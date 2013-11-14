package me.haynesy.iso;

import me.haynesy.iso.entities.Entity;
import me.haynesy.iso.graphics.Bitmap;
import me.haynesy.iso.graphics.Screen;
import me.haynesy.iso.graphics.Tile;
import me.haynesy.iso.graphics.Tiles;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: NewLease
 * Date: 11/12/13
 * Time: 10:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class Level {

    private final int tileHeight;
    private final int tileWidth;
    private Screen screen;
    private int[][] map;
    private ArrayList<Entity> entities;

    public Level(Screen screen){
        this.screen = screen;
        entities = new ArrayList<Entity>();

        map = new int[][] {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1}
        };

        tileHeight = screen.height / map.length;
        tileWidth = screen.width / map[0].length;
        Tiles.Initialize(tileWidth, tileHeight);

        // Render grass over whole level
        screen.render(new Bitmap(screen.width, screen.height, Tiles.GRASS.pixels[0]), 0, 0);
    }

    public void render(){

        for(int y = 0; y < map.length; y++){
            for(int x = 0; x < map[0].length; x++){
                int tile = map[x][y];

                if(tile == Tile.GRASS)
                    screen.render(Tiles.GRASS, x * tileWidth, y * tileHeight);

                else if(tile == Tile.WALL)
                    screen.render(Tiles.WALL, x * tileWidth, y * tileHeight);

                else if(tile == Tile.HERO)
                    screen.render(Tiles.HERO, x * tileWidth, y * tileHeight);
            }
        }

    }

    public void update(InputHandler input) {

    }
}
