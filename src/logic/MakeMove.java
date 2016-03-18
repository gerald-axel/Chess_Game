package logic;

import graphics.Board;
import pieces.Pawn;
import pieces.Piece;

public class MakeMove
{
	
	public MakeMove(){
		
	}
	
	public static void movePiece(Piece piece, String coordenatesToMove){
		String []coord = coordenatesToMove.split(",");
		int newCoordenateX = Integer.parseInt(coord[0]);
		int newCoordenateY = Integer.parseInt(coord[1]);
						
		int oldPieceCoordenates[] = piece.getCoordenates();
		
		reviewIfIsEating(newCoordenateX, newCoordenateY);
		generateNewPiece(newCoordenateX, newCoordenateY, piece);
		graphics.StartGame.board.removePiece(oldPieceCoordenates[0], oldPieceCoordenates[1]);
	}
	
	public static void generateNewPiece(int newCoordenateX, int newCoordenateY, Piece piece){
		String colorImage = piece.getTeam().equals("white") ? "W" : "B";
		
        switch(piece.getType()){
	        case "Pawn":
	            graphics.StartGame.board.addPiece(new pieces.Pawn("src/pieces_images/" + colorImage + "pawn.png", piece.getTeam(), new int[]{newCoordenateX, newCoordenateY}), newCoordenateX, newCoordenateY);
	            break;
	        
	        case "Knight":
	            graphics.StartGame.board.addPiece(new pieces.Knight("src/pieces_images/" + colorImage + "knight.png", piece.getTeam(), new int[]{newCoordenateX, newCoordenateY}), newCoordenateX, newCoordenateY);
	            break;
	            
	        case "King":
	            graphics.StartGame.board.addPiece(new pieces.King("src/pieces_images/" + colorImage + "king.png", piece.getTeam(), new int[]{newCoordenateX, newCoordenateY}), newCoordenateX, newCoordenateY);
	            break;
	            
	        case "Bishop":
	            graphics.StartGame.board.addPiece(new pieces.Bishop("src/pieces_images/" + colorImage + "bishop.png", piece.getTeam(), new int[]{newCoordenateX, newCoordenateY}), newCoordenateX, newCoordenateY);
	            break;
	            
	        case "Rook":
	            graphics.StartGame.board.addPiece(new pieces.Rook("src/pieces_images/" + colorImage + "rook.png", piece.getTeam(), new int[]{newCoordenateX, newCoordenateY}), newCoordenateX, newCoordenateY);
	            break;
	            
	        case "Queen":
	            graphics.StartGame.board.addPiece(new pieces.Queen("src/pieces_images/" + colorImage + "queen.png", piece.getTeam(), new int[]{newCoordenateX, newCoordenateY}), newCoordenateX, newCoordenateY);
	            break;
        }
        
        ((Piece) Board.squares[newCoordenateX][newCoordenateY].getAccessibleContext().getAccessibleChild(0)).setMovesCounter();
	}
	
	public static void reviewIfIsEating(int x, int y){
        int squarePiece = Board.squares[x][y].getAccessibleContext().getAccessibleChildrenCount();
        if(squarePiece != 0){
    		graphics.StartGame.board.removePiece(x, y);
        }
	}

}
