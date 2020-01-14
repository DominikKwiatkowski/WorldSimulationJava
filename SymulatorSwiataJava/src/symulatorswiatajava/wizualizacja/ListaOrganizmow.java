/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.wizualizacja;

import java.awt.Point;
import symulatorswiatajava.Organizmy.*;
import symulatorswiatajava.swiat.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListaOrganizmow extends JFrame {
    private JList<String> orgList;
    private Swiat swiat;
    private Point poz;
    private JFrame frame;
    public ListaOrganizmow(Swiat swiat, Point poz){
        this.swiat = swiat;
        this.poz = poz;
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Antylopa");
        model.addElement("Lis");
        model.addElement("Owca");
        model.addElement("Zolw");
        model.addElement("Wilk");
        model.addElement("Trawa");
        model.addElement("Guaryna");
        model.addElement("Barszcz Sosnowskiego");
        model.addElement("Mlecz");
        model.addElement("Wilcze Jagody");

        orgList = new JList<>(model);
        orgList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        orgList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                switch(orgList.getSelectedValue()) {
                    case "Antylopa":
                       new Antylopa(poz.x,poz.y,swiat);
                        break;
                    case "Lis":
                        new Lis(poz.x,poz.y,swiat);
                        break;
                    case "Owca":
                        new Owca(poz.x,poz.y,swiat);
                        break;
                    case "Zolw":
                        new Zolw(poz.x,poz.y,swiat);
                        break;
                    case "Wilk":
                        new Wilk(poz.x,poz.y,swiat);
                        break;
                    case "Guaryna":
                        new Guaryna(poz.x,poz.y,swiat);
                        break;
                    case "Trawa":
                        new Trawa(poz.x,poz.y,swiat);
                        break;
                    case "Barszcz Sosnowskiego":
                        new BarszczSosnowskiego(poz.x,poz.y,swiat);
                        break;
                    case "Mlecz":
                        new Mlecz(poz.x,poz.y,swiat);
                        break;
                    case "Wilcze Jagody":
                       new WilczaJagoda(poz.x,poz.y,swiat);
                        break;
                }
                swiat.frame.repaint();
            SwingUtilities.getWindowAncestor(orgList).setVisible(false);
            }

        });
        add(orgList);
        setTitle("List of organisms");
        orgList.setSize(400,400);
        setSize(400,400);
        setVisible(true);

    }
}