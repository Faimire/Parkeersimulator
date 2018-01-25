package view;

import java.awt.Color;
import java.awt.Container;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import main.Simulator;

 
public class Piechart {
   

   
   public static PieDataset createDataset(int i) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "non-subscription " + String.valueOf(SimulatorView.red) , new Integer(SimulatorView.red));  
      dataset.setValue( "subsription " + String.valueOf(SimulatorView.blue) , new Integer(SimulatorView.blue) );
      dataset.setValue( "open-space " + String.valueOf(SimulatorView.white), new Integer(SimulatorView.white + i));
      return dataset;         
   }
   
   public static JFreeChart createChart( PieDataset dataset, String name ) {
      JFreeChart chart = ChartFactory.createRingChart(    
         name,   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);


      return chart;
   }
   
   public static JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset(200), "demopanel" );  
      return new ChartPanel( chart ); 
   }


}
