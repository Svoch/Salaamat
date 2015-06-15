package gui.drugstore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import users.Drugstore;
import users.management.DrugstoreUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author siavashnazari
 *
 */
public class DrugstoreProfilePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4967096620186500474L;
	private JPanel contentPane;
	
	private Drugstore patient = (Drugstore) new DrugstoreUserManager().getLoggedInUser();


	/**
	 * Create the frame.
	 */
	public DrugstoreProfilePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("مشخصات داروخانه\n");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(333, 6, 111, 29);
		contentPane.add(titleLabel);
		
		JLabel nameLabel = new JLabel("نام");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(383, 66, 61, 23);
		contentPane.add(nameLabel);
		
		JLabel certificateLabel = new JLabel("شماره پروانه");
		certificateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		certificateLabel.setBounds(371, 94, 73, 23);
		contentPane.add(certificateLabel);
		
		JLabel addressLabel = new JLabel("نشانی");
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
		backButton.setBounds(21, 220, 81, 29);
		contentPane.add(backButton);
		
		JTextField nameTextField = new JTextField(patient.getFirstname());
		nameTextField.setEditable(false);
		nameTextField.setBounds(173, 66, 186, 23);
		contentPane.add(nameTextField);
		
		JTextField certificateTextField = new JTextField(patient.getSurname());
		certificateTextField.setEditable(false);
		certificateTextField.setBounds(173, 94, 186, 23);
		contentPane.add(certificateTextField);
		
		JTextField AddressTextField = new JTextField(patient.getAddress());
		AddressTextField.setEditable(false);
		AddressTextField.setBounds(21, 150, 338, 23);
		contentPane.add(AddressTextField);
		
		JButton editButton = new JButton("ویرایش");
		editButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DrugstoreSignUpPage frame = new DrugstoreSignUpPage();
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
		
	}

}
