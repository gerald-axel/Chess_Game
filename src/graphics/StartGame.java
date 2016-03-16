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
            board.addPiece(new logic.Pawn("src/piezas/Bpawn.png", "black"), 1, i);
            board.addPiece(new logic.Pawn("src/piezas/Wpawn.png", "white"), 6, i);
        }
        
        board.addPiece(new logic.Tower("src/piezas/Btower.png", "black"), 0, 7);
        board.addPiece(new logic.Tower("src/piezas/Wtower.png", "white"), 7, 7);
        board.addPiece(new logic.Tower("src/piezas/Btower.png", "black"), 0, 0);
        board.addPiece(new logic.Tower("src/piezas/Wtower.png", "white"), 7, 0);
        
        board.addPiece(new logic.Knight("src/piezas/Bknight.png", "black"), 0, 6);
        board.addPiece(new logic.Knight("src/piezas/Wknight.png", "white"), 7, 6);
        board.addPiece(new logic.Knight("src/piezas/Bknight.png", "black"), 0, 1);
        board.addPiece(new logic.Knight("src/piezas/Wknight.png", "white"), 7, 1);

        board.addPiece(new logic.Bishop("src/piezas/Bbishop.png", "black"), 0, 5);
        board.addPiece(new logic.Bishop("src/piezas/Wbishop.png", "white"), 7, 5);
        board.addPiece(new logic.Bishop("src/piezas/Bbishop.png", "black"), 0, 2);
        board.addPiece(new logic.Bishop("src/piezas/Wbishop.png", "white"), 7, 2);

        board.addPiece(new logic.Queen("src/piezas/Bqueen.png", "black"), 0, 4);
        board.addPiece(new logic.Queen("src/piezas/Wqueen.png", "white"), 7, 4);

        board.addPiece(new logic.King("src/piezas/Bking.png", "black"), 0, 3);
        board.addPiece(new logic.King("src/piezas/Wking.png", "white"), 7, 3);
        
        board.setVisible(true);
        //board.removePiece(7, 3);
        
    }
    
}