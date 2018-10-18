
import java.lang.Object;

public class ArrayQueue implements Queue {

	private final int size = 10;
	private int head;
	private int tail;
	private Object[] arr;


	public ArrayQueue() {
		tail = 0;
		head = 0;
		arr = (Object[]) new Object[size];
	}

	public ArrayQueue(int capacity) {
		tail = 0;
		head = 0;
		arr = (Object[]) new Object[capacity];
	}

	public Object dequeue() {
		//Assert.not_false(head == tail);
		return arr[head++];
	}

	public void enqueue(Object item) {
		//try{
			//Assert.not_false(tail + 1 != head);
		//}
		//catch(Exception e){
			grow_array();
		//}
	}

	public void grow_array() {
		Object[] newarr = new Object[arr.length*2];
		for(int i = 0; i < arr.length; i++) {
			newarr[i] = arr[i];
		}
		arr = newarr;
	}

	public boolean empty() {
		return tail == 0;
	}
}