
package rockpaperscissors;

import java.util.*;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;

public class RockPaperScissors extends Application{

    private Button rockBTN , paperBTN , scissorsBTN , playAgainBTN;
    private Scene play , displayResult;
    private Text WelcomeMessage, StartMessage, ResultMessage;
    private int userSelction;
    private int compSelection;
    private String result;
    private String player1Pick;
    private String computerPick;
    
    public static void main(String[]args){
        
     launch(args);
    }
    @Override
    public void start (Stage primaryStage) throws Exception {
     primaryStage.setTitle("Rock-Paper-Scissors");
     
     WelcomeMessage = new Text("welcome to Rock Paper Scissors");
     StartMessage = new Text ("Please make your selection below : ");
     ResultMessage = new Text();
     
     rockBTN = new Button("Rock");
     paperBTN = new Button("Paper");
     scissorsBTN = new Button ("Scissors");
     
     VBox vbox = new VBox();
     vbox.getChildren().addAll(WelcomeMessage, StartMessage);
     vbox.setAlignment(Pos.CENTER);
     
     HBox hbox1 = new HBox();
     hbox1.getChildren().addAll(rockBTN, paperBTN, scissorsBTN);
     hbox1.setAlignment(Pos.CENTER);
     hbox1.setPadding(new Insets(5,5,5,5));
     hbox1.setSpacing(15);
     VBox main = new VBox(5);
     main.getChildren().addAll(vbox,hbox1);
     main.setAlignment(Pos.CENTER);
     main.setPadding(new Insets (15 , 15 , 15 , 15));
     BorderPane border = new BorderPane();
     border.setCenter(main);
     
     playAgainBTN = new Button("Play Again");
     BorderPane border1 = new BorderPane();
     VBox results = new VBox(10);
     results.getChildren().addAll(ResultMessage,playAgainBTN);
     results.setAlignment(Pos.CENTER);
     border1.setCenter(results);
     
     play = new Scene(border , 700 , 300);
     displayResult = new Scene(border1, 700 , 300);
     
     
     rockBTN.setOnAction
     (e ->{userSelction = 1;
     player1Pick = "Rock";
     displayResults();
     primaryStage.setScene(displayResult);
     });
     
     
     paperBTN.setOnAction
     (e ->{userSelction = 2;
     player1Pick = "Paper";
     displayResults();
     primaryStage.setScene(displayResult);
     });
     
     
     scissorsBTN.setOnAction
     (e ->{userSelction = 3;
     player1Pick = "Scissors";
     displayResults();
     primaryStage.setScene(displayResult);
     });
     
     playAgainBTN.setOnAction  
      (e -> {
          primaryStage.setScene(play);
            });
     
     primaryStage.setScene(play);
     primaryStage.show();
    }
     public int computerSelection()
     {
         Random rand = new Random();
         compSelection = rand.nextInt(3)+1;
         
       if (compSelection == 1)
       {
         computerPick = "Rock";
         
       }else if (compSelection == 2)
       {
         computerPick = "Paper";
       }else if (compSelection == 3)   
       {
        computerPick = "Scissors";
       }
        return compSelection;
     }
     
     public String runGame()
     {
      computerSelection();
      if ((userSelction == 1 && compSelection == 3)
        ||(userSelction == 2 && compSelection == 1)
        ||(userSelction == 3 && compSelection == 2)){
          
        result = "Congratulations. You won!!";
     }
      else if ((userSelction == 1 && compSelection == 2)
             ||(userSelction == 2 && compSelection == 3)
             ||(userSelction == 3 && compSelection == 1)){
         
         result ="The comuter wins. Better luck next time!";
     }
      
     else {
      result = "The game was a tie! Please try again";
     }
      return result;                 
     }
     
     public void displayResults(){
         runGame();
         ResultMessage.setText("You picked "+player1Pick+" and the"
                             + " computer picked " +computerPick+" "+result);
     }
     

}
