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
public abstract class Organizm {

    private final Swiat swiat;
    private int sila;
    private final int inicjatywa;
    private int pozycjaX;
    private int pozycjaY;
    private final char literka;
    private final boolean trujaca = false;
    private final int wiek;

    public void Wypisz() {
    }

    public Organizm(int sila, int inicjatywa, int pozycjaX, int pozycjaY, char literka, Swiat swiat) {
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.pozycjaX = pozycjaX;
        this.pozycjaY = pozycjaY;
        this.literka = literka;
        this.swiat = swiat;
        swiat.Dodaj(this);
        swiat.SetMapa(pozycjaX, pozycjaY, this);
        wiek = swiat.GetIloscTur();
    }
    public int GetWiek(){
        return this.wiek;
    }
    public int GetSila() {
        return this.sila;
    }

    public void SetSila(int sila) {
        this.sila = sila;
    }

    public int GetInicjatywa() {
        return this.inicjatywa;
    }

    abstract public Color Color();
    public int GetPozycjaX() {
        return this.pozycjaX;
    }

    public void SetPozycjaX(int pozycjaX) {
        this.pozycjaX = pozycjaX;
    }

    public int GetPozycjaY() {
        return this.pozycjaY;
    }

    public void SetPozycjaY(int pozycjaY) {
        this.pozycjaY = pozycjaY;
    }

    public char GetLiterka() {
        return this.literka;
    }

    public Swiat GetSwiat() {
        return this.swiat;
    }

    public boolean CzyTrujacy() {
        return this.trujaca;
    }

    abstract public void Akcja();

    abstract public void MakeChild(int pozycjax, int pozycjay);

    abstract public void Kolizja(Organizm wrog, boolean atakujacy);
    
    abstract protected Point CzyAkcje();

    public boolean CzyZwial() {
        return false;
    }

    public boolean CzyOdbil(Organizm wrog) {
        return false;
    }

    public boolean CzyZwierze() {
        return false;
    }

    public void Usuniecie(){
        this.swiat.Usun(this);
    }

    
}
