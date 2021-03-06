import java.util.*;

public class Stack {
	
	private int head;
	private ArrayList<StackFrame> stack;

	public Stack ( ) {
		head = 0;
		stack = new ArrayList<StackFrame>();
	}
	
	public Stack (StackFrame stk_frm) {
		head = 1;
		stack = new ArrayList<StackFrame>();
		stack.add(stk_frm);
	}

	public StackFrame get_top( ) {
		if (head < 1)
			throw new IllegalArgumentException("stack underflow");
		return stack.get(head - 1);
	}

	/* pops the current head off the stack
     	   returns the head */
	public StackFrame pop () {
		StackFrame ret;
		if (head < 1) 
			throw new IllegalArgumentException("stack underflow");
		else {
			ret = stack.get(head - 1);
			head -= 1;
		}
		return ret;
	}

	/* pushes a new StackFrame onto the stack
	   returns a reference to the stack */
	public Stack push (StackFrame stk_frm) {
		stack.add(head, stk_frm);
		head += 1;
		return this;
	}

	public boolean isEmpty() {
		return head == 0;
	}

	public void display( ) {
		get_top( ).display( );		
	}

	/* displays usefule debug information */
	public void debug() {
		int marker = head;
		while (marker > 0) {
			System.out.println(marker + "-------------");
			stack.get(marker - 1).debug();
			marker -= 1;
		}
	}
}