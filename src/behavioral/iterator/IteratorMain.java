package behavioral.iterator;

public class IteratorMain {

	public static void main(String[] args) {
		GirlsContainer girls = new GirlsContainer();
		Iterator iterator = girls.getIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}

interface Iterator {

	boolean hasNext();

	Object next();

}

interface Container {

	Iterator getIterator();

}

class GirlsContainer implements Container {

	String[] girls = { "Sisi", "Amy", "Dilayla" };

	@Override
	public Iterator getIterator() {
		return new GirlsIterator();
	}

	private class GirlsIterator implements Iterator {

		int index;

		@Override
		public boolean hasNext() {
			return index < girls.length;
		}

		@Override
		public Object next() {
			return girls[index++];
		}

	}

}