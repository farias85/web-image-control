/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.cenpis.gps.wic.main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farias-i5
 */
class ColoredCircle implements Serializable {

    private int x;
    private int y;

    public ColoredCircle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class DeepCopy {

    static public void main(String[] args) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            // create original serializable object
            ColoredCircle c1 = new ColoredCircle(100, 100);
            // print it
            System.out.println("Original = " + c1);

            // deep copy
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // serialize and pass the object
            oos.writeObject(c1);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            // return the new object
            ColoredCircle c2 = (ColoredCircle) ois.readObject();

            // verify it is the same
            System.out.println("Copied   = " + c2);
            // change the original object's contents
            c1.setX(200);
            c1.setY(200);
            // see what is in each one now
            System.out.println("Original = " + c1);
            System.out.println("Copied   = " + c2);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Exception in main = " + e);
        } finally {
            try {
                oos.close();
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(DeepCopy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
