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
public class Owca extends Zwierzeta{

    public Owca( int pozycjaX, int pozycjaY, Swiat swiat) {
        super(4, 4, pozycjaX, pozycjaY, 'o', swiat);
    }
    public Owca(int sila, int pozycjaX, int pozycjaY, Swiat swiat) {
        super(sila, 4, pozycjaX, pozycjaY, 'o', swiat);
    }
    @Override
    public java.awt.Color Color() {
         return Color.WHITE;
    }

    @Override
    public void MakeChild(int pozycjax, int pozycjay) {
        new Owca(pozycjax,pozycjay,this.GetSwiat());
    }
    
}
