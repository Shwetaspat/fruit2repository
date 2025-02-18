package rpncalculator;


import java.util.Stack;


public class RPNCalculator2 {

	double firstOperand;
	double secondOperand;
	double result;
	Stack<Double> stack = new Stack<Double>();
	Operations operation;

	public double evaluate(String input) {
		
		// TODO Auto-generated method stub
		String[] tokens = input.split(" ");
		
		for(String token : tokens) {
			if(isMathOperator(token) == true) {
				extractInputs();
				Operations mathOperation = MathFactory.getObject(token);
				double result = mathOperation.calculate(firstOperand,secondOperand);
				stack.push(result);
			}
			else {
				
				pushStack(Double.parseDouble(token));
			}
			
		}
		
		return popStack();
	}
	
	private boolean isMathOperator(String token) {
		// TODO Auto-generated method stub
		String operators = "+-/*";
			return operators.contains(token);
	}

	public void performOperation(Stack <Double> stack, Operations operation) {
		extractInputs();		
		double result=operation.calculate(firstOperand, secondOperand);
		pushStack(result);
		

	}

	private void extractInputs() {
		secondOperand = popStack();
		firstOperand = popStack();
	}
	public double popStack() {
		return stack.pop();
	}
	public void pushStack(double result) {
		 stack.push(result);
	}
}
