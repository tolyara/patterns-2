package other.dao;

public class DaoMain {

	public static void main(String[] args) {
		Database database = new PostgreSQL();
		System.out.println(database.getData());
	}
	
}

interface Database {
	
	String getData();
	
}

class PostgreSQL implements Database {

	@Override
	public String getData() {		
		return "Postgres data";
	}
	
}

class MySQL implements Database {

	@Override
	public String getData() {
		return "MySQL data";
	}
	
}