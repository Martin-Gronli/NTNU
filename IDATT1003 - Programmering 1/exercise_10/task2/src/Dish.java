public class Dish {
    private final String name;
    private final DishType type;
    private final double price;
    private final String recipe;

    public Dish(String name, DishType type, double price, String recipe) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public DishType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - kr%.2f", name, type, price);
    }

}
