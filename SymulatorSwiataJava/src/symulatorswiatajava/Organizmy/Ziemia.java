/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.Organizmy;

import java.awt.Color;
import java.awt.Point;
import symulatorswiatajava.swiat.Swiat;

/**
 *
 * @author domik
 */
public class Ziemia extends Organizm{
    public Ziemia(Swiat swiat, int pozycjax, int pozycjay){
        super(0,0,pozycjax,pozycjay,' ', swiat);
    }
    @Override
    public Color Color(){
        return new Color(210,180,140);
    }

    @Override
    public void Akcja() {
        
    }

    @Override
    public void MakeChild(int pozycjax, int pozycjay) {
        
    }

    @Override
    public void Kolizja(Organizm wrog, boolean atakujacy) {
    }

    @Override
    protected Point CzyAkcje() {
        return null;
    }
}
