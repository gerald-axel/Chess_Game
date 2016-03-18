package pieces;

/**
 *
 * @author gerald
 */
public class Knight extends Piece{

    public Knight(String image_file, String team, int []coordenates)
    {
        super(image_file);
        setType("Knight");
        setTeam(team);
        setCoordenates(coordenates);
    }
    
}