package me.haynesy.iso.graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: NewLease
 * Date: 11/11/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bitmap {
    public int[] pixels;
    public int width, height;
    public int x, y;

    public Bitmap(BufferedImage image) {
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
        width = image.getWidth();
        height = image.getHeight();
        x = 0;
        y = 0;

        System.out.println("Pixels Length: "+ pixels.length);
    }

    public Bitmap(int width, int height, int defaultColor) {
        pixels = new int[width * height];
        Arrays.fill(pixels, defaultColor);

        this.width = width;
        this.height = height;
        x = 0;
        y = 0;
    }

    public void render(Bitmap bitmap, int offsetX, int offsetY){

        // Establish bounds
        int xStart = bitmap.x;
        int yStart = bitmap.y;
        int xEnd = xStart + bitmap.width;
        int yEnd = yStart + bitmap.height;

        // Bounds check
        if(xStart < 0) xStart = 0;
        if(yStart < 0) yStart = 0;
        if(xEnd > width) xEnd = width;
        if(yEnd > height) yEnd = height;

        // Render
        for(int y = yStart; y < yEnd; y++){
            for(int x = xStart; x < xEnd; x++){

                // Get color
                int color = bitmap.pixels[y * bitmap.width + x];

                // Use offset to get target position
                int target = (y + offsetY) * width + (x + offsetX);

                // If position is valid add color
                if(target < pixels.length)
                    pixels[target] = color;
            }
        }

    }
}
