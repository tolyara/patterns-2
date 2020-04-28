package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightMain {
	
	public static void main(String[] args) {
		MagicFridge fridge = new MagicFridge();
		
		FoodProduct bread = fridge.getProduct("Bread");
		System.out.println(bread.name);
		
		FoodProduct cheese = fridge.getProduct("Cheese");
		System.out.println(cheese.name);
		FoodProduct cheese2 = fridge.getProduct("Cheese");
		System.out.println(cheese2.name);
	}

}

class FoodProduct {
	
	String name;

	public String getName() {
		return name;
	}

	public void create(String name) {
		System.out.println("Creating new product position - " + name);
		this.name = name;
	}
	
}

class MagicFridge {
	
	Map<String, FoodProduct> products = new HashMap<String, FoodProduct>();
	
	FoodProduct getProduct(String productName) {
		FoodProduct product = products.get(productName);
		if (product == null) {
			product = new FoodProduct();
			product.create(productName);
			products.put(productName, product);
		}
		return product;
	}
	
}