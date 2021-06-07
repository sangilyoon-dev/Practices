package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
	EditText editText;
	EditText editText2;
	EditText editText3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText = findViewById(R.id.sendNumberET);
		editText2 = findViewById(R.id.contentET);
		editText3 = findViewById(R.id.timeET);

		Button button = findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		Intent passedIntent = getIntent();
		processIntent(passedIntent);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		processIntent(intent);

		super.onNewIntent(intent);
	}

	private void processIntent(Intent intent) {

		if (intent != null) {
			String sender = intent.getStringExtra("sender");
			String contents = intent.getStringExtra("contents");
			String receivedDate = intent.getStringExtra("receivedDate");

			editText.setText(sender);
			editText2.setText(contents);
			editText3.setText(receivedDate);
		}
	}
}