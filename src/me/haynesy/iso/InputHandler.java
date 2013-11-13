package me.haynesy.iso;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created with IntelliJ IDEA.
 * User: NewLease
 * Date: 11/11/13
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class InputHandler implements KeyListener {
    public boolean escape;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(KeyEvent.VK_ESCAPE == e.getKeyCode())
            escape = true;

    }
}
