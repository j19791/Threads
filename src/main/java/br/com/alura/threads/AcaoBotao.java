
package br.com.alura.threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AcaoBotao implements ActionListener {

	private JTextField primeiro;
	private JTextField segundo;
	private JLabel resultado;

	public AcaoBotao(JTextField primeiro, JTextField segundo, JLabel resultado) {
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.resultado = resultado;
	}

	public void actionPerformed(ActionEvent e) {

		// 1 - criação da thread. Dizer o q ela deverá fazer: passar tarefa rodavel de
		// multiplicação para ela (Runnable)
		Thread threadMultiplicador = new Thread(new TarefaMultiplicacao(primeiro, segundo, resultado));

		// thread começa a trabalhar: inicializa-la implicitamente
		threadMultiplicador.start();
	}

}