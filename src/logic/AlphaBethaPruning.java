package logic;

import java.util.ArrayList;
import java.util.Random;

import pieces.Piece;

public class AlphaBethaPruning {
	NodeAlphaBetha root;
	public AlphaBethaPruning(Piece[][] rootmap) {
		root = new NodeAlphaBetha(rootmap);
	}
	public Piece[][] YourTurn(String player){
		NodeAlphaBetha BestMove;
		if(player.equals("black")){
			BestMove = prune(root,-100000,100000,5,true);
			root = null;
			return BestMove.getMap();
		}
		else{
			BestMove = prune(root,-100000,100000,5,false);
			root = null;
			return BestMove.getMap();
		}
	}
	public NodeAlphaBetha prune(NodeAlphaBetha node, int alpha, int betha,int prof, boolean max){
		NodeAlphaBetha aux = new NodeAlphaBetha();
		ArrayList<NodeAlphaBetha> listMovs = findFuture(node, max);
		if(listMovs.isEmpty() || prof==0){
			node.calculateValue();
			return node;
		}else{
			if(max){
				for (NodeAlphaBetha sonNode : listMovs) {
					aux = prune(sonNode,alpha,betha,prof-1,false);
					node.nodes.add(sonNode);
					if(aux.getValue()>alpha){
						alpha = aux.getValue();
					}
					if(alpha>=betha){
						aux.setValue(betha);
						aux.setMap(sonNode.getMap());
						return aux;
					}	
				}
				Random ran = new Random();
				int x = ran.nextInt(node.nodes.size());
				//int x = (int) Math.random()*node.nodes.size();
				aux.setMap(node.nodes.get(x).getMap());
				aux.setValue(alpha);
				return aux;
			}
			else{
				for (NodeAlphaBetha sonNode : listMovs) {
					aux = prune(sonNode,alpha,betha,prof-1,true);
					node.nodes.add(sonNode);
					if(aux.getValue()<betha){
						betha = aux.getValue();
					}
					if(alpha>=betha){
						aux.setMap(sonNode.getMap());
						aux.setValue(alpha);
						return aux;
					}
					
				}
				Random ran = new Random();
				int x = ran.nextInt(node.nodes.size());
				//int x = (int) Math.random()*node.nodes.size();
				aux.setMap(node.nodes.get(x).getMap());
				aux.setValue(betha);
				return aux;
			}
		}
	}
	
	public ArrayList<NodeAlphaBetha> findFuture(NodeAlphaBetha node, boolean max){
		Piece[][] map = node.getMap();
		ArrayList<NodeAlphaBetha> listedMovs  = new ArrayList<NodeAlphaBetha>();
		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8; y++){
				if(map[x][y]!=null){
					if(map[x][y].getTeam().equals("black")&& max){
						PossibleMoves.possibleMoves.clear();
						PossibleMoves.reviewPiece(map[x][y]);
						for (javax.swing.JPanel piece : PossibleMoves.possibleMoves) {
							Piece[][] aux = new Piece[8][8];
							for(int i = 0; i < 8; i++){
								for(int j = 0; j < 8; j++){
									if(map[i][j]!=null){
										try {
											aux[i][j] = (Piece) map[i][j].clone();
										} catch (CloneNotSupportedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								}
							}
							String []coord = piece.getName().split(",");
							int newCoordenateX = Integer.parseInt(coord[0]);
							int newCoordenateY = Integer.parseInt(coord[1]);
							aux[newCoordenateX][newCoordenateY] = aux[x][y];
							aux[x][y]=null;
							listedMovs.add(new NodeAlphaBetha(aux));
						}
					}
					if(map[x][y].getTeam().equals("white")&& !max){
						PossibleMoves.possibleMoves.clear();
						PossibleMoves.reviewPiece(map[x][y]);
						for (javax.swing.JPanel piece : PossibleMoves.possibleMoves) {
							Piece[][] aux = new Piece[8][8];
							for(int i = 0; i < 8; i++){
								for(int j = 0; j < 8; j++){
									if(map[i][j]!=null){
										try {
											aux[i][j] = (Piece) map[i][j].clone();
										} catch (CloneNotSupportedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								}
							}
							String []coord = piece.getName().split(",");
							int newCoordenateX = Integer.parseInt(coord[0]);
							int newCoordenateY = Integer.parseInt(coord[1]);
							aux[newCoordenateX][newCoordenateY] = aux[x][y];
							aux[x][y]=null;
							listedMovs.add(new NodeAlphaBetha(aux));
						}
					}
				}
				
			}
		}
		return listedMovs;
	}
}
