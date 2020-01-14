/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.swiat;

import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;
import symulatorswiatajava.Organizmy.Organizm;
import symulatorswiatajava.wizualizacja.Ekran;
import symulatorswiatajava.wizualizacja.EkranHex;
import symulatorswiatajava.wizualizacja.MenuWyboru;

/**
 *
 * @author domik
 */
public class SwiatHex extends Swiat {

    public SwiatHex(int dlugosc, int szerokosc) {
        super(dlugosc, szerokosc);
    }

    @Override
    public void Wypisz() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 1, 0, 0));
        frame.setSize(1900, 1000);
        frame.setVisible(true);
        EkranHex e = new EkranHex(frame, this, super.GetMapa(), super.GetDlugosc(), super.GetSzerokosc());
        frame.add(e);
        e.setVisible(true);
        MenuWyboru m = new MenuWyboru(this, e);
        frame.add(m);
        m.setVisible(true);
    }

    @Override
    public ArrayList<Point> GetSasiadow(Organizm org) {
        ArrayList<java.awt.Point> sasiedzi = new ArrayList<>();

        if (org.GetPozycjaX() > 0) {
            sasiedzi.add(0, new Point(org.GetPozycjaX() - 1, org.GetPozycjaY()));
        } else {
            sasiedzi.add(0, new Point(-1, -1));
        }
        if (org.GetPozycjaX() + 1 < this.GetDlugosc()) {
            sasiedzi.add(1, new Point(org.GetPozycjaX() + 1, org.GetPozycjaY()));
        } else {
            sasiedzi.add(1, new Point(-1, -1));
        }
        if (org.GetPozycjaY() > 0) {
            sasiedzi.add(2, new Point(org.GetPozycjaX(), org.GetPozycjaY() - 1));
        } else {
            sasiedzi.add(2, new Point(-1, -1));
        }
        if (org.GetPozycjaY() + 1 < this.GetSzerokosc()) {
            sasiedzi.add(3, new Point(org.GetPozycjaX(), org.GetPozycjaY() + 1));
        } else {
            sasiedzi.add(3, new Point(-1, -1));
        }
        if (org.GetPozycjaX() % 2 == 0) {
            if (org.GetPozycjaY() > 0) {
                if (org.GetPozycjaX() > 0) {
                    sasiedzi.add(0, new Point(org.GetPozycjaX() - 1, org.GetPozycjaY() - 1));
                } else {
                    sasiedzi.add(0, new Point(-1, -1));
                }
                if (org.GetPozycjaX() + 1 < this.GetDlugosc()) {
                    sasiedzi.add(1, new Point(org.GetPozycjaX() + 1, org.GetPozycjaY() - 1));
                } else {
                    sasiedzi.add(1, new Point(-1, -1));
                }
            } else {
                sasiedzi.add(1, new Point(-1, -1));
                sasiedzi.add(1, new Point(-1, -1));
            }
        } else {
            if (org.GetPozycjaY() + 1 < this.GetSzerokosc()) {
                if (org.GetPozycjaX() > 0) {
                    sasiedzi.add(0, new Point(org.GetPozycjaX() - 1, org.GetPozycjaY() + 1));
                } else {
                    sasiedzi.add(0, new Point(-1, -1));
                }
                if (org.GetPozycjaX() + 1 < this.GetDlugosc()) {
                    sasiedzi.add(1, new Point(org.GetPozycjaX() + 1, org.GetPozycjaY() + 1));
                } else {
                    sasiedzi.add(1, new Point(-1, -1));
                }
            } else {
                sasiedzi.add(1, new Point(-1, -1));
                sasiedzi.add(1, new Point(-1, -1));
            }

        }
        return sasiedzi;
    }

}
