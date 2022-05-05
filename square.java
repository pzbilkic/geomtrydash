import java.awt.*;

public class square {

    Image sprite = Toolkit.getDefaultToolkit().getImage("squareSprite.jpg");

    public square() {

    }

    public void move() {

    }

    public void jump() {

    }

    public void draw(Graphics g) {
        g.drawImage(sprite, 50, 50, null);
    }
}