package br.com.alura.banheiro;

public class TarefaLimpeza implements Runnable {

	Banheiro banheiro = new Banheiro();

	public TarefaLimpeza(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	public void run() {

		while (true) {// limpeza devera funcionar como um robo, sempre verificando a limpeza do
						// banheiro
			this.banheiro.limpa();
			try {
				Thread.sleep(15000);// limpando cada 15s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
