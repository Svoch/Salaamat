package gui.doctor;

import gui.patient.PatientSicknessDetailPage;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author siavashnazari
 *
 */
public class DoctorPatientViewPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5743315232541890339L;

	private JPanel contentPane;

	String sicknessList[] = { "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->" };
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorPatientViewPage frame = new DoctorPatientViewPage();
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
	public DoctorPatientViewPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u0645\u0634\u062E\u0635\u0627\u062A \u0628\u06CC\u0645\u0627\u0631\n");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(333, 6, 111, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u0646\u0627\u0645");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(383, 66, 61, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(219, 66, 73, 16);
		contentPane.add(label_2);
		
		JButton button = new JButton("\u0628\u0627\u0632\u06A9\u0634\u062A");
		button.addActionListener(new ActionListener() {
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
		button.setBounds(6, 243, 81, 29);
		contentPane.add(button);
		
		JLabel label_4 = new JLabel("<-->");
		label_4.setBounds(333, 66, 61, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("<-->");
		label_5.setBounds(146, 66, 61, 16);
		contentPane.add(label_5);
		
		JButton button_1 = new JButton("\u0627\u0631\u062A\u0628\u0627\u0637 \u0628\u0627 \u0628\u06CC\u0645\u0627\u0631");
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorConsultPatientPage frame = new DoctorConsultPatientPage();
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
		button_1.setBounds(52, 114, 138, 29);
		contentPane.add(button_1);
		
		
		MouseListener mouseListener = new MouseAdapter() {
		      @SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent mouseEvent) {
		        JList theList = (JList) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2) {
		          int index = theList.locationToIndex(mouseEvent.getPoint());
		          if (index >= 0) {
		            Object o = theList.getModel().getElementAt(index);
		            
		            //----------------- Add doctor selection page here
		            
		            EventQueue.invokeLater(new Runnable() {
		    			public void run() {
		    				try {
		    					PatientSicknessDetailPage frame = new PatientSicknessDetailPage(new DoctorPatientViewPage());
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
//			scrollPane.setBounds(219, 223, 205, 180);
			contentPane.add(scrollPane);
			

		scrollPane.setBounds(219, 117, 205, 98);

		
		JList jlist = new JList(sicknessList);
	    scrollPane.setViewportView(jlist);
	    jlist.addMouseListener(mouseListener);
	    jlist.setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(jlist);
		
		
		
		JLabel label_3 = new JLabel("\u0644\u06CC\u0633\u062A \u0628\u06CC\u0645\u0627\u0631\u06CC\u200C\u0647\u0627");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(333, 89, 91, 16);
		contentPane.add(label_3);
		
		JButton button_2 = new JButton("\u0627\u0631\u062C\u0627\u0639 \u0628\u0647 \u0645\u062A\u062E\u0635\u0635");
		button_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorReferPatientToProfessionalDoctorPage frame = new DoctorReferPatientToProfessionalDoctorPage();
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
		button_2.setBounds(52, 141, 138, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u062A\u062C\u0648\u06CC\u0632 \u0646\u0633\u062E\u0647");
		button_3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorPrescribePage frame = new DoctorPrescribePage();
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
		button_3.setBounds(52, 167, 138, 29);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u062B\u0628\u062A \u0648\u0636\u06CC\u0639\u062A \u062C\u0633\u0645\u0627\u0646\u06CC");
		button_4.setBounds(52, 194, 138, 29);
		contentPane.add(button_4);
	}

}
