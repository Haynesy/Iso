package me.haynesy.iso;

import me.haynesy.iso.graphics.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: NewLease
 * Date: 11/11/13
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class App extends Canvas implements Runnable{
    private static Thread thread;
    private boolean running;
    private BufferedImage screenImage;
    private Screen screen;
    private Level level;

    private static int WIDTH = 240;
    private static int HEIGHT = 200;
    private static int SCALE = 2;
    private InputHandler input;

    public App(){
        setFocusable(true);
    }

    public static void start() {

        JFrame frame = new JFrame("App");

        Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);

        App app = new App();
        frame.setSize(size);
        frame.setSize(size);
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(app);
        frame.pack();

        frame.setVisible(true);

        thread = new Thread(app, "App");
        thread.start();

    }
    @Override
    public void run() {

        init();

        int frames = 0;
        double nsPerFrame = 1000000000.0 / 60.0;
        long lastFrameTime = System.nanoTime();
        long lastFrame = System.currentTimeMillis();
        double unProcessedTime = 0;


        running = true;
        while(running){

            long now = System.nanoTime();
            unProcessedTime += (now - lastFrameTime) / nsPerFrame;
            lastFrameTime = now;

            while(unProcessedTime >= 1){
                unProcessedTime -= 1;

                tick();
                render();
                frames++;

            }

            if(System.currentTimeMillis() >= lastFrame + 1000){

                System.out.println("fps: "+ frames);
                lastFrame += 1000;
                frames = 0;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            swap();
        }
        destroy();
    }

    private void destroy() {

        System.out.println("Done!");
        System.exit(0);
    }

    private void init() {
        if(getBufferStrategy() == null)
            createBufferStrategy(3);

        screenImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        screen = new Screen(screenImage);
        input = new InputHandler();
        addKeyListener(input);

        level = new Level(screen);
    }

    private void render() {

        BufferStrategy strategy = getBufferStrategy();
        Graphics graphics = strategy.getDrawGraphics();

        graphics.drawImage(screenImage, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);

        strategy.show();
        graphics.dispose();
    }

    private void tick() {
        input.update();
        level.update(input);

        if(input.escape)
            running = false;

        screen.clear();
        level.render();
        //screen.update();
    }

    private void swap() {
        //To change body of created methods use File | Settings | File Templates.
    }
}
