package br.com.alura.aula4;

import java.util.List;
import java.util.Vector;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// instancie um ArrayList - q será compartilhado pelas thread abaixo;
		// List<String> lista = new ArrayList<String>();// ArrayList não é thread safe

		List<String> lista = new Vector<String>();// thread safe

		for (int i = 0; i < 10; i++) {

			new Thread(new TarefaAdicionarElemento(lista), "Thread " + i).start();

		}

		// imprima todos os elementos da lista;
		for (int i = 0; i < 100; i++) {

			System.out.println(lista.get(i));

		}

	}

}
