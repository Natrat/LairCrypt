package game.Managers;

import game.Data.Area;
import game.Data.GameData;

import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;

public class AreaManager {
    Gson gson = new Gson();
    private final GameData data;

    private Area currentArea;

    public AreaManager(GameData gameData) {
        this.data = gameData;
    }

    public void loadArea(String id) {
        // eventually use gson.getJson to load area using ID above
        try {
            String json = Files.readString(Path.of("src/game/Data/World/" + id + ".json"));
            currentArea = gson.fromJson(json, Area.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Area getCurrentArea() {
        return currentArea;
    }
}
