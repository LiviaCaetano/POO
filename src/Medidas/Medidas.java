package Medidas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Medidas {
	public static void main(String[] args) {

		// Janela principal
		JFrame frame = new JFrame("Calculadora de IMC");
		// Define as larguras
		frame.setSize(350, 220);
		// Encerra o programa ao ser fechado a janela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		// JLabel é o texto que aparece na tela como orientação
		JLabel lblPeso = new JLabel("Peso (Kg):");
		lblPeso.setBounds(20, 20, 100, 25);
		frame.add(lblPeso);

		// Onde o usuário irá inserir os dados
		JTextField txtPeso = new JTextField();
		// posiciona os elementos na tela
		txtPeso.setBounds(120, 20, 180, 25);
		frame.add(txtPeso);

		JLabel lblAltura = new JLabel("Altura (Cm):");
		lblAltura.setBounds(20, 60, 100, 25);
		frame.add(lblAltura);

		JTextField txtAltura = new JTextField();
		txtAltura.setBounds(120, 60, 180, 25);
		frame.add(txtAltura);

		// Cria um botão para calcular imc
		JButton btnCalcular = new JButton("Calcular IMC");
		btnCalcular.setBounds(100, 110, 140, 30);
		frame.add(btnCalcular);

		btnCalcular.addActionListener(e -> {
			try {
				double peso = Double.parseDouble(txtPeso.getText());
				double alturaCm = Double.parseDouble(txtAltura.getText());
				double alturaM = alturaCm / 100;

				double imc = peso / (alturaM * alturaM);
				String classificacao = classificarIMC(imc);

				String mensagem = String.format("Seu IMC é: %.2f\nClassificação: %s", imc, classificacao);

				JOptionPane.showMessageDialog(frame, mensagem, "Resultado do IMC", JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos.", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		// Exibe a janela
		frame.setVisible(true);
	}

	private static String classificarIMC(double imc) {
		if (imc < 18.5)
			return "Abaixo do peso";
		else if (imc < 25)
			return "Peso normal";
		else if (imc < 30)
			return "Sobrepeso";
		else if (imc < 35)
			return "Obesidade grau I";
		else if (imc < 40)
			return "Obesidade grau II (severa)";
		else
			return "Obesidade grau III (mórbida)";
	}
}