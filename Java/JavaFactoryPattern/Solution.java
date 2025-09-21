import java.util.Scanner;

interface Food {
  public String getType();
}

class Pizza implements Food {
  public String getType() {
    return "Someone ordered a Fast Food!";
  }
}

class Cake implements Food {
  public String getType() {
    return "Someone ordered a Dessert!";
  }
}

class FoodFactory {
  public Food getFood(String order) {
    if (order.equals("cake"))
      return new Cake();

    return new Pizza();
  }
}

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    FoodFactory factory = new FoodFactory();
    Food food = factory.getFood(scanner.nextLine());
    System.out.println("The factory returned " + food.getClass());
    System.out.println(food.getType());
  }
}
