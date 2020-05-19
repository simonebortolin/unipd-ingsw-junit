public interface Target<E>
{
	/**
	* Tests if this stack is empty.
	*/
	boolean	empty();
	
	/**
	* Looks at the object at the top of this stack without removing it from the stack.
	*/
	E peek();
	
	/**
	*Removes the object at the top of this stack and returns that object as the value of this function.
	*/
	E pop();
	
	/**
	*Pushes an item onto the top of this stack.
	*/
	E push(E item);
	
	/**
	*Returns the 1-based position where an object is on this stack.
	*/
	int	search(Object o);
}
