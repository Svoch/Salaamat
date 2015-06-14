package gui.doctor;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import users.Doctor;
import users.Patient;
import users.management.DoctorUserManager;
import users.management.IUserManager;
import utility.Consultation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * 
 * @author siavashnazari
 *
 */
public class DoctorConsultPatientPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5616938066891921049L;
	private JPanel contentPane;
	private JTextField questionTextField;
	private JTextField answerTextField;
	
	private Patient patient;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DoctorConsultPatientPage frame = new DoctorConsultPatientPage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param p 
	 */
	public DoctorConsultPatientPage() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("مشاوره با بیمار");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(300, 6, 144, 29);
		contentPane.add(titleLabel);
		
		JLabel questionLabel = new JLabel("سؤال بیمار");
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setBounds(383, 114, 61, 21);
		contentPane.add(questionLabel);
		
		questionTextField = new JTextField();
		questionTextField.setEditable(false);
		questionTextField.setColumns(10);
		questionTextField.setBounds(6, 114, 365, 61);
		contentPane.add(questionTextField);
		
		JLabel answerLabel = new JLabel("پاسخ پزشک");
		answerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		answerLabel.setBounds(383, 178, 61, 21);
		contentPane.add(answerLabel);
		
		answerTextField = new JTextField();
		answerTextField.setColumns(10);
		answerTextField.setBounds(6, 177, 365, 61);
		contentPane.add(answerTextField);


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
	        		patient = (Patient) o;

	        		Consultation consultation = (Consultation) IUserManager.getConsultation(((Doctor) new DoctorUserManager().getLoggedInUser()).getID() , patient.getID());
	        		if(consultation!=null) {
//	        			if(consultation.getQuestion()!=null)
	        				questionTextField.setText(consultation.getQuestion());
//	        			if(consultation.getAnswer()!=null)
	        				answerTextField.setText(consultation.getAnswer());
	        		}
	        		else {
        				questionTextField.setText("");
        				answerTextField.setText("");
	        		}
	        	}
	        }
	        
	      }
	    };
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(125, 51, 205, 61);
	    contentPane.add(scrollPane);
	    
		List<Object> patientsList = ((Doctor) new DoctorUserManager().getLoggedInUser()).getPatientsWithQuestionsList();
	    JList<Object> jList = new JList<Object>(patientsList.toArray());
	    scrollPane.setViewportView(jList);
	    jList.addMouseListener(mouseListener);
	    jList.setBackground(Color.WHITE);
	    
		
		JButton backButton = new JButton("بازگشت");
		backButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
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
		
		JButton submitButton = new JButton("ثبت");
		submitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				if(patient!=null) {
					if(!questionTextField.getText().equals("")) {
						if(!answerTextField.getText().equals("")) {
							((Doctor) (new DoctorUserManager().getLoggedInUser())).asnwerConsultation(patient,questionTextField.getText(),answerTextField.getText()); 
							JOptionPane.showMessageDialog(null, "پاسخ شما با موفقیت ثبت شد.");
						} else
							JOptionPane.showMessageDialog(null, "لطفاً پاسخ خود را وارد کنید.");
					}
					else
						JOptionPane.showMessageDialog(null, "میشه بگی به کدوم سؤال داری جواب می‌دی؟!");
				}
				else
					JOptionPane.showMessageDialog(null, "لطفاً بیماری را انتخاب کنید.");
			}
		});
		submitButton.setBounds(121, 243, 117, 29);
		contentPane.add(submitButton);
		
		JLabel patientsListLabel = new JLabel("لیست بیماران شما:");
		patientsListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		patientsListLabel.setBounds(342, 47, 102, 21);
		contentPane.add(patientsListLabel);

	    }
	    
	    
}
