package pieces;

import main.*;
import javax.swing.*;
import java.awt.*;

public class Pieza extends JPanel {
    protected int row;
    protected int col;
    protected boolean iswhite;
    protected Tablero board;

    public Pieza(Tablero board, int row, int col, boolean iswhite){
        this.board = board;
        this.row = row;
        this.col = col;
        this.iswhite = iswhite;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isWhite() {
        return iswhite;
    }

    public void paint(Graphics g) {
        paintComponent(g);
    }
}
