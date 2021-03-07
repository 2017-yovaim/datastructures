package homework01032021;

public interface List <T>
{
	boolean isEmpty();
	boolean contains (T item);
	void add(T item);
	void insertAt(T item, int index);
	void removeFrom(int index);
	void remove(T item);
	T get(int index);
	void clear();
}
