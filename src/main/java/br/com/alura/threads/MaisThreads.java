package br.com.alura.threads;

public class MaisThreads {

	public static void main(String[] args) {

		/*
		 * Crie um programa com duas threads que imprimem n�meros de 1 at� 1000, al�m da
		 * ID da thread.
		 * 
		 * Voc� pode imprimir a id da thread atrav�s do m�todo getId(), por exemplo:
		 * 
		 * Thread threadAtual = Thread.currentThread(); long id = threadAtual.getId();
		 * System.out.println("Id da thread: " + id); Rode o programa no m�nimo duas
		 * vezes para ver se o resultado da execu��o difere. M�os � obra!
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
