package br.com.alura.banheiro;

//objeto que sera compartilhado
public class Banheiro {

	private boolean ehSujo = true; // estado do banheiro. Se for true, thread (convidado) dever� sair do bloco
									// (devolver a chave) e esperar a limpeza

	public void fazNumero1() {

		String nomeConvidado = Thread.currentThread().getName();

		System.out.println(nomeConvidado + " bateu na porta");

		synchronized (this) { // tarefa (thread) pega uma chave Mutex (acesso exclusivo ao recurso p/ executar
								// o bloco. os comandos dentro do bloco ser�o executados de maneira at�mica

			while (this.ehSujo) {// banheiro sujo
				this.esperaLaFora(nomeConvidado);
			}

			System.out.println(nomeConvidado + " entrando no banheiro");
			System.out.println(nomeConvidado + " fazendo coisa rapida");

			try {// thread dorme por 8 segundos
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.ehSujo = true;

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

			while (this.ehSujo) {// banheiro sujo
				this.esperaLaFora(nomeConvidado);
			}

			System.out.println(nomeConvidado + " entrando no banheiro");
			System.out.println(nomeConvidado + " fazendo coisa demorada");

			try {// thread dorme por 15 segundos
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.ehSujo = true;

			System.out.println(nomeConvidado + " dando descarga");
			System.out.println(nomeConvidado + " lavando a mao");
			System.out.println(nomeConvidado + " saindo do banheiro");

		}

	}

	private void esperaLaFora(String nome) {

		System.out.println(nome + ", eca, banheiro est� sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void limpa() { // metodo q sera chamado pelo Runnable para mudar o estado do objeto
							// compartilhado e notificar todos os outros threads q est�o esperando
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized (this) { // recurso dever� estar de uso exclusivo para utiliza-lo

			System.out.println(nome + " entrando no banheiro");

			if (!this.ehSujo) {
				System.out.println(nome + ", n�o est� sujo, vou sair");
				return;
			}

			System.out.println(nome + " limpando o banheiro");
			this.ehSujo = false;

			try {
				Thread.sleep(13000); // demora p executar a tarefa
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.notifyAll(); // notiifcar todas as outras threads que est�o esperando o recurso que estes
								// podem compartilhar novamente o recurso

			System.out.println(nome + " saindo do banheiro");
		}
	}

}

/*
 * estados da thread: NEW Uma thread foi criada mas ainda n�o foi iniciada.
 * RUNNABLE A thread est� rodando dentro da JVM. BLOCKED A thread foi bloqueada
 * pois n�o conseguiu pegar a chave. WAITING A thread est� esperando pois foi
 * chamado this.wait(). TIMED_WAITING A thread est� esperando pois foi chamado
 * this.wait(milis). TERMINATED A thread est� finalizada.
 */
