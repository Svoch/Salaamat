package gui.patient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author siavashnazari
 *
 */
public class PatientProfilePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4408782093621357426L;
	String patientName = "<-->";
	String patientSurname = "<-->";
	String patientAddress = "<----->";
	String patientDoctorName = "<-->";
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientProfilePage frame = new PatientProfilePage();
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
	public PatientProfilePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u0645\u0634\u062E\u0635\u0627\u062A \u0628\u06CC\u0645\u0627\u0631\n");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
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
		
		JLabel label_3 = new JLabel("\u0646\u0634\u0627\u0646\u06CC \u0645\u0646\u0632\u0644");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(383, 150, 61, 16);
		contentPane.add(label_3);
		
		JButton button = new JButton("\u0628\u0627\u0632\u06A9\u0634\u062A");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
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
		});
		button.setBounds(21, 220, 81, 29);
		contentPane.add(button);
		
		JLabel label_4 = new JLabel(patientName);
		label_4.setBounds(298, 66, 61, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel(patientSurname);
		label_5.setBounds(298, 94, 61, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel(patientAddress);
		label_6.setBounds(199, 150, 160, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u067E\u0632\u0634\u06A9");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(383, 178, 61, 16);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel(patientDoctorName);
		label_8.setBounds(199, 178, 61, 16);
		contentPane.add(label_8);
		
		JButton button_1 = new JButton("\u0648\u06CC\u0631\u0627\u06CC\u0634");
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
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
				
				contentPane.removeAll();
				contentPane.repaint();
				
				hide();
			
			}
		});
		button_1.setBounds(99, 220, 81, 29);
		contentPane.add(button_1);
	}
}
