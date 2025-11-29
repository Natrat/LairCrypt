package game.Managers;

import game.Data.GameData;

public class SaveManager {

    public void save(GameData data) {
        // build a path "saves/saveX.txt"
        // serialize data and write/flush to file
    }

    public GameData load(){
        // read file, build GameData and return data
        throw new UnsupportedOperationException("Load not implemented yet");
    }
}
