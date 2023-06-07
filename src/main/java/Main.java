import processing.core.*;

public class Main extends PApplet {
    public static PApplet pApplet;
    private final int width = 400;
    private final int height = 700;
    public Human human = new Human();
    public Block block = new Block(0, 0, 0, 0, 0);
    public int life = 15; // equal to 5
    public int score = 0;
    public boolean gameOver = false;
    public boolean startMenu = true;
    public static boolean HighScore = false;
    public PFont emojiFont;

    public void setup() {
        pApplet = this;
        human.humanBody();
        block.makeBlocks();
        emojiFont = createFont("Arial Unicode MS", 25);
        textFont(emojiFont);
    }

    public void draw() {
        if (startMenu) {
            drawStartMenu();
            keyPressed();
        } else if (!gameOver) {
            background.setBackGround();
            float humanC = human.getHeadXPos();
            float humanT = human.getHeadYPos() + human.getHeadHeight() / 2;
            float humanB = human.getHeadYPos() - human.getHeadHeight() / 2;
            human.humanFPS();
            block.showBlocks();
            // Checking hit...
            for (Block b : Block.blocks) {
                float blockL = b.getBlockX() - b.getWidth() / 2;
                float blockR = b.getBlockX() + b.getWidth() / 2;
                float blockT = b.getBlockY() + b.getHeight() / 2;
                float blockB = b.getBlockY() - b.getHeight() / 2;
                if (humanC >= blockL && humanC <= blockR && humanT < blockT && humanB > blockB) {
                    life--;
                    if (life <= 1) {
                        score = frameCount / 10;
                        gameOver = true;
                        gameOver(score);
                    }
                }
            }
            // Moving block in each frame
            for (Block tempBlock : Block.blocks) {
                tempBlock.setBlockY(tempBlock.getBlockY() + 3);
            }
            background.setScore();
            for (int i = 0; i < life / 3; i++) {
                text("❤️", 295 + i * 20, 30);
            }
        } else {
            gameOver(score);
        }
    }

    public void settings() {
        size(width, height);
    }

    public void drawStartMenu() {
        background(0);
        textAlign(CENTER);

        // Title
        textSize(38);
        fill(255);
        text("Welcome to the Game!", width / 2, height / 2 - 100);

        // Start button background
        noStroke();
        fill(128, 3, 5);
        rectMode(CENTER);
        rect(width / 2, height / 2, 200, 60, 10);

        // Start button text
        textSize(30);
        fill(255);
        text("Click to Start", width / 2, height / 2 + 10);

        // Exit button background
        noStroke();
        fill(128, 3, 5);
        rectMode(CENTER);
        rect(width / 2, height / 2 + 100, 200, 60, 10);

        // Exit button text
        textSize(30);
        fill(255);
        text("Click to Exit", width / 2, height / 2 + 110);

        // Help menu button
        textSize(20);
        fill(200);
        text("Press 'h' for help menu", width / 2, height / 2 + 200);
    }

    public void gameOver(int score) {
        background(255, 0, 0); // Set background color to red
        textAlign(CENTER);
        textSize(40);
        fill(255);
        text("Game Over", width / 2, height / 2 - 100);

        textSize(30);
        fill(255);
        text("Your Score: " + score, width / 2, height / 2);

        // Calculate the time played
        int minutes = frameCount / 60;
        int seconds = frameCount % 60;
        String timePlayed = String.format("Time Played: %02d:%02d", minutes, seconds);
        fill(255);
        textSize(20);
        text(timePlayed, width / 2, height / 2 + 50);

        if (HighScore) {
            fill(52, 143, 235);
            textSize(30);
            text("New High Score!", width / 2, height / 2 + 100);
        }

        fill(255);
        textSize(20);
        text("Click toExit", width / 2, height / 2 + 150);

        noLoop();
    }

    public void mouseClicked() {
        if (startMenu) {
            // Check if the mouse was clicked inside the start button
            if (mouseX > width / 2 - 100 && mouseX < width / 2 + 100 && mouseY > height / 2 - 30 && mouseY < height / 2 + 30) {
                startMenu = false;
            }

            // Check if the mouse was clicked inside the exit button
            if (mouseX > width / 2 - 100 && mouseX < width / 2 + 100 && mouseY > height / 2 + 70 && mouseY < height / 2 + 130) {
                exit();
            }
        } else if (gameOver) {
            exit();
        }
    }

    public void keyPressed() {
        if (key == 'h') {
            drawHelpMenu();
        }
    }

    public void drawHelpMenu() {
        background(0);
        textAlign(CENTER);

        // Title
        textSize(40);
        fill(255);
        text("Help Menu", width / 2, height / 2 - 100);

        // Controls
        textSize(20);
        fill(255);
        text("Controls:", width / 2, height / 2);
        text("Use the mouse to move", width / 2, height / 2 + 30);
        text("Avoid the falling blocks", width / 2, height / 2 + 60);

        // Scoring
        textSize(20);
        fill(255);
        text("Scoring:", width / 2, height / 2 + 120);
        text("Every 10 frames survived = 1 point", width / 2, height / 2 + 150);

        // Exit option
        textSize(20);
        fill(255);
        text("Press 'x' to exit help menu", width / 2, height / 2 + 220);
    }

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }
}