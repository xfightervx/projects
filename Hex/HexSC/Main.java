package HexSC;

import HexSC.src.board;
import HexSC.src.Token.Color;
/*
 * The Hex game (https://en.wikipedia.org/wiki/Hex_(board_game)) is a simple board game 
 * that has two players, each with theoretically infinite tokens of either white or black.
 * The starter of the game is chosen randomly and given the black tokens.
 * The board can be a 11x11 or 13x13 or 19x19 rhombus (check https://en.wikipedia.org/wiki/Rhombus
 * for more info).
 * Players take turns putting their tokens on the board as long as the spot is empty.
 * The game ends when a player makes a connection from their end of the board to the end 
 * facing the opponent.
 * This game is solved (meaning the starting position can always win), hence the existence
 * of an AI or algorithm that can never be beaten given the first move. Creating such a bot 
 * is the objective of the second part of the project.
 */
public class Main {
    public static void main(String[] args) {
        board b = new board(11);
        for(int i=0;i<11;i++) {
        	int[] k = new  int[2];
        	k[0]=0;
        	k[1]=10-i;
        	b.check_place(k,Color.BLACK);
        }
    }
}
