import java.awt.*;
import java.awt.event.ActionEvent;

public class game {

    private square square = new square();

    public void updateGame() {
        moveObjects();
        checkCollisions();
    }

    public void checkCollisions() {

    }

    public void moveObjects() {
        square.move();
    }

    public void drawTheGame(Graphics g) {

    }

    public void upHit(ActionEvent e) {
        System.out.println("Up!!");
    }

    public void upReleased(ActionEvent e) {
        System.out.println("Released ^^^^  Up!!");
    }
}