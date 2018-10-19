import java.util.EmptyStackException;

public class ArrayStack implements Stack{

	private final int size = 10;
	private int top;
	private Object[] arr;

	public ArrayStack() {
		top = 0;
		arr = new Object[size];
	}

	public void push(Object item){
		if(top == arr.length) {
			resize(2*arr.length);
		}
		arr[top++] = item;
	}

	public Object pop(){
		if(empty()) {
			throw new EmptyStackException();
		}
		Object newarr = arr[top-1];
		arr[top-1] = null;
		top--;
		if(top > 0 && top == arr.length/4) {
			resize(arr.length/2);
		}
		return newarr;
	}

	public Object peek(){
		if(empty()) {
			throw new EmptyStackException();
		}
		return arr[top-1];
	}

	public void resize(int length) {
		Object[] newarr = new Object[length];
		for(int i = 0; i < top; i++) {
			newarr[i] = arr[i];
		}
		arr = newarr; 
	}

	public int size() {
		return top;
	}

	public boolean empty(){
		return top == 0;
	}
}