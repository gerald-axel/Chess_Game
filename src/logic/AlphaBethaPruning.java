package logic;

import pieces.Piece;

public class AlphaBethaPruning {
	NodeAlphaBetha root;
	public AlphaBethaPruning(Piece[][] rootmap) {
		root = new NodeAlphaBetha(rootmap);
		prune(root,-100000,100000,5,true);
	}
	public int prune(NodeAlphaBetha node, int alpha, int betha,int prof, boolean max){
		if(node.nodes.isEmpty() || prof==0){
			node.calculateValue();
			return node.getValue();
		}else{
			if(max){
				for (NodeAlphaBetha sonNode : node.nodes) {
					
					int aux = prune(sonNode,alpha,betha,prof-1,false);
					if(aux>alpha){
						aux=alpha;
					}
					if(alpha>=betha){
						return betha;
					}
					
				}
				return alpha;
			}
			else{
				for (NodeAlphaBetha sonNode : node.nodes) {
					
					int aux = prune(sonNode,alpha,betha,prof-1,true);
					if(aux<alpha){
						aux=alpha;
					}
					if(alpha>=betha){
						return alpha;
					}
					
				}
				return betha;
			}
		}
	}
}
