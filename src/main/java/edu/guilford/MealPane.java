package edu.guilford;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MealPane extends GridPane {
    // attributes for the MealPane class
    private Meal meal;

    private Label appetizerLabel;
    private Label entreeLabel;
    private Label dessertLabel;
    private Label drinkLabel;

    private TextField appetizerField;
    private TextField entreeField;
    private TextField dessertField;
    private TextField drinkField;

    private Button enterButton;

    private Label ratingLabel;
    // Step 1: Instantiate the slider
    private Slider ratingSlider;

    private ImageView imageView;

    private Button increaseFont;
    private Button decreaseFont;

    private ComboBox viewComboBox;

    // constructor for the MealPane class that takes in a Meal object
    public MealPane(Meal meal) {
        this.meal = meal;

        // instantiate the labels
        appetizerLabel = new Label("Appetizer: " + meal.getAppetizer());
        entreeLabel = new Label("Entree: " + meal.getEntree());
        dessertLabel = new Label("Dessert: " + meal.getDessert());
        drinkLabel = new Label("Drink: " + meal.getDrink());

        // instantiate the text fields
        appetizerField = new TextField();
        entreeField = new TextField();
        dessertField = new TextField();
        drinkField = new TextField();

        // instantiate the button
        enterButton = new Button("Enter");

        // instantiate the rating label and slider
        ratingLabel = new Label("What would you rate your meal?");
        // Step 2: Instantiate the slider
        ratingSlider = new Slider(0, 10, 5);
        // create a File object for the image
        File rateFace = new File(this.getClass().getResource("Shadie_Yummy_Bitmoji.png").getPath());
        // instantiate the image view
        imageView = new ImageView(rateFace.toURI().toString());
        // change the size of the image
        imageView.setFitHeight(200);
        // and keep the aspect ratio
        imageView.setPreserveRatio(true);

        // instantiate the buttons
        increaseFont = new Button("+ Font");
        decreaseFont = new Button("- Font");

        // instantiate the combo box
        viewComboBox = new ComboBox();
        // add the options to the combo box
        viewComboBox.getItems().addAll("Light Mode", "Dark Mode");
        // set the default value of the combo box
        viewComboBox.setValue("Light Mode");


        // add the labels, text fields, and button to the pane
        add(appetizerLabel, 0, 0);
        add(entreeLabel, 0, 1);
        add(dessertLabel, 0, 2);
        add(drinkLabel, 0, 3);

        add(appetizerField, 1, 0);
        add(entreeField, 1, 1);
        add(dessertField, 1, 2);
        add(drinkField, 1, 3);

        add(enterButton, 1, 4);

        // leave a blank row after the button
        add(new Label(), 0, 5);

        // add the font buttons
        add(increaseFont, 0, 6);
        add(decreaseFont, 1, 6);

        // leave a blank row afteter the font buttons
        add(new Label(), 0, 7);

        // add the rating label and slider
        add(ratingLabel, 0, 8);
        // Step 3: Add the slider to the pane
        add(ratingSlider, 1, 8);

        // add the image view underneath the rating label and slider
        add(imageView, 0, 9, 2, 1);

        // leave 2 blank rows after the image view
        add(new Label(), 0, 10);
        add(new Label(), 0, 11);

        // add the combo box
        add(viewComboBox, 0, 12, 2, 1);
         
        enterButton.setOnAction(e -> {
            appetizerLabel.setText("Appetizer: " + appetizerField.getText());
            entreeLabel.setText("Entree: " + entreeField.getText());
            dessertLabel.setText("Dessert: " + dessertField.getText());
            drinkLabel.setText("Drink: " + drinkField.getText());
        });

        // step 4 and 5: Write an event listener and connect it to the component that triggers the event
        // (add an event handler for the slider that changes the size of the image 
        // based on the value of the slider)
        ratingSlider.setOnMouseReleased(e -> {
            imageView.setFitHeight(ratingSlider.getValue() * 40);
        });

        // add a listener for the increase font button
        increaseFont.setOnAction(e -> {
            appetizerLabel.setStyle("-fx-font-size: " + (appetizerLabel.getFont().getSize() + 1) + "px;");
            entreeLabel.setStyle("-fx-font-size: " + (entreeLabel.getFont().getSize() + 1) + "px;");
            dessertLabel.setStyle("-fx-font-size: " + (dessertLabel.getFont().getSize() + 1) + "px;");
            drinkLabel.setStyle("-fx-font-size: " + (drinkLabel.getFont().getSize() + 1) + "px;");
        });

        // add a listener for the decrease font button
        decreaseFont.setOnAction(e -> {
            appetizerLabel.setStyle("-fx-font-size: " + (appetizerLabel.getFont().getSize() - 1) + "px;");
            entreeLabel.setStyle("-fx-font-size: " + (entreeLabel.getFont().getSize() - 1) + "px;");
            dessertLabel.setStyle("-fx-font-size: " + (dessertLabel.getFont().getSize() - 1) + "px;");
            drinkLabel.setStyle("-fx-font-size: " + (drinkLabel.getFont().getSize() - 1) + "px;");
        });

        // add a listener for the combo box that changes the background color of the pane
        viewComboBox.setOnAction(e -> {
            if (viewComboBox.getValue().equals("Light Mode")) {
                setStyle("-fx-background-color: white;");
            } else {
                setStyle("-fx-background-color: black;");
            }
        });
    }
    
}
