package br.com.alura.aula4;

public class TarefaImprimir implements Runnable {

	private Lista lista;

	public TarefaImprimir(Lista lista) {
		this.lista = lista;
	}

	public void run() {

		synchronized (lista) {// O objeto sincronizado é a lista, e esse será a nossa chave mutex

			try {
				if (!lista.estaCheia()) { // espera apenas se a lista ainda não esta cheia
					lista.wait(); // deve estar dentro de um bloco ou metodo synchronized
					System.out.println("esperando para imprimir, aguardando notificacao da Tarefa de adicionar elementos");
				}

				for (int i = 0; i < 100; i++) {

					System.out.println(lista.pegarElemento(i));

				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
