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

import users.Patient;
import users.login.IUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * 
 * @author siavashnazari
 *
 */
public class DoctorViewAllPatiensPage extends JFrame {

	private static final long serialVersionUID = -6362230250525505691L;
	private JPanel contentPane;
	private JTextField firstnameTextField;
	private JTextField surnameTextField;

	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DoctorViewAllPatiensPage frame = new DoctorViewAllPatiensPage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
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
		
		JLabel titleLabel = new JLabel("\u0644\u06CC\u0633\u062A \u0628\u06CC\u0645\u0627\u0631\u0627\u0646");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(300, 6, 144, 29);
		contentPane.add(titleLabel);
		
	   
	    MouseListener mouseListener = new MouseAdapter() {
	      @SuppressWarnings({ "deprecation", "rawtypes" })
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
	    					DoctorViewOtherPatientsPage frame = new DoctorViewOtherPatientsPage();
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
	    
	    
		
	    ArrayList<Object> allPatientsList = new ArrayList<Object>( IUserManager.getAllPatientsList() );	    
	    JList<Object> jlist = new JList<Object>(allPatientsList.toArray());
	    
	    scrollPane.setViewportView(jlist);
	    jlist.addMouseListener(mouseListener);
	    jlist.setBackground(Color.WHITE);
	    
		
		
		JLabel searchTitleLabel = new JLabel("جست و جو در لیست");
		searchTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchTitleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		searchTitleLabel.setBounds(54, 13, 144, 29);
		contentPane.add(searchTitleLabel);
		
		JLabel firstnameLabel = new JLabel("نام");
		firstnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstnameLabel.setBounds(152, 59, 61, 16);
		contentPane.add(firstnameLabel);
		
		JLabel surnameLabel = new JLabel("نام خانوادگی");
		surnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		surnameLabel.setBounds(140, 87, 73, 16);
		contentPane.add(surnameLabel);
		
		firstnameTextField = new JTextField();
		firstnameTextField.setColumns(10);
		firstnameTextField.setBounds(32, 49, 108, 28);
		contentPane.add(firstnameTextField);
		
		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(32, 81, 108, 28);
		contentPane.add(surnameTextField);
		
		JButton searchButton = new JButton("جست و جو");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> searchedList = new ArrayList<Object>();
	    		for(int i=0; i<allPatientsList.size(); i++) {
					/*
					 * this one seems complicated but it is simple: there is a logical equivalence between p=>q and ¬p∨q 
					 * note that p is "textField is not empty" and q is "what textField contains is a part of search criteria"
					 * TODO extract method for this one
					 */
	    			if( ( firstnameTextField.getText().equals("") || ((Patient)allPatientsList.get(i)).getFirstname().contains(firstnameTextField.getText()) )
	    					&& ( surnameTextField.getText().equals("") || ((Patient)allPatientsList.get(i)).getSurname().contains(surnameTextField.getText()) )
	    					)
	    					searchedList.add((Patient)allPatientsList.get(i));
	    		}
	    		
	    		JList<Object> jList = new JList<Object>(searchedList.toArray());
	    		/*
	    		 * if there is no search criteria, display all items
	    		 */
	    		if( firstnameTextField.getText().equals("") && surnameTextField.getText().equals("")  )
	    			jList = new JList<Object>(allPatientsList.toArray());
	    		
	    		
	    		scrollPane.setViewportView(jList);
	    		jList.addMouseListener(mouseListener);
	    		jList.setBackground(Color.WHITE);
	    		scrollPane.repaint();
			
			}
		});
		searchButton.setBounds(99, 243, 99, 29);
		contentPane.add(searchButton);
		
		JButton backButton = new JButton("بازگشت");
		backButton.addActionListener(new ActionListener() {
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
		backButton.setBounds(6, 243, 96, 29);
		contentPane.add(backButton);
	}

}
