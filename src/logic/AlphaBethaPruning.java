package logic;

import java.util.ArrayList;

import pieces.Piece;

public class AlphaBethaPruning {
	NodeAlphaBetha root;
	public AlphaBethaPruning(Piece[][] rootmap) {
		root = new NodeAlphaBetha(rootmap);
	}
	public NodeAlphaBetha YourTurn(String player){
		if(player.equals("black")){
			return prune(root,-100000,100000,5,true);
		}
		else{
			return prune(root,-100000,100000,5,false);
		}
	}
	public NodeAlphaBetha prune(NodeAlphaBetha node, int alpha, int betha,int prof, boolean max){
		NodeAlphaBetha aux = new NodeAlphaBetha();
		node = findFuture(node);
		if(node.nodes.isEmpty() || prof==0){
			node.calculateValue();
			return node;
		}else{
			if(max){
				for (NodeAlphaBetha sonNode : node.nodes) {
					aux = prune(sonNode,alpha,betha,prof-1,false);
					if(aux.getValue()>alpha){
						alpha = aux.getValue();
					}
					if(alpha>=betha){
						aux.setValue(betha);
						aux.setMap(sonNode.getMap());
						return aux;
					}	
				}
				aux.setMap(node.getMap());
				aux.setValue(alpha);
				return aux;
			}
			else{
				for (NodeAlphaBetha sonNode : node.nodes) {
					
					aux = prune(sonNode,alpha,betha,prof-1,true);
					if(aux.getValue()<betha){
						betha = aux.getValue();
					}
					if(alpha>=betha){
						aux.setMap(sonNode.getMap());
						aux.setValue(alpha);
						return aux;
					}
					
				}
				aux.setMap(node.getMap());
				aux.setValue(betha);
				return aux;
			}
		}
	}
	
	public NodeAlphaBetha findFuture(NodeAlphaBetha node){
		Piece[][] map = node.getMap();
		
		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8; y++){
				if(map[x][y]!=null){
					
					PossibleMoves.reviewPiece(map[x][y]);
					for (javax.swing.JPanel piece : PossibleMoves.possibleMoves) {
						Piece[][] aux = map.clone();
						String []coord = piece.getName().split(",");
						int newCoordenateX = Integer.parseInt(coord[0]);
						int newCoordenateY = Integer.parseInt(coord[1]);
						aux[newCoordenateX][newCoordenateY] = aux[x][y];
						aux[x][y]=null;
						node.nodes.add(new NodeAlphaBetha(aux));
					}
				}
				
			}
		}
		return node;
	}
}
