import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRegister {
    private Map<String, Dish> dishes;
    private List<Menu> menus;
    
    public MenuRegister() {
        this.dishes = new HashMap<>();
        this.menus = new ArrayList<>();
    }
    
    // Register a new dish
    public void registerDish(Dish dish) {
        dishes.put(dish.getName(), dish);
    }
    
    // Find a dish by name
    public Dish findDish(String name) {
        return dishes.get(name);
    }
    
    // Find all dishes of a given type
    public List<Dish> findDishesByType(DishType type) {
        List<Dish> result = new ArrayList<>();
        for (Dish dish : dishes.values()) {
            if (dish.getType() == type) {
                result.add(dish);
            }
        }
        return result;
    }
    
    // Register a new menu with a set of dishes
    public void registerMenu(Menu menu) {
        menus.add(menu);
    }
    
    // Find all menus with total price within a given range
    public List<Menu> findMenusByPriceRange(double minPrice, double maxPrice) {
        List<Menu> result = new ArrayList<>();
        for (Menu menu : menus) {
            double totalPrice = menu.getTotalPrice();
            if (totalPrice >= minPrice && totalPrice <= maxPrice) {
                result.add(menu);
            }
        }
        return result;
    }
    
    public List<Dish> getAllDishes() {
        return new ArrayList<>(dishes.values());
    }
    
    public List<Menu> getAllMenus() {
        return new ArrayList<>(menus);
    }
}