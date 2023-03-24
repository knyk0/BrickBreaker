package com.game.main;

import java.awt.*;


public class Handler {

    SinglyLinkedList<GameObject> gameObjects = new SinglyLinkedList<>();

    public void tick(){
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject tempObject = (GameObject) gameObjects.getAtIndex(i).data;
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject tempObject = (GameObject) gameObjects.getAtIndex(i).data;
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.gameObjects.insertFirst(object);
    }

    public void removeObject(GameObject object){
        this.gameObjects.deleteLink(object);
    }
}
