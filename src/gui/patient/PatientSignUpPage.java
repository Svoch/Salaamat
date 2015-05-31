package gui.patient;
import gui.LoginPage;
import gui.OperationSuccessfulPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import users.Doctor;
import users.Patient;
import users.login.DoctorUserManager;
import users.login.PatientUserManager;

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
	private JTextField firstname;
	private JTextField surname;
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
		
		JLabel label = new JLabel("\u062B\u0628\u062A \u0646\u0627\u0645 \u0628\u06CC\u0645\u0627\u0631\n");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(333, 6, 111, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u0646\u0627\u0645");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(383, 66, 61, 16);
		contentPane.add(label_1);
		
		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(225, 60, 134, 28);
		contentPane.add(firstname);
		
		JLabel label_2 = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(371, 94, 73, 16);
		contentPane.add(label_2);
		
		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(225, 88, 134, 28);
		contentPane.add(surname);
		
		JLabel label_4 = new JLabel("\u0646\u0634\u0627\u0646\u06CC \u0645\u0646\u0632\u0644");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(383, 150, 61, 16);
		contentPane.add(label_4);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(212, 144, 147, 28);
		contentPane.add(address);
		
		JLabel label_5 = new JLabel("\u06AF\u0630\u0631\u0648\u0627\u0698\u0647");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(129, 94, 71, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u0646\u0627\u0645 \u06A9\u0627\u0631\u0628\u0631\u06CC");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(129, 66, 71, 16);
		contentPane.add(label_6);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(21, 60, 96, 28);
		contentPane.add(username);
		
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
		
		JButton button = new JButton("\u062B\u0628\u062A \u0627\u0637\u0644\u0627\u0639\u0627\u062A");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				new PatientUserManager().signup(  new Patient(firstname.getText(), surname.getText(), username.getText(), password.getText(), address.getText()) );

				
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
		button.setBounds(21, 220, 117, 29);
		contentPane.add(button);
	}

}
