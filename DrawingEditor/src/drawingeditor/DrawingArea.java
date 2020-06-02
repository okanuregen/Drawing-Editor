/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingeditor;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author okan.uregen
 */
public class DrawingArea extends JPanel implements MouseMotionListener, MouseListener {

    static ArrayList<Shape> shapes;
    static int presX, presY, secX, secY;

    public DrawingArea() {

        addMouseListener(this);
        addMouseMotionListener(this);
        shapes = new ArrayList<>();

    }

    public void drawing() {
        repaint();
    }

    @Override
    public void paint(Graphics p) {

        super.paint(p);
        Graphics2D g = (Graphics2D) p;
        Rectangle tmp1;
        Circle tmp2;
        Line tmp3;
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof Rectangle) {
                tmp1 = (Rectangle) shapes.get(i);
                g.setColor(tmp1.getColor());
                if (tmp1.isFilled) {
                    g.fillRect(tmp1.x, tmp1.y, tmp1.w, tmp1.h);
                } else {
                    g.drawRect(tmp1.x, tmp1.y, tmp1.w, tmp1.h);
                }
            } else if (shapes.get(i) instanceof Circle) {
                tmp2 = (Circle) shapes.get(i);
                g.setColor(tmp2.getColor());
                if (tmp2.isFilled) {
                    g.fillOval(tmp2.x, tmp2.y, tmp2.w, tmp2.h);
                } else {
                    g.drawOval(tmp2.x, tmp2.y, tmp2.w, tmp2.h);
                }

            } else if (shapes.get(i) instanceof Line) {
                tmp3 = (Line) shapes.get(i);
                g.setColor(tmp3.getColor());
                g.setStroke(new BasicStroke(tmp3.getSize()));
                g.drawLine(tmp3.x, tmp3.y, tmp3.w, tmp3.h);
            }
        }

    }
    int i;
    boolean c = false;

    @Override
    public void mouseClicked(MouseEvent me) {

        if (DrawingEditor.remove) { //REMOVEING CONTROL
            for (int a = 0; a < shapes.size(); a++) {
                if (shapes.get(a).contains(me.getX(), me.getY())) {
                    shapes.remove(a);
                    repaint();
                    break;
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

        for (i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).contains(me.getX(), me.getY())) {
                presX = me.getX();
                presY = me.getY();
                c = true;
                break;
            }
        }
        presX = me.getX();
        presY = me.getY();
    }

    @Override
    public void mouseReleased(MouseEvent me) {

        if (DrawingEditor.currentTop == DrawingEditor.topLine) {
            secX = me.getX();
            secY = me.getY();
            if (!c) {
                shapes.add(new Line(presX, presY, secX, secY, DrawingEditor.lineCol, DrawingEditor.lineSize * 5));
            }
            repaint();
        }
        c = false;
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    public void removeAll() {
        shapes.clear();
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent me) {

        if (c == true) { //WHEN CLICK SOMEWHHERE, THERE IS A SHAPE
            int newX = (int) ((int) (me.getX() - presX) + shapes.get(i).getX());
            int newY = (int) ((int) (me.getY() - presY) + shapes.get(i).getY());
            shapes.get(i).move(newX, newY);
            repaint();
            presX = me.getX();
            presY = me.getY();
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

}
