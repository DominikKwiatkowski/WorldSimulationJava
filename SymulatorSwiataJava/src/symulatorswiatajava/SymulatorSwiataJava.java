/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import symulatorswiatajava.swiat.Swiat;
import symulatorswiatajava.swiat.SwiatKwadratowy;
import symulatorswiatajava.Organizmy.*;
import symulatorswiatajava.swiat.SwiatHex;

/**
 *
 * @author domik
 */
public class SymulatorSwiataJava {

    public static void main(String[] args) {
        JFrame f = new JFrame("Ekran poczatku gry");
        JButton init = new JButton("zacznij");

        init.setPreferredSize(new Dimension(100, 50));
        f.getContentPane().setLayout(new FlowLayout());
        JTextField pole1 = new JTextField("Dlugosc", 10);
        JTextField pole2 = new JTextField("Szerokosc", 10);
        JTextField pole3 = new JTextField("h lub k", 10);
        f.getContentPane().add(pole1);
        f.getContentPane().add(pole2);
        f.getContentPane().add(pole3);
        init.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char typ = pole3.getText().charAt(0);
                int dlugosc = Integer.parseInt(pole1.getText());
                int szerokosc = Integer.parseInt(pole2.getText());
                Swiat swiat;
                if (typ == 'k') {
                    swiat = new SwiatKwadratowy(dlugosc, szerokosc);
                } else if (typ == 'h') {
                    swiat = new SwiatHex(dlugosc, szerokosc);
                } else {
                    return;
                }
                f.setVisible(false);
                new Wilk(1, 1, swiat);
                new Wilk(1, 2, swiat);
                new Owca(2, 2, swiat);
                new Owca(3, 3, swiat);
                new Trawa(5, 5, swiat);
                new Trawa(6, 6, swiat);
                new Mlecz(8, 8, swiat);
                new Mlecz(9, 9, swiat);
                new Guaryna(10, 10, swiat);
                new WilczaJagoda(4, 4, swiat);
                new WilczaJagoda(10, 0, swiat);
                new BarszczSosnowskiego(0, 10, swiat);
                new BarszczSosnowskiego(1, 10, swiat);
                new Zolw(5, 10, swiat);
                new Zolw(5, 11, swiat);
                new Lis(15, 15, swiat);
                new Lis(15, 15, swiat);
                new Antylopa(15, 0, swiat);
                new Antylopa(15, 1, swiat);
                swiat.Wypisz();

                System.out.println("zaczynam");
            }
        });
        f.getContentPane().add(init);
        f.pack();
        f.setVisible(true);
    }
}
