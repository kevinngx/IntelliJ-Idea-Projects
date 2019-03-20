public class Pet {
    protected int id;
    protected String name;
    protected String species;
    protected String colour;
    protected String owner;

    // TODO: Finish this object-oriented class definition
    // HINT: Use NetBeans to automatically generate getters and setters


    public Pet(int id, String name, String species, String colour, String owner) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.colour = colour;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}