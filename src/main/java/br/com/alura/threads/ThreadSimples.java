package br.com.alura.threads;

public class ThreadSimples {

	public static void main(String[] args) {

		// Crie uma classe que imprime no console uma String a partir de uma nova
		// Thread! Chame a tarefa ImprimeString.

		// Thread threadSimples = new Thread(new ImprimeString());

		// threadSimples.start();

		// Usando classes anonimas
		new Thread(new Runnable() {

			public void run() {

				System.out.println("Resposta");

			}
		}).start();

	}

}
