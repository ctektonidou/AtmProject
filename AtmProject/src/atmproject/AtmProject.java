/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Chrysanthi
 */
public class AtmProject extends Application {

    String[][] loginNumbers = {{"11110000", "1234"},
    {"11110001", "5678"},
    {"11110002", "2345"}};

    Label welcomeLabel = new Label("Welcome");
    Label acountNumberLabel = new Label("Αριθμός λογαριασμού:");
    Label passwordLabel = new Label("Κωδικός:");
    Label endLabel = new Label("Γράψε Όνομα και Κωδικό");
    Label analipsiLabel = new Label("Επιλέξτε το ποσό για την ανάληψή σας:");
    Label katathesiLabel = new Label("Γράψτε το ποσό της κατάθεσής σας:");
    Label kiniseisLabel = new Label("Δείτε τις κινήσεις σας στο λογαριασμό 1111xxxx");

    TextField acountNumberText = new TextField("");
    TextField passwordText = new TextField("");
    TextField posoText = new TextField("");

    Button btnSign = new Button("Είσοδος");
    Button btnAnalipsi = new Button("Ανάληψη Χρημάτων");
    Button btnAn = new Button("Ανάληψη");
    Button btnKatathesi = new Button("Κατάθεση Χρημάτων");
    Button btnKat = new Button("Κατάθεση");
    Button btnKiniseis = new Button("Κινήσεις Χρημάτων");
    Button btnKin = new Button("Κινήσεις");
    Button btnEktiposi = new Button("Εκτύπωση Απόδειξης");
    Button btnMainMenu = new Button("Επιστροφή");
    Button btnOut = new Button("Αποσύνδεση");

    HBox epiloges = new HBox(10, btnAnalipsi, btnKatathesi, btnKiniseis);

    ToggleGroup rb = new ToggleGroup();

    RadioButton radioBtn100 = new RadioButton("100");
    RadioButton radioBtn200 = new RadioButton("200");
    RadioButton radioBtn300 = new RadioButton("300");
    RadioButton radioBtn400 = new RadioButton("400");

    String an = "";

    String data = "";

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setBackground(Background.EMPTY);//αν δεν υπήρχε αυτή η εντολή δεν μπορούσα να βάλω χρώμα

        welcomeLabel.setAlignment(Pos.TOP_LEFT);

        grid.add(welcomeLabel, 0, 0, 1, 1);
        welcomeLabel.setTextFill(Color.web("#FFFFFF"));
        welcomeLabel.setFont(Font.font ("Verdana", 20));

        grid.add(acountNumberLabel, 0, 1, 1, 1);
        acountNumberLabel.setTextFill(Color.web("#FFFFFF"));
        acountNumberLabel.setFont(Font.font ("Verdana", 15));

        grid.add(passwordLabel, 0, 2, 1, 1);
        passwordLabel.setTextFill(Color.web("#FFFFFF"));
        passwordLabel.setFont(Font.font ("Verdana", 15));

        grid.add(endLabel, 0, 3, 1, 1);
        endLabel.setTextFill(Color.web("#FFFFFF"));
        endLabel.setFont(Font.font ("Verdana", 15));

        grid.add(acountNumberText, 1, 1, 1, 1);

        grid.add(passwordText, 1, 2, 1, 1);

        grid.setHalignment(btnSign, HPos.RIGHT);
        grid.add(btnSign, 1, 3, 1, 1);

