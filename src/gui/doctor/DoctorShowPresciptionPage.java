package gui.doctor;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import users.Patient;
import utility.Diagnosis;
import medical.Illness;
import medical.Medicine;
import medical.management.IMedicalEntityManager;

public class DoctorShowPresciptionPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7160486139138585251L;
	private JPanel contentPane;
	private JTextField medicineNameTextField;
	private JTextField prescriptionDateTextField;
	private JTextField medicineDescriptionTextField;
	
	private Illness illness;
	private Patient patient;

	
	/**
	 * Create the frame.
	 */
	public DoctorShowPresciptionPage(Patient p, Illness i) {
	
		this.illness = i; 
		this.patient = p;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("مشاهده نسخه");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(306, 6, 144, 29);
		contentPane.add(titleLabel);
		
		JLabel medicinesListLabel = new JLabel("لیست داروها:");
		medicinesListLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		medicinesListLabel.setBounds(231, 66, 213, 26);
		contentPane.add(medicinesListLabel);
		
		JButton backButton = new JButton("بازگشت");
		backButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				
				/**
				 * TODO notice: deep shit here
				 */
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorViewIllnessOfPatientPage frame = new DoctorViewIllnessOfPatientPage(patient,illness);
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
		backButton.setBounds(6, 243, 117, 29);
		contentPane.add(backButton);
		
		MouseListener medicinesMouseListener = new MouseAdapter() {
			@SuppressWarnings("rawtypes")
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 1) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);
						medicineNameTextField.setText(((Medicine) o).getName());
						medicineDescriptionTextField.setText(((Medicine) o).getDescription());
						/**
						 * TODO add date 
						 */
					}
				}
			}
		};


		int patientID = patient.getID();
		int illnessID = illness.getID();
		Diagnosis diagnosis = (Diagnosis) IMedicalEntityManager.getDiagnosis(patientID, illnessID);
		ArrayList<Object> allMedicinesList = new ArrayList<Object>( diagnosis.getMedicines() );	    


		JScrollPane medicinesScrollPane = new JScrollPane();
		medicinesScrollPane.setBounds(231, 66, 140, 68);
		contentPane.add(medicinesScrollPane);
		JList<Object> allMedicinesJList = new JList<Object>(allMedicinesList.toArray());
		medicinesScrollPane.setViewportView(allMedicinesJList);
		allMedicinesJList.addMouseListener(medicinesMouseListener);
		allMedicinesJList.setBackground(Color.WHITE);
		
		
		
		JLabel medicineNameLabel = new JLabel("نام دارو");
		medicineNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		medicineNameLabel.setBounds(168, 66, 61, 26);
		contentPane.add(medicineNameLabel);
		
		JLabel prescriptionDateLabel = new JLabel("زمان تجویز");
		prescriptionDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		prescriptionDateLabel.setBounds(156, 105, 73, 26);
		contentPane.add(prescriptionDateLabel);
		
		medicineNameTextField = new JTextField();
		medicineNameTextField.setEditable(false);
		medicineNameTextField.setColumns(10);
		medicineNameTextField.setBounds(16, 65, 140, 28);
		contentPane.add(medicineNameTextField);
		
		prescriptionDateTextField = new JTextField();
		prescriptionDateTextField.setEditable(false);
		prescriptionDateTextField.setColumns(10);
		prescriptionDateTextField.setBounds(48, 104, 108, 28);
		contentPane.add(prescriptionDateTextField);
		
		JLabel medicineDescriptionLabel = new JLabel("توضیحات");
		medicineDescriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		medicineDescriptionLabel.setBounds(389, 147, 61, 26);
		contentPane.add(medicineDescriptionLabel);
		
		medicineDescriptionTextField = new JTextField();
		medicineDescriptionTextField.setEditable(false);
		medicineDescriptionTextField.setColumns(10);
		medicineDescriptionTextField.setBounds(16, 146, 355, 85);
		contentPane.add(medicineDescriptionTextField);
	
	}

}
