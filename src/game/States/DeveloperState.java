package game.States;

import java.util.Arrays;

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
        data.messageLog.addMessage("Developer state");
    }

    @Override
    public void update() {
        try {
            Thread.sleep(50000);
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
        for (EnemyDefinition enemy : data.getEnemyMap().values()) {
            System.out.printf("%s | Base health: %s | Damage: %s | Attack speed: %s | XP drop: %s | Drop table: %s | Enemy type: %s | Biomes: %s%n",
                    enemy.name, enemy.baseHealth, enemy.attackDamage, enemy.attackSpeed, enemy.xpDrop,
                    enemy.dropTable.toString(), enemy.enemyType, Arrays.asList(enemy.biome));
        }
    }

}
