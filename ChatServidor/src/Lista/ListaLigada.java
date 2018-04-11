package Lista;

import java.net.Socket;

public class ListaLigada {

	private No inicio;
	
	public void adicionaInicio(Socket novoElemento)
	{
		No novo = new No(novoElemento);
		novo.prox =  inicio;
		inicio = novo;
	}
	
	public void removerInicio()
	{
		int r = -1;
		if(inicio == null)
		{
			System.out.println("Erro");
		}
		else
		{	
			inicio = inicio.prox;
		}
	
	}
	
	public String toString()
	{
		No aux = inicio;
		String s = "";
		
		while(aux != null)
		{
			s = s + " " + aux.dado;
			aux = aux.prox;
		}
		return s;
	}
	
	

	public void removeFinal()
	{
		
		if(inicio != null)
		{
			No aux1 = inicio, aux2 = null;
			while(aux1.prox != null)
			{
				aux2 = aux1;
				aux1 = aux1.prox;
			}
			aux2.prox = null;
		
		}
		
		
		
	}
	
	public void adicionaFinal(Socket novoElemento)
	{
		
		if(inicio == null)
		{
			inicio = new No(novoElemento);
		}
		else
		{
			No aux = inicio;
			
			while(aux.prox != null)
			{
				aux = aux.prox;
			}
			No novo = new No(novoElemento);
			aux.prox = novo;
		}
	}
}
