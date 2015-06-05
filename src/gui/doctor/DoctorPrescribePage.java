package gui.doctor;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.lang.Exception;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import users.Patient;
import utility.Diagnosis;
import medical.Illness;
import medical.Medicine;
import medical.management.IMedicalEntityManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * 
 * @author siavashnazari
 *
 */
public class DoctorPrescribePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6193897830801416924L;
	private JPanel contentPane;

	private JTextField prescriptionNameTextField;
	private JTextField prescriptionDateTextField;
	private JTextField illnessTitleTextField;

	private Patient patient;

	//	/**
	//	 * Launch the application.
	//	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					DoctorPrescribePage frame = new DoctorPrescribePage();
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
	public DoctorPrescribePage(Patient p) {

		this.patient = p;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titleLabel = new JLabel("تجویز نسخه برای بیماری");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(300, 6, 144, 29);
		contentPane.add(titleLabel);


		JButton backButton = new JButton("بازگشت");
		backButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

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

		JLabel PrescriptionNameLabel = new JLabel("نام دارو");
		PrescriptionNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PrescriptionNameLabel.setBounds(383, 167, 61, 26);
		contentPane.add(PrescriptionNameLabel);

		JLabel PrescriptionDate = new JLabel("زمان تجویز");
		PrescriptionDate.setHorizontalAlignment(SwingConstants.CENTER);
		PrescriptionDate.setBounds(371, 205, 73, 26);
		contentPane.add(PrescriptionDate);

		prescriptionNameTextField = new JTextField();
		prescriptionNameTextField.setEditable(false);
		prescriptionNameTextField.setColumns(10);
		prescriptionNameTextField.setBounds(231, 166, 140, 28);
		contentPane.add(prescriptionNameTextField);

		prescriptionDateTextField = new JTextField();
		prescriptionDateTextField.setColumns(10);
		prescriptionDateTextField.setBounds(263, 204, 108, 28);
		contentPane.add(prescriptionDateTextField);

		JButton submitButton = new JButton("ثبت");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				/**
				 * TODO check duplicate entries
				 * TODO add diagnosis details
				 */
				try {
					if(!illnessTitleTextField.getText().equals("") && !prescriptionNameTextField.getText().equals("")) {

						Illness illness = (Illness) IMedicalEntityManager.getIllness(illnessTitleTextField.getText());
						Diagnosis diagnosis = (Diagnosis) IMedicalEntityManager.getDiagnosis( patient.getID() , illness.getID() );
						Medicine medicine = (Medicine) IMedicalEntityManager.getMedicine( prescriptionNameTextField.getText() );

						diagnosis.addMedicine(medicine);

						JOptionPane.showMessageDialog(null, "داروی انتخاب شده، برای بیماری مورد نظر تجویز شد.");
					}
					else
						JOptionPane.showMessageDialog(null, "لطفاً نام دارو و نام بیماری را وارد کنید.");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "خطا در عملیات. آیا این نسخه را قبلاً تجویز کرده‌اید؟");
				}
				
			}
		});
		submitButton.setBounds(101, 243, 99, 29);
		contentPane.add(submitButton);

		MouseListener medicinesMouseListener = new MouseAdapter() {
			@SuppressWarnings("rawtypes")
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 1) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);
						prescriptionNameTextField.setText(((Medicine) o).getName());
					}
				}
			}
		};


		ArrayList<Object> allMedicinesList = new ArrayList<Object>( IMedicalEntityManager.getAllMedicines() );	    


		JScrollPane medicinesScrollPane = new JScrollPane();
		medicinesScrollPane.setBounds(231, 47, 140, 115);
		contentPane.add(medicinesScrollPane);
		JList<Object> allMedicinesJList = new JList<Object>(allMedicinesList.toArray());
		medicinesScrollPane.setViewportView(allMedicinesJList);
		allMedicinesJList.addMouseListener(medicinesMouseListener);
		allMedicinesJList.setBackground(Color.WHITE);

		MouseListener illnessesMouseListener = new MouseAdapter() {
			@SuppressWarnings("rawtypes")
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 1) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);
						illnessTitleTextField.setText(((Illness) o).getTitle());
					}
				}
			}
		};


		ArrayList<Object> patientIllnessesList = new ArrayList<Object>( patient.getIllnesses() );	    


		JScrollPane illnessesScrollPane = new JScrollPane();
		illnessesScrollPane.setBounds(17, 47, 140, 115);
		contentPane.add(illnessesScrollPane);
		JList<Object> patientIllnessesJList = new JList<Object>(patientIllnessesList.toArray());
		illnessesScrollPane.setViewportView(patientIllnessesJList);
		patientIllnessesJList.addMouseListener(illnessesMouseListener);
		patientIllnessesJList.setBackground(Color.WHITE);


		JLabel medicinesListLabel = new JLabel(" لیست دارو‌ها:");
		medicinesListLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		medicinesListLabel.setBounds(231, 47, 213, 23);
		contentPane.add(medicinesListLabel);

		JLabel PatientIllnessesLabel = new JLabel(" بیماری‌ها:");
		PatientIllnessesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		PatientIllnessesLabel.setBounds(6, 46, 213, 23);
		contentPane.add(PatientIllnessesLabel);

		JLabel illnessTitleLabel = new JLabel("نام بیماری");
		illnessTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		illnessTitleLabel.setBounds(158, 167, 61, 26);
		contentPane.add(illnessTitleLabel);

		illnessTitleTextField = new JTextField();
		illnessTitleTextField.setEditable(false);
		illnessTitleTextField.setColumns(10);
		illnessTitleTextField.setBounds(17, 166, 140, 28);
		contentPane.add(illnessTitleTextField);

	}
}
