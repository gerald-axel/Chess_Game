package logic;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author gerald
 */
public abstract class Piece extends JLabel{
    private String pieceType;
    private int x;
    private int y;
    private String team;    
    
    public Piece(String image_file){
        super(new ImageIcon(image_file));
    }
    
    public void setType(String pieceType) {
        this.pieceType = pieceType;
        this.setToolTipText(pieceType);
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getType(){
        return this.pieceType;
    }
    
    public String getTeam(){
        return this.team;
    }
}
