package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorMain {

	public static void main(String[] args) {
		ConcreteServer server = new ConcreteServer();
		server.addCollegue(new ConcreteCollegue(1, server));
		server.addCollegue(new ConcreteCollegue(2, server));

		Collegue collegue = new ConcreteCollegue(3, server);
		server.addCollegue(collegue);
		collegue.changeStatus();
	}

}

//mediator
interface Server {

	void requestAll(Collegue collegue);

}

class ConcreteServer implements Server {

	List<Collegue> collegues = new ArrayList<Collegue>();

	void addCollegue(Collegue collegue) {
		collegues.add(collegue);
	}

	@Override
	public void requestAll(Collegue collegue) {
		collegue.setTrue();
		for (Collegue coll : collegues) {
			if (coll != collegue) {
				coll.setFalse();
			}
		}
	}

}

interface Collegue {

	void setFalse();

	void setTrue();

	void changeStatus();

}

class ConcreteCollegue implements Collegue {

	int id;
	boolean status;
	Server server;

	public ConcreteCollegue(Server server) {
		this.server = server;
	}

	public ConcreteCollegue(int id, Server server) {
		this.id = id;
		this.server = server;
	}

	@Override
	public void setFalse() {
		status = false;
		System.out.println("Status of collegue with id = " + id + " changed to " + status);
	}

	@Override
	public void setTrue() {
		status = true;
		System.out.println("Status of collegue with id = " + id + " changed to " + status);
	}

	@Override
	public void changeStatus() {
		server.requestAll(this);
	}

}
