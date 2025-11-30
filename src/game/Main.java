package game;

import game.Managers.StateManager;
import game.Managers.InputManager;
import game.Data.GameData;
import game.Data.DataLoader;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        GameData data = new GameData();

        DataLoader dataLoader = new DataLoader();
        dataLoader.initialiseData(data);
        
        StateManager stateManager = new StateManager(data);
        stateManager.run();
    }
}