package game;

import game.Managers.StateManager;
import game.Managers.InputManager;
import game.Data.GameData;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        // create data class called gameData, pass it through
        GameData data = new GameData();
        InputManager inputManager = new InputManager();
        
        StateManager stateManager = new StateManager(data, inputManager);
        stateManager.run();
    }
}