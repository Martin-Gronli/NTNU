import java.util.*;

public class TestClient {
    public static void main(String[] args) {
        MenuRegister register = new MenuRegister();
        Scanner in = new Scanner(System.in);

        // Register dishes
        System.out.println("=== Registering Dishes ===");
        Dish salad = new Dish("Caesar Salad", DishType.APPETIZER, 8.50, "Romaine lettuce, parmesan, croutons, Caesar dressing");
        Dish soup = new Dish("Tomato Soup", DishType.APPETIZER, 6.00, "Tomatoes, cream, basil, garlic");
        Dish steak = new Dish("Grilled Steak", DishType.MAIN_COURSE, 25.00, "Ribeye steak, herbs, butter");
        Dish pasta = new Dish("Pasta Carbonara", DishType.MAIN_COURSE, 15.00, "Pasta, eggs, bacon, parmesan");
        Dish tiramisu = new Dish("Tiramisu", DishType.DESSERT, 7.50, "Mascarpone, coffee, ladyfingers");
        Dish icecream = new Dish("Vanilla Ice Cream", DishType.DESSERT, 5.00, "Vanilla, cream, sugar");
        
        register.registerDish(salad);
        register.registerDish(soup);
        register.registerDish(steak);
        register.registerDish(pasta);
        register.registerDish(tiramisu);
        register.registerDish(icecream);
        System.out.println("Registered 6 dishes\n");

        // Create and register menus
        System.out.println("=== Creating Menus ===");
        Menu menu1 = new Menu("Budget Menu");
        menu1.addDish(soup);
        menu1.addDish(pasta);
        menu1.addDish(icecream);
        register.registerMenu(menu1);
        
        Menu menu2 = new Menu("Premium Menu");
        menu2.addDish(salad);
        menu2.addDish(steak);
        menu2.addDish(tiramisu);
        register.registerMenu(menu2);
        
        Menu menu3 = new Menu("Quick Lunch");
        menu3.addDish(soup);
        menu3.addDish(pasta);
        register.registerMenu(menu3);
        
        System.out.println("Registered 3 menus\n");
        
        while (true) {
            System.out.println("1. Find dish by name");
            System.out.println("2. Find all appetizers");
            System.out.println("3. Display all menus");
            System.out.println("4. Find menus by price range");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");   

            String line = in.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 ->  {
                    // Find dish by name
                    System.out.println("=== Finding Dish by Name ===");
                    System.out.print("Enter dish name: ");
                    String dishName = in.nextLine();
                    Dish foundDish = register.findDish(dishName);
                    if (foundDish != null) {
                        System.out.println("Found: " + foundDish + "\n");
                    } else {
                        System.out.println("Dish not found: " + dishName + "\n");
                    }
                }

                case 2 ->  {
                    // Find all appetizers
                    System.out.println("=== Finding All Appetizers ===");
                    List<Dish> appetizers = register.findDishesByType(DishType.APPETIZER);
                    for (Dish dish : appetizers) {
                        System.out.println(dish);
                    }
                    System.out.println();
                }

                case 3 ->  {
                    // Display all menus
                    System.out.println("=== All Menus ===");
                    for (Menu menu : register.getAllMenus()) {
                        System.out.println(menu);
                        System.out.println();
                    }
                }

                case 4 ->  {
                    // Find menus by price range
                    System.out.println("=== Finding Menus in Price Range ===");
                    System.out.print("Enter minimum price: ");
                    String minLine = in.nextLine();
                    System.out.print("Enter maximum price: ");
                    String maxLine = in.nextLine();
                    double minPrice, maxPrice;
                    try {
                        minPrice = Double.parseDouble(minLine.trim());
                        maxPrice = Double.parseDouble(maxLine.trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price input. Please enter numeric values.\n");
                        break;
                    }
                    List<Menu> menusInRange = register.findMenusByPriceRange(minPrice, maxPrice);
                    for (Menu menu : menusInRange) {
                        System.out.println(menu.getName() + " - Total: " + 
                            String.format("%.2f", menu.getTotalPrice()) + "kr");
                    }
                    System.out.println();
                }

                case 5 -> {
                    in.close();
                    return;
                }

                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}