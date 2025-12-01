package game.States;

import game.UserInterface.*;
import game.Managers.StateManager;
import game.Managers.InputManager;
import static game.Managers.PlayerControls.*;

import game.Data.GameData;

public class MenuState implements State {

    private final StateManager stateManager;
    private final GameData data;

    private String lastInput;
    private String selection;
    private String highlightedText;

    private int selectionTracker;
    // List of Strings that will be looked for on menu
    private String[] playerOptions = { "New game", "Load game", "Save game", "Developer", "Quit"};

    public MenuState(StateManager stateManager, GameData data) {
        this.stateManager = stateManager;
        this.data = data;
    }

    public void onEnter() {
        selectionTracker = 0;
        highlightedText = playerOptions[0];
        render();
    }

    public void update() {
        lastInput = data.inputManager.readLine("Input your command: ");
        menuSelection();
        userSelection();
    }

    private void menuSelection() {
        if (isUp(lastInput)) {
            if (selectionTracker == 0)
                selectionTracker = playerOptions.length - 1;
            else
                selectionTracker -= 1;
        } else if (isDown(lastInput)) {
            if (selectionTracker == playerOptions.length - 1)
                selectionTracker = 0;
            else
                selectionTracker += 1;
        } else if (isSelect(lastInput)) {
            selection = playerOptions[selectionTracker];
        }
        highlightedText = playerOptions[selectionTracker];
    }

    private void userSelection() {
        if (selection == null)
            return;
        if (selection.equals("New game")) {
            stateManager.setState(new GameState(stateManager, data));
        } else if (selection.equals("Load game")) {
            stateManager.setState(new LoadGameState(stateManager, data));
        } else if (selection.equals("Save game")) {
            stateManager.setState(new SaveGameState(stateManager, data));
        } else if (selection.equals("Quit")) {
            stateManager.stopRunning();
        } else if (selection.equals("Developer")){
            stateManager.setState(new DeveloperState(stateManager, data));
        }
        selection = null;
    }

    public void onExit() {
        selection = null;
        highlightedText = null;
        lastInput = null;
    }

    public void render() {
        Display.clearScreen();
        //Display.drawMainMenu(highlightedText);
        Display.drawMainMenuDeveloper(highlightedText);
    }
}
