import processing.core.PApplet;
import processing.core.PImage;  
/**
 * Description: 
 * @author: B. Zhang
 */

public class Sketch extends PApplet {
  // global variables
  PImage imgBasketballCourt;
  PImage imgSoccerField;
  PImage imgSoccerBall;
  PImage imgBasketBall;
  PImage imgFootball;
  char charSport = ' ';
  boolean charP = false;
  boolean charO = false;
  boolean charI = false;
  boolean charU = false;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    size(900, 500);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    imgBasketballCourt = loadImage("gym.png");
    imgBasketballCourt.resize(900,500);

    imgSoccerField = loadImage("soccerfield.jpg");
    imgSoccerField.resize(900,500);

    imgSoccerBall = loadImage("soccerball.png");
    imgSoccerBall.resize(100,100);

    imgBasketBall = loadImage("basketball.jpg");
    imgBasketBall.resize(100,100);

    imgFootball = loadImage("football.png");
    imgFootball.resize(150,100);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(0);

    // boolean variable mousePressed is used to change the background to a basketball court whenever the user left clicks
    if (mousePressed){
      image(imgBasketballCourt, 0, 0);
    }

    fill(255);
    textSize(13);
    text("(Drag your mouse to enter the soccer field)", 50, 25);
    text("You are pressing this key: ", 50, 50);

    // boolean variable keyPressed is used to track and output the key inputted by the user
    if (keyPressed){
      fill(255);
      textSize(13);
      text(key, 200, 50);
    }

    textSize(30);
    text("Which is the better sport: ", 250, 100);
    textSize(18);
    text("a. Soccer", 250, 125);
    text("b. Basketball ", 250, 145);
    text("or Football (hold u,i,o,p)", 250, 165);

    // uses charSport and if statements with a value assigned to it from the keyTyped() function
    if(charSport == 'a'){
      textSize(30);
      text("Heres a soccer ball :)", 250, 205);
      image(imgSoccerBall, 250, 250);
      text("Are you sure?? Use the left arrow for no, right arrow for yes", 55, 400);
      // keyCode is used to track user inputted keys that are not char types and are used to decide on an option.
      if (keyCode == LEFT) {
        textSize(18);
        text("Aww :(", 425, 425);
      }
      else if (keyCode == RIGHT) {
        textSize(18);
        text("Have another one!", 375, 425);
        image(imgSoccerBall, 400, 250);
      }
    }

    // uses charSport for basketball, with a value assigned to it from the keyTyped() function
    if(charSport == 'b'){
      textSize(30);
      text("Heres a basketball :)", 250, 205);
      image(imgBasketBall, 250, 250);
      text("Are you sure?? Use the left arrow for no, right arrow for yes", 55, 400);
      if (keyCode == LEFT) {
        textSize(18);
        text("Aww :(", 425, 425);
      }
      else if (keyCode == RIGHT) {
        textSize(18);
        text("Have another one!", 375, 425);
        image(imgBasketBall, 400, 250);
      }
    }

    // multiple booleans to track multiple key inputs for the football path
    if(charP && charO && charI && charU){
      image(imgFootball, 675, 275);
      text("Have a football :)", 675, 225);
    }
  }

  /**
   * Changes the background to a soccer field, and also creates a cursor for the user when the mouse left click is held down
   */
  public void mouseDragged(){
    image(imgSoccerField, 0, 0);
    fill(0);
    ellipse(mouseX, mouseY, 10, 10);
  }

  /**
   * Assigns a char type to the charSport variable used in the draw method
   */
  public void keyTyped(){
    charSport = key;
  }

  /**
   * Assigns a value for the booleans to use in the draw method that indicate whether a key was pressed
   */
  public void keyPressed() {
    if (key == 'p') {
      charP = true;
    }
    else if (key == 'o') {
      charO = true;
    }
    else if (key == 'i') {
      charI = true;
    }
    else if (key == 'u') {
      charU = true;
    }
  }
  
  /**
   * Assigns a value for the booleans to use in the draw method that indicate whether a key was released
   */
  public void keyReleased() {
    if (key == 'p') {
      charP = false;
    }
    else if (key == 'o') {
      charO = false;
    }
    else if (key == 'i') {
      charI = false;
    }
    else if (key == 'u') {
      charU = false;
    }
  }
}