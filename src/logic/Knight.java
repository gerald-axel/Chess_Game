package logic;

/**
 *
 * @author gerald
 */
public class Knight extends Piece{

    public Knight(String image_file, String team)
    {
        super(image_file);
        setType("Knight");
        setTeam(team);
    }
    
}