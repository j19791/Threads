package br.com.alura.deadlock;

public class TarefaAcessaBancoProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	public void run() {

		// Para resolver o deadlock, devemos sempre obter as chaves na mesma ordem.
		// Ambos os blocos devem primeiro tentar obter a chave do pool e só depois a
		// chave do gerenciador de transação.

		String nameThread = Thread.currentThread().getName();

		/*
		 * synchronized (tx) {
		 * 
		 * System.out.println(nameThread + ": Peguei a chave da tx"); tx.begin();
		 * 
		 * synchronized (pool) {
		 * 
		 * System.out.println(nameThread + ": Peguei a chave do pool");
		 * pool.getConnection(); } }
		 */

		// resolvendo o deadlock
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
