package gui.drugstore;

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

public class DrugstoreShowPrescriptionPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7214314982839265239L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrugstoreShowPrescriptionPage frame = new DrugstoreShowPrescriptionPage();
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
	public DrugstoreShowPrescriptionPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u0645\u0634\u0627\u0647\u062F\u0647 \u0646\u0633\u062E\u0647");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(300, 6, 144, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u062F\u0627\u0631\u0648\u0647\u0627");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(377, 66, 61, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("<------>");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(131, 66, 230, 100);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u0622\u0632\u0645\u0627\u06CC\u0634\u200C\u0647\u0627");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(383, 180, 61, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("<------>");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(131, 172, 230, 76);
		contentPane.add(label_4);
		
		JButton button = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DrugstoreMainPage frame = new DrugstoreMainPage();
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
		button.setBounds(0, 243, 117, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u062B\u0628\u062A \u062A\u062D\u0648\u06CC\u0644 \u062F\u0627\u0631\u0648");
		button_1.setBounds(2, 219, 117, 29);
		contentPane.add(button_1);
	}

}
