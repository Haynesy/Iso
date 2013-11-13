package me.haynesy.iso.graphics;

/**
 * Created with IntelliJ IDEA.
 * User: NewLease
 * Date: 11/12/13
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tile extends Bitmap {
    boolean walkable = true;

    public static int GRASS = 0;
    public static int WALL = 1;
    public static int HERO = 2;

    public Tile(int width, int height, boolean walkable, int color){
        super(width, height, color);

        this.walkable = walkable;
    }
}


