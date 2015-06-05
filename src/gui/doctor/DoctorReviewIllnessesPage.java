package gui.doctor;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import medical.Illness;
import medical.management.IMedicalEntityManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DoctorReviewIllnessesPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2081498198957337115L;
	private JPanel contentPane;
	private JTextField illnessTitleTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorReviewIllnessesPage frame = new DoctorReviewIllnessesPage();
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
	public DoctorReviewIllnessesPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton backButton = new JButton("خروج");
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
		backButton.setBounds(6, 243, 117, 29);
		contentPane.add(backButton);

		JButton addIllnessButton = new JButton("افزودن بیماری جدید");
		addIllnessButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorAddNewIllnessPage frame = new DoctorAddNewIllnessPage();
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
		addIllnessButton.setBounds(115, 243, 117, 29);
		contentPane.add(addIllnessButton);


		MouseListener mouseListener = new MouseAdapter() {
			@SuppressWarnings({ "deprecation", "rawtypes" })
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);

						/**
						 * TODO fix here
						 */
						
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									DoctorViewIllnessDetailPage frame = new DoctorViewIllnessDetailPage((Illness) o);
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


		ArrayList<Object> allIllnessesList = new ArrayList<Object>( IMedicalEntityManager.getAllIllnesses() );	    
		JList<Object> jlist = new JList<Object>(allIllnessesList.toArray());


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 73, 222, 115);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(jlist);
		jlist.addMouseListener(mouseListener);
		jlist.setBackground(Color.WHITE);


		JLabel titleLabel = new JLabel("بررسی بیماری‌ها");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(333, 6, 111, 29);
		contentPane.add(titleLabel);

		JLabel listTitleLabel = new JLabel(" لیست بیماری‌هایی که تاکنون ثبت شده‌اند:");
		listTitleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		listTitleLabel.setBounds(217, 47, 213, 23);
		contentPane.add(listTitleLabel);

		JLabel searchTitleLabel = new JLabel("جست و جو در لیست");
		searchTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchTitleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		searchTitleLabel.setBounds(37, 73, 144, 29);
		contentPane.add(searchTitleLabel);

		JLabel illnessTitleLabel = new JLabel("نام بیماری");
		illnessTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		illnessTitleLabel.setBounds(135, 112, 61, 23);
		contentPane.add(illnessTitleLabel);

		illnessTitleTextField = new JTextField();
		illnessTitleTextField.setColumns(10);
		illnessTitleTextField.setBounds(15, 109, 108, 28);
		contentPane.add(illnessTitleTextField);

		JButton searchButton = new JButton("جست و جو");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ArrayList<Object> searchedList = new ArrayList<Object>();
	    		for(int i=0; i<allIllnessesList.size(); i++) {
					/*
					 * this one seems complicated but it is simple: there is a logical equivalence between p=>q and ¬p∨q 
					 * note that p is "textField is not empty" and q is "what textField contains is a part of search criteria"
					 * TODO extract method for this one
					 */
	    			if( ( illnessTitleTextField.getText().equals("") || ((Illness)allIllnessesList.get(i)).getTitle().contains(illnessTitleTextField.getText()) )
	    					)
	    					searchedList.add((Illness)allIllnessesList.get(i));
	    		}
	    		
	    		JList<Object> jList = new JList<Object>(searchedList.toArray());
	    		/*
	    		 * if there is no search criteria, display all items
	    		 */
	    		if( illnessTitleTextField.getText().equals("") )
	    			jList = new JList<Object>(allIllnessesList.toArray());
	    		
	    		
	    		scrollPane.setViewportView(jList);
	    		jList.addMouseListener(mouseListener);
	    		jList.setBackground(Color.WHITE);
	    		scrollPane.repaint();
			
			}
			
		});
		searchButton.setBounds(79, 147, 117, 29);
		contentPane.add(searchButton);
	}
}
