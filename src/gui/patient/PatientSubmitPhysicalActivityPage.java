package gui.patient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PatientSubmitPhysicalActivityPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2551536715568427095L;
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
					PatientSubmitPhysicalActivityPage frame = new PatientSubmitPhysicalActivityPage();
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
	public PatientSubmitPhysicalActivityPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u062A\u0627\u0631\u06CC\u062E \u0634\u0631\u0648\u0639");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(371, 83, 73, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u062A\u0627\u0631\u06CC\u062E \u067E\u0627\u06CC\u0627\u0646");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(381, 111, 61, 16);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(263, 77, 108, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(263, 105, 108, 28);
		contentPane.add(textField_1);
		
		JButton button = new JButton("\u062B\u0628\u062A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(263, 152, 99, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		button_1.addActionListener(new ActionListener() {
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
		button_1.setBounds(6, 243, 117, 29);
		contentPane.add(button_1);
		
		JLabel label_2 = new JLabel("\u062B\u0628\u062A \u0641\u0639\u0627\u0644\u06CC\u062A \u0628\u062F\u0646\u06CC");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_2.setBounds(300, 6, 144, 29);
		contentPane.add(label_2);
	}

}
