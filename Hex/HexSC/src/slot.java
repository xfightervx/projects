package HexSC.src;
import HexSC.src.Token.Color;

/*
 * this file is dedicated to define slots
 * define content of each slot(is_empty?taken?order_of_fill?token?)
 * define a constructor	that initialize the color wit empty to prevent null
 * pointer in comparisons in end.java
 */
public class slot {
	private boolean is_empty;//containing the state of the slot
	public Token owner;//defining the token placed in the slot
	public int order;//the order of placement of the token
	public static int number_of_moves=0;//total number of placed tokens
	/**
	 * a simple constructor
	 */
	public slot() {
		owner = new Token(Color.Empty);
		is_empty=true;
	}
	/*
	 * a method that change the value of is_empty indicating that the slot is 
	 * full
	 */
	public void fill() {
		is_empty=false;
	}
	public boolean is_empty() {//a getter for is_empty
		return is_empty;
	}
	
}
