package gui.patient;


import gui.OperationSuccessfulPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import users.Doctor;
import users.Patient;
import users.management.PatientUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author siavashnazari
 *
 */
public class PatientRequestDoctorPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4741161238333393232L;

	private Doctor doctor;
	private JPanel contentPane;
	private JFrame returnPage;


	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					PatientRequestDoctorPage frame = new PatientRequestDoctorPage(new LoginPage());
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
	public PatientRequestDoctorPage(Doctor doc, final JFrame returnPage) {

		this.doctor = doc;
		this.setReturnPage(returnPage);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titleLabel = new JLabel("مشخصات پزشک\n");
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
							PatientAddDoctorPage frame = new PatientAddDoctorPage();
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

		JTextField firstnameTextField = new JTextField(doctor.getFirstname());
		firstnameTextField.setEditable(false);
		firstnameTextField.setBounds(173, 66, 186, 23);
		contentPane.add(firstnameTextField);

		JTextField surnameTextField = new JTextField(doctor.getSurname());
		surnameTextField.setEditable(false);
		surnameTextField.setBounds(173, 94, 186, 23);
		contentPane.add(surnameTextField);

		JTextField AddressTextField = new JTextField(doctor.getAddress());
		AddressTextField.setEditable(false);
		AddressTextField.setBounds(21, 150, 338, 23);
		contentPane.add(AddressTextField);

		JTextField specialtyTextField = new JTextField(doctor.getSpecialty());
		specialtyTextField.setEditable(false);
		specialtyTextField.setBounds(99, 178, 260, 23);
		contentPane.add(specialtyTextField);


		JLabel specialtyLabel = new JLabel("تخصص");
		specialtyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		specialtyLabel.setBounds(383, 178, 61, 23);
		contentPane.add(specialtyLabel);


		JButton button_1 = new JButton("ارسال درخواست");
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				/**
				 * 
				 * TODO handle request to its own doctor bug
				 */
				((Patient) new PatientUserManager().getLoggedInUser()).requestSupervisor(doctor);
				
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							// ---------- Beware!!... error-prone piece of code

							OperationSuccessfulPage frame = new OperationSuccessfulPage(new PatientRequestDoctorPage(doctor, returnPage));
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
		button_1.setBounds(99, 220, 122, 29);
		contentPane.add(button_1);



	}

	public JFrame getReturnPage() {
		return returnPage;
	}

	public void setReturnPage(JFrame returnPage) {
		this.returnPage = returnPage;
	}

}
