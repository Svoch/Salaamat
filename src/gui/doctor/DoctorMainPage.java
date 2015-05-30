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

import javax.swing.JScrollPane;

public class DoctorMainPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 102L;

	private JPanel contentPane;

	String patientList[] = { "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->" };

	
	
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
		
		JLabel label = new JLabel("<----> \u062E\u0648\u0634 \u0622\u0645\u062F\u06CC\u062F!");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label.setBounds(181, 6, 263, 25);
		contentPane.add(label);
		
		JButton button = new JButton("\u062E\u0631\u0648\u062C");
		button.addActionListener(new ActionListener() {
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
		button.setBounds(6, 243, 117, 29);
		contentPane.add(button);
		
		JButton button_4 = new JButton("\u0645\u0634\u0627\u0647\u062F\u0647 \u067E\u0631\u0648\u0641\u0627\u06CC\u0644");
		button_4.addActionListener(new ActionListener() {
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
		button_4.setBounds(115, 243, 117, 29);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("\u0645\u0634\u0627\u0647\u062F\u0647 \u062F\u0631\u062E\u0648\u0627\u0633\u062A\u200C\u0647\u0627");
		button_5.addActionListener(new ActionListener() {
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
		button_5.setBounds(20, 97, 181, 46);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("\u0645\u0634\u0627\u0647\u062F\u0647 \u0644\u06CC\u0633\u062A \u0628\u06CC\u0645\u0627\u0631\u0627\u0646");
		button_6.addActionListener(new ActionListener() {
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
		button_6.setBounds(20, 142, 181, 46);
		contentPane.add(button_6);

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
	    					DoctorPatientViewPage frame = new DoctorPatientViewPage();
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
	    scrollPane.setBounds(225, 73, 205, 115);
	    contentPane.add(scrollPane);
	    
	    JList jlist = new JList(patientList);
	    scrollPane.setViewportView(jlist);
	    jlist.addMouseListener(mouseListener);
	    //	    contentPane.add(scrollPane1);
	    jlist.setBackground(Color.WHITE);
	    
	    JLabel label_1 = new JLabel("\u0644\u06CC\u0633\u062A \u0628\u06CC\u0645\u0627\u0631\u200C\u0647\u0627\u06CC \u0634\u0645\u0627:");
	    label_1.setHorizontalAlignment(SwingConstants.CENTER);
	    label_1.setBounds(308, 45, 117, 16);
	    contentPane.add(label_1);
	    
	}
}
