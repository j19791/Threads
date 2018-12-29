package br.com.alura.banheiro;

//objeto que sera compartilhado
public class Banheiro {

	public void fazNumero1() {

		String nomeConvidado = Thread.currentThread().getName();

		System.out.println(nomeConvidado + " bateu na porta");

		synchronized (this) { // tarefa (thread) pega uma chave Mutex (acesso exclusivo ao recurso p/ executar
								// o bloco. os comandos dentro do bloco serão executados de maneira atômica
			System.out.println(nomeConvidado + " entrando no banheiro");
			System.out.println(nomeConvidado + " fazendo coisa rapida");

			try {// thread dorme por 8 segundos
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(nomeConvidado + " dando descarga");
			System.out.println(nomeConvidado + " lavando a mao");
			System.out.println(nomeConvidado + " saindo do banheiro");

		}

	}

	public void fazNumero2() {

		String nomeConvidado = Thread.currentThread().getName();

		System.out.println(nomeConvidado + " bateu na porta");

		synchronized (this) {// tarefa (thread) pega uma chave (acesso exclusivo ao objeto p/ executar o
			// bloco
			System.out.println(nomeConvidado + " entrando no banheiro");
			System.out.println(nomeConvidado + " fazendo coisa demorada");

			try {// thread dorme por 15 segundos
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(nomeConvidado + " dando descarga");
			System.out.println(nomeConvidado + " lavando a mao");
			System.out.println(nomeConvidado + " saindo do banheiro");

		}

	}

}
