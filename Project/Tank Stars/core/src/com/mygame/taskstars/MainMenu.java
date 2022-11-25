package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;


public class MainMenu implements Screen {
    private TankStars game;
    private SpriteBatch batch;
    private Texture background;
    private Texture tank;
    private Texture setting;
    private Rectangle settingBox;
    private Vector3 settingTouch;
    private TextButton newGame;
    private TextButton loadGame;
    private TextButton exit;
    private TextureAtlas atlas;
    private Skin skin;
    private BitmapFont font;
    private Stage stage;
    private Table table;

    public MainMenu(TankStars game) {
        this.game = game;
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        stage = new Stage();
        table = new Table(skin);
        TextButton.TextButtonStyle buttonText = new TextButton.TextButtonStyle();
        Gdx.input.setInputProcessor(stage);


        background = new Texture("MainMenu.png");
        tank = new Texture("Tank1MainMenu.png");
        setting = new Texture("SettingIcon.png");
        atlas = new TextureAtlas("button.atlas");
        skin = new Skin(atlas);
        buttonText.up = skin.getDrawable("button_up");
        buttonText.down = skin.getDrawable("button_down");
        buttonText.pressedOffsetX = 1;
        buttonText.pressedOffsetY = -1;
        buttonText.font = font;
        newGame = new TextButton("NEW GAME",buttonText);
        loadGame = new TextButton("LOAD GAME", buttonText);
        exit = new TextButton("EXIT", buttonText);
        loadGame.setPosition(1350,377);
        loadGame.setSize(350,120);
        loadGame.getLabel().setFontScale(3,3);
        newGame.setPosition(1350,537);
        newGame.setSize(350,120);
        newGame.getLabel().setFontScale(3,3);
        exit.setPosition(1350,217);
        exit.setSize(350,120);
        exit.getLabel().setFontScale(3,3);

        stage.addActor(newGame);
        stage.addActor(loadGame);
        stage.addActor(exit);
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
        game.batch.end();

        newGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event , float x , float y){
                game.setScreen(new ChooseTanksPlayer1(game));
            }
        });
        loadGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event , float x , float y){
                game.setScreen(new SavedGame(game));
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
        font.dispose();
    }
}
