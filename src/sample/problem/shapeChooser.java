package sample.problem;

import java.util.Random;

public class shapeChooser {
    int input=0;
    Random rn =new Random();
    private static String shape;
    public String shapechoser() {
        input= rn.nextInt(5);



        return switch (input) {
            case 0 -> "L";
            case 1 -> "Z";
            case 2 -> "MIRROR_T";
            case 3 ->  "SQUARE";
            case 4->"LINE";
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }
   public void setShape(){
           shape=shapechoser();
   }
   public String getShape(){
        return shape;
   }

}
