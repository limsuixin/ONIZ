package com.oniz.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.oniz.Game.AssetLoader;
import com.oniz.Game.ZGame;
import com.oniz.UI.SimpleButton;

/**
 * Created by robin on 19/3/16.
 */
public class MatchMakingScreen implements Screen{

    public static ZGame zgame;

    private Stage stage;
    private Skin skin;
    private Table table;

    private SimpleButton buttonB;

    private TextureRegion background;
    private SpriteBatch batcher;
    private OrthographicCamera cam;

    public MatchMakingScreen(ZGame zgame) {
        this.zgame = zgame;
        this.stage = new Stage(new FitViewport(450, 800));
        this.skin = AssetLoader.getInstance().skin;

        background =  AssetLoader.getInstance().sprites.get("waitingBackground");
        stage = new Stage(new FitViewport(450, 800));

        //Viewport - Aspect Radio
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 450, 800); //false for y upwards

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);


        //TODO: enable cancel?

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClearColor(0, 0, 0, 1);
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batcher.begin();
        batcher.disableBlending();
        // draw the background
        batcher.draw(background, 0, 0, 450, 800);

        batcher.enableBlending();
        batcher.end();

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

    }
}
