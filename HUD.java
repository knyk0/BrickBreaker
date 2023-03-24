package com.game.main;

import java.awt.*;

public class HUD {

    private static int maxHealth = 100;
    public static int HEALTH = 100;
    private int greenValue = 255;

    private int score = 0;
    private int level = 1;

    public void tick(){
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = 250 * HEALTH / 100;

        greenValue = HEALTH * 2;

        score++;
    }

    public void render(Graphics g){
        /*
        g.setFont(new Font( "SansSerif", Font. TYPE1_FONT, 12 ));
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(100,greenValue,0));
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);
        */

        /*
        g.drawString("Score: "+ score, 15,64);
        g.drawString("Level: "+ level, 15,80);
        g.drawString(HEALTH +"/"+maxHealth,224,32);
         */
    }

    public void score(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

}
