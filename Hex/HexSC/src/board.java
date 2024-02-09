package HexSC.src;

import HexSC.src.Token.Color;

/*
 * this file is dedicated to creating the board
 * creating the constructor
 * creating a place_token method
 * creating a check_end_game method
 * creating a cancel_move method
 * 
 */
public class board {
	private int size;//the size of the board sizexsize
	public slot[][] board;//the board containing slots
	public end end=new end();//variable that indicate the end of the game
	/**
	 * Initializing  the board by:
	 * @param size :the size of the board;
	 * the creating the slots of the board
	 * passing the size to end
	 */
	public board(int size) {
		this.size=size;
		this.board=new slot[size][size];
		end.get_size(size);
	}
	/**
	 * placing token in slots(private because it should only invoked by check_place)
	 * @param pos :the position of the slot which will be filled
	 * @param c : the color of the Token that will fill the slot
	 * first putting a token in the position wanted in the board
	 * then increasing the number of moves
	 * increasing the array that saves the position of tokens
	 * then check if the game is over after at list [size*2-1] of moves since the game 
	 * can't be over if one of the players at least put [size] of tokens in the board
	 * to connect the two ends
	 * and return the position in the end
	 */
	private int[] place_token(int[] pos,Color c) {
		this.board[pos[0]][pos[1]].owner=new Token(c);
		this.board[pos[0]][pos[1]].order = slot.number_of_moves+1;
		slot.number_of_moves+=1;
		end.pos_increase(c, pos);
		if(slot.number_of_moves>=size*2-1) {
			check_end_game(c);
		}
		return pos;
	}
	/*
	 * 
	 */
	public void check_place(int[] pos,Color c) {
		if(this.board[pos[0]][pos[1]].is_empty()) {
			place_token(pos, c);
		}
	}
	public boolean check_end_game(Color c) {
		return end.end_game(this.board,c);
	}
	public void cuncel_move() {
		if(slot.number_of_moves!=0) {
			outerloop:
			for(int i=0;i<size;i--) {
				for(int j=0;j<size;j--) {
					if(this.board[i][j].order==slot.number_of_moves) {
						this.board[i][j] = new slot();
						slot.number_of_moves-=1;
						break outerloop;
					}
				}
			}
		}
	}
}
