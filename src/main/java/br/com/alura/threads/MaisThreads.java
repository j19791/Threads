package br.com.alura.threads;

public class MaisThreads {

	public static void main(String[] args) {

		/*
		 * Crie um programa com duas threads que imprimem números de 1 até 1000, além da
		 * ID da thread.
		 * 
		 * Você pode imprimir a id da thread através do método getId(), por exemplo:
		 * 
		 * Thread threadAtual = Thread.currentThread(); long id = threadAtual.getId();
		 * System.out.println("Id da thread: " + id); Rode o programa no mínimo duas
		 * vezes para ver se o resultado da execução difere. Mãos à obra!
		 * 
		 * 
		 */

		new Thread(new Runnable() {

			public void run() {

				for (int i = 1; i <= 1000; i++) {
					System.out.println("thread " + Thread.currentThread().getId() + ": " + i);
				}

			}
		}).start();

		new Thread(new Runnable() {

			public void run() {

				for (int i = 1; i <= 1000; i++) {
					System.out.println("thread " + Thread.currentThread().getId() + ": " + i);
				}

			}
		}).start();

	}

}
