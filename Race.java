/**
* Name: Grace Bui
* NetID: bhg27
*
* Execution: java Race
*
* Write a program Race.java that visualizes a race 
* between Yale (yay!) and Harvard (boo!).
* Determine which side wins and draw a victory board.
*/

public class Race {    
   public static void main(String[] args) {
      boolean yaleWins = false;       // has Yale won the race?
      boolean harvardWins = false;    // has Harvard won the race?
   
      // the width of 1 pixel in window coordinates,
      // assuming you do NOT call PennDraw.setXscale()
      double ONE_PIXEL = 1.0 / 512;  
   
      // TODO - define any variables you need here
      double startx1 = 100.0 / 512;
      double starty1 = 50.0 / 512;
      double startx2 = startx1;
      double starty2 = 465.0 / 512;
      double endx1 = 465.0 / 512;
      double endy1 = starty1;
      double endy2 = 465.0 / 512;
      double harvardx0 = startx1 - 0.1;
      double yalex0 = startx1 - 0.1;
      double hx0 =  ONE_PIXEL + 0.5 * Math.random();
      double yx0 =  ONE_PIXEL + 0.505 * Math.random();    
   
      // TODO - set the pennant locations before the starting line
      PennDraw.setPenRadius(0.003);
      PennDraw.setPenColor();
      PennDraw.line(startx1, starty1, startx1, starty2); //Draw starting line
      PennDraw.setPenColor(PennDraw.RED);
      PennDraw.line(endx1, endy1, endx1, endy2); // Draw finish line
      
      //set Harvard and Yale pennant locaitons
      PennDraw.picture(harvardx0, 0.3 , "harvard.gif", 60, 0);  
      PennDraw.picture(yalex0, 0.8, "yale.gif", 60, 0); 
      
         
      
      // enable animation at 10 frames/second
      // TODO - you may change the frame rate to be any speed you like
      PennDraw.enableAnimation(0.5);
   
      while (!yaleWins && !harvardWins) {
         /* TODO the following
         * 1. clear the screen
         * 2. draw the Yale and Harvard pennants
         * 3. draw the start line
         * 4. draw the finish line
         * 5. based on current positions, determine if anyone has won. 
         * 6. determine whether the Yale pennant position changes 
         * 7. determine whether the Harvard pennant position changes 
         */
         if (harvardx0 < endx1) { harvardx0 = harvardx0 + hx0; }
         if (yalex0 < endx1) { yalex0 = yalex0 + yx0; }
         
         //set Harvard & Yale pennant locations
         PennDraw.clear(PennDraw.WHITE);
         PennDraw.picture(harvardx0, 0.3 , "harvard.gif", 60, 0); 
         PennDraw.picture(yalex0, 0.8, "yale.gif", 60, 0);  
         PennDraw.setPenRadius(0.003);
         PennDraw.setPenColor();
         PennDraw.line(startx1, starty1, startx1, starty2); //Draw starting line
         PennDraw.setPenColor(PennDraw.RED);
         PennDraw.line(endx1, endy1, endx1, endy2); // Draw finish line
            
          
         PennDraw.advance();
         
         yaleWins = yalex0 >= harvardx0 && yalex0 >= endx1;
         harvardWins = harvardx0 > yalex0 && harvardx0 >= endx1;
         
         if (harvardx0 > yalex0 && harvardx0 >= endx1) {
            PennDraw.setPenColor();
            PennDraw.text(0.5, 0.5, "Congratulations to Harvard", 0);
         }
         
         else if (yalex0 >= harvardx0 && yalex0 >= endx1) {
            PennDraw.text(0.5, 0.5, "Congratulations to Yale", 0);
         } 
            
      }
   
      PennDraw.disableAnimation(); // the race is over so turn off animation
      // TODO - draw text containing a victory message in the sketch
     
   }
}
