package sample.problem;
import javafx.stage.Stage;
import sample.userinterface.INPUT;
import sample.userinterface.userinterface;


public class gameLogic {

    INPUT i =new INPUT();
    shapeChooser shapeChooser=new shapeChooser();

        double [][]square=new double[100][100];

        public Boolean ForCompletion(int a1,int b1,int a2,int b2,int a3,int b3,int a4,int b4){
         if (b1<=2||b2<=2||b3<=2||b4<=2)  {return true;}
         else {return false;}

        }




        public gameLogic(){
            for (int i=0;i<square.length;i++){
                for (int j=0;j<square.length;j++){
                    square[i][j]=0;
                    if (i==0){square[i][j]=1;}
                   if (i==21){ square[i][j]=1; }
                   if (j==20){square[i][j]=1;}
                }
            }
        }


        public void setvalue(int a,int b){
            square[a][b]=1;
        }

        public double[][] getSquare(){
            return square;
        }

        public void removevalue(int a,int b){
            square[a][b]=0;
        }





        public  boolean CheckBottom(int a1,int b1,int a2,int b2,int a3,int b3,int a4,int b4){

if (shapeChooser.getShape()=="L"){
                                                if (i.getIndex()==0)           {if (square[a4][b4+1]==0&square[a2][b2+1]==0&square[a3][b3+1]==0){return true; }
                                                                                else {return false;}}
                                                else if(i.getIndex()==1)       {if (square[a1][b1+1]==0&square[a2][b2+1]==0){return true;}
                                                                                else {return false;} }
                                                 else if(i.getIndex()==2)      {if (square[a1][b1+1]==0&square[a3][b3+1]==0&square[a4][b4+1]==0){return true;}
                                                                                else {return false;} }
                                                else if(i.getIndex()==3)       { if (square[a1][b1+1]==0&square[a4][b4+1]==0){return true;}
                                                                                 else {return false;} }
                                                 else{ return false;}}
else if (shapeChooser.getShape()=="Z"){
                                                if (i.getIndex()==0){              if (square[a1][b1+1]==0&square[a3][b3+1]==0&square[a4][b4+1]==0){return true;}
                                                                                       else{return false;}}
                                                else if (i.getIndex()==1){         if (square[a1][b1+1]==0&square[a3][b3+1]==0){return true;}
                                                                                      else{return false;}}
                                                else if (i.getIndex()==2){  if (square[a1][b1+1]==0&square[a2][b2+1]==0&square[a4][b4+1]==0){return true;}
                                                                                       else{return false;}}
                                                else if (i.getIndex()==3){  if (square[a2][b2+1]==0&square[a4][b4+1]==0){return true;}
                                                                                        else{return false;}}

                                                else {return false;}
         }
else if (shapeChooser.getShape()=="MIRROR_T"){
                                                if (i.getIndex()==0){              if (square[a2][b2+1]==0&square[a3][b3+1]==0&square[a4][b4+1]==0){return true;}
                                                                                                 else{return false;}}
                                                else if (i.getIndex()==1){         if (square[a1][b1+1]==0&square[a2][b2+1]==0){return true;}
                                                                                               else{return false;}}
                                                else if (i.getIndex()==2){        if (square[a1][b1+1]==0&square[a2][b2+1]==0&square[a4][b4+1]==0){return true;}
                                                                                                 else{return false;}}
                                                else if (i.getIndex()==3){       if (square[a1][b1+1]==0&square[a4][b4+1]==0){return true;}
                                                                                              else{return false;}}

                                                else {return false;}

}
else if (shapeChooser.getShape()=="SQUARE"){
                                                if (i.getIndex()==0){              if (square[a3][b3+1]==0&square[a4][b4+1]==0){return true;}
                                                                                                   else{return false;}}
                                                else if (i.getIndex()==1){         if (square[a1][b1+1]==0&square[a2][b2+1]==0){return true;}
                                                                                                   else{return false;}}
                                                else if (i.getIndex()==2){        if (square[a1][b1+1]==0&square[a4][b4+1]==0){return true;}
                                                                                                   else{return false;}}
                                                else if (i.getIndex()==3){       if (square[a3][b3+1]==0&square[a4][b4+1]==0){return true;}
                                                                                                  else{return false;}}

    else {return false;}

}
else if (shapeChooser.getShape()=="LINE"){
                                                if (i.getIndex()==0){              if (square[a4][b4+1]==0){return true;}
                                                                                                 else{return false;}}
                                                else if (i.getIndex()==1){         if (square[a1][b1+1]==0&square[a2][b2+1]==0&square[a3][b3+1]==0&square[a4][b4+1]==0){return true;}
                                                                                                 else{return false;}}
                                                else if (i.getIndex()==2){        if (square[a1][b1+1]==0){return true;}
                                                                                               else{return false;}}
                                                else if (i.getIndex()==3){       if (square[a3][b3+1]==0&square[a4][b4+1]==0&square[a1][b1+1]==0&square[a2][b2+1]==0){return true;}
                                                                                             else{return false;}}

    else {return false;}

}
 else {return false;}
        }



