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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField textField_1;
	private JTextField textField_2;

	String sicknessList[] = { "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->" };

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

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
		
		JLabel label = new JLabel("\u0633\u0648\u0627\u0628\u0642 \u067E\u0632\u0634\u06A9\u06CC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(300, 6, 144, 29);
		contentPane.add(label);

		
		//--------------------------------------------------------------
		//--------------------------------------------------------------

		
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
		    					PatientSicknessDetailPage frame = new PatientSicknessDetailPage(new PatientMedicalHistoryPage());
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
		    scrollPane.setBounds(225, 49, 205, 190);
		    contentPane.add(scrollPane);
		
		scrollPane.setBounds(225, 87, 205, 98);

		
		JList jlist = new JList(sicknessList);
	    scrollPane.setViewportView(jlist);
	    jlist.addMouseListener(mouseListener);
	    jlist.setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(jlist);
		
		//--------------------------------------------------------------
		//--------------------------------------------------------------

		
		JLabel label_2 = new JLabel("\u062C\u0633\u062A \u0648 \u062C\u0648 \u062F\u0631 \u0644\u06CC\u0633\u062A");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(99, 59, 114, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u062A\u0627\u0631\u06CC\u062E \u0634\u0631\u0648\u0639");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(140, 87, 73, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u062A\u0627\u0631\u06CC\u062E \u067E\u0627\u06CC\u0627\u0646");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(150, 115, 61, 16);
		contentPane.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(32, 81, 108, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(32, 109, 108, 28);
		contentPane.add(textField_2);
		
		JButton button = new JButton("\u062C\u0633\u062A \u0648 \u062C\u0648");
		button.setBounds(32, 156, 99, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		button_1.addActionListener(new ActionListener() {
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
		button_1.setBounds(6, 243, 96, 29);
		contentPane.add(button_1);
		
		JLabel label_5 = new JLabel("\u0644\u06CC\u0633\u062A \u0628\u06CC\u0645\u0627\u0631\u06CC\u200C\u0647\u0627");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(339, 59, 91, 16);
		contentPane.add(label_5);
		
		JButton btnNewButton = new JButton("\u0645\u0634\u0627\u0647\u062F\u0647 \u0633\u0648\u0627\u0628\u0642 \u062C\u0633\u0645\u0627\u0646\u06CC");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PatientHealthHistoryPage frame = new PatientHealthHistoryPage();
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
		btnNewButton.setBounds(259, 197, 171, 29);
		contentPane.add(btnNewButton);
		
		JButton button_2 = new JButton("\u0645\u0634\u0627\u0647\u062F\u0647 \u0641\u0639\u0627\u0644\u06CC\u062A \u0628\u062F\u0646\u06CC");
		button_2.addActionListener(new ActionListener() {
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
		button_2.setBounds(259, 226, 171, 29);
		contentPane.add(button_2);
	}

}
