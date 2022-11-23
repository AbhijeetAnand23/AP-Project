package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;


public class MainMenu implements Screen {
    TankStars game;
    SpriteBatch batch;
    Texture background;
    Texture tank;
    Texture setting;
//    Texture vsComputer;
//    Texture vsFriend;
//    Rectangle vsComputerBox;
//    Rectangle vsFriendBox;
    Rectangle settingBox;
//    Vector3 vsComputerTouch;
//    Vector3 vsFriendTouch;
    Vector3 settingTouch;
    ShapeRenderer shapeRenderer;
    ImageButton newGame;
    ImageButton loadGame;
    ImageButton exit;
    TextureAtlas atlas;
    Skin skin;
//    BitmapFont black;
    Stage stage;
    Table table;

//    Image try1;
    public MainMenu(TankStars game) {
        this.game = game;
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        background = new Texture("MainMenu.png");
        tank = new Texture("MainMenuTank.png");
        setting = new Texture("SettingIcon.png");
//        vsComputer = new Texture("VsComputer.png");
//        vsFriend = new Texture("VsFriend.png");
        atlas = new TextureAtlas("button.atlas");
//        black = new BitmapFont(Gdx.files.internal("font/black.fnt"))
        skin = new Skin(atlas);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        table = new Table(skin);
//        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        ImageButton.ImageButtonStyle button = new ImageButton.ImageButtonStyle();
        button.up = skin.getDrawable("button_up");
        button.down = skin.getDrawable("button_down");
        button.pressedOffsetX = 1;
        button.pressedOffsetY = -1;
//        button.font = black;
        newGame = new ImageButton(button);
        loadGame = new ImageButton(button);
        exit = new ImageButton(button);
//        yellowButton.pad(20);
//        table.add(yellowButton);
//        table.debug();
//        stage.addActor(table);
        loadGame.setPosition(1900/2+400,915/2-80);
        loadGame.setSize(350,120);
        newGame.setPosition(1900/2+400,915/2+80);
        newGame.setSize(350,120);
        exit.setPosition(1900/2+400,915/2-240);
        exit.setSize(350,120);
        stage.addActor(newGame);
        stage.addActor(loadGame);
        stage.addActor(exit);
//        vsComputerBox = new Rectangle(1345, 485, 407, 130);
//        vsFriendBox = new Rectangle(1345, 302, 407, 130);
        settingBox = new Rectangle(70, 830, 46,46);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);

//        table.drawDebug(shapeRenderer);
        game.batch.begin();
        game.batch.draw(background, 0,0, 1900, 915);
        game.batch.draw(tank, 325, 80, 600, 600);
        game.batch.draw(setting, 70,830,46,46);
//        game.batch.draw(vsComputer,1300,460, 492, 190);
//        game.batch.draw(vsFriend,1261,260, 586, 215);
        game.batch.end();

//        if (Gdx.input.justTouched()) {
//            vsComputerTouch = new Vector3();
//            vsComputerTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
//            if(vsComputerBox.contains(vsComputerTouch.x, vsComputerTouch.y)) {
//                game.setScreen(new VsComputer(game));
//                dispose();
//            }
//        }
//        if (Gdx.input.justTouched()) {
//            vsFriendTouch = new Vector3();
//            vsFriendTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
//            if(vsFriendBox.contains(vsFriendTouch.x, vsFriendTouch.y)) {
//                game.setScreen(new VsFriend(game));
//                dispose();
//            }
//        }
        newGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event , float x , float y){
                game.setScreen(new VsComputer(game));
            }
        });
        loadGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event , float x , float y){
                game.setScreen(new VsFriend(game));
            }
        });
        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event , float x , float y){
                Gdx.app.exit();
            }
        });
        if (Gdx.input.justTouched()) {
            settingTouch = new Vector3();
            settingTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(settingBox.contains(settingTouch.x, settingTouch.y)) {
                game.setScreen(new MainMenuSetting(game));
                dispose();
            }
        }
        stage.act(delta);
        stage.draw();

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
//        vsFriend.dispose();
    }
}
