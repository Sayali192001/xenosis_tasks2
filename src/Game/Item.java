package Game;

public class Item {
    private String name;
    private String effect;

    public Item(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}

