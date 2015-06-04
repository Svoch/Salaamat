package gui.doctor;

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
import users.management.DoctorUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author siavashnazari
 *
 */
public class DoctorProfilePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7276170333543352879L;

	private Doctor doctor = (Doctor) new DoctorUserManager().getLoggedInUser();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorProfilePage frame = new DoctorProfilePage();
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
	public DoctorProfilePage() {
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
							DoctorMainPage frame = new DoctorMainPage();
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

		JTextField supervisorTextField = new JTextField(doctor.getSpecialty());
		supervisorTextField.setEditable(false);
		supervisorTextField.setBounds(99, 178, 260, 23);
		contentPane.add(supervisorTextField);

		JButton editButton = new JButton("ویرایش");
		editButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorSignUpPage frame = new DoctorSignUpPage();
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


		JLabel specialtyLabel = new JLabel("تخصص");
		specialtyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		specialtyLabel.setBounds(383, 178, 61, 23);
		contentPane.add(specialtyLabel);
	}

}
