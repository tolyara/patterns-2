package behavioral.chain_of_responsibility;

public class ChainOfResponsibilityMain {
	
	public static void main(String[] args) {
		MessagePrinter consoleMessagePrinter = new ConsoleMessagePrinter();
		MessagePrinter fileMessagePrinter = new FileMessagePrinter();
		MessagePrinter databaseMessagePrinter = new DatabaseMessagePrinter();
		
		consoleMessagePrinter.setNextMessagePrinter(fileMessagePrinter);
		fileMessagePrinter.setNextMessagePrinter(databaseMessagePrinter);
		consoleMessagePrinter.doPrint("Hello");
	}

}

abstract class MessagePrinter {
	
	MessagePrinter nextMessagePrinter;

	public void setNextMessagePrinter(MessagePrinter messagePrinter) {
		this.nextMessagePrinter = messagePrinter;
	}
	
	void doPrint(String message) {
		printMessage(message);
		if (nextMessagePrinter != null) {
			nextMessagePrinter.doPrint(message);
		}
	}
	
	abstract void printMessage(String message);
	
}

class ConsoleMessagePrinter extends MessagePrinter {

	@Override
	void printMessage(String message) {
		System.out.println("Print to console: " + message);
	}
	
}

class FileMessagePrinter extends MessagePrinter {

	@Override
	void printMessage(String message) {
		System.out.println("Print to file: " + message);
	}
	
}

class DatabaseMessagePrinter extends MessagePrinter {

	@Override
	void printMessage(String message) {
		System.out.println("Print to database: " + message);
	}
	
}
