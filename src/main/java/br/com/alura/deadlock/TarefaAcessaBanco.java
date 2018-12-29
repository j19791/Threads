package br.com.alura.deadlock;

public class TarefaAcessaBanco implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	public void run() {

		// Para resolver o deadlock, devemos sempre obter as chaves na mesma ordem.
		// Ambos os blocos devem primeiro tentar obter a chave do pool e só depois a
		// chave do gerenciador de transação.

		String nameThread = Thread.currentThread().getName();

		synchronized (pool) {

			System.out.println(nameThread + ": Peguei a chave do pool");
			pool.getConnection();

			synchronized (tx) {

				System.out.println(nameThread + ": Peguei a chave da tx");
				tx.begin();

			}
		}

	}

}
