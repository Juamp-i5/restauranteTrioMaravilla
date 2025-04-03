/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Jp
 */
public class PlantillaMesa extends JPanel {

    String nombreMesa;

    public PlantillaMesa(String nombreMesa) {
        this.nombreMesa = nombreMesa;

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.ORANGE);
        g2d.fillOval(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.BOLD, 20);
        g2d.setFont(font);

        FontMetrics metrics = g2d.getFontMetrics(font);
        int x = (getWidth() - metrics.stringWidth(nombreMesa)) / 2;
        int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();

        g2d.drawString(nombreMesa, x, y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(150, 150);
    }

}
