package com.example.android.notificationdemoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{

	Button btnNotification1, btnNotification2, btnNotification3, btnNotification4, btnNotification5,
	 btnNotification6, btnNotification7, btnNotification8, btnNotification9;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnNotification1 = (Button) findViewById(R.id.btnNotification1);
		btnNotification2 = (Button) findViewById(R.id.btnNotification2);
		btnNotification3 = (Button) findViewById(R.id.btnNotification3);
		btnNotification4 = (Button) findViewById(R.id.btnNotification4);
		btnNotification5 = (Button) findViewById(R.id.btnNotification5);
		btnNotification6 = (Button) findViewById(R.id.btnNotification6);
		btnNotification7 = (Button) findViewById(R.id.btnNotification7);
		btnNotification8 = (Button) findViewById(R.id.btnNotification8);
		btnNotification9 = (Button) findViewById(R.id.btnNotification9);

		btnNotification1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationGenerator.simpleNotification(getApplicationContext());
			}
		});
		btnNotification2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationGenerator.openActivityNotification(getApplicationContext());
			}
		});
		btnNotification3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationGenerator.twoIconNotification(getApplicationContext());
			}
		});
		btnNotification4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationGenerator.bigPictureNotification(getApplicationContext());
			}
		});
		btnNotification5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationGenerator.bigTextStyleNotification(getApplicationContext());
			}
		});
		btnNotification6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationGenerator.chatStyleNotification(getApplicationContext());
			}
		});
		btnNotification7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationGenerator.actionButtonNotification(getApplicationContext());
			}
		});
		btnNotification8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationGenerator.customSimpleNotification(getApplicationContext());
			}
		});
		btnNotification9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationGenerator.customBigNotification(getApplicationContext());
			}
		});
	}
}
