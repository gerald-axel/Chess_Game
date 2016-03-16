package logic;

public class Rook extends Piece{

    public Rook(String image_file, String team)
    {
        super(image_file);
        setType("Tower");
        setTeam(team);
    }
    
}
