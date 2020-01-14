/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.Organizmy;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import symulatorswiatajava.swiat.Swiat;

/**
 *
 * @author domik
 */
public abstract class Rosliny extends Organizm {

    public Rosliny(int sila, int pozycjaX, int pozycjaY, char literka, Swiat swiat) {
        super(sila, 0, pozycjaX, pozycjaY, literka, swiat);
    }

    @Override
    protected Point CzyAkcje() {

        Random generator = new Random();
        int numerek = generator.nextInt(10);
        if (numerek < 2) {
            ArrayList<Point> tab = this.GetSwiat().GetSasiadow(this);
            int size = tab.size();
            for (int i = 0; i < size; i++) {
                int numer = generator.nextInt(tab.size());
                if (tab.get(numer).x >= 0) {
                    if (this.GetSwiat().GetMapa()[tab.get(numer).x][tab.get(numer).y] instanceof Ziemia) {
                        return tab.get(numer);
                    }
                } else {
                    tab.remove(numer);
                }
            }
        }
        return null;
    }

    @Override
    public void Akcja() {
        Point punkt = CzyAkcje();
        if (punkt == null) {
        } else {
            this.MakeChild(punkt.x, punkt.y);
        }
    }

    @Override
    public void Kolizja(Organizm wrog, boolean atakujacy) {
        if (this.GetSila() > wrog.GetSila()) {
            wrog.Usuniecie();
        }
    }
}
