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

		Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");
		limpeza.setDaemon(true); // a thread limpeza só ira existir se ainda as demais threads ainda estiverem
									// rodadndo. prestadores de serviços para outras threads. Elas são usadas para
									// dar apoio à tarefas e só são necessárias rodar quando as threads "normais"
									// ainda estão sendo executadas.

		convidado1.start();
		convidado2.start();
		limpeza.start();

	}

}
