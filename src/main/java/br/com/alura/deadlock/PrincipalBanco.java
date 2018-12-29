package br.com.alura.deadlock;

public class PrincipalBanco {

	public static void main(String[] args) {

		GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
		PoolDeConexao pool = new PoolDeConexao();

		new Thread(new TarefaAcessaBanco(pool, tx), "Acessa banco: ").start();

		new Thread(new TarefaAcessaBancoProcedimento(pool, tx), "Acessa Proc: ").start();

		// deadlock: Um thread impede a execução do outro pois cada um possui a chave de
		// um objeto
		// que o outro precisa para continuar. Temos um impasse.Uma thread segura um
		// recurso e aguarda por outro.

	}

}
