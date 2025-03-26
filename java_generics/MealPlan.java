import java.util.*;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High Protein Meal";
    }
}

class Meal<T extends MealPlan> {
    T mealPlan;
    
    Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }
    
    <T extends MealPlan> void generateMealPlan(T mealPlan) {
        System.out.println("Generating " + mealPlan.getMealType());
    }
    
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeal = new Meal<>(new VegetarianMeal());
        vegetarianMeal.generateMealPlan(new VegetarianMeal());
        
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        veganMeal.generateMealPlan(new VeganMeal());
        
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        ketoMeal.generateMealPlan(new KetoMeal());
        
        Meal<HighProteinMeal> highProteinMeal = new Meal<>(new HighProteinMeal());
        highProteinMeal.generateMealPlan(new HighProteinMeal());
    }
}
