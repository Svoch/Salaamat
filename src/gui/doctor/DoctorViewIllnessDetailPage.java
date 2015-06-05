package gui.doctor;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

import medical.Illness;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorViewIllnessDetailPage extends JFrame {

	private static final long serialVersionUID = -7832691915240296304L;

	private JPanel contentPane;
	private JTextField illnessTitleTextField;
	private JTextField illnessDescriptionTextField;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DoctorShowIllnessDetailPage frame = new DoctorShowIllnessDetailPage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DoctorViewIllnessDetailPage(Illness illness) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("جزئیات بیماری");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(300, 6, 144, 29);
		contentPane.add(titleLabel);
		
		JButton backButton = new JButton("بازگشت");
		backButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorReviewIllnessesPage frame = new DoctorReviewIllnessesPage();
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
		backButton.setBounds(6, 243, 96, 29);
		contentPane.add(backButton);
		
		JLabel illnessTitleLabel = new JLabel("نام بیماری");
		illnessTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		illnessTitleLabel.setBounds(383, 71, 61, 26);
		contentPane.add(illnessTitleLabel);
		
		JLabel illnessDescriptionLabel = new JLabel("توضیحات");
		illnessDescriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		illnessDescriptionLabel.setBounds(371, 103, 73, 26);
		contentPane.add(illnessDescriptionLabel);
		
		illnessTitleTextField = new JTextField(illness.getTitle());
		illnessTitleTextField.setEditable(false);
		illnessTitleTextField.setColumns(10);
		illnessTitleTextField.setBounds(110, 71, 261, 28);
		contentPane.add(illnessTitleTextField);
		
		illnessDescriptionTextField = new JTextField(illness.getDescription());
		illnessDescriptionTextField.setEditable(false);
		illnessDescriptionTextField.setColumns(10);
		illnessDescriptionTextField.setBounds(41, 103, 330, 128);
		contentPane.add(illnessDescriptionTextField);
	}
}
