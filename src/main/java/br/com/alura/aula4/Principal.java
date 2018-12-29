package br.com.alura.aula4;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// instancie um ArrayList - q ser� compartilhado pelas thread abaixo;
		// List<String> lista = new ArrayList<String>();// ArrayList n�o � thread safe

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

		// substitui��o da impress�o por uma thread. Nos testes, uma adi��o demora mais
		// que a impress�o. Causando exceptions. o thread que imprime deve esperar at�
		// que a lista realmente esteja preenchida
		new Thread(new TarefaImprimir(lista)).start();

	}

}
