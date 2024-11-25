package com.example.assingment2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox vegetarianCheckBox, nonVegetarianCheckBox;
    private RadioGroup ingredientsRadioGroup;
    private SeekBar spiceLevelSeekBar;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch cookingModeSwitch;
    private RatingBar recipeRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure this matches your layout filename

        // Initializing views
        vegetarianCheckBox = findViewById(R.id.vegetarian);
        nonVegetarianCheckBox = findViewById(R.id.non_vegetarian);
        ingredientsRadioGroup = findViewById(R.id.radioGroup);
        spiceLevelSeekBar = findViewById(R.id.seekBar_spice);
        cookingModeSwitch = findViewById(R.id.switch_mode);
        recipeRatingBar = findViewById(R.id.ratingBar);
        Button submitButton = findViewById(R.id.submit_button);

        // Handling the submit button click event
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleFormSubmission();
            }
        });
    }

    private void handleFormSubmission() {
        // Collecting checkbox inputs
        boolean isVegetarian = vegetarianCheckBox.isChecked();
        boolean isNonVegetarian = nonVegetarianCheckBox.isChecked();

        // Collecting radio button input
        int selectedIngredientId = ingredientsRadioGroup.getCheckedRadioButtonId();
        String selectedIngredient = "No ingredient selected";
        if (selectedIngredientId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedIngredientId);
            selectedIngredient = selectedRadioButton.getText().toString();
        }

       
        int spiceLevel = spiceLevelSeekBar.getProgress();

        // Collecting switch input
        boolean isCookingModeEnabled = cookingModeSwitch.isChecked();

        // Collecting rating bar input
        float recipeRating = recipeRatingBar.getRating();

        // Constructing message to show in the Toast
        String message = "Preferences:\n";
        message += isVegetarian ? "Vegetarian\n" : "";
        message += isNonVegetarian ? "Non-Vegetarian\n" : "";
        message += "Selected Ingredient: " + selectedIngredient + "\n";
        message += "Spice Level: " + spiceLevel + "\n";
        message += "Cooking Mode: " + (isCookingModeEnabled ? "Advanced" : "Basic") + "\n";
        message += "Recipe Rating: " + recipeRating + " stars";

        // Displaying collected data in a Toast
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
