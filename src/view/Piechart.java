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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import main.Simulator;

public class Piechart {

	public static PieDataset createDataset(int i) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("non-subscription " + String.valueOf(SimulatorView.red), new Integer(SimulatorView.red));
		dataset.setValue("subsription " + String.valueOf(SimulatorView.blue), new Integer(SimulatorView.blue));
		dataset.setValue("open-space " + String.valueOf(SimulatorView.white), new Integer(SimulatorView.white + i));
		dataset.setValue("reserved " + String.valueOf(SimulatorView.yellow), new Integer(SimulatorView.yellow));
		return dataset;
	}

	
	public static PieDataset createQueueDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("non-subscription " + String.valueOf(SimulatorView.RedQueue),
				new Integer(SimulatorView.RedQueue));
		dataset.setValue("subscription " + String.valueOf(SimulatorView.BlueQueue),
				new Integer(SimulatorView.BlueQueue));
		dataset.setValue("reserved " + String.valueOf(SimulatorView.YellowQueue),
				new Integer(SimulatorView.YellowQueue));
		return dataset;
	}
	
	public static DefaultCategoryDataset createhistogram() {
		int length = SimulatorView.ArrivalHistogram.size();
		int position = 0;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < length; i++) {
			position++;
		}
		if (length != 0) {
			if (length <= 11) {
				for (int f = 0; f < position; f++) {
					dataset.addValue(SimulatorView.ArrivalHistogram.get(f), "Arrivals", "hour " + String.valueOf(f));
				}
			}
		}

		if (length != 0) {
			if (length > 11) {
				int lenght2 = SimulatorView.ArrivalHistogram.size();
				for (int f = lenght2 - 11; f < position; f++) {
					dataset.addValue(SimulatorView.ArrivalHistogram.get(f), "Arrivals", "hour " + String.valueOf(f));
				}
			}
		}

		else {
			dataset.setValue(0, "Arrivals", "hour " + String.valueOf(position));
		}

		return dataset;
	}
	
	public static DefaultCategoryDataset createProfitDay() {
		int length = SimulatorView.Profit.size();
		int position = 0;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < length; i++) {
			position++;
		}
		if (length != 0) {
			if (length <= 11) {
				for (int f = 0; f < position; f++) {
					dataset.addValue(SimulatorView.Profit.get(f), "Euros", "day " + String.valueOf(f));
				}
			}
		}

		if (length != 0) {
			if (length > 11) {
				int lenght2 = SimulatorView.Profit.size();
				for (int f = lenght2 - 11; f < position; f++) {
					dataset.addValue(SimulatorView.Profit.get(f), "Euros", "day " + String.valueOf(f));
				}
			}
		}

		else {
			dataset.setValue(0, "Euros", "day " + String.valueOf(position));
		}
		return dataset;

		
	}


	public static JFreeChart createChart(PieDataset dataset, String name) {
		JFreeChart chart = ChartFactory.createRingChart(name, // chart title
				dataset, // data
				true, // include legend
				true, false);

		return chart;
	}
	
	public static JFreeChart createLineChart(DefaultCategoryDataset dataset, String name) {
		JFreeChart chart = ChartFactory.createLineChart(name, "hours", "cars", dataset, PlotOrientation.VERTICAL,
		         true,true,false);
		return chart;
	}
	
	public static JFreeChart createLineProfitChart(DefaultCategoryDataset dataset, String name) {
		JFreeChart chart = ChartFactory.createLineChart(name, "days", "profit", dataset, PlotOrientation.VERTICAL,
		         true,true,false);
		return chart;
	}
	

	public static JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset(200), "demopanel");
		return new ChartPanel(chart);
	}

}
