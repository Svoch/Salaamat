package gui.doctor;

import java.awt.EventQueue;

import javax.swing.JComboBox;
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
 * @author naderi
 *
 */
public class DoctorReportPage extends JFrame {

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
					DoctorReportPage frame = new DoctorReportPage();
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
	public DoctorReportPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("گزارش تجمیعی");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(300, 6, 144, 29);
		contentPane.add(titleLabel);

		JLabel label1 = new JLabel("بازه زمان");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(340, 37, 111, 29);
		contentPane.add(label1);

		JTextField startDateField = new JTextField();
		startDateField.setBounds(250, 40, 80, 28);
		contentPane.add(startDateField);
		startDateField.setColumns(6);

		JTextField endDateField = new JTextField();
		endDateField.setBounds(160, 40, 80, 28);
		contentPane.add(endDateField);
		endDateField.setColumns(10);

		JLabel label3 = new JLabel("نوع بیماری");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(340, 77, 111, 29);
		contentPane.add(label3);
		
		String[] illnesses = { "تست ۱","تست ۲", "تست ۳","تست ۴"};
		JComboBox<String> illMenu = new JComboBox<String>(illnesses);
		illMenu.setBounds(220, 80, 110, 28);
		contentPane.add(illMenu);
		
		JLabel label4 = new JLabel("بازه فشار خون");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setBounds(340, 117, 111, 29);
		contentPane.add(label4);
		
		JTextField press1Field = new JTextField();
		press1Field.setBounds(250, 120, 80, 28);
		contentPane.add(press1Field);
		press1Field.setColumns(10);
		
		JTextField press2Field = new JTextField();
		press2Field.setBounds(160, 120, 80, 28);
		contentPane.add(press2Field);
		press2Field.setColumns(10);
		
		JLabel label5 = new JLabel("بازه قند خون");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setBounds(340, 157, 111, 29);
		contentPane.add(label5);
		
		JTextField sugar1Field = new JTextField();
		sugar1Field.setBounds(250, 160, 80, 28);
		contentPane.add(sugar1Field);
		sugar1Field.setColumns(10);
		
		JTextField sugar2Field = new JTextField();
		sugar2Field.setBounds(160, 160, 80, 28);
		contentPane.add(sugar2Field);
		sugar2Field.setColumns(10);

		JLabel label6 = new JLabel("بازه فعالیت بدنی");
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setBounds(340, 197, 111, 29);
		contentPane.add(label6);
		
		JTextField act1Field = new JTextField();
		act1Field.setBounds(250, 200, 80, 28);
		contentPane.add(act1Field);
		act1Field.setColumns(10);
		
		JTextField act2Field = new JTextField();
		act2Field.setBounds(160, 200, 80, 28);
		contentPane.add(act2Field);
		act2Field.setColumns(10);

		JButton backButton = new JButton("بازگشت");
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
		backButton.setBounds(21, 230, 81, 29);
		contentPane.add(backButton);

		JButton okButton = new JButton("نمایش");
		okButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							/*
							 * TODO search here, and pass the result
							 */
							int[] xdata = { 1,2,3,4,5};
							int[] ydata = { 9,2,4,1,7};
							DoctorShowReport frame = new DoctorShowReport(xdata, ydata);
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
		okButton.setBounds(99, 230, 81, 29);
		contentPane.add(okButton);


	}

}