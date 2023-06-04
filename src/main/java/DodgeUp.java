import processing.core.PApplet;

public class DodgeUp extends PApplet {
    public static PApplet pApplet;
    private final int width = 400;
    private final int height = 600;
    public Human human = new Human();
    public Block block = new Block(0, 0, 0, 0, 0);
    public int life = 15; // equal to 5
    public int score = 0;
    public boolean gameOver = false;
    public static boolean HighScore = false;


    public void setup() {
        pApplet = this;
        human.humanBody();
        block.makeBlocks();
    }

    public void draw() {
        if (!gameOver) {
            background.setBackGround();
            float humanC = human.getHeadXPos();
            float humanT = human.getHeadYPos() + human.getHeadHeight() / 2;
            float humanB = human.getHeadYPos() - human.getHeadHeight() / 2;
            human.humanFPS();
            block.showBlocks();
//        checking hit...
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
//        moving block in each frame
            for (Block tempBlock : Block.blocks) {
                tempBlock.setBlockY(tempBlock.getBlockY() + 3);
            }
            background.setScore();
            textSize(25);
            fill(128, 3, 5);
            text("Life : " + life / 3, 310, 30);
        }
    }

    public void settings() {
        size(width, height);
    }

    public void mouseClicked() {
        if (gameOver) {
            exit();
        }
    }

    public void gameOver(int score) {
        background(0);
        textSize(25);
        text("your score is : " + score, 120, 200);
        if (HighScore) {
            fill(52, 143, 235);
            text("you set a highScore!!!", 105, 295);
        }
        fill(143, 11, 25);
        text("Exit", 150, 400);
    }

    public static void main(String[] args) {

        PApplet.main("DodgeUp", args);
    }
}