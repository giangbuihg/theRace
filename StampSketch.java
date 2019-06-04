/*
 Name: Grace Bui
* NetID: bhg27
*
* Execution: java StampsSketch
* 
* Write an interactive drawing
 */
public class StampSketch {
   public static void main(String[] args) {
      // is this the first time through the animation loop?
      boolean firstTime = true;
         
      //PennDraw.enableAnimation(2);
      while (true) {
          // redraw background both when it's the first time through loop and
          // when a key is pressed
         if (firstTime == true || PennDraw.hasNextKeyTyped()) {
              // TODO - draw a random background/
              // some aspect of the background must involve a loop.
            PennDraw.setPenColor(0, 195, 249); // draw a blue sky
            PennDraw.filledRectangle(0.5, 0.75, 0.5, 0.25);
            PennDraw.setPenColor(121, 130, 0); 
            PennDraw.filledRectangle(0.5, 0.25, 0.5, 0.25); // draw green grass
            
            //draw floating cloud 
            for (int i = 2; i < 10; i++) {
               PennDraw.setPenColor(216, 237, 242); 
               double x0 = 0.01 + Math.random();
               double y0 = 0.5 + 0.5 * Math.random();
               double z0 = 0.1 * Math.random();
               
               x0 = x0 + Math.random();
               PennDraw.filledArc(x0, y0, z0, 0, 180);    
            }
           
            for (int i = 1; i < 10; i++) {   //Draw rocks on grass
               double x0 = 0.01 + Math.random();
               double y0 = 0.01 + 0.5 * Math.random();
               double z0 = 0.01 + 0.01 * Math.random();
               PennDraw.setPenColor(0, 0, 0);
               PennDraw.circle(x0, y0, z0);
            }   
          
            if (PennDraw.hasNextKeyTyped()) {
               PennDraw.nextKeyTyped();
            }
         
         }           
                         
         firstTime = false;
         
        
          // if the mouse is clicked
         if (PennDraw.mousePressed()) {
          // get the coordinates of the mouse cursor
            double x = PennDraw.mouseX();
            double y = PennDraw.mouseY();
            
         // TODO - check which region the mouse click was in
         // draw a scaled shape
            if (y > 0.5) {
               PennDraw.picture(x, y , "bird.png", 250 * (x + y), 250 * (x + y));
            } 
            if (y < 0.5) {
               PennDraw.picture(x, y , "bird.png", 250 * (x - y), 250 * (x - y));
            }  
         }
      
       
      }
   }
}