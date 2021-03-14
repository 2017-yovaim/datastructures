package homework01032021;

public class SortedList <T extends Comparable<T>> implements List<T>{

	private Object[] arr;
	private int index;
	
	public SortedList()
	{
		//O(n) = const
		arr = new Object[100];
		index = 0;
	}
	
	public SortedList(int size)
	{
		//O(n) = const
		if(size <= 0)
		{
			throw new IllegalArgumentException("The size of your array must be greater than 0.");
		}
		arr = new Object[size];
		index = 0;
	}
	
	public int getIndex()
	{
		//O(n) = const
		return this.index;
	}
	
	
	private boolean validateIndex(int index)
	{
		//O(n) = const
		if(index < 0 || index > this.index)
		{
			return false;
		}
		return true;
	}
	
	private void expandArray()
	{
		Object[] newArray = this.arr;
		this.arr = new Object[newArray.length * 2];
		for(int i = 0; i < newArray.length; i++)
		{
			this.arr[i] = newArray[i];
		}
	}
	
	
	@Override
	public boolean isEmpty() {
		//O(n) = const
		return index <= 0;
	}

	@Override
	public boolean contains(T item) {
		//rewrite this with binary search
		//O(n) = n
		for(int i = 0; i < index; i++)
		{
			if(((T)arr[i]).equals(item))
			{
				return true;
			}
		}
		return false;
	}
	

	@Override
	public void add(T item) {
		//O(n) = n * n
		if(this.index >= this.arr.length || this.index + 1 >= this.arr.length)
		{
			expandArray();
		}
		if(index == 0)
		{
			arr[index] = item;
			index++;
			return;
		}
		for(int i = 0; i < this.index - 1; i++)
		{
			if(arr[i + 1] == null)
			{
				arr[i + 1] = item;
			}
			if(arr[i + 1] != null && 
					(item.compareTo((T)arr[i]) > 0) && (item.compareTo((T)arr[i + 1]) < 0))
			{
				for(int j = this.index; j >= i + 1; j--)
				{
					arr[j + 1] = arr[j];
				}
				arr[i + 1] = item;
			}
		}
		this.index++;
		
	}

	@Override
	public void insertAt(T item, int index) {
		//this method won't be used since we need the array to be sorted
		//therefore, we can't allow users to insert elements wherever they want in the array
		
	}

	@Override
	public void removeFrom(int index) {
		//O(n) = n
		if(validateIndex(index) == false)
		{
			throw new IllegalArgumentException("Your index isn't correct - removeFrom(int index).");
		}
		for(int i = index + 1; i < this.index; i++)
		{
			arr[i] = arr[i - 1];
		}
		this.index--;
		
	}

	@Override
	public void remove(T item) {
		//O(n) = const
		int index = getIndex(item);
		if(index == -1)
			return;
		removeFrom(index);
		
	}
	
	private int getIndex(T item)
	{
		//O(n) = n
		for(int i = 0; i < index; i++)
		{
			if(item.equals(arr[i]))
			{
				return i;
			}
		}
		return -1;
	}

	@Override
	public T get(int index) {
		//O(n) = const
		if(validateIndex(index) == false)
		{
			throw new IllegalArgumentException("Your index is not correct - get(int index).");
		}
		return (T)arr[index];
	}

	@Override
	public void clear() {
		//O(n) = const
		this.index = 0;
		
	}
	
	public String toString()
	{
		//O(n) = n
		String result = "";
		for(int i = 0; i < index; i++)
		{
			result = result + arr[i] + " ";
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		SortedList<Integer> sl = new SortedList<>(10);
		sl.add(1);
		sl.add(2);
		sl.add(3);
		System.out.println(sl.toString());
	}
}
