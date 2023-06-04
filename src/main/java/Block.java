import java.util.*;

public class Block implements BlockInterface {
    public static ArrayList<Block> blocks= new ArrayList<>();
    private final int width  = 40;
    private final int height = 30;
    public float speedY = -50;
    private float BlockX;
    private float BlockY;
    private int colorR;
    private int colorG;
    private int colorB;


    public Block(float blockX, float blockY, int colorR, int colorG, int colorB) {
        this.BlockX = blockX;
        this.BlockY = blockY;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public void makeBlocks() {
        int blockCount = 1000;
        float initialSpeedY = -50;
        float speedIncrement = 50;

        for (int i = 0; i < blockCount; i++) {
            float randomX = Main.pApplet.random(10, 390);
            float randomY = speedY;

            // Generate random RGB color values
            int randomR = (int) Main.pApplet.random(256);
            int randomG = (int) Main.pApplet.random(256);
            int randomB = (int) Main.pApplet.random(256);

            blocks.add(new Block(randomX, randomY, randomR, randomG, randomB));

            speedY -= speedIncrement;
        }
    }

    public void showBlocks() {
        int alpha = 150; // Set a constant alpha value for all blocks

        for (Block tempBlock : blocks) {
            Main.pApplet.fill(tempBlock.colorR, tempBlock.colorG, tempBlock.colorB, alpha);
            Main.pApplet.rect(tempBlock.BlockX, tempBlock.BlockY, width, height);
        }
    }

    public void moveBlock() {
        for (Block block : blocks){
            block.setBlockY(getBlockY()+15);
        }
    }

    public float getBlockY() {
        return BlockY;
    }

    public void setBlockY(float blockY) {
        BlockY = blockY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getBlockX() {
        return BlockX;
    }

    public void setBlockX(float blockX) {
        BlockX = blockX;
    }

    public static void setBlocks(ArrayList<Block> blocks) {
        Block.blocks = blocks;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public void setColorR(int colorR) {
        this.colorR = colorR;
    }

    public void setColorG(int colorG) {
        this.colorG = colorG;
    }

    public void setColorB(int colorB) {
        this.colorB = colorB;
    }
}