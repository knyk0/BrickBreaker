package com.game.main;

import java.awt.*;

public class Ball extends GameObject{

    private Handler handler;
    private int collided = 0;
    private int width = 16;
    private int height = 16;

    public Ball(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        speedX = 2;
        speedY = 2;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 16, 16);
    }
    public Rectangle getTopSide(){
        return new Rectangle(x,y,width,1);
    }
    public Rectangle getLeftSide(){
        return new Rectangle(x,y,1,height);
    }
    public Rectangle getBottomSide(){
        return new Rectangle(x,y+height-1,width,1);
    }
    public Rectangle getRightSide(){
        return new Rectangle(x+width,y,1,height);
    }
    private void collision(){
        for(int i = 0; i < handler.gameObjects.size(); i++){

            GameObject tempObject = (GameObject) handler.gameObjects.getAtIndex(i).data;

            if(tempObject.getId() == ID.Player){
                if(getBounds().intersects(tempObject.getBounds())){
                    if(collided == 0)
                        speedY *= -1;
                    collided = 10;
                }
            }
        }
    }

    public void tick() {
        x += speedX;
        y += speedY;

        if(y <= 0 || y >= Game.HEIGHT - 45) speedY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 15) speedX *= -1;

        if(collided > 0)
            collided--;

        collision();
    }

    public void render(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
        /*
        g.setColor(Color.red);
        g.drawRect(x,y,width,1);
        g.drawRect(x,y,1,height);
        g.drawRect(x,y+height-1,width,1);
        g.drawRect(x+width,y,1,height);
        */

    }
}
