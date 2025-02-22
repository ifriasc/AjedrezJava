package main;

import pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Tablero extends JPanel {
    private int cols = 8;
    private int rows = 8;
    public final int cellSize = 90; // Tamaño de cada celda

    private ArrayList<Pieza> piezas = new ArrayList<>();
    public Pieza piezaSeleccionada;

    public Tablero() {
        this.setLayout(new GridLayout(8,8));

        this.setPreferredSize(new Dimension(cols*cellSize, rows*cellSize));
        this.setBackground(Color.GREEN);
        addPieces();
    }

    public void getPiezaSelect(int row, int col) {
        int i = 0;
        boolean found = false;
        while(i < piezas.size() && !found) {
            if(piezas.get(i).getRow() == row && piezas.get(i).getCol() == col) {
                piezaSeleccionada = piezas.get(i);
                found = true;
            }
            i++;
        }
        if(!found) piezaSeleccionada = null;
    }

    public void addPieces() {
        //Blacks
        piezas.add(new Tower(this, 0, 0, false));
        piezas.add(new Knight(this, 0, 1, false));
        piezas.add(new Bishop(this, 0, 2, false));
        piezas.add(new King(this, 0, 3, false));
        piezas.add(new Queen(this, 0, 4, false));
        piezas.add(new Bishop(this, 0, 5, false));
        piezas.add(new Knight(this, 0, 6, false));
        piezas.add(new Tower(this, 0, 7, false));
        for(int j = 0; j < cols;j++){//black pawns
            piezas.add(new Pawn(this, 1, j, false));
        }

        //Whites
        for(int j = 0; j < cols;j++){//white pawns
            piezas.add(new Pawn(this, 6, j, true));
        }
        piezas.add(new Tower(this, 7, 0, true));
        piezas.add(new Knight(this, 7, 1, true));
        piezas.add(new Bishop(this, 7, 2, true));
        piezas.add(new King(this, 7, 3, true));
        piezas.add(new Queen(this, 7, 4, true));
        piezas.add(new Bishop(this, 7, 5, true));
        piezas.add(new Knight(this, 7, 6, true));
        piezas.add(new Tower(this, 7, 7, true));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                g2d.setColor(((i+j) % 2 == 0) ? Color.WHITE : new Color(110,43,26));
                g2d.fillRect(j*cellSize, i*cellSize, cellSize, cellSize);
            }
        }

        for(Pieza p: piezas){
            p.paint(g2d);
        }
    }

}
