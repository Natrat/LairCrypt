package game.Data;

import java.util.ArrayList;
import java.util.List;

import game.Data.Enemy.EnemyDefinition;
import game.Data.Types.Biome;

public class Area {
    public String id;
    public Biome area;
    public int difficulty;
    public EnemyDefinition[] enemies = {};
    public List<String> worldRows = new ArrayList<>();
    public String mapFile;
}
