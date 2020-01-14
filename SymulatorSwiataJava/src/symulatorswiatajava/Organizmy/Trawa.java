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
public class Trawa extends Rosliny {

    public Trawa(int pozycjaX, int pozycjaY, Swiat swiat) {
        super(0, pozycjaX, pozycjaY, 't', swiat);
    }

    @Override
    public java.awt.Color Color() {
        return Color.GREEN;
    }

    @Override
    public void MakeChild(int pozycjax, int pozycjay) {
        new Trawa(pozycjax,pozycjay,this.GetSwiat());
    }
    
}
