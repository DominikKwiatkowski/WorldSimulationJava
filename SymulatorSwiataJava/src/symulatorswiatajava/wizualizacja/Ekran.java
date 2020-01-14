/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.wizualizacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.KeyEventDispatcher.*;
import symulatorswiatajava.Kierunki;
import symulatorswiatajava.swiat.Swiat;
import symulatorswiatajava.Organizmy.Organizm;
import symulatorswiatajava.Ruch;

/**
 *
 * @author domik
 */
public class Ekran extends JPanel implements ActionListener, KeyListener, MouseListener {

    protected Color color;
    protected Organizm[][] plansza;
    protected int dlugosc, szerokosc;
    protected Swiat swiat;
    protected JFrame frame;

    public Ekran(JFrame frame, Swiat swiat, Organizm[][] plansza, int dlugosc, int szerokosc) {
        this.plansza = plansza;
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.swiat = swiat;
        this.frame = frame;
        repaint();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (!(this instanceof EkranHex)) {
            for (int i = 1; i <= dlugosc; i++) {
                for (int j = 1; j <= szerokosc; j++) {
                    g.setColor(plansza[i - 1][j - 1].Color());
                    g.fillRect(j * 30, i * 30, 30, 30);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                swiat.GetCzlowiek().SetRuch(Ruch.UP);
                break;
            case KeyEvent.VK_DOWN:
                swiat.GetCzlowiek().SetRuch(Ruch.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                swiat.GetCzlowiek().SetRuch(Ruch.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                swiat.GetCzlowiek().SetRuch(Ruch.LEFT);
                break;
            case KeyEvent.VK_ENTER:
                swiat.GetCzlowiek().SetPower();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ListaOrganizmow lista = new ListaOrganizmow(swiat, new Point(e.getY() / 30 - 1, e.getX() / 30 - 1));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

}
