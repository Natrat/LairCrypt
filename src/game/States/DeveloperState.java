package game.States;

import game.Data.GameData;
import game.Data.Enemy.EnemyDefinition;
import game.Managers.StateManager;
import game.UserInterface.Display;

public class DeveloperState implements State {

    private final StateManager stateManager;
    private final GameData data;


    public DeveloperState(StateManager stateManager, GameData data) {
        this.stateManager = stateManager;
        this.data = data;
    }

    @Override
    public void onEnter() {

    }

    @Override
    public void update() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onExit() {

    }

    @Override
    public void render() {
        Display.clearScreen();
        for(EnemyDefinition enemy: data.getEnemyMap().values()){
            System.out.printf("%s | Rarity: %s%n", enemy.name, enemy.dropTable.toString());
        }
    }

}
