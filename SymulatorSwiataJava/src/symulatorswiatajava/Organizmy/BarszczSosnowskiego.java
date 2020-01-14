/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.Organizmy;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import symulatorswiatajava.swiat.Swiat;

/**
 *
 * @author domik
 */
public class BarszczSosnowskiego extends Rosliny {

    public BarszczSosnowskiego(int pozycjaX, int pozycjaY, Swiat swiat) {
        super(10, pozycjaX, pozycjaY, 'b', swiat);
    }

    @Override
    public java.awt.Color Color() {
        return Color.RED;
    }

    @Override
    public void MakeChild(int pozycjax, int pozycjay) {
        new BarszczSosnowskiego(pozycjax, pozycjay, this.GetSwiat());
    }

    @Override
    public void Kolizja(Organizm wrog, boolean atakujacy) {
        if (this.GetSila() > wrog.GetSila())
	{
            this.GetSwiat().SetMapa(this.GetPozycjaX(), this.GetPozycjaX(), new Ziemia(GetSwiat(),this.GetPozycjaX(),this.GetPozycjaY()));
            this.Usuniecie();
	}
        this.GetSwiat().SetMapa(wrog.GetPozycjaX(), wrog.GetPozycjaX(), new Ziemia(GetSwiat(),wrog.GetPozycjaX(),wrog.GetPozycjaY()));
	wrog.Usuniecie();
    }

    @Override
    public void Akcja() {
        ArrayList<Point> tab = this.GetSwiat().GetSasiadow(this);
        for (Point tab1 : tab) {
            if (tab1.x >= 0) {
                if (this.GetSwiat().GetMapa()[tab1.x][tab1.y].CzyZwierze()) {
                    this.GetSwiat().GetLog().Zbarszczowanie(this.GetSwiat().GetMapa()[tab1.x][tab1.y]);
                    this.GetSwiat().GetMapa()[tab1.x][tab1.y].Usuniecie();
                    this.GetSwiat().SetMapa(tab1.x, tab1.y, new Ziemia(GetSwiat(), tab1.x, tab1.y));
                }
            }
        }
        super.Akcja();
    }
}
