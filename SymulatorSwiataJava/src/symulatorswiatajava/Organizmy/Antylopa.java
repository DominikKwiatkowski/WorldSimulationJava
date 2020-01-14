/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.Organizmy;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import symulatorswiatajava.swiat.Swiat;

/**
 *
 * @author domik
 */
public class Antylopa extends Zwierzeta{

    public Antylopa(int pozycjaX, int pozycjaY, Swiat swiat) {
        super(4, 4, pozycjaX, pozycjaY, 'a', swiat);
    }
    public Antylopa(int sila,int pozycjaX, int pozycjaY, Swiat swiat) {
        super(sila, 4, pozycjaX, pozycjaY, 'a', swiat);
    }
    @Override
    public java.awt.Color Color() {
        return Color.GRAY;
    }

    @Override
    public void MakeChild(int pozycjax, int pozycjay) {
        new Antylopa(pozycjax,pozycjay,this.GetSwiat());
    }
    @Override
    public void Akcja(){
        super.Akcja();
        if(this.GetSwiat().GetMapa()[this.GetPozycjaX()][this.GetPozycjaY()]==this){
            super.Akcja();
        }
    }
    @Override
    public boolean CzyZwial(){
         Random randGen = new Random();
        int temp = randGen.nextInt(2);
        if(temp==0){
            Point punkt = CzyAkcje();
            if(punkt==null)
                return false;
            else{
                this.GetSwiat().SetMapa(this.GetPozycjaX(),this.GetPozycjaY(), new Ziemia(this.GetSwiat(),punkt.x,punkt.y));
                this.SetPozycjaX(punkt.x);
                this.SetPozycjaY(punkt.y);
                this.GetSwiat().SetMapa(this.GetPozycjaX(),this.GetPozycjaY(),this);
                return true;
            }
        }
        else
            return false;
    }
}
