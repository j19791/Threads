package br.com.alura.threads;

public class Principal {

	// qualquer programa Java sempre começa com o método main
	public static void main(String[] args) throws InterruptedException {

		// máquina virtual irá criar um novo thread
		System.out.println("Thread MAIN Inicio");

		Thread.sleep(50000); // manda a thread main dormir por 50s. Ira demorar 50s p/ ser executado.

		System.out.println("fim");

	}

}
