package sample.userinterface;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class gridLines {
    private  static  final Color board_background_color=Color.WHITE;
    String title1="TETRIS";



    public gridLines(Group root) {
        drawBoard(root);
        drawTitle(root);
        Rectangle horizontalLine;
        Rectangle verticalLine;
        int index1 = 0;
        while (index1 <= 20) {
            verticalLine = getLine(
                    50+25*index1,0,500,3
            );
            index1++;
            root.getChildren().addAll(verticalLine);
        }
        int  index2=0;
        while (index2 <= 20) {
            horizontalLine = getLine(
                    50,25*index2,3,500

            );
            index2++;
            root.getChildren().addAll(
                    horizontalLine
            );
        }
    }
    public Rectangle getLine(double x, double y, double height, double width){//getLine method
        Rectangle line = new Rectangle();
        line.setX(x);
        line.setY(y);
        line.setHeight(height);
        line.setWidth(width);
        line.setFill(Color.BLACK);
        return line;

    }
    private void drawBoard(Group root) {


        Rectangle boardBackground = new Rectangle();
        boardBackground.setX(50);
        boardBackground.setY(50);
        boardBackground.setWidth(500);
        boardBackground.setHeight(450);//rectangle.setFill(new ImagePattern(img));
        boardBackground.setFill(Color.rgb(0,0,0));
        root.getChildren().add(boardBackground);

    }
    private void drawTitle(Group root) {
        Text title = new Text(100, 550, title1);
        title.setFill(Color.WHITE);
        Font titleFont = new Font(43);
        title.setFont(titleFont);
        root.getChildren().add(title);
    }
}
