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

/**
 * 
 * @author siavashnazari
 *
 */
public class PatientSicknessDetailPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3416373368565869041L;
	private JPanel contentPane;
	private JFrame returnPage; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientSicknessDetailPage frame = new PatientSicknessDetailPage(new LoginPage());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param returnPage 
	 */
	public PatientSicknessDetailPage(final JFrame returnPage) {
		
		// returnPage must be set
		
		this.setReturnPage(returnPage);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u062C\u0632\u0626\u06CC\u0627\u062A \u0648 \u0634\u0631\u062D \u0628\u06CC\u0645\u0627\u0631\u06CC");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(261, 6, 183, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u0646\u0627\u0645 \u0628\u06CC\u0645\u0627\u0631\u06CC");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(383, 66, 61, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u0646\u0638\u0631 \u067E\u0632\u0634\u06A9");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(371, 94, 73, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u062A\u0627\u0631\u06CC\u062E \u062A\u0634\u062E\u06CC\u0635");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(341, 164, 103, 16);
		contentPane.add(label_3);
		
		JButton button = new JButton("\u0628\u0627\u0632\u06A9\u0634\u062A");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							// PatientMedicalHistoryPage frame = new PatientMedicalHistoryPage();
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
		
		JLabel label_4 = new JLabel("<-->");
		label_4.setBounds(298, 66, 61, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("<---->");
		label_5.setBounds(112, 94, 247, 54);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("<--->");
		label_6.setBounds(286, 164, 73, 16);
		contentPane.add(label_6);
		
		JButton button_1 = new JButton("\u0645\u0634\u0627\u0647\u062F\u0647 \u0646\u0633\u062E\u0647");
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientShowPrescriptionPage frame = new PatientShowPrescriptionPage();
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
		button_1.setBounds(322, 192, 122, 29);
		contentPane.add(button_1);
	}

	public JFrame getReturnPage() {
		return returnPage;
	}

	public void setReturnPage(JFrame returnPage) {
		this.returnPage = returnPage;
	}

}
