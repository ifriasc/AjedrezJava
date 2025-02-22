package pieces;

import main.Tablero;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tower extends Pieza {
    private BufferedImage img;

    public Tower(Tablero board, int row, int col, boolean iswhite){
        super(board, row, col, iswhite);
        try {
            if(iswhite) img = ImageIO.read(getClass().getResource("/images/tBlanco.png"));
            else img = ImageIO.read(getClass().getResource("/images/tNegro.png"));
            int cellSize = board.cellSize;
            Image scaled = img.getScaledInstance(cellSize, cellSize, Image.SCALE_SMOOTH);
            BufferedImage scaledBuffered = new BufferedImage(cellSize, cellSize, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = scaledBuffered.createGraphics();
            g2d.drawImage(scaled, 0, 0, null);
            g2d.dispose();
            img = scaledBuffered;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (img != null) {
            g2d.drawImage(img, col* board.cellSize, row* board.cellSize,this);
        }
    }

    public String toString(){
        return "Tower";
    }
}
