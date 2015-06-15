package gui.drugstore;

import gui.LoginPage;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;

import medical.management.IMedicalEntityManager;
import users.Drugstore;
import users.management.DrugstoreUserManager;
import utility.Prescription;

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
	private JTextField patientIDTextField;
	private JTextField illnessIDTextField;

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

		/**
		 * TODO fix loggedInDoctor's name
		 */
		JLabel titleLabel = new JLabel("داروخانه " + ((Drugstore) new DrugstoreUserManager().getLoggedInUser()).getFirstname() + " خوش آمدید!");
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
				
				new DrugstoreUserManager().setLoggedInUser(null);
				
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
		showProfileButton.setBounds(211, 243, 117, 29);
		contentPane.add(showProfileButton);

		MouseListener mouseListener = new MouseAdapter() {
			@SuppressWarnings({ "deprecation", "rawtypes" })
			public void mouseClicked(MouseEvent mouseEvent) {

				JList theList = (JList) mouseEvent.getSource();				
				
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);

						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									DrugstoreShowPrescriptionPage frame = new DrugstoreShowPrescriptionPage((Prescription) o);
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
				}
			}
		};


		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 73, 419, 100);
		contentPane.add(scrollPane);

		List<Object> prescriptionsList = IMedicalEntityManager.getAllPrescriptions();		
		JList<Object> jlist = new JList<Object>(prescriptionsList.toArray());

		scrollPane.setViewportView(jlist);
		jlist.addMouseListener(mouseListener);
		jlist.setBackground(Color.WHITE);
		

		JLabel patientsList = new JLabel("لیست نسخه‌ها:");
		patientsList.setHorizontalAlignment(SwingConstants.CENTER);
		patientsList.setBounds(308, 45, 117, 16);
		contentPane.add(patientsList);
		
		JLabel searchTitleLabel = new JLabel("جست و جو در لیست");
		searchTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchTitleLabel.setBounds(311, 185, 114, 16);
		contentPane.add(searchTitleLabel);

		JLabel patientIDLabel = new JLabel("شناسه بیمار");
		patientIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		patientIDLabel.setBounds(352, 215, 73, 16);
		contentPane.add(patientIDLabel);

		JLabel illnessLabel = new JLabel("شناسه بیماری");
		illnessLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		illnessLabel.setBounds(143, 215, 99, 16);
		contentPane.add(illnessLabel);

		patientIDTextField = new JTextField();
		patientIDTextField.setColumns(10);
		patientIDTextField.setBounds(61, 209, 108, 28);
		contentPane.add(patientIDTextField);

		illnessIDTextField = new JTextField();
		illnessIDTextField.setColumns(10);
		illnessIDTextField.setBounds(254, 209, 108, 28);
		contentPane.add(illnessIDTextField);

		JButton searchButton = new JButton("جست و جو");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ArrayList<Prescription> searchedList = new ArrayList<Prescription>();
	    		for(int i=0; i<prescriptionsList.size(); i++) {
					/*
					 * this one seems complicated but it is simple: there is a logical equivalence between p=>q and ¬p∨q 
					 * note that p is "textField is not empty" and q is "what textField contains is a part of search criteria"
					 * TODO extract method for this one
					 */
	    			if( ( patientIDTextField.getText().equals("") || ((Prescription)prescriptionsList.get(i)).getID().getPatientID() == (Integer.parseInt(patientIDTextField.getText())) )
	    					&& ( illnessIDTextField.getText().equals("") || ((Prescription)prescriptionsList.get(i)).getID().getIllnessID() == (Integer.parseInt(illnessIDTextField.getText())) )
	    					)
	    					searchedList.add((Prescription)prescriptionsList.get(i));
	    		}
	    		
	    		JList<Object> jList = new JList<Object>(searchedList.toArray());
	    		/*
	    		 * if there is no search criteria, display all items
	    		 */
	    		if( patientIDTextField.getText().equals("") && illnessIDTextField.getText().equals("") )
	    			jList = new JList<Object>(prescriptionsList.toArray());
	    		
	    		
	    		scrollPane.setViewportView(jList);
	    		jList.addMouseListener(mouseListener);
	    		jList.setBackground(Color.WHITE);
	    		scrollPane.repaint();
				
				
			
			}
		});
		searchButton.setBounds(117, 243, 99, 29);
		contentPane.add(searchButton);
		
	    
	}
}
