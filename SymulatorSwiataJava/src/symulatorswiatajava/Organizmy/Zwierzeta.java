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
public abstract class Zwierzeta extends Organizm {

    public Zwierzeta(int sila, int inicjatywa, int pozycjaX, int pozycjaY, char literka, Swiat swiat) {
        super(sila, inicjatywa, pozycjaX, pozycjaY, literka, swiat);
    }

    @Override
    public boolean CzyZwierze() {
        return true;
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
                return tab.get(numer);
            }
        }
        return null;
    }

    @Override
    public void Akcja() {
        Point punkt = CzyAkcje();
        if (punkt == null) {
        } else if (this.GetSwiat().GetMapa()[punkt.x][punkt.y] instanceof Ziemia) {
            this.GetSwiat().SetMapa(this.GetPozycjaX(), this.GetPozycjaY(), new Ziemia(this.GetSwiat(), this.GetPozycjaX(), this.GetPozycjaY()));
            this.SetPozycjaX(punkt.x);
            this.SetPozycjaY(punkt.y);
            this.GetSwiat().SetMapa(this.GetPozycjaX(), this.GetPozycjaY(), this);

        } else {
            this.Kolizja(this.GetSwiat().GetMapa()[punkt.x][punkt.y], true);
        }
    }

    @Override
    public void Kolizja(Organizm wrog, boolean atakujacy) {
        if (wrog.GetLiterka() == this.GetLiterka()) {
            ArrayList<Point> tab = this.GetSwiat().GetSasiadow(this);
            for (Point tab1 : tab) {
                if (tab1.x >= 0) {
                    if (this.GetSwiat().GetMapa()[tab1.x][tab1.y] instanceof Ziemia) {
                        this.MakeChild(tab1.x, tab1.y);
                        return;
                    }
                }
            }
            if (atakujacy) {
                wrog.Kolizja(this, false);
            }
        } else if (wrog.CzyOdbil(this)) {
        } else if (atakujacy == false && GetSila() <= wrog.GetSila()) {
        } else {
            int pozycjax = wrog.GetPozycjaX();
            int pozycjay = wrog.GetPozycjaY();
            if (wrog.CzyZwial() && atakujacy) {
                this.GetSwiat().SetMapa(GetPozycjaX(), GetPozycjaY(), new Ziemia(this.GetSwiat(), pozycjax, pozycjay));
                this.SetPozycjaX(pozycjax);
                this.SetPozycjaY(pozycjay);
                this.GetSwiat().SetMapa(GetPozycjaX(), GetPozycjaY(), this);
            } else if (CzyZwial()) {
            } else {
                if(atakujacy){
                    this.GetSwiat().GetLog().Stworz(this,wrog);
                }
                if (GetSila() > wrog.GetSila()) {
                    wrog.Kolizja(this, false);
                    if (!wrog.CzyTrujacy()) {
                        if (atakujacy) {
                            this.GetSwiat().SetMapa(GetPozycjaX(), GetPozycjaY(), new Ziemia(this.GetSwiat(), pozycjax, pozycjay));
                            this.SetPozycjaX(wrog.GetPozycjaX());
                            this.SetPozycjaY(wrog.GetPozycjaY());
                            this.GetSwiat().SetMapa(wrog.GetPozycjaX(), wrog.GetPozycjaY(), this);
                        }
                        else{
                            this.GetSwiat().SetMapa(this.GetPozycjaX(), this.GetPozycjaX(), new Ziemia(GetSwiat(),this.GetPozycjaX(),this.GetPozycjaY()));
                        }
                    }
                    wrog.Usuniecie();
                } else if (GetSila() == wrog.GetSila()) {
                    if (atakujacy) {
                        wrog.Kolizja(this, false);
                        if (!wrog.CzyTrujacy()) {
                            this.GetSwiat().SetMapa(GetPozycjaX(), GetPozycjaY(), new Ziemia(this.GetSwiat(), pozycjax, pozycjay));
                            this.SetPozycjaX(wrog.GetPozycjaX());
                            this.SetPozycjaY(wrog.GetPozycjaY());
                            this.GetSwiat().SetMapa(wrog.GetPozycjaX(), wrog.GetPozycjaY(), this);
                        }
                        wrog.Usuniecie();
                    }
                    else{
                        wrog.Kolizja(this, false);
                    }
                } else {
                    wrog.Kolizja(this, false);
                }
            }
        }
    }
}
