package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import cipher.RSACipher;
import utils.ColorsGUI;

public class DecipherGUI {
	private JFrame frame = new JFrame();
	private JLabel result = new JLabel("");
	private JTextArea cipheredText = new JTextArea();
	private JTextArea plainText = new JTextArea();
	private JTextArea moduloTextArea;
	private int cipherBitLength = 100;
	private final JLabel lblMensajeClaro = new JLabel("Mensaje claro");
	private final JTextArea exponentTextArea = new JTextArea();
	private final JLabel lblExponented = new JLabel("Clave (d)");
	private final JLabel lblModulon = new JLabel("Modulo (n)");

	public DecipherGUI() {
		lblModulon.setBounds(370, 212, 140, 20);
		lblModulon.setForeground(SystemColor.menu);
		lblModulon.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));

		lblExponented.setBounds(30, 212, 140, 20);
		lblExponented.setForeground(SystemColor.menu);
		lblExponented.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));

		exponentTextArea.setBounds(29, 239, 297, 45);
		exponentTextArea.setWrapStyleWord(true);
		exponentTextArea.setLineWrap(true);
		exponentTextArea.setBackground(new Color(150, 150, 150));
		exponentTextArea.setBorder(new LineBorder(ColorsGUI.GRIS_SELECCION.get(), 3, false));

		lblMensajeClaro.setBounds(30, 351, 140, 20);
		lblMensajeClaro.setForeground(SystemColor.menu);
		lblMensajeClaro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(771, 543);
		frame.getContentPane().setBackground(ColorsGUI.GRIS_MUY_OSCURO.get());

		cipheredText.setBounds(30, 50, 649, 92);
		cipheredText.setLineWrap(true);
		cipheredText.setWrapStyleWord(true);
		cipheredText.setBackground(ColorsGUI.GRIS_CLARO.get());

		JScrollPane cipheredScrollText = new JScrollPane(cipheredText);
		cipheredScrollText.setBounds(30, 50, 649, 136);
		cipheredScrollText.setBorder(new LineBorder(ColorsGUI.GRIS_SELECCION.get(), 3, false));
		/* plainText.setFocusable(false); */

		// PlainDocument document = (PlainDocument) plainText.getDocument();
		// document.setDocumentFilter(new DigitFilter());

		JButton btnCheck = new JButton("Descifrar");
		btnCheck.setBounds(285, 306, 134, 38);
		btnCheck.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnCheck.setBorder(new LineBorder(ColorsGUI.GRIS_SELECCION.get(), 3, false));
		btnCheck.setBackground(ColorsGUI.LETRA_COLOR.get());
		btnCheck.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				RSACipher cipher = new RSACipher(cipherBitLength);
				cipher.setD(new BigInteger(exponentTextArea.getText()));
				cipher.setN(new BigInteger(moduloTextArea.getText()));
				plainText.setText(cipher.decrypt(cipheredText.getText()));
			}
		});
		plainText.setBounds(30, 382, 649, 75);

		plainText.setBackground(ColorsGUI.GRIS_CLARO.get());
		plainText.setWrapStyleWord(true);
		plainText.setLineWrap(true);
		// cipheredText.setFocusable(false);
		plainText.setEditable(false);
		plainText.setBorder(new LineBorder(ColorsGUI.GRIS_SELECCION.get(), 3, false));

		JLabel lblMensajeCifrado = new JLabel("Ingrese texto cifrado...");
		lblMensajeCifrado.setBounds(31, 19, 198, 20);

		lblMensajeCifrado.setForeground(ColorsGUI.LETRA_COLOR.get());
		lblMensajeCifrado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblMensajeCifrado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));

		moduloTextArea = new JTextArea();
		moduloTextArea.setBounds(371, 239, 308, 45);
		moduloTextArea.setWrapStyleWord(true);
		moduloTextArea.setLineWrap(true);
		moduloTextArea.setBackground(new Color(150, 150, 150));
		moduloTextArea.setBorder(new LineBorder(ColorsGUI.GRIS_SELECCION.get(), 3, false));

		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblExponented);
		result.setBounds(1247, 150, 182, 21);
		frame.getContentPane().add(result);
		frame.getContentPane().add(lblModulon);
		frame.getContentPane().add(lblMensajeClaro);
		frame.getContentPane().add(cipheredScrollText);
		frame.getContentPane().add(exponentTextArea);
		frame.getContentPane().add(moduloTextArea);
		frame.getContentPane().add(plainText);
		frame.getContentPane().add(lblMensajeCifrado);
		frame.getContentPane().add(btnCheck);

	}
}
