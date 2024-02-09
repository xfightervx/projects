package HexSC.src;
/*
 * in this file we define the tokens given them a enum color that either white or black
 * and a position in the beard and create a constructor that init the color and position
 * there is no error handling since each token will be created right when put on the beard
 * and will be given a 
 */
public class token {
	enum color{
		black,
		white
	}
	private int[] pos;
	private color col;
	public token(color k,int[] l) {
		col = k;
		pos = new int[2];
		pos[0]=l[0];
		pos[1]=l[1];
		
	}
}
