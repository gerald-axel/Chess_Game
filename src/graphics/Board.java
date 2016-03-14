package graphics;

/**
 *
 * @author gerald
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JFrame implements MouseListener
{
    public JPanel[][] squares = new JPanel[8][8];
    
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
                panel.setBackground(getColor(i, j));
                //panel.setName(i + ","+ j);
                panel.addMouseListener(this);
                add(panel);
                squares[i][j] = panel;
            }
        }
    }
    
    public Color getColor(int x, int y)
    {
        return (x + y) % 2 == 0 ? Color.WHITE : Color.BLACK;
    }
    
    public void addPiece(logic.Piece p, int x, int y)
    {
        squares[x][y].add(p);
        paintAll(getGraphics());
    }
    
    public void removePiece(int x, int y)
    {
        squares[x][y].remove(0);
        paintAll(getGraphics());
    }

    /* Mouse Events */
    @Override
    public void mouseClicked(MouseEvent e){
        logic.Piece piece = (logic.Piece) e.getComponent().getAccessibleContext().getAccessibleChild(0);
        
        if(piece != null){
            System.out.println(piece.getType());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e){}
   
}
