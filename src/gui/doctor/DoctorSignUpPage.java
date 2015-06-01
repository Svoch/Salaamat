package gui.doctor;

import gui.LoginPage;

import gui.OperationSuccessfulPage;

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

import users.Doctor;
import users.login.DoctorUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * 
 * @author siavashnazari
 *
 */
public class DoctorSignUpPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private JPanel contentPane;
	private JTextField firstnameTextField;
	private JTextField surnameTextField;
	private JTextField specialtyTextField;
	private JTextField addressTextField;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField passwordRepeatTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorSignUpPage frame = new DoctorSignUpPage();
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
	public DoctorSignUpPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("ثبت نام پزشک");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(333, 6, 111, 29);
		contentPane.add(label);

		JLabel label_1 = new JLabel("نام");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(383, 66, 61, 16);
		contentPane.add(label_1);

		firstnameTextField = new JTextField();
		firstnameTextField.setBounds(225, 60, 134, 28);
		contentPane.add(firstnameTextField);
		firstnameTextField.setColumns(10);

		JLabel label_2 = new JLabel("نام خانوادگی");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(371, 94, 73, 16);
		contentPane.add(label_2);

		surnameTextField = new JTextField();
		surnameTextField.setBounds(225, 88, 134, 28);
		contentPane.add(surnameTextField);
		surnameTextField.setColumns(10);

		JLabel label_3 = new JLabel("تخصص*");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(383, 122, 61, 16);
		contentPane.add(label_3);

		specialtyTextField = new JTextField();
		specialtyTextField.setBounds(225, 116, 134, 28);
		contentPane.add(specialtyTextField);
		specialtyTextField.setColumns(10);

		JLabel label_4 = new JLabel("نشانی مطب");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(383, 150, 61, 16);
		contentPane.add(label_4);

		addressTextField = new JTextField();
		addressTextField.setBounds(212, 144, 147, 28);
		contentPane.add(addressTextField);
		addressTextField.setColumns(10);

		JLabel label_5 = new JLabel("گذرواژه");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(129, 94, 71, 16);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("نام کاربری");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(129, 66, 71, 16);
		contentPane.add(label_6);

		usernameTextField = new JTextField();
		usernameTextField.setBounds(21, 60, 96, 28);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);

		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(21, 88, 96, 28);
		contentPane.add(passwordTextField);

		JLabel label_7 = new JLabel("تکرار گذرواژه");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(129, 122, 71, 16);
		contentPane.add(label_7);

		passwordRepeatTextField = new JTextField();
		passwordRepeatTextField.setColumns(10);
		passwordRepeatTextField.setBounds(21, 116, 96, 28);
		contentPane.add(passwordRepeatTextField);

		JButton submitButton = new JButton("ثبت اطلاعات");
		submitButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				/**
				 * TODO confirm that fields are not NUll
				 * TODO decide whether to make signup() in DoctorUserManager a static method or not.
				 * TODO extract method for checking operations
				 * TODO there is a state where not all fields are entered also passwords do not match, what should be done?
				 */
				//				UserManager.save( new Doctor(firstname.getText(), surname.getText(), username.getText(), password.getText(), address.getText(), specialty.getText()) );
				//				new DoctorUserManager().signup(  new Doctor(firstname.getText(), surname.getText(), username.getText(), password.getText(), address.getText(), specialty.getText()) );
				EventQueue.invokeLater(new Runnable() {
					public void run() {

						if( !firstnameTextField.getText().equals("") && !surnameTextField.getText().equals("") && !usernameTextField.getText().equals("")
								&& !passwordTextField.getText().equals("") && !addressTextField.getText().equals("") && !specialtyTextField.getText().equals("")
								&& !passwordRepeatTextField.getText().equals("") ) {
							
							if( passwordTextField.getText().equals(passwordRepeatTextField.getText()) ) {
								// creating a new doctor based on given input
								System.err.println("here I am madafaka!");
								System.err.println(firstnameTextField.getText() + "\n" + surnameTextField.getText() + "\n" + usernameTextField.getText() + "\n" + surnameTextField.getText() + "\n" + passwordTextField.getText() + "\n" + addressTextField.getText() + "\n" + specialtyTextField.getText() + "\n" + passwordRepeatTextField.getText() );
								if(firstnameTextField.getText().equals(""))
									System.err.println("fuck fuck fuck");
								Doctor doctor = new Doctor(firstnameTextField.getText(), surnameTextField.getText(), usernameTextField.getText(), passwordTextField.getText(), addressTextField.getText(), specialtyTextField.getText());							
								new DoctorUserManager().signup( doctor );
								try {
									OperationSuccessfulPage frame = new OperationSuccessfulPage(new LoginPage());
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
								contentPane.removeAll();
								contentPane.repaint();
								hide();
							}
							else 
								JOptionPane.showMessageDialog(null, "گذرواژه وارد شده و تکرار آن یکسان نیستند.");
						}

						else {
							JOptionPane.showMessageDialog(null, "لطفاً همه‌ی اطلاعات را وارد نمایید.");
						}
					}
				});

				

			}
		});
		submitButton.setBounds(21, 220, 117, 29);
		contentPane.add(submitButton);
	}
}
