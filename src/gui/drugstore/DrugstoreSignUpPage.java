package gui.drugstore;
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

import users.Drugstore;
import users.management.DoctorUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/**
 * 
 * @author siavashnazari
 *
 */
public class DrugstoreSignUpPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField certificateNumberTextField;
	private JTextField addressTextField;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JPasswordField passwordRepeatTextField;
//	
//	private JTextField firstnameTextField;
//	private JTextField surnameTextField;
//	private JTextField specialtyTextField;


	/**
	 * Create the frame.
	 */
	public DrugstoreSignUpPage() {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("ثبت نام داروخانه\n");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(333, 6, 111, 29);
		contentPane.add(titleLabel);
		
		JLabel nameLabel = new JLabel("نام");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(383, 66, 61, 16);
		contentPane.add(nameLabel);
		
		JLabel certificateNumberLabel = new JLabel("شماره پروانه");
		certificateNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		certificateNumberLabel.setBounds(371, 94, 73, 16);
		contentPane.add(certificateNumberLabel);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(225, 60, 134, 28);
		contentPane.add(nameTextField);
		
		certificateNumberTextField = new JTextField();
		certificateNumberTextField.setColumns(10);
		certificateNumberTextField.setBounds(225, 88, 134, 28);
		contentPane.add(certificateNumberTextField);
		
		JLabel addressLabel = new JLabel("نشانی");
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setBounds(383, 150, 61, 16);
		contentPane.add(addressLabel);
		
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(212, 144, 147, 28);
		contentPane.add(addressTextField);
		
		JLabel passwordLabel = new JLabel("گذرواژه");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(129, 94, 71, 16);
		contentPane.add(passwordLabel);
		
		JLabel usernameLabel = new JLabel("نام کاربری");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(129, 66, 71, 16);
		contentPane.add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(21, 60, 96, 28);
		contentPane.add(usernameTextField);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(21, 88, 96, 28);
		contentPane.add(passwordTextField);
		
		JLabel passwordRepeatLabel = new JLabel("تکرار گذرواژه");
		passwordRepeatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordRepeatLabel.setBounds(129, 122, 71, 16);
		contentPane.add(passwordRepeatLabel);
		
		passwordRepeatTextField = new JPasswordField();
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

						if( !nameTextField.getText().equals("") && !certificateNumberTextField.getText().equals("") && !usernameTextField.getText().equals("")
								&& !passwordTextField.getText().equals("") && !addressTextField.getText().equals("") && !passwordRepeatTextField.getText().equals("") ) {
							
							if( passwordTextField.getText().equals(passwordRepeatTextField.getText()) ) {
								// creating a new doctor based on given input
								Drugstore drugstore = new Drugstore(nameTextField.getText(), certificateNumberTextField.getText(), usernameTextField.getText(), passwordTextField.getText(), addressTextField.getText() );							
								new DoctorUserManager().signup( drugstore );
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
		submitButton.setBounds(97, 220, 117, 29);
		contentPane.add(submitButton);
		
		JButton backButton = new JButton("بازکشت");
		backButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
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
		});
		backButton.setBounds(21, 220, 81, 29);
		contentPane.add(backButton);
	}
		
}
