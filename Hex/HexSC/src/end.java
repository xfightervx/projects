package HexSC.src;
import HexSC.src.Token.Color;

public class end{
	private static int size;
	private static int[][] pos_black;

	public void initializePosBlack(int size) {
	    pos_black = new int[size * size][2];
	}
	private static int[][] pos_white;

	public void initializePosWhite(int size) {
	    pos_white = new int[size * size][2];
	}
	protected void get_size(int size) {
		end.size=size;
		initializePosBlack(size);
		initializePosWhite(size);
	}
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
	public boolean end_game(slot[][] board,Color c,int[] pos) {
		boolean start=false;
		boolean finish=false;
		int[][] crawler =new int[(size*size)/2][2];
		for(int i=0;i<size*size/2;i++) {
			crawler[i][0]=-1;
		}
		crawler[0]=pos;
		int position=0;
		outer:
		while(crawler[position][0]!=-1 && position<=(size*size)/2) {
			board[crawler[position][0]][crawler[position][1]].owner.passed=true;
			int[][] nighbor = check_nighbore(crawler[position], c, board);
			int k=1;
			for(int i=0;i<6;i++) {
				if(nighbor[i][0]!=-1) {
					crawler[position+k][0]=nighbor[i][0];
					crawler[position+k][1]=nighbor[i][1];
					board[nighbor[i][0]][nighbor[i][1]].owner.passed=true;
					k+=1;
				}
			}
			if(crawler[position][1]==0 && c==Color.WHITE) {
				start=true;
			}
			if(crawler[position][0]==0 && c==Color.BLACK) {
				start=true;
			}
			if(crawler[position][0]==size-1 && c==Color.WHITE) {
				finish=true;
			}
			if(crawler[position][1]==size-1 && c==Color.BLACK) {
				finish=true;
			}
			position+=1;
			if(start&&finish) {
				break outer;
			}
		}
		if(c==Color.BLACK) {
			for(int[] i:pos_black){
				board[i[0]][i[1]].owner.passed=false;
			}
		}
		if(c==Color.WHITE) {
			for(int[] i:pos_white){
				board[i[0]][i[1]].owner.passed=false;
			}
		}
		return start&&finish;
	}
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
