package pieces;

/**
 *
 * @author gerald
 */
public class Bishop extends Piece{
    
    public Bishop(String image_file, String team, int []coordenates)
    {
        super(image_file);
        setType("Bishop");
        setTeam(team);
        setCoordenates(coordenates);
    }
    
}
