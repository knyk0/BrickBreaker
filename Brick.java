package com.game.main;

import java.awt.*;
import java.util.Random;

public class Brick extends GameObject {

    Random r = new Random();
    Handler handler;
    private final int width = 30;
    private final int height = 20;

    public Brick(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds(){
        return new Rectangle(x-4, y-4, width, height);
    }
    public Rectangle getTopSide(){
        return new Rectangle(x-4,y-4,width,1);
    }
    public Rectangle getLeftSide(){
        return new Rectangle(x-4,y-4,1,height);
    }
    public Rectangle getBottomSide(){
        return new Rectangle(x-4,y-4+height,width,1);
    }
    public Rectangle getRightSide(){
        return new Rectangle(x-4+width,y-4,1,height+1);
    }

    public void tick() {
        collision();
    }
    private void collision(){
        for(int i = 0; i < handler.gameObjects.size(); i++){
            GameObject tempObject = (GameObject) handler.gameObjects.getAtIndex(i).data;
            if(tempObject.getId() == ID.Ball){
                if(getLeftSide().intersects(((Ball)tempObject).getRightSide()) || getRightSide().intersects(((Ball)tempObject).getLeftSide())){
                    handler.removeObject(this);
                    tempObject.speedX *= -1;
                }
                else if(getTopSide().intersects(((Ball)tempObject).getBottomSide()) || getBottomSide().intersects(((Ball)tempObject).getTopSide())){
                    handler.removeObject(this);
                    tempObject.speedY *= -1;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(x-3, y-4, width, height);
        /*
        g.setColor(Color.red);
        g.drawRect(x-4,y-3,width,1);
        g.drawRect(x-4,y-3,1,height);
        g.drawRect(x-4,y-4+height,width,1);
        g.drawRect(x-4+width,y-2,1,height-3);
        */

    }


}
