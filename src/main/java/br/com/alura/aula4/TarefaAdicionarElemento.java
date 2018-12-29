package br.com.alura.aula4;

public class TarefaAdicionarElemento implements Runnable {

	// private List<String> lista;
	private Lista lista;
	// private int numeroDoThread;

	public TarefaAdicionarElemento(Lista lista) {
		this.lista = lista;
		// this.numeroDoThread = numeroDoThread;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			lista.adicionarElemento(Thread.currentThread().getName() + " - " + i);
		}
	}

}
