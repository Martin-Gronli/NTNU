import java.util.*;

public class Menu {
    private ArrayList<Dish> dishes;
    private String name;

    public Menu(String name) {
        this.name = name;
        this.dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public double getTotalPrice() {
        return dishes.stream().mapToDouble(Dish::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu: ").append(name).append("\n");
        for (Dish dish : dishes) {
            sb.append(dish.toString()).append("\n");
        }
        sb.append(String.format("Total Price: kr%.2f", getTotalPrice()));
        return sb.toString();
    }

}
