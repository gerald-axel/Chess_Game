package logic;

/**
 *
 * @author gerald
 */
public class Queen extends Piece{
    
    public Queen(String image_file, String team)
    {
        super(image_file);
        setType("Queen");
        setTeam(team);
    }
    
}