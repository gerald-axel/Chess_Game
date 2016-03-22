package graphics;

/**
 *
 * @author gerald
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;

import logic.MakeMove;
import logic.PossibleMoves;

public class Board extends JFrame implements MouseListener
{
	
    public static JPanel[][] squares = new JPanel[8][8];
    public boolean isSelected = false;
    public static pieces.Piece pieceSelected;
    
    public Board() 
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 700);
        setLayout(new GridLayout(8, 8));
    }
    
    public void createSquares()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                JPanel panel = new JPanel();
                panel.addMouseListener(this);
                panel.setBackground(getColor(i, j));
                panel.setName(i + "," + j);
                add(panel);
                squares[i][j] = panel;
            }
        }
    }
    
    public Color getColor(int x, int y)
    {
        return (x + y) % 2 == 0 ? Color.WHITE : Color.GRAY;
    }
    
    public void addPiece(pieces.Piece p, int x, int y)
    {
        squares[x][y].add(p);
        paintAll(getGraphics());
    }
    
    public void removePiece(int x, int y)
    {
        squares[x][y].remove(0);
        paintAll(getGraphics());
    }
    
    public void cleanBoard()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
            	squares[i][j].setBorder(null);            
            }
        }
    	isSelected = false;
    }

    
    /* Mouse Events */
    @Override
    public void mouseClicked(MouseEvent e)
    {    	
    	/* 0 means there is not a piece, 1 means there is a piece */
    	int squareHasPiece = e.getComponent().getAccessibleContext().getAccessibleChildrenCount();
    	
        /* You have selected a piece */
        if(squareHasPiece != 0 && !isSelected){
            pieces.Piece piece = (pieces.Piece) e.getComponent().getAccessibleContext().getAccessibleChild(0);
            PossibleMoves.reviewPiece(piece);
            pieceSelected = piece;
            isSelected = true;
        }
        
        /* You had made a move */
        else if(isSelected){
        	
        	/* If the JPanel that is wanted to move is in the possibleMoves do it */
        	if(PossibleMoves.possibleMoves.contains(e.getComponent())){
            	MakeMove.movePiece(pieceSelected, e.getComponent().getName());
            	cleanBoard();
        	} else{
        		JOptionPane.showMessageDialog(null, "Movimiento no permitido!");
            	cleanBoard();
        	}
        	PossibleMoves.possibleMoves.clear();

        }
        
        else{
        	cleanBoard();
        }
        
    }

    
    public static void setBorders(int x, int y)
    {
    	Board.squares[x][y].setBorder(new CompoundBorder(
        	    BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED), 
        	    BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED)));
    }
    
    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}
   
}
