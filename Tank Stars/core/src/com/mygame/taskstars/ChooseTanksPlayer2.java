package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class ChooseTanksPlayer2 implements Screen {
    private TankStars game;
    private SpriteBatch batch;
    private Texture background;
    private Texture tank;
    private Texture tankMini;
    private Texture setting;
    private Rectangle settingBox;
    private Vector3 settingTouch;
    private Rectangle selectBox;
    private Vector3 selectTouch;
    private Rectangle closeBox;
    private Vector3 closeTouch;
    public ChooseTanksPlayer2(TankStars game) {
        this.game = game;
        batch = new SpriteBatch();

        background = new Texture("ChooseTanksPlayer2.png");
        tank = new Texture("Tank2MainMenu.png");
        tankMini = new Texture("Tank2.png");
        setting = new Texture("SettingIcon.png");
        settingBox = new Rectangle(70, 830, 46,46);
        selectBox = new Rectangle(1327, 114, 435,132);
        closeBox = new Rectangle(1825,840,46,46);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);

        game.batch.begin();
        game.batch.draw(background, 0,0, 1900, 915);
        game.batch.draw(tank, 290,65, 600,600);
        game.batch.draw(tankMini, 1450,365,170,170);
        game.batch.draw(setting, 70,830,46,46);
        game.batch.end();

        if (Gdx.input.justTouched()) {
            settingTouch = new Vector3();
            settingTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(settingBox.contains(settingTouch.x, settingTouch.y)) {
                game.setScreen(new ChooseTankSetting(game));
                dispose();
            }
        }

        if (Gdx.input.justTouched()) {
            selectTouch = new Vector3();
            selectTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(selectBox.contains(selectTouch.x, selectTouch.y)) {
                game.setScreen(new NewGame(game));
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
        tankMini.dispose();
        setting.dispose();
    }
}
