package model.data_structures;

import java.util.Iterator;


public class Stack<T extends Comparable<T>> implements IStack<T>
{
	private T primero;
	private int tamanio; 	
	private int n; 	
	private T[] datos; 	
  

	public Stack()
	{
		n = 1000000; 
		tamanio = 0; 
		datos = (T[]) new Comparable[n]; 
		primero = null;   
	}

	
	public Iterator<T> iterator() 
	{
		return new Iterador<T>(datos);
	}

	
	public boolean isEmpty() 
	{
		return tamanio == 0;
	}

	
	public int size() 
	{
		return tamanio;
	}

	
	public void push(T t) 
	{
		if(tamanio == n) estaArriba(); 
		{
			primero = datos[tamanio++] = t; 
		}
	}
	
	public T[] darListado()
	{
		return datos; 
	}
	
	public void invertir()
	{
		T[] muestraInvertida = (T[]) new Comparable[ tamanio ];
		int j = tamanio;
		
		for ( int i = 0 ; i < tamanio ; i++ )
		{
			muestraInvertida[i] = datos[j-1];
			j--;	
		}		
		datos = muestraInvertida;
	}

	@Override
	public T pop() 
	{
		T rejected = datos[--tamanio]; 
		
		datos[tamanio] = null;
		
		if(tamanio > 0 && tamanio < n/4) estaDebajo(); 
		return rejected;
	}
	
	
	private void estaDebajo()
	{
		n = n / 4;
		T[] clon = datos;
		datos = (T[]) new Comparable[n];
		
		for (int i = 0; i < tamanio; i++)
		{
			datos[i] = clon[i];
		}
	}

	
	private void estaArriba()
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
