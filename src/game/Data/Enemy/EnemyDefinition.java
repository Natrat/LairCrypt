package game.Data.Enemy;

import game.Data.EnemyType;
import game.Data.Types.Biome;
import game.Data.Types.Rarity;

public class EnemyDefinition {
    public String id;
    public String name;
    public int baseHealth;
    public int attackDamage;
    public int attackSpeed;
    public int xpDrop;
    public Rarity dropTable;
    public EnemyType enemyType;
    public Biome[] biome;
    public String artFile;
}