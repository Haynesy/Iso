package me.haynesy.iso.graphics;

/**
 * Created with IntelliJ IDEA.
 * User: NewLease
 * Date: 11/13/13
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tiles {

    public static Tile GRASS = null;
    public static Tile WALL = null;
    public static Tile HERO = null;

    public Tiles(){

    }

    public static void Initialize(int width, int height){
        if(GRASS == null)
            GRASS = new Tile(width, height, true, 0xff45ef45);
        if(WALL == null)
            WALL = new Tile(width, height, false, 0xff121212);
        if(HERO == null)
            HERO = new Tile(width - 4, height - 4, false, 0xffef4545);
    }
}
