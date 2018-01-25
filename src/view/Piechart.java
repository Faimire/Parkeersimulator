package view;

import java.awt.Container;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import main.Simulator;

 
public class Piechart {
   

   
   public static PieDataset createDataset( ) {
	  Random random = new Random();
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "non-subscription" , new Integer(SimulatorView.red));  
      dataset.setValue( "subsription" , new Integer(SimulatorView.blue) );
      return dataset;         
   }
   
   public static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Queue",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }


}
