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

    private TextField appetizerPrice;
    private TextField entreePrice;
    private TextField dessertPrice;
    private TextField drinkPrice;

    private Button calculateButton;

    private Label totalLabel;

    private Label errorLabel;

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

        // instantiate the price text fields
        appetizerPrice = new TextField();
        entreePrice = new TextField();
        dessertPrice = new TextField();
        drinkPrice = new TextField();

        // instantiate the calculate button
        calculateButton = new Button("Calculate Price!");

        // instantiate the total label
        totalLabel = new Label("Total: ");

        // instantiate the error label
        errorLabel = new Label();

        // add the labels, text fields, and button to the pane
        add(appetizerLabel, 0, 0);
        add(entreeLabel, 0, 1);
        add(dessertLabel, 0, 2);
        add(drinkLabel, 0, 3);
        add(errorLabel, 0, 4);

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

        // leave a blank space between the text fields and the price text fields
        add(new Label(), 2, 3);

        // add the price text fields to the right of the text fields
        add(appetizerPrice, 4, 0);
        add(entreePrice, 4, 1);
        add(dessertPrice, 4, 2);
        add(drinkPrice, 4, 3);

        // total label and calculate button to the right of the last price text field
        add(totalLabel, 4, 4);
        add(calculateButton, 3, 3);

        // implement a try catch blcok to make sure user only enters text in the text
        // fields
        enterButton.setOnAction(e -> {
            try {
                setLabels();
            } catch (BlankTextException ex) {
                errorLabel.setStyle("-fx-text-fill: red;");
                errorLabel.setText("Please enter text in all fields!");
            } 
            try {
                charcterLimit();
            } catch (TooManyCharactersException ex) {
                errorLabel.setStyle("-fx-text-fill: red;");
                errorLabel.setText("Please enter less than 20 characters!");
            }

        });

        // step 4 and 5: Write an event listener and connect it to the component that
        // triggers the event
        // (add an event handler for the slider that changes the size of the image
        // based on the value of the slider)
        ratingSlider.setOnMouseReleased(e -> {
            imageView.setFitHeight(ratingSlider.getValue() * 40);
        });

        // add a listener for the increase font button
        increaseFont.setOnAction(e -> {
            try {
                increaseFontSize();
            } catch (FontSizeException ex) {
                errorLabel.setStyle("-fx-text-fill: red;");
                errorLabel.setText("Font size cannot be greater than 25!");
            }
        });

        // add a listener for the decrease font button
        decreaseFont.setOnAction(e -> {
            // add a try catch block to make sure the font size doesn't go below 6
            try {
                decreaseFontSize();
            } catch (FontSizeException ex) {
                errorLabel.setStyle("-fx-text-fill: red;");
                errorLabel.setText("Font size cannot be less than 6!");
            }
        });

        // add a listener for the combo box that changes the background color of the
        // pane
        viewComboBox.setOnAction(e -> {
            if (viewComboBox.getValue().equals("Light Mode")) {
                setStyle("-fx-background-color: white;");
            } else {
                setStyle("-fx-background-color: black;");
                // and change the color of the labels
                appetizerLabel.setStyle("-fx-text-fill: white;");
                entreeLabel.setStyle("-fx-text-fill: white;");
                dessertLabel.setStyle("-fx-text-fill: white;");
                drinkLabel.setStyle("-fx-text-fill: white;");
                ratingLabel.setStyle("-fx-text-fill: white;");
                totalLabel.setStyle("-fx-text-fill: white;");
            }
        });

        // add a listener for the calculate button
        calculateButton.setOnAction(e -> {
            double total = 0;
            try {
                if (!appetizerPrice.getText().equals("")) {
                    total += Double.parseDouble(appetizerPrice.getText());
                }
                if (!entreePrice.getText().equals("")) {
                    total += Double.parseDouble(entreePrice.getText());
                }
                if (!dessertPrice.getText().equals("")) {
                    total += Double.parseDouble(dessertPrice.getText());
                }
                if (!drinkPrice.getText().equals("")) {
                    total += Double.parseDouble(drinkPrice.getText());
                }
                totalLabel.setText("Total: $" + total);
            } catch (NumberFormatException ex) {
                totalLabel.setStyle("-fx-text-fill: red;");
                totalLabel.setText("Non-numeric input detected! Please enter a double or integer.");
            }
        });
    }

    public static class BlankTextException extends Exception {
        public BlankTextException(String message) {
            super("Blank Text Exception");
        }
    }

    public static class FontSizeException extends Exception {
        public FontSizeException(String message, Throwable err) {
            super("Font Size Exception", err);
        }
    }

    public static class TooManyCharactersException extends Exception {
        public TooManyCharactersException(String message, Throwable err) {
            super("Too Many Characters Exception", err);
        }
    }
    private void setLabels() throws BlankTextException {
        // if all the labels are blank, throw the blank text exception
        if (appetizerField.getText().equals("") && entreeField.getText().equals("")
                && dessertField.getText().equals("") && drinkField.getText().equals("")) {
            throw new BlankTextException("Please enter text in the text fields!");
        } else {
            // set the label text to the text in the text fields
            appetizerLabel.setText("Appetizer: " + appetizerField.getText());
            entreeLabel.setText("Entree: " + entreeField.getText());
            dessertLabel.setText("Dessert: " + dessertField.getText());
            drinkLabel.setText("Drink: " + drinkField.getText());
        }
    }

    private void increaseFontSize() throws FontSizeException {
        // if the font size is greater than 25, throw the font size exception
        if (appetizerLabel.getFont().getSize() > 25 || entreeLabel.getFont().getSize() > 25
                || dessertLabel.getFont().getSize() > 25 || drinkLabel.getFont().getSize() > 25) {
            throw new FontSizeException("Font size cannot be greater than 30!", null);
        } else {
            // set the font size of the labels to the font size of the labels plus 1
            appetizerLabel.setStyle("-fx-font-size: " + (appetizerLabel.getFont().getSize() + 1) + "px;");
            entreeLabel.setStyle("-fx-font-size: " + (entreeLabel.getFont().getSize() + 1) + "px;");
            dessertLabel.setStyle("-fx-font-size: " + (dessertLabel.getFont().getSize() + 1) + "px;");
            drinkLabel.setStyle("-fx-font-size: " + (drinkLabel.getFont().getSize() + 1) + "px;");
        }
    }

    private void decreaseFontSize() throws FontSizeException {
        // if the font size is less than 6, throw the font size exception
        if (appetizerLabel.getFont().getSize() < 6 || entreeLabel.getFont().getSize() < 6
                || dessertLabel.getFont().getSize() < 6 || drinkLabel.getFont().getSize() < 6) {
            throw new FontSizeException("Font size cannot be less than 6!", null);
        } else {
            // set the font size of the labels to the font size of the labels minus 1
            appetizerLabel.setStyle("-fx-font-size: " + (appetizerLabel.getFont().getSize() - 1) + "px;");
            entreeLabel.setStyle("-fx-font-size: " + (entreeLabel.getFont().getSize() - 1) + "px;");
            dessertLabel.setStyle("-fx-font-size: " + (dessertLabel.getFont().getSize() - 1) + "px;");
            drinkLabel.setStyle("-fx-font-size: " + (drinkLabel.getFont().getSize() - 1) + "px;");
        }
    }

    private void charcterLimit() throws TooManyCharactersException {
        // if the text in the text fields is greater than 20 characters, throw the too
        // many characters exception
        if (appetizerField.getText().length() > 20 || entreeField.getText().length() > 20
                || dessertField.getText().length() > 20 || drinkField.getText().length() > 20) {
            throw new TooManyCharactersException("Too many characters!", null);
        } else {
            // set the label text to the text in the text fields
            appetizerLabel.setText("Appetizer: " + appetizerField.getText());
            entreeLabel.setText("Entree: " + entreeField.getText());
            dessertLabel.setText("Dessert: " + dessertField.getText());
            drinkLabel.setText("Drink: " + drinkField.getText());
        }
    }

}
