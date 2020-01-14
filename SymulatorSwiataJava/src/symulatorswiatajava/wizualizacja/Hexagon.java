/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorswiatajava.wizualizacja;

import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author domik
 */
public class Hexagon {
        private final int promien;

        private final Point srodek;

        private final Polygon hexagon;

        public Hexagon(Point srodek, int promien) {
            this.srodek = srodek;
            this.promien = promien;
            this.hexagon = createHexagon();
        }

        private Polygon createHexagon() {
            Polygon polygon = new Polygon();

            for (int i = 0; i < 6; i++) {
                int xval = (int) (srodek.x + promien
                        * Math.cos(i * 2 * Math.PI / 6D));
                int yval = (int) (srodek.y + promien
                        * Math.sin(i * 2 * Math.PI / 6D));
                polygon.addPoint(xval, yval);
            }

            return polygon;
        }

        public int getPromien() {
            return promien;
        }

        public Point GetSrodek() {
            return srodek;
        }

        public Polygon getHexagon() {
            return hexagon;
        }

    }
