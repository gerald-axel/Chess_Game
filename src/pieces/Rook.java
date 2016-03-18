package pieces;

public class Rook extends Piece{

    public Rook(String image_file, String team, int []coordenates)
    {
        super(image_file);
        setType("Rook");
        setTeam(team);
        setCoordenates(coordenates);
    }
    
}
