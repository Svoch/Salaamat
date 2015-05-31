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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author siavashnazari
 *
 */
public class DoctorViewAllPatiensPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6362230250525505691L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	String patientList[] = { "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->" };

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public DoctorViewAllPatiensPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u0644\u06CC\u0633\u062A \u0628\u06CC\u0645\u0627\u0631\u0627\u0646");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(300, 6, 144, 29);
		contentPane.add(label);
		
	   
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
	    					DoctorOtherPatientViewPage frame = new DoctorOtherPatientViewPage();
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
	    
	    JList jlist = new JList(patientList);
	    scrollPane.setViewportView(jlist);
	    jlist.addMouseListener(mouseListener);
	    //	    contentPane.add(scrollPane1);
	    jlist.setBackground(Color.WHITE);
	    
		
		
		JLabel label_1 = new JLabel("\u062C\u0633\u062A \u0648 \u062C\u0648 \u062F\u0631 \u0644\u06CC\u0633\u062A");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_1.setBounds(54, 13, 144, 29);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u0646\u0627\u0645");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(152, 59, 61, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(140, 87, 73, 16);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(32, 49, 108, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(32, 81, 108, 28);
		contentPane.add(textField_1);
		
		JButton button = new JButton("\u062C\u0633\u062A \u0648 \u062C\u0648");
		button.setBounds(99, 243, 99, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
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
		button_1.setBounds(6, 243, 96, 29);
		contentPane.add(button_1);
	}

}
