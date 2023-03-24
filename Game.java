package com.game.main;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

    public static int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean running = false;

    private Random r;
    private Handler handler;
    private HUD hud;

    public Game(){

        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Game1", this);

        hud = new HUD();
        r = new Random();

        for(int i = 0;i < 10;i++){
            handler.addObject(new Brick(i*40, HEIGHT/2 - 40,ID.Brick,handler));
        }
        handler.addObject(new Ball(WIDTH/2 - 32, 20, ID.Ball, handler));
        handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2 + 196, ID.Player, handler));
    }
    public synchronized void start(){
        thread = new Thread(this);
        running = true;
        thread.start();
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
    public void run(){
        this.requestFocus();
        long before = System.nanoTime();
        double ticks = 60.0;
        double nano = 1000000000 / ticks;
        double i = 0;
        while(running){
            long current = System.nanoTime();
            i += (current - before) / nano;
            before = current;
            while(i >= 1){
                tick();
                i--;
            }
            if(running)
                render();
        }
        stop();
    }

    private void tick(){
            handler.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max){
        if(var >= max)
            return max;
        else if(var <= min)
            return min;
        else
            return var;
    }

    public static void main(String args[]){
        new Game();
    }
}
