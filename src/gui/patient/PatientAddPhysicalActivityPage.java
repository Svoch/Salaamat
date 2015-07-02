package gui.patient;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import medical.PhysicalActivity;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import users.Patient;
import users.management.PatientUserManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.List;

/**
 * 
 * @author siavashnazari
 *
 */
public class PatientAddPhysicalActivityPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2551536715568427095L;
	private JPanel contentPane;
	private JTextField dateTextField;
	private JTextField measurementTextField;
	private ChartPanel chartPanel ;


	/**
	 * Create the frame.
	 */
	public PatientAddPhysicalActivityPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("ثبت فعالیت بدنی");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(300, 6, 144, 29);
		contentPane.add(titleLabel);
		
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
		backButton.setBounds(6, 290, 117, 29);
		contentPane.add(backButton);

		
		
		//-----------------------------------------------------
		
		List<PhysicalActivity> physicalActivities = ( (Patient) (new PatientUserManager().getLoggedInUser()) ).getPhysicalActivities();
		
		//------------------------------------------------------
		
		XYSeries series = new XYSeries("Data");
		
		for(PhysicalActivity p : physicalActivities) 
	        series.add(p.getDate(),p.getMeasurement());
	
		XYSeriesCollection data = new XYSeriesCollection(series);
		
		JFreeChart chart = ChartFactory.createXYLineChart(
				"",
				"", 
	            "", 
	            data,
	            PlotOrientation.VERTICAL,
	            false,
	            false,
	            false
	        );
		
        chart.setBackgroundPaint(Color.WHITE);

		chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(6, 158, 438, 113);
		chartPanel.setBackground(Color.WHITE);
		contentPane.add(chartPanel);
		
		JLabel typeLabel = new JLabel("نوع فعالیت");
		typeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		typeLabel.setBounds(302, 47, 130, 23);
		contentPane.add(typeLabel);
		
		JLabel dateLabel = new JLabel("تاریخ فعالیت");
		dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dateLabel.setBounds(302, 81, 130, 23);
		contentPane.add(dateLabel);
		
		JLabel measurementLabel = new JLabel("میزان کالری مصرفی");
		measurementLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		measurementLabel.setBounds(302, 115, 130, 23);
		contentPane.add(measurementLabel);
		
		String[] choices = { "پیاده‌روی","دو", "کوهنوردی","دوچرخه‌سواری"};
		JComboBox<String> typeMenu = new JComboBox<String>(choices);
		typeMenu.setBounds(180, 44, 134, 28);
		contentPane.add(typeMenu);
		
		dateTextField = new JTextField();
		dateTextField.setBounds(180, 78, 134, 28);
		contentPane.add(dateTextField);
		dateTextField.setColumns(10);
		
		measurementTextField = new JTextField();
		measurementTextField.setColumns(10);
		measurementTextField.setBounds(180, 112, 134, 28);
		contentPane.add(measurementTextField);
		
		JButton submitButton = new JButton("ثبت");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(typeMenu.getSelectedIndex());
			
				if(!dateTextField.getText().equals("") && !measurementTextField.getText().equals("")) {
					
					((Patient) (new PatientUserManager().getLoggedInUser())).addPhysicalActivity(typeMenu.getSelectedIndex(), Integer.parseInt( measurementTextField.getText() ),Integer.parseInt( dateTextField.getText() ));
					
					JOptionPane.showMessageDialog(null, "فعالیت بدنی مورد نظر با موفقیت ثبت شد.");
					
				}
				else
					JOptionPane.showMessageDialog(null, "لطفاً اطلاعات فعالیت بدنی را کامل وارد کنید.");
			}
		});
		submitButton.setBounds(121, 290, 117, 29);
		contentPane.add(submitButton);
	}
}
