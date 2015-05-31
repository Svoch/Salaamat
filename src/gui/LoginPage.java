package gui;

import gui.doctor.DoctorMainPage;
import gui.drugstore.DrugstoreMainPage;
import gui.patient.PatientMainPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import users.login.DoctorUserManager;
import users.login.DrugstoreLoginCheck;
import users.login.PatientUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author siavashnazari
 *
 */
public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		textField = new JTextField();
		textField.setBounds(244, 80, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(244, 130, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);


		JLabel label = new JLabel("\u0646\u0627\u0645 \u06A9\u0627\u0631\u0628\u0631\u06CC");
		label.setBounds(309, 59, 124, 70);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(label);

		JLabel lblNewLabel = new JLabel("\u0628\u0647 \u0633\u0627\u0645\u0627\u0646\u0647 \u0633\u0644\u0627\u0645\u062A \u062E\u0648\u0634 \u0622\u0645\u062F\u06CC\u062F!");
		lblNewLabel.setBounds(168, 0, 265, 56);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel);

		JLabel label_1 = new JLabel("\u06AF\u0630\u0631\u0648\u0627\u0698\u0647");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(319, 116, 110, 56);
		contentPane.add(label_1);

		JButton btnNewButton = new JButton("\u0648\u0631\u0648\u062F \u067E\u0632\u0634\u06A9");
		btnNewButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				if( new DoctorUserManager().login(textField.getText(), textField_1.getText()) ) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								DoctorMainPage frame = new DoctorMainPage();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					contentPane.removeAll();
					contentPane.repaint();
					hide();
				}
				// use the message...
				else 
					JOptionPane.showMessageDialog(null, "\u0634\u0646\u0627\u0633\u0647 \u06A9\u0627\u0631\u0628\u0631\u06CC \u06CC\u0627 \u06AF\u0630\u0631\u0648\u0627\u0698\u0647 \u0646\u0627\u062F\u0631\u0633\u062A \u0627\u0633\u062A.");
			}
			
		});
		btnNewButton.setBounds(316, 178, 117, 29);
		contentPane.add(btnNewButton);

		JButton button = new JButton("\u0648\u0631\u0648\u062F \u0645\u0634\u062A\u0631\u06CC");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				if( new PatientUserManager().login(textField.getText(), textField_1.getText()) ) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								PatientMainPage frame = new PatientMainPage();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					contentPane.removeAll();
					contentPane.repaint();
					hide();
				}
				// use the message...
				else 
					JOptionPane.showMessageDialog(null, "\u0634\u0646\u0627\u0633\u0647 \u06A9\u0627\u0631\u0628\u0631\u06CC \u06CC\u0627 \u06AF\u0630\u0631\u0648\u0627\u0698\u0647 \u0646\u0627\u062F\u0631\u0633\u062A \u0627\u0633\u062A.");
			}
			
		});
		button.setBounds(316, 205, 117, 29);
		contentPane.add(button);

		JButton button_1 = new JButton("\u0648\u0631\u0648\u062F \u062F\u0627\u062F\u0648\u062E\u0627\u0646\u0647");
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if( new DrugstoreLoginCheck().login(textField.getText(), textField_1.getText()) ) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								DrugstoreMainPage frame = new DrugstoreMainPage();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					contentPane.removeAll();
					contentPane.repaint();
					hide();
				}
				// use the message...
				else 
					JOptionPane.showMessageDialog(null, "\u0634\u0646\u0627\u0633\u0647 \u06A9\u0627\u0631\u0628\u0631\u06CC \u06CC\u0627 \u06AF\u0630\u0631\u0648\u0627\u0698\u0647 \u0646\u0627\u062F\u0631\u0633\u062A \u0627\u0633\u062A.");
			}
			
		});
		button_1.setBounds(316, 232, 117, 29);
		contentPane.add(button_1);

		JLabel label_2 = new JLabel("\u06A9\u0627\u0631\u0628\u0631 \u062C\u062F\u06CC\u062F \u0647\u0633\u062A\u06CC\u062F\u061F");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(149, 210, 124, 16);
		contentPane.add(label_2);

		JButton button_2 = new JButton("\u062B\u0628\u062A \u0646\u0627\u0645 \u062D\u0633\u0627\u0628 \u06A9\u0627\u0631\u0628\u0631\u06CC \u062C\u062F\u06CC\u062F");
		button_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SignUpPage frame = new SignUpPage();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

				contentPane.removeAll();
				contentPane.repaint();
				hide();
			}
		});
		button_2.setBounds(18, 205, 164, 29);
		contentPane.add(button_2);
		
	}
}
