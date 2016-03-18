package pieces;

/**
 *
 * @author gerald
 */
public class Queen extends Piece{
    
    public Queen(String image_file, String team, int []coordenates)
    {
        super(image_file);
        setType("Queen");
        setTeam(team);
        setCoordenates(coordenates);
    }
    
}