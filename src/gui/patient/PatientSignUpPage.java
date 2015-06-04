package gui.patient;
import gui.LoginPage;
import gui.OperationSuccessfulPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import users.Patient;
import users.management.PatientUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author siavashnazari
 *
 */
public class PatientSignUpPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private JPanel contentPane;
	private JTextField firstnameTextField;
	private JTextField surnameTextField;
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
					PatientSignUpPage frame = new PatientSignUpPage();
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
	public PatientSignUpPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("ثبت نام بیمار");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(333, 6, 111, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("نام");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(383, 66, 61, 16);
		contentPane.add(label_1);
		
		firstnameTextField = new JTextField();
		firstnameTextField.setColumns(10);
		firstnameTextField.setBounds(225, 60, 134, 28);
		contentPane.add(firstnameTextField);
		
		JLabel label_2 = new JLabel("نام خانوادگی");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(371, 94, 73, 16);
		contentPane.add(label_2);
		
		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(225, 88, 134, 28);
		contentPane.add(surnameTextField);
		
		JLabel label_4 = new JLabel("نشانی منزل");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(383, 150, 61, 16);
		contentPane.add(label_4);
		
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(212, 144, 147, 28);
		contentPane.add(addressTextField);
		
		JLabel label_5 = new JLabel("گذرواژه");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(129, 94, 71, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("نام کاربری");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(129, 66, 71, 16);
		contentPane.add(label_6);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(21, 60, 96, 28);
		contentPane.add(usernameTextField);
		
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
		
		JButton button = new JButton("ثبت اطلاعات");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				/**
				 * TODO confirm that fields are not NUll
				 * TODO decide whether to make signup() in PatientUserManager a static method or not.
				 * TODO extract method for checking operations
				 * TODO there is a state where not all fields are entered also passwords do not match, what should be done?
				 */
//				new PatientUserManager().signup(  new Patient(firstnameTextField.getText(), surnameTextField.getText(), usernameTextField.getText(), passwordTextField.getText(), addressTextField.getText()) );				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						if( !firstnameTextField.getText().equals("") && !surnameTextField.getText().equals("") && !usernameTextField.getText().equals("")
								&& !passwordTextField.getText().equals("") && !addressTextField.getText().equals("") && !passwordRepeatTextField.getText().equals("") ) {
							
							if( passwordTextField.getText().equals(passwordRepeatTextField.getText()) ) {
								// creating a new patient based on given input
								System.err.println(firstnameTextField.getText() + "\n" + surnameTextField.getText() + "\n" + usernameTextField.getText() + "\n" + surnameTextField.getText() + "\n" + passwordTextField.getText() + "\n" + addressTextField.getText() + "\n" + passwordRepeatTextField.getText() );
								Patient patient = new Patient(firstnameTextField.getText(), surnameTextField.getText(), usernameTextField.getText(), passwordTextField.getText(), addressTextField.getText() );							
								new PatientUserManager().signup( patient );
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
		button.setBounds(21, 220, 117, 29);
		contentPane.add(button);
	}

}
