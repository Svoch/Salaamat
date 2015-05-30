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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DoctorSignUpPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		
		JLabel label_2 = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(371, 94, 73, 16);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(225, 60, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(225, 88, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u062A\u062E\u0635\u0635*\n");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(383, 122, 61, 16);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(225, 116, 134, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("\u0646\u0634\u0627\u0646\u06CC \u0645\u0637\u0628");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(383, 150, 61, 16);
		contentPane.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(212, 144, 147, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_5 = new JLabel("\u06AF\u0630\u0631\u0648\u0627\u0698\u0647");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(129, 94, 71, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u0646\u0627\u0645 \u06A9\u0627\u0631\u0628\u0631\u06CC");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(129, 66, 71, 16);
		contentPane.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(21, 60, 96, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(21, 88, 96, 28);
		contentPane.add(textField_5);
		
		JLabel label_7 = new JLabel("\u062A\u06A9\u0631\u0627\u0631 \u06AF\u0630\u0631\u0648\u0627\u0698\u0647");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(129, 122, 71, 16);
		contentPane.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(21, 116, 96, 28);
		contentPane.add(textField_6);
		
		JButton button = new JButton("\u062B\u0628\u062A \u0627\u0637\u0644\u0627\u0639\u0627\u062A");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
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
