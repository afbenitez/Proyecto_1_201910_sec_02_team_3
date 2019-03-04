package model.data_structures;

import java.util.Iterator;

public class Queue<T extends Comparable<T>> implements IQueue<T> 

{ 
	private T primero;

	private T ultimo; 
	
	private int tamanio; 	

	private int n; 

	private T[] datos; 




	@SuppressWarnings("unchecked")
	public Queue()
	{
		tamanio = 0;
		n = 500000; 
		datos = (T[]) new Comparable[500000];
		ultimo = primero = null; 
	}

	@Override
	public Iterator<T> iterator() 
	{
		return new Iterador<T>(datos);
	}

	@Override
	public boolean isEmpty() 
	{
		return tamanio == 0;
	}

	@Override
	public int size() 
	{
		return tamanio;
	}

	@Override
	public void enqueue(T t) 
	{
		if(tamanio == n) oversize();
		ultimo = datos[tamanio++] = t;
		if(primero == null)
			primero = ultimo;
	}

	@Override
	public T dequeue() 
	{
		T refused = datos[0]; 
		if(refused.equals(ultimo))
			ultimo = null; 
		for(int u = 1; u < tamanio; u++)
			datos[u-1]=datos[u];
		--tamanio; 
		if(tamanio > 0 && tamanio < n/4) undersize(); 
		return refused;
	}

	public T darElementuel(int i) 
	{
		return datos[i];
	}

	@SuppressWarnings("unchecked")
	private void undersize()
	{
		n = n / 4;
		T[] clon = datos;
		datos = (T[]) new Comparable[n];
		for (int i = 0; i < tamanio; i++)
		{
			datos[i] = clon[i];
		}
	}

	@SuppressWarnings("unchecked")
	private void oversize()
	{
		n = 2 * n;
		T[] clon = datos;
		datos = (T[]) new Comparable[n];
		for (int i = 0; i < tamanio; i++)
		{
			datos[i] = clon[i];
		} 
	}
}
