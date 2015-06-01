package gui.doctor;

import gui.LoginPage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JScrollPane;

import users.Doctor;
import users.login.DoctorUserManager;

/**
 * 
 * @author siavashnazari
 *
 */
public class DoctorMainPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 102L;

	private JPanel contentPane;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public DoctorMainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**
		 * TODO fix loggedInDoctor's name
		 */
		JLabel label = new JLabel("<----> خوش آمدید!");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label.setBounds(181, 6, 263, 25);
		contentPane.add(label);

		JButton exitButton = new JButton("خروج");
		exitButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LoginPage frame = new LoginPage();
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
		exitButton.setBounds(6, 243, 117, 29);
		contentPane.add(exitButton);

		JButton showProfileButton = new JButton("مشاهده پروفایل");
		showProfileButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

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

				contentPane.removeAll();
				contentPane.repaint();

				hide();


			}
		});
		showProfileButton.setBounds(115, 243, 117, 29);
		contentPane.add(showProfileButton);

		JButton viewRequestsButton = new JButton("مشاهده درخواست‌ها");
		viewRequestsButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorViewRequestsPage frame = new DoctorViewRequestsPage();
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
		viewRequestsButton.setBounds(20, 97, 181, 46);
		contentPane.add(viewRequestsButton);

		JButton viewPatientsButton = new JButton("مشاهده لیست بیماران");
		viewPatientsButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorViewAllPatiensPage frame = new DoctorViewAllPatiensPage();
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
		viewPatientsButton.setBounds(20, 142, 181, 46);
		contentPane.add(viewPatientsButton);

		MouseListener mouseListener = new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent mouseEvent) {


				JList theList = (JList) mouseEvent.getSource();
				List patientsList = ((Doctor) new DoctorUserManager().getLoggedInUser()).getPatientsList();

				
				
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);

						//----------------- Add doctor selection page here

						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									DoctorViewPatientsPage frame = new DoctorViewPatientsPage();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});

						contentPane.removeAll();
						contentPane.repaint();

						hide();

						System.out.println("Double-clicked on: " + o.toString());
					}
				}
			}
		};


		//String patientList[] = { "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->" };
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 73, 205, 115);
		contentPane.add(scrollPane);

		List patientList = ((Doctor) new DoctorUserManager().getLoggedInUser()).getPatientsList();
		
//		JList jlist = new JList((ListModel) patientList);
		
		JList jlist = new JList(patientList.toArray());
		scrollPane.setViewportView(jlist);
		jlist.addMouseListener(mouseListener);
		//	    contentPane.add(scrollPane1);
		jlist.setBackground(Color.WHITE);
		

		JLabel label_1 = new JLabel("لیست بیمار‌های شما:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(308, 45, 117, 16);
		contentPane.add(label_1);

	}
}
