package gui.patient;

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

import javax.swing.JTextField;

import users.Patient;
import users.management.PatientUserManager;

/**
 * 
 * @author siavashnazari
 *
 */
public class PatientProfilePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4408782093621357426L;
	
	private Patient patient = (Patient) new PatientUserManager().getLoggedInUser();
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PatientProfilePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("مشخصات بیمار\n");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(333, 6, 111, 29);
		contentPane.add(titleLabel);
		
		JLabel firstnameLabel = new JLabel("نام");
		firstnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstnameLabel.setBounds(383, 66, 61, 23);
		contentPane.add(firstnameLabel);
		
		JLabel surnameLabel = new JLabel("نام خانوادگی");
		surnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		surnameLabel.setBounds(371, 94, 73, 23);
		contentPane.add(surnameLabel);
		
		JLabel addressLabel = new JLabel("نشانی منزل");
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setBounds(383, 150, 61, 23);
		contentPane.add(addressLabel);
		
		JButton backButton = new JButton("بازکشت");
		backButton.addActionListener(new ActionListener() {
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
		backButton.setBounds(21, 220, 81, 29);
		contentPane.add(backButton);
		
		JTextField firstnameTextField = new JTextField(patient.getFirstname());
		firstnameTextField.setEditable(false);
		firstnameTextField.setBounds(173, 66, 186, 23);
		contentPane.add(firstnameTextField);
		
		JTextField surnameTextField = new JTextField(patient.getSurname());
		surnameTextField.setEditable(false);
		surnameTextField.setBounds(173, 94, 186, 23);
		contentPane.add(surnameTextField);
		
		JTextField AddressTextField = new JTextField(patient.getAddress());
		AddressTextField.setEditable(false);
		AddressTextField.setBounds(21, 150, 338, 23);
		contentPane.add(AddressTextField);
		
		JTextField supervisorTextField = new JTextField();
		supervisorTextField.setEditable(false);
		supervisorTextField.setBounds(99, 178, 260, 23);
		if(patient.getSupervisor() != null)
			supervisorTextField.setText(patient.getSupervisor().toString());
		else
			supervisorTextField.setText("هنوز پزشکی به شما اختصاص داده نشده است.");
		contentPane.add(supervisorTextField);
		
		JButton editButton = new JButton("ویرایش");
		editButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientSignUpPage frame = new PatientSignUpPage();
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
		editButton.setBounds(99, 220, 81, 29);
		contentPane.add(editButton);
		
		JLabel supervisorLabel = new JLabel("پزشک");
		supervisorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		supervisorLabel.setBounds(383, 178, 61, 23);
		contentPane.add(supervisorLabel);
	}
}
