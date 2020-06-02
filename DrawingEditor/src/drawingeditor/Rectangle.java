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
public class Rectangle extends Shape {

    public Rectangle(int x, int y, int w, int h,Color c, int f) {
       super(x, y, w, h, c);
        if (f == 1) {
            isFilled = true;
        }
    }
}
