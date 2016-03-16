/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import graphics.Board;
import java.awt.Color;

/**
 *
 * @author gerald
 */
public class PossibleMoves {
    
    public PossibleMoves(){
    }
    
    public static void reviewPiece(String pieceType, String coordenates, String team){
        String []position = coordenates.split(",");
        int x = Integer.parseInt(position[0]);
        int y = Integer.parseInt(position[1]);

        switch(pieceType){
            case "Pawn":
                pawnMoves(x, y, team);
                break;
            
            case "Knight":
                knightMoves(x, y, team);
                break;
                
            case "King":
                kingMoves(x, y, team);
                break;
                
            case "Bishop":
                bishopMoves(x, y, team);
                break;
                
            case "Rook":
                rookMoves(x, y, team);
                break;
                
            case "Queen":
                queenMoves(x, y, team);
                break;
        }
    }
    
    public static boolean pawnMoves(int x, int y, String team){
        int nextPosition = team.equals("white") ? -1 : 1;

        Piece piece = (Piece) Board.squares[x + 1][y].getAccessibleContext().getAccessibleChild(0);
        System.out.println(piece);

        if(piece == null){
            Board.squares[x + 1][y].setBackground(Color.BLUE);
            System.out.println("Color");
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean kingMoves(int x, int y, String team){
        int[][] range = {
            {1,  0},
            {0,  1},
            {-1, 0},
            {0, -1},
            {1,  1},
            {-1, 1},
            {-1,-1},
            {1, -1}
        };    
 
        return true;
    }

    public static boolean bishopMoves(int x, int y, String team){
        int limitX = 8 - x;
        int limitY = 8 - y;
        
        for (int i = 0; i < limitX; i++) {
            for (int j = 0; j < limitY; j++) {
                
            }
        }
        return true;
    }

    public static boolean rookMoves(int x, int y, String team){
        return true;
    }

    public static boolean queenMoves(int x, int y, String team){
        return true;
    }
    
    public static boolean knightMoves(int x, int y, String team){
        int[][] range = {
            {-2, 1},
            {-1, 2},
            {1,  2},
            {2,  1},
            {2, -1},
            {1, -2},
            {-1,-2},
            {-2,-1}
        };
        return true;
    }
}
