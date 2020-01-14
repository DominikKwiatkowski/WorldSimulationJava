/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.Organizmy;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import symulatorswiatajava.Ruch;
import static symulatorswiatajava.Ruch.*;
import symulatorswiatajava.swiat.Swiat;

/**
 *
 * @author domik
 */
public class Czlowiek extends Zwierzeta {

    Ruch ruch;
    int moc = -5;

    public Czlowiek(int pozycjaX, int pozycjaY, Swiat swiat) {
        super(5, 4, pozycjaX, pozycjaY, 'H', swiat);
    }

    public Czlowiek(int sila, int pozycjaX, int pozycjaY, Swiat swiat) {
        super(sila, 4, pozycjaX, pozycjaY, 'H', swiat);
    }

    @Override
    public java.awt.Color Color() {
        return Color.CYAN;
    }

    public void SetRuch(Ruch ruch) {
        this.ruch = ruch;
    }

    public void SetPower() {
        if (moc < -5) {
            moc = 4;
        }
    }

    @Override
    public void MakeChild(int pozycjax, int pozycjay) {

    }
    @Override
    public void Akcja(){
        if(this.moc>=0){
            this.SpalWszystko();
        }
        int pozx = this.GetPozycjaX();
        int pozy = this.GetPozycjaY();
        if(this.ruch==UP){
            pozx--;
        }
        else if(this.ruch==DOWN){
            pozx++;
        }
        else if(this.ruch==LEFT){
            pozy--;
        }
        else if(this.ruch==RIGHT){
            pozy++;
        }
        if(pozx<0){
            pozx=0;
        }
        else if(pozx>=this.GetSwiat().GetSzerokosc()){
            pozx--;
        }
        else if(pozy<0){
            pozy=0;
        }
        else if(pozy>=this.GetSwiat().GetDlugosc()){
            pozy--;
        }
        if(this.GetSwiat().GetMapa()[pozx][pozy] instanceof Ziemia){
            this.GetSwiat().SetMapa(this.GetPozycjaX(), this.GetPozycjaY(), new Ziemia(this.GetSwiat(), this.GetPozycjaX(), this.GetPozycjaY()));
            this.SetPozycjaX(pozx);
            this.SetPozycjaY(pozy);
            this.GetSwiat().SetMapa(this.GetPozycjaX(), this.GetPozycjaY(), this);
        }
        if(this.moc>=0){
            this.SpalWszystko();
        }
        moc--;
        this.ruch=NONE;
    }
    private void SpalWszystko() {
        ArrayList<Point> tab = this.GetSwiat().GetSasiadow(this);
        for (Point punkt : tab) {
            if (punkt.x >= 0) {
                if (!(this.GetSwiat().GetMapa()[punkt.x][punkt.y] instanceof Ziemia)) {
                    this.GetSwiat().GetMapa()[punkt.x][punkt.y].Usuniecie();
                    this.GetSwiat().SetMapa(punkt.x, punkt.y, new Ziemia(GetSwiat(), punkt.x, punkt.y));
                }
            }
        }
    }
}
