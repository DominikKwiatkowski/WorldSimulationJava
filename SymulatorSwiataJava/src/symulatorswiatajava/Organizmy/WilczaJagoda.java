/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.Organizmy;


import java.awt.Color;
import symulatorswiatajava.swiat.Swiat;

/**
 *
 * @author domik
 */
public class WilczaJagoda extends Rosliny {

    public WilczaJagoda(int pozycjaX, int pozycjaY, Swiat swiat) {
        super(99, pozycjaX, pozycjaY, 'j', swiat);
    }

    @Override
    public Color Color() {
        return Color.magenta;
    }

    @Override
    public void MakeChild(int pozycjax, int pozycjay) {
        new WilczaJagoda(pozycjax,pozycjay,this.GetSwiat());
    }
    @Override
    public void Kolizja(Organizm wrog, boolean atakujacy){
        if (this.GetSila() > wrog.GetSila())
	{
            this.GetSwiat().SetMapa(this.GetPozycjaX(), this.GetPozycjaX(), new Ziemia(GetSwiat(),this.GetPozycjaX(),this.GetPozycjaY()));
            this.Usuniecie();
	}
        this.GetSwiat().SetMapa(wrog.GetPozycjaX(), wrog.GetPozycjaX(), new Ziemia(GetSwiat(),wrog.GetPozycjaX(),wrog.GetPozycjaY()));
	wrog.Usuniecie();
    }
}
