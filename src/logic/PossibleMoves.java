package logic;

import graphics.Board;
import pieces.Piece;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author gerald
 */
public class PossibleMoves 
{
    public static ArrayList<JPanel> possibleMoves = new ArrayList<JPanel>();
    
    public PossibleMoves(){
    }
    
    public static void reviewPiece(Piece piece){
    	String pieceType = piece.getType();
    	int []coordenates = piece.getCoordenates();
        int x = coordenates[0];
        int y = coordenates[1];

        switch(pieceType){
            case "Pawn":
                pawnMoves(x, y, piece);
                break;
            
            case "Knight":
                knightMoves(x, y, piece);
                break;
                
            case "King":
                kingMoves(x, y, piece);
                break;
                
            case "Bishop":
                bishopMoves(x, y, piece);
                break;
                
            case "Rook":
                rookMoves(x, y, piece);
                break;
                
            case "Queen":
                queenMoves(x, y, piece);
                break;
        }
    }
    
    public static ArrayList pawnMoves(int x, int y, Piece piece){
    	int numberOfIterations = piece.getMovesCounter() == 0 ? 2 : 1;
        int direction = piece.getTeam().equals("white") ? -1 : 1;

        if(reviewBoardLimits(x + direction, y)){
	        for (int i = 0, aux = direction; i < numberOfIterations; i++, aux += aux) {
	            int squarePiece = Board.squares[x + aux][y].getAccessibleContext().getAccessibleChildrenCount();
	            
	            if(squarePiece == 0){
	            	possibleMoves.add(Board.squares[x + aux][y]);
	            	Board.setBorders(x + aux, y);
	            }  
			}
        }
        
        if(reviewBoardLimits(x + direction, y -1)){
            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + direction][y - 1].getAccessibleContext().getAccessibleChild(0);
            if(squarePiece != null && !piece.getTeam().equals(squarePiece.getTeam())){
            	possibleMoves.add(Board.squares[x + direction][y - 1]);
            	Board.setBorders(x + direction, y - 1);
            }  	
        }

