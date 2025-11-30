package game.States;


import game.Data.GameData;
import game.Managers.StateManager;
import game.UserInterface.Display;

public class LoadGameState implements State {
    private final StateManager stateManager;
    private final GameData data;

    public LoadGameState(StateManager stateManager, GameData data) {
        this.stateManager = stateManager;
        this.data = data;
    }

    public void onEnter() {
        render();
    }

    public void update() {

    }

    public void render() {
        Display.clearScreen();
    }

    public void onExit() {

    }
}
