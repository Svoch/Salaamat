package gui;


import gui.admin.adminMainPage;
import gui.doctor.DoctorMainPage;
import gui.drugstore.DrugstoreMainPage;
import gui.patient.PatientMainPage;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import users.management.AdminUserManager;
import users.management.DoctorUserManager;
import users.management.DrugstoreUserManager;
import users.management.PatientUserManager;
import utility.hibernate.HibernateUtility;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * TODO handle loggedInUser upon خروج button
 * TODO handle loggedInUser when running mid-windows
 * TODO handle logging by username instead of login by ID
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

		HibernateUtility.createSessionFactory();

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
		setBounds(100, 100, 450, 320);
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


		JLabel usernameLabel = new JLabel("نام کاربری");
		usernameLabel.setBounds(309, 59, 124, 70);
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(usernameLabel);

		JLabel titleLabel = new JLabel("به سامانه سلامت خوش آمدید!");
		titleLabel.setBounds(168, 0, 265, 56);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(titleLabel);

		JLabel passwordLabel = new JLabel("گذرواژه");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setBounds(319, 116, 110, 56);
		contentPane.add(passwordLabel);

		JButton doctorLoginButton = new JButton("ورود پزشک");
		doctorLoginButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				try {
					if( new DoctorUserManager().login(usernameTextField.getText(), passwordTextField.getText()) ) {
						System.err.println("loggedInDoctor is: " + new DoctorUserManager().getLoggedInUser().toString() );
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
					else 
						JOptionPane.showMessageDialog(null, "شناسه کاربری یا گذرواژه نادرست است.");
				} catch (HeadlessException e) {
					JOptionPane.showMessageDialog(null, "ورود به سیستم مقدور نمی‌باشد. آیا نوع کاربر صحیح را انتخاب کرده‌اید؟");
					e.printStackTrace();
				}
			}

		});
		doctorLoginButton.setBounds(316, 178, 117, 29);
		contentPane.add(doctorLoginButton);

		JButton patientLoginButton = new JButton("ورود مشتری");
		patientLoginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				try {
					if( new PatientUserManager().login(usernameTextField.getText(), passwordTextField.getText()) ) {
						
						if( new PatientUserManager().getLoggedInUser().getConfirmed() ) {
					
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
						else
							JOptionPane.showMessageDialog(null, "حساب کاربری شما هنوز تأیید نشده است.");
					}
					else 
						JOptionPane.showMessageDialog(null, "شناسه کاربری یا گذرواژه نادرست است.");
				} catch (HeadlessException e) {
					JOptionPane.showMessageDialog(null, "ورود به سیستم مقدور نمی‌باشد. آیا نوع کاربر صحیح را انتخاب کرده‌اید؟");
					e.printStackTrace();
				}
			}
		});
		patientLoginButton.setBounds(316, 205, 117, 29);
		contentPane.add(patientLoginButton);

		JButton drugstoreLoginButton = new JButton("ورود دادوخانه");
		drugstoreLoginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				try {
					if( new DrugstoreUserManager().login(usernameTextField.getText(), passwordTextField.getText()) ) {
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
					else 
						JOptionPane.showMessageDialog(null, "شناسه کاربری یا گذرواژه نادرست است.");
				} catch (HeadlessException e1) {
					JOptionPane.showMessageDialog(null, "ورود به سیستم مقدور نمی‌باشد. آیا نوع کاربر صحیح را انتخاب کرده‌اید؟");
					e1.printStackTrace();
				}
			}
		});
		drugstoreLoginButton.setBounds(316, 232, 117, 29);
		contentPane.add(drugstoreLoginButton);

		JLabel newUserQuestionLabel = new JLabel("کاربر جدید هستید؟");
		newUserQuestionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		newUserQuestionLabel.setBounds(149, 210, 134, 16);
		contentPane.add(newUserQuestionLabel);

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
		signupButton.setBounds(10, 205, 164, 29);
		contentPane.add(signupButton);

		JButton adminLoginButton = new JButton("ورود مخصوص مدیر سامانه");
		adminLoginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				try {
					if( new AdminUserManager().login(usernameTextField.getText(), passwordTextField.getText()) ) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									adminMainPage frame = new adminMainPage();
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
					else 
						JOptionPane.showMessageDialog(null, "شناسه کاربری یا گذرواژه نادرست است.");
				} catch (HeadlessException e1) {
					JOptionPane.showMessageDialog(null, "ورود به سیستم مقدور نمی‌باشد. آیا نوع کاربر صحیح را انتخاب کرده‌اید؟");
					e1.printStackTrace();
				}
			}
		});
		adminLoginButton.setBounds(10, 243, 164, 29);
		contentPane.add(adminLoginButton);

	}
}
