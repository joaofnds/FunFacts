package com.example.joaofnds.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {
	// Declare our View variables
	private TextView mFactTextView;
	private Button mShowFactButton;
	private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

		// Assing the Views fom the layout file corresponding to the variables
		mFactTextView = (TextView) findViewById(R.id.factTextView);
		mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

		View.OnClickListener listener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
                int color = mColorWheel.getColor();
                // Update the screen with out dynamic fact
				mFactTextView.setText(mFactBook.getFact());
                mRelativeLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);
			}
		};
        mShowFactButton.setOnClickListener(listener);
    }
}
