import java.util.*;

public class Adaptee<E>
{
	Node<E> head;
	int count;

	public Adaptee()
	{
		head = null;
		count = 0;
	}

	public E peek(int pos)
	{
		if(pos < 0 || pos >= count)
		{
			throw new NoSuchElementException("pos is out of current bounds: size is " + String.valueOf(count));
		}

		Node<E> tmp = head;
		for(int i=0;i<pos;i++)
		{
			tmp = tmp.next;
		}
		return tmp.elem;
	}

	public void remove(int pos)
	{
		if(pos < 0 || pos >= count)
		{
			throw new NoSuchElementException("pos is out of current bounds: size is " + String.valueOf(count));
		}

		if(pos == 0)
		{
			head = head.next;
		}
		else
		{
			Node<E> cursor = head;
			for(int i = 0;i<pos-1;i++)
			{
				cursor = cursor.next;
			}
			cursor.next = cursor.next.next;
		}
		count--;
	}

	public void insert(int pos, E elem)
	{
		if(pos < 0 || pos > count)
		{
			throw new NoSuchElementException("pos is out of current bounds: size is " + String.valueOf(count));
		}

		Node<E> tmp = new Node<E>();
		tmp.elem = elem;

		Node<E> cursor = head;

		if(pos == 0)
		{
			tmp.next = head;
			head = tmp;
		}
		else
		{
			for(int i = 0;i<pos-1;i++)
			{
				cursor = cursor.next;
			}
			tmp.next = cursor.next;
			cursor.next = tmp;
		}
		count++;
	}

	public int search(E elem)
	{
		Node<E> tmp = head;
		for(int i=0;i<count;i++)
		{
			if(elem.equals(tmp.elem))
			{
				return i;
			} else {
				tmp = tmp.next;
			}
		}
		return -1;
	}

	public int size()
	{
		return count;
	}

	class Node<E>
	{
		E elem = null;
		Node<E> next = null;
	}

	public String toString()
	{
		String retval = "";
		for(int i=0;i<count;i++)
		{
			retval = retval.concat("[" + peek(i).toString() + "]");
		}
		return retval;
	}
}
