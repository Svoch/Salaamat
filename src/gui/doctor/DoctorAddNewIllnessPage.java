package gui.doctor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

import medical.Illness;
import medical.management.IMedicalEntityManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorAddNewIllnessPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1368974179759749213L;
	private JPanel contentPane;
	private JTextField illnessTitleTextField;
	private JTextField illnessDescriptionTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorAddNewIllnessPage frame = new DoctorAddNewIllnessPage();
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
	public DoctorAddNewIllnessPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("ثبت بیماری جدید");
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
		
		JLabel descriptionLabel = new JLabel("توضیحات");
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setBounds(371, 103, 73, 26);
		contentPane.add(descriptionLabel);
		
		illnessTitleTextField = new JTextField();
		illnessTitleTextField.setColumns(10);
		illnessTitleTextField.setBounds(263, 71, 108, 28);
		contentPane.add(illnessTitleTextField);
		
		JButton submitButton = new JButton("ثبت");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				/**
				 * TODO handle adding confirmation here
				 */
				if(!illnessTitleTextField.getText().equals("")) {
					Illness illness = new Illness(illnessTitleTextField.getText());
					illness.setDescription(illnessDescriptionTextField.getText());
					IMedicalEntityManager.addIllness(illness);
					
				}
				else
					JOptionPane.showMessageDialog(null, "لطفاً نام بیماری را وارد کنید.");
				
			
			}
		});
		submitButton.setBounds(101, 243, 99, 29);
		contentPane.add(submitButton);
		
		illnessDescriptionTextField = new JTextField();
		illnessDescriptionTextField.setColumns(10);
		illnessDescriptionTextField.setBounds(41, 103, 330, 128);
		contentPane.add(illnessDescriptionTextField);
	}

}
