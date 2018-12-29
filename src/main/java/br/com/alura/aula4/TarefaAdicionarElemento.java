package br.com.alura.aula4;

import java.util.List;

public class TarefaAdicionarElemento implements Runnable {

	private List<String> lista;
	// private int numeroDoThread;

	public TarefaAdicionarElemento(List<String> lista) {
		this.lista = lista;
		// this.numeroDoThread = numeroDoThread;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			lista.add(Thread.currentThread().getName() + " - " + i);
		}
	}

}
