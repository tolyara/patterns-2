package behavioral.interpreter;

import java.util.Stack;

public class InterpreterMain {

	public static void main(String[] args) {
//		String expression = "1 + 2 + 3 + 4";
		String expression = "1+2+6-1";
		Expression evaluator = new Evaluate(expression);
		System.out.println(evaluator.interpret(evaluator));
	}
	
}

interface Expression {
	
	int interpret(Expression context);
	
}

class Number implements Expression {
	
	int number;

	public Number(int number) {
		this.number = number;
	}

	@Override
	public int interpret(Expression context) {
		return number;
	}
		
}

class Plus implements Expression {

	Expression expressionLeft;
	Expression expressionRight;
	
	public Plus(Expression expressionLeft, Expression expressionRight) {
		this.expressionLeft = expressionLeft;
		this.expressionRight = expressionRight;
	}

	@Override
	public int interpret(Expression context) {		
		return expressionLeft.interpret(context) + expressionRight.interpret(context);
	}
	
}

class Minus implements Expression {

	Expression expressionLeft;
	Expression expressionRight;
	
	public Minus(Expression expressionLeft, Expression expressionRight) {
		this.expressionLeft = expressionLeft;
		this.expressionRight = expressionRight;
	}

	@Override
	public int interpret(Expression context) {		
		return expressionLeft.interpret(context) - expressionRight.interpret(context);
	}
	
}

//works only with digits
class Evaluate implements Expression {
	
	Expression evaluate;

	public Evaluate(String expression) {
		parseExpression(expression);
	}
	
	void parseExpression(String expression) {
		Stack<Expression> expressions = new Stack<>();
		String expressionReversed = new StringBuilder(expression).reverse().toString();
		for (String string : expressionReversed.split("\\D")) {
			expressions.push(new Number(Integer.parseInt(string)));
		}
		for (String string : expression.split("\\d")) {
			if (string.equals("+")) {
				expressions.push(new Plus(expressions.pop(), expressions.pop()));
			} else if (string.equals("-")) {
				expressions.push(new Minus(expressions.pop(), expressions.pop()));
			}
		}
		evaluate = expressions.pop();
	}

	@Override
	public int interpret(Expression context) {
		return evaluate.interpret(context);
	}
	
}





