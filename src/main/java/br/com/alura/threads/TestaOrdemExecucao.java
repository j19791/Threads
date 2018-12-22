package br.com.alura.threads;

public class TestaOrdemExecucao {

	public static void main(String[] args) {

		String nomeProcurado = "Jef"; // nome q queremos procurar

		// inicializando cada tarefa q busca o nome nos 3 arquivos q estão na raiz
		Thread threadAutores = new Thread(new TarefaBuscaNome("autores.txt", nomeProcurado));
		Thread threadAssinaturas1 = new Thread(new TarefaBuscaNome("assinaturas1.txt", nomeProcurado));
		Thread threadAssinaturas2 = new Thread(new TarefaBuscaNome("assinaturas2.txt", nomeProcurado));

		threadAutores.start();
		threadAssinaturas1.start();
		threadAssinaturas2.start();

	}

}
