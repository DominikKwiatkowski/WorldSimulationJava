/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.swiat;

import symulatorswiatajava.Organizmy.Organizm;
import symulatorswiatajava.Organizmy.Organizm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import symulatorswiatajava.wizualizacja.*;

/**
 *
 * @author domik
 */
public class SwiatKwadratowy extends Swiat {

    public SwiatKwadratowy(int dlugosc, int szerokosc) {
        super(dlugosc, szerokosc);
    }

    @Override
    public void Wypisz() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 1, 0, 0));
        frame.setSize(1900, 1000);
        frame.setVisible(true);
        Ekran e = new Ekran(frame, this, super.GetMapa(), super.GetDlugosc(), super.GetSzerokosc());
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
        if (org.GetPozycjaY() + 1 <this.GetSzerokosc()) {
            sasiedzi.add(3, new Point(org.GetPozycjaX(), org.GetPozycjaY() + 1));
        } else {
            sasiedzi.add(3, new Point(-1, -1));
        }

        return sasiedzi;
    }

}
