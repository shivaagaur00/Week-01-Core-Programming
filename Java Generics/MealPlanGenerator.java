interface MealPlan { String planName(); }
class VegetarianMeal implements MealPlan { public String planName() { return "Vegetarian Plan"; } }
class VeganMeal implements MealPlan { public String planName() { return "Vegan Plan"; } }

class Meal<T extends MealPlan> {
    private T mealType;
    public Meal(T mealType) { this.mealType = mealType; }
    public void showPlan() { System.out.println(mealType.planName()); }
}

public class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        meal.showPlan();
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarian = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> vegan = new Meal<>(new VeganMeal());
        generateMealPlan(vegetarian);
        generateMealPlan(vegan);
    }
}
