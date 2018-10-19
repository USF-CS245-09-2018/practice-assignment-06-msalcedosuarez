import java.util.NoSuchElementException;
import java.lang.Object;

public class ArrayQueue implements Queue {

	private final int size = 10;
	private int head;
	private int tail;
	private Object[] arr;
	private int numSize;

	public ArrayQueue() {
		tail = 0;
		head = 0;
		numSize = 0;
		arr = new Object[size];
	}

	public Object dequeue() {
		if(empty()) {
			throw new NoSuchElementException("Queue is Empty");
		}
		Object obj = arr[head];
		arr[head] = null;
		numSize--;
		if(head == arr.length) {
			head = 0;
		}
		else {
			head++;
		}
		if(numSize == arr.length/4) {
			grow_array(arr.length/2);
			head = 0;
			tail = numSize -1;
		}
		return obj;
	}

	public void enqueue(Object item) {
		if(numSize == arr.length) {
			grow_array(2*arr.length);
			head = 0;
			tail = numSize -1;
		}
		if(empty()) {
			head = tail = 0;
		}
		else if(tail == arr.length -1) {
			tail = 0;
		}
		else {
			tail++;
		}
		arr[tail] = item;
		numSize++;
	}

	public void grow_array(int length) {
		Object[] newarr = new Object[length];
		int current = head;
		for(int i = 0; i < numSize; i++) {
			newarr[i] = arr[current];
			if(current == arr.length-1) {
				current = 0;
			}
			else {
				current++;
			}
		}
		arr = newarr;
	}

	public boolean empty() {
		return numSize == 0;
	}

	public int size(){
		return numSize;
	}
}