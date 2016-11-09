package de.vogella.jfreechart.swing.pie;

public class PieMain 
{
         public static void main(String[] args) {
                PieChart demo = new PieChart("Comparison", "Which operating system are you using?");
                demo.pack();
                demo.setVisible(true);
            }
}