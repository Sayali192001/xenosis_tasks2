package Game;

public class Enemy {
    private String type;
    private int health;
    private int attackPower;

    public Enemy(String type, int health, int attackPower) {
        this.type = type;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }
}

