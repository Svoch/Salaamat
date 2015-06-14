package gui.doctor;


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

import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import users.Patient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Set;

import javax.swing.JTextField;

import medical.Illness;

/**
 * 
 * @author siavashnazari
 *
 */
public class DoctorViewPatientPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5743315232541890339L;

	private JPanel contentPane;
	private JTextField firstnameTextField;
	private JTextField surnameTextField;

	private Patient patient;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DoctorViewPatientPage frame = new DoctorViewPatientPage(null);
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
	public DoctorViewPatientPage(Patient p) {
		
		this.patient = p;
		
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
		firstnameLabel.setBounds(383, 59, 61, 23);
		contentPane.add(firstnameLabel);
		
		JLabel surnameLabel = new JLabel("نام خانوادگی");
		surnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		surnameLabel.setBounds(163, 59, 73, 23);
		contentPane.add(surnameLabel);
		
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
		backButton.setBounds(6, 243, 81, 29);
		contentPane.add(backButton);
		
		JButton reviewMedicalRecordsButton = new JButton("مشاهده سوابق جسمانی");
		reviewMedicalRecordsButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
//							DoctorConsultPatientPage frame = new DoctorConsultPatientPage(patient);
//							frame.setVisible(true);
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
		reviewMedicalRecordsButton.setBounds(57, 113, 150, 30);
		contentPane.add(reviewMedicalRecordsButton);
		
		
		MouseListener mouseListener = new MouseAdapter() {
		      @SuppressWarnings({ "deprecation", "rawtypes" })
			public void mouseClicked(MouseEvent mouseEvent) {
		        JList theList = (JList) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2) {
		          int index = theList.locationToIndex(mouseEvent.getPoint());
		          if (index >= 0) {
		            Object o = theList.getModel().getElementAt(index);
		            
		            //----------------- Add doctor selection page here
		            /**
		             * TODO deep shit here!
		             * TODO should be another page; not PatientSicknessDetailPage
		             */
		            EventQueue.invokeLater(new Runnable() {
		    			public void run() {
		    				try {
		    					DoctorViewIllnessOfPatientPage frame = new DoctorViewIllnessOfPatientPage(patient,(Illness) o);
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
		    
		    JScrollPane scrollPane = new JScrollPane();
			contentPane.add(scrollPane);
			

		scrollPane.setBounds(219, 117, 205, 140);

		
		
		Set<Illness> illnessesList = patient.getIllnesses();
		JList<Object> jList = new JList<Object>(illnessesList.toArray());
		
		scrollPane.setViewportView(jList);
		jList.addMouseListener(mouseListener);
	    jList.setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(jList);
		
		
		
		JLabel illnessesListLabel = new JLabel("لیست بیماری‌ها");
		illnessesListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		illnessesListLabel.setBounds(333, 89, 91, 16);
		contentPane.add(illnessesListLabel);
		
		JButton referToSpecialistButton = new JButton("ارجاع به متخصص");
		referToSpecialistButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorReferPatientToProfessionalDoctorPage frame = new DoctorReferPatientToProfessionalDoctorPage(patient);
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
		referToSpecialistButton.setBounds(57, 215, 150, 30);
		contentPane.add(referToSpecialistButton);
		
		JButton prescribeButton = new JButton("تجویز نسخه");
		prescribeButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorPrescribePage frame = new DoctorPrescribePage(patient);
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
		prescribeButton.setBounds(57, 163, 150, 30);
		contentPane.add(prescribeButton);
		
		JButton addIllnessButton = new JButton("ثبت بیماری");
		addIllnessButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorAddIlnessToPatientPage frame = new DoctorAddIlnessToPatientPage(patient);
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
		addIllnessButton.setBounds(57, 188, 150, 30);
		contentPane.add(addIllnessButton);
		
		firstnameTextField = new JTextField(patient.getFirstname());
		firstnameTextField.setEditable(false);
		firstnameTextField.setBounds(248, 58, 150, 23);
		contentPane.add(firstnameTextField);
		
		surnameTextField = new JTextField(patient.getSurname());
		surnameTextField.setEditable(false);
		surnameTextField.setBounds(6, 58, 150, 23);
		contentPane.add(surnameTextField);
		
		JButton addBodyStateButton = new JButton("ثبت وضیعت جسمانی");
		addBodyStateButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorAddBodyStateToPatientPage frame = new DoctorAddBodyStateToPatientPage(patient);
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
		addBodyStateButton.setBounds(57, 138, 148, 30);
		contentPane.add(addBodyStateButton);
	}
}
