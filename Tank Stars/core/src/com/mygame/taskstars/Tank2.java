package com.mygame.taskstars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

public class Tank2 extends Image {

    Texture player1;
    Texture player2;
    Vector2 size;
    private static Map<Vector2, Tank2> instances = new HashMap<Vector2, Tank2>();

    public static Tank2 getTank2(Vector2 s) {
        if(!instances.containsKey(s)) {
            instances.put(s, new Tank2(s));
        }
        return instances.get(s);
    }

    public Tank2(Vector2 size) {
        player1 = new Texture("Tank2.png");
        player2 = new Texture("Tank2 Reversed.png");
        this.size = size;
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
