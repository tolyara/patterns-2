package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverMain {

	public static void main(String[] args) {
		News news = new News(); 
		news.addArticle("Coronavirus");
		news.addArticle("Putin");
		
		Observer reader1 = new Reader("Anatolii");
		Observer reader2 = new Reader("Elena");
		
		news.addReader(reader1);
		news.addReader(reader2);
		
		news.addArticle("Weather");
		news.removeArticle("Coronavirus");
	}
	
}

interface Observable {
	
	void notifyAllObservers();
	
}

class News implements Observable {
	
	List<String> articles = new ArrayList<String>();
	List<Observer> readers = new ArrayList<Observer>();

	public void addArticle(String article) {
		this.articles.add(article);
		notifyAllObservers();
	}
	
	public void removeArticle(String article) {
		this.articles.remove(article);
		notifyAllObservers();
	}

	public void addReader(Observer reader) {
		this.readers.add(reader);
	}

	public void removeReader(Observer reader) {
		this.readers.remove(reader);
	}
	
	@Override
	public void notifyAllObservers() {
		for (Observer reader: readers) {
			reader.update(articles);
		}
	}	
	
}

interface Observer {
	
	void update(List<String> article);
	
}

class Reader implements Observer {
	
	String name;

	public Reader(String name) {
		this.name = name;
	}

	@Override
	public void update(List<String> article) {
		System.out.println("Reader " + name + " have got new changes in articles: " + article);
	}	
	
}










