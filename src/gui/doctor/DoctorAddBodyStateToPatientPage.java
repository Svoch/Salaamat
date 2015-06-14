package gui.doctor;

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

import medical.BodyState;
import medical.management.IMedicalEntityManager;
import users.Patient;

public class DoctorAddBodyStateToPatientPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1148626219242560634L;


	private JPanel contentPane;
	private JTextField bodyStateTypeTextField;
	private JTextField submittingDateTextField;

	
	private Patient patient;
	private JLabel measurementLabel;
	private JTextField measurementTextField;
	

	/**
	 * Create the frame.
	 */
	public DoctorAddBodyStateToPatientPage(Patient p) {
		
		this.patient = p;
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titleLabel = new JLabel("ثبت وضیعت جسمانی برای بیمار");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(248, 6, 196, 29);
		contentPane.add(titleLabel);


		JButton backButton = new JButton("بازگشت");
		backButton.addActionListener(new ActionListener() {
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
		backButton.setBounds(6, 243, 96, 29);
		contentPane.add(backButton);

		JLabel bodyStateTypeLabel = new JLabel("وضیعت جسمانی انتخاب شده:");
		bodyStateTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bodyStateTypeLabel.setBounds(295, 126, 149, 26);
		contentPane.add(bodyStateTypeLabel);

		JLabel submittingDate = new JLabel("زمان ثبت وضیعت جسمانی:");
		submittingDate.setHorizontalAlignment(SwingConstants.CENTER);
		submittingDate.setBounds(305, 164, 139, 26);
		contentPane.add(submittingDate);

		bodyStateTypeTextField = new JTextField();
		bodyStateTypeTextField.setEditable(false);
		bodyStateTypeTextField.setColumns(10);
		bodyStateTypeTextField.setBounds(72, 125, 222, 28);
		contentPane.add(bodyStateTypeTextField);

		submittingDateTextField = new JTextField();
		submittingDateTextField.setColumns(10);
		submittingDateTextField.setBounds(186, 163, 108, 28);
		contentPane.add(submittingDateTextField);

		JButton submitButton = new JButton("ثبت");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * TODO check duplicate Illnesses
				 * TODO add diagnosis details
				 */

				BodyState bodyState = new BodyState();

				if(!bodyStateTypeTextField.getText().equals("") && !measurementTextField.getText().equals("") && !submittingDateTextField.getText().equals("")) {
					bodyState.setBodyStateID( bodyStateTypeTextField.getText() , patient.getID() , Integer.parseInt(submittingDateTextField.getText()) );
					bodyState.setMeasurement(Integer.parseInt(measurementTextField.getText()));
					IMedicalEntityManager.addBodyState(bodyState);
					JOptionPane.showMessageDialog(null, "وضیعت جسمانی برای بیمار با موفقیت ثبت شد.");
				}
				else
					JOptionPane.showMessageDialog(null, "لطفاً تمامی اطلاعات خواسته شده را وارد کنید.");

				
				
				
			}
		});
		submitButton.setBounds(101, 243, 99, 29);
		contentPane.add(submitButton);

		MouseListener mouseListener = new MouseAdapter() {
			@SuppressWarnings("rawtypes")
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 1) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);
						bodyStateTypeTextField.setText(o.toString());
					}
				}
			}
		};


		ArrayList<Object> getAllBodyStateTypes = new ArrayList<Object>( BodyState.getAllBodyStateTypes() );	    


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 47, 222, 76);
		contentPane.add(scrollPane);
		JList<Object> jlist = new JList<Object>(getAllBodyStateTypes.toArray());
		scrollPane.setViewportView(jlist);
		jlist.addMouseListener(mouseListener);
		jlist.setBackground(Color.WHITE);
		
		JLabel bodyStateTypesListLabel = new JLabel(" لیست وضیعت‌های جسمانی:");
		bodyStateTypesListLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		bodyStateTypesListLabel.setBounds(231, 47, 213, 23);
		contentPane.add(bodyStateTypesListLabel);
		
		measurementLabel = new JLabel("میزان وضیعت جسمانی:");
		measurementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		measurementLabel.setBounds(305, 202, 139, 26);
		contentPane.add(measurementLabel);
		
		measurementTextField = new JTextField();
		measurementTextField.setColumns(10);
		measurementTextField.setBounds(186, 202, 108, 28);
		contentPane.add(measurementTextField);

	}

}
