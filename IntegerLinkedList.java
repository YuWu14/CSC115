/*
 * Name:YUWU
 * Student Number:V00917423
 */

public class IntegerLinkedList implements IntegerList
{
	private int[] storage;
	private int count;
	private IntegerNode head;
	private IntegerNode tail;
	
	public IntegerLinkedList()
	{	
		storage = new int[1];
		count = 0;
	}

	/*
	 * PURPOSE:
	 *   Add the element x to the front of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * Examples:
	 *
	 * If l is {1,2,3} and l.addFront(9) returns, then l is {9,1,2,3}.
	 * If l is {} and l.addFront(3) returns, then l is {3}.
	 */
	public void addFront (int x)
	{	IntegerNode n = new IntegerNode();
		n.value = x;
		if (head == null){
			head = n;
			tail = n;
		}
		else{
			head.prev = n;
			n.next = head;
			head = n;
			
		}
		count = count + 1;
	}


	/*
	 * PURPOSE:
	 *   Add the element x to the back of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * Examples:
	 *
	 * If l is {1,2,3} and l.addBack(9) returns, then l is {1,2,3,9}.
	 * If l is {} and l.addBack(9) returns, then l is {9}.
	 */
	public void addBack (int x)
	{	
		IntegerNode n = new IntegerNode();
		n.value = x;
		if(head == null){
			head = n;
			tail = n;
		}
		else{
			tail.next = n;
			n.prev = tail;
			tail = n;
		}		
		count = count + 1;
	}

	/*
	 * PURPOSE:
	 *   Add the element x at position pos in the list.
	 *
	 * Note:
	 *   In a list with 3 elements, the valid positions for addAt are
	 *   0, 1, 2, 3.
	 *
	 * PRECONDITIONS:
	 *   pos >= 0 and pos <= l.size()
	 *
	 * Examples:
	 *
	 * If l is {} and l.addAt(9,0) returns, then l is {9}.
	 * If l is {1} and l.addAt(9,0) returns, then l is {9,1}.
	 * If l is {1,2} and l.addAt(9,1) returns, then l is {1,9,2}
	 * If l is {1,2} and l.addAt(9,2) returns, then l is {1,2,9}
	 */
	public void addAt (int x, int pos)
	{	
		if(pos == 0){
			IntegerNode n = new IntegerNode();
			n.value = x;
			if (head == null){
				head = n;
				tail = n;
			}
			else{
				head.prev = n;
				n.next = head;
				head = n;
				
			}
			count = count + 1;
		}
		else if(pos == count && pos != 0){
			IntegerNode n = new IntegerNode();
			n.value = x;
			if(head == null){
				head = n;
				tail = n;
			}
			else{
				tail.next = n;
				n.prev = tail;
				tail = n;		
			count = count + 1;
			}
		}
		else if(pos < count && pos != 0){
			IntegerNode p = new IntegerNode(x);
			IntegerNode m = head;
			int a = 0;
			while(a != pos-1){
				a = a+1;
				m = m.next;
			}
			m.next.prev = p;
			p.next = m. next;
			m.next = p;
			p.prev = m;
			count = count + 1;
		}
	}

	/*
	 * PURPOSE:
	 *	Return the number of elements in the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {7,13,22} l.size() returns 3
	 *	If l is {} l.size() returns 0
	 */
	public int size()
	{
		return count;
	}

	/*
	 * PURPOSE:
	 *   Return the element at position pos in the list.
	 *
	 * PRECONDITIONS:
	 *	pos >= 0 and pos < l.size()
	 *
	 * Examples:
	 *	If l is {67,12,13} then l.get(0) returns 67
	 *	If l is	{67,12,13} then l.get(2) returns 13
	 *	If l is {92} then the result of l.get(2) is undefined.
	 *
	 */
	public int  get (int pos)
	{	int x = 0;
		IntegerNode p = head;
		while ( x < pos){
			x = x + 1;
			p = p.next;
		}
		
		return p.value;
	}

	/*
	 * PURPOSE:
	 *   Remove all elements from the list.  After calling this
	 *   method on a list l, l.size() will return 0
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {67,12,13} then after l.clear(), l is {}
	 *	If l is {} then after l.clear(), l is {}
	 *
	 */
	public void clear()
	{	head = null;
		tail = null;
		count = 0;

	}

