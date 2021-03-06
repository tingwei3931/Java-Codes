/**Assignment 1 
*Name: Lim Ting Wei
*Student ID: 0188323
*
* Creates a program that draws a picture of
* full name and ID based on geometric alphabet.
*@author Lim Ting Wei
*
**/

//Arrays to store information of stars
//generated
int[] starX; //x-coordinate of stars
int[] starY; //y-coordinate of stars 
color[] starColor; //color of stars

//self-generate a pool of colors to randomly choose from
color [] colorPool = new color[13]; 

/**Processing's built-in draw function that infinitely
  *during program execution
**/
void draw(){
  frameRate(15);
  noFill();
  //draw first name using lines
  print_first_name();
  //draw middle name
  print_middle_name();
  //draw last name
  print_last_name();
  //draw student ID
  print_ID();
  draw_moon(450, 256, 98); //draw a moon using arcs
  draw_stars(30, 226);//draw star using pshape
  stroke(0);
  strokeWeight(0);
  for(int i=0; i<starX.length; i++){
    //this if else controls the probability of the stars twinkling(i.e. rate of twinkling).
    //By generating random numbers from 0 to 10, we can control the probability by changing the right operand.
    //Eg : if(random(10) < 1) has a 10% chance of changing colors since random() is uniformly distributed
    if(random(20) < 9){ 
      //randomize the colors that can be changed 
      starColor[i] = color((int)random(0, 255));
    }
    fill(starColor[i]);
    //instantiate the stars by drawing circles
    ellipse(starX[i], starY[i], 1.2, 1.2);
  }
}

/**sets up the size of canvas, generate colors, generate background
/*before calling draw()
**/
void setup(){
  size(512, 512);
  set_colors();
  stroke(0);
  smooth(8); //anti-aliase edges
  background(0, 0, 50);   //midnight blue color
  generateBGI(2500); //generate background image with 2500 stars
  strokeWeight(5);
  noFill();
}


/**method that draws first name using lines 
**/
void print_first_name(){
  //Letter L
  stroke(colorPool[(int)(Math.random()*13)]); //color the letters with the colors generated by Rng
  line(50, 50, 50, 150);
  line(50, 150, 75, 130);
  
  //Letter I
  stroke(colorPool[(int)(Math.random()*13)]);
  line(110, 50, 110, 150);
  
  //Letter M
  stroke(colorPool[(int)(Math.random()*13)]);
  triangle(130, 150, 153, 55, 175, 150);
  triangle(153, 150, 175, 55, 198, 150);
}

/**draws middle name using lines and assign a random color
 * to it from colorPool
**/
void print_middle_name(){
  //Letter T
  stroke(colorPool[(int)(Math.random()*13)]);
  line(256, 50, 316, 50);
  line(286, 50, 286, 150);
  
  //Letter I
  stroke(colorPool[(int)(Math.random()*13)]);
  line(336, 50, 336, 150);
  
  //Letter N
  stroke(colorPool[(int)(Math.random()*13)]);
  line(356, 150, 381, 50);
  line(406, 150, 381, 50);
  line(381, 150, 406, 150);
  line(381, 150, 406, 50);
  
  //Letter G
  stroke(colorPool[(int)(Math.random()*13)]);
  line(470, 50, 420, 100);
  line(420, 100, 470, 150);
  line(470, 150, 470, 100);
}

/**draws last name and assigns a color from colorpool
**/
void print_last_name(){
  //Letter W
  stroke(colorPool[(int)(Math.random()*13)]);
  triangle(155, 200, 178, 290, 200, 200);
  triangle(178, 200, 200, 290, 223, 200);
  
  //Letter E
  stroke(colorPool[(int)(Math.random()*13)]);
  line(275, 200, 230, 225);
  line(230, 225, 275, 275);
  line(275, 225, 230, 275);
  line(230, 275, 275, 300);
  
  //Letter I
  stroke(colorPool[(int)(Math.random()*13)]);
  line(305, 200, 305, 300);
}

