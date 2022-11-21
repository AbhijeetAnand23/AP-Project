package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;


public class MainMenu implements Screen {
    TankStars game;
    SpriteBatch batch;
    Texture background;
    Texture tank;
    Texture setting;
    Texture vsComputer;
    Texture vsFriend;
    Rectangle vsComputerBox;
    Rectangle vsFriendBox;
    Rectangle settingBox;
    Vector3 vsComputerTouch;
    Vector3 vsFriendTouch;
    Vector3 settingTouch;
    ShapeRenderer shapeRenderer;

    public MainMenu(TankStars game) {
        this.game = game;
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

        background = new Texture("MainMenu.png");
        tank = new Texture("MainMenuTank.png");
        setting = new Texture("SettingIcon.png");
        vsComputer = new Texture("VsComputer.png");
        vsFriend = new Texture("VsFriend.png");
        vsComputerBox = new Rectangle(1345, 485, 407, 130);
        vsFriendBox = new Rectangle(1345, 302, 407, 130);
        settingBox = new Rectangle(70, 830, 46,46);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.begin();
        game.batch.draw(background, 0,0, 1900, 915);
        game.batch.draw(tank, 325, 80, 600, 600);
        game.batch.draw(setting, 70,830,46,46);
        game.batch.draw(vsComputer,1300,460, 492, 190);
        game.batch.draw(vsFriend,1261,260, 586, 215);
        game.batch.end();

        if (Gdx.input.justTouched()) {
            vsComputerTouch = new Vector3();
            vsComputerTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(vsComputerBox.contains(vsComputerTouch.x, vsComputerTouch.y)) {
                game.setScreen(new VsComputer(game));
                dispose();
            }
        }
        if (Gdx.input.justTouched()) {
            vsFriendTouch = new Vector3();
            vsFriendTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(vsFriendBox.contains(vsFriendTouch.x, vsFriendTouch.y)) {
                game.setScreen(new VsFriend(game));
                dispose();
            }
        }
        if (Gdx.input.justTouched()) {
            settingTouch = new Vector3();
            settingTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(settingBox.contains(settingTouch.x, settingTouch.y)) {
                game.setScreen(new MainMenuSetting(game));
                dispose();
            }
        }

//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//        shapeRenderer.rect(vsComputerBox.x, vsComputerBox.y, vsComputerBox.width, vsComputerBox.height);
//        shapeRenderer.rect(vsFriendBox.x, vsFriendBox.y, vsFriendBox.width, vsFriendBox.height);
//        shapeRenderer.rect(settingBox.x, settingBox.y, settingBox.width, settingBox.height);
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
        tank.dispose();
        setting.dispose();
        vsComputer.dispose();
        vsFriend.dispose();
    }
}
