package graphics;

/**
 *
 * @author gerald
 */
public class StartGame
{
    public static Board board = new Board();
    
    public static void main(String args[])
    {        
        /* Creating Board */
        board.createSquares();
        
        /* Adding Pieces */
        for(int i = 0; i < 8; i++)
        {
            board.addPiece(new pieces.Pawn("src/pieces_images/Bpawn.png", "black", new int[]{1, i}), 1, i);
            board.addPiece(new pieces.Pawn("src/pieces_images/Wpawn.png", "white", new int[]{6, i}), 6, i);
        }
        
        board.addPiece(new pieces.Rook("src/pieces_images/Brook.png", "black", new int[]{0, 7}), 0, 7);
        board.addPiece(new pieces.Rook("src/pieces_images/Wrook.png", "white", new int[]{7, 7}), 7, 7);
        board.addPiece(new pieces.Rook("src/pieces_images/Brook.png", "black", new int[]{0, 0}), 0, 0);
        board.addPiece(new pieces.Rook("src/pieces_images/Wrook.png", "white", new int[]{7, 0}), 7, 0);
        
        board.addPiece(new pieces.Knight("src/pieces_images/Bknight.png", "black", new int[]{0, 6}), 0, 6);
        board.addPiece(new pieces.Knight("src/pieces_images/Wknight.png", "white", new int[]{7, 6}), 7, 6);
        board.addPiece(new pieces.Knight("src/pieces_images/Bknight.png", "black", new int[]{0, 1}), 0, 1);
        board.addPiece(new pieces.Knight("src/pieces_images/Wknight.png", "white", new int[]{7, 1}), 7, 1);

        board.addPiece(new pieces.Bishop("src/pieces_images/Bbishop.png", "black", new int[]{0, 5}), 0, 5);
        board.addPiece(new pieces.Bishop("src/pieces_images/Wbishop.png", "white", new int[]{7, 5}), 7, 5);
        board.addPiece(new pieces.Bishop("src/pieces_images/Bbishop.png", "black", new int[]{0, 2}), 0, 2);
        board.addPiece(new pieces.Bishop("src/pieces_images/Wbishop.png", "white", new int[]{7, 2}), 7, 2);

        board.addPiece(new pieces.Queen("src/pieces_images/Bqueen.png", "black", new int[]{0, 4}), 0, 4);
        board.addPiece(new pieces.Queen("src/pieces_images/Wqueen.png", "white", new int[]{7, 4}), 7, 4);

        board.addPiece(new pieces.King("src/pieces_images/Bking.png", "black", new int[]{0, 3}), 0, 3);
        board.addPiece(new pieces.King("src/pieces_images/Wking.png", "white", new int[]{7, 3}), 7, 3);
        
        board.setVisible(true);
        
    }
    
}