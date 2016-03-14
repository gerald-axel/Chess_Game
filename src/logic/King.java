package logic;

/**
 *
 * @author gerald
 */
public class King extends Piece{
    
    public King(String image_file, String team)
    {
        super(image_file);
        setType("King");
        setTeam(team);
    }
    
}