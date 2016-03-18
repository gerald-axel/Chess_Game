package pieces;

/**
 *
 * @author gerald
 */
public class King extends Piece{
    
    public King(String image_file, String team, int []coordenates)
    {
        super(image_file);
        setType("King");
        setTeam(team);
        setCoordenates(coordenates);
    }
    
}