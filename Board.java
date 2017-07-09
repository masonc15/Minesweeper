import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.*;

public class Board extends JFrame
{
   private static final long serialVersionUID = 1L;
	// private Minesweeper mine;
// 	private Cell[][] cells;

   public Board()
   {
   	Board board = new Board();
      JButton reset = new JButton("Minesweeper");
   	add(board, BorderLayout.CENTER);
      add(reset, BorderLayout.SOUTH);
   
   	// reset.addActionListener(new Actions(this));
   
      // board.setTitle("Minesweeper");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      pack();
      setVisible(true);
   
   
      setPreferredSize(new Dimension(8, 8));
   }

   public void paintComponent(Graphics g)
   {
   	// cells = mine.getCells();
   
      for (int i = 0; i < 8; i++)
      {
         for (int j = 0; j < 8; j++)
         {
            g.setColor(Color.BLACK);
            g.drawRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
         }
      }
   }
   
   public static void main (String[] args)
	{
		
      
      JButton reset;
   
      Board board = new Board();
      reset = new JButton("Reset");
   
      
	}
}