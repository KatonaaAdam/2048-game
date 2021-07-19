package hu.alkfejl.view.controller;

import hu.alkfejl.controller.MaxSzint;
import hu.alkfejl.dao.GameDAO;
import hu.alkfejl.dao.GameDAOImp;
import hu.alkfejl.model.game.Cell;
import hu.alkfejl.model.game.Game;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class KezdoAblakKezelo implements Initializable {
    GameDAO dao=new GameDAOImp();

    public static  int CELL_SIZE = 64;
    private static int szam10=4;
    public int szam1=4;
    public Game game = new Game();




    @FXML
    Spinner<Integer> spinerLevel;

    public KezdoAblakKezelo() {
    }

    @FXML
    private void nyolc(ActionEvent event){
        this.szam1=8;
        KezdoAblakKezelo.szam10=8;
        game = new Game(8,spinerLevel.getValue());

    }
    @FXML
    private void hat(ActionEvent event){
        this.szam1=6;
        KezdoAblakKezelo.szam10=6;
        game = new Game(6,spinerLevel.getValue());

    }
    @FXML
    private void ot(ActionEvent event){
        this.szam1=5;
        KezdoAblakKezelo.szam10=5;
        game = new Game(5,spinerLevel.getValue());
    }
    @FXML
    private void negy(ActionEvent event){
        this.szam1=4;
        KezdoAblakKezelo.szam10=4;
        game = new Game(4,spinerLevel.getValue());
    }

    @FXML
    private void goRanglista(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/hu/alkfejl/view/main_window.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int atvalt(int num){
        switch (num){
            case 4:
                return 2;
            case 8:
                return 3;
                case 16:

                return 4;
            case 32:
                return 5;
            case 64:
                return 6;
                case 128:
                return 7;
            case 256:
                return 8;
            case 512:
                return 9;
                case 1024:
                return 10;
            case 2048:
                return 11;
            default:
                return 1;
        }

    }



    @FXML
    private void tovab() {

        Stage myStage=new Stage();

        game.watch.start();

        myStage.setTitle("Game 2048");

        FlowPane rootNode = new FlowPane();

        myStage.setResizable(false);
        myStage.setOnCloseRequest(event -> Platform.exit());

        Scene myScene = new Scene(rootNode, game.getWidth(), game.getHeight());
        myStage.setScene(myScene);

        myScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {

                if (event.getCode() == KeyCode.ESCAPE || event.getCode()==KeyCode.CANCEL) {
                    MaxSzint maxSzint=new MaxSzint(game.getCells(),0,game.getCells().length);
                    maxSzint.run();
                    Cell cell2 = maxSzint.localMaximum;
                    atvalt(cell2.number);

                        dao.add(atvalt(cell2.number),String.valueOf(game.watch.getTime(TimeUnit.SECONDS)));


                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/kezdo.fxml"));
                        Scene scene = new Scene(root);
                        myStage.setScene(scene);
                        myStage.show();
                        myStage.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                if (!game.canMove() || (!game.win && !game.canMove())) {
                    game.lose = true;
                }

                if (!game.win && !game.lose) {
                    switch (event.getCode()) {
                        case LEFT:
                            game.left();
                            break;
                        case A:
                            game.left();
                            break;
                        case RIGHT:
                            game.right();
                            break;
                        case D:
                            game.right();
                            break;
                        case DOWN:
                            game.down();
                            break;
                        case S:
                            game.down();
                            break;
                        case UP:
                            game.up();
                            break;
                        case W:
                            game.up();
                            break;
                    }
                }
                game.relocate(800, 700);
            }
        });

        rootNode.getChildren().add(game);
        myStage.show();


        new AnimationTimer() {
            @Override
            public void handle(long now) {

                GraphicsContext gc = game.getGraphicsContext2D();
                gc.setFill(Color.rgb(187, 173, 160, 1.0));
                gc.fillRect(0, 0, game.getWidth(), game.getHeight());

                for(int y = 0; y < szam1; y++) {
                    for(int x = 0; x < szam1; x++){
                        Cell cell = game.getCells()[x + y * szam1];
                        int value = cell.number;
                        int xOffset = offsetCoors(x);
                        int yOffset = offsetCoors(y);


                        gc.setFill(cell.getBackground());
                        gc.fillRoundRect(xOffset, yOffset, CELL_SIZE, CELL_SIZE, 20, 20);
                        gc.setFill(cell.getForeground());

                        final int size = value < 100 ? 32 : value < 1000 ? 28 : 24;
                        gc.setFont(Font.font("Arial", FontWeight.BOLD, size));
                        gc.setTextAlign(TextAlignment.CENTER);


                        String s = String.valueOf(value);

                        if (value != 0)
                            gc.fillText(s, xOffset + CELL_SIZE / 1.75, yOffset + CELL_SIZE / 1.75 - 2);
                        if(game.win || game.lose) {

                            if (game.watch.isStarted()){
                                game.watch.stop();}


                            gc.setFill(Color.rgb(255, 255, 255));
                            gc.fillRect(0, 0, game.getWidth(), game.getHeight());
                            gc.setFill(Color.rgb(78, 139, 202));
                            gc.setFont(Font.font("Arial", FontWeight.BOLD, 40));
                            if(game.win){
                                gc.fillText("Hurrá, ez szuper!", 350, 300);
                                gc.fillText("Nyertél!", 360, 400);
                            }
                            if(game.lose) {
                                gc.fillText("A játéknak vége!", 350, 300);
                                gc.fillText("Vesztettél!", 360, 400);
                            }
                            if(game.win || game.lose) {
                                gc.setFont(Font.font("Arial", FontWeight.LIGHT, 16));
                                gc.setFill(Color.rgb(128, 128, 128));


                                gc.fillText("Nyomd meg az Esc billentyűt egy új körért!", 390, 430);
                            }

                        }
                        gc.setFont(Font.font("Verdana", FontWeight.LIGHT, 18));
                        gc.fillText("Eredmény: " + game.score, 700, 50);

                            gc.setFont(Font.font("Verdana", FontWeight.LIGHT, 18));
                            gc.fillText("Time: " +game.watch.getTime(TimeUnit.SECONDS), 700, 80);





                    }
                }


            }


        }.start();






    }

    @FXML
    private void kilep(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        spinerLevel.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 11, 1));
        spinerLevel.getValueFactory().valueProperty().bindBidirectional(game.levelProperty().asObject());

    }

    private static int offsetCoors(int arg) {
        if (szam10==4){
            CELL_SIZE=120;
            return arg * (80 + 70) + 75;
        }else if (szam10==5){
            CELL_SIZE=100;
            return arg * (60 + 64) + 70;
        }else if (szam10==6){
            CELL_SIZE=80;
            return arg * (25 + 64) + 60;
        }else {
            CELL_SIZE=60;
            return arg * (14 + 64) + 14;
        }

    }
}

