package com.game.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;
    private int invincible = 50;
    private int rgbValue = 255;
    private int width = 80;
    private int height = 14;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public Rectangle getBounds(){
        return new Rectangle(x-4, y-4, width, height);
    }

    public void tick() {
        x += speedX;
        y += speedY;

        invincible--;
        rgbValue += 5;
        if(invincible < 0) invincible = 0;
        if(rgbValue >= 255) rgbValue = 255;
        x = Game.clamp(x, 0, Game.WIDTH - 38);
        y = Game.clamp(y, 0, Game.HEIGHT - 62);


    }

    public void render(Graphics g) {
        g.setColor(new Color(255,rgbValue,rgbValue));
        g.fillRect(x-4, y-4, width, height);

    }


}
