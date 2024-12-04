
public class MyType <T extends Comparable <T>> implements Comparable<MyType>{
	
	
	T data;
	LinkedStack<T> k=new LinkedStack<>();
	
	
	public MyType(T data) {
		this.data=data;
		insert(data);
		
	}
	
	public T getData() {
		return k.peek();
	}
	
	public void insert(T data) {
		k.push(data);
	}
	
	

	@Override
	public int compareTo(MyType o) {
		return this.getData().compareTo((T) o.getData());
	}
@Override 
public String toString() {
	return data.toString();
}
}

