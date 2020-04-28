package behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class CommandMain {

	public static void main(String[] args) {
		User user = new User();
		Laptop laptop = new Laptop();
		user.addCommand(new MouseClick(laptop));
		user.addCommand(new KeyboardPress(laptop));
		user.runCommands();		
	}
	
}

interface Command {
	
	void execute();
	
}

class MouseClick implements Command {

	Laptop laptop;
	
	public MouseClick(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public void execute() {
		laptop.mouseClick();
	}
	
}

class KeyboardPress implements Command {

	Laptop laptop;
	
	public KeyboardPress(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public void execute() {
		laptop.keyboardPress();
	}
	
}

//Invoker
class User {
	
	List<Command> commands = new ArrayList<>();
	
	void addCommand(Command command) {
		commands.add(command);
	}
	
	void runCommands() {
		for (Command command : commands) {
			command.execute();
		}
	}
	
}

class Laptop {
	
	void mouseClick() {
		System.out.println("Mouse clicked...");
	}
	
	void keyboardPress() {
		System.out.println("Keyboard pressed...");
	}
	
}

//





