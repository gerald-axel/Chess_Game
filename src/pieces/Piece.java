package pieces;

import javax.swing.*;
/**
 *
 * @author gerald
 */
public abstract class Piece extends JLabel
{	
    private String pieceType;
    private String team;
    private int [][]moves;
    private int movesCounter = 0;
    private int []coordenates;
    
    public Piece(String image_file)
    {
        super(new ImageIcon(image_file));
    }
    
    public void setType(String pieceType)
    {
        this.pieceType = pieceType;
        this.setToolTipText(pieceType);
    }

    public void setTeam(String team)
    {
        this.team = team;
    }
    
    public void setCoordenates(int []coordenates)
    {
    	this.coordenates = coordenates;
    }
    
    public void setMovesCounter()
    {
    	this.movesCounter++;
    }
    
    public String getType()
    {
        return this.pieceType;
    }
    
    public String getTeam()
    {
        return this.team;
    }
    
    public int getMovesCounter()
    {
    	return this.movesCounter;
    }
    
    public int[] getCoordenates(){
    	return this.coordenates;
    }
    
}
