/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.swiat;

import java.util.LinkedList;
import symulatorswiatajava.Organizmy.*;

/**
 *
 * @author domik
 */
public class Logi {
    private LinkedList<String> log = new LinkedList<>();
    private String Tlumacz(Organizm org){
        switch (org.GetLiterka())
	{
	case 'w':
		return "wilk";
	case 'a':
		return "antylopa";
	case'g':
		return "guarana";
	case 'l':
		return "lis";
	case 'b':
		return "barszcz sosnowskiego";
	case 'm':
		return "mlecz";
	case 'o':
		return "owca";
	case 't':
		return "trawa";
	case 'z':
		return "zolw";
	case 'j':
		return "wilcza jagoda";
	case 'H':
		return "czlowiek";
	default:
		return "dziwadlo";
	}
    }
    private void UsunLogi(){
        while(log.size()>100){
            log.removeLast();
        }
    }
    public void DodajLog(String log){
        this.log.add(log);
        this.UsunLogi();
    }
    public void Stworz(Organizm org1, Organizm org2){
        if(org1 instanceof Rosliny){
            this.Zjedzenie(org2, org1);
        }
        else if(org2 instanceof Rosliny){
            this.Zjedzenie(org1, org2);
        }
        else if(org1.GetSila()>=org2.GetSila()){
            this.Walka(org1, org2);
        }
        else{
            this.Walka(org2, org1);
        }
    }
    private void Zjedzenie (Organizm zwyciezca, Organizm zjedzony){
        String zwynas = this.Tlumacz(zwyciezca);
        String zwyzje = this.Tlumacz(zjedzony);
        StringBuilder tekst = new StringBuilder("");
        tekst.append(zwynas);
        tekst.append(" zjadl ");
        tekst.append(zwyzje);
        DodajLog(tekst.toString());
    }
    private void Walka (Organizm zwyciezca, Organizm zjedzony){
        String zwynas = this.Tlumacz(zwyciezca);
        String zwyzje = this.Tlumacz(zjedzony);
        StringBuilder tekst = new StringBuilder("");
        tekst.append(zwynas);
        tekst.append(" walczyl z ");
        tekst.append(zwyzje);
        tekst.append(" w konsekwencji ja zjadl");
        DodajLog(tekst.toString());
    }
    public void Zbarszczowanie(Organizm org){
        String orgt = Tlumacz(org);
         StringBuilder tekst = new StringBuilder("");
         tekst.append(orgt);
         tekst.append(" zostal zbarszczowany");
         DodajLog(tekst.toString());
    }
    public String Wypisz(){
        StringBuilder tekst = new StringBuilder("");
        for (String logi : log) {
            tekst.append(logi);
            tekst.append("\n");
        }
        return tekst.toString();
    }
}
