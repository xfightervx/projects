package HexSC.src;
import HexSC.src.Token.Color;

import java.util.LinkedList;
import java.util.Queue;
/*
 * in this file i tried to fit in all methods i needed to announce the end
 * of the game
 */
public class end{
	private static int size;//a variable used to stock the size of the board
	private static int[][] pos_black;//an array for the position of all black tokens

	public void initializePosBlack(int size) {//initializing pos_black
	    pos_black = new int[size * size][2];
	}
	private static int[][] pos_white;//same as pos_black

	public void initializePosWhite(int size) {
	    pos_white = new int[size * size][2];
	}
	protected void get_size(int size) {//a method used to initialize the arrays and pass the size
		end.size=size;
		initializePosBlack(size);
		initializePosWhite(size);
	}
	/**
	 * a method used to return the neighbors of a given slot that didn't get passed
	 *  by the crawler(will be defined after) using a simple logic:
	 *  check slot if only guaranteed it existence to prevent index out of bound
	 * @param pos the position of the slot we want to check it neighbors
	 * @param c the color of the token we look for
	 * @param board the board of the game
	 * @return an array containing all the neighbors the we can crawl over
	 */
	private int[][] check_nighbore(int[] pos,Color c,slot[][] board) {
		int[][] nighbors=new int[6][2];
		for(int i=0;i<6;i++) {
			nighbors[i][0]=-1;
			nighbors[i][1]=-1;
		}
		int a=pos[0];
		int b=pos[1];
		if(a!=0) {
			if(!board[a-1][b].owner.passed && board[a-1][b].owner.color==c) {
				nighbors[0][0]=a-1;
				nighbors[0][1]=b;
			}
		}
		if(b!=0) {
			if(!board[a][b-1].owner.passed && board[a][b-1].owner.color==c) {
				nighbors[1][0]=a;
				nighbors[1][1]=b-1;
			}
		}
		if(a!=size-1) {
			if(!board[a+1][b].owner.passed && board[a+1][b].owner.color==c) {
				nighbors[2][0]=a+1;
				nighbors[2][1]=b;
			}
		}
		if(b!=size-1) {
			if(!board[a][b+1].owner.passed && board[a][b+1].owner.color==c) {
				nighbors[3][0]=a;
				nighbors[3][1]=b+1;
			}
		}
		if(a!=0 && b!=size-1) {
			if(!board[a-1][b+1].owner.passed && board[a-1][b+1].owner.color==c) {
				nighbors[4][0]=a-1;
				nighbors[4][1]=b+1;
			}
		}
		if(a!=size-1 && b!=0) {
			if(!board[a+1][b-1].owner.passed && board[a+1][b-1].owner.color==c) {
				nighbors[5][0]=a+1;
				nighbors[5][1]=b-1;
			}
		}
		return nighbors;
	}
	/**
	 * a method used to answer is the game over? using a simple logic:
	 * if the game over changed value from the before last move to this move that means
	 * the last placed token exist in the chain that connect the two ends of the board
	 * using start var and finish var to track if the crawler did reach both ends of the 
	 * board thus the end of game. starting the crawler from the position that we placed
	 * on the last token by adding it to a FIFO crawler and filling it with it s position
	 * then checking if we reached any of the ends of the board.
	 * @param board the board of the game in the state after putting the last token
	 * @param c the color of the last token
	 * @param pos	the position of the last token
	 * @return a binary value that represent the end of the game
	 */
	public boolean end_game(slot[][] board,Color c,int[] pos) {
		boolean start;//setting the start and finish to false
		boolean finish;
		start=finish=false;
		Queue<Integer> crawler1 =new LinkedList<Integer>();
		Queue<Integer> crawler2 =new LinkedList<Integer>();
		int[] crawler =new int[2];//creating the FIFO
		outer://a way to break from both loops
		/*
		 * loop as long as crawler not empty(we passed every slot in the chain) and index is 
		 * valid
		 */
		crawler1.offer(pos[0]);
		crawler2.offer(pos[1]);
		
		outer:
		while(!crawler1.isEmpty()) {
			
			crawler[0]= crawler1.poll();
			crawler[1]= crawler2.poll();
			if(crawler[0]==0 && c==Color.WHITE) {
				
				start=true;
			}
			if(crawler[1]==0 && c==Color.BLACK) {
				
				start=true;
			}
			if(crawler[0]==size-1 && c==Color.WHITE) {
				finish=true;
			}
			if(crawler[1]==size-1 && c==Color.BLACK) {
				
				finish=true;
			}
			board[crawler[0]][crawler[1]].owner.passed=true;//mark it being passed
			int[][] nighbor = check_nighbore(crawler, c, board);
			for(int i=0;i<6;i++) {//adding the neighbors to the FIFO and marking them
				if(nighbor[i][0]!=-1) {
					crawler1.offer(nighbor[i][0]);
					crawler2.offer(nighbor[i][1]);
					board[nighbor[i][0]][nighbor[i][1]].owner.passed=true;
				}
			}

			//update the value of start and finish after each iteration
			if(start&&finish) {//if we reach both end no need to go further the game is over
				break outer;
			}
			
			
		}
		for(int[] i :pos_black) {
			board[i[0]][i[1]].owner.passed=false;
		}
		for(int[] i :pos_white) {
			board[i[0]][i[1]].owner.passed=false;
		}
		return start&&finish;
	}
	//add the position of the last token to the array to make removing marks easier
	public void pos_increase(Color c,int[] pos) {
		if(c==Color.BLACK) {
			pos_black[slot.number_of_moves/2][0]=pos[0];
			pos_black[slot.number_of_moves/2][1]=pos[1];
		}
		else {
			pos_white[slot.number_of_moves/2][0]=pos[0];
			pos_white[slot.number_of_moves/2][1]=pos[1];
		}
	}
}
