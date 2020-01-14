/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.Organizmy;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import symulatorswiatajava.swiat.Swiat;

/**
 *
 * @author domik
 */
public class Lis extends Zwierzeta {

    public Lis(int pozycjaX, int pozycjaY, Swiat swiat) {
        super(3, 7, pozycjaX, pozycjaY, 'l', swiat);
    }
    public Lis(int sila, int pozycjaX, int pozycjaY, Swiat swiat) {
        super(sila, 7, pozycjaX, pozycjaY, 'l', swiat);
    }
    @Override
    public java.awt.Color Color() {
        return Color.ORANGE;
    }

    @Override
    public void MakeChild(int pozycjax, int pozycjay) {
        new Lis(pozycjax, pozycjay, this.GetSwiat());
    }

    @Override
    protected Point CzyAkcje() {
        ArrayList<Point> tab = this.GetSwiat().GetSasiadow(this);
        Random generator = new Random();
        int size = tab.size();
        for (int i = 0; i < size; i++) {
            int numer = generator.nextInt(tab.size());
            if (tab.get(numer).x == -1) {
                tab.remove(numer);
            } else {
                if (this.GetSwiat().GetMapa()[tab.get(numer).x][tab.get(numer).y].GetSila() > this.GetSila()) {
                    tab.remove(numer);
                } else {
                    return tab.get(numer);
                }
            }
        }
        return null;
    }
}
