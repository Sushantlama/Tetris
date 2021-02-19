package sample.userinterface;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.problem.gameLogic;
import sample.problem.shapeChooser;

import java.io.Serializable;
import java.util.Random;

public class userinterface {
    gameLogic value = new gameLogic();//object of class value
    INPUT i = new INPUT();
    Stage stage;
    Scene scene;


    public Group root = new Group();
    gridLines gridLines = new gridLines(root);
    shapeChooser shapechoser=new shapeChooser();
    double windowX = 600;
    double windowY = 600;
    //color
    private static final Color window_background_color = Color.rgb(0, 0, 0);
    private static final Color window_background_color1 = Color.rgb(211, 211, 116);
    Random ra = new Random();
    boolean Rotation = false;
    boolean running = false;
    //parts of lthe Lblock
    Rectangle l1;
    Rectangle l2;
    Rectangle l3;
    Rectangle l4;
    int no1;
    int no2;
    int no3;
    Color color = Color.rgb(no1, no2, no3);
    Button button;

    int timer = 0;
    int x = 10;
    int y =2;
    int point=2;

    int x1;int y1;
    int x2;int y2;
    int x3;int y3;
    int x4;int y4;

    int p1;int q1;
    int p2;int q2;
    int p3;int q3;
    int p4;int q4;

    int m1;int n1;
    int m2;int n2;
    int m3;int n3;
    int m4;int n4;

    int u1;int v1;
    int u2;int v2;
    int u3;int v3;
    int u4;int v4;

    int e1;int f1;
    int e2;int f2;
    int e3;int f3;
    int e4;int f4;

    int input =0;
    Circle circle=new Circle();

    public boolean isCheck = true;
    public boolean isLeftCheck = true;
    public boolean isRightCheck = true;
    public boolean isRotationCheck = true;


    public userinterface(Stage Stage)
    {   stage = Stage;
        stage.setX(600);
        stage.setY(0);
        initiate_class();
    }
    public void initiate_class() {
        Image image=new Image("/bak.jpeg");

        scene = new Scene(root, windowX, windowY);
        scene.setFill(new ImagePattern(image));
        stage.setScene(scene);
        stage.setTitle("TETRIS");
        stage.show();
        shapechoser.setShape();
        drawshapes();
        Action();

    }
    public Scene getScene(){
        return this.scene;
    }
    public Color colorChosser(){
        return switch (shapechoser.getShape()) {
            case "L"->Color.rgb(240,24,23);
            case "LINE"-> Color.rgb(144,200,0);
            case "SQUARE"->Color.rgb(250,250,250);
            case "smallT"->Color.rgb(255,127,0);
            case "Z"-> Color.rgb(0,200,200);
            case "MIRROR_T"-> Color.rgb(50,50,200);
            case "T"-> Color.rgb(250,200,0);
            default   -> Color.rgb(250,200,0);
        };
    }
    public void drawshapes() {
        switch (shapechoser.getShape()) {
            case "L" -> {    makeL();break; }
            case "LINE" ->{   makeLINE();break;}
            case "SQUARE" ->  { makeSQUARE();break;}
            case "smallT" -> {}
            case "Z" -> {makez();break;}
            case "MIRROR_T" ->{   make_mirrorT();break;}
            case "T" ->   {}

        }
    }





