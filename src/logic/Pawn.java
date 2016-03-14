package logic;

/**
 *
 * @author gerald
 */
public class Pawn extends Piece{
    
    public Pawn(String image_file, String team)
    {
        super(image_file);
        setType("Pawn");
        setTeam(team);
    }
    
}