        if(reviewBoardLimits(x + direction, y + 1)){
            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + direction][y + 1].getAccessibleContext().getAccessibleChild(0);
	        if(squarePiece != null && !piece.getTeam().equals(squarePiece.getTeam())){
	        	possibleMoves.add(Board.squares[x + direction][y + 1]);
	        	Board.setBorders(x + direction, y + 1);
	        }
        }
        
        return possibleMoves;
    }
    
    public static ArrayList kingMoves(int x, int y, Piece piece){

        for (int i = 0, directionX = 1; i < 3; i++, directionX += -1) {
        	
        	for (int j = 0, directionY = 1; j < 3; j++, directionY += -1) {
        		
                if(reviewBoardLimits(x + directionX, y + directionY)){
	                pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + directionX][y + directionY].getAccessibleContext().getAccessibleChild(0);
	                
	                if(squarePiece == null){
	                	possibleMoves.add(Board.squares[x + directionX][y + directionY]);
	                	Board.setBorders(x + directionX, y + directionY);		                	
	                } else{
	                	if(piece.getTeam() != squarePiece.getTeam()){
		                	possibleMoves.add(Board.squares[x + directionX][y + directionY]);
		                	Board.setBorders(x + directionX, y + directionY);	                	
		               }
	                }
                }
            }

		}
        return possibleMoves;
    }

    public static ArrayList bishopMoves(int x, int y, Piece piece){
    	
		for (int j = 1; j <= 8; j++) {
			
			if(reviewBoardLimits(x + j, y + j)){
	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + j][y + j].getAccessibleContext().getAccessibleChild(0);
	            
	            if(squarePiece == null){
	            	possibleMoves.add(Board.squares[x + j][y + j]);
	            	Board.setBorders(x + j, y + j);            
	            } else {
	            	if(piece.getTeam() != squarePiece.getTeam()){
	                	possibleMoves.add(Board.squares[x + j][y + j]);
	                	Board.setBorders(x + j, y + j);
	                	break;
	               } else{
	            	   break;
	               }
	           }
			}
		}
		
		for (int j = 1; j <= 8; j++) {
			
			if(reviewBoardLimits(x - j, y - j)){

	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x - j][y - j].getAccessibleContext().getAccessibleChild(0);
	            
	            if(squarePiece == null){
	            	possibleMoves.add(Board.squares[x - j][y - j]);
	            	Board.setBorders(x - j, y - j);            
	            } else {
	            	if(piece.getTeam() != squarePiece.getTeam()){
	                	possibleMoves.add(Board.squares[x - j][y - j]);
	                	Board.setBorders(x - j, y - j);
	                	break;
	               } else{
	            	   break;
	               }
	           }
			}
		}
		
		for (int j = 1; j <= 8; j++) {
			
			if(reviewBoardLimits(x + j, y - j)){

	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + j][y - j].getAccessibleContext().getAccessibleChild(0);
	            
	            if(squarePiece == null){
	            	possibleMoves.add(Board.squares[x + j][y - j]);
	            	Board.setBorders(x + j, y - j);            
	            } else {
	            	if(piece.getTeam() != squarePiece.getTeam()){
	                	possibleMoves.add(Board.squares[x + j][y - j]);
	                	Board.setBorders(x + j, y - j);
	                	break;
	               } else{
	            	   break;
	               }
	           }
			}
		}     	
		
		for (int j = 1; j <= 8; j++) {
			
			if(reviewBoardLimits(x - j, y + j)){

	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x - j][y + j].getAccessibleContext().getAccessibleChild(0);
	            
	            if(squarePiece == null){
	            	possibleMoves.add(Board.squares[x - j][y + j]);
	            	Board.setBorders(x - j, y + j);            
	            } else {
	            	if(piece.getTeam() != squarePiece.getTeam()){
	                	possibleMoves.add(Board.squares[x - j][y + j]);
	                	Board.setBorders(x - j, y + j);
	                	break;
	               } else{
	            	   break;
	               }
	           }
			}
		}         
		
        return possibleMoves;
    }

    public static ArrayList rookMoves(int x, int y, Piece piece){

		for (int j = 1; j <= 8; j++) {
			
			if(reviewBoardLimits(x + j, y)){
	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + j][y].getAccessibleContext().getAccessibleChild(0);
	            
	            if(squarePiece == null){
	            	possibleMoves.add(Board.squares[x + j][y]);
	            	Board.setBorders(x + j, y);            
	            } else {
	            	if(piece.getTeam() != squarePiece.getTeam()){
	                	possibleMoves.add(Board.squares[x + j][y]);
	                	Board.setBorders(x + j, y);
	                	break;
	               } else{
	            	   break;
	               }
	           }
			}
		}
		
		for (int j = 1; j <= 8; j++) {
			
			if(reviewBoardLimits(x - j, y)){
	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x - j][y].getAccessibleContext().getAccessibleChild(0);
	            
	            if(squarePiece == null){
	            	possibleMoves.add(Board.squares[x - j][y]);
	            	Board.setBorders(x - j, y);            
	            } else {
	            	if(piece.getTeam() != squarePiece.getTeam()){
	                	possibleMoves.add(Board.squares[x - j][y]);
	                	Board.setBorders(x - j, y);
	                	break;
	               } else{
	            	   break;
	               }
	           }
			}
		}
		
		for (int j = 1; j <= 8; j++) {
			
			if(reviewBoardLimits(x, y + j)){
	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x][y + j].getAccessibleContext().getAccessibleChild(0);
	            
	            if(squarePiece == null){
	            	possibleMoves.add(Board.squares[x][y + j]);
	            	Board.setBorders(x, y + j);            
	            } else {
	            	if(piece.getTeam() != squarePiece.getTeam()){
	                	possibleMoves.add(Board.squares[x][y + j]);
	                	Board.setBorders(x, y + j);
	                	break;
	               } else{
	            	   break;
	               }
	           }
			}
		}     	
		
		for (int j = 1; j <= 8; j++) {
			
			if(reviewBoardLimits(x, y - j)){
	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x][y - j].getAccessibleContext().getAccessibleChild(0);
	            
	            if(squarePiece == null){
	            	possibleMoves.add(Board.squares[x][y - j]);
	            	Board.setBorders(x, y - j);            
	            } else {
	            	if(piece.getTeam() != squarePiece.getTeam()){
	                	possibleMoves.add(Board.squares[x][y - j]);
	                	Board.setBorders(x, y - j);
	                	break;
	               } else{
	            	   break;
	               }
	           }
			}
		}         
		
		return possibleMoves;
    }

    public static ArrayList queenMoves(int x, int y, Piece piece){
     	
    		for (int j = 1; j <= 8; j++) {
    			
    			if(reviewBoardLimits(x + j, y + j)){
    	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + j][y + j].getAccessibleContext().getAccessibleChild(0);
    	            
    	            if(squarePiece == null){
    	            	possibleMoves.add(Board.squares[x + j][y + j]);
    	            	Board.setBorders(x + j, y + j);            
    	            } else {
    	            	if(piece.getTeam() != squarePiece.getTeam()){
    	                	possibleMoves.add(Board.squares[x + j][y + j]);
    	                	Board.setBorders(x + j, y + j);
    	                	break;
    	               } else{
    	            	   break;
    	               }
    	           }
    			}
    		}
    		
    		for (int j = 1; j <= 8; j++) {
    			
    			if(reviewBoardLimits(x - j, y - j)){

    	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x - j][y - j].getAccessibleContext().getAccessibleChild(0);
    	            
    	            if(squarePiece == null){
    	            	possibleMoves.add(Board.squares[x - j][y - j]);
    	            	Board.setBorders(x - j, y - j);            
    	            } else {
    	            	if(piece.getTeam() != squarePiece.getTeam()){
    	                	possibleMoves.add(Board.squares[x - j][y - j]);
    	                	Board.setBorders(x - j, y - j);
    	                	break;
    	               } else{
    	            	   break;
    	               }
    	           }
    			}
    		}
    		
    		for (int j = 1; j <= 8; j++) {
    			
    			if(reviewBoardLimits(x + j, y - j)){

    	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + j][y - j].getAccessibleContext().getAccessibleChild(0);
    	            
    	            if(squarePiece == null){
    	            	possibleMoves.add(Board.squares[x + j][y - j]);
    	            	Board.setBorders(x + j, y - j);            
    	            } else {
    	            	if(piece.getTeam() != squarePiece.getTeam()){
    	                	possibleMoves.add(Board.squares[x + j][y - j]);
    	                	Board.setBorders(x + j, y - j);
    	                	break;
    	               } else{
    	            	   break;
    	               }
    	           }
    			}
    		}     	
    		
    		for (int j = 1; j <= 8; j++) {
    			
    			if(reviewBoardLimits(x - j, y + j)){

    	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x - j][y + j].getAccessibleContext().getAccessibleChild(0);
    	            
    	            if(squarePiece == null){
    	            	possibleMoves.add(Board.squares[x - j][y + j]);
    	            	Board.setBorders(x - j, y + j);            
    	            } else {
    	            	if(piece.getTeam() != squarePiece.getTeam()){
    	                	possibleMoves.add(Board.squares[x - j][y + j]);
    	                	Board.setBorders(x - j, y + j);
    	                	break;
    	               } else{
    	            	   break;
    	               }
    	           }
    			}
    		}
    		

    		for (int j = 1; j <= 8; j++) {
    			
    			if(reviewBoardLimits(x + j, y)){
    	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + j][y].getAccessibleContext().getAccessibleChild(0);
    	            
    	            if(squarePiece == null){
    	            	possibleMoves.add(Board.squares[x + j][y]);
    	            	Board.setBorders(x + j, y);            
    	            } else {
    	            	if(piece.getTeam() != squarePiece.getTeam()){
    	                	possibleMoves.add(Board.squares[x + j][y]);
    	                	Board.setBorders(x + j, y);
    	                	break;
    	               } else{
    	            	   break;
    	               }
    	           }
    			}
    		}
    		
    		for (int j = 1; j <= 8; j++) {
    			
    			if(reviewBoardLimits(x - j, y)){
    	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x - j][y].getAccessibleContext().getAccessibleChild(0);
    	            
    	            if(squarePiece == null){
    	            	possibleMoves.add(Board.squares[x - j][y]);
    	            	Board.setBorders(x - j, y);            
    	            } else {
    	            	if(piece.getTeam() != squarePiece.getTeam()){
    	                	possibleMoves.add(Board.squares[x - j][y]);
    	                	Board.setBorders(x - j, y);
    	                	break;
    	               } else{
    	            	   break;
    	               }
    	           }
    			}
    		}
    		
    		for (int j = 1; j <= 8; j++) {
    			
    			if(reviewBoardLimits(x, y + j)){
    	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x][y + j].getAccessibleContext().getAccessibleChild(0);
    	            
    	            if(squarePiece == null){
    	            	possibleMoves.add(Board.squares[x][y + j]);
    	            	Board.setBorders(x, y + j);            
    	            } else {
    	            	if(piece.getTeam() != squarePiece.getTeam()){
    	                	possibleMoves.add(Board.squares[x][y + j]);
    	                	Board.setBorders(x, y + j);
    	                	break;
    	               } else{
    	            	   break;
    	               }
    	           }
    			}
    		}     	
    		
    		for (int j = 1; j <= 8; j++) {
    			
    			if(reviewBoardLimits(x, y - j)){
    	            pieces.Piece squarePiece = (pieces.Piece) Board.squares[x][y - j].getAccessibleContext().getAccessibleChild(0);
    	            
    	            if(squarePiece == null){
    	            	possibleMoves.add(Board.squares[x][y - j]);
    	            	Board.setBorders(x, y - j);            
    	            } else {
    	            	if(piece.getTeam() != squarePiece.getTeam()){
    	                	possibleMoves.add(Board.squares[x][y - j]);
    	                	Board.setBorders(x, y - j);
    	                	break;
    	               } else{
    	            	   break;
    	               }
    	           }
    			}
    		}         
    		        
    		return possibleMoves;
    }
    
    public static ArrayList knightMoves(int x, int y, Piece piece){
    	
		if(reviewBoardLimits(x - 2, y - 1)){
			pieces.Piece squarePiece = (pieces.Piece) Board.squares[x - 2][y - 1].getAccessibleContext().getAccessibleChild(0);
            if(squarePiece == null ){
	        	possibleMoves.add(Board.squares[x - 2][y -1]);
	        	Board.setBorders(x - 2, y - 1);
            } else {
            	if(piece.getTeam() != squarePiece.getTeam()){
    	        	possibleMoves.add(Board.squares[x - 2][y - 1]);
    	        	Board.setBorders(x - 2, y - 1);
               }            
            }
		}

		if(reviewBoardLimits(x - 2, y + 1)){
			pieces.Piece squarePiece = (pieces.Piece) Board.squares[x - 2][y + 1].getAccessibleContext().getAccessibleChild(0);
            if(squarePiece == null ){
	        	possibleMoves.add(Board.squares[x - 2][y + 1]);
	        	Board.setBorders(x - 2, y + 1);
            } else {
            	if(piece.getTeam() != squarePiece.getTeam()){
    	        	possibleMoves.add(Board.squares[x - 2][y + 1]);
    	        	Board.setBorders(x - 2, y + 1);
               }            
            }
		}
		
		if(reviewBoardLimits(x - 1, y - 2)){
			pieces.Piece squarePiece = (pieces.Piece) Board.squares[x - 1][y - 2].getAccessibleContext().getAccessibleChild(0);
            if(squarePiece == null ){
	        	possibleMoves.add(Board.squares[x - 1][y - 2]);
	        	Board.setBorders(x - 1, y - 2);
            } else {
            	if(piece.getTeam() != squarePiece.getTeam()){
    	        	possibleMoves.add(Board.squares[x - 1][y - 2]);
    	        	Board.setBorders(x - 1, y - 2);
               }            
            }
		}
		
		if(reviewBoardLimits(x - 1, y + 2)){
			pieces.Piece squarePiece = (pieces.Piece) Board.squares[x - 1][y + 2].getAccessibleContext().getAccessibleChild(0);
            if(squarePiece == null ){
	        	possibleMoves.add(Board.squares[x - 1][y + 2]);
	        	Board.setBorders(x - 1, y + 2);
            } else {
            	if(piece.getTeam() != squarePiece.getTeam()){
    	        	possibleMoves.add(Board.squares[x - 1][y + 2]);
    	        	Board.setBorders(x - 1, y + 2);
               }            
            }
		}        
		
		if(reviewBoardLimits(x + 2, y + 1)){
			pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + 2][y + 1].getAccessibleContext().getAccessibleChild(0);
            if(squarePiece == null ){
	        	possibleMoves.add(Board.squares[x + 2][y + 1]);
	        	Board.setBorders(x + 2, y + 1);
            } else {
            	if(piece.getTeam() != squarePiece.getTeam()){
    	        	possibleMoves.add(Board.squares[x + 2][y + 1]);
    	        	Board.setBorders(x + 2, y + 1);
               }            
            }
		}
		
		if(reviewBoardLimits(x + 2, y - 1)){
			pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + 2][y - 1].getAccessibleContext().getAccessibleChild(0);
            if(squarePiece == null ){
	        	possibleMoves.add(Board.squares[x + 2][y - 1]);
	        	Board.setBorders(x + 2, y - 1);
            } else {
            	if(piece.getTeam() != squarePiece.getTeam()){
    	        	possibleMoves.add(Board.squares[x + 2][y - 1]);
    	        	Board.setBorders(x + 2, y - 1);
               }            
            }
		}
		
		if(reviewBoardLimits(x + 1, y - 2)){
			pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + 1][y - 2].getAccessibleContext().getAccessibleChild(0);
            if(squarePiece == null ){
	        	possibleMoves.add(Board.squares[x + 1][y - 2]);
	        	Board.setBorders(x + 1, y - 2);
            } else {
            	if(piece.getTeam() != squarePiece.getTeam()){
    	        	possibleMoves.add(Board.squares[x + 1][y - 2]);
    	        	Board.setBorders(x + 1, y - 2);
               }            
            }
		}
		
		if(reviewBoardLimits(x + 1, y + 2)){
			pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + 1][y + 2].getAccessibleContext().getAccessibleChild(0);
            if(squarePiece == null ){
	        	possibleMoves.add(Board.squares[x + 1][y + 2]);
	        	Board.setBorders(x + 1, y + 2);
            } else {
            	if(piece.getTeam() != squarePiece.getTeam()){
    	        	possibleMoves.add(Board.squares[x + 1][y + 2]);
    	        	Board.setBorders(x + 1, y + 2);
               }            
            }
		}    
		return possibleMoves;
    }
    
    public static boolean reviewBoardLimits(int x, int y){
    	return (x < 8 && y < 8)  && (x  >= 0 && y >= 0) ? true : false;
    }
}
