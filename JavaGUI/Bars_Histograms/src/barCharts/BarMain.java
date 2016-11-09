package barCharts;

import de.vogella.jfreechart.swing.pie.PieChart;

public class BarMain
{
         public static void main(String[] args) {
                BarChart demo = new BarChart("Bar Chart Window", "Bar chart, bitches!");
                demo.pack();
                demo.setVisible(true);
            }
}
