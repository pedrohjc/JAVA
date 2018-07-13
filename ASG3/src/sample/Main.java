
package sample;
/**********************************************

 Workshop #3

 Course: JAC444 - 4th

 Last Name: Carvalho

 First Name: Pedro Henrique

 ID: 118495167

 Section: SCD

 This assignment represents my own work in accordance with Seneca Academic Policy.

 Pedro Henrique Carvalho
 Date:12/07/2018

 **********************************************/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.CharacterStringConverter;

import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.*;

public class Main extends Application {

    TextField nameLabel = new TextField();
    TextField streetfield = new TextField();
    TextField cityLabel = new TextField();
    TextField StateLabel = new TextField();
    TextField zipLabel = new TextField();

    private static final int record = 100;
    String bName = "Null";
    String bStreet="Null",bCity="Null",bState="Null", bZip="Null";

    @Override
    public void start(Stage primaryStage) throws Exception{




        //Creating the GRID
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(1);
        grid.setVgap(1);
        //grid.setPadding(new Insets(25,25,25,25));
        Scene scene = new Scene(grid, 700, 200);

        //Creating the fields
        Text intro = new Text("Please enter the information ");
        intro.setFont(Font.font("Tahoma",FontWeight.NORMAL, 20));

        Label Name = new Label("Name");

        nameLabel.setPrefWidth(35);

        Label Street = new Label("Street ");


        Label city = new Label("City");


        cityLabel.setPrefWidth(20);
        Label state = new Label("     State");


        StateLabel.setPrefColumnCount(1);
        //StateLabel.setAlignment(Pos.CENTER);
        Label zip = new Label("   zip");


        //Creating the buttons
        Button add = new Button("Add");
        Button First = new Button("First");
        Button Next = new Button("Next");
        Button Previous = new Button("Previous");
        Button Last = new Button("Last");
        Button Update = new Button("Update");

        //Setting the places
        grid.add(intro,0,0,2,1);

        grid.add(Name,0,1);
        grid.add(nameLabel, 1,1,3,1);

        grid.add(Street,0,2);
        grid.add(streetfield,1,2,3,1);

        grid.add(city,0,3);
        grid.add(cityLabel,1,3);

        grid.add(state,2,3);
        grid.add(StateLabel,3,3);

        grid.add(zip,4,3);
        grid.add(zipLabel,5,3);

        //Add the Buttons
        grid.add(add,0,4);
        grid.add(First,1,4);
        grid.add(Previous,2,4);
        grid.add(Next,3,4);
        grid.add(Last,4,4);
        grid.add(Update,5,4);


        //Make the border of the grid visible(Bool)
        grid.setGridLinesVisible(true);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                actiontarget.setFill(Color.FIREBRICK);
                //actiontarget.setText("Add button pressed");
                //boolean flag = false;
                //do {
                    if (nameLabel.getText().isEmpty()) {
                        actiontarget.setText("Please enter your Name");
                        System.out.println("Form Error! Please enter your name");
                    }
                    else if (streetfield.getText().isEmpty()) {
                        actiontarget.setText("Please enter your Street");
                        System.out.println("Form Error! Please enter your Street");
                    }
                    else if (cityLabel.getText().isEmpty()) {
                        actiontarget.setText("Please enter your City");
                        System.out.println("Form Error! Please enter your City");
                    }
                    else if (StateLabel.getText().isEmpty()) {
                        actiontarget.setText("Please enter your State");
                        System.out.println("Form Error! Please enter your State/Province");
                    }
                    else if (zipLabel.getText().isEmpty()) {
                        actiontarget.setText("Please enter your Zip Code");
                        System.out.println("Form Error! Please enter your Zip");
                    } else {
                        actiontarget.setText("Registration Complete!");
                        //System.out.println("No Errors! Registration Confirmed");
                        JOptionPane.showMessageDialog(null, "No Errors! Registration Confirmed");
                        //flag = true;
                    }
                try {
                    RAccessWrite(nameLabel.getText(), streetfield.getText(),cityLabel.getText(), StateLabel.getText(),
                             zipLabel.getText());
                    RAccessRead();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    System.out.println("Error to getText() --> " + e1);
                }
            }
        });

        First.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                    RAccessRead();
                }catch (IOException e1){
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });

        Next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                    int temp = 0;

                    RAccessRead();

                }catch (IOException e1){
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });

        Update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                    RandomAccessFile random = new RandomAccessFile("dataform.dat", "r");
                    if (nameLabel.getText().isEmpty()) {
                        actiontarget.setText("Please enter your Name");
                        System.out.println("Form Error! Please enter your name");
                    }
                    else if (streetfield.getText().isEmpty()) {
                        actiontarget.setText("Please enter your Street");
                        System.out.println("Form Error! Please enter your Street");
                    }
                    else if (cityLabel.getText().isEmpty()) {
                        actiontarget.setText("Please enter your City");
                        System.out.println("Form Error! Please enter your City");
                    }
                    else if (StateLabel.getText().isEmpty()) {
                        actiontarget.setText("Please enter your State");
                        System.out.println("Form Error! Please enter your State/Province");
                    }
                    else if (zipLabel.getText().isEmpty()) {
                        actiontarget.setText("Please enter your Zip Code");
                        System.out.println("Form Error! Please enter your Zip");
                    } else {
                        actiontarget.setText("Registration Complete!");
                        //System.out.println("No Errors! Registration Confirmed");
                        JOptionPane.showMessageDialog(null, "No Errors!Update Completed");
                        //flag = true;
                    }
                    RAccessWrite(nameLabel.getText(), streetfield.getText(),cityLabel.getText(), StateLabel.getText(),
                            zipLabel.getText());
                }catch (IOException e1){
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        primaryStage.setTitle("Address Book");
        primaryStage.setScene(scene);
        primaryStage.show();

    }



    public void RAccessWrite(String vname,String vsteet, String vcity, String vstate, String vzip) throws IOException {
        //write to a random access file

        try {
            RandomAccessFile random = new RandomAccessFile("dataform.dat", "rw");
            System.out.println("Writing to the file!");
            long fileSize = 0;
            fileSize = random.length();
            random.seek(fileSize);

            random.writeUTF(vname);
            for(int i = 0; i  < 20 - vname.length(); i++){
                random.writeByte(20); }

            random.writeUTF(vsteet);
            for(int i = 0; i  < 20 - vsteet.length(); i++){
                random.writeByte(20); }


            random.writeUTF(vcity);
            for(int i = 0; i  < 20 - vcity.length(); i++){
                random.writeByte(20); }


            random.writeUTF(vstate);
            for(int i = 0; i  < 20 - vstate.length(); i++){
                random.writeByte(20);}


            random.writeUTF(vzip);
            for(int i = 0; i  < 20 - vzip.length(); i++){
                random.writeByte(20); }

            //random.writeUTF("\n");

            System.out.println("Finished writing!");

            random.close();
        }catch (IOException e){
            System.out.println("Can't read the FILE!" + e);
        }
    }

    public void RAccessRead() throws IOException {


        System.out.println("Beginning to read!");
        try {
            RandomAccessFile rand0m = new RandomAccessFile("dataform.dat", "r");
            long fileSize = rand0m.length();
            long NUMrecords = fileSize/record;
            rand0m.seek(0);
            for(int j = 0; j < NUMrecords; j++) {
                bName = rand0m.readUTF();
                for (int i = 0; i < 20 - bName.length(); i++) {
                    rand0m.readByte();
                }
                bStreet = rand0m.readUTF();
                for (int i = 0; i < 20 - bStreet.length(); i++) {
                    rand0m.readByte();
                }
                bCity = rand0m.readUTF();
                for (int i = 0; i < 20 - bCity.length(); i++) {
                    rand0m.readByte();
                }
                bState = rand0m.readUTF();
                for (int i = 0; i < 20 - bState.length(); i++) {
                    rand0m.readByte();
                }
                bZip = rand0m.readUTF();
                for (int i = 0; i < 20 - bZip.length(); i++) {
                    rand0m.readByte();
                }
            }
//            System.out.println("\n\n\nName:" + bName + "  Street: " + bStreet +
//                    " City" + bCity +"\n\n\n");
            JOptionPane.showMessageDialog(null, "Name:" + bName + "\nStreet: " + bStreet +
                    "\nCity: " + bCity);
            rand0m.close();
//            nameLabel.setText(rand0m.readUTF());
        }catch(EOFException e1){
            System.out.println("Error - EOF");
        }

    }



    public static void main(String[] args) {
        launch(args);
    }
}
