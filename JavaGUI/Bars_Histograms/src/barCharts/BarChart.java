package barCharts;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.util.ArrayList; 

public class BarChart extends JFrame 
{

   private static final long serialVersionUID = 1L;

   public BarChart(String applicationTitle, String chartTitle) 
   {
        super(applicationTitle);

        // based on the dataset we create the chart
        JFreeChart pieChart = ChartFactory.createBarChart(chartTitle, "Category", "Score", createDataset(),PlotOrientation.VERTICAL, true, true, false);

        // Adding chart into a chart panel
        ChartPanel chartPanel = new ChartPanel(pieChart);
      
        // settind default size
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 270));
      
        // add to contentPane
        setContentPane(chartPanel);
    }
  
   private CategoryDataset createDataset() 
   {
     
      // row keys...
      final String firefox = "Poops";
    

      // column keys...
      final String speed = "Speed";
   
      
      // This section loads the array.txt file, and updates textArea.
				
        File f = new File("src/barCharts/array.txt");
       System.out.println("Path : " + f.getAbsolutePath());

        // Initialize inputFile
        Scanner inputFile = null;
        try 
        {
                inputFile = new Scanner(f);
        } 
        catch (FileNotFoundException e1) 
        {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        }

     // Preferable to use ArrayList, no need to define array size in advance.
        ArrayList<Integer> array = new ArrayList<Integer>();


        // while loop to read file
        int Count = 0;
        while (inputFile.hasNext()) 
        {
          // find next line
          int token = inputFile.nextInt();
          array.add(token);
         
          System.out.print(token + " ");  

          // How many numbers are there.
          Count++; 
          
          System.out.println(Count + " numbers so far.  Number is : " + token);
        }

                
        inputFile.close();
        
        
         // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i=0; i< Count; i++)
        {
               String unique = (i + "Value");
               dataset.addValue(array.get(i),"Array Values",unique );
               System.out.println(i + " numbers so far.  Number is : " + array.get(i));
        }
        
        return dataset;
        
     
   }
      
     
 }
