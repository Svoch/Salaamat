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
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientRequestDoctorPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4741161238333393232L;
	private JPanel contentPane;
	private JFrame returnPage;
	
	
	String doctorName = "<-->";
	String doctorSurname = "<---->";
	String doctorProfession = "<--->";
	String doctorOfficeAddress = "<---------->";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientRequestDoctorPage frame = new PatientRequestDoctorPage(new LoginPage());
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
	public PatientRequestDoctorPage(final JFrame returnPage) {
		
		this.setReturnPage(returnPage);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u0645\u0634\u062E\u0635\u0627\u062A \u067E\u0632\u0634\u06A9\n");
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
		
		JLabel label_3 = new JLabel("\u062A\u062E\u0635\u0635");
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
//							PatientAddDoctorPage frame = new PatientAddDoctorPage();
							JFrame frame = returnPage;
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
		
		JLabel label_4 = new JLabel(doctorName);
		label_4.setBounds(298, 66, 61, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel(doctorSurname);
		label_5.setBounds(298, 94, 61, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel(doctorProfession);
		label_6.setBounds(286, 150, 73, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u0646\u0634\u0627\u0646\u06CC \u0645\u0637\u0628");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(383, 178, 61, 16);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel(doctorOfficeAddress);
		label_8.setBounds(185, 178, 174, 16);
		contentPane.add(label_8);
		
		JButton button_1 = new JButton("\u0627\u0631\u0633\u0627\u0644 \u062F\u0631\u062E\u0648\u0627\u0633\u062A");
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							// ---------- Beware!!... error-prone piece of code
							
							OperationSuccessfulPage frame = new OperationSuccessfulPage(new PatientRequestDoctorPage(returnPage));
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
		button_1.setBounds(99, 220, 122, 29);
		contentPane.add(button_1);
	}

	public JFrame getReturnPage() {
		return returnPage;
	}

	public void setReturnPage(JFrame returnPage) {
		this.returnPage = returnPage;
	}

}
