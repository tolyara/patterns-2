package behavioral.state;

public class StateMain {

	public static void main(String[] args) {
		Context context = new Context(new LowerCaseState(), "Anatolii is a Java developer");
		context.showState();
		context.setState(new UpperCaseState());
		context.showState();
	}
	
}

interface State {
	
	void doAction(Context context);
	
}

class LowerCaseState implements State {

	@Override
	public void doAction(Context context) {
		System.out.println(context.name.toLowerCase());
	}
	
}

class UpperCaseState implements State {

	@Override
	public void doAction(Context context) {
		System.out.println(context.name.toUpperCase());
	}
	
}

//Context
class Context {
	
	State state;
	String name;
	
	public Context(State state, String name) {
		this.state = state;
		this.name = name;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	void showState() {
		state.doAction(this);
	}
	
	
}