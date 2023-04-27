package edu.guilford;

public class Meal {
    // attributes for the Meal class
    private String appetizer;
    private String entree;
    private String dessert;
    private String drink;

    // constructor for the Meal class that gives default values to the attributes
    public Meal() {
        appetizer = "Chips and Salsa";
        entree = "Birria Tacos";
        dessert = "Churros";
        drink = "Horchata";
    }

    // constructor for the Meal class that takes in values for the attributes
    public Meal(String appetizer, String entree, String dessert, String drink) {
        this.appetizer = appetizer;
        this.entree = entree;
        this.dessert = dessert;
        this.drink = drink;
    }

    // getters and setters for the attributes
    public String getAppetizer() {
        return appetizer;
    }

    public void setAppetizer(String appetizer) {
        this.appetizer = appetizer;
    }

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.drink = dessert;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    // toString method for the Meal class
    @Override
    public String toString() {
        return "Meal{" +
                "appetizer='" + appetizer + '\'' +
                ", entree='" + entree + '\'' +
                ", dessert='" + dessert + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }

}
