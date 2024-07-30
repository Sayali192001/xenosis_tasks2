package Game;
import java.util.*;
public class GameWorld {
    private Player player;
    private Map<String, String> map;
    private Random random;

    public GameWorld(Player player) {
        this.player = player;
        this.map = new HashMap<>();
        this.random = new Random();
        initializeMap();
    }

    private void initializeMap() {
        // Simple map structure for demonstration
        map.put("Start", "Forest");
        map.put("Forest", "Cave");
        map.put("Cave", "Treasure Room");
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        String location = "Start";

        System.out.println("Welcome, " + player.getName() + "!");

        while (player.getHealth() > 0) {
            System.out.println("You are at: " + location);
            System.out.print("Enter command (move, fight, inventory, quit): ");
            String command = scanner.nextLine();

            if (command.equals("move")) {
                location = move(location);
            } else if (command.equals("fight")) {
                fight();
            } else if (command.equals("inventory")) {
                player.showInventory();
            } else if (command.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
        scanner.close();
    }

    private String move(String currentLocation) {
        if (map.containsKey(currentLocation)) {
            return map.get(currentLocation);
        } else {
            System.out.println("You can't move from here.");
            return currentLocation;
        }
    }

    private void fight() {
        Enemy enemy = new Enemy("Voldemort", 30, 10);
        System.out.println("You encounter a " + enemy.getType() + "!");

        while (enemy.getHealth() > 0 && player.getHealth() > 0) {
            int damageToEnemy = random.nextInt(10) + 1;
            int damageToPlayer = random.nextInt(enemy.getAttackPower()) + 1;

            enemy.takeDamage(damageToEnemy);
            player.takeDamage(damageToPlayer);

            System.out.println("You hit the " + enemy.getType() + " for " + damageToEnemy + " damage.");
            System.out.println("The " + enemy.getType() + " hits you for " + damageToPlayer + " damage.");

            if (enemy.getHealth() <= 0) {
                System.out.println("You defeated the " + enemy.getType() + "!");
                break;
            }

            if (player.getHealth() <= 0) {
                System.out.println("You have been defeated!");
                break;
            }
        }
    }
}

