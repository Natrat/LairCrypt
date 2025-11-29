package game.States;

import static game.Managers.PlayerControls.*;

import game.Data.GameData;
import game.Managers.InputManager;
import game.Managers.StateManager;
import game.UserInterface.Display;

public class GameState implements State {
    private final StateManager stateManager;
    private final GameData data;
    private final InputManager inputManager;

    public GameState(StateManager stateManager, InputManager inputManager, GameData data) {
        this.stateManager = stateManager;
        this.inputManager = inputManager;
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
