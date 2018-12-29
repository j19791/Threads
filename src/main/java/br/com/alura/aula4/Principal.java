package br.com.alura.aula4;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// instancie um ArrayList - q será compartilhado pelas thread abaixo;
		// List<String> lista = new ArrayList<String>();// ArrayList não é thread safe

		// List<String> lista = new Vector<String>();// thread safe

		// utilizando alista caseira
		Lista lista = new Lista();

		for (int i = 0; i < 10; i++) {

			new Thread(new TarefaAdicionarElemento(lista), "Thread " + i).start();

		}

		// imprima todos os elementos da lista;
		/*
		 * for (int i = 0; i < 100; i++) {
		 * 
		 * System.out.println(lista.pegarElemento(i));
		 * 
		 * }
		 */

		// substituição da impressão por uma thread. Nos testes, uma adição demora mais
		// que a impressão. Causando exceptions. o thread que imprime deve esperar até
		// que a lista realmente esteja preenchida
		new Thread(new TarefaImprimir(lista)).start();

	}

}
