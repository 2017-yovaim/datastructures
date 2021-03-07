package homework01032021;

public class Node<T>
{
	private T data;
	private Node<T> next;
	
	public Node()
	{
		this(null);
	}
	
	public Node (T dataValue)
	{
		this(dataValue, null);
	}
	
	public Node(T dataValue, Node<T> nextValue)
	{
		this.data = dataValue;
		this.next = nextValue;
	}
	
	public void setData(T dataValue)
	{
		this.data = dataValue;
	}
	
	public void setNext(Node<T> nextValue)
	{
		this.next = nextValue;
	}
	
	public T getData()
	{
		return this.data;
	}
	
	public Node<T> getNext()
	{
		return this.next;
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
