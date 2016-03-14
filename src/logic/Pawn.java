/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
