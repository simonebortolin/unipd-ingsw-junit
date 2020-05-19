import java.util.*;

public class ClassAdapter<E>
extends Adaptee<E>
implements Target<E>
{
	/**
	* Tests if this stack is empty.
	*/
	public boolean empty()
	{
		return size() == 0;
	}
	
	/**
	* Looks at the object at the top of this stack without removing it from the stack.
	*/
	public E peek()
	{
		try
		{
			return super.peek(0);
		}
		catch(NoSuchElementException nsee)
		{
			EmptyStackException see =  new EmptyStackException();
			see.initCause(nsee);
			throw see;
		}
	}
	
	/**
	*Removes the object at the top of this stack and returns that object as the value of this function.
	*/
	public E pop()
	{
		//vi faccio vedere la soluzione diversa, ma e' meglio essere consistenti
		if(size() == 0)
		{
			throw new EmptyStackException();
		}

		E retval = super.peek(0);
		remove(0);
		return retval;
	}
	
	/**
	*Pushes an item onto the top of this stack.
	*/
	public E push(E item)
	{
		insert(0, item);
		return item;
	}
	
	/**
	*Returns the 1-based position where an object is on this stack.
	*/
	public int search(Object o)
	{
		int retval = search(o);
		if(retval == -1)
		{
			return -1;
		}
		else
		{
			return retval + 1;
		}
	}
}
