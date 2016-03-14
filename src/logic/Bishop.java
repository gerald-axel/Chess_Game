package logic;

/**
 *
 * @author gerald
 */
public class Bishop extends Piece{
    
    public Bishop(String image_file, String team)
    {
        super(image_file);
        setType("Bishop");
        setTeam(team);
    }
    
}
