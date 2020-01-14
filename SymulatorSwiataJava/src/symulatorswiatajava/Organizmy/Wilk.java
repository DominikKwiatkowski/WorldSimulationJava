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
public class Wilk extends Zwierzeta{

    public Wilk(int pozycjaX, int pozycjaY, Swiat swiat) {
        super(9, 5, pozycjaX, pozycjaY, 'w', swiat);
    }
    public Wilk(int sila,int pozycjaX, int pozycjaY, Swiat swiat) {
        super(sila, 5, pozycjaX, pozycjaY, 'w', swiat);
    }
    @Override
    public Color Color() {
        return Color.BLACK;
    }

    @Override
    public void MakeChild(int pozycjax, int pozycjay) {
        new Wilk(pozycjax,pozycjay,this.GetSwiat());
    }
    
}
