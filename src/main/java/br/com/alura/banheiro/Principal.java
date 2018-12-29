package br.com.alura.banheiro;

public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Banheiro banheiro = new Banheiro(); // objeto q sera compartilhado por varias threads

		// convidados (threads) que compartilhar�o o objeto banheiro
		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Jo�o");
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");

		Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");
		limpeza.setDaemon(true); // a thread limpeza s� ira existir se ainda as demais threads ainda estiverem
									// rodadndo. prestadores de servi�os para outras threads. Elas s�o usadas para
									// dar apoio � tarefas e s� s�o necess�rias rodar quando as threads "normais"
									// ainda est�o sendo executadas.

		convidado1.start();
		convidado2.start();
		limpeza.start();

	}

}
