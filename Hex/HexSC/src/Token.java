package HexSC.src;

/**
 * Defines tokens with an enum color representing white or black.
 * Each token has a position on the board.
 * Error handling is omitted since tokens are created when placed on the board.
 */
public class Token {
    enum Color {
        BLACK,      // First player's color
        WHITE,      // Second player's color
        FAINT_BLACK,// Temporary token used for hovering over slots
        FAINT_WHITE
    }

    public Color color; // Token's color

    /**
     * Initializes token with given color and position.
     * @param color The color of the token
     */
    public Token(Color color) {
        this.color = color;
    }
}
