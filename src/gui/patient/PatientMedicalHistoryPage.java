package gui.patient;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

import medical.Illness;


import users.Patient;
import users.management.PatientUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Set;

/**
 * 
 * @author siavashnazari
 *
 */
public class PatientMedicalHistoryPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4060125018860454673L;
	private JPanel contentPane;
	private JTextField startDateTextField;
	private JTextField endDateTextField;


//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PatientMedicalHistoryPage frame = new PatientMedicalHistoryPage();
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
	public PatientMedicalHistoryPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titleLabel = new JLabel("سوابق پزشکی");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(300, 6, 144, 29);
		contentPane.add(titleLabel);


		//--------------------------------------------------------------
		//--------------------------------------------------------------


		MouseListener mouseListener = new MouseAdapter() {
			@SuppressWarnings({ "deprecation", "rawtypes" })
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);

						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									PatientViewIllnessDetailPage frame = new PatientViewIllnessDetailPage((Illness) o);
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
				}
			}
		};

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 49, 205, 190);
		contentPane.add(scrollPane);
		scrollPane.setBounds(225, 87, 205, 98);


		
		Set<Illness> illnessesList = ((Patient)(new PatientUserManager().getLoggedInUser())).getIllnesses();
		JList<Object> jList = new JList<Object>(illnessesList.toArray());

		scrollPane.setViewportView(jList);
		jList.addMouseListener(mouseListener);
		jList.setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(jList);

		JLabel searchTitleLabel = new JLabel("جست و جو در لیست");
		searchTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchTitleLabel.setBounds(99, 59, 114, 16);
		contentPane.add(searchTitleLabel);

		JLabel startDateLabel = new JLabel("تاریخ شروع");
		startDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		startDateLabel.setBounds(140, 87, 73, 16);
		contentPane.add(startDateLabel);

		JLabel finishDateLabel = new JLabel("تاریخ پایان");
		finishDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		finishDateLabel.setBounds(150, 115, 61, 16);
		contentPane.add(finishDateLabel);

		startDateTextField = new JTextField();
		startDateTextField.setColumns(10);
		startDateTextField.setBounds(32, 81, 108, 28);
		contentPane.add(startDateTextField);

		endDateTextField = new JTextField();
		endDateTextField.setColumns(10);
		endDateTextField.setBounds(32, 109, 108, 28);
		contentPane.add(endDateTextField);

		JButton searchButton = new JButton("جست و جو");
		searchButton.setBounds(32, 156, 99, 29);
		contentPane.add(searchButton);

		JButton backButton = new JButton("بازگشت");
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
		backButton.setBounds(6, 243, 96, 29);
		contentPane.add(backButton);

		JLabel illnessesListLabel = new JLabel("لیست بیماری‌ها");
		illnessesListLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		illnessesListLabel.setBounds(339, 59, 91, 16);
		contentPane.add(illnessesListLabel);

		JButton showBodyStateButton = new JButton("مشاهده سوابق جسمانی");
		showBodyStateButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientBodyStatesPage frame = new PatientBodyStatesPage();
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
		showBodyStateButton.setBounds(259, 197, 171, 29);
		contentPane.add(showBodyStateButton);

		JButton showPhysicalActivityButton = new JButton("مشاهده فعالیت بدنی");
		showPhysicalActivityButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientPhysicalActivityHistoryPage frame = new PatientPhysicalActivityHistoryPage();
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
		showPhysicalActivityButton.setBounds(259, 226, 171, 29);
		contentPane.add(showPhysicalActivityButton);
	}

}
