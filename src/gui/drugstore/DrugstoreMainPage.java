package gui.drugstore;

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

/**
 * 
 * @author siavashnazari
 *
 */
public class DrugstoreMainPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8745059488246082135L;

	private JPanel contentPane;

	String prescriptionsList[] = { "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->", "<--> <----->" };

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrugstoreMainPage frame = new DrugstoreMainPage();
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
	public DrugstoreMainPage() {
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
							DrugstoreProfilePage frame = new DrugstoreProfilePage();
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
	    					DrugstoreShowPrescriptionPage frame = new DrugstoreShowPrescriptionPage();
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
	    
	    JList jlist = new JList(prescriptionsList);
	    scrollPane.setViewportView(jlist);
	    jlist.addMouseListener(mouseListener);
	    //	    contentPane.add(scrollPane1);
	    jlist.setBackground(Color.WHITE);
	    
	    JLabel label_1 = new JLabel("\u0644\u06CC\u0633\u062A \u0646\u0633\u062E\u0647\u200C\u0647\u0627\u06CC \u062F\u0631 \u0627\u0646\u062A\u0638\u0627\u0631:");
	    label_1.setHorizontalAlignment(SwingConstants.CENTER);
	    label_1.setBounds(272, 45, 153, 16);
	    contentPane.add(label_1);
	    
	}
}