        public  boolean CheckLeft(int a1,int b1,int a2,int b2,int a3,int b3,int a4,int b4){

if (shapeChooser.getShape()=="L"){
                                                if (i.getIndex()==0)                  { if (square[a1-1][b1]==0&square[a2-1][b2]==0){return true;}
                                                                                                               else {return false;}}
                                                 else if(i.getIndex()==1)             { if (square[a1-1][b1]==0&square[a3-1][b3]==0&square[a4-1][b4]==0){return true;}
                                                                                                               else {return false;} }
                                                 else if(i.getIndex()==2)             { if (square[a1-1][b1]==0&square[a4-1][b4]==0){return true;}
                                                                                                                else {return false;} }
                                                else if(i.getIndex()==3)              { if (square[a2-1][b2]==0&square[a3-1][b3]==0&square[a4-1][b4]==0){return true;}
                                                                                                                else {return false;} }
                                                else{ return false;}
         }
else if (shapeChooser.getShape()=="Z"){
                                                if (i.getIndex()==0){                  if (square[a1-1][b1]==0&square[a3-1][b3]==0){return true;}
                                                                                                                  else {return false;}  }
                                                else if(i.getIndex()==1)             { if (square[a1-1][b1]==0&square[a2-1][b2]==0&square[a4-1][b4]==0){return true;}
                                                                                                                 else {return false;} }
                                                else if(i.getIndex()==2)             { if (square[a4-1][b4]==0&square[a2-1][b2]==0){return true;}
                                                                                                                else {return false;} }
                                                else if(i.getIndex()==3)             { if (square[a4-1][b4]==0&square[a3-1][b3]==0&square[a1-1][b1]==0){return true;}
                                                                                                                 else {return false;} }
                                                else {return false;} }
else if (shapeChooser.getShape()=="MIRROR_T"){
                                                if (i.getIndex()==0){                  if (square[a1-1][b1]==0&square[a2-1][b2]==0){return true;}
                                                                                                    else {return false;}  }
                                                else if(i.getIndex()==1)             { if (square[a1-1][b1]==0&square[a2-1][b2]==0&square[a4-1][b4]==0){return true;}
                                                                                                     else {return false;} }
                                                else if(i.getIndex()==2)             { if (square[a4-1][b4]==0&square[a1-1][b1]==0){return true;}
                                                                                                    else {return false;} }
                                                else if(i.getIndex()==3)             { if (square[a4-1][b4]==0&square[a3-1][b3]==0&square[a2-1][b2]==0){return true;}
                                                                                                   else {return false;} }
                                                else {return false;}}
else if (shapeChooser.getShape()=="SQUARE"){
                                                if (i.getIndex()==0){                  if (square[a1-1][b1]==0&square[a4-1][b4]==0){return true;}
                                                                                       else {return false;}  }
                                                else if(i.getIndex()==1)             { if (square[a1-1][b1]==0&square[a4-1][b4]==0){return true;}
                                                                                         else {return false;} }
                                                else if(i.getIndex()==2)             { if (square[a4-1][b4]==0&square[a3-1][b3]==0){return true;}
                                                                                        else {return false;} }
                                                else if(i.getIndex()==3)             { if (square[a3-1][b3]==0&square[a2-1][b2]==0){return true;}
                                                                                        else {return false;} }
                                                else {return false;}}
else if (shapeChooser.getShape()=="LINE"){

                                                if (i.getIndex()==0){                  if (square[a1-1][b1]==0&square[a4-1][b4]==0&square[a3-1][b3]==0&square[a2-1][b2]==0){return true;}
                                                                                         else {return false;}  }
                                                else if(i.getIndex()==1)             { if (square[a1-1][b1]==0){return true;}
                                                                                          else {return false;} }
                                                else if(i.getIndex()==2)             { if (square[a1-1][b1]==0&square[a4-1][b4]==0&square[a3-1][b3]==0&square[a2-1][b2]==0){return true;}
                                                                                          else {return false;} }
                                                else if(i.getIndex()==3)             { if (square[a4-1][b4]==0){return true;}
                                                                                           else {return false;} }
                                                else {return false;}}

 else {return false;}

        }



