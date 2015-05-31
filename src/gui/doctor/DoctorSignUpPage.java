package gui.doctor;

import gui.LoginPage;

import gui.OperationSuccessfulPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
	private JTextField firstname;
	private JTextField surname;
	private JTextField specialty;
	private JTextField address;
	private JTextField username;
	private JTextField password;
	private JTextField passwordRepeat;

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
		
		JLabel label = new JLabel("\u062B\u0628\u062A \u0646\u0627\u0645 \u067E\u0632\u0634\u06A9");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(333, 6, 111, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u0646\u0627\u0645");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(383, 66, 61, 16);
		contentPane.add(label_1);
		
		firstname = new JTextField();
		firstname.setBounds(225, 60, 134, 28);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		JLabel label_2 = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(371, 94, 73, 16);
		contentPane.add(label_2);
		
		surname = new JTextField();
		surname.setBounds(225, 88, 134, 28);
		contentPane.add(surname);
		surname.setColumns(10);
		
		JLabel label_3 = new JLabel("\u062A\u062E\u0635\u0635*\n");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(383, 122, 61, 16);
		contentPane.add(label_3);
		
		specialty = new JTextField();
		specialty.setBounds(225, 116, 134, 28);
		contentPane.add(specialty);
		specialty.setColumns(10);
		
		JLabel label_4 = new JLabel("\u0646\u0634\u0627\u0646\u06CC \u0645\u0637\u0628");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(383, 150, 61, 16);
		contentPane.add(label_4);
		
		address = new JTextField();
		address.setBounds(212, 144, 147, 28);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel label_5 = new JLabel("\u06AF\u0630\u0631\u0648\u0627\u0698\u0647");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(129, 94, 71, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u0646\u0627\u0645 \u06A9\u0627\u0631\u0628\u0631\u06CC");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(129, 66, 71, 16);
		contentPane.add(label_6);
		
		username = new JTextField();
		username.setBounds(21, 60, 96, 28);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(21, 88, 96, 28);
		contentPane.add(password);
		
		JLabel label_7 = new JLabel("\u062A\u06A9\u0631\u0627\u0631 \u06AF\u0630\u0631\u0648\u0627\u0698\u0647");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(129, 122, 71, 16);
		contentPane.add(label_7);
		
		passwordRepeat = new JTextField();
		passwordRepeat.setColumns(10);
		passwordRepeat.setBounds(21, 116, 96, 28);
		contentPane.add(passwordRepeat);
		
		JButton submitButton = new JButton("\u062B\u0628\u062A \u0627\u0637\u0644\u0627\u0639\u0627\u062A");
		submitButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				/**
				 * TODO confirm that fields are not NUll
				 */
//				UserManager.save( new Doctor(firstname.getText(), surname.getText(), username.getText(), password.getText(), address.getText(), specialty.getText()) );
				new DoctorUserManager().signup(  new Doctor(firstname.getText(), surname.getText(), username.getText(), password.getText(), address.getText(), specialty.getText()) );
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							OperationSuccessfulPage frame = new OperationSuccessfulPage(new LoginPage());
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
		submitButton.setBounds(21, 220, 117, 29);
		contentPane.add(submitButton);
	}
}
