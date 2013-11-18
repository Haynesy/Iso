package me.haynesy.iso;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: NewLease
 * Date: 11/11/13
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class InputHandler implements KeyListener {
    public boolean escape;
    public boolean up, right, down, left;

    private boolean[] keys;


    public InputHandler(){
        keys = new boolean[255];
        Arrays.fill(keys, false);
        up = false;
        right = false;
        down = false;
        left = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
            escape = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void update(){
        up = keys[KeyEvent.VK_W];
        right = keys[KeyEvent.VK_D];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
    }
}