        Scene scene = new Scene(grid, 400, 375, Color.STEELBLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ATM");
        primaryStage.show();

        //Έλεγχος στοιχείων για είσοδο
        btnSign.setOnAction(e -> {

            String checkUser = acountNumberText.getText();
            String checkPa = passwordText.getText();

            if (checkUser.equals(loginNumbers[0][0]) && checkPa.equals(loginNumbers[0][1])) {
                primaryStage.hide();
                GridPane Pane2 = new GridPane();
                Pane2.setAlignment(Pos.CENTER);
                Pane2.setBackground(Background.EMPTY);
                Pane2.setHgap(10);
                Pane2.setVgap(10);
                Pane2.setPadding(new Insets(25, 25, 25, 25));
                
                Pane2.add(epiloges, 0, 1, 2, 2);
                
                Scene scene1 = new Scene(Pane2, 500, 300, Color.STEELBLUE);
                primaryStage.setTitle("Account Page"); // Set the stage title
                primaryStage.setScene(scene1); // Place the scene in the stage
                primaryStage.show(); // Display the stage

                //Επιλογή Ανάληψη Χρημάτων
                btnAnalipsi.setOnAction(e100 -> {

                    primaryStage.hide();
                    GridPane Pane3 = new GridPane();
                    Pane3.setAlignment(Pos.CENTER);
                    Pane3.setHgap(10);
                    Pane3.setVgap(10);
                    Pane3.setPadding(new Insets(26, 26, 26, 26));
                    Pane3.setBackground(Background.EMPTY);

                    radioBtn100.setToggleGroup(rb);
                    radioBtn200.setToggleGroup(rb);
                    radioBtn300.setToggleGroup(rb);
                    radioBtn400.setToggleGroup(rb);

                    Pane3.add(analipsiLabel, 0, 0, 1, 1);
                    analipsiLabel.setTextFill(Color.web("#FFFFFF"));
                    analipsiLabel.setFont(Font.font ("Verdana", 15));
                    VBox rbs = new VBox(10, radioBtn100, radioBtn200, radioBtn300, radioBtn400);

                    Pane3.add(rbs, 0, 1, 1, 1);
                    Pane3.add(btnMainMenu, 1, 2, 1, 1);
                    Pane3.add(btnEktiposi, 0, 3, 1, 1);
                    Pane3.add(btnAn, 0, 2, 1, 1);
                    Pane3.add(btnOut, 1, 3, 1, 1);
                    
                    btnOut.setPrefWidth(100);
                    btnMainMenu.setPrefWidth(100);
                    btnAn.setPrefWidth(200);
                    btnEktiposi.setPrefWidth(200);
                    
                    Pane3.setBackground(Background.EMPTY);
                    Pane3.setHalignment(btnMainMenu, HPos.CENTER);
                    Pane3.setHalignment(btnEktiposi, HPos.CENTER);
                    Pane3.setHalignment(btnAn, HPos.CENTER);
                    Pane3.setHalignment(btnOut, HPos.CENTER);

                    btnAn.setOnAction(e12 -> {
                        if (radioBtn100.isSelected()) {
                            an = "100";
                        }
                        if (radioBtn200.isSelected()) {
                            an = "200";
                        }
                        if (radioBtn300.isSelected()) {
                            an = "300";
                        }
                        if (radioBtn400.isSelected()) {
                            an = "400";
                        }

                        try {
                            FileWriter writer = new FileWriter("11110000.txt", true);
                            BufferedWriter bufferedWriter = new BufferedWriter(writer);//Γράφει κείμενο σε ροή εξόδου χαρακτήρων

                            bufferedWriter.write(LocalDate.now() + "    ΑΝΑΛΗΨΗ   " + an + "\n");

                            bufferedWriter.close();
                        } catch (IOException ex1) {
                            ex1.printStackTrace();
                        }

                    });

                    btnEktiposi.setOnAction(e11 -> {
                        String message = " *******************************\n"
                                + "Αριθμός λογαριασμού: 1111xxxx\n"
                                + "Τύπος Συναλλαγής: ΑΝΑΛΗΨΗ \n"
                                + "Ποσό: " + an + "\n"
                                + "Ημερομηνία: " + LocalDate.now() + "\n"
                                + "***********************************";
                        MessageBox.show(message, "Απόδειξη");
                    });
                    Scene scene100 = new Scene(Pane3, 600, 300, Color.STEELBLUE);
                    primaryStage.setTitle("ΑΝΑΛΗΨΗ ΧΡΗΜΑΤΩΝ"); // Set the stage title
                    primaryStage.setScene(scene100); // Place the scene in the stage
                    primaryStage.show(); // Display the stage
                });

                //Επιλογή Κατάθεση χρημάτων
                btnKatathesi.setOnAction(e101 -> {
                    primaryStage.hide();
                    GridPane Pane4 = new GridPane();
                    Pane4.setAlignment(Pos.CENTER);
                    Pane4.setHgap(10);
                    Pane4.setVgap(10);
                    Pane4.setPadding(new Insets(26, 26, 26, 26));
                    
                    Pane4.add(katathesiLabel, 0, 0, 1, 1);
                    katathesiLabel.setTextFill(Color.web("#FFFFFF"));
                    katathesiLabel.setFont(Font.font ("Verdana", 15));
                    
                    Pane4.add(posoText, 0, 1, 1, 1);
                    Pane4.add(btnKat, 0, 3, 1, 1);
                    Pane4.add(btnEktiposi, 0, 4, 1, 1);
                    Pane4.add(btnMainMenu, 1, 3, 1, 1);
                    Pane4.add(btnOut, 1, 4, 1, 1);
                    
                    btnOut.setPrefWidth(100);
                    btnMainMenu.setPrefWidth(100);
                    btnKat.setPrefWidth(200);
                    btnEktiposi.setPrefWidth(200);
                    
                    Pane4.setHalignment(btnKat, HPos.CENTER);
                    Pane4.setHalignment(btnMainMenu, HPos.CENTER);
                    Pane4.setHalignment(btnEktiposi, HPos.CENTER);
                    Pane4.setHalignment(btnOut, HPos.CENTER);
                    Pane4.setBackground(Background.EMPTY);

                    btnKat.setOnAction(e22 -> {
                        try {
                            FileWriter writer = new FileWriter("11110000.txt", true);
                            BufferedWriter bufferedWriter = new BufferedWriter(writer);

                            bufferedWriter.write(LocalDate.now() + "    ΚΑΤΑΘΕΣΗ   " + posoText.getText() + "\n");

                            bufferedWriter.close();
                        } catch (IOException ex1) {
                            ex1.printStackTrace();
                        }
                    });

                    btnEktiposi.setOnAction(e21 -> {
                        String message = " *******************************\n"
                                + "Αριθμός λογαριασμού: 1111xxxx\n"
                                + "Τύπος Συναλλαγής: ΚΑΤΑΘΕΣΗ \n"
                                + "Ποσό: " + posoText.getText() + "\n"
                                + "Ημερομηνία: " + LocalDate.now() + "\n"
                                + "***********************************";
                        MessageBox.show(message, "Απόδειξη");

                    });

                    Scene scene101 = new Scene(Pane4, 600, 300, Color.STEELBLUE);
                    primaryStage.setTitle("ΚΙΝΗΣΕΙΣ ΧΡΗΜΑΤΩΝ"); // Set the stage title
                    primaryStage.setScene(scene101); // Place the scene in the stage
                    primaryStage.show(); // Display the stage
                });

                //Επιλογή Κινήσεων Χρημάτων - Προβολή ιστορικού
                btnKiniseis.setOnAction(e102 -> {
                    primaryStage.hide();
                    GridPane Pane5 = new GridPane();
                    Pane5.setAlignment(Pos.CENTER);
                    Pane5.setHgap(10);
                    Pane5.setVgap(10);
                    Pane5.setPadding(new Insets(26, 26, 26, 26));
                    
                    Pane5.add(kiniseisLabel, 0, 1, 1, 1);
                    kiniseisLabel.setPrefWidth(500);
                    kiniseisLabel.setTextFill(Color.web("#FFFFFF"));
                    kiniseisLabel.setFont(Font.font ("Verdana", 20));
                    
                    Pane5.add(btnKin, 0, 2, 1, 1);
                    Pane5.add(btnOut,0,5,1,1);
                    Pane5.add(btnMainMenu, 0, 4, 1, 1);
                    
                    btnKin.setPrefWidth(200);
                    btnMainMenu.setPrefWidth(200);
                    btnOut.setPrefWidth(200);
                    
                    Pane5.setHalignment(btnMainMenu, HPos.CENTER);
                    Pane5.setHalignment(btnKin, HPos.CENTER);
                    Pane5.setHalignment(kiniseisLabel, HPos.CENTER);
                    Pane5.setHalignment(btnOut, HPos.CENTER);
                    Pane5.setBackground(Background.EMPTY);

                    btnKin.setOnAction(e31 -> {
                        try {
                            data = new String(Files.readAllBytes(Paths.get("11110000.txt")));
                            MessageBox.show(data, "Κινήσεις");
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }

                    });

                    Scene scene102 = new Scene(Pane5, 600, 300, Color.STEELBLUE);
                    primaryStage.setTitle("ΚΙΝΗΣΕΙΣ ΧΡΗΜΑΤΩΝ"); // Set the stage title
                    primaryStage.setScene(scene102); // Place the scene in the stage
                    primaryStage.show(); // Display the stage
                });

            }

            if (checkUser.equals(loginNumbers[1][0]) && checkPa.equals(loginNumbers[1][1])) {

                primaryStage.hide();
                GridPane Pane2 = new GridPane();
                Pane2.setAlignment(Pos.CENTER);
                Pane2.setHgap(10);
                Pane2.setVgap(10);
                Pane2.setPadding(new Insets(25, 25, 25, 25));
                
                Pane2.add(epiloges, 0, 1, 2, 2);
                
                Scene scene1 = new Scene(Pane2, 500, 300, Color.STEELBLUE);
                primaryStage.setTitle("Account Page"); // Set the stage title
                primaryStage.setScene(scene1); // Place the scene in the stage
                primaryStage.show(); // Display the stage
                Pane2.setBackground(Background.EMPTY);

                //Επιλογή Ανάληψη Χρημάτων
                btnAnalipsi.setOnAction(e200 -> {
                    primaryStage.hide();
                    GridPane Pane3 = new GridPane();
                    Pane3.setAlignment(Pos.CENTER);
                    Pane3.setHgap(10);
                    Pane3.setVgap(10);
                    Pane3.setPadding(new Insets(26, 26, 26, 26));
                    Pane3.setBackground(Background.EMPTY);

                    radioBtn100.setToggleGroup(rb);
                    radioBtn200.setToggleGroup(rb);
                    radioBtn300.setToggleGroup(rb);
                    radioBtn400.setToggleGroup(rb);

                    Pane3.add(analipsiLabel, 0, 0, 1, 1);
                    analipsiLabel.setTextFill(Color.web("#FFFFFF"));
                    analipsiLabel.setFont(Font.font ("Verdana", 15));
                    VBox rbs = new VBox(10, radioBtn100, radioBtn200, radioBtn300, radioBtn400);

                    Pane3.add(rbs, 0, 1, 1, 1);
                    Pane3.add(btnMainMenu, 1, 2, 1, 1);
                    Pane3.add(btnEktiposi, 0, 3, 1, 1);
                    Pane3.add(btnAn, 0, 2, 1, 1);
                    Pane3.add(btnOut, 1, 3, 1, 1);
                    
                    btnOut.setPrefWidth(100);
                    btnMainMenu.setPrefWidth(100);
                    btnAn.setPrefWidth(200);
                    btnEktiposi.setPrefWidth(200);

                    Pane3.setHalignment(btnMainMenu, HPos.CENTER);
                    Pane3.setHalignment(btnEktiposi, HPos.CENTER);
                    Pane3.setHalignment(btnAn, HPos.CENTER);
                    Pane3.setHalignment(btnOut, HPos.CENTER);

                    btnAn.setOnAction(e12 -> {
                        if (radioBtn100.isSelected()) {
                            an = "100";
                        }
                        if (radioBtn200.isSelected()) {
                            an = "200";
                        }
                        if (radioBtn300.isSelected()) {
                            an = "300";
                        }
                        if (radioBtn400.isSelected()) {
                            an = "400";
                        }

                        try {
                            FileWriter writer = new FileWriter("11110001.txt", true);
                            BufferedWriter bufferedWriter = new BufferedWriter(writer);

                            bufferedWriter.write(LocalDate.now() + "    ΑΝΑΛΗΨΗ   " + an + "\n");

                            bufferedWriter.close();
                        } catch (IOException ex1) {
                            ex1.printStackTrace();
                        }

                    });

                    btnEktiposi.setOnAction(e11 -> {
                        String message = " *******************************\n"
                                + "Αριθμός λογαριασμού: 1111xxxx\n"
                                + "Τύπος Συναλλαγής: ΑΝΑΛΗΨΗ \n"
                                + "Ποσό: " + an + "\n"
                                + "Ημερομηνία: " + LocalDate.now() + "\n"
                                + "***********************************";
                        MessageBox.show(message, "Απόδειξη");
                    });

                    Scene scene200 = new Scene(Pane3, 600, 300, Color.STEELBLUE);
                    primaryStage.setTitle("ΑΝΑΛΗΨΗ ΧΡΗΜΑΤΩΝ"); // Set the stage title
                    primaryStage.setScene(scene200); // Place the scene in the stage
                    primaryStage.show(); // Display the stage
                });

                //Επιλογή Κατάθεση χρημάτων
                btnKatathesi.setOnAction(e201 -> {
                    primaryStage.hide();
                    GridPane Pane4 = new GridPane();
                    Pane4.setAlignment(Pos.CENTER);
                    Pane4.setHgap(10);
                    Pane4.setVgap(10);
                    Pane4.setPadding(new Insets(26, 26, 26, 26));
                    
                    Pane4.add(katathesiLabel, 0, 0, 1, 1);
                    katathesiLabel.setTextFill(Color.web("#FFFFFF"));
                    katathesiLabel.setFont(Font.font ("Verdana", 15));
                    
                    Pane4.add(posoText, 0, 1, 1, 1);
                    Pane4.add(btnKat, 0, 3, 1, 1);
                    Pane4.add(btnEktiposi, 0, 4, 1, 1);
                    Pane4.add(btnMainMenu, 1, 3, 1, 1);
                    Pane4.add(btnOut, 1, 4, 1, 1);
                    
                    btnOut.setPrefWidth(100);
                    btnMainMenu.setPrefWidth(100);
                    btnKat.setPrefWidth(200);
                    btnEktiposi.setPrefWidth(200);
                    
                    Pane4.setHalignment(btnKat, HPos.CENTER);
                    Pane4.setHalignment(btnMainMenu, HPos.CENTER);
                    Pane4.setHalignment(btnEktiposi, HPos.CENTER);
                    Pane4.setHalignment(btnOut, HPos.CENTER);
                    Pane4.setBackground(Background.EMPTY);

                    btnKat.setOnAction(e22 -> {
                        try {
                            FileWriter writer = new FileWriter("11110001.txt", true);
                            BufferedWriter bufferedWriter = new BufferedWriter(writer);

                            bufferedWriter.write(LocalDate.now() + "    ΚΑΤΑΘΕΣΗ   " + posoText.getText() + "\n");

                            bufferedWriter.close();
                        } catch (IOException ex1) {
                            ex1.printStackTrace();
                        }
                    });

                    btnEktiposi.setOnAction(e21 -> {
                        String message = " *******************************\n"
                                + "Αριθμός λογαριασμού: 1111xxxx\n"
                                + "Τύπος Συναλλαγής: ΚΑΤΑΘΕΣΗ \n"
                                + "Ποσό: " + posoText.getText() + "\n"
                                + "Ημερομηνία: " + LocalDate.now() + "\n"
                                + "***********************************";
                        MessageBox.show(message, "Απόδειξη");
                    });

                    Scene scene201 = new Scene(Pane4, 600, 300, Color.STEELBLUE);
                    primaryStage.setTitle("ΚΑΤΑΘΕΣΗ ΧΡΗΜΑΤΩΝ"); // Set the stage title
                    primaryStage.setScene(scene201); // Place the scene in the stage
                    primaryStage.show(); // Display the stage
                });

                //Επιλογή Κινήσεων Χρημάτων - Προβολή ιστορικού
                btnKiniseis.setOnAction(e202 -> {
                    primaryStage.hide();
                    GridPane Pane5 = new GridPane();
                    Pane5.setAlignment(Pos.CENTER);
                    Pane5.setHgap(10);
                    Pane5.setVgap(10);
                    Pane5.setPadding(new Insets(26, 26, 26, 26));
                    
                    Pane5.add(kiniseisLabel, 0, 1, 1, 1);
                    kiniseisLabel.setPrefWidth(500);
                    kiniseisLabel.setTextFill(Color.web("#FFFFFF"));
                    kiniseisLabel.setFont(Font.font ("Verdana", 20));
                    
                    Pane5.add(btnKin, 0, 2, 1, 1);
                    Pane5.add(btnOut,0,5,1,1);
                    Pane5.add(btnMainMenu, 0, 4, 1, 1);
                    
                    btnKin.setPrefWidth(200);
                    btnMainMenu.setPrefWidth(200);
                    btnOut.setPrefWidth(200);
                    
                    Pane5.setHalignment(btnMainMenu, HPos.CENTER);
                    Pane5.setHalignment(btnKin, HPos.CENTER);
                    Pane5.setHalignment(kiniseisLabel, HPos.CENTER);
                    Pane5.setHalignment(btnOut, HPos.CENTER);
                    Pane5.setBackground(Background.EMPTY);

                    btnKin.setOnAction(e31 -> {
                        try {
                            data = new String(Files.readAllBytes(Paths.get("11110001.txt")));
                            MessageBox.show(data, "Κινήσεις");
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }

                    });

                    Scene scene202 = new Scene(Pane5, 600, 300, Color.STEELBLUE);
                    primaryStage.setTitle("ΚΙΝΗΣΕΙΣ ΧΡΗΜΑΤΩΝ"); // Set the stage title
                    primaryStage.setScene(scene202); // Place the scene in the stage
                    primaryStage.show(); // Display the stage
                });

            }

            if (checkUser.equals(loginNumbers[2][0]) && checkPa.equals(loginNumbers[2][1])) {
                primaryStage.hide();
                GridPane Pane2 = new GridPane();
                Pane2.setAlignment(Pos.CENTER);
                Pane2.setHgap(10);
                Pane2.setVgap(10);
                Pane2.setPadding(new Insets(26, 26, 26, 26));
                
                Pane2.add(epiloges, 0, 1, 2, 2);
                
                Scene scene1 = new Scene(Pane2, 600, 300, Color.STEELBLUE);
                primaryStage.setTitle("Account Page"); // Set the stage title
                primaryStage.setScene(scene1); // Place the scene in the stage
                primaryStage.show(); // Display the stage
                Pane2.setBackground(Background.EMPTY);

                //Επιλογή Ανάληψη Χρημάτων
                btnAnalipsi.setOnAction(e300 -> {
                    primaryStage.hide();
                    GridPane Pane3 = new GridPane();
                    Pane3.setAlignment(Pos.CENTER);
                    Pane3.setHgap(10);
                    Pane3.setVgap(10);
                    Pane3.setPadding(new Insets(26, 26, 26, 26));
                    Pane3.setBackground(Background.EMPTY);

                    radioBtn100.setToggleGroup(rb);
                    radioBtn200.setToggleGroup(rb);
                    radioBtn300.setToggleGroup(rb);
                    radioBtn400.setToggleGroup(rb);

                    Pane3.add(analipsiLabel, 0, 0, 1, 1);
                    analipsiLabel.setTextFill(Color.web("#FFFFFF"));
                    analipsiLabel.setFont(Font.font ("Verdana", 15));
                    VBox rbs = new VBox(10, radioBtn100, radioBtn200, radioBtn300, radioBtn400);

                    Pane3.add(rbs, 0, 1, 1, 1);
                    Pane3.add(btnMainMenu, 1, 2, 1, 1);
                    Pane3.add(btnEktiposi, 0, 3, 1, 1);
                    Pane3.add(btnAn, 0, 2, 1, 1);
                    Pane3.add(btnOut, 1, 3, 1, 1);
                    
                    btnOut.setPrefWidth(100);
                    btnMainMenu.setPrefWidth(100);
                    btnAn.setPrefWidth(200);
                    btnEktiposi.setPrefWidth(200);

                    Pane3.setHalignment(btnMainMenu, HPos.CENTER);
                    Pane3.setHalignment(btnEktiposi, HPos.CENTER);
                    Pane3.setHalignment(btnAn, HPos.CENTER);
                    Pane3.setHalignment(btnOut, HPos.CENTER);

                    btnAn.setOnAction(e12 -> {
                        if (radioBtn100.isSelected()) {
                            an = "100";
                        }
                        if (radioBtn200.isSelected()) {
                            an = "200";
                        }
                        if (radioBtn300.isSelected()) {
                            an = "300";
                        }
                        if (radioBtn400.isSelected()) {
                            an = "400";
                        }

                        try {
                            FileWriter writer = new FileWriter("11110002.txt", true);
                            BufferedWriter bufferedWriter = new BufferedWriter(writer);

                            bufferedWriter.write(LocalDate.now() + "    ΑΝΑΛΗΨΗ   " + an + "\n");

                            bufferedWriter.close();
                        } catch (IOException ex1) {
                            ex1.printStackTrace();
                        }

                    });

                    btnEktiposi.setOnAction(e11 -> {
                        String message = " *******************************\n"
                                + "Αριθμός λογαριασμού: 1111xxxx\n"
                                + "Τύπος Συναλλαγής: ΑΝΑΛΗΨΗ \n"
                                + "Ποσό: " + an + "\n"
                                + "Ημερομηνία: " + LocalDate.now() + "\n"
                                + "***********************************";
                        MessageBox.show(message, "Απόδειξη");
                    });

                    Scene scene300 = new Scene(Pane3, 600, 300, Color.STEELBLUE);
                    primaryStage.setTitle("ΑΝΑΛΗΨΗ ΧΡΗΜΑΤΩΝ"); // Set the stage title
                    primaryStage.setScene(scene300); // Place the scene in the stage
                    primaryStage.show(); // Display the stage
                });

                //Επιλογή Κατάθεση χρημάτων
                btnKatathesi.setOnAction(e302 -> {
                    primaryStage.hide();
                    GridPane Pane4 = new GridPane();
                    Pane4.setAlignment(Pos.CENTER);
                    Pane4.setHgap(10);
                    Pane4.setVgap(10);
                    Pane4.setPadding(new Insets(26, 26, 26, 26));
                    
                    Pane4.add(katathesiLabel, 0, 0, 1, 1);
                    katathesiLabel.setTextFill(Color.web("#FFFFFF"));
                    katathesiLabel.setFont(Font.font ("Verdana", 15));
                    
                    Pane4.add(posoText, 0, 1, 1, 1);
                    Pane4.add(btnKat, 0, 3, 1, 1);
                    Pane4.add(btnEktiposi, 0, 4, 1, 1);
                    Pane4.add(btnMainMenu, 1, 3, 1, 1);
                    Pane4.add(btnOut, 1, 4, 1, 1);
                    
                    btnOut.setPrefWidth(100);
                    btnMainMenu.setPrefWidth(100);
                    btnKat.setPrefWidth(200);
                    btnEktiposi.setPrefWidth(200);
                    
                    Pane4.setHalignment(btnKat, HPos.CENTER);
                    Pane4.setHalignment(btnMainMenu, HPos.CENTER);
                    Pane4.setHalignment(btnEktiposi, HPos.CENTER);
                    Pane4.setHalignment(btnOut, HPos.CENTER);
                    Pane4.setBackground(Background.EMPTY);

                    btnKat.setOnAction(e22 -> {
                        try {
                            FileWriter writer = new FileWriter("11110002.txt", true);
                            BufferedWriter bufferedWriter = new BufferedWriter(writer);

                            bufferedWriter.write(LocalDate.now() + "    ΚΑΤΑΘΕΣΗ   " + posoText.getText() + "\n");

                            bufferedWriter.close();
                        } catch (IOException ex1) {
                            ex1.printStackTrace();
                        }
                    });

                    btnEktiposi.setOnAction(e21 -> {
                        String message = " *******************************\n"
                                + "Αριθμός λογαριασμού: 1111xxxx\n"
                                + "Τύπος Συναλλαγής: ΚΑΤΑΘΕΣΗ \n"
                                + "Ποσό: " + posoText.getText() + "\n"
                                + "Ημερομηνία: " + LocalDate.now() + "\n"
                                + "***********************************";
                        MessageBox.show(message, "Απόδειξη");
                    });

                    Scene scene301 = new Scene(Pane4, 600, 300, Color.STEELBLUE);
                    primaryStage.setTitle("ΚΑΤΑΘΕΣΗ ΧΡΗΜΑΤΩΝ"); // Set the stage title
                    primaryStage.setScene(scene301); // Place the scene in the stage
                    primaryStage.show(); // Display the stage
                });

                //Επιλογή Κινήσεων Χρημάτων - Προβολή ιστορικού
                btnKiniseis.setOnAction(e302 -> {
                    primaryStage.hide();
                    GridPane Pane5 = new GridPane();
                    Pane5.setAlignment(Pos.CENTER);
                    Pane5.setHgap(10);
                    Pane5.setVgap(10);
                    Pane5.setPadding(new Insets(26, 26, 26, 26));
                    
                    Pane5.add(kiniseisLabel, 0, 1, 1, 1);
                    kiniseisLabel.setPrefWidth(500);
                    kiniseisLabel.setTextFill(Color.web("#FFFFFF"));
                    kiniseisLabel.setFont(Font.font ("Verdana", 20));
                    
                    Pane5.add(btnKin, 0, 2, 1, 1);
                    Pane5.add(btnOut,0,5,1,1);
                    Pane5.add(btnMainMenu, 0, 4, 1, 1);
                    
                    btnKin.setPrefWidth(200);
                    btnMainMenu.setPrefWidth(200);
                    btnOut.setPrefWidth(200);
                    
                    Pane5.setHalignment(btnMainMenu, HPos.CENTER);
                    Pane5.setHalignment(btnKin, HPos.CENTER);
                    Pane5.setHalignment(kiniseisLabel, HPos.CENTER);
                    Pane5.setHalignment(btnOut, HPos.CENTER);
                    Pane5.setBackground(Background.EMPTY);

                    btnKin.setOnAction(e31 -> {
                        try {
                            data = new String(Files.readAllBytes(Paths.get("11110002.txt")));
                            MessageBox.show(data, "Κινήσεις");
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    });

                    Scene scene302 = new Scene(Pane5, 600, 300, Color.STEELBLUE);
                    primaryStage.setTitle("ΚΙΝΗΣΕΙΣ ΧΡΗΜΑΤΩΝ"); // Set the stage title
                    primaryStage.setScene(scene302); // Place the scene in the stage
                    primaryStage.show(); // Display the stage

                });

            } else {
                endLabel.setText("Λάθος όνομα ή κωδικός.");
                acountNumberText.setText("");
                passwordText.setText("");
            }

            
        });

        //Επιστροφή στο αρχικό
        btnMainMenu.setOnAction(e -> {
            primaryStage.hide();
            GridPane Pane2 = new GridPane();
            Pane2.setAlignment(Pos.CENTER);
            Pane2.setHgap(10);
            Pane2.setVgap(10);
            Pane2.setPadding(new Insets(25, 25, 25, 25));
            Pane2.add(epiloges, 0, 1, 2, 2);
            Pane2.setBackground(Background.EMPTY);
            Scene scene1 = new Scene(Pane2, 500, 300, Color.STEELBLUE);
            primaryStage.setTitle("Account Page"); // Set the stage title
            primaryStage.setScene(scene1); // Place the scene in the stage
            primaryStage.show(); // Display the stage
        });
        
        //ΑΑποσύνδεση - τον πετάει στο αρχικό παράθυρο για να βάλει κωδικούς.
        btnOut.setOnAction(e -> {
                primaryStage.hide();
                GridPane grid1 = new GridPane();
                grid1.setHgap(10);
                grid1.setVgap(10);
                grid1.setAlignment(Pos.CENTER);
                grid1.setPadding(new Insets(25, 25, 25, 25));
                grid1.setBackground(Background.EMPTY);

                welcomeLabel.setAlignment(Pos.TOP_LEFT);

                grid1.add(welcomeLabel, 0, 0, 1, 1);
                welcomeLabel.setTextFill(Color.web("#FFFFFF"));

                grid1.add(acountNumberLabel, 0, 1, 1, 1);
                acountNumberLabel.setTextFill(Color.web("#FFFFFF"));

                grid1.add(passwordLabel, 0, 2, 1, 1);
                passwordLabel.setTextFill(Color.web("#FFFFFF"));

                grid1.add(endLabel, 0, 3, 1, 1);
                endLabel.setTextFill(Color.web("#FFFFFF"));

                grid1.add(acountNumberText, 1, 1, 1, 1);

                grid1.add(passwordText, 1, 2, 1, 1);

                grid1.setHalignment(btnSign, HPos.RIGHT);
                grid1.add(btnSign, 1, 3, 1, 1);

                Scene scene1 = new Scene(grid1, 400, 375,Color.STEELBLUE);
                primaryStage.setScene(scene1);
                primaryStage.setTitle("ATM");
                primaryStage.show();
            });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
