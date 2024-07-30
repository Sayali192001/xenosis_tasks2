package Game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private List<Item> inventory;

    public Player(String name) {
        this.name = name;
        this.health = 100; // Default health
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void heal(int amount) {
        this.health += amount;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void showInventory() {
        System.out.println("Inventory:");
        for (Item item : inventory) {
            System.out.println(item.getName() + ": " + item.getEffect());
        }
    }
}

