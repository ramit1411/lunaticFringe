package stackAndQueues;

public class CircularQueue {
	protected int[] data;
	private static final int DEFAULT_SIZE = 10;
	
	protected int end = 0;
	protected int front = 0;
	private int size = 0;
	
	public CircularQueue(int size) {
		this.data = new int[size];
	}
	
	public CircularQueue() {
		this(DEFAULT_SIZE);
	}
	
	public boolean isFull() {
		return size == data.length; //last index
	}
	
	private boolean isEmpty() {
		return size == 0; 
	}
	
	
	public boolean insert(int item) {
		if(isFull()) {
			return false;	
		}
		
		data[end++] = item;
		end = end % data.length;
		size++;
		return true;
	}
	
	public int remove() throws Exception {
		if(isEmpty()) {
			throw new Exception("QUEUE is Empty");
		}
		
		int removed = data[front++];
		front = front%data.length;
		size--;
		return removed;
	}
	
	public int front() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		
		return data[front];
	}
 	
	
	public void display() {
		if(isEmpty()) {
			System.out.print("EMPTY");
			return;
		}
		int i = front;
		do {
			System.out.print(data[i] + " -> ");
			i++;
			i %= data.length;
		}while(i!=end);

		
		System.out.print("END");
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		CircularQueue queue = new CircularQueue(5);
		queue.insert(3);
		queue.insert(6);
		queue.insert(5);
		queue.insert(33);
		queue.insert(1);
		
		queue.display();
		System.out.println();
		System.out.println(queue.remove());
		
		queue.insert(133);
		
		queue.display();
		
		
		
	}
}
