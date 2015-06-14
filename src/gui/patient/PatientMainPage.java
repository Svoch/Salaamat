package gui.patient;
import gui.LoginPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import users.Patient;
import users.management.DoctorUserManager;
import users.management.PatientUserManager;
import utility.hibernate.HibernateUtility;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author siavashnazari
 *
 */
public class PatientMainPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6100680177851509918L;

	private JPanel contentPane;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PatientMainPage frame = new PatientMainPage();
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
	public PatientMainPage() {
		
		HibernateUtility.createSessionFactory();
		// TODO WTF?
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel( "مشتری " + ((Patient) new PatientUserManager().getLoggedInUser()).toString() + " خوش آمدید!" );
		titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		titleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		titleLabel.setBounds(181, 6, 263, 25);
		contentPane.add(titleLabel);
		
		String supervisorSurname = null;
		if( ((Patient) new PatientUserManager().getLoggedInUser()).getSupervisor()!= null )
//			supervisorSurname = ((Doctor)(IUserManager.getDoctor(((Patient) new PatientUserManager().getLoggedInUser()).getSupervisorID()))).getSurname();
			supervisorSurname = ((Patient) new PatientUserManager().getLoggedInUser()).getSupervisor().getSurname();
		JLabel supervisorNameLabel = new JLabel(" پزشک شما دکتر " + supervisorSurname  + " است.");
		supervisorNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		supervisorNameLabel.setBounds(231, 60, 213, 29);
		
		JButton changeSupervisorButton = new JButton("تغییر پزشک");
		changeSupervisorButton.addActionListener(new ActionListener() {
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
		changeSupervisorButton.setBounds(115, 60, 117, 29);
		
		JButton consultWithSupervisorButton = new JButton("ارتباط با پزشک");
		consultWithSupervisorButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientConsultDoctorPage frame = new PatientConsultDoctorPage();
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
		consultWithSupervisorButton.setBounds(6, 60, 117, 29);
		
		JLabel noSupervisorLabel = new JLabel("شما در حال حاضر پزشکی ندارید.");
		noSupervisorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		noSupervisorLabel.setBounds(243, 88, 201, 25);
		
		JButton addSupervisorButton = new JButton("افزودن پزشک");
		addSupervisorButton.addActionListener(new ActionListener() {
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
		addSupervisorButton.setBounds(63, 88, 117, 29);
		
		JButton exitButton = new JButton("خروج");
		exitButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				/**
				 * TODO add "Are you sure?" message
				 */
				
				new DoctorUserManager().setLoggedInUser(null);

				
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
	

		if( supervisorSurname != null) {
			contentPane.add(changeSupervisorButton);
			contentPane.add(consultWithSupervisorButton);
			contentPane.add(supervisorNameLabel);
		}
		else {
			contentPane.add(addSupervisorButton);
			contentPane.add(noSupervisorLabel);
		}
		
		JButton showProfileButton = new JButton("مشاهده پروفایل");
		showProfileButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientProfilePage frame = new PatientProfilePage();
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
		
		JButton showMedicalHistoryButton = new JButton("مشاهده سوابق پزشکی");
		showMedicalHistoryButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientMedicalHistoryPage frame = new PatientMedicalHistoryPage();
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
		showMedicalHistoryButton.setBounds(263, 121, 181, 46);
		contentPane.add(showMedicalHistoryButton);
		
		JButton showPhysicalActivityButton = new JButton("ثبت فعالیت‌های بدنی");
		showPhysicalActivityButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientAddPhysicalActivityPage frame = new PatientAddPhysicalActivityPage();
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
		showPhysicalActivityButton.setBounds(263, 168, 181, 46);
		contentPane.add(showPhysicalActivityButton);
	}
}
