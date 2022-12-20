package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class SavedGame implements Screen {
    private TankStars game;
    private SpriteBatch batch;
    private Texture background;
    private Texture tank;
    private Texture setting;
    private Rectangle settingBox;
    private Vector3 settingTouch;
    private Rectangle closeBox;
    private Vector3 closeTouch;

    public SavedGame(TankStars game) {
        this.game = game;
        batch = new SpriteBatch();

        background = new Texture("SavedGame.png");
        tank = new Texture("Tank1MainMenu.png");
        setting = new Texture("SettingIcon.png");
        settingBox = new Rectangle(70, 830, 46,46);
        closeBox = new Rectangle(1825,840,46,46);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(background, 0,0,1900,915);
        game.batch.draw(tank, 325, 80, 600, 600);
        game.batch.draw(setting, 70,830,46,46);
        game.batch.end();

        if (Gdx.input.justTouched()) {
            settingTouch = new Vector3();
            settingTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(settingBox.contains(settingTouch.x, settingTouch.y)) {
                game.setScreen(new SavedGameSetting(game));
                dispose();
            }
        }
        if (Gdx.input.justTouched()) {
            closeTouch = new Vector3();
            closeTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(closeBox.contains(closeTouch.x, closeTouch.y)) {
                game.setScreen(new MainMenu(game));
                dispose();
            }
        }
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
        tank.dispose();
        setting.dispose();
    }
}
