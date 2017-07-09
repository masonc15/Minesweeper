   import javax.swing.*;
   import java.util.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.io.*;

    public class mineSweeper2 implements ActionListener{
    
      GridLayout g;
      JFrame f;
      JPanel p1=new JPanel();
      JPanel p2=new JPanel();
      JPanel p3=new JPanel();
   //changed from static to non-static
      String [][]code=new String [9][9];
      JButton[][] myButtons;
		
   
       public static void main(String[]args){
         mineSweeper2 myB=new mineSweeper2();
         myB.draw();
      
      
      }
       public void draw()
      {
         f=new JFrame();
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.getContentPane().setSize(800,400);
      // 	p1.setPreferredSize(new Dimension(162,20));
      // 		p1.setMaximumSize(new Dimension(162,20));
      // 		f.getContentPane().add(BorderLayout.NORTH,p1);
      // 		p2.setBackground(Color.lightGray);
      // 		p2.setPreferredSize(new Dimension(162,45));
      // 		p2.setMaximumSize(new Dimension(162, 45));
      // 		f.getContentPane().add(BorderLayout.CENTER, p2);
         p3.setPreferredSize(new Dimension(600,300));
         p3.setMaximumSize(new Dimension(600,300));
         f.getContentPane().add(BorderLayout.CENTER,p3);
         p3.setLayout((g=new GridLayout(9,9)));
         myButtons=new JButton[9][9];
         for(int j=0;j<9;j++)
            for(int i=0;i<9;i++)
            {
               myButtons[j][i]=new JButton();
               p3.add(myButtons[j][i]);
               myButtons[j][i].addActionListener(this);
					myButtons[j][i].add
					
            }
         f.setSize(170,260);
         f.setVisible(true);
      }
   //changed from static to non-static
   
       @Override
       public void actionPerformed(ActionEvent e) {
      //loop through each button
         for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
            //see which one was clicked
               if(e.getSource()==myButtons[i][j]){
               //set color and disable the button so it cannot be clicked.
               
                  myButtons[i][j].setBackground(Color.DARK_GRAY);
                  myButtons[i][j].setEnabled(false);
               /*create method validate to check i and j within the code array.
                
                */
               }
            
            
            }
         }
      }
   }


