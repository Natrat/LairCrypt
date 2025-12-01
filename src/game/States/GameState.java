package game.States;


import game.Data.Area;
import game.Data.GameData;
import game.Managers.AreaManager;
import game.Managers.StateManager;
import game.UserInterface.Display;

public class GameState implements State {
    private final StateManager stateManager;
    private final GameData data;
    private final AreaManager areaManager;

    private String lastInput;
    private String[] playerOptions = {};

    public GameState(StateManager stateManager, GameData data) {
        this.stateManager = stateManager;
        this.data = data;
        this.areaManager = new AreaManager(data);
    }

    public void onEnter() {
        data.playerData.setAreaByID("VILLAGE_HUB");
        areaManager.loadArea(data.playerData.getCurrentAreaID());
        render();
    }

    public void update() {
        lastInput = data.inputManager.readLine("Input your command: ");
        userControl();
    }

    public void render() {
        Display.clearScreen();
        System.out.println(areaManager.getCurrentArea().id);
    }

    public void onExit() {

    }

    private void userControl(){

    }
}
