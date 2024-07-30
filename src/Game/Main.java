package Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your character's name: ");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName);
        GameWorld gameWorld = new GameWorld(player);
        gameWorld.play();
    }
}

