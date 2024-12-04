
public class LinkedStack<T extends Comparable<T>> implements Stackable<T> {

	private Node<T> topNode;

	@Override
	public void push(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(topNode);
		topNode = newNode;
	}

	@Override
	public T pop() {
		T toDel = topNode.getData();
		if (topNode != null)
			topNode = topNode.getNext();
		return toDel;
	}

	public int length() {
		int length = 0;
		Node<T> curr = topNode;
		while (curr != null) {
			length++;
			curr = curr.getNext();
		}
		return length;
	}

	@Override
	public boolean isEmpty() {
		return (topNode == null);
	}

	@Override
	public void clear() {
		topNode = null;
	}

	@Override
	public T peek() {
		if (isEmpty()) return null;
		return topNode.getData();
	}
}
