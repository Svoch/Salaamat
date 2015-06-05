package gui.doctor;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import users.Doctor;
import users.Patient;
import users.management.DoctorUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author siavashnazari
 *
 */
public class DoctorViewPatientWithRequestPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7418629067370152485L;
	private JPanel contentPane;
	private Patient patient;

	//	/**
	//	 * Launch the application.
	//	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					DoctorOtherPatientWithRequestViewPage frame = new DoctorOtherPatientWithRequestViewPage();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}
	/**
	 * Create the frame.
	 * @param patient 
	 */
	public DoctorViewPatientWithRequestPage(Patient p) {

		this.patient = p;
		//		this.setReturnPage(returnPage);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titleLabel = new JLabel("مشخصات بیمار");
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
							DoctorViewAllRequestsPage frame = new DoctorViewAllRequestsPage();
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

		JButton btnNewButton = new JButton("رد درخواست");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				((Doctor) new DoctorUserManager().getLoggedInUser()).rejectRequest(patient);

				JOptionPane.showMessageDialog(null, "درخواست بیمار مورد نظر رد شد.");

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorViewAllRequestsPage frame = new DoctorViewAllRequestsPage();
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
		btnNewButton.setBounds(114, 220, 117, 29);
		contentPane.add(btnNewButton);

		JButton approveRequestButton = new JButton("پذیرش درخواست");
		approveRequestButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				((Doctor) new DoctorUserManager().getLoggedInUser()).approveRequest(patient);

				JOptionPane.showMessageDialog(null, "پذیرش درخواست بیمار با موفقیت انجام شد.");

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorViewAllRequestsPage frame = new DoctorViewAllRequestsPage();
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
		approveRequestButton.setBounds(223, 220, 117, 29);
		contentPane.add(approveRequestButton);
	}

}
