package game.Data;

import java.util.HashMap;
import java.util.Map;

import game.Data.Enemy.EnemyDefinition;
import game.Managers.InputManager;

public class GameData {
    public final InputManager inputManager = new InputManager();
    public final MessageLog messageLog = new MessageLog();
    public final PlayerData playerData = new PlayerData();

    private final Map<String, EnemyDefinition> enemiesByID = new HashMap<>();

    public void addEnemy(String id, EnemyDefinition definition){
        enemiesByID.put(id, definition);
    }

    public EnemyDefinition getEnemy(String id){
        return enemiesByID.get(id);
    }

    public Map<String, EnemyDefinition> getEnemyMap(){
        return enemiesByID;
    }
}