        public  boolean CheckRight(int a1,int b1,int a2,int b2,int a3,int b3,int a4,int b4){

 if (shapeChooser.getShape()=="L"){
                                                if (i.getIndex()==0)                             {if (square[a1+1][b1]==0&square[a4+1][b2]==0){return true;}
                                                                                                     else {return false;}}
                                                else if(i.getIndex()==1)                        { if (square[a2+1][b2]==0&square[a3+1][b3]==0&square[a4+1][b4]==0){return true;}
                                                                                                  else {return false;} }
                                                else if(i.getIndex()==2)                         { if (square[a2+1][b2]==0&square[a1+1][b1]==0){return true;}
                                                                                                   else {return false;} }
                                                else if(i.getIndex()==3)                        { if (square[a1+1][b1]==0&square[a3+1][b3]==0&square[a4+1][b4]==0){return true;}
                                                                                                   else {return false;} }
                                                else {return  false;}
                                                        }
else if(shapeChooser.getShape()=="Z"){
                                                if (i.getIndex()==0)                             {if (square[a2+1][b2]==0&square[a4+1][b4]==0){return true;}
                                                                                                                    else {return false;} }
                                                else if (i.getIndex()==1)                         {if (square[a4+1][b4]==0&square[a3+1][b3]==0&square[a1+1][b1]==0){return true;}
                                                                                                                   else {return false;}}
                                                else if (i.getIndex()==2)                         {if (square[a3+1][b3]==0&square[a1+1][b1]==0){return true;}
                                                                                                                   else {return false;}}
                                                else if (i.getIndex()==3)                         {if (square[a4+1][b4]==0&square[a2+1][b2]==0&square[a1+1][b1]==0){return true;}
                                                                                                                   else {return false;}}
                                                else{return false;}

}
 else if(shapeChooser.getShape()=="MIRROR_T"){
                                                 if (i.getIndex()==0)                             {if (square[a1+1][b1]==0&square[a4+1][b4]==0){return true;}
                                                                                                      else {return false;} }
                                                 else if (i.getIndex()==1)                         {if (square[a4+1][b4]==0&square[a3+1][b3]==0&square[a2+1][b2]==0){return true;}
                                                                                                      else {return false;}}
                                                 else if (i.getIndex()==2)                         {if (square[a2+1][b2]==0&square[a1+1][b1]==0){return true;}
                                                                                                       else {return false;}}
                                                 else if (i.getIndex()==3)                         {if (square[a4+1][b4]==0&square[a2+1][b2]==0&square[a1+1][b1]==0){return true;}
                                                                                                      else {return false;}}
                                                 else{return false;}

 }
 else if(shapeChooser.getShape()=="SQUARE"){
                                                 if (i.getIndex()==0)                             {if (square[a2+1][b2]==0&square[a3+1][b3]==0){return true;}
                                                                                                            else {return false;} }
                                                 else if (i.getIndex()==1)                         {if (square[a3+1][b3]==0&square[a2+1][b2]==0){return true;}
                                                                                                            else {return false;}}
                                                 else if (i.getIndex()==2)                         {if (square[a2+1][b2]==0&square[a1+1][b1]==0){return true;}
                                                                                                             else {return false;}}
                                                 else if (i.getIndex()==3)                         {if (square[a4+1][b4]==0&square[a1+1][b1]==0){return true;}
                                                                                                             else {return false;}}
                                                 else{return false;}
                                                 }
 else if(shapeChooser.getShape()=="LINE"){
                                                 if (i.getIndex()==0)                             {if (square[a2+1][b2]==0&square[a3+1][b3]==0&square[a1+1][b1]==0&square[a4+1][b4]==0){return true;}
                                                                                                               else {return false;} }
                                                 else if (i.getIndex()==1)                         {if (square[a4+1][b4]==0){return true;}
                                                                                                                else {return false;}}
                                                 else if (i.getIndex()==2)                         {if (square[a2+1][b2]==0&square[a3+1][b3]==0&square[a1+1][b1]==0&square[a4+1][b4]==0){return true;}
                                                                                                                else {return false;}}
                                                 else if (i.getIndex()==3)                         {if (square[a1+1][b1]==0){return true;}
                                                                                                                else {return false;}}
                                                 else{return false;}
 }
                                                 else {return false;}

        }




