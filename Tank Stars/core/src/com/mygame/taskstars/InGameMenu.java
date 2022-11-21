package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.mygame.taskstars.TankStars;

import java.awt.*;

public class InGameMenu implements Screen {
    TankStars game;
    SpriteBatch batch;
    Texture background;
    Rectangle closeBox;
    Vector3 closeTouch;
    Rectangle resumeBox;
    Vector3 resumeTouch;
    Rectangle mainMenuBox;
    Vector3 mainMenuTouch;
    ShapeRenderer shapeRenderer;

    public InGameMenu(TankStars game) {
        this.game = game;
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

        background = new Texture("InGameMenu.png");
        closeBox = new Rectangle(1240,700, 44,44);
        resumeBox = new Rectangle(895, 595, 198, 69);
        mainMenuBox = new Rectangle(895, 178, 198, 69);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(background, 630,90, 761, 700);
        game.batch.end();

        if (Gdx.input.justTouched()) {
            closeTouch = new Vector3();
            closeTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(closeBox.contains(closeTouch.x, closeTouch.y)) {
                game.setScreen(new VsFriend(game));
                dispose();
            }
        }

        if (Gdx.input.justTouched()) {
            resumeTouch = new Vector3();
            resumeTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(resumeBox.contains(resumeTouch.x, resumeBox.y)) {
                game.setScreen(new VsFriend(game));
                dispose();
            }
        }

        if (Gdx.input.justTouched()) {
            mainMenuTouch = new Vector3();
            mainMenuTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(mainMenuBox.contains(mainMenuTouch.x, mainMenuTouch.y)) {
                game.setScreen(new MainMenu(game));
                dispose();
            }
        }

//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//        shapeRenderer.rect(closeBox.x, closeBox.y, closeBox.width, closeBox.height);
//        shapeRenderer.rect(resumeBox.x, resumeBox.y, resumeBox.width, resumeBox.height);
//        shapeRenderer.rect(mainMenuBox.x, mainMenuBox.y, mainMenuBox.width, mainMenuBox.height);
//        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();

    }
}
