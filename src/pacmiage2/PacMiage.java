/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmiage2;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Alexandre
 */
public class PacMiage {

    private float x = 416, y = 200;
    private int direction = 0;
    private int futurDirection = 0;

    private boolean moving = false;
    private Animation[] animations = new Animation[8];
    private boolean onStair = false;
    private int vitesse = 2;

    private Map map;

    public PacMiage(Map map) {
        this.map = map;
    }

    public void init() throws SlickException {
        SpriteSheet spriteSheet = new SpriteSheet("./src/ressources/image/personnage/pacManMove.png", 32, 32);
        this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
        this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
        this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
        this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
        this.animations[4] = loadAnimation(spriteSheet, 1, 6, 0);
        this.animations[5] = loadAnimation(spriteSheet, 1, 6, 1);
        this.animations[6] = loadAnimation(spriteSheet, 1, 6, 2);
        this.animations[7] = loadAnimation(spriteSheet, 1, 6, 3);
    }

    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }

    public void render(Graphics g) throws SlickException {
        g.drawAnimation(animations[direction + (moving ? 4 : 0)], x, y);
    }

    public void update(int delta) {
        if (this.moving) {
            float futurX = getFuturX(vitesse, this.direction);
            float futurY = getFuturY(vitesse, this.direction);
            float futurXDir = getFuturX(vitesse, this.futurDirection);
            float futurYDir = getFuturY(vitesse, this.futurDirection);
            float futurX1Dir = getFuturX1(vitesse, this.futurDirection);
            float futurY1Dir = getFuturY1(vitesse, this.futurDirection);

            if (!estEnCollisionMur(futurX1Dir, futurY1Dir)) {
                this.direction = this.futurDirection;
                this.x = futurXDir;
                this.y = futurYDir;

            } else {
                if (estEnCollisionMur(futurX, futurY)) {
                    this.moving = false;
                } else {
                    this.x = futurX;
                    this.y = futurY;
                }
            }
        }
    }

    public boolean estEnCollisionMur(float xObjet, float yObjet) {
        boolean collision = false;
        if(this.map.isCollision(xObjet + 1, yObjet + 1)
             ||this.map.isCollision(xObjet + 31, yObjet + 1)
                ||this.map.isCollision(xObjet + 1, yObjet + 31)
                  ||this.map.isCollision(xObjet + 31, yObjet + 31)
                ){
        collision = true;
    } 
        return collision;
    }

    public boolean estEnCollisionObjet(float xObjet, float yObjet) {

        return xObjet > this.x && xObjet < this.x + 33 && yObjet > this.y && yObjet < this.y + 33;

    }

    private float getFuturX(int delta, int direction) {
        float futurX = this.x;
        switch (direction) {
            case 1:
                futurX = this.x - 2 * delta;
                break;
            case 0:
                futurX = this.x + 2 * delta;
                break;
        }
        return futurX;
    }

    private float getFuturY(int delta, int direction) {
        float futurY = this.y;
        switch (direction) {
            case 2:
                futurY = this.y - 2 * delta;
                break;
            case 3:
                futurY = this.y + 2 * delta;
                break;
        }
        return futurY;
    }
    
       private float getFuturX1(int delta, int direction) {
        float futurX = this.x;
        switch (direction) {
            case 1:
                futurX = this.x - 4 * delta;
                break;
            case 0:
                futurX = this.x + 4 * delta;
                break;
        }
        return futurX;
    }

    private float getFuturY1(int delta, int direction) {
        float futurY = this.y;
        switch (direction) {
            case 2:
                futurY = this.y - 4 * delta;
                break;
            case 3:
                futurY = this.y + 4 * delta;
                break;
        }
        return futurY;
    }

//        private int getFuturX(int delta) {
//        int futurX = this.x;
//        switch (this.direction) {
//            case 1:
//                futurX = this.x - .1f * delta;
//                break;
//            case 0:
//                futurX = this.x + .1f * delta;
//                break;
//        }
//        return futurX;
//    }
//
//    private int getFuturY(int delta) {
//        int futurY = this.y;
//        switch (this.direction) {
//            case 2:
//                futurY = this.y - .1f * delta;
//                break;
//            case 3:
//                futurY = this.y + .1f * delta;
//                break;
//        }
//        return futurY;
//    }
    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isOnStair() {
        return onStair;
    }

    public void setOnStair(boolean onStair) {
        this.onStair = onStair;
    }

    public int getFuturDirection() {
        return futurDirection;
    }

    public void setFuturDirection(int futurDirection) {
        this.futurDirection = futurDirection;
    }

}
