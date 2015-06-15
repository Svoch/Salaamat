package gui.patient;

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
import users.management.IUserManager;
import users.management.PatientUserManager;
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
public class PatientConsultDoctorPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8345842265778751599L;
	private JPanel contentPane;
	private JTextField questionTextField;
	private JTextField answerTextField;
	
	private Doctor doctor;


	/**
	 * Create the frame.
	 */
	public PatientConsultDoctorPage() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("مشاوره با دکتر");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(300, 6, 144, 29);
		contentPane.add(titleLabel);
		
		JLabel questionLabel = new JLabel("سؤال بیمار");
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setBounds(383, 114, 61, 21);
		contentPane.add(questionLabel);
		
		questionTextField = new JTextField();
		questionTextField.setColumns(10);
		questionTextField.setBounds(6, 114, 365, 61);
		contentPane.add(questionTextField);
		
		JLabel answerLabel = new JLabel("پاسخ پزشک");
		answerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		answerLabel.setBounds(383, 178, 61, 21);
		contentPane.add(answerLabel);
		
		answerTextField = new JTextField();
		answerTextField.setEditable(false);
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
	        		doctor = (Doctor) o;

	        		Consultation consultation = (Consultation) IUserManager.getConsultation(doctor.getID(), ((Patient) new PatientUserManager().getLoggedInUser()).getID());
	        		if(consultation!=null) {
	        			if(consultation.getQuestion()!=null)
	        				questionTextField.setText(consultation.getQuestion());
	        			if(consultation.getAnswer()!=null)
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
	    
	    /**
	     * 
	     */
//		List<Object> doctorsList = IUserManager.getAllDoctorsList();
		List<Object> doctorsList = new PatientUserManager().getConsultingDoctorsList( ((Patient) new PatientUserManager().getLoggedInUser()) );
//		List<Object> doctorsList = consultList;
		
	    JList<Object> jList = new JList<Object>(doctorsList.toArray());
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
							PatientMainPage frame = new PatientMainPage();
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
			
				if(doctor!=null) {
					if(!questionTextField.getText().equals("")) {
						((Patient) (new PatientUserManager().getLoggedInUser())).consult(doctor,questionTextField.getText()); 
						JOptionPane.showMessageDialog(null, "سؤال شما با موفقیت ثبت شد.");
					}
					else
						JOptionPane.showMessageDialog(null, "لطفاً سؤال خود را وارد کنید.");
				}
				else
					JOptionPane.showMessageDialog(null, "لطفاً پزشکی را انتخاب کنید.");
			}
		});
		submitButton.setBounds(121, 243, 117, 29);
		contentPane.add(submitButton);
		
		JLabel doctorsListLabel = new JLabel("لیست پزشکان شما:");
		doctorsListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		doctorsListLabel.setBounds(342, 47, 102, 21);
		contentPane.add(doctorsListLabel);
	}

}
