package game.Data;

import game.Data.Types.Skill;

public class PlayerData {
    private final int MAX_LVL = 20;

    private int maxHealth = 20;
    private int currentHealth = maxHealth;
    private int bonusHealth = 0;
    private int playerLvl = 1;
    private int attackLvl = 1;
    private int attackXP;
    private int strengthLvl = 1;
    private int strengthXP;
    private int defenceLvl = 1;
    private int defenceXP;

    private String currentAreaID;

    // FOR TESTING ONLY, REMOVE LATER \\
    public void setAreaByID(String id){
        currentAreaID = id;
    }

    public boolean isDamaged(){
        return currentHealth < getEffectiveMaxHealth();
    }

    public void addHealth(int health){
        currentHealth = Math.min(currentHealth + health, getEffectiveMaxHealth());
    }

    public void damage(int damage){
        int damageDealt = Math.max(damage, 0);
        currentHealth = Math.max(currentHealth - damageDealt, 0);
    }

    public void removeHealthBonus(int bonus){
        bonusHealth -= bonus;
        currentHealth = Math.min(currentHealth, getEffectiveMaxHealth());
    }

    public void addHealthBonus(int bonus){
        bonusHealth += bonus;
    }

    private int xpToNextLevel(int level) {
        if (level >= MAX_LVL)
            return Integer.MAX_VALUE;
        return 100 + 50 * (level - 1);
    }

    public void addXP(Skill skill, int xp) {
        switch (skill) {
            case ATTACK:
                attackXP += xp;
                tryToLevelUp(Skill.ATTACK);
                break;
            case STRENGTH:
                strengthXP += xp;
                tryToLevelUp(Skill.STRENGTH);
                break;
            case DEFENCE:
                defenceXP += xp;
                tryToLevelUp(Skill.DEFENCE);
                break;
        }
    }

    private void tryToLevelUp(Skill skill) {
        switch (skill) {
            case ATTACK:
                while (attackLvl < MAX_LVL && attackXP >= xpToNextLevel(attackLvl)) {
                    attackXP -= xpToNextLevel(attackLvl);
                    attackLvl++;
                }
                break;
            case STRENGTH:
                while (strengthLvl < MAX_LVL && strengthXP >= xpToNextLevel(strengthLvl)) {
                    strengthXP -= xpToNextLevel(strengthLvl);
                    strengthLvl++;
                }
                break;
            case DEFENCE:
                while (defenceLvl < MAX_LVL && defenceXP >= xpToNextLevel(defenceLvl)) {
                    defenceXP -= xpToNextLevel(defenceLvl);
                    defenceLvl++;
                    
                }
                break;
        }
        playerLvl = (attackLvl + strengthLvl + defenceLvl) / 3;
    }

    public int getEffectiveMaxHealth(){
        return maxHealth + bonusHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttackLvl() {
        return attackLvl;
    }

    public int getStrengthLvl() {
        return strengthLvl;
    }

    public int getDefenceLvl() {
        return defenceLvl;
    }

    public String getCurrentAreaID(){
        return currentAreaID;
    }

}
