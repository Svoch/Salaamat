package gui.patient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import medical.PhysicalActivity;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import users.Patient;
import users.management.PatientUserManager;

/**
 * 
 * @author siavashnazari
 *
 */
public class PatientPhysicalActivityHistoryPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5759659620428862006L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PatientPhysicalActivityHistoryPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("مشاهده فعالیت بدنی");
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
		backButton.setBounds(6, 243, 117, 29);
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
				"تاریخ", 
	            "میزان فعالیت", 
	            data,
	            PlotOrientation.VERTICAL,
	            false,
	            false,
	            false
	        );
		
		ChartPanel panel = new ChartPanel(chart);
		panel.setBounds(6, 39, 438, 192);
		contentPane.add(panel);
		
	}
}
