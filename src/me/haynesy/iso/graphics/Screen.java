package me.haynesy.iso.graphics;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: NewLease
 * Date: 11/11/13
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Screen extends Bitmap {

    Random random;

    public Screen(BufferedImage screenImage) {
        super(screenImage);

        random = new Random();
    }

    public void clear(){
        Arrays.fill(pixels, 0xff343434);
    }

    public void update(){
        for(int i = 0; i < pixels.length; i++)
            pixels[i] = random.nextInt();
    }
}
