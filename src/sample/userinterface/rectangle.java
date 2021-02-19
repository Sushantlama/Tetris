package sample.userinterface;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class rectangle extends Rectangle {
    Color color=Color.PURPLE;
    public Rectangle drawRectangle(int x, int y) {
        Rectangle box = new Rectangle();
        box.setX(50 * x);
        box.setY(50 * y);
        box.setWidth(50);
        box.setHeight(50);
        box.setFill(color);
        return box;
    }
}
