package br.com.alura.aula4;

public class Lista {

	private int indice = 0;
	final int TAMANHO = 100;

	String[] elementos = new String[100];

	private int tamanho = 0;

	public synchronized void adicionarElemento(String elemento) {
		this.elementos[indice] = elemento;
		this.indice++;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // demora 10 milisegundos para adicionar o elemento

		if (this.indice == this.getTamanho()) {
			System.out.println("lista tá cheia, notificando a Tarefa de Imprimir");
			this.notify();// notificando thread de impressão que a lista esta cheia. deve estar dentro de
							// um bloco ou metodo synchronized
		}
	}

	public int getTamanho() {
		return elementos.length;
	};

	public String pegarElemento(int posicao) {
		return this.elementos[posicao];
	}

	public boolean estaCheia() {
		return this.indice == this.getTamanho();
	}

}
