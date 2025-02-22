package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        Tablero tablero = new Tablero();
        tablero.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = e.getY()/ tablero.cellSize;
                int col = e.getX()/ tablero.cellSize;
                tablero.getPiezaSelect(row, col);
                System.out.println(row +" " +col+"\nPieza: "+ tablero.piezaSeleccionada);
                if(tablero.piezaSeleccionada == null){
                    System.out.println("No se ha seleccionado ninguna pieza");
                }
            }

            public void mouseDragged(MouseEvent e) {
                if(tablero.piezaSeleccionada != null){
                    tablero.piezaSeleccionada.setRow(e.getY()/tablero.cellSize);
                    tablero.piezaSeleccionada.setCol(e.getX()/ tablero.cellSize);
                    tablero.repaint();
                }
            }

            public void mouseReleased(MouseEvent e) {
                int row = e.getY()/ tablero.cellSize;
                int col = e.getX()/ tablero.cellSize;
                if(tablero.piezaSeleccionada != null){
                   // tablero.makeMove(row, col);

                }
            }
        });

        frame.add(tablero);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}