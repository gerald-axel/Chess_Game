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
public class Queen extends Piece{
    
    public Queen(String image_file, String team)
    {
        super(image_file);
        setType("Queen");
        setTeam(team);
    }
    
}