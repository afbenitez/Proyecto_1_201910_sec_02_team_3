package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterador<T> implements Iterator<T>
{
	T[] actual; 
	int currentIndex; 

	public Iterador(T[] definer)
	{
		actual = definer; 
		currentIndex = 0; 
	}

	@Override
	public boolean hasNext() 
	{
		return actual[currentIndex+1] != null;
	}

	@Override
	public T next() throws NoSuchElementException
	{
		T porVisitar = actual[currentIndex++];
		return porVisitar; 
	}

	public void remove()
	{ }
}