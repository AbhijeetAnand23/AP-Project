package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class NewGame implements Screen {
    private TankStars game;
    private SpriteBatch batch;
    private Texture background;
    private Texture terrain;
    private Texture health;
    private Texture menuIcon;
    private Texture tank1;
    private Texture tank2;
    private Rectangle menuBox;
    private Vector3 menuTouch;
    private World world;
    private Body box;
    private Box2DDebugRenderer debugRenderer;

    private OrthographicCamera camera;
    public NewGame(TankStars game){
        this.game = game;
        batch = new SpriteBatch();

        background = new Texture("GameBackground.png");
        terrain = new Texture("Terrain.png");
        health = new Texture("Health.png");
        menuIcon = new Texture("MenuIcon.png");
        tank1 = new Texture("Tank1.png");
        tank2 = new Texture("Tank2 Reversed.png");
        menuBox = new Rectangle(63,820,60,70);
        debugRenderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/4);
        world = new World(new Vector2(0,-9.8f), true);
//        box = new Body(world, );
        BodyDef bodyDef = new BodyDef();
        FixtureDef fixtureDef = new FixtureDef();
        ChainShape chainShape = new ChainShape();
        fixtureDef.shape = chainShape;
        chainShape.createChain(new Vector2[]{new Vector2(-250, 55), new Vector2(-190,55), new Vector2(-157,-8),
                 new Vector2( -82,-8), new Vector2(-63, 26), new Vector2(-14, 26), new Vector2(21,-42),
                 new Vector2(98,-42), new Vector2(118,24), new Vector2(191, 24), new Vector2(212,-18),
                 new Vector2(250, -18)});
        world.createBody(bodyDef).createFixture(fixtureDef);

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.begin();
        game.batch.draw(background, 0,0,1900, 915);
        game.batch.draw(terrain,0,-100,1920,1080);
        game.batch.draw(health, -400,720,2798, 256);
        game.batch.draw(menuIcon, 0,790,188, 138);
        game.batch.draw(tank1,370,381,170,170);
        game.batch.draw(tank2, 1475,505,170,170);
        game.batch.end();

        debugRenderer.render(world, camera.combined);
        world.step(1/60f,8,3);

        if (Gdx.input.justTouched()) {
            menuTouch = new Vector3();
            menuTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(menuBox.contains(menuTouch.x, menuTouch.y)) {
                game.setScreen(new InGameMenu(game));
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
        terrain.dispose();
        health.dispose();
        menuIcon.dispose();
        tank1.dispose();
        tank2.dispose();
    }
}
