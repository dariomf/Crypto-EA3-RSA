package gui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import utils.ColorsGUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGUI {
	private JFrame frame;
	public MainGUI() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Criptograf\u00EDa EA1");
		frame.setSize(598,360);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(ColorsGUI.GRIS_MUY_OSCURO.get());
		frame.getContentPane().add(panel, "name_105100547687300");
		
		JButton cipherBtn = new JButton("Encriptador");
		cipherBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		cipherBtn.setBorder(new LineBorder(ColorsGUI.GRIS_MENU.get(), 2, false));
		cipherBtn.setBackground(ColorsGUI.LETRA_COLOR.get());
		cipherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CipherGUI();
			}
		});
		
		JButton decipherBtn = new JButton("Desencriptador");
		decipherBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		decipherBtn.setBorder(new LineBorder(ColorsGUI.GRIS_MENU.get(),2, false));
		decipherBtn.setBackground(ColorsGUI.LETRA_COLOR.get());
		decipherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new DecipherGUI();
			}
		});
		
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(172)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(cipherBtn, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addComponent(decipherBtn, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(61)
					.addComponent(cipherBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(decipherBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		panel.setLayout(gl_panel);
		
	}
}
