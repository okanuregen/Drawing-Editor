/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingeditor;

import java.awt.Color;

/**
 *
 * @author okan.uregen
 */
public class Line extends Shape {

    int size;
    float m; // slope

    public Line(int x, int y, int x2, int y2, Color c, int size) {
        super(x, y, x2, y2, c);
        this.size = size;
        if (x2 != x) {
            this.m = (float) (y2 - y) / (x2 - x); //slope for the equation
        } else {
            this.m = 1;
        }

    }

    @Override
    public void move(int x, int y) {

        this.w = (x - this.x) + this.w;  //w is x2
        this.h = (y - this.y) + this.h;  // h is y2
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean contains(int x, int y) {

        if ((this.w >= this.x) && (this.y >= this.h)) {
            if (x >= this.x && x <= this.w && y <= this.y && y >= this.h) {
                return control(x, y);
            }
        } else if ((this.w >= this.x) && (this.y <= this.h)) {
            if (x >= this.x && x <= this.w && y >= this.y && y <= this.h) {
                return control(x, y);
            }
        } else if ((this.x >= this.w) && (this.y >= this.h)) {
            if (x <= this.x && x >= this.w && y <= this.y && y >= this.h) {
                return control(x, y);
            }
        } else if ((this.x >= this.w) && (this.y <= this.h)) {
            if (x <= this.x && x >= this.w && y >= this.y && y <= this.h) {
                return control(x, y);
            }
        }
        return false;
    }

    public boolean control(float x, float y) {
        for (int i = -20; i < 20; i++) {
            if ((int) (this.y - (y + i)) == (int) (m * (this.x - x))) {          
                return true;
            }
        }
        for (int i = -20; i < 20; i++) {
            if ((int) (this.y - y) == (int) (m * (this.x - (x + i)))) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
