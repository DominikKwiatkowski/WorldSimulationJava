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
public class Guaryna extends Rosliny{

    public Guaryna(int pozycjaX, int pozycjaY,  Swiat swiat) {
        super(0, pozycjaX, pozycjaY, 'g', swiat);
    }


    @Override
    public java.awt.Color Color() {
        return new Color(110, 76, 211);
    }

    @Override
    public void MakeChild(int pozycjax, int pozycjay) {
        new Guaryna(pozycjax,pozycjay,this.GetSwiat());
    }
    
    @Override
    public void Kolizja(Organizm wrog,boolean atakujacy){
        wrog.SetSila(wrog.GetSila()+3);
    }
}
