import processing.core.PApplet;

public class background {
    public static PApplet background = Main.pApplet;

    public static void setBackGround() {
        background.background(128, 52, 235);
        background.fill(150);
        background.noStroke();
        background.rect(200, 531, 400, 62);
    }

    public static void setScore() {
        background.textSize(25);
        background.fill(5);
        background.text("score : " + background.frameCount / 10,50 , 30);
    }
}