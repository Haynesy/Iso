package me.haynesy.iso.entities;

import me.haynesy.iso.graphics.Bitmap;

/**
 * Created with IntelliJ IDEA.
 * User: NewLease
 * Date: 11/14/13
 * Time: 8:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class Entity {

    Bitmap texture;
    public int x;
    public int y;
    public double speed; // in pixels

    public Entity(){
        x = 0;
        y = 0;
        speed = 0.0;
    }
}
