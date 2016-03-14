package graphics;

/**
 *
 * @author gerald
 */
public class StartGame
{
    
    public static void main(String args[])
    {
        Board board = new Board();
        
        /* Creating Board */
        board.createSquares();
        
        /* Adding Pieces */
        for(int i = 0; i < 8; i++)
        {
            board.addPiece(new logic.Pawn("/home/gerald/Desktop/Bknight.png", "white"), 1, i);
            board.addPiece(new logic.Pawn("/home/gerald/Desktop/Bknight.png", "black"), 6, i);
        }
        
        board.addPiece(new logic.Knight("/home/gerald/Desktop/Bknight.png", "white"), 0, 7);
        board.addPiece(new logic.Knight("/home/gerald/Desktop/Bknight.png", "white"), 7, 7);
        board.addPiece(new logic.Knight("/home/gerald/Desktop/Bknight.png", "white"), 0, 0);
        board.addPiece(new logic.Knight("/home/gerald/Desktop/Bknight.png", "white"), 7, 0);
        
        board.addPiece(new logic.Knight("/home/gerald/Desktop/Bknight.png", "black"), 0, 6);
        board.addPiece(new logic.Knight("/home/gerald/Desktop/Bknight.png", "black"), 7, 6);
        board.addPiece(new logic.Knight("/home/gerald/Desktop/Bknight.png", "black"), 0, 1);
        board.addPiece(new logic.Knight("/home/gerald/Desktop/Bknight.png", "black"), 7, 1);

        board.addPiece(new logic.Bishop("Rbishop.gif", "white"), 0, 5);
        board.addPiece(new logic.Bishop("Bbishop.gif", "black"), 7, 5);
        board.addPiece(new logic.Bishop("Rbishop.gif", "white"), 0, 2);
        board.addPiece(new logic.Bishop("Bbishop.gif", "black"), 7, 2);

        board.addPiece(new logic.Queen("Rqueen.gif", "white"), 0, 4);
        board.addPiece(new logic.Queen("Bqueen.gif", "black"), 7, 4);

        board.addPiece(new logic.King("Rking.gif", "white"), 0, 3);
        board.addPiece(new logic.King("Rking.gif", "black"), 7, 3);
        
        board.setVisible(true);
        //board.removePiece(7, 3);
        
    }
    
}