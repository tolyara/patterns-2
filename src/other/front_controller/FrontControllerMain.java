package other.front_controller;

import java.util.Scanner;

public class FrontControllerMain {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNext()) {
				new DispatcherServlet().process(scanner.nextLine());
			}
		}
	}

}

class DispatcherServlet {

	public void process(String url) {
		switch (url.toLowerCase()) {
		case "home":
			new HomeController().show();;
			break;
		case "user":
			new UserController().show();;
			break;
		default:
			new ErrorController().show();;
			break;
		}
	}

}

class HomeController {

	void show() {
		System.out.println("Home page");
	}

}

class UserController {

	void show() {
		System.out.println("User page");
	}

}

class ErrorController {

	void show() {
		System.out.println("Error");
	}

}