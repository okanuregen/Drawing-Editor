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
public class Shape {

    int x, y, w, h;
    Color color;
    boolean isFilled = false;

    public Shape(int x, int y, int w, int h, Color c) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = c;

    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean contains(int x, int y) {
        if (x > getX() && x < (getX() + getW())) {
            if (y > getY() && y < (getY() + getH())) {
                return true;
            }
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public Color getColor() {
        return color;
    }

}
