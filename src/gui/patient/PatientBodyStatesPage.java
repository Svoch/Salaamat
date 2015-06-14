package gui.patient;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import medical.BodyState;
import users.Patient;
import users.management.PatientUserManager;

/**
 * 
 * @author siavashnazari
 *
 */
public class PatientBodyStatesPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7210371391273046133L;
	private JPanel contentPane;
	private JTextField startDateTextField;
	private JTextField endDateTextField;
	private JTextField selectedBodyStateTextField;

	

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PatientBodyStatesPage frame = new PatientBodyStatesPage();
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
	public PatientBodyStatesPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titleLabel = new JLabel("سوابق وضیعت‌های جسمانی");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(262, 6, 182, 29);
		contentPane.add(titleLabel);


		//--------------------------------------------------------------
		//--------------------------------------------------------------


		MouseListener mouseListener = new MouseAdapter() {
			@SuppressWarnings({ "rawtypes" })
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 1) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);
						selectedBodyStateTextField.setText(((BodyState) o).toString());
					}
				}
			}
		};

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 49, 205, 190);
		contentPane.add(scrollPane);
		scrollPane.setBounds(225, 87, 205, 98);
		
		List<BodyState> bodyStatesList = ( (Patient) (new PatientUserManager().getLoggedInUser()) ).getBodyStates();
		JList<Object> jList = new JList<Object>(bodyStatesList.toArray());

		scrollPane.setViewportView(jList);
		jList.addMouseListener(mouseListener);
		jList.setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(jList);

		JLabel searchTitleLabel = new JLabel("جست و جو در لیست");
		searchTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchTitleLabel.setBounds(99, 59, 114, 16);
		contentPane.add(searchTitleLabel);

		JLabel startDateLabel = new JLabel("تاریخ شروع");
		startDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		startDateLabel.setBounds(140, 87, 73, 16);
		contentPane.add(startDateLabel);

		JLabel finishDateLabel = new JLabel("تاریخ پایان");
		finishDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		finishDateLabel.setBounds(150, 115, 61, 16);
		contentPane.add(finishDateLabel);

		startDateTextField = new JTextField();
		startDateTextField.setColumns(10);
		startDateTextField.setBounds(32, 81, 108, 28);
		contentPane.add(startDateTextField);

		endDateTextField = new JTextField();
		endDateTextField.setColumns(10);
		endDateTextField.setBounds(32, 109, 108, 28);
		contentPane.add(endDateTextField);

		JButton searchButton = new JButton("جست و جو");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ArrayList<BodyState> searchedList = new ArrayList<BodyState>();
	    		for(int i=0; i<bodyStatesList.size(); i++) {
					System.err.println(((BodyState)bodyStatesList.get(i)).getDate());
					/*
					 * this one seems complicated but it is simple: there is a logical equivalence between p=>q and ¬p∨q 
					 * note that p is "textField is not empty" and q is "what textField contains is a part of search criteria"
					 * TODO extract method for this one
					 */
	    			if( ( startDateTextField.getText().equals("") || ((BodyState)bodyStatesList.get(i)).getDate() >= (Integer.parseInt(startDateTextField.getText())) )
	    					&& ( endDateTextField.getText().equals("") || ((BodyState)bodyStatesList.get(i)).getDate() <= (Integer.parseInt(endDateTextField.getText())) )
	    					)
	    					searchedList.add((BodyState)bodyStatesList.get(i));
	    		}
	    		
	    		JList<Object> jList = new JList<Object>(searchedList.toArray());
	    		/*
	    		 * if there is no search criteria, display all items
	    		 */
	    		if( startDateTextField.getText().equals("") && endDateTextField.getText().equals("") )
	    			jList = new JList<Object>(bodyStatesList.toArray());
	    		
	    		
	    		scrollPane.setViewportView(jList);
	    		jList.addMouseListener(mouseListener);
	    		jList.setBackground(Color.WHITE);
	    		scrollPane.repaint();
				
				
			
			}
		});
		searchButton.setBounds(32, 156, 99, 29);
		contentPane.add(searchButton);

		JButton backButton = new JButton("بازگشت");
		backButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

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

				contentPane.removeAll();
				contentPane.repaint();

				hide();

			}
		});
		backButton.setBounds(6, 243, 96, 29);
		contentPane.add(backButton);

		JLabel bodyStatesListLabel = new JLabel("لیست سوابق وضیعت‌های جسمانی:");
		bodyStatesListLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		bodyStatesListLabel.setBounds(225, 59, 205, 16);
		contentPane.add(bodyStatesListLabel);
		
		selectedBodyStateTextField = new JTextField();
		selectedBodyStateTextField.setHorizontalAlignment(SwingConstants.CENTER);
		selectedBodyStateTextField.setEditable(false);
		selectedBodyStateTextField.setColumns(10);
		selectedBodyStateTextField.setBounds(32, 197, 398, 28);
		contentPane.add(selectedBodyStateTextField);

	}
}
