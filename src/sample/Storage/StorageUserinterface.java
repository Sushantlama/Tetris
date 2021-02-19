package sample.Storage;
import sample.userinterface.userinterface;

import java.io.*;

public class StorageUserinterface {
    private static File gameData=new File("gamedata.txt");

    public void updateGameData(userinterface userData){
        FileOutputStream out= null;
        try {
            out = new FileOutputStream(gameData);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(out);
            objectOutputStream.writeObject(userData);
            objectOutputStream.close();
            System.out.println("sucessfully loaded");

        } catch (FileNotFoundException e) {
            System.out.println("file not found in your directory");
        }
       catch (IOException e) {
           System.out.println("there is an error in your game ,please restart the game");
        }
    }
    public userinterface getGameData() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(gameData);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            userinterface gameState = (userinterface) objectInputStream.readObject();
            objectInputStream.close();
            return gameState;
        } catch (ClassNotFoundException e) {
            throw new IOException("File Not Found");
        }
    }




}
