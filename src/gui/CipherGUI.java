package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import cipher.RSACipher;
import utils.ColorsGUI;

public class CipherGUI {
	JFrame frame = new JFrame();
	JLabel result = new JLabel("");
	JTextArea plainText = new JTextArea();
	JTextArea cipheredText = new JTextArea();
	private final JLabel lblMensajeCifrado = new JLabel("Mensaje cifrado");
	private final JTextArea exponentTextArea = new JTextArea();
	private final JTextArea moduleTextArea = new JTextArea();
	private final JLabel lblExponented = new JLabel("Clave (d)");
	private final JLabel lblModulon = new JLabel("Modulo (n)");
	private JTextField bitLengthField;

	public CipherGUI() {
		lblModulon.setBounds(392, 375, 140, 20);
		lblModulon.setForeground(SystemColor.menu);
		lblModulon.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblExponented.setBounds(44, 375, 140, 20);

		lblExponented.setForeground(SystemColor.menu);
		lblExponented.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));

		moduleTextArea.setBounds(392, 406, 316, 52);
		moduleTextArea.setWrapStyleWord(true);
		moduleTextArea.setLineWrap(true);
		moduleTextArea.setEditable(false);
		moduleTextArea.setBackground(new Color(150, 150, 150));
		moduleTextArea.setBorder(new LineBorder(ColorsGUI.GRIS_SELECCION.get(), 3, false));

		exponentTextArea.setBounds(44, 406, 316, 52);
		exponentTextArea.setWrapStyleWord(true);
		exponentTextArea.setLineWrap(true);
		exponentTextArea.setEditable(false);
		exponentTextArea.setBackground(new Color(150, 150, 150));
		exponentTextArea.setBorder(new LineBorder(ColorsGUI.GRIS_SELECCION.get(), 3, false));

		lblMensajeCifrado.setBounds(44, 203, 140, 20);
		lblMensajeCifrado.setForeground(SystemColor.menu);
		lblMensajeCifrado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));

		plainText.setBounds(44, 40, 664, 81);
		plainText.setLineWrap(true);
		plainText.setWrapStyleWord(true);
		plainText.setBackground(ColorsGUI.GRIS_CLARO.get());
		plainText.setBorder(new LineBorder(ColorsGUI.GRIS_SELECCION.get(), 3, false));
		/* plainText.setFocusable(false); */

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(771, 543);
		frame.getContentPane().setBackground(ColorsGUI.GRIS_MUY_OSCURO.get());

		// PlainDocument document = (PlainDocument) plainText.getDocument();
		// document.setDocumentFilter(new DigitFilter());

		JButton btnCheck = new JButton("Cifrar");
		btnCheck.setBounds(302, 150, 132, 40);
		btnCheck.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnCheck.setBorder(new LineBorder(ColorsGUI.LETRA_COLOR.get(), 3, false));
		btnCheck.setBackground(ColorsGUI.LETRA_COLOR.get());
		btnCheck.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				handleCipher();
			}

		});
		cipheredText.setBounds(44, 229, 641, 135);

		cipheredText.setBackground(ColorsGUI.GRIS_CLARO.get());
		cipheredText.setWrapStyleWord(true);
		cipheredText.setLineWrap(true);
		// cipheredText.setFocusable(false);
		cipheredText.setEditable(false);
		cipheredText.setBorder(null);

		JScrollPane cipheredScrollText = new JScrollPane(cipheredText);
		cipheredScrollText.setBounds(44, 229, 664, 135);
		cipheredScrollText.setBorder(new LineBorder(ColorsGUI.GRIS_SELECCION.get(), 3, false));

		JLabel lblMensajeClaro = new JLabel("Ingrese texto claro...");
		lblMensajeClaro.setBounds(44, 14, 168, 20);
		lblMensajeClaro.setForeground(ColorsGUI.LETRA_COLOR.get());
		lblMensajeClaro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));

		bitLengthField = new JTextField();
		bitLengthField.setBounds(492, 170, 86, 20);
		bitLengthField.setColumns(10);
		bitLengthField.setBackground(ColorsGUI.GRIS_CLARO.get());
		bitLengthField.setBorder(new LineBorder(ColorsGUI.GRIS_SELECCION.get(), 2, false));

		JLabel lblBitspq = new JLabel("bits (p,q):");
		lblBitspq.setBounds(492, 150, 140, 20);
		lblBitspq.setForeground(SystemColor.menu);
		lblBitspq.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblMensajeClaro);
		result.setBounds(1101, 150, 182, 21);
		frame.getContentPane().add(result);
		frame.getContentPane().add(bitLengthField);
		frame.getContentPane().add(lblBitspq);
		frame.getContentPane().add(btnCheck);
		frame.getContentPane().add(exponentTextArea);
		frame.getContentPane().add(lblExponented);
		frame.getContentPane().add(lblModulon);
		frame.getContentPane().add(moduleTextArea);
		frame.getContentPane().add(lblMensajeCifrado);
		frame.getContentPane().add(plainText);
		frame.getContentPane().add(cipheredScrollText);

	}

	private void handleCipher() {

		RSACipher cipher = new RSACipher(Integer.parseInt(bitLengthField.getText()));
		cipher.generateKeys();
		cipheredText.setText(cipher.encrypt(plainText.getText()));
		exponentTextArea.setText(cipher.getD().toString());
		moduleTextArea.setText(cipher.getN().toString());
	}
}
