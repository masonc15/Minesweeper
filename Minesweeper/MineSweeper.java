   import java.awt.*;
   import java.awt.event.*;
   import java.util.Scanner;
   import javax.swing.*;
    public class MineSweeper extends JFrame implements ActionListener, MouseListener{
      static int numberMines = 1;
      int permanent[][];
      String tmp;
      boolean found = false;
      int row;
      int column;
      int guesses[][];
      JButton button[][];
      int[][] mines;
      boolean allmines;
      static int height = 2;
      static int width = 2;
      int changeinX[] = {-1, 0, 1, -1, 1, -1, 0, 1};
      int changeinY[] = {-1, -1, -1, 0, 0, 1, 1, 1};
      double starttime;
      double endtime;
       public MineSweeper(){
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         permanent = new int[height][width];
         boolean allmines = false;
         guesses = new int [height+2][width+2];
         mines = new int[height+2][width+2];
         button = new JButton [height][width];
         setLayout(new GridLayout(height,width));
      	//establishes number of mines and flags for each grid
         for (int y = 0;y<width+2;y++){
            mines[0][y] = 3;
            mines[height+1][y] = 3;
            guesses[0][y] = 3;
            guesses[height+1][y] = 3;
         }
         for (int x = 0;x<height+2;x++){
            mines[x][0] = 3;
            mines[x][width+1] = 3;
            guesses[x][0] = 3;
            guesses[x][width+1] = 3;
         }
         do {
            int check = 0;
            for (int y = 1;y<width+1;y++){
               for (int x = 1;x<height+1;x++){
                  mines[x][y] = 0;
                  guesses[x][y] = 0;
               }
            }
            for (int x = 0;x<numberMines;x++){
               mines [(int) (Math.random()*(height)+1)][(int) (Math.random()*(width)+1)] = 1;
            }
            for (int x = 0;x<height;x++){
               for (int y = 0;y<width;y++){
                  if (mines[x+1][y+1] == 1){
                     check++;
                  }
               }}
            if (check == numberMines){
               allmines = true;
            }}while (allmines == false);
      		//adds question mark to every blank space
         for (int y = 0;y<width;y++){
            for (int x = 0;x<height;x++){
               if ((mines[x+1][y+1] == 0) || (mines[x+1][y+1] == 1)){
                  permanent[x][y] = perimetercheck(x,y);
               }
               button[x][y] = new JButton("?");
               button[x][y].addActionListener(this);
               button[x][y].addMouseListener(this);
               add(button[x][y]);
               button[x][y].setEnabled(true);
            }//end inner for
         }//end for
         pack();
         setVisible(true);
         for (int y = 0;y<width+2;y++){
            for (int x = 0;x<height+2;x++){
            //System.out.print(mines[x][y]);
            }
            System.out.println("");}
         starttime = System.nanoTime();
      }//end constructor Mine()
   
       public void actionPerformed(ActionEvent e){
       
         found =  false;
         JButton current = (JButton)e.getSource();  //adds ActionListener to each button
         for (int y = 0;y<width;y++){
            for (int x = 0;x<height;x++){
               JButton t = button[x][y];
               if(t == current){
                  row=x;column=y; found =true;
               }
            }//end inner for
         }//end for
         if(!found) {
            System.out.println("didn't find the button, there was an error "); System.exit(-1);
         }
         Component lost = null;
         if (button[row][column].getBackground() == Color.orange){  //displays color if flagged
            return;
         }
         else if (mines[row+1][column+1] == 1){
            JOptionPane.showMessageDialog(lost, "You set off a Mine!!!!."); //displays lose message
            System.exit(0);
         } 
         else {
            tmp = Integer.toString(permanent[row][column]);
            if (permanent[row][column] == 0){
               tmp = " ";
            }
            button[row][column].setText(tmp);
            button[row][column].setEnabled(false);
            checkIfOver();
            if (permanent[row][column] == 0){
               scan(row, column);
               checkIfOver();
            }}}
       
       public void checkIfOver(){
         int check= 0;
         for (int y = 0; y<width;y++){
            for (int x = 0;x<height;x++){
               if (button[x][y].isEnabled()){
                  check++;
               }
            }}
         if (check == numberMines){
            endtime = System.nanoTime();
            Component lost = null;
            JOptionPane.showMessageDialog(lost, "Congratulations you won!!! It took you "+(int)((endtime-starttime)/1000000000)+" seconds!");
            System.exit(0);
         }
      }
   
       public void scan(int x, int y){
         for (int a = 0;a<8;a++){
            if (mines[x+1+changeinX[a]][y+1+changeinY[a]] == 3){
            
            } 
            else if ((permanent[x+changeinX[a]][y+changeinY[a]] == 0) && (mines[x+1+changeinX[a]][y+1+changeinY[a]] == 0) && (guesses[x+changeinX[a]+1][y+changeinY[a]+1] == 0)){
               if (button[x+changeinX[a]][y+changeinY[a]].isEnabled()){
                  button[x+changeinX[a]][y+changeinY[a]].setText(" ");
                  button[x+changeinX[a]][y+changeinY[a]].setEnabled(false);
                  scan(x+changeinX[a], y+changeinY[a]);
               }
            } 
            else if ((permanent[x+changeinX[a]][y+changeinY[a]] != 0) && (mines[x+1+changeinX[a]][y+1+changeinY[a]] == 0)  && (guesses[x+changeinX[a]+1][y+changeinY[a]+1] == 0)){
               tmp = new Integer(permanent[x+changeinX[a]][y+changeinY[a]]).toString();
               button[x+changeinX[a]][y+changeinY[a]].setText(Integer.toString(permanent[x+changeinX[a]][y+changeinY[a]]));
               button[x+changeinX[a]][y+changeinY[a]].setEnabled(false);    
            }
         }}
       
       public int perimetercheck(int a, int y){
         int minecount = 0;
         for (int x = 0;x<8;x++){
            if (mines[a+changeinX[x]+1][y+changeinY[x]+1] == 1){
               minecount++;
            }
         }
         return minecount;
      }
   
       public void windowIconified(WindowEvent e){
      
      }
   
       public static void main(String[] args){
         int difficulty;
         Scanner kbd = new Scanner(System.in);
      	
      	//switch statement to determine width and height of window and number of mines on the grid
         System.out.println("Enter number of difficulty level: \n 1. \t Easy\n 2. \t Medium\n 3. \t Hard\n 4. \t Extreme");
         int choice = kbd.nextInt();
         switch(choice){
            case 1:	numberMines = 10;
              height= 8;
              width= 8;
               break;
            case 2:	numberMines = 40;
              height= 16;
              width= 16;
               break;
            case 3:	numberMines = 72;
              height= 16;
              width= 30;
               break;
            case 4:	numberMines = 135;
              height= 30;
              width= 30;
               break;
         
         }
      	
         new MineSweeper();
      }
   
   
       public void mouseClicked(MouseEvent e) {
               
      }
   
   
   
       @Override
                public void mouseEntered(MouseEvent arg0) {
                        
                       
      }
   
       @Override
                public void mouseExited(MouseEvent arg0) {
                        
                       
      }
   
       @Override
                public void mousePressed(MouseEvent e) {
         if (e.getButton() == MouseEvent.BUTTON3) {
            found =  false;
            Object current = e.getSource();
            for (int y = 0;y<width;y++){
               for (int x = 0;x<height;x++){
                  JButton t = button[x][y];
                  if(t == current){
                     row=x;column=y; found =true;
                  }
               }//end inner for
            }//end for
            if(!found) {
               System.out.println("didn't find the button, there was an error "); System.exit(-1);
            }
            if ((guesses[row+1][column+1] == 0) && (button[row][column].isEnabled())){
               button[row][column].setText("x");
               guesses[row+1][column+1] = 1;
               button[row][column].setBackground(Color.orange);
            } 
            else if (guesses[row+1][column+1] == 1){
            
               button[row][column].setText("?");
               guesses[row+1][column+1] = 0;
               button[row][column].setBackground(null);
            }}
      }
   
       @Override
                public void mouseReleased(MouseEvent arg0) {
                        
                       
      }
   
   
   }