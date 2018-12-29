package br.com.alura.banheiro;

public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Banheiro banheiro = new Banheiro(); // objeto q sera compartilhado por varias threads

		// convidados (threads) que compartilharão o objeto banheiro
		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");

		convidado1.start();
		convidado2.start();

	}

}