	/*
	 * PURPOSE:
	 *   Remove all instances of value from the list.
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {67,12,13,12} then after l.remove(12), l is {67,13}
	 *	If l is {1,2,3} then after l.remove(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(99), l is {1,2,3}
	 */
	public void remove (int value)
	{	IntegerNode p = head;
		int b = 0;
		int x = value;
		if(count == 1){
			if(head.value == x){
				head = null;
				tail = null;
				b = 1;
			}
			else if(tail.value == x){
				head = null;
				tail = null;
				b = 1;
			}
		}
		else if (count <=2 && count != 1){
			if(head.value == x && head.next != null){
				head.next.prev = null;
				head = head.next;
				b = b+1;
			}
			if(tail.value == x && tail.prev != null){
				tail.prev.next = null;
				tail = tail.prev;
				b = b+1;
			}
		}
		else if(head.value == x){
			head.next.prev = null;
			head = head.next;
			b = b + 1;
		}
		else if(tail.value == x){
			tail = tail.prev;
			tail.next = null;
			b = b + 1;
				
		}
		else if (count == 3){
			if(head.value == x){
				head.next.prev = null;
				head = head.next;
				b = b + 1;
			}
			if(tail.value == x){
				tail.prev.next = null;
				tail = tail.prev;
				b = b + 1;
			}
			if(head.next.value == x){
				head.next = tail;
				tail.prev = head;
				b = b+1;
				
			}
			
		}
		

		if (count > 3 ){
			int a = 0 ;
			
			IntegerNode m = head;
			while(a < count){
				if(m.value == x){
					if(head.value == x && head.next != null){
						head.next.prev = null;
						head = head.next;
						b = b + 1;
					}
					else if(tail.value == x && tail.prev != null){
						tail.prev.next = null;
						tail = tail.prev;
						b = b + 1;	
					}

					else if (m.next != null && m.prev != null){	
						m.next.prev = m.prev;
						m.prev.next = m.next;
						b = b + 1;
					}
				}
				a = a+1;
				if( m.next != null){
					m = m.next;
				}
				
			}
			if ( head.value == x && b == count - 1){
				head = null;
				tail = null;
				b = count;
			}
		}
		count = count - b;
		
		if(count == 1 && head.value == value){
			head = null;
			tail = null;
			count = 0;
		}
	}

	/*
	 * PURPOSE:
	 *   Remove the element at position pos in the list.
	 *
	 * Note:
	 *   In a list with 3 elements, the valid positions for removeAt are
	 *   0, 1, 2.
	 *
	 * PRECONDITIONS:
	 *   pos >= 0 and pos < l.size()
	 *
	 * Examples:
	 *
	 * If l is {1} and l.removeAt(0) returns, then l is {}.
	 * If l is {1,2,3} and l.removeAt(1) returns, then l is {1,3}
	 * If l is {1,2,3} and l.removeAt(2) returns, then l is {1,2}
	 */
	 
	public void removeAt (int pos)
	{	

		if (pos ==0){
			if (count == 1){
				head = null;
				tail = null;
				count = 0;
			}
				
			else{
				head.next.prev = null;
				head = head.next;
				count = count - 1;
			}
		}
			
		else if ( pos == count-1){
			tail.prev.next = null;
			tail = tail.prev;
			count = count - 1;
		
		}
		else if(pos < count-1){
			IntegerNode p = head;
			int a = 0;
			while (a != pos){
				a = a+1;
				p = p.next;
			}
			p.next.prev = p.prev;
			p.prev.next = p.next;
			count = count -1;
		}
	}

	/*
	 * PURPOSE:
	 *	Return a string representation of the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {1,2,3,4} then l.toString() returns "{1,2,3,4}"
	 *	If l is {} then l.toString() returns "{}"
	 *
	 */
	public String toString()
	{	
		IntegerNode p = head;
		String s = "{";
		while (p != null){
			s += p.value;
			if(p.next != null){
				s += ",";
			}
			p = p.next;
			
		}
		s += "}";
		return s;
	}
}
