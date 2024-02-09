package HexSC.src;
import HexSC.src.Token.Color;

public class end{
	private static int size;
	private static int[][] pos_white=new int[(size*size)/2][2];
	private static int[][] pos_black=new int[(size*size)/2][2];
	protected void get_size(int size) {
		end.size=size;
	}
	private int[][] check_nighbore(int[] pos,Color c,slot[][] board) {
		int[][] nighbors=new int[6][2];
		int a=pos[0];
		int b=pos[1];
		if(pos[0]==0) {
			if(pos[1]==0) {
				if(board[0][1].owner.color== c) {
					nighbors[0][0]=0;
					nighbors[0][1]=1;
				}
				if(board[1][0].owner.color== c) {
					nighbors[2][0]=1;
					nighbors[2][1]=0;
				}
			}
			if(pos[1]==size-1) {
				if(board[1][size-1].owner.color== c) {
					nighbors[2][0]=1;
					nighbors[2][1]=size-1;
				}
				if(board[0][size-2].owner.color== c) {
					nighbors[4][0]=0;
					nighbors[4][1]=size-2;
				}
				if(board[1][size-2].owner.color== c) {
					nighbors[3][0]=1;
					nighbors[3][1]=size-2;
				}
			}
			else {
				if(board[a][b-1].owner.color== c) {
					nighbors[4][0]=a;
					nighbors[4][1]=b-1;
				}
				if(board[a][b+1].owner.color== c) {
					nighbors[1][0]=a;
					nighbors[1][1]=b+1;
				}
				if(board[a+1][b-1].owner.color== c) {
					nighbors[3][0]=a+1;
					nighbors[3][1]=b-1;
				}
				if(board[a+1][b].owner.color== c) {
					nighbors[2][0]=a+1;
					nighbors[2][1]=b;
				}
			}
			
		}
		if(pos[0]==size-1) {
			if(pos[1]==0) {
				if(board[size-1][1].owner.color== c) {
					nighbors[0][0]=size-1;
					nighbors[0][1]=1;
				}
				if(board[1][0].owner.color== c) {
					nighbors[2][0]=1;
					nighbors[2][1]=0;
				}
				if(board[1][0].owner.color== c) {
					nighbors[2][0]=1;
					nighbors[2][1]=0;
				}
			}
			if(pos[1]==size-1) {
				if(board[1][size-1].owner.color== c) {
					nighbors[2][0]=1;
					nighbors[2][1]=size-1;
				}
				if(board[0][size-2].owner.color== c) {
					nighbors[4][0]=0;
					nighbors[4][1]=size-2;
				}
				if(board[1][size-2].owner.color== c) {
					nighbors[3][0]=1;
					nighbors[3][1]=size-2;
				}
			}
			else {
				if(board[a][b-1].owner.color== c) {
					nighbors[4][0]=a;
					nighbors[4][1]=b-1;
				}
				if(board[a][b+1].owner.color== c) {
					nighbors[1][0]=a;
					nighbors[1][1]=b+1;
				}
				if(board[a+1][b-1].owner.color== c) {
					nighbors[3][0]=a+1;
					nighbors[3][1]=b-1;
				}
				if(board[a+1][b].owner.color== c) {
					nighbors[2][0]=a+1;
					nighbors[2][1]=b;
				}
			}
			
		}
		return nighbors;
	}
	public boolean end_game(slot[][] board,Color c) {
		boolean end=false;
		boolean start=false;
		boolean finish=false;
		
		return end;
	}
	public void pos_increase(Color c,int[] pos) {
		if(c==Color.BLACK) {
			pos_black[slot.number_of_moves/2]=pos;
		}
		else {
			pos_white[slot.number_of_moves/2]=pos;
		}
	}
}