        public  boolean CheckRotation(int a1,int b1,int a2,int b2,int a3,int b3,int a4,int b4){
if (shapeChooser.getShape()=="L"){
                                                if (i.getIndex()==0){                         if (square[a3][b3+1]==0&square[a3][b3-1]==0&square[a3-1][b3+1]==0&square[a3+1][b3-1]==0&square[a3+1][b3+1]==0){ return true;}
                                                                                             else { return false;} }
                                                else if (i.getIndex()==1){
                                                                                              if (square[a3-1][b3]==0&square[a3+1][b3]==0&square[a3-1][b3-1]==0&square[a3+1][b3-1]==0&square[a3+1][b3+1]==0){ ;return true;}
                                                                                            else { return false;} }
                                                else if (i.getIndex()==2){                   if (square[a3-1][b3+1]==0&square[a3+1][b3-1]==0&square[a3-1][b3-1]==0&square[a3][b3-1]==0&square[a3][b3+1]==0){ ;return true;}
                                                                                             else { return false;} }
                                                else if (i.getIndex()==3){
                                                                                            if (square[a3-1][b3+1]==0&square[a3-1][b3-1]==0&square[a3-1][b3]==0&square[a3+1][b3]==0&square[a3+1][b3+1]==0){ return true;}
                                                                                             else { return false;} }
                                                else { return false;}

                                                       }
else if(shapeChooser.getShape()=="Z"){
                                                 if (i.getIndex()==0){                         if (square[a3][b3+1]==0&square[a3-1][b3]==0&square[a3-1][b3+1]==0&square[a3+1][b3-1]==0&square[a3+1][b3+1]==0){ return true;}
                                                                                              else { return false;} }
                                                if (i.getIndex()==1){                      if (square[a3][b3+1]==0&square[a3-1][b3-1]==0&square[a3+1][b3+1]==0&square[a3+1][b3-1]==0&square[a3+1][b3]==0){ return true;}
                                                                                               else { return false;} }
                                                if (i.getIndex()==2){                         if (square[a3][b3-1]==0&square[a3-1][b3-1]==0&square[a3+1][b3-1]==0&square[a3-1][b3+1]==0&square[a3+1][b3]==0){ return true;}
                                                                                                else { return false;} }
                                                if (i.getIndex()==3){                         if (square[a3-1][b3]==0&square[a3-1][b3+1]==0&square[a3-1][b3-1]==0&square[a3][b3-1]==0&square[a3+1][b3+1]==0){ return true;}
                                                                                                else { return false;} }

                                                else {return false;}
                                                }

else if(shapeChooser.getShape()=="MIRROR_T"){
                                                if (i.getIndex()==0){                         if (square[a3][b3+1]==0&square[a3-1][b3+1]==0&square[a3-1][b3-1]==0&square[a3+1][b3-1]==0&square[a3+1][b3+1]==0){ return true;}
                                                                                                       else { return false;} }
                                                if (i.getIndex()==1){                      if (square[a3+1][b3+1]==0&square[a3+1][b3]==0&square[a3+1][b3-1]==0&square[a3-1][b3-1]==0&square[a3-1][b3+1]==0){ return true;}
                                                                                                         else { return false;} }
                                                if (i.getIndex()==2){                         if (square[a3][b3-1]==0&square[a3-1][b3-1]==0&square[a3+1][b3-1]==0&square[a3-1][b3+1]==0&square[a3+1][b3+1]==0){ return true;}
                                                                                                        else { return false;} }
                                                if (i.getIndex()==3){                         if (square[a3-1][b3]==0&square[a3-1][b3+1]==0&square[a3-1][b3-1]==0&square[a3+1][b3-1]==0&square[a3+1][b3+1]==0){ return true;}
                                                                                                       else { return false;} }

                                                else {return false;}
}
else if(shapeChooser.getShape()=="SQUARE"){
                                                if (i.getIndex()==0){                         if (square[a3+1][b3]==0&square[a3+1][b3+1]==0&square[a3+1][b3-1]==0&square[a3][b3+1]==0&square[a3-1][b3+1]==0){ return true;}
                                                                                                   else { return false;} }
                                                if (i.getIndex()==1){                      if (square[a3-1][b3-1]==0&square[a3][b3-1]==0&square[a3+1][b3-1]==0&square[a3+1][b3]==0&square[a3+1][b3+1]==0){ return true;}
                                                                                                  else { return false;} }
                                                if (i.getIndex()==2){                         if (square[a3-1][b3+1]==0&square[a3-1][b3]==0&square[a3-1][b3-1]==0&square[a3][b3-1]==0&square[a3+1][b3-1]==0){ return true;}
                                                                                                  else { return false;} }
                                                if (i.getIndex()==3){                         if (square[a3-1][b3-1]==0&square[a3-1][b3]==0&square[a3-1][b3+1]==0&square[a3][b3+1]==0&square[a3+1][b3+1]==0){ return true;}
                                                                                                   else { return false;} }

                                                else {return false;}


}
else if(shapeChooser.getShape()=="LINE"){
if (a3+2==0||a2+2==0||a1+2==0||a4-1==0||a4+2==0){
    if (i.getIndex()==0){                     if (square[a3-1][b3]==0&square[a3-1][b3-1]==0&square[a3-1][b3-2]==0&square[a3-1][b3+1]==0&square[a3+1][b3]==0&square[a3+1][b3-1]==0&square[a3+1][b3-2]==0&square[a3+1][b3+1]==0){ return true;}

    else { return false;} }
    if (i.getIndex()==1){                      if (square[a3][b3-2]==0&square[a3][b3-1]==0&square[a3][b3+1]==0&square[a2][b2-2]==0&square[a2][b2-1]==0&square[a2][b2+1]==0&square[a1][b1-2]==0&square[a1][b1-1]==0&square[a1][b1+1]==0&square[a4][b4-2]==0&square[a4][b4-1]==0&square[a4][b4+1]==0){ return true;}
    else { return false;} }
    if (i.getIndex()==2){                         if (square[a3-1][b3]==0&square[a3+1][b3]==0&square[a3+2][b3-1]==0&square[a2-1][b2]==0&square[a2+1][b2]==0&square[a2+2][b2-1]==0&square[a1-1][b1]==0&square[a1+1][b1]==0&square[a1+2][b1-1]==0&square[a4-1][b4]==0&square[a4+1][b4]==0&square[a4+2][b4-1]==0){ return true;}
    else { return false;} }
    if (i.getIndex()==3){                         if (square[a3][b3-2]==0&square[a3][b3-1]==0&square[a3][b3+1]==0&square[a1][b1-2]==0&square[a1][b1-1]==0&square[a1][b1+1]==0&square[a2][b2-2]==0&square[a2][b2-1]==0&square[a2][b2+1]==0&square[a4][b4-2]==0&square[a4][b4-1]==0&square[a4][b4+1]==0){ return true;}
    else { return false;} }

    else {return false;}
}







else{
                                                if (i.getIndex()==0){                     if (square[a3+1][b3]==0&square[a3+1][b3+1]==0&square[a3+1][b3-1]==0&square[a3+1][b3-2]==0&square[a3-1][b3]==0&square[a3-1][b3+1]==0&square[a3-1][b3-1]==0&square[a3-1][b3-2]==0&square[a3-2][b3]==0&square[a3-2][b3+1]==0&square[a3-2][b3-1]==0&square[a3-2][b3-2]==0){ return true;}

                                                                                                   else { return false;} }
                                                if (i.getIndex()==1){                      if (square[a3][b3-2]==0&square[a3][b3-1]==0&square[a3][b3+1]==0&square[a2][b2-2]==0&square[a2][b2-1]==0&square[a2][b2+1]==0&square[a1][b1-2]==0&square[a1][b1-1]==0&square[a1][b1+1]==0&square[a4][b4-2]==0&square[a4][b4-1]==0&square[a4][b4+1]==0){ return true;}
                                                                                                  else { return false;} }
                                                if (i.getIndex()==2){                         if (square[a3-1][b3]==0&square[a3+1][b3]==0&square[a3+2][b3-1]==0&square[a2-1][b2]==0&square[a2+1][b2]==0&square[a2+2][b2-1]==0&square[a1-1][b1]==0&square[a1+1][b1]==0&square[a1+2][b1-1]==0&square[a4-1][b4]==0&square[a4+1][b4]==0&square[a4+2][b4-1]==0){ return true;}
                                                                                                   else { return false;} }
                                                if (i.getIndex()==3){                         if (square[a3][b3-2]==0&square[a3][b3-1]==0&square[a3][b3+1]==0&square[a1][b1-2]==0&square[a1][b1-1]==0&square[a1][b1+1]==0&square[a2][b2-2]==0&square[a2][b2-1]==0&square[a2][b2+1]==0&square[a4][b4-2]==0&square[a4][b4-1]==0&square[a4][b4+1]==0){ return true;}
                                                                                                  else { return false;} }

                                                else {return false;}}
    }
else {return false;}




                                                }



public boolean check_square(int a,int b){
            if (square[a][b]==1){return true;}
            else {  return false;}
}


}


