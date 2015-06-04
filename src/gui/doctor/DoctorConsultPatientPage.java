package gui.doctor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author siavashnazari
 *
 */
public class DoctorConsultPatientPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 101L;
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
					DoctorConsultPatientPage frame = new DoctorConsultPatientPage();
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
	public DoctorConsultPatientPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u0645\u0634\u0627\u0648\u0631\u0647 \u0628\u0627 \u0628\u06CC\u0645\u0627\u0631");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(300, 6, 144, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u0646\u0638\u0631 \u0628\u06CC\u0645\u0627\u0631");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(383, 72, 61, 16);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(121, 66, 250, 80);
		contentPane.add(textField);
		
		JLabel label_2 = new JLabel("\u0646\u0638\u0631 \u067E\u0632\u0634\u06A9");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(383, 155, 61, 16);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(121, 147, 250, 80);
		contentPane.add(textField_1);
		
		JButton button = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				/**
				 * TODO deep shit here
				 */
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorViewPatientPage frame = new DoctorViewPatientPage(null);
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
		button.setBounds(6, 243, 117, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u062B\u0628\u062A");
		button_1.setBounds(121, 243, 117, 29);
		contentPane.add(button_1);
	}
}
