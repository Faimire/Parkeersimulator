package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

public class Piechart extends ApplicationFrame{
	
	public Piechart( String title ) {
	      super( title ); 
	      setContentPane(createDemoPanel( ));
	   }
	
	public static PieDataset Data() {
	    DefaultPieDataset dataset = new DefaultPieDataset( );
	    dataset.setValue("abonnement", new Double(5));
	    dataset.setValue("no abonnement", new Double(5));
		return dataset;
	}
	
	  private static JFreeChart createChart( PieDataset dataset ) {
	      JFreeChart chart = ChartFactory.createPieChart(      
	         "garage",   // chart title 
	         dataset,          // data    
	         true,             // include legend   
	         true, 
	         false);

	      return chart;
	   }
	  
	  public static JPanel createDemoPanel( ) {
	      JFreeChart chart = createChart(Data( ) );  
	      return new ChartPanel( chart ); 
	   }
	  
	  

}
