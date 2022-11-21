package com.mygame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


public class TankStars extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	Texture img;
	Sprite sprite;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Loader_Page.png");
		font = new BitmapFont();
		sprite = new Sprite(img);
		font.setColor(Color.BLACK);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
//		batch.draw(img, 200, 100);
		sprite.setPosition(0,0);
		sprite.draw(batch);
//		sprite.setPosition(100,100);
//		sprite.draw(batch);
//		font.draw(batch , "Mail Likhra Hu" , 400 , 400);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
