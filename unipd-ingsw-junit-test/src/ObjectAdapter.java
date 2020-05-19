import java.util.*;

public class ObjectAdapter<E>
implements Target<E>
{
	private Adaptee<E> a = new Adaptee<E>();

	/**
	* Tests if this stack is empty.
	*/
	public boolean empty()
	{
		return a.size() == 0;
	}
	
	/**
	* Looks at the object at the top of this stack without removing it from the stack.
	*/
	public E peek()
	{
		try
		{
			return a.peek(0);
		}
		catch(NoSuchElementException nsee)
		{
			EmptyStackException ese = new EmptyStackException();
			ese.initCause(nsee);
			throw ese;
		}
	}
	
	/**
	*Removes the object at the top of this stack and returns that object as the value of this function.
	*/
	public E pop()
	{
		if(a.size() == 0)
		{
			throw new EmptyStackException();
		}

		E retval = a.peek(0);
		a.remove(0);
		return retval;
	}
	
	/**
	*Pushes an item onto the top of this stack.
	*/
	public E push(E item)
	{
		a.insert(0, item);
		return item;
	}
	
	/**
	*Returns the 1-based position where an object is on this stack.
	*/
	public int search(Object o)
	{
		E tbf = null;

		try
		{
			tbf = (E)o;
		}
		catch(ClassCastException cce)
		{
			cce.printStackTrace();
			return -1;
		}

		int retval = a.search(tbf);
		if(retval != -1)
		{
			return retval+1;
		}
		return retval;
	}

	public String toString()
	{
		return a.toString();
	}
}
