package barCharts;

import javax.swing.JFrame;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.File;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList; 

public class BarChart extends JFrame 
{

   private static final long serialVersionUID = 1L;

   public BarChart(int[] intArray, int index, String applicationTitle, String chartTitle) throws IOException 
   {
        super(applicationTitle);

        // based on the dataset we create the chart
        JFreeChart barChart = ChartFactory.createBarChart(chartTitle, "Category", "Score", createDataset(intArray),PlotOrientation.VERTICAL, true, true, false);

        // Adding chart into a chart panel
        ChartPanel chartPanel = new ChartPanel(barChart);
      
        // settind default size
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 270));
      
        // add to contentPane
        setContentPane(chartPanel);
        
        // save iteration to image
        ChartUtilities.saveChartAsPNG(new File("Iteration" + index + ".png"), barChart, 600, 400);
        
    }
  
   private CategoryDataset createDataset(int[] intArray) 
   {                
         // Create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i=0; i< intArray.length ; i++)
        {
               String unique = (i + "Value");
               dataset.addValue(intArray[i],"Array Values",unique );
               System.out.println(i + " numbers so far.  Number is : " + intArray[i]);
        }     
        
        System.out.println("End of chart class");
        return dataset;     
     
   }
      
     
 }
