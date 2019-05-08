package T02E01;

public class Pets {
    private String id;
    private String name;
    private String species;
    private String color;
    private String owner;

    public Pets(String id, String name, String species, String color, String owner) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.color = color;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getColor() {
        return color;
    }

    public String getOwner() {
        return owner;
    }
}
