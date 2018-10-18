import java.util.EmptyStackException;

public class ArrayStack implements Stack{

	private final int size = 10;
	private int top;
	private Object[] arr;

	public ArrayStack() {
		top = 0;
		arr = (Object[]) new Object[size];
	}

	public ArrayStack(int capacity) {
		top = 0;
		arr = (Object[]) new Object[capacity];
	}

	public void push(Object item){

		arr[++top] = item;
	}

	public Object pop(){
		if(!empty()) {
			return top--;
		}
		throw new EmptyStackException();
	}

	public Object peek(){
		if(!empty()) {
			return arr[top];
		}

		throw new EmptyStackException();
	}

	public boolean empty(){
		return top == 0;
	}
}