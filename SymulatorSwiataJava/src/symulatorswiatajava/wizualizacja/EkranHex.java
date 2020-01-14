/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.wizualizacja;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import symulatorswiatajava.Organizmy.Organizm;
import symulatorswiatajava.swiat.Swiat;

/**
 *
 * @author domik
 */
public class EkranHex extends Ekran {

    public EkranHex(JFrame frame, Swiat swiat, Organizm[][] plansza, int dlugosc, int szerokosc) {
        super(frame, swiat, plansza, dlugosc, szerokosc);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 1; i <= dlugosc; i++) {
            for (int j = 1; j <= szerokosc; j++) {
                g.setColor(plansza[i - 1][j - 1].Color());
                if (i % 2 == 0) {
                    g.fillPolygon(new Hexagon(new Point(i * 30 , j * 30+ 15), 20).getHexagon());
                } else {
                    g.fillPolygon(new Hexagon(new Point(i*30, j*30),20).getHexagon());
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        //TODO: open window with choose which organism should be created
        ListaOrganizmow lista = new ListaOrganizmow(swiat, new Point(e.getY() / 30 - 1, e.getX() / 30 - 1));
        //frame.setVisible(false);
    }
}
