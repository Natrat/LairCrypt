package game.States;

import game.UserInterface.*;
import game.Managers.StateManager;
import game.Managers.InputManager;
import static game.Managers.PlayerControls.*;

import game.Data.GameData;

public class MenuState implements State {

    private final StateManager stateManager;
    private final GameData data;
    private final InputManager inputManager;

    private String lastInput;
    private String selection;
    private String highlightedText;

    private int selectionTracker;
    // List of Strings that will be looked for on menu
    private String[] selectableStrings = { "New game", "Load game", "Save game", "Quit" };

    public MenuState(StateManager stateManager, InputManager inputManager, GameData data) {
        this.stateManager = stateManager;
        this.inputManager = inputManager;
        this.data = data;
    }

    public void onEnter() {
        selectionTracker = 0;
        highlightedText = selectableStrings[0];
        render();
    }

    public void update() {
        lastInput = inputManager.readLine("Input your command: ");
        userControl();
        userSelection();
    }

    public void userControl() {
        if (isUp(lastInput)) {
            if (selectionTracker == 0)
                selectionTracker = selectableStrings.length - 1;
            else
                selectionTracker -= 1;
        } else if (isDown(lastInput)) {
            if (selectionTracker == selectableStrings.length - 1)
                selectionTracker = 0;
            else
                selectionTracker += 1;
        } else if (isSelect(lastInput)) {
            selection = selectableStrings[selectionTracker];
        }
        highlightedText = selectableStrings[selectionTracker];
    }

    public void userSelection() {
        if (selection == null)
            return;
        if (selection.equals("New game")) {
            stateManager.setState(new GameState(stateManager,inputManager, data));
        } else if (selection.equals("Load game")) {
            stateManager.setState(new LoadGameState(stateManager, inputManager, data));
        } else if (selection.equals("Save game")) {
            stateManager.setState(new SaveGameState(stateManager, inputManager, data));
        } else if (selection.equals("Quit")) {
            stateManager.stopRunning();
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
        Display.drawMainMenu(highlightedText);
    }
}
