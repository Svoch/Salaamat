package gui.admin;


import gui.LoginPage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import users.User;
import users.Patient;
import users.management.IUserManager;
import users.management.PatientUserManager;

public class adminMainPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 217516051013885368L;

	private JPanel contentPane;
	
	private JTextField firstnameTextField;
	private JTextField surnameTextField;

	private User selectedUser;
	private JTextField selectedUserTextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminMainPage frame = new adminMainPage();
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
	public adminMainPage() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titleLabel = new JLabel("مدیر سامانه، خوش آمدید!");
		titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		titleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		titleLabel.setBounds(181, 6, 263, 25);
		contentPane.add(titleLabel);

		JButton exitButton = new JButton("خروج");
		exitButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				/**
				 * TODO add "Are you sure?" message
				 */
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

		JButton confirmUserButton = new JButton("تأیید کاربر");
		confirmUserButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				if(selectedUser!=null) {
					selectedUser.setConfirmed(true);
					/**
					 * TODO
					 * 1) Does it need to be generalized for all Users?
					 * 2) It is a little bit hard-coded and... dirty, but I...
					 * 
					 */
					new PatientUserManager().update((Patient)selectedUser);
					JOptionPane.showMessageDialog(null, "کاربر انتخاب شده تأیید شد." );
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								adminMainPage frame = new adminMainPage();
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
				else
					JOptionPane.showMessageDialog(null, "لطفاً یک کاربر را انتخاب کنید.");
				
			}
		});
		confirmUserButton.setBounds(225, 243, 205, 29);
		contentPane.add(confirmUserButton);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 73, 205, 132);
		contentPane.add(scrollPane);

	    ArrayList<Object> allPatientsList = new ArrayList<Object>( IUserManager.getAllPatientsList() );	    
	    
	    for(int i=0; i<allPatientsList.size(); i++)
	    	if( ((Patient) allPatientsList.get(i)).getConfirmed() )
	    		allPatientsList.remove(i);
	    	

	    JList<Object> jlist = new JList<Object>(allPatientsList.toArray());


		MouseListener mouseListener = new MouseAdapter() {
			@SuppressWarnings("rawtypes")
			public void mouseClicked(MouseEvent mouseEvent) {

				JList theList = (JList) mouseEvent.getSource();				
				
				if (mouseEvent.getClickCount() == 1) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);
						selectedUser = (User) o;
						selectedUserTextField.setText(selectedUser.toString());
					
					}
				}
			}
		};

	    
		scrollPane.setViewportView(jlist);
		jlist.addMouseListener(mouseListener);
		jlist.setBackground(Color.WHITE);
		

		JLabel patientsList = new JLabel("لیست کاربران جدید سامانه:");
		patientsList.setHorizontalAlignment(SwingConstants.RIGHT);
		patientsList.setBounds(225, 45, 200, 16);
		contentPane.add(patientsList);

		JLabel searchTitleLabel = new JLabel("جست و جو در لیست");
		searchTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchTitleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		searchTitleLabel.setBounds(54, 43, 144, 29);
		contentPane.add(searchTitleLabel);
		
		JLabel firstnameLabel = new JLabel("نام");
		firstnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstnameLabel.setBounds(152, 81, 61, 21);
		contentPane.add(firstnameLabel);
		
		JLabel surnameLabel = new JLabel("نام خانوادگی");
		surnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		surnameLabel.setBounds(140, 114, 73, 22);
		contentPane.add(surnameLabel);
		
		firstnameTextField = new JTextField();
		firstnameTextField.setColumns(10);
		firstnameTextField.setBounds(32, 79, 108, 28);
		contentPane.add(firstnameTextField);
		
		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(32, 111, 108, 28);
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
	    			if( ( firstnameTextField.getText().equals("") || ((User)allPatientsList.get(i)).getFirstname().contains(firstnameTextField.getText()) )
	    					&& ( surnameTextField.getText().equals("") || ((User)allPatientsList.get(i)).getSurname().contains(surnameTextField.getText()) )
	    					)
	    					searchedList.add((User)allPatientsList.get(i));
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
		searchButton.setBounds(32, 161, 99, 29);
		contentPane.add(searchButton);
		
		JLabel selectedUserLabel = new JLabel("کاربر انتخاب شده:");
		selectedUserLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		selectedUserLabel.setBounds(336, 215, 94, 16);
		contentPane.add(selectedUserLabel);
		
		selectedUserTextField = new JTextField();
		selectedUserTextField.setEditable(false);
		selectedUserTextField.setBounds(225, 209, 113, 28);
		contentPane.add(selectedUserTextField);
		selectedUserTextField.setColumns(10);
		
		
		
	}
}
