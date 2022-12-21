package com.mygame.taskstars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Objects;

public class Tank1 extends Image {
    Texture player1;
    Texture player2;

    private static Tank1 tank = null;
    public static Tank1 getTank1() {
        if(tank == null) {
            tank = new Tank1();
        }
        return tank;
    }

    public Tank1() {
        player1 = new Texture("Tank1.png");
        player2 = new Texture("Tank1 Reversed.png");
    }
    public void draw(String playerType, Player player, SpriteBatch batch) {
        if(Objects.equals(playerType, "Player1")) {
            batch.draw(player1, player.getX(), player.getY(), player.getLength(), player.getHeight());
        }
        if(Objects.equals(playerType, "Player2")) {
            batch.draw(player2, player.getX(), player.getY(), player.getLength(), player.getHeight());
        }
    }
    @Override
    public int getWidth(ImageObserver imageObserver) {
        return 0;
    }

    @Override
    public int getHeight(ImageObserver imageObserver) {
        return 0;
    }

    @Override
    public ImageProducer getSource() {
        return null;
    }

    @Override
    public Graphics getGraphics() {
        return null;
    }

    @Override
    public Object getProperty(String s, ImageObserver imageObserver) {
        return null;
    }
}
