package com.oniz.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.oniz.Network.PlayServices;
import com.oniz.Screens.GameScreen;
import com.oniz.Screens.MainScreen;
import com.oniz.Screens.MatchMakingScreen;
import com.oniz.Screens.StartScreen;
import com.oniz.Screens.SplashScreen;


public class ZGame extends Game {
    AssetLoader assets;

    public PlayServices playServices;

    public static Screen startScreen, matchMakingScreen, gameScreen;

    private GameWorld gameWorld;

    public ZGame(PlayServices playServices) {
        super();
        this.playServices = playServices;
        this.playServices.setGame(this);
    }

    public enum State
    {
        PAUSE,
        RUN,
        RESUME,
        STOPPED
    }


    public enum ScreenState {
        START, MATCHMAKING, MAIN, GAMEOVER, SPLASH
    }
    @Override
    public void create() {
        Gdx.app.log("ONIZ", "created");
        assets = new AssetLoader();
        gameScreen = new GameScreen(this);
        startScreen = new StartScreen(this);
        matchMakingScreen = new MatchMakingScreen(this);

        //splash seems to only activate if its passed as a new object
        setScreen(startScreen);
    }

    public void switchScreen(ScreenState screen) {
        switch(screen) {
            case START:
                setScreen(startScreen);
                break;
            case MATCHMAKING:
                setScreen(matchMakingScreen);
                break;
            case MAIN:
                setScreen(gameScreen);
                break;
            case GAMEOVER:
                setScreen(startScreen);
                break;
            default:
                setScreen(startScreen);
                break;
        }
    }

    public void setGameWorld(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        gameWorld.setGame(this);
    }

    public GameWorld getGameWorld() {
        return this.gameWorld;
    }

    public boolean isGameWorldReady() {
        return gameWorld != null;
    }

    @Override
    public void dispose() {
        super.dispose();
        assets.dispose();
    }
}