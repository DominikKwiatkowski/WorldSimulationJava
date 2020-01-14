/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.wizualizacja;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import symulatorswiatajava.Organizmy.*;
import symulatorswiatajava.swiat.*;
/**
 *
 * @author domik
 */
public class MenuWyboru extends JPanel implements KeyListener, ActionListener {
    private final Swiat swiat;
    private Ekran ekran;
    public MenuWyboru(Swiat swiat, Ekran ekran) {
        //        repaint();
        this.swiat = swiat;
        this.ekran= ekran;
        repaint();
        AddButtons();
    }
        private void PrintColors(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(100, 50, 30,30);
        g.setColor(new Color(110, 76, 211));
        g.fillRect(100, 100, 30,30);
        g.setColor(Color.RED);
        g.fillRect(100, 150, 30,30);
        g.setColor(Color.YELLOW);
        g.fillRect(100, 200, 30,30);
        g.setColor(Color.magenta);
        g.fillRect(100, 250, 30,30);
        g.setColor(Color.GRAY);
        g.fillRect(100, 300, 30,30);
        g.setColor(Color.ORANGE);
        g.fillRect(100, 400, 30,30);
        g.setColor(Color.WHITE);
        g.fillRect(100, 450, 30,30);
        g.setColor(new Color(0, 51, 0));
        g.fillRect(100, 500, 30,30);
        g.setColor(Color.BLACK);
        g.fillRect(100, 550, 30,30);
        g.setColor(Color.CYAN);
        g.fillRect(100,350, 30,30);

    }
    private void PrintLabels(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN,25));
        g.drawString("Trawa", 150, 75);
        g.drawString("Guaryna", 150, 125);
        g.drawString("Barszcz Sosnowskiego", 150, 175);
        g.drawString("Mlecz",150,225);
        g.drawString("Wilcze Jagody",150,275);
        g.drawString("Antylopa",150,325);
        g.drawString("Lis",150,425);
        g.drawString("Owca",150,475);
        g.drawString("Zolw",150,525);
        g.drawString("Wilk",150,575);
        g.drawString("Czlowiek",150,375);

    }
    private void AddButtons() {

        //Button's initializations
        JButton nextT = new JButton("N Tura");
        JButton save = new JButton("Zapisz");
        JButton load = new JButton("Wczytaj");
        JButton logi = new JButton(("Logi"));
        //Action listeners
        nextT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swiat.PrzeprowadzTure();
                System.out.println("Przycisk nastepnej tury");
                ekran.requestFocus();
            }
        });
        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                swiat.Zapisz();
                }
                catch(IOException ie){
                }
                System.out.println("Zapisuje");
                ekran.requestFocus();
            }
        });
        load.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                swiat.Wczytaj();
                }
                catch(IOException ie){
                }
                System.out.println("Wczytuje");
                ekran.requestFocus();
            }
        });
        logi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JFrame textArea = new JFrame();
                JPanel panel = new JPanel();
                JTextArea area = new JTextArea(swiat.GetLog().Wypisz(), 1000, 50);
                JScrollPane scroll = new JScrollPane(area);
                scroll.setVisible(true);
                area.setEditable(false);
                area.setLineWrap(true);
                area.setWrapStyleWord(true);
                textArea.getContentPane().add(scroll, BorderLayout.EAST);
                textArea.add(panel);
                textArea.setSize(1000, 500);
                textArea.setVisible(true);
                ekran.requestFocus();
            }
        });
        //button's sizes
        nextT.setPreferredSize(new Dimension(100, 50));
        save.setPreferredSize(new Dimension(100, 50));
        load.setPreferredSize(new Dimension(100, 50));
        logi.setPreferredSize(new Dimension(100, 50));
        
        //Adding buttons to menu
        add(nextT);
        add(save);
        add(load);
        add(logi);
        //setting buttons visible - not working ?
        nextT.setVisible(true);
        save.setVisible(true);
        load.setVisible(true);
        logi.setVisible(true);
        
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        PrintColors(g);
        PrintLabels(g);
    }
    @Override
     public void actionPerformed(ActionEvent e){
        repaint();
    }
    @Override
    public void keyPressed(KeyEvent e){
        swiat.PrzeprowadzTure();
    }
    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyReleased(KeyEvent e){}
}
