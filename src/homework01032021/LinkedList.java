package homework01032021;

public class LinkedList<T> implements List<T> {
	
	//I used some help for the first three methods (contains, add, and insertAt)
	//the rest I did on my own

	private Node<T> firstElement;
	private int size;

	public LinkedList() {
		// this.firstElement = new Node<>();
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (firstElement == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(T item) {
		if (this.isEmpty())
			return false;
		Node<T> temp = firstElement;
		do {
			if (temp.isEqual(item)) {
				return true;
			}
			temp = temp.getNext();
		} while (temp != null);

		return false;
	}

	@Override
	public void add(T item) {
		Node<T> newItem = new Node<>(item);
		if (this.isEmpty()) {
			this.firstElement = newItem;
		} else {
			Node<T> temp = firstElement;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newItem);
		}
		this.size++;
	}

	@Override
	public void insertAt(T item, int index) {
		validateIndex(index);
		if (index == 0) {
			Node<T> newItem = new Node<>(item, firstElement);
			firstElement = newItem;
		} else {
			int counter = 0;
			Node<T> temp = firstElement;
			while (counter < index) {
				temp = temp.getNext();
				counter++;
			}
			Node<T> nextTemp = temp.getNext();
			Node<T> newItem = new Node<>(item, nextTemp);
			temp.setNext(newItem);
		}
		this.size++;

	}

	@Override
	public void removeFrom(int index) {
		validateIndex(index);
		if (index == 0) {
			this.firstElement = firstElement.getNext();
		} else {
			Node<T> temp = firstElement;
			int counter = 0;
			while (counter < (index - 1)) {
				temp = temp.getNext();
				counter++;
			}
			Node<T> toBeRemoved = temp.getNext();
			temp.setNext(toBeRemoved.getNext());
		}
		this.size--;
	}

	@Override
	public void remove(T item) {
		if(getIndex(item) == -1)
			return;
		removeFrom(getIndex(item));
	}
	
	private int getIndex(T item) {
		int counter = 0;
		Node<T> temp = firstElement;
		while (temp != null) {
			if(temp.isEqual(item)) {
				return counter;
			}
			counter++;
			temp = temp.getNext();
		}
		return -1;
	}

	@Override
	public T get(int index) {
		validateIndex(index);
		int counter = 0;
		Node<T> temp = firstElement;
		while(counter < index)
		{
			temp = temp.getNext();
			counter++;
		}
		return temp.getData();
	}

	@Override
	public void clear() {
		this.size = 0;
	}

	private void validateIndex(int index) {
		if (index < 0 || index > this.size) {
			throw new IllegalArgumentException("Index is not valid.");
		}
	}
}
