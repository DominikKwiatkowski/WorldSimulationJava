/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.swiat;

import symulatorswiatajava.Organizmy.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author domik
 */
abstract public class Swiat {

    private int dlugosc, szerokosc;
    private int iloscTur;
    private Organizm[][] mapa;
    private LinkedList<Organizm> listaOrganizmow = new LinkedList<>();
    public JFrame frame;
    private Logi logi;
    private Czlowiek czlowiek;

    private void OczyscListe() {
        while (listaOrganizmow.remove(null));
    }

    private void OczyscMape() {
        for (int i = 0; i < this.GetDlugosc(); i++) {
            for (int j = 0; j < this.GetSzerokosc(); j++) {
                if (this.GetMapa()[i][j].GetPozycjaX() != i || this.GetMapa()[i][j].GetPozycjaY() != j) {
                    this.GetMapa()[i][j].Usuniecie();
                    this.GetMapa()[i][j] = new Ziemia(this, i, j);
                }
            }
        }
        for (int i = 0; i < this.listaOrganizmow.size(); i++) {
            if (this.listaOrganizmow.get(i) != null) {
                if (this.GetMapa()[this.listaOrganizmow.get(i).GetPozycjaX()][this.listaOrganizmow.get(i).GetPozycjaY()] != this.listaOrganizmow.get(i)) {
                    if (this.GetMapa()[this.listaOrganizmow.get(i).GetPozycjaX()][this.listaOrganizmow.get(i).GetPozycjaY()].GetSila() >= this.listaOrganizmow.get(i).GetSila()) {
                        this.listaOrganizmow.get(i).Usuniecie();
                    } else {
                        this.GetMapa()[this.listaOrganizmow.get(i).GetPozycjaX()][this.listaOrganizmow.get(i).GetPozycjaY()].Usuniecie();
                        this.GetMapa()[this.listaOrganizmow.get(i).GetPozycjaX()][this.listaOrganizmow.get(i).GetPozycjaY()] = this.listaOrganizmow.get(i);
                    }
                }
            }
        }
    }

    abstract public void Wypisz();

    public Swiat(int dlugosc, int szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.iloscTur = 0;
        this.mapa = new Organizm[dlugosc][szerokosc];
        for (int i = 0; i < dlugosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                mapa[i][j] = new Ziemia(this, i, j);
            }
        }
        logi = new Logi();
        this.czlowiek = new Czlowiek(dlugosc / 2, szerokosc / 2, this);
    }

    abstract public ArrayList<java.awt.Point> GetSasiadow(Organizm org);

    public void PrzeprowadzTure() {
        iloscTur++;
        System.out.println("przeprowadzam ture");
        for (int i = 0; i < this.listaOrganizmow.size(); i++) {
            if (this.listaOrganizmow.get(i) != null && this.iloscTur > this.listaOrganizmow.get(i).GetWiek()) {
                this.listaOrganizmow.get(i).Akcja();
            }
        }
        this.OczyscListe();
        this.OczyscMape();
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public Organizm[][] GetMapa() {
        return mapa;
    }

    public Czlowiek GetCzlowiek() {
        return this.czlowiek;
    }

    public void SetMapa(int pozycjax, int pozycjay, Organizm organizm) {
        this.mapa[pozycjax][pozycjay] = organizm;
    }

    public void Dodaj(Organizm org) {
        if (org instanceof Ziemia) {
            return;
        }
        if (this.listaOrganizmow.size() == 0) {
            this.listaOrganizmow.add(org);
            return;
        }
        if (org instanceof Rosliny) {
            this.listaOrganizmow.add(org);
            return;
        }
        for (int i = 0; i < this.listaOrganizmow.size(); i++) {
            if (org.GetInicjatywa() > this.listaOrganizmow.get(i).GetInicjatywa()) {
                this.listaOrganizmow.add(i, org);
                return;
            } else {
                if (i == this.listaOrganizmow.size() - 1) {
                    this.listaOrganizmow.add(org);
                    return;
                }
            }
        }
    }

    public void Usun(Organizm org) {
        if (org instanceof Wilk) {
            int a = 0;
        }
        if (this.listaOrganizmow.indexOf(org) >= 0) {
            this.listaOrganizmow.remove(this.listaOrganizmow.indexOf(org));
        } else {
            int a = 0;
        }
    }

    public LinkedList<Organizm> GetPocz() {
        return this.listaOrganizmow;
    }

    public int GetDlugosc() {
        return dlugosc;
    }

    public int GetSzerokosc() {
        return szerokosc;
    }

    public int GetIloscTur() {
        return iloscTur;
    }

    public Logi GetLog() {
        return this.logi;
    }

    public void Zapisz() throws IOException {
        try {
            String path = ".\\src\\symulatorswiatajava\\zapis\\zapis.txt";
            File file = new File(path);
            file.delete();
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            PrintWriter pisacz = new PrintWriter(writer);
            pisacz.printf("%d ", this.GetDlugosc());
            pisacz.printf("%d ", this.GetSzerokosc());
            pisacz.printf("%d ", this.GetIloscTur());
            for (Organizm org : this.listaOrganizmow) {
                writer.write(org.GetLiterka());
                pisacz.printf(" ");
                pisacz.printf("%d ", org.GetSila());
                pisacz.printf("%d ", org.GetPozycjaX());
                pisacz.printf("%d ", org.GetPozycjaY());
            }
            pisacz.close();
            writer.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void WczytarOrganizm(char literka, int sila, int pozycjax, int pozycjay) {
        switch (literka) {
            case 'w':
                new Wilk(sila, pozycjax, pozycjay, this);
                break;
            case 'a':
                new Antylopa(sila, pozycjax, pozycjay, this);
                break;
            case 'g':
                new Guaryna(pozycjax, pozycjay, this);
                break;
            case 'l':
                new Lis(sila, pozycjax, pozycjay, this);
                break;
            case 'b':
                new BarszczSosnowskiego(pozycjax, pozycjay, this);
                break;
            case 'm':
                new Mlecz(pozycjax, pozycjay, this);
                break;
            case 'o':
                new Owca(sila, pozycjax, pozycjay, this);
                break;
            case 't':
                new Trawa(pozycjax, pozycjay, this);
                break;
            case 'z':
                new Zolw(sila, pozycjax, pozycjay, this);
                break;
            case 'j':
                new WilczaJagoda(pozycjax, pozycjay, this);
                break;
            case 'H':
                this.czlowiek = new Czlowiek(sila, pozycjax, pozycjay, this);
                break;
            default:
                break;
        }
    }

    public void Wczytaj() throws IOException {
        frame.setVisible(false);
        this.listaOrganizmow.clear();
        mapa = null;
        logi = null;
        BufferedReader reader = new BufferedReader(new FileReader(".\\src\\symulatorswiatajava\\zapis\\zapis.txt"));
        String line = reader.readLine();
        String[] elements = line.split(" ");
        szerokosc = Integer.parseInt(elements[0]);
        dlugosc = Integer.parseInt(elements[1]);
        iloscTur = Integer.parseInt(elements[2]);
        mapa = new Organizm[dlugosc][szerokosc];
        for (int i = 0; i < dlugosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                mapa[i][j] = new Ziemia(this, i, j);
            }
        }
        for (int i = 3; i < elements.length; i += 4) {
            this.WczytarOrganizm(elements[i].charAt(0), Integer.parseInt(elements[i + 1]), Integer.parseInt(elements[i + 2]), Integer.parseInt(elements[i + 3]));
        }
        logi = new Logi();
        reader.close();
        this.Wypisz();
    }

}
