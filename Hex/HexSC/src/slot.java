package HexSC.src;

import HexSC.src.Token.Color;

/*
 * this file is dedicated to define slots
 * define content of each slot(is_empty?taken?order_of_fill?token?)
 * define a constructor
 */
public class slot {
	private boolean is_empty;
	public Token owner;
	public int order;
	public static int number_of_moves=0;
	public slot() {
		owner = new Token(Color.Empty);
		is_empty=true;
	}
	public void fill() {
		is_empty=true;
	}
	public boolean is_empty() {
		return is_empty;
	}
	
}
