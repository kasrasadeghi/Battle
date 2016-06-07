package com.kaz.fight;

import com.kaz.fight.kMath.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.kaz.fight.kMath.Vec2.PI;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

/**
 * Created by kasra on 5/31/2016.
 */
public class View extends JPanel{
    private Game game;
    private Vec2 v = new Vec2(200, 200);
    private double theta = PI/2;

    public View(Dimension size, Game game) {
        setPreferredSize(size);
        this.game = game;
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rotate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void rotate() {
        v.rotate(theta);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        Double time = game.getTime();
        g.setColor(new Color(216, 218, 0));
        g.drawString(time + "", 50, 50);

        g.setColor(Color.WHITE);

        //paint grid
        Point c = new Point(getWidth()/2, getHeight()/2);
        g.drawLine(0, c.y, getWidth(), c.y);
        g.drawLine(c.x, 0, c.x, getHeight());

        //label x-axis
        for (int i = -10; i < 25; ++i) {
            g.drawLine(c.x + i * 100, c.y, c.x + i * 100, c.y - 25);
            g.drawString(i * 100 + "", c.x + i * 100, c.y);
        }
        for (int i = -100; i < 255; ++i) {
            g.drawLine(c.x + i * 25, c.y, c.x + i * 25, c.y - 10);
        }
        //label y-axis
        for (int i = 10; i > -25; --i) {
            if (i == 0 ) continue;
            g.drawLine(c.x, c.y + i * 100, c.x + 25, c.y + i * 100);
            g.drawString((i * 100 < 0)? "" + -i * 100: "-" + i * 100, c.x, c.y + i * 100);
        }
        for (int i = -100; i < 255; ++i) {
            g.drawLine(c.x, c.y + i * 25, c.x + 10, c.y + i * 25);
        }


        //region test dRect
//        dRect test = new dRect(100, 100, 25, 25);
//        g.drawString(test.toString(), 50, 100);
//
//        dRect test2 = test.copy().rotate(PI/4);
//        g.drawString(test2.toString(), 50, 150);
//
//        List<dRect> list = new ArrayList<>();
//        int i = 0;
//        list.add(test);
//        list.add(test2);
//
//        List<Color> colors = new ArrayList<>();
//        Collections.addAll(colors, Color.BLUE, Color.RED);
//        ListIterator<Color> iter = colors.listIterator();
//        //draw dRect
//        list.forEach(t -> {
//            if (iter.hasNext()) g.setColor(iter.next());
//            else {
//                while(iter.hasPrevious()) iter.previous();
//                g.setColor(iter.next());
//            }
//
//            t.translate(new Vec2(getWidth()/2, getHeight()/2));
//
//            Point p1 = t.p1.point();
//            Point p2 = t.p2.point();
//            Point p3 = t.p3.point();
//            Point p4 = t.p4.point();
//
//            g.drawLine(p1.x, p1.y, p2.x, p2.y);
//            g.drawLine(p2.x, p2.y, p3.x, p3.y);
//            g.drawLine(p3.x, p3.y, p4.x, p4.y);
//            g.drawLine(p4.x, p4.y, p1.x, p1.y);
//        });
        //endregion

        //region test Vec2

        if (g.getColor() == Color.RED) g.setColor(Color.BLUE);
        else g.setColor(Color.RED);

        Vec2 ov = v.copy();

        ov.y *= -1;
        ov.add(new Vec2(getWidth()/2, getHeight()/2));
        g.drawLine(getWidth()/2, getHeight()/2, ov.intx(), ov.inty());
        g.drawString(v.toString(), 50, 100 + 20);

        g.setColor(new Color(0, 200, 0));
        g.drawString(String.format("[ %.3f, %.3f ]",Math.cos(theta), -Math.sin(theta)), 50, 100 + 40);
        g.drawString(String.format("[ %.3f, %.3f ]", Math.sin(theta), Math.cos(theta)), 50, 100 + 55);
        double[][] matrix = new double[][] {
                new double[] {cos(theta), -sin(theta)},
                new double[] {sin(theta),  cos(theta)}
        };

        g.drawString(String.format("[ %.3f, %.3f ]",matrix[0][0], matrix[0][1]), 50, 100 + 80);
        g.drawString(String.format("[ %.3f, %.3f ]",matrix[1][0], matrix[1][1]), 50, 100 + 95);

        int y = 220;
        g.drawString(String.format("x' = %.3f * %.3f + %.3f * %.3f", v.x, matrix[0][0], v.y, matrix[0][1]), 50, y);
        g.drawString(String.format("y' = %.3f * %.3f + %.3f * %.3f", v.x, matrix[1][0], v.y, matrix[1][1]), 50, y += 15);
        g.drawString(String.format("<x', y'> is estimated to be <%d, %d>",
                (int)( v.x* matrix[0][0]+ v.y* matrix[0][1]),
                (int) (v.x* matrix[1][0]+ v.y* matrix[1][1])
        ), 50, y+=15);

        //endregion

        //paint arena

        Arena arena = game.getArena();
    }

    public void render() {
        repaint();
    }
}