/**draws ID and assigns color randomly from colorPool
**/
void print_ID(color [] colorPool){
  assert colorPool.length == 13;
  //Number 0
  stroke(colorPool[(int)(Math.random()*13)]);
  triangle(50, 370, 85, 470 , 120, 370);
  
  //Number 1
  stroke(colorPool[(int)(Math.random()*13)]);
  line(140, 370, 140, 470);
  
  //Number 8
  stroke(colorPool[(int)(Math.random()*13)]);
  triangle(160, 370, 230, 370, 195, 430);
  triangle(160, 470, 230, 470, 195, 415);
  
  //Number 8
  stroke(colorPool[(int)(Math.random()*13)]);
  triangle(240, 370, 310, 370, 275, 430);
  triangle(240, 470, 310, 470, 275, 415);
  
  //Number 3
  stroke(colorPool[(int)(Math.random()*13)]);
  line(320, 370, 370, 400);
  line(370, 400, 345, 420);
  line(320, 400, 370, 440);
  line(370, 440, 320, 470);
  
  //Number 2
  stroke(colorPool[(int)(Math.random()*13)]);
  line(375, 370, 422, 420);
  line(422, 420, 375, 470);
  line(375, 470, 422, 470);
  
  //Number 3
  stroke(colorPool[(int)(Math.random()*13)]);
  line(430, 370, 480, 400);
  line(480, 400, 455, 420);
  line(430, 400, 480, 440);
  line(480, 440, 430, 470);
}

/**generates background by instantiating ellipses that
* resembles blinking stars to create a night sky atmosphere
* @param numStars: number of stars to be generated
**/
void generateBGI(int numStars){
   starX=new int[numStars]; //create an array of size numStars
   starY=new int[numStars];
   starColor= new color[numStars];
   float sd = width/2;
   float mean = width/2;
   //Gaussian distribution function is governed by two parameters, standard deviation
   //and mean. Here I scale the random number obtained by multiplying by s.d. and plus mean
   //Reference can be found in the examples given in the menu file>Examples>RandomGaussian
   for(int i =0; i<starX.length;i++){
     starX[i] = (int)(randomGaussian()*sd+mean); //generate x-coordinates of the stars that is within the boundaries of the canvas
     starY[i] = (int)(randomGaussian()*sd+mean);//generate y-coordinates of the stars that is within the boundaries of the canvas
     starColor[i] = color((int)random(0, 255));//generate any of the possible shades of black and white to make the twinkling effect
   }

}


/**Generates a set of colors that
*will be randomly chosen from
**/
void set_colors(){
  colorPool[0] = color(0, 255, 0); //Pure green
  colorPool[1] = color(255, 0, 0); //Pure red
  colorPool[2] = color(255, 255, 0); //Pure yellow
  colorPool[3] = color(102, 0, 255); //pure violet
  colorPool[4] = color(255, 153, 0); //orange
  colorPool[5] = color(204, 51, 102); //Strong pink
  colorPool[6] = color(0, 153, 255); //light blue
  colorPool[7] = color(238, 130, 238); //soft magenta
  colorPool[8] = color(135,206,250); //light blue
  colorPool[9] = color(255, 215, 0); //gold
  colorPool[10] = color(139, 69, 19); // brown
  colorPool[11] = color(222, 184, 135); //burlywood(very soft orange)
  colorPool[12] = color(32, 178, 170); //dark cyan  
}

/**draws a cresent moon in the canvas
*@param cx: x-coordinate of the center
*@param cy: y-coordinate of the center
*@param size: size of the cresent moon
**/
void draw_moon(int cx, int cy, int size){
 stroke(colorPool[(int)(Math.random()*13)]);
 arc(cx, cy, size, size, HALF_PI, 1.5*PI);
 arc(cx, cy, size+60, size, HALF_PI, 1.5*PI);
}

/**draws stars using pshape
*@param x: first param for translate();
*@param y: second param for translate();
**/
void draw_stars(int x, int y){
  translate(x, y);
  stroke(colorPool[(int)(Math.random()*13)]);
  beginShape();
  vertex(10, 0);
  vertex(90, 0);
  vertex(25, 70);
  vertex(50, -20);
  vertex(75, 70);
  endShape(CLOSE);
}