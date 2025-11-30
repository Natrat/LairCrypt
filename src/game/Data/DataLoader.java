package game.Data;

import game.Data.Enemy.EnemyDefinition;

import java.util.List;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DataLoader {
    Gson gson = new Gson();

    String basePath = "src/game/Data/Enemy/";

    String[] enemyFiles = {
            "common_enemies.json",
            "uncommon_enemies.json",
            "rare_enemies.json",
            "epic_enemies.json",
            "legendary_enemies.json"
    };

    // load .json files into definitionslist, then convert to a map
    public void initialiseData(GameData data) {
        for (String enemyFile : enemyFiles) {
            String path = basePath + enemyFile;
            loadEnemiesFromFile(path, data);
        }
    }

    private void loadEnemiesFromFile(String path, GameData data) {
        try (FileReader fileReader = new FileReader(path)) {
            List<EnemyDefinition> enemyDefinitionList = gson.fromJson(fileReader, // gson.fromJson(WHERE, WHAT);
                    new TypeToken<List<EnemyDefinition>>() {
                    }.getType()); // this is all one line, formatter forces it to 2
            for (EnemyDefinition enemy : enemyDefinitionList) {
                data.addEnemy(enemy.id, enemy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
