package logic;

import java.util.ArrayList;

import pieces.Piece;

public class NodeAlphaBetha {
	private Piece[][] map = new Piece[8][8];
	private int value = 0;
	private NodeAlphaBetha reference = null;
	private boolean maxmin = true;
	public ArrayList<NodeAlphaBetha> nodes = new ArrayList<NodeAlphaBetha>();
	
	public NodeAlphaBetha(Piece[][] map) {
		this.map = map;	
	}
	
	public Piece[][] getMap() {
		return map;
	}
	public void setMap(Piece[][] map) {
		this.map = map;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public NodeAlphaBetha getReference() {
		return reference;
	}
	public void setReference(NodeAlphaBetha reference) {
		this.reference = reference;
	}
	
	public int calculateValue(){
		value = 0;
		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8; y++){
				if(map[x][y]!=null){
					switch(map[x][y].getType()){
					case "Pawn":
			            value += map[x][y].getTeam().equals("white") ? -1 : 1;
			            break;
			        
			        case "Knight":
			        	value += map[x][y].getTeam().equals("white") ? -3 : 3;
			            break;
			            
			        case "King":
			        	value += map[x][y].getTeam().equals("white") ? -10000 : 10000;
			            break;
			            
			        case "Bishop":
			        	value += map[x][y].getTeam().equals("white") ? -3 : 3;
			            break;
			            
			        case "Rook":
			        	value += map[x][y].getTeam().equals("white") ? -5 : 5;
			            break;
			            
			        case "Queen":
			        	value += map[x][y].getTeam().equals("white") ? -9 : 9;
			            break;
					}
				}
			}
		}
		
		return value;
	}
	
}

