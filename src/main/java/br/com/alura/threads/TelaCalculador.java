package br.com.alura.threads;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCalculador {

	public static void main(String[] args) {

		// criação da tela
		JFrame janela = new JFrame("Multiplicação Demorada");

		// campo 1
		JTextField primeiro = new JTextField(10);

		// campo 2
		JTextField segundo = new JTextField(10);

		JButton botao = new JButton(" = ");

		// resultado
		JLabel resultado = new JLabel("           ?          ");

		// quando clica no botãoo será executado a classe Multiplicador
		botao.addActionListener(new AcaoBotao(primeiro, segundo, resultado));

		JPanel painel = new JPanel();
		painel.add(primeiro);
		painel.add(new JLabel("x"));
		painel.add(segundo);
		painel.add(botao);
		painel.add(resultado);

		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);
	}
}
