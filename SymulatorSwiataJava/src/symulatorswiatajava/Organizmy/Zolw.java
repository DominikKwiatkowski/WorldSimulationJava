/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.Organizmy;

import java.awt.Color;
import java.util.Random;
import symulatorswiatajava.swiat.Swiat;

/**
 *
 * @author domik
 */
public class Zolw extends Zwierzeta {

    public Zolw(int pozycjaX, int pozycjaY, Swiat swiat) {
        super(2, 1, pozycjaX, pozycjaY, 'z', swiat);
    }
    public Zolw(int sila, int pozycjaX, int pozycjaY, Swiat swiat) {
        super(sila, 1, pozycjaX, pozycjaY, 'z', swiat);
    }
    @Override
    public Color Color() {

        return new Color(0, 51, 0);
    }

    @Override
    public void MakeChild(int pozycjax, int pozycjay) {
        new Zolw(pozycjax,pozycjay,this.GetSwiat());
    }
    
    @Override
    public void Akcja(){
        Random randGen = new Random();
        int temp = randGen.nextInt(4);
        if(temp==0){
            super.Akcja();
        }
    }
    @Override
    public boolean CzyOdbil(Organizm wrog){
        if(wrog.GetSila()<5)
            return true;
        else
            return false;
    }
}
