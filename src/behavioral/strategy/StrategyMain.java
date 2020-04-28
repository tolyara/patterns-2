package behavioral.strategy;

public class StrategyMain {

	public static void main(String[] args) {
//		double price = 100 * 0.7;      shop discounts 
//		System.out.println(price);
		
		double fullPrice = 100;		
		Context context = new Context();
		
		context.setStrategy(new FullPrice());
		double actualPrice1 = context.getActualPrice(fullPrice);
		System.out.println(actualPrice1);
		
		context.setStrategy(new HalfPrice());
		double actualPrice2 = context.getActualPrice(fullPrice);
		System.out.println(actualPrice2);
		
		context.setStrategy(new QuarterPrice());
		double actualPrice3 = context.getActualPrice(fullPrice);
		System.out.println(actualPrice3);
	}

}

interface DiscountStrategy {

	double getActualPrice(double price);

}

class FullPrice implements DiscountStrategy {

	@Override
	public double getActualPrice(double price) {
		return price;
	}

}

class HalfPrice implements DiscountStrategy {

	@Override
	public double getActualPrice(double price) {
		return price * 0.5;
	}

}

class QuarterPrice implements DiscountStrategy {

	@Override
	public double getActualPrice(double price) {
		return price * 0.25;
	}

}

class Context {

	DiscountStrategy strategy;

	public Context(DiscountStrategy strategy) {
		this.strategy = strategy;
	}
	
	public Context() {

	}

	public DiscountStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(DiscountStrategy strategy) {
		this.strategy = strategy;
	}

	double getActualPrice(double price) {
		return strategy.getActualPrice(price);
	}
	
}

//