package pieces;

/**
 *
 * @author gerald
 */
public class Pawn extends Piece{
	
    public Pawn(String image_file, String team, int []coordenates)
    {
        super(image_file);
        setType("Pawn");
        setTeam(team);
        setCoordenates(coordenates);
        setMoves(new int[][]{
        	{},
        	{},
        	
        });
    }
    
}
