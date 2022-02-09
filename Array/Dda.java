public package computergraphics;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import java.util.*;

public class Dda extends Applet {

    BufferedImage image = new BufferedImage(100, 150, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = image.getRaster();
    int array[] = {250, 0, 0, 250};

    public void init() {
        setSize(800, 800);
    }

    public void paint(Graphics g) {
        double dx, dy, x, y;
        int k;
        double xc, yc;
        double x1 = 20, y1 = 50, x2 = 60, y2 = 70;

        dx = x2 - x1;
        dy = y2 - y1;

        double m = dy / dx;

        if (m <= 1) {
            xc = 1;
            yc = m;
        } else {
            xc = 1 / m;
            yc = 1;
        }

        x = x1;
        y = y1;
        raster.setPixel((int) Math.round(x), (int) Math.round(y), array);
        System.out.println("k = 0 : " + (int) Math.round(x) + " , " + (int) Math.round(y));

        for (k = 1; k <= dx; k++) {
            x += xc;
            y += yc;
            raster.setPixel((int) Math.round(x), (int) Math.round(y), array);
            System.out.println("k = " + k + " : " + (int) Math.round(x) + " , " + (int) Math.round(y));
        }
        g.drawImage(image, 0, 0, this);
    }
}
