package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0;i < handler.gameObjects.size(); i++){
            GameObject tempObject = (GameObject) handler.gameObjects.getAtIndex(i).data;

            if(tempObject.getId() == ID.Player){
                //key events for player 1
                //if(key == KeyEvent.VK_W) tempObject.setSpeedY(-5);
                //if(key == KeyEvent.VK_S) tempObject.setSpeedY(5);
                if(key == KeyEvent.VK_D) tempObject.setSpeedX(5);
                else if(key == KeyEvent.VK_A) tempObject.setSpeedX(-5);
            }
        }

        //if(key == KeyEvent.VK_ESCAPE) System.exit(1);

    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0;i < handler.gameObjects.size(); i++){
            GameObject tempObject = (GameObject) handler.gameObjects.getAtIndex(i).data;

            if(tempObject.getId() == ID.Player){
                //key events for player 1
                //if(key == KeyEvent.VK_W) tempObject.setSpeedY(0);
                //if(key == KeyEvent.VK_S) tempObject.setSpeedY(0);
                if(key == KeyEvent.VK_D) tempObject.setSpeedX(0);
                if(key == KeyEvent.VK_A) tempObject.setSpeedX(0);
            }
        }
    }
}
