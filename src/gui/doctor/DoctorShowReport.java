package gui.doctor;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * 
 * @author naderi
 *
 */

public class DoctorShowReport extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2551536715568427095L;
	private JPanel contentPane;
	private ChartPanel chartPanel ;


	/**
	 * Create the frame.
	 */
	public DoctorShowReport(int[] xdata, int[] ydata) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("نمودار گزارش تجمیعی");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		titleLabel.setBounds(400, 6, 144, 29);
		contentPane.add(titleLabel);
		
		JButton backButton = new JButton("بازگشت");
		backButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoctorReportPage frame = new DoctorReportPage();
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
		backButton.setBounds(6, 395, 117, 29);
		contentPane.add(backButton);

		
		XYSeries series = new XYSeries("Data");
		
		for (int i=0; i<xdata.length; i++) 
	        series.add(xdata[i], ydata[i]);
	
		XYSeriesCollection data = new XYSeriesCollection(series);
		
		JFreeChart chart = ChartFactory.createXYLineChart(
				"",
				"شماره ماه", 
	            "تعداد بیمار", 
	            data,
	            PlotOrientation.VERTICAL,
	            false,
	            false,
	            false
	        );
		
        chart.setBackgroundPaint(Color.WHITE);

		chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(6, 40, 538, 350);
		chartPanel.setBackground(Color.WHITE);
		contentPane.add(chartPanel);
		
	}
}