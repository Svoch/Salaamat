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
 * TODO handle loggedInUser upon خروج button
 * TODO handle loggedInUser when running mid-windows
 * @author siavashnazari
 *
 */
public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField passwordTextField;

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


		usernameTextField = new JTextField();
		usernameTextField.setBounds(244, 80, 134, 28);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);

		passwordTextField = new JTextField();
		passwordTextField.setBounds(244, 130, 134, 28);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);


		JLabel label = new JLabel("نام کاربری");
		label.setBounds(309, 59, 124, 70);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(label);

		JLabel lblNewLabel = new JLabel("به سامانه سلامت خوش آمدید!");
		lblNewLabel.setBounds(168, 0, 265, 56);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel);

		JLabel label_1 = new JLabel("گذرواژه");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(319, 116, 110, 56);
		contentPane.add(label_1);

		JButton doctorLoginButton = new JButton("ورود پزشک");
		doctorLoginButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				if( new DoctorUserManager().login(usernameTextField.getText(), passwordTextField.getText()) ) {
					System.err.println("some loggedInDoctor is: " + new DoctorUserManager().getLoggedInUser().toString() );
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
		doctorLoginButton.setBounds(316, 178, 117, 29);
		contentPane.add(doctorLoginButton);

		JButton patientLoginButton = new JButton("ورود مشتری");
		patientLoginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				if( new PatientUserManager().login(usernameTextField.getText(), passwordTextField.getText()) ) {
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
		patientLoginButton.setBounds(316, 205, 117, 29);
		contentPane.add(patientLoginButton);

		JButton drugstoreLoginButton = new JButton("ورود دادوخانه");
		drugstoreLoginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if( new DrugstoreLoginCheck().login(usernameTextField.getText(), passwordTextField.getText()) ) {
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
		drugstoreLoginButton.setBounds(316, 232, 117, 29);
		contentPane.add(drugstoreLoginButton);

		JLabel label_2 = new JLabel("کاربر جدید هستید؟");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(149, 210, 124, 16);
		contentPane.add(label_2);

		JButton signupButton = new JButton("ثبت نام حساب کاربری جدید");
		signupButton.addActionListener(new ActionListener() {
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
		signupButton.setBounds(18, 205, 164, 29);
		contentPane.add(signupButton);
		
	}
}
