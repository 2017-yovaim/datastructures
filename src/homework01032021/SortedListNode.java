package homework01032021;

public class SortedListNode<T extends Comparable<T>> implements List<T> {

	class Node<T>
	{
		private T data;
		private Node<T> previous;
		private Node<T> next;
		
		public Node()
		{
			this(null, null, null);
		}
		
		public Node(T dataValue)
		{
			this(dataValue, null, null);
		}
		
		public Node(T dataValue, Node<T> nextValue)
		{
			this(dataValue, nextValue, null);
		}
		
		public Node(T dataValue, Node<T> nextValue, Node<T> previousValue)
		{
			this.data = dataValue;
			this.next = nextValue;
			this.previous = previousValue;
		}
		
		public T getData()
		{
			return this.data;
		}
		
		public Node<T> getNext()
		{
			return this.next;
		}
		
		public Node<T> getPrevious()
		{
			return this.previous;
		}
		
		public void setNext(Node<T> nextValue)
		{
			this.next = nextValue;
		}
		
		public void setPrevious(Node<T> previousValue)
		{
			this.previous = previousValue;
		}
		
		public boolean isEqual(T toCompare)
		{
			if(this.data != null)
			{
				return data.equals(toCompare);
			}
			return false;
		}
	}
	
	private Node<T> firstElement;
	private int size;
	
	public SortedListNode(Node<T> firstElementValue)
	{
		this.firstElement = firstElementValue;
	}
	
	public SortedListNode()
	{
		this(null);
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		//O(n) = const
		return size <= 0;
	}

	@Override
	public boolean contains(T item) {
		//O(n) = n
		if(this.isEmpty())
			return false;
		Node<T> temp = firstElement;
		do
		{
			if(temp.isEqual(item))
				return true;
			temp = temp.getNext();
		} while(temp.getNext() != null);
		return false;
	}

	@Override
	public void add(T item) {
		//O(n) = n
		Node<T> newItem = new Node<>(item);
		if(this.isEmpty())
		{
			this.firstElement = newItem;
		}
		else
		{
			Node<T> temp = firstElement;
			while(temp.getNext() != null)
			{
				if((item.compareTo(temp.getPrevious().getData()) > 0) && (item.compareTo(temp.getNext().getData()) >= 0))
				{
					newItem.setPrevious(temp.getPrevious());
					newItem.setNext(temp.getNext());
					temp.getPrevious().setNext(newItem);
					temp.getNext().setPrevious(newItem);
					this.size++;
					return;
				}
			}
			newItem.setPrevious(temp);
			temp.setNext(newItem);
			this.size++;
		}
		
	}

	@Override
	public void insertAt(T item, int index) {
		//won't be used since this is a sorted list and we can't allow users to just insert
		//elements wherever they want in the list
		
	}

	@Override
	public void removeFrom(int index) {
		//O(n) = n
		validateIndex(index);
		if(index == 0)
		{
			this.firstElement = firstElement.getNext();
		}
		else
		{
			Node<T> temp = firstElement;
			int counter = 0;
			while(counter < (index - 1))
			{
				temp = temp.getNext();
				counter++;
			}
			Node<T> toBeRemoved = temp.getNext();
			temp.setNext(toBeRemoved.getNext());
			temp.setPrevious(toBeRemoved.getPrevious());
		}
		this.size--;
		
	}

	@Override
	public void remove(T item) {
		//O(n) = const, but with O(n) of removeFrom(int index) it's n
		int index = getIndex(item);
		if(index == -1)
			return;
		removeFrom(index);
		
	}

	@Override
	public T get(int index) {
		//O(n) = n
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
		//O(n) = const
		this.size = 0;
		
	}
	
	private void validateIndex(int index)
	{
		//O(n) = const
		if(index < 0 || index > this.size - 1)
		{
			throw new IllegalArgumentException("Your index isn't valid.");
		}
	}
	
	private int getIndex(T item)
	{
		//O(n) = n
		int counter = 0;
		Node<T> temp = firstElement;
		while(temp != null)
		{
			if(temp.isEqual(item))
			{
				return counter;
			}
			counter++;
			temp = temp.getNext();
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
