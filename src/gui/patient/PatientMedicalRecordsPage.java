package gui.patient;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * 
 * @author siavashnazari
 *
 */
public class PatientMedicalRecordsPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7210371391273046133L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientMedicalRecordsPage frame = new PatientMedicalRecordsPage();
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
	public PatientMedicalRecordsPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u0633\u0648\u0627\u0628\u0642 \u067E\u0632\u0634\u06A9\u06CC");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label.setBounds(169, 6, 275, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u062A\u0627\u0631\u06CC\u062E \u0634\u0631\u0648\u0639 \u0628\u0627\u0632\u0647");
		label_1.setBounds(352, 76, 92, 16);
		contentPane.add(label_1);
	}

}
