import processing.core.PApplet;

public class background {
    public static PApplet bgc = DodgeUp.pApplet;
    public DodgeUp dodge = new DodgeUp();

    public static void setBackGround() {
        bgc.background(128, 52, 235);
//        bottom line
        bgc.fill(150);
        bgc.noStroke();
        bgc.rect(200, 531, 400, 62);
    }

    public static void setScore() {
        bgc.textSize(25);
        bgc.fill(5);
        bgc.text("score : " + bgc.frameCount / 10, 10, 20);
    }

    public static void setLife() {
        bgc.textSize(15);
        bgc.fill(150, 150, 250);
        bgc.text("Life : " + 5 / 3, 350, 20);
    }

//    public void startMenu() {
//        // display instructions and options for the player
//        textSize(30);
//        fill(255);
//        textAlign(CENTER);
//        text("DodgeUp Game", width/2, height/4);
//
//        textSize(20);
//        fill(255);
//        textAlign(LEFT);
//        text("Instructions: Avoid the blocks by moving the human with left and right arrow keys.", 50, height/2-50);
//        text("Press any key to start the game.", 50, height/2);
//
////        // Wait for player input to start the game
////        if (keyPressed) {
////            gameState = "play";
////        }
//    }


}