   public Rectangle drawRectangle(int x, int y) {
        no1 = ra.nextInt(200);
        no2 = ra.nextInt(200);
        no3 = ra.nextInt(200);
        Rectangle box = new Rectangle();
        box.setX(25+25 * x);
        box.setY(25 * y);
        box.setWidth(25);
        box.setHeight(25);
        box.setFill(colorChosser());
        return box;
    }
   AnimationTimer timerX = new AnimationTimer() {
       @Override
       public void handle(long l) {
           timer = timer + 1;


           if (timer >= 40) {
                   if (shapechoser.getShape()=="L"){checkL();}//check whether is it right to move down or not
                   if (shapechoser.getShape()=="Z"){checkZ();}
                   if (shapechoser.getShape()=="MIRROR_T"){check_mirror_T();}
                   if (shapechoser.getShape()=="SQUARE"){checkSQUARE();}
                   if (shapechoser.getShape()=="LINE"){checkLINE();}
                   switch (shapechoser.getShape()){
                       case "L":{
                           if (i.getIndex() == 0) {
                               if (y < 18) {
                                   if (isCheck){ remove0L(); remove(); y = y + 1; makeL(); }
                                   else {y=point;shapechoser.setShape();drawshapes();}
                               }
                               if (y == 18) { y = point;  shapechoser.setShape();drawshapes();}
                           }
                           if (i.getIndex() == 1) {
                               if (y < 17) {
                                   if (isCheck){ remove1L();remove();y = y + 1;makeL();}
                                   else {y=point;shapechoser.setShape();drawshapes();}
                               }
                               if (y == 17) { y = point;  shapechoser.setShape();
                                   drawshapes(); }
                           }
                           if (i.getIndex() == 2) {
                               if (y <17) {
                                   if (isCheck){ remove2L();remove();y = y + 1;makeL();}
                                   else {y=point;shapechoser.setShape();drawshapes();}
                               }
                               if (y == 17) { y = point;  shapechoser.setShape();
                                   drawshapes(); }
                           }
                           if (i.getIndex() == 3) {
                               if (y < 17) {
                                   if (isCheck){ remove3L();remove();y = y + 1;makeL();}
                                   else {y=point;shapechoser.setShape();drawshapes();}
                               }
                               if (y ==17) { y = point;  shapechoser.setShape();
                                   drawshapes(); }
                           }
                           break;            }
                       case "Z":{
                           if (i.getIndex()==0)                                                  {if (y < 18) { if (isCheck){remove0Z(); remove(); y = y + 1; makez();}
                           else {y=point;shapechoser.setShape();drawshapes();}}
                               if (y == 18) { y = point;  shapechoser.setShape();
                                   drawshapes(); }
                           }

                           if (i.getIndex()==1){
                               if (y < 17) { if (isCheck){ remove1Z();remove();y = y + 1;makez();}
                               else {y=point;shapechoser.setShape();drawshapes();} }
                               if (y==17){y=point;  shapechoser.setShape();
                                   drawshapes();}

                           }
                           if (i.getIndex() == 2) {
                               if (y <17) { if (isCheck){ remove2Z();remove();y = y + 1;makez();}
                               else {y=point;shapechoser.setShape();drawshapes();} }
                               if (y == 17) { y = point;  shapechoser.setShape();
                                   drawshapes(); }
                           }
                           if (i.getIndex() == 3) {
                               if (y < 17) { if (isCheck){ remove3Z();remove();y = y + 1;makez();}
                               else {y=point;shapechoser.setShape();drawshapes();} }
                               if (y ==17) { y = point;  shapechoser.setShape();
                                   drawshapes(); }
                           }


                           break;           }
                       case "MIRROR_T":{
                           if (i.getIndex()==0)                                                  {if (y < 18) { if (isCheck){remove0_mirrorT(); remove(); y = y + 1; make_mirrorT();}
                           else {y=point;shapechoser.setShape();drawshapes();}}
                               if (y == 18) { y = point;  shapechoser.setShape();
                                   drawshapes(); }
                           }

                           if (i.getIndex()==1){
                               if (y < 17) { if (isCheck){ remove1_mirrorT();remove();y = y + 1;make_mirrorT();}
                               else {y=point;shapechoser.setShape();drawshapes();} }
                               if (y==17){y=point;  shapechoser.setShape();
                                   drawshapes();}

                           }
                           if (i.getIndex() == 2) {
                               if (y <17) { if (isCheck){ remove2_mirrorT();remove();y = y + 1;make_mirrorT();}
                               else {y=point;shapechoser.setShape();drawshapes();} }
                               if (y == 17) { y = point;  shapechoser.setShape();
                                   drawshapes(); }
                           }
                           if (i.getIndex() == 3) {
                               if (y < 17) { if (isCheck){ remove3_mirrorT();remove();y = y + 1;make_mirrorT();}
                               else {y=point;shapechoser.setShape();drawshapes();} }
                               if (y ==17) { y = point;  shapechoser.setShape();
                                   drawshapes(); }
                           }


                           break;           }
                       case "SQUARE":{
                           if (i.getIndex()==0)                                                  {if (y < 18) { if (isCheck){remove0SQUARE(); remove(); y = y + 1; makeSQUARE();}
                           else {y=point;shapechoser.setShape();drawshapes();}}
                               if (y == 18) { y = point ;  shapechoser.setShape();
                                   drawshapes();} }

                           if (i.getIndex()==1){
                               if (y < 17) { if (isCheck){ remove1SQUARE();remove();y = y + 1;makeSQUARE();}
                               else {y=point;shapechoser.setShape();drawshapes();} }
                               if (y==17){y=point;  shapechoser.setShape();
                                   drawshapes();}

                           }
                           if (i.getIndex() == 2) {
                               if (y <17) { if (isCheck){ remove2SQUARE();remove();y = y + 1;makeSQUARE();}
                               else {y=point;shapechoser.setShape();drawshapes();} }
                               if (y == 17) { y = point;  shapechoser.setShape();
                                   drawshapes(); }
                           }
                           if (i.getIndex() == 3) {
                               if (y < 18) { if (isCheck){ remove3SQUARE();remove();y = y + 1;makeSQUARE();}
                               else {y=point;shapechoser.setShape();drawshapes();} }
                               if (y ==18) { y = point;  shapechoser.setShape();
                                   drawshapes(); }
                           }


                           break;           }
                       case "LINE":{
                           if (i.getIndex()==0)                                                  {if (y < 16) { if (isCheck){remove0LINE(); remove(); y = y + 1; makeLINE();}
                           else {y=point;shapechoser.setShape();drawshapes();}}
                               if (y == 16) { y = point;  shapechoser.setShape();
                                   drawshapes(); } }

                           if (i.getIndex()==1){
                               if (y < 17) { if (isCheck){ remove1LINE();remove();y = y + 1;makeLINE();}
                               else {y=point;shapechoser.setShape();drawshapes();} }
                               if (y==17){y=point; shapechoser.setShape();
                                   drawshapes();}

                           }
                           if (i.getIndex() == 2) {
                               if (y <17) { if (isCheck){ remove2LINE();remove();y = y + 1;makeLINE();}
                               else {y=point;shapechoser.setShape();drawshapes();} }
                               if (y == 17) { y =point;makeLINE();  shapechoser.setShape();
                                   drawshapes(); }
                           }
                           if (i.getIndex() == 3) {
                               if (y < 18) { if (isCheck){ remove3LINE();remove();y = y + 1;makeLINE();}
                               else {y=point;shapechoser.setShape();drawshapes();} }
                               if (y ==18) { y = point;   shapechoser.setShape();
                                   drawshapes();}
                           }


                           break;           }
                   }
               timer=0;
               }


           }
   };
    public void Action() {
    scene.setOnKeyPressed(event -> {
    switch (event.getCode()) {
    case LEFT -> {
        if (shapechoser.getShape().equalsIgnoreCase("L")){
            checkL(); }//check whether is it right to move down or not
        if (shapechoser.getShape().equalsIgnoreCase("Z")){
           checkZ();}
        if (shapechoser.getShape().equals("MIRROR_T")){
           check_mirror_T();}
        if (shapechoser.getShape().equals("SQUARE")){
            checkSQUARE();}
        if (shapechoser.getShape().equals("LINE")){
           checkLINE();}


       switch (shapechoser.getShape()){

           case "L":{
               if (i.getIndex() == 0) {
                                                                                   if (x > 1) {
                                                                                                      if (isLeftCheck){  remove0L(); remove();  x = x - 1; makeL();}
                                                                                              }
                                                                                  if (x == 1) {   }
                                }
               if (i.getIndex() == 1) {
                                                                                  if (x > 1) {
                                                                                                        if (isLeftCheck){remove1L(); remove();  x = x - 1;   makeL();}
                                                                                            }

                                                                                  if (x == 1) {   }
                               }
        if (i.getIndex() == 2) {                                                   if (x > 1) {
                                                                                                       if (isLeftCheck){remove2L();remove(); x = x - 1; makeL();} }
                                                                                  if (x == 1) {  }
                               }
        if (i.getIndex() == 3) {
                                                                                  if (x > 0) {
                                                                                                        if (isLeftCheck){ remove3L();remove(); x = x - 1;makeL();}}
                                                                                 if (x == 0) {   }
                               }

           break;       }
       case "Z":{
       if (i.getIndex()==0){                                                        if (x>1){if (isLeftCheck){remove();remove0Z();x=x-1;makez();break;}}
                                                                                    if (x==1){}
                                                                                    else {}
                }
       if (i.getIndex()==1){
                                                                                     if (x>1){if (isLeftCheck){remove();remove1Z();x=x-1;makez();break;}}
                                                                                     if (x==1){}
                                                                                     else {}
       }
       if (i.getIndex()==2){
                                                                                      if (x>1){if (isLeftCheck){remove();remove2Z();x=x-1;makez();break;}}
                                                                                        if (x==1){}
                                                                                            else {}
       }
       if (i.getIndex()==3){
                                                                                        if (x>0){if (isLeftCheck){remove();remove3Z();x=x-1;makez();break;}}
                                                                                       if (x==0){}
                                                                                           else {}

       }
       break;}
           case "MIRROR_T":{
               if (i.getIndex()==0){                                                        if (x>2){if (isLeftCheck){remove();remove0_mirrorT();x=x-1;make_mirrorT();break;}}
                                                                                            if (x==2){}
                                                                                            else {}
               }
               if (i.getIndex()==1){
                                                                                            if (x>1){
                                                                                                System.out.println("hi");if (isLeftCheck){remove();remove1_mirrorT();x=x-1;make_mirrorT();break;}}
                                                                                            if (x==1){}
                                                                                               else {}
               }
               if (i.getIndex()==2){
                                                                                              if (x>2){if (isLeftCheck){remove();remove2_mirrorT();x=x-1;make_mirrorT();break;}}
                                                                                             if (x==2){}
                                                                                               else {}
               }
               if (i.getIndex()==3){
                                                                                                if (x>0){if (isLeftCheck){remove();remove3_mirrorT();x=x-1;make_mirrorT();break;}}
                                                                                             if (x==0){}
                                                                                                  else {}
 
               }
               break;}
           case "SQUARE":{
               if (i.getIndex()==0){                                                        if (x>1){if (isLeftCheck){remove();remove0SQUARE();x=x-1;makeSQUARE();break;}}
                                                                                               if (x==1){}
                                                                                               else {}
               }
               if (i.getIndex()==1){
                                                                                               if (x>1){if (isLeftCheck){remove();remove1SQUARE();x=x-1;makeSQUARE();break;}}
                                                                                               if (x==1){}
                                                                                               else {}
               }
               if (i.getIndex()==2){
                                                                                               if (x>0){if (isLeftCheck){remove();remove2SQUARE();x=x-1;makeSQUARE();break;}}
                                                                                               if (x==0){}
                                                                                               else {}
               }
               if (i.getIndex()==3){
                                                                                               if (x>0){if (isLeftCheck){remove();remove3SQUARE();x=x-1;makeSQUARE();break;}}
                                                                                               if (x==0){}
                                                                                               else {}

               }
               break;}
           case "LINE":{
               if (i.getIndex()==0){                                                        if (x>=2){if (isLeftCheck){ remove();remove0LINE();x=x-1;makeLINE();break;}}
                                                                                           if (x==1){}
                                                                                           else {}
               }
               if (i.getIndex()==1){
                                                                                           if (x>3){if (isLeftCheck){remove();remove1LINE();x=x-1;makeLINE();break;}}
                                                                                           if (x==3){}
                                                                                           else {}
               }
               if (i.getIndex()==2){
                                                                                           if (x>1){if (isLeftCheck){remove();remove2LINE();x=x-1;makeLINE();break;}}
                                                                                           if (x==1){}
                                                                                           else {}
               }
               if (i.getIndex()==3){
                                                                                           if (x>2){if (isLeftCheck){remove();remove3LINE();x=x-1;makeLINE();break;}}
                                                                                           if (x==2){}
                                                                                           else {}

               }
               break;}
       
    }
    }
   case RIGHT -> {
       if (shapechoser.getShape().equalsIgnoreCase("L")){ checkL();}//check whether is it right to move down or not
       if (shapechoser.getShape().equalsIgnoreCase("Z")){ checkZ();}
       if (shapechoser.getShape().equalsIgnoreCase("MIRROR_T")){ check_mirror_T();}
       if (shapechoser.getShape().equalsIgnoreCase("SQUARE")){ checkSQUARE();}
       if (shapechoser.getShape().equalsIgnoreCase("LINE")){ checkLINE();}
       switch (shapechoser.getShape()){
       case "L":{
           if (i.getIndex() == 0) {
                                                                                   if (x < 18) {
                                                                                       if (isRightCheck){ remove(); remove0L(); x = x + 1; makeL(); }
                                                                                              }
                                                                                   if (x == 18) { }
                                }
         if (i.getIndex() == 1) {
                                                                                   if (x < 19) {
                                                                                       if (isRightCheck){ remove();remove1L(); x = x + 1;makeL(); }
                                                                                              }
                                                                                    if (x == 18) { }
                                }
         if (i.getIndex() == 2) {
                                                                                   if (x < 19) {
                                                                                       if (isRightCheck) { remove();remove2L(); x = x + 1; makeL(); }
                                                                                              }
                                                                                   if (x == 19) { }
                                }

         if (i.getIndex() == 3) {
                                                                                    if (x < 19) {
                                                                                        if (isRightCheck) { remove();remove3L();x = x + 1;makeL(); }
                                                                                               }
                                                                                    if (x == 19) { }
                                }

break;
}
           case "Z":{
            if (i.getIndex() == 0) {
                                                                                    if (x<18){if (isRightCheck){remove();remove0Z();x=x+1;makez();break;}}
                                                                                         if (x==18){}
                                                                                         else {}}
            if (i.getIndex()==1){
                                                                                   if (x < 19) { if (isRightCheck){ remove();remove1Z(); x = x + 1;makez(); } }
                                                                                     if (x == 18) { }
                                                                                     else {}
            }
            if (i.getIndex()==2){
                                                                                   if (x < 19) { if (isRightCheck){ remove();remove2Z(); x = x + 1;makez(); } }
                                                                                   if (x == 18) { }
                                                                                     else {}
               }
               if (i.getIndex()==3){
                                                                                  if (x < 19) { if (isRightCheck){ remove();remove3Z(); x = x + 1;makez(); } }
                                                                                   if (x == 18) { }
                                                                                       else {}
               }

 break;          }
           case "MIRROR_T":{
               if (i.getIndex() == 0) {
                                                                                      if (x<19){if (isRightCheck){remove();remove0_mirrorT();x=x+1;make_mirrorT();break;}}
                                                                                         if (x==19){}
                                                                                           else {}}
               if (i.getIndex()==1){
                                                                                     if (x < 20) { if (isRightCheck){ remove();remove1_mirrorT(); x = x + 1;make_mirrorT();break; } }
                                                                                       if (x == 19) { }
                                                                                         else {}
               }
               if (i.getIndex()==2){
                                                                                         if (x < 19) { if (isRightCheck){ remove();remove2_mirrorT(); x = x + 1;make_mirrorT(); } }
                                                                                    if (x == 18) { }
                                                                                          else {}
               }
               if (i.getIndex()==3){
                                                                                         if (x < 19) { if (isRightCheck){ remove();remove3_mirrorT(); x = x + 1;make_mirrorT();break; } }
                                                                                      if (x == 18) { }
                                                                                              else {}
               }

               break;          }
           case "SQUARE":{
               if (i.getIndex() == 0) {
                                                                                   if (x<19){if (isRightCheck){remove();remove0SQUARE();x=x+1;makeSQUARE();break;}}
                                                                                    if (x==19){}
                                                                                              else {}}
               if (i.getIndex()==1){
                                                                                   if (x < 20) { if (isRightCheck){ remove();remove1SQUARE(); x = x + 1;makeSQUARE();break; } }
                                                                                   if (x == 19) { }
                                                                                   else {}
               }
               if (i.getIndex()==2){
                                                                                   if (x < 19) { if (isRightCheck){ remove();remove2SQUARE(); x = x + 1;makeSQUARE();break; } }
                                                                                   if (x == 18) { }
                                                                                   else {}
               }
               if (i.getIndex()==3){
                                                                                   if (x < 19) { if (isRightCheck){ remove();remove3SQUARE(); x = x + 1;makeSQUARE();break; } }
                                                                                   if (x == 18) { }
                                                                                   else {}
               }

               break;          }
           case "LINE":{
               if (i.getIndex() == 0) {
                                                                                   if (x<20){if (isRightCheck){remove();remove0LINE();x=x+1;makeLINE();break;}}
                                                                                   if (x==20){}
                                                                                   else {}}
               if (i.getIndex()==1){
                                                                                   if (x < 20) { if (isRightCheck){ remove();remove1LINE(); x = x + 1;makeLINE();break; } }
                                                                                   if (x == 19) { }
                                                                                   else {}
               }
               if (i.getIndex()==2){
                                                                                   if (x < 20) { if (isRightCheck){ remove();remove2LINE(); x = x + 1;makeLINE();break; } }
                                                                                   if (x == 19) { }
                                                                                   else {}
               }
               if (i.getIndex()==3){
                                                                                   if (x < 19) { if (isRightCheck){ remove();remove3LINE(); x = x + 1;makeLINE();break; } }
                                                                                   if (x == 18) { }
                                                                                   else {}
               }

               break;          }
               }
}
      case DOWN -> {
         if (shapechoser.getShape()=="L"){checkL();}//check whether is it right to move down or not
          if (shapechoser.getShape()=="Z"){checkZ();}
          if (shapechoser.getShape()=="MIRROR_T"){check_mirror_T();}
          if (shapechoser.getShape()=="SQUARE"){checkSQUARE();}
          if (shapechoser.getShape()=="LINE"){checkLINE();}
         switch (shapechoser.getShape()){
             case "L":{
             if (i.getIndex() == 0) {
                                                                                    if (y < 18) {
                                                                                        if (isCheck){ remove0L(); remove(); y = y + 1; makeL(); }
                                                                                        else {y=point;shapechoser.setShape();drawshapes();}
                                                                                               }
                                                                                    if (y == 18) { y = point;  shapechoser.setShape();drawshapes();}
                                }
         if (i.getIndex() == 1) {
                                                                                     if (y < 17) {
                                                                                         if (isCheck){ remove1L();remove();y = y + 1;makeL();}
                                                                                         else {y=point;shapechoser.setShape();drawshapes();}
                                                                                                }
                                                                                     if (y == 17) { y = point;  shapechoser.setShape();
                                                                                         drawshapes(); }
                                 }
         if (i.getIndex() == 2) {
                                                                                    if (y <17) {
                                                                                        if (isCheck){ remove2L();remove();y = y + 1;makeL();}
                                                                                        else {y=point;shapechoser.setShape();drawshapes();}
                                                                                               }
                                                                                    if (y == 17) { y = point;  shapechoser.setShape();
                                                                                        drawshapes(); }
                                }
         if (i.getIndex() == 3) {
                                                                                     if (y < 17) {
                                                                                         if (isCheck){ remove3L();remove();y = y + 1;makeL();}
                                                                                         else {y=point;shapechoser.setShape();drawshapes();}
                                                                                               }
                                                                                     if (y ==17) { y =point;  shapechoser.setShape();
                                                                                         drawshapes(); }
                                 }
      break;            }
             case "Z":{
                 if (i.getIndex()==0)                                                  {if (y < 18) { if (isCheck){remove0Z(); remove(); y = y + 1; makez();}
                                                                                          else {y=point;shapechoser.setShape();drawshapes();}}
                                                                                        if (y == 18) { y =point;  shapechoser.setShape();
                                                                                            drawshapes(); }
                                                                                        }

                 if (i.getIndex()==1){
                                                                                       if (y < 17) { if (isCheck){ remove1Z();remove();y = y + 1;makez();}
                                                                                           else {y=point;shapechoser.setShape();drawshapes();} }
                                                                                       if (y==17){y=point;  shapechoser.setShape();
                                                                                           drawshapes();}

                 }
                 if (i.getIndex() == 2) {
                                                                          if (y <17) { if (isCheck){ remove2Z();remove();y = y + 1;makez();}
                                                                                           else {y=point;shapechoser.setShape();drawshapes();} }
                                                                            if (y == 17) { y =point;  shapechoser.setShape();
                                                                                drawshapes(); }
                 }
                 if (i.getIndex() == 3) {
                                                                       if (y < 17) { if (isCheck){ remove3Z();remove();y = y + 1;makez();}
                                                                                       else {y=point;shapechoser.setShape();drawshapes();} }
                                                                             if (y ==17) { y = point;  shapechoser.setShape();
                                                                                 drawshapes(); }
                 }


      break;           }
             case "MIRROR_T":{
                 if (i.getIndex()==0)                                                  {if (y < 18) { if (isCheck){remove0_mirrorT(); remove(); y = y + 1; make_mirrorT();}
                                                                                         else {y=point;shapechoser.setShape();drawshapes();}}
                                                                                          if (y == 18) { y = point;  shapechoser.setShape();
                                                                                              drawshapes(); }
                 }

                 if (i.getIndex()==1){
                                                                                         if (y < 17) { if (isCheck){ remove1_mirrorT();remove();y = y + 1;make_mirrorT();}
                                                                                         else {y=point;shapechoser.setShape();drawshapes();} }
                                                                                         if (y==17){y=point;  shapechoser.setShape();
                                                                                             drawshapes();}

                 }
                 if (i.getIndex() == 2) {
                                                                                             if (y <17) { if (isCheck){ remove2_mirrorT();remove();y = y + 1;make_mirrorT();}
                                                                                             else {y=point;shapechoser.setShape();drawshapes();} }
                                                                                             if (y == 17) { y = point;  shapechoser.setShape();
                                                                                                 drawshapes(); }
                 }
                 if (i.getIndex() == 3) {
                                                                                             if (y < 17) { if (isCheck){ remove3_mirrorT();remove();y = y + 1;make_mirrorT();}
                                                                                              else {y=point;shapechoser.setShape();drawshapes();} }
                                                                                             if (y ==17) { y = point;  shapechoser.setShape();
                                                                                                 drawshapes(); }
                 }


                 break;           }
             case "SQUARE":{
                 if (i.getIndex()==0)                                                  {if (y < 18) { if (isCheck){remove0SQUARE(); remove(); y = y + 1; makeSQUARE();}
                                                                                            else {y=point;shapechoser.setShape();drawshapes();}}
                                                                                       if (y == 18) { y = point ;  shapechoser.setShape();
                                                                                           drawshapes();} }

                 if (i.getIndex()==1){
                                                                                    if (y < 17) { if (isCheck){ remove1SQUARE();remove();y = y + 1;makeSQUARE();}
                                                                                                 else {y=point;shapechoser.setShape();drawshapes();} }
                                                                                          if (y==17){y=point;  shapechoser.setShape();
                                                                                              drawshapes();}

                 }
                 if (i.getIndex() == 2) {
                                                                                       if (y <17) { if (isCheck){ remove2SQUARE();remove();y = y + 1;makeSQUARE();}
                                                                                     else {y=point;shapechoser.setShape();drawshapes();} }
                                                                                     if (y == 17) { y =point;  shapechoser.setShape();
                                                                                         drawshapes(); }
                 }
                 if (i.getIndex() == 3) {
                                                                                     if (y < 18) { if (isCheck){ remove3SQUARE();remove();y = y + 1;makeSQUARE();}
                                                                                     else {y=point;shapechoser.setShape();drawshapes();} }
                                                                                     if (y ==18) { y =point;  shapechoser.setShape();
                                                                                         drawshapes(); }
                 }


                 break;           }
             case "LINE":{
                 if (i.getIndex()==0)                                                  {if (y < 16) { if (isCheck){remove0LINE(); remove(); y = y + 1; makeLINE();}
                                                                                       else {y=point;shapechoser.setShape();drawshapes();}}
                                                                                       if (y == 16) { y =point;  shapechoser.setShape();
                                                                                           drawshapes(); } }

                 if (i.getIndex()==1){
                                                                                         if (y < 17) { if (isCheck){ remove1LINE();remove();y = y + 1;makeLINE();}
                                                                                         else {y=point;shapechoser.setShape();drawshapes();} }
                                                                                         if (y==17){y=point; shapechoser.setShape();
                                                                                             drawshapes();}

                 }
                 if (i.getIndex() == 2) {
                                                                                         if (y <17) { if (isCheck){ remove2LINE();remove();y = y + 1;makeLINE();}
                                                                                         else {y=point;shapechoser.setShape();drawshapes();} }
                                                                                         if (y == 17) { y = point;makeLINE();  shapechoser.setShape();
                                                                                             drawshapes(); }
                 }
                 if (i.getIndex() == 3) {
                                                                                         if (y < 18) { if (isCheck){ remove3LINE();remove();y = y + 1;makeLINE();}
                                                                                         else {y=point;shapechoser.setShape();drawshapes();} }
                                                                                         if (y ==18) { y = point;   shapechoser.setShape();
                                                                                             drawshapes();}
                 }


                 break;           }
}
}
    case ENTER -> {
     if(shapechoser.getShape().equalsIgnoreCase("L")){
        switch (i.getIndex()) {
            case 0 -> {
                remove0L();
                checkL();
                if (!isRotationCheck){setValueL(); }
            }
            case 1 -> {
                remove1L();
                checkL();
                if (!isRotationCheck){setValueL(); }
            }
            case 2 -> {
                remove2L();
                checkL();
                if (!isRotationCheck){setValueL(); }
            }
            case 3 -> {
                remove3L();
                checkL();
                if (!isRotationCheck){setValueL(); }
            }
                             }}
     else if(shapechoser.getShape().equalsIgnoreCase("Z")){
         switch (i.getIndex()) {
             case 0 -> {
                 remove0Z();
                 checkZ();
                 if (!isRotationCheck){setValueZ(); }
             }
             case 1 -> {
                 remove1Z();
                 checkZ();
                 if (!isRotationCheck){setValueZ(); }
             }
             case 2 -> {
                 remove2Z();
                 checkZ();
                 if (!isRotationCheck){setValueZ(); }
             }
             case 3 -> {

                 remove3Z();
                 checkZ();
                 if (!isRotationCheck){setValueZ(); }
             }
         }
     }
     else if(shapechoser.getShape().equalsIgnoreCase("MIRROR_T")){
         switch (i.getIndex()) {
             case 0 -> {
                 remove0_mirrorT();
                 check_mirror_T();
                 if (!isRotationCheck){setValue_mirrorT(); }
             }
             case 1 -> {

                 remove1_mirrorT();
                 check_mirror_T();
                 if (!isRotationCheck){setValue_mirrorT(); }
             }
             case 2 -> {
                 remove2_mirrorT();
                 check_mirror_T();
                 if (!isRotationCheck){setValue_mirrorT(); }
             }
             case 3 -> {
                 remove3_mirrorT();
                 check_mirror_T();
                 if (!isRotationCheck){setValue_mirrorT(); }
             }
         }
     }
     else if(shapechoser.getShape().equalsIgnoreCase("SQUARE")){
         switch (i.getIndex()) {
             case 0 -> {
                                         remove0SQUARE();
                                       checkSQUARE();
                                         if (!isRotationCheck){setValueSQUARE(); }
             }
             case 1 -> {
                                         remove1SQUARE();
                                         checkSQUARE();
                                         if (!isRotationCheck){setValueSQUARE(); }
             }
             case 2 -> {
                                         remove2SQUARE();
                                         checkSQUARE();
                                         if (!isRotationCheck){setValueSQUARE(); }
             }
             case 3 -> {
                                         remove3SQUARE();
                                         checkSQUARE();
                                         if (!isRotationCheck){setValueSQUARE(); }
             }
         }
     }
     else if(shapechoser.getShape().equalsIgnoreCase("LINE")){
         switch (i.getIndex()) {
             case 0 -> {
                                     remove0LINE();
                                       checkLINE();
                                     if (!isRotationCheck){setValueLINE(); }
             }
             case 1 -> {
                                     remove1LINE();
                                    checkLINE();
                                    if (!isRotationCheck){setValueLINE(); }
             }
             case 2 -> {
                                     remove2LINE();
                                     checkLINE();
                                     if (!isRotationCheck){setValueLINE(); }
             }
             case 3 -> {
                                     remove3LINE();
                                     checkLINE();
                                     if (!isRotationCheck){setValueLINE(); }
                                     
             }
         }
     }

switch (shapechoser.getShape()){
     case "L":{
    switch (i.getIndex()) {
            case 0: {

                            if (isRotationCheck){         remove();                                    i.setIndex(1);  makeL();       break;}//this is making 1
                    }
            case 1:{

                            if (isRotationCheck){            remove();                      i.setIndex(2); makeL()        ;break;}
                    }
            case 2: {
                            if (isRotationCheck){           remove();                 i.setIndex(3); makeL();       break; }
                    }


            case 3:{
                            if (isRotationCheck){             remove();                  i.setIndex(0); makeL();      break; }
                   }
             default:

                          }
       break;         }
    case "Z":{
        switch (i.getIndex()) {
            case 0: {

                if (isRotationCheck){         remove();                                    i.setIndex(1);  makez();       break;}//this is making 1
            }
            case 1:{

                if (isRotationCheck){            remove();                      i.setIndex(2); makez()        ;break;}
            }
            case 2: {
                if (isRotationCheck){
                    remove();                 i.setIndex(3); makez();       break; }
            }


            case 3:{
                if (isRotationCheck){
                    remove();                  i.setIndex(0); makez();      break; }
            }
            default:

        }
break;
    }
    case "MIRROR_T":{
        switch (i.getIndex()) {
            case 0: {

                if (isRotationCheck){         remove();                                    i.setIndex(1);  make_mirrorT();       break;}//this is making 1
            }
            case 1:{

                if (isRotationCheck){            remove();                      i.setIndex(2); make_mirrorT()        ;break;}
            }
            case 2: {
                if (isRotationCheck){
                    remove();                 i.setIndex(3); make_mirrorT();       break; }
            }


            case 3:{
                if (isRotationCheck){
                    remove();                  i.setIndex(0); make_mirrorT();      break; }
            }
            default:

        }
        break;
    }    case "SQUARE":{
        switch (i.getIndex()) {
            case 0: {
                if (isRotationCheck){         remove();                                    i.setIndex(1);  makeSQUARE();       break;}//this is making 1
            }
            case 1:{

                if (isRotationCheck){            remove();                      i.setIndex(2); makeSQUARE();        ;break;}
            }
            case 2: {
                if (isRotationCheck){
                    remove();                 i.setIndex(3);  makeSQUARE();     break; }
            }


            case 3:{
                if (isRotationCheck){
                    remove();                  i.setIndex(0);  makeSQUARE();      break; }
            }
            default:

        }
        break;
    }
    case "LINE":{
        switch (i.getIndex()) {
            case 0: {
                if (isRotationCheck){         remove();                                    i.setIndex(1);  makeLINE();       break;}//this is making 1
            }
            case 1:{

                if (isRotationCheck){            remove();                      i.setIndex(2); makeLINE();        ;break;}
            }
            case 2: {
                if (isRotationCheck){    remove();                 i.setIndex(3);   makeLINE();     break; }
            }


            case 3:{
                if (isRotationCheck){    remove();                  i.setIndex(0);   makeLINE();      break; }
            }
            default:

        }
        break;
    }

        }
    }

            }//switch (event.getcode)
        }//event ->{}
      );//scene,setonkeypressed
    }///action
//----------------------------------------------------------------------------------------------------------------------------
//                                           \\
//                                            \\
//                                             \\
//                                              \\====================
//---------------------------------------------------------------------------------------------------------------------------
public void makeL() {
    setcoordinates();


    l1 = drawRectangle(x1, y1);
    l2 = drawRectangle(x2, y2);
    l3 = drawRectangle(x3, y3);
    l4 = drawRectangle(x4, y4);
    setValueL();

    root.getChildren().add(l1);
    root.getChildren().add(l2);
    root.getChildren().add(l3);
    root.getChildren().add(l4);
     timerX.start();//Start the timer here
    running = true;
}
    public void setcoordinates(){

        if (i.getIndex()==0){
            if(x>=19){x=18;}
            x1 = x;                              y1 = y;
            x2 = x;                              y2 = 1 + y;
            x3 = 1 + x;                          y3 = 1 + y;
            x4 = 2 + x;                          y4 = 1 + y;
        }
        if (i.getIndex()==1){
            if(x>=20){x=19;}
            x1 = x;                               y1 = y+2;
            x2 = x+1;                             y2 = 2 + y;
            x3 = 1 + x;                           y3 = 1 + y;
            x4 =  x+1;                            y4 = y;
        }
        if (i.getIndex() == 2) {
            if (x>=19){x=18;}
            x1 = x+2;                                y1 = y+2;
            x2 = x+1+1;                              y2 = 2 + y-1;
            x3 = 1 + x;                              y3 = 1 + y;
            x4 =  x+1-1;                             y4 = y+1;
        }
        if (i.getIndex() == 3) {
            if (x>=19){x=18;}
            x1 = x+2;                                  y1 = y+2-2;
            x2 = x+1+1-1;                              y2 = 2 + y-1-1;
            x3 = 1 + x;                                y3 = 1 + y;
            x4 =  x+1-1+1;                             y4 = y+1+1;
        }
    }
   public void setValueL(){
       value.setvalue(x1, y1);//0+2
       value.setvalue(x2, y2);//0+2
       value.setvalue(x3, y3);//1+2
       value.setvalue(x4,y4);
   }
    public void remove() {
        if (running) {
            root.getChildren().remove(l1);
            root.getChildren().remove(l2);
            root.getChildren().remove(l3);
            root.getChildren().remove(l4);


        }

    }
    public  void checkL(){
        System.out.println(x);
        setcoordinates();
        isRightCheck=value.CheckRight(x1,y1,x2,y2,x3,y3,x4,y4);
        isCheck=value.CheckBottom(x1,y1,x2,y2,x3,y3,x4,y4);
        isLeftCheck= value.CheckLeft(x1,y1,x2,y2,x3,y3,x4,y4);
        if (x>0){isRotationCheck=value.CheckRotation(x1,y1,x2,y2,x3,y3,x4,y4);}
        else {isRotationCheck=false;}

    }
    public  void checkZ(){

        setcoordinatesZ();
        isRightCheck=value.CheckRight(p1,q1,p2,q2,p3,q3,p4,q4);
        isCheck=value.CheckBottom(p1,q1,p2,q2,p3,q3,p4,q4);
        isLeftCheck= value.CheckLeft(p1,q1,p2,q2,p3,q3,p4,q4);
        if (x>0){isRotationCheck=value.CheckRotation(p1,q1,p2,q2,p3,q3,p4,q4);}
        else {isRotationCheck=false;}

    }
    public void check_mirror_T(){
        setcoordinates_mirrorT();
        isRightCheck=value.CheckRight(m1,n1,m2,n2,m3,n3,m4,n4);
        isCheck=value.CheckBottom(m1,n1,m2,n2,m3,n3,m4,n4);
        isLeftCheck= value.CheckLeft(m1,n1,m2,n2,m3,n3,m4,n4);
        if (x>0){isRotationCheck=value.CheckRotation(m1,n1,m2,n2,m3,n3,m4,n4);}
        else {isRotationCheck=false;}
    }
    public void checkSQUARE(){
        setcoordinatesSQUARE();
        isRightCheck=value.CheckRight(u1,v1,u2,v2,u3,v3,u4,v4);
        isCheck=value.CheckBottom(u1,v1,u2,v2,u3,v3,u4,v4);
        isLeftCheck= value.CheckLeft(u1,v1,u2,v2,u3,v3,u4,v4);
        if (x>0){isRotationCheck=value.CheckRotation(u1,v1,u2,v2,u3,v3,u4,v4);}
        else {isRotationCheck=false;}
    }
    public void checkLINE(){
        setcoordinatesLINE();
        isRightCheck=value.CheckRight(e1,f1,e2,f2,e3,f3,e4,f4);
        isCheck=value.CheckBottom(e1,f1,e2,f2,e3,f3,e4,f4);
        isLeftCheck= value.CheckLeft(e1,f1,e2,f2,e3,f3,e4,f4);
        if (x>=1){isRotationCheck=value.CheckRotation(e1,f1,e2,f2,e3,f3,e4,f4);}
        else {isRotationCheck=false;}
    }

    public void remove0L(){
        value.removevalue(x, y);
        value.removevalue(x, y + 1);
        value.removevalue(x + 1, y + 1);
        value.removevalue(2 + x, 1 + y);
    }
    public void remove1L(){
        value.removevalue(x, y + 2);
        value.removevalue(x + 1, y + 2);
        value.removevalue(x + 1, y + 1);
        value.removevalue(1 + x, y);
    }
    public void remove2L(){
        value.removevalue(x+2, y + 2);
        value.removevalue(x + 1+1, y + 2-1);
        value.removevalue(x + 1, y + 1);
        value.removevalue(1 + x-1, y+1);

    }
    public void remove3L(){
        value.removevalue(x + 2, y + 2 - 2);
        value.removevalue(x + 1 + 1 - 1, y + 2 - 1 - 1);
        value.removevalue(x + 1, y + 1);
        value.removevalue(1 + x - 1 + 1, y + 1 +1);
    }

//----------------------------------------------------------------------------------------------------------------------------
//                                 ==========================
//                                                         \\
//                                      ====================\\
//                                         \\
//                                            \\=======================
//---------------------------------------------------------------------------------------------------------------------------
    public void makez() {
        setcoordinatesZ();
        l1 = drawRectangle(p1, q1);
        l2 = drawRectangle(p2, q2);
        l3 = drawRectangle(p3, q3);
        l4 = drawRectangle(p4, q4);
        setValueZ();

        root.getChildren().add(l1);
        root.getChildren().add(l2);
        root.getChildren().add(l3);
        root.getChildren().add(l4);
        timerX.start();//Start the timer here
        running = true;
    }
    public void setValueZ(){
        value.setvalue(p1,q1);
        value.setvalue(p2,q2);
        value.setvalue(p3,q3);
        value.setvalue(p4,q4);
    }
    public void setcoordinatesZ(){
     if (i.getIndex()==0){
         if (x>=19){x=18;}
       p1=x;q1=y;
       p2=x+1;q2=y;
       p3=x+1;q3=y+1;
       p4=x+2;q4=y+1;}
     if (i.getIndex()==1){
         if (x>=20){x=19;}
         p1=x;q1=y+2;
         p2=x;q2=y+1;
         p3=x+1;q3=y+1;
         p4=x+1;q4=y;
     }
     if (i.getIndex()==2){
         if (x>=19){x=18;}
         p1=x+2;q1=y+2;
         p2=x+1;q2=y+2;
         p3=x+1;q3=y+1;
         p4=x;q4=y+1;
     }
     if (i.getIndex()==3){
         if (x>=19){x=18;}
         p1=x+2;q1=y;
         p2=x+2;q2=y+1;
         p3=x+1;q3=y+1;
         p4=x+1;q4=y+2;
     }

    }
    public void remove0Z(){
     value.removevalue(x,y);
     value.removevalue(x+1,y);
     value.removevalue(x+1,y+1);
     value.removevalue(x+2,y+1);
    }
    public void remove1Z(){
        value.removevalue(x,y+2);
        value.removevalue(x,y+1);
        value.removevalue(x+1,y+1);
        value.removevalue(x+1,y);
    }
    public void remove2Z(){
        value.removevalue(x+2,y+2);
        value.removevalue(x+1,y+2);
        value.removevalue(x+1,y+1);
        value.removevalue(x,y+1);
    }
    public void remove3Z(){
        value.removevalue(x+2,y);
        value.removevalue(x+2,y+1);
        value.removevalue(x+1,y+1);
        value.removevalue(x+1,y+2);
    }
//------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------
//  \\\\   //\\          ===============     ==========       \\========\\           \\========\\         \\========\\       \\
//  \\  \\\\  \\               \\            \\        \\      \\         \\          \\        \\         \\         \\      \\
//  \\         \\               \\            \\=========       \\=========\\          \\=========\\        \\=========\\      \\
//  \\          \\       ==================    ||  \\            ||  \\                                      ||  \\             \\
//                                             ||   \\           ||    \\                                    ||   \\             \\=============
//-----------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------
    public void make_mirrorT() {
        setcoordinates_mirrorT();
        l1 = drawRectangle(m1, n1);
        l2 = drawRectangle(m2, n2);
        l3 = drawRectangle(m3, n3);
        l4 = drawRectangle(m4, n4);
        setValue_mirrorT();

        root.getChildren().add(l1);
        root.getChildren().add(l2);
        root.getChildren().add(l3);
        root.getChildren().add(l4);
        timerX.start();//Start the timer here
        running = true;
    }
    public void setValue_mirrorT(){
        value.setvalue(m1,n1);
        value.setvalue(m2,n2);
        value.setvalue(m3,n3);
        value.setvalue(m4,n4);
    }
    public void setcoordinates_mirrorT(){
        if (i.getIndex()==0) {
            if (x<=1){x=2;}
            if(x>=20){x=19;}
                m1 = x;
                n1 = y;
                m2 = x - 1;
                n2 = y + 1;
                m3 = x;
                n3 = y + 1;
                m4 = x + 1;
                n4 = y + 1;

        }
        if (i.getIndex()==1){
            if (x<=1){x=2;}
            m1=x-1;n1=y+1;
            m2=x;n2=y+2;
            m3=x;n3=y+1;
            m4=x;n4=y;

        }
        if (i.getIndex()==2){
            if (x<=1){x=2;}
            if(x>=20){x=19;}
           if (x>0){m1=x;n1=y+2;
            m2=x+1;n2=y+1;
            m3=x;n3=y+1;
            m4=x-1;n4=y+1;
            }
        }
        if (i.getIndex()==3){

           if (x<=0){x=1;}
            m1=x+1;n1=y+1;
            m2=x;n2=y;
            m3=x;n3=y+1;
            m4=x;n4=y+2;

        }

    }
    public void remove0_mirrorT(){

           value.removevalue(x, y);
           value.removevalue(x - 1, y + 1);
           value.removevalue(x, y + 1);
           value.removevalue(x + 1, y + 1);

    }
    public void remove1_mirrorT(){
        value.removevalue(x-1,y+1);
        value.removevalue(x,y+2);
        value.removevalue(x,y+1);
        value.removevalue(x,y);
    }
    public void remove2_mirrorT(){


        value.removevalue(x,y+2);
        value.removevalue(x+1,y+1);
        value.removevalue(x,y+1);
        value.removevalue(x-1,y+1);
    }
    public void remove3_mirrorT(){
        value.removevalue(x+1,y+1);
        value.removevalue(x,y);
        value.removevalue(x,y+1);
        value.removevalue(x,y+2);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
//          \\\\\\\\        \\============\\          \\          \\       // \\       ||========\\      \\=======
//           \\             \\             \\          \\         \\       //  \\      ||        \\      \\
//            \\\\\\\        \\            \\          \\          \\     //====\\     ||======= \\       \\======
//                  \\       \\            \\          \\           \\   //     \\     ||\\               \\
//             \\\\\\\\      \\============\\           \\===========\\ //        \\   || \\              \\======
//                                          \\
//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------


    public void makeSQUARE() {
        setcoordinatesSQUARE();
        l1 = drawRectangle(u1, v1);
        l2 = drawRectangle(u2, v2);
        l3 = drawRectangle(u3, v3);
        l4 = drawRectangle(u4, v4);
        setValueSQUARE();

        root.getChildren().add(l1);
        root.getChildren().add(l2);
        root.getChildren().add(l3);
        root.getChildren().add(l4);
        timerX.start();//Start the timer here
        running = true;
    }
    public void setValueSQUARE(){
        value.setvalue(u1,v1);
        value.setvalue(u2,v2);
        value.setvalue(u3,v3);
        value.setvalue(u4,v4);
    }
    public void setcoordinatesSQUARE(){
        if (i.getIndex()==0) {
            if(x>=20){x=19;}
               u1 = x;v1 = y;
               u2 = x + 1;v2 = y;
               u3=x+1;    v3=y+1;
               u4=x;      v4=y+1;}
        if (i.getIndex()==1){
            if(x>=20){x=19;}
            u1=x;       v1=y+2;
            u2=x+1;     v2=y+2;
            u3=x+1;     v3=y+1;
            u4=x;       v4=y+1;
        }
        if (i.getIndex()==2){
            if(x>=19){x=18;}
            u1=x+2;     v1=y+2;
            u2=x+2;     v2=y+1;
            u3=x+1;     v3=y+1;
            u4=x+1;     v4=y+2;
        }
        if (i.getIndex()==3){
            if(x>=19){x=18;}
            u1=x+2;     v1=y;
            u2=x+1;     v2=y;
            u3=x+1;     v3=y+1;
            u4=x+2;     v4=y+1;
        }


    }
    public void remove0SQUARE(){
        value.removevalue(x,y);
        value.removevalue(x+1,y);
        value.removevalue(x+1,y+1);
        value.removevalue( x,y+1);
    }
    public void remove1SQUARE(){
        value.removevalue(x,y+2);
        value.removevalue(x+1,y+2);
        value.removevalue(x+1,y+1);
        value.removevalue(x,y+1);
    }
    public void remove2SQUARE(){
        value.removevalue(x+2,y+2);
        value.removevalue(x+2,y+1);
        value.removevalue(x+1,y+1);
        value.removevalue(x+1,y+2);
    }
    public void remove3SQUARE(){
        value.removevalue(x+2,y);
        value.removevalue(x+1,y);
        value.removevalue(x+1,y+1);
        value.removevalue(x+2,y+1);
    }


//------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------
//                            ||         ========     ||\\   ||     ||========
//                            ||            ||        || \\  ||     ||=====
//                            ||=====    ========     ||  \\ ||     ||========
//---------------------------------------------------------------------------------------------------------------------
    public void makeLINE() {
        setcoordinatesLINE();
        l1 = drawRectangle(e1, f1);
        l2 = drawRectangle(e2, f2);
        l3 = drawRectangle(e3, f3);
        l4 = drawRectangle(e4, f4);
        setValueLINE();

        root.getChildren().add(l1);
        root.getChildren().add(l2);
        root.getChildren().add(l3);
        root.getChildren().add(l4);
        timerX.start();//Start the timer here
        running = true;
    }
    public void setValueLINE(){
        value.setvalue(e1,f1);
        value.setvalue(e2,f2);
        value.setvalue(e3,f3);
        value.setvalue(e4,f4);
    }
    public void setcoordinatesLINE(){

        if (i.getIndex()==0){
            e1=x;      f1=y;
            e2=x;    f2=y+1;
            e3=x;    f3=y+2;
            e4=x;      f4=y+3;}
        if (i.getIndex()==1){
            if (x>=20){x=19;}
            if (x<=2){x=3;}
            e1=x-2;       f1=y+2;
            e2=x-1;     f2=y+2;
            e3=x;     f3=y+2;
            e4=x+1;       f4=y+2;
        }
        if (i.getIndex()==2){
            if (x<=0){x=1;}
            e1=x;     f1=y+4;
            e2=x;     f2=y+3;
            e3=x;     f3=y+2;
            e4=x;     f4=y+1;
        }
        if (i.getIndex()==3){
            if (x<=1){x=2;}
            if (x>=19){x=18;}
            e1=x+2;     f1=y+2;
            e2=x+1;     f2=y+2;
            e3=x;       f3=y+2;
            e4=x-1;     f4=y+2;
        }
       }
    public void remove0LINE(){
        value.removevalue(x,y);
        value.removevalue(x,y+1);
        value.removevalue(x,y+2);
        value.removevalue( x,y+3);
    }
    public void remove1LINE(){
            value.removevalue(x - 2, y + 2);
            value.removevalue(x - 1, y + 2);
            value.removevalue(x, y + 2);
            value.removevalue(x + 1, y + 2);
    }
    public void remove2LINE(){
        value.removevalue(x,y+4);
        value.removevalue(x,y+3);
        value.removevalue(x,y+2);
        value.removevalue(x,y+1);
    }
    public void remove3LINE(){
        value.removevalue(x+2,y+2);
        value.removevalue(x+1,y+2);
        value.removevalue(x,y+2);
        value.removevalue(x-1,y+2);
    }
//----------------------------------------------------------------------------------------------------------------------------

}

