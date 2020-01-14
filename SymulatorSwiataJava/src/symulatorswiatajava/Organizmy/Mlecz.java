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
public class Mlecz extends Rosliny {

    public Mlecz(int pozycjaX, int pozycjaY, Swiat swiat) {
        super(0, pozycjaX, pozycjaY, 'm', swiat);
    }

    @Override
    public java.awt.Color Color() {
        return Color.YELLOW;
    }

    @Override
    public void MakeChild(int pozycjax, int pozycjay) {
        new Mlecz(pozycjax, pozycjay, this.GetSwiat());
    }
    
    @Override
    public void Akcja(){
        for(int i=0;i<3;i++){
            super.Akcja();
        }
    }
}
