package gui.patient;
import gui.LoginPage;

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


public class PatientMainPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6100680177851509918L;

	private JPanel contentPane;
	
	// Need to be object oriented
	private String patientName = "<---->";
	private String doctorName = "<---->";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public PatientMainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel( patientName + " \u062E\u0648\u0634 \u0622\u0645\u062F\u06CC\u062F!");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label.setBounds(181, 6, 263, 25);
		contentPane.add(label);
		
		
		JLabel label_1 = new JLabel("\u067E\u0632\u0634\u06A9 \u0634\u0645\u0627 " + doctorName + " \u0627\u0633\u062A.");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(297, 65, 147, 16);
		
		JButton button = new JButton("\u062A\u063A\u06CC\u06CC\u0631 \u067E\u0632\u0634\u06A9");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientAddDoctorPage frame = new PatientAddDoctorPage();
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
		button.setBounds(168, 60, 117, 29);
		
		JButton button_1 = new JButton("\u0627\u0631\u062A\u0628\u0627\u0637 \u0628\u0627 \u067E\u0632\u0634\u06A9");
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientConsultDoctorPage frame = new PatientConsultDoctorPage();
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
		button_1.setBounds(39, 60, 117, 29);
		
		JLabel label_2 = new JLabel("\u0634\u0645\u0627 \u062F\u0631 \u062D\u0627\u0644 \u062D\u0627\u0636\u0631 \u067E\u0632\u0634\u06A9\u06CC \u0646\u062F\u0627\u0631\u06CC\u062F.");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(243, 93, 201, 16);
		
		JButton button_2 = new JButton("\u0627\u0641\u0632\u0648\u062F\u0646 \u067E\u0632\u0634\u06A9");
		button_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientAddDoctorPage frame = new PatientAddDoctorPage();
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
		button_2.setBounds(140, 88, 117, 29);
		
		JButton button_3 = new JButton("\u062E\u0631\u0648\u062C");
		button_3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
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
				
				contentPane.removeAll();
				contentPane.repaint();
				hide();
				
			}
		});
		button_3.setBounds(6, 243, 117, 29);
		contentPane.add(button_3);
	

		// Need to be object oriented
//		if(doctorName!=null) {
			contentPane.add(button);
			contentPane.add(button_1);
			contentPane.add(label_1);
//		}
//		else {
			contentPane.add(button_2);
			contentPane.add(label_2);
//		}
		
		JButton button_4 = new JButton("\u0645\u0634\u0627\u0647\u062F\u0647 \u067E\u0631\u0648\u0641\u0627\u06CC\u0644");
		button_4.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
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
				
				contentPane.removeAll();
				contentPane.repaint();
				
				hide();
			
			}
		});
		button_4.setBounds(115, 243, 117, 29);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("\u0645\u0634\u0627\u0647\u062F\u0647 \u0633\u0648\u0627\u0628\u0642 \u067E\u0632\u0634\u06A9\u06CC");
		button_5.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientMedicalHistoryPage frame = new PatientMedicalHistoryPage();
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
		button_5.setBounds(263, 121, 181, 46);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("\u062B\u0628\u062A \u0641\u0639\u0627\u0644\u06CC\u062A\u200C\u0647\u0627\u06CC \u0628\u062F\u0646\u06CC");
		button_6.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientSubmitPhysicalActivityPage frame = new PatientSubmitPhysicalActivityPage();
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
		button_6.setBounds(263, 168, 181, 46);
		contentPane.add(button_6);
	}
}
