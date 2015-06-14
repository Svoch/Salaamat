package gui.doctor;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import medical.Illness;
import medical.management.IMedicalEntityManager;
import users.Patient;
import users.Doctor;
import users.management.DoctorUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DoctorAddIlnessToPatientPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6134944076788330902L;
	private JPanel contentPane;
	private JTextField illnessTitleTextField;
	private JTextField illnessDiagnosisDateTextField;

	private Patient patient;

	//	/**
	//	 * Launch the application.
	//	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					DoctorAddIlnessToPatientPage frame = new DoctorAddIlnessToPatientPage();
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
	public DoctorAddIlnessToPatientPage(Patient p) {

		this.patient = p;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titleLabel = new JLabel("ثبت بیماری برای بیمار");
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

		JLabel illnessTitleLabel = new JLabel("نام بیماری");
		illnessTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		illnessTitleLabel.setBounds(383, 167, 61, 26);
		contentPane.add(illnessTitleLabel);

		JLabel illnessDiagnosisDate = new JLabel("زمان تشخیص");
		illnessDiagnosisDate.setHorizontalAlignment(SwingConstants.CENTER);
		illnessDiagnosisDate.setBounds(371, 205, 73, 26);
		contentPane.add(illnessDiagnosisDate);

		illnessTitleTextField = new JTextField();
		illnessTitleTextField.setEditable(false);
		illnessTitleTextField.setColumns(10);
		illnessTitleTextField.setBounds(120, 166, 251, 28);
		contentPane.add(illnessTitleTextField);

		illnessDiagnosisDateTextField = new JTextField();
		illnessDiagnosisDateTextField.setColumns(10);
		illnessDiagnosisDateTextField.setBounds(263, 204, 108, 28);
		contentPane.add(illnessDiagnosisDateTextField);

		JButton submitButton = new JButton("ثبت");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * TODO check duplicate Illnesses
				 * TODO add diagnosis details
				 */

				Illness illness = (Illness) IMedicalEntityManager.getIllness( illnessTitleTextField.getText() );

				if(!illness.getTitle().equals(""))
					( (Doctor) new DoctorUserManager().getLoggedInUser() ).addIllness(patient,illness);
//					patient.addIllness(illness);
				else
					JOptionPane.showMessageDialog(null, "لطفاً نام بیماری را وارد کنید.");

			}
		});
		submitButton.setBounds(101, 243, 99, 29);
		contentPane.add(submitButton);

		MouseListener mouseListener = new MouseAdapter() {
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


		ArrayList<Object> allIllnessesList = new ArrayList<Object>( IMedicalEntityManager.getAllIllnesses() );	    


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 47, 222, 115);
		contentPane.add(scrollPane);
		JList<Object> jlist = new JList<Object>(allIllnessesList.toArray());
		scrollPane.setViewportView(jlist);
		jlist.addMouseListener(mouseListener);
		jlist.setBackground(Color.WHITE);
		
		JLabel label = new JLabel(" لیست بیماری‌ها:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(231, 47, 213, 23);
		contentPane.add(label);

	}
}
