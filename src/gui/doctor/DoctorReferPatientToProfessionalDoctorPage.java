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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import users.Doctor;
import users.Patient;
import users.management.DoctorUserManager;
import users.management.IUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author siavashnazari
 *
 */
public class DoctorReferPatientToProfessionalDoctorPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8822966327019592098L;
	private JPanel contentPane;

	private JTextField firstnameTextField;
	private JTextField surnameTextField;
	private JTextField specialtyTextField;

	private Patient patient;
	private JTextField additionalInformationTextField;
	private JTextField selectedDoctorTextField;
	
	private Doctor selectedDoctor = null;

	
	/**
	 * Create the frame.
	 * @param patient 
	 */
	public DoctorReferPatientToProfessionalDoctorPage(Patient p) {
		
		this.patient = p;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("لیست پزشکان متخصص");
		titleLabel.setBounds(300, 6, 144, 29);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(titleLabel);

	    
	    MouseListener mouseListener = new MouseAdapter() {
	    @SuppressWarnings({ "rawtypes" })
		public void mouseClicked(MouseEvent mouseEvent) {
	        JList theList = (JList) mouseEvent.getSource();
	        
	        /*
	         * this part is just for debugging :D
	         */
	        if (mouseEvent.getClickCount() == 1 ) {
	        	int index = theList.locationToIndex(mouseEvent.getPoint());
	        	if(index >=0) {
	        		Object o = theList.getModel().getElementAt(index);
	        		selectedDoctor = (Doctor) o;
	        		selectedDoctorTextField.setText(((Doctor) o).toString());
	        	}
	        }
	        
	      }
	    };
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(225, 49, 205, 93);
	    contentPane.add(scrollPane);
	    

	    /**
	     * TODO specialist doctors list
	     */
		List<Object> doctorsList = IUserManager.getAllDoctorsList();
		doctorsList.remove(((Doctor) new DoctorUserManager().getLoggedInUser()));
		//-------------------------------------------------------------
		//-------------------------------------------------------------
		
		JList<Object> jList = new JList<Object>(doctorsList.toArray());
		scrollPane.setViewportView(jList);
		jList.addMouseListener(mouseListener);
		jList.setBackground(Color.WHITE);
		
	    
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
	    
	    JLabel specialtyLabel = new JLabel("تخصص");
	    specialtyLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    specialtyLabel.setBounds(152, 115, 61, 16);
	    contentPane.add(specialtyLabel);
	    
	    firstnameTextField = new JTextField();
	    firstnameTextField.setColumns(10);
	    firstnameTextField.setBounds(32, 49, 108, 28);
	    contentPane.add(firstnameTextField);
	    
	    surnameTextField = new JTextField();
	    surnameTextField.setColumns(10);
	    surnameTextField.setBounds(32, 81, 108, 28);
	    contentPane.add(surnameTextField);
	    
	    specialtyTextField = new JTextField();
	    specialtyTextField.setColumns(10);
	    specialtyTextField.setBounds(32, 109, 108, 28);
	    contentPane.add(specialtyTextField);
	    
	    JButton button = new JButton("جست و جو");
	    button.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent arg0) {
	    	
	    		ArrayList<Doctor> searchedList = new ArrayList<Doctor>();
	    		for(int i=0; i<doctorsList.size(); i++) {
					System.err.println(((Doctor)doctorsList.get(i)).getSpecialty());
					/*
					 * this one seems complicated but it is simple: there is a logical equivalence between p=>q and ¬p∨q 
					 * note that p is "textField is not empty" and q is "what textField contains is a part of search criteria"
					 * TODO extract method for this one
					 */
	    			if( ( firstnameTextField.getText().equals("") || ((Doctor)doctorsList.get(i)).getFirstname().contains(firstnameTextField.getText()) )
	    					&& ( surnameTextField.getText().equals("") || ((Doctor)doctorsList.get(i)).getSurname().contains(surnameTextField.getText()) )
	    					&& ( specialtyTextField.getText().equals("") || ((Doctor)doctorsList.get(i)).getSpecialty().contains(specialtyTextField.getText()) )
	    					)
	    					searchedList.add((Doctor)doctorsList.get(i));
	    		}
	    		
	    		JList<Object> jList = new JList<Object>(searchedList.toArray());
	    		/*
	    		 * if there is no search criteria, display all items
	    		 */
	    		if( firstnameTextField.getText().equals("") && surnameTextField.getText().equals("") && specialtyTextField.getText().equals("") )
	    			jList = new JList<Object>(doctorsList.toArray());
	    		
	    		
	    		scrollPane.setViewportView(jList);
	    		jList.addMouseListener(mouseListener);
	    		jList.setBackground(Color.WHITE);
	    		scrollPane.repaint();
	    	}
	    });
	    button.setBounds(32, 149, 99, 29);
	    contentPane.add(button);
	    
	    JButton btnNewButton = new JButton("بازگشت");
	    btnNewButton.addActionListener(new ActionListener() {
	    	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
	    	
	    		EventQueue.invokeLater(new Runnable() {
	    			public void run() {
	    				try {
	    					DoctorViewPatientPage frame = new DoctorViewPatientPage(patient);
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
	    btnNewButton.setBounds(6, 243, 96, 29);
	    contentPane.add(btnNewButton);
	    
	    JButton referButton = new JButton("ارجاع");
	    referButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		if(selectedDoctor!=null) {
	    			patient.consult(selectedDoctor, ((Doctor) (new DoctorUserManager().getLoggedInUser())).toString() + " to " + selectedDoctor.toString() + " / message: " + additionalInformationTextField.getText(), 1);
	    			JOptionPane.showMessageDialog(null, "ارجاع بیمار با موفقیت انجام شد.");
	    		}
	    		else
	    			JOptionPane.showMessageDialog(null, "لطفاً یک پزشک متخصص را انتخاب کنید.");
	    	
	    	}
	    });
	    referButton.setBounds(99, 243, 99, 29);
	    contentPane.add(referButton);
	    
	    JLabel additionalInformationLabel = new JLabel("توضیحات");
	    additionalInformationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	    additionalInformationLabel.setBounds(374, 190, 56, 16);
	    contentPane.add(additionalInformationLabel);
	    
	    additionalInformationTextField = new JTextField();
	    additionalInformationTextField.setBounds(32, 184, 337, 47);
	    contentPane.add(additionalInformationTextField);
	    additionalInformationTextField.setColumns(10);
	    
	    JLabel selectedDoctorLabel = new JLabel("پزشک انتخاب شده");
	    selectedDoctorLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    selectedDoctorLabel.setBounds(347, 154, 88, 16);
	    contentPane.add(selectedDoctorLabel);
	    
	    selectedDoctorTextField = new JTextField();
	    selectedDoctorTextField.setEditable(false);
	    selectedDoctorTextField.setColumns(10);
	    selectedDoctorTextField.setBounds(136, 148, 205, 28);
	    contentPane.add(selectedDoctorTextField);

	}
}
