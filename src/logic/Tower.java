package logic;

public class Tower extends Piece{

    public Tower(String image_file, String team)
    {
        super(image_file);
        setType("Tower");
        setTeam(team);
    }
    
}
