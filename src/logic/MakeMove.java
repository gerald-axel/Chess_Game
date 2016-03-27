package logic;

import graphics.Board;
import pieces.Piece;

public class MakeMove
{
	public static pieces.Piece [][]matrixPieces; 
	public static pieces.Piece [][]newBoardMachine;
	
	public MakeMove(){}
	
	public static void movePiece(Piece piece, String coordenatesToMove)
	{
		String []coord = coordenatesToMove.split(",");
		int newCoordenateX = Integer.parseInt(coord[0]);
		int newCoordenateY = Integer.parseInt(coord[1]);
						
		int oldPieceCoordenates[] = piece.getCoordenates();
		
		reviewIfIsEating(newCoordenateX, newCoordenateY);
		generateNewPiece(newCoordenateX, newCoordenateY, piece);
		graphics.StartGame.board.removePiece(oldPieceCoordenates[0], oldPieceCoordenates[1]);
		changeTurn();
		
		if(!Board.isHumanTurn)
		{
			makeArrayForTree();
			AlphaBethaPruning prune = new AlphaBethaPruning(matrixPieces);
			newBoardMachine = prune.YourTurn("black");
			removeAllPieces();
			newBoard();
		}
		
	}
	
	public static void generateNewPiece(int newCoordenateX, int newCoordenateY, Piece piece)
	{
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
	
	public static void reviewIfIsEating(int x, int y)
	{
        int squarePiece = Board.squares[x][y].getAccessibleContext().getAccessibleChildrenCount();
        if(squarePiece != 0){
    		graphics.StartGame.board.removePiece(x, y);
        }
	}
	
	public static void changeTurn()
	{
		Board.isHumanTurn = Board.isHumanTurn ? false : true;
	}
	
	public static void makeArrayForTree()
	{
		matrixPieces = new pieces.Piece[8][8];
		
		for (int i = 0; i < 8; i++) 
		{
			for (int j = 0; j < 8; j++) 
			{
				matrixPieces[i][j] = (pieces.Piece) Board.squares[i][j].getAccessibleContext().getAccessibleChild(0);
			}
		}
	}
	
	public static void removeAllPieces()
	{
		for (int i = 0; i < 8; i++) 
		{
			for (int j = 0; j < 8; j++) 
			{
		    	int squareHasPiece = Board.squares[i][j].getAccessibleContext().getAccessibleChildrenCount();
		    	
		    	if(squareHasPiece != 0){
					graphics.StartGame.board.removePiece(i, j);
		    	}
			}
		}
	}

	public static void newBoard()
	{
		pieces.Piece piece;
		int []coordenates;
		
		for (int i = 0; i < 8; i++) 
		{
			for (int j = 0; j < 8; j++) 
			{
				if(newBoardMachine[i][j] != null){
					System.out.println(i + "," + j);
					generateNewPiece(i, j, newBoardMachine[i][j]);
				}
			}
		}
	}
}
