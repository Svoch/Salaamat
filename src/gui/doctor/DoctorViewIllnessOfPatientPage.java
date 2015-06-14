package gui.doctor;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import medical.Illness;
import medical.management.IMedicalEntityManager;
import users.Patient;
import utility.Diagnosis;

public class DoctorViewIllnessOfPatientPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7139752099432515044L;

	private JPanel contentPane;
	private JTextField illnessTitleTextField;
	private JTextField illnessDescriptionTextField;
	private JTextField diagnosisDateTextField;
	
	private Patient patient;
	private Illness illness;

	/**
	 * Create the frame.
	 */
	public DoctorViewIllnessOfPatientPage(Patient p, Illness i) {
		
		this.illness = i;
		this.patient = p;
		
		Diagnosis diagnosis = (Diagnosis) IMedicalEntityManager.getDiagnosis(patient.getID(), illness.getID());
		diagnosis.getIllnessID();
		
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
							DoctorViewPatientPage frame = new DoctorViewPatientPage(patient);
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
		illnessDescriptionTextField.setBounds(41, 103, 330, 100);
		contentPane.add(illnessDescriptionTextField);
		
		JButton showPrescriptionButton = new JButton("مشاهده نسخه");
		showPrescriptionButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorShowPresciptionPage frame = new DoctorShowPresciptionPage(patient,illness);
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
		showPrescriptionButton.setBounds(100, 243, 96, 29);
		contentPane.add(showPrescriptionButton);
		
		JLabel diagnosisDate = new JLabel("تاریخ تشخیص");
		diagnosisDate.setHorizontalAlignment(SwingConstants.CENTER);
		diagnosisDate.setBounds(371, 206, 73, 26);
		contentPane.add(diagnosisDate);
		
		diagnosisDateTextField = new JTextField();
		/**
		 * TODO add date here
		 */
//		diagnosisDateTextField.setText(.........);
		diagnosisDateTextField.setEditable(false);
		diagnosisDateTextField.setColumns(10);
		diagnosisDateTextField.setBounds(263, 205, 108, 28);
		contentPane.add(diagnosisDateTextField);
	}

}
