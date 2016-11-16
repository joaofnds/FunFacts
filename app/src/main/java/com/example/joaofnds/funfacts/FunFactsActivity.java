package com.example.joaofnds.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {
	// Declare our View variables
	private TextView mFactTextView;
	private Button mShowFactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

		// Assing the Views fom the layout file corresponding to the variables
		mFactTextView = (TextView) findViewById(R.id.factTextView);
		mShowFactButton = (Button) findViewById(R.id.showFactButton);

		View.OnClickListener listener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// The button was clicked, so update de fact TextView with a new fact
				String fact = "Ostriches can run faster than horses.";
				mFactTextView.setText(fact);
			}
		};
		mShowFactButton.addOnClickListener(listener);
    }
}
