public class StackRefBased<T> implements Stack<T> {
	
	private StackNode<T> head;
	private StackNode<T> tail;
	private int count;
	private T[] storage;

    public StackRefBased() {
		head = null;
    }

    public int size() {
        return count;
    }


    public boolean isEmpty() {
		if ( count == 0 ){
			return true;}
		else{
        return false;
		}
    }


    public void push(T data) {
        StackNode<T> n = new StackNode<T>(data);
		n.next = head;
		head = n;
		count = count + 1;
    }


    public T pop() throws StackEmptyException {
		if(count == 0){
			throw new StackEmptyException();
		}
		T m = head.data;
		if(head.next!=null){
			StackNode<T> n = head.next;
			head = n;
			count = count - 1;
		}
		else if(count == 1){
			head = null;
			count = 0;
		}
		
		return m;
    }


    public T peek() throws StackEmptyException {
		if(count == 0){
			throw new StackEmptyException();
		}
        return head.data;
    }


    public void makeEmpty() {
		head = null;
		tail = null;
		count = 0;
		
    }


    public String toString() {
		StackNode<T> p = head;
		String s = "{";
		while(p!= null){
			s += p.data;
			if(p.next != null){
				s += ",";
			}
			p = p.next;
			
		}
		s += "}";
        return s;
    }
}

