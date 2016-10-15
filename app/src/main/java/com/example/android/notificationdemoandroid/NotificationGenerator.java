package com.example.android.notificationdemoandroid;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

public class NotificationGenerator {
	public static final String NOTIFY_PREVIOUS = "com.tutorialsface.notificationdemo.previous";
	public static final String NOTIFY_DELETE = "com.tutorialsface.notificationdemo.delete";
	public static final String NOTIFY_PAUSE = "com.tutorialsface.notificationdemo.pause";
	public static final String NOTIFY_PLAY = "com.tutorialsface.notificationdemo.play";
	public static final String NOTIFY_NEXT = "com.tutorialsface.notificationdemo.next";
	private static final int NOTIFICATION_ID_SIMPLE = 1;
	private static final int NOTIFICATION_ID_TWO_ICONS = 2;
	private static final int NOTIFICATION_ID_BIG_PIC = 3;
	private static final int NOTIFICATION_ID_BIG_TEXT = 4;
	private static final int NOTIFICATION_ID_CHAT = 5;
	private static final int NOTIFICATION_ID_ACTION_BUTTON = 6;
	private static final int NOTIFICATION_ID_CUSTOM_SIMPLE = 7;
	private static final int NOTIFICATION_ID_CUSTOM_BIG = 8;
	private static final int NOTIFICATION_ID_OPEN_ACTIVITY = 9;
	static String songName = "Now You're Gone";
	static String albumName = "Now Youre Gone - The Album";

	public static void simpleNotification(Context context) {
		NotificationCompat.Builder nc = new NotificationCompat.Builder(context);
		NotificationManager nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
	
		nc.setSmallIcon(R.drawable.ic_action_call);
		nc.setAutoCancel(true);
		nc.setContentTitle("Simple Notification");
		nc.setContentText("Showing notification content");
		nc.setTicker("Ticker 1");
		nc.setNumber(2);
		
		nm.notify(NOTIFICATION_ID_SIMPLE, nc.build());
	}

	public static void openActivityNotification(Context context) {
		NotificationCompat.Builder nc = new NotificationCompat.Builder(context);
		NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		// Creates an Intent for the Activity
		Intent notifyIntent = new Intent(context, MainActivity.class);
		// Sets the Activity to start in a new, empty task
		notifyIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
		// Creates the PendingIntent
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		nc.setContentIntent(pendingIntent);
	
		nc.setSmallIcon(R.drawable.ic_action_call);
		nc.setAutoCancel(true);
		nc.setContentTitle("Click to open Activity");
		nc.setContentText("Click please");
		
		nm.notify(NOTIFICATION_ID_OPEN_ACTIVITY, nc.build());
	}
	
	public static void twoIconNotification(Context context) {
		NotificationCompat.Builder nc = new NotificationCompat.Builder(context);
		NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		nc.setSmallIcon(R.drawable.ic_action_call);
		nc.setAutoCancel(true);
		nc.setContentTitle("Two Icon Notification");
		nc.setContentText("Showing two icon content");
		nc.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_action_person));
		nc.setTicker("Ticker 2");
		nc.setNumber(3);
		
		nm.notify(NOTIFICATION_ID_TWO_ICONS, nc.build());
	}
	
	public static void bigPictureNotification(Context context) {
		NotificationCompat.Builder nc = new NotificationCompat.Builder(context);
		NotificationCompat.BigPictureStyle bigPictureNotification = new NotificationCompat.BigPictureStyle();
		NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		nc.setSmallIcon(R.drawable.ic_launcher);
		nc.setAutoCancel(true);
		nc.setContentTitle("Big Picture Style");
		nc.setContentText("Big Picture Style Content");
		nc.addAction(R.drawable.ic_action_share, "Share", null);
		
		bigPictureNotification.bigPicture(BitmapFactory.decodeResource(context.getResources(), R.drawable.big_img));
		bigPictureNotification.setBigContentTitle("New Big Picture Title");
		nc.setStyle(bigPictureNotification);
		
		nm.notify(NOTIFICATION_ID_BIG_PIC, nc.build());
	}
	
	public static void bigTextStyleNotification(Context context) {
		NotificationCompat.Builder nc = new NotificationCompat.Builder(context);
		NotificationCompat.BigTextStyle bigTextNotification = new NotificationCompat.BigTextStyle();
		NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		nc.setSmallIcon(R.drawable.ic_launcher);
		nc.setAutoCancel(true);
		nc.setContentTitle("Big Text Style");
		nc.setContentText("Big Text Style Content");
		
		bigTextNotification.setBigContentTitle("New Big Text Title");
		bigTextNotification.bigText("Starting with Jelly Bean, Android supports optional actions that are displayed at the bottom of the notification. With actions, users can handle the most common tasks for a particular notification from within the notification shade without having to open the originating application. This speeds up interaction and, in conjunction with swipe-to-dismiss, helps users to streamline their notification triaging experience.");
		bigTextNotification.setSummaryText("By: http://developer.android.com/");
		nc.setStyle(bigTextNotification);
		
		nm.notify(NOTIFICATION_ID_BIG_TEXT, nc.build());
	}
	
	public static void chatStyleNotification(Context context) {
		NotificationCompat.Builder nc = new NotificationCompat.Builder(context);
		NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
		NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		String[] lines = new String[7];  
		lines[0] = "David@ Hi Howard";  
		lines[1] = "Howard@ Hi David";  
		lines[2] = "David@ What is the agenda for the upcoming meeting?";  
		lines[3] = "Howard@ I will send you a copy";  
		lines[4] = "David@ Thank you";  
		lines[5] = "Howard@ I will talk to you later";
		lines[6] = "David@ Bye for now"; 
		
		nc.setSmallIcon(R.drawable.ic_launcher);
		nc.setAutoCancel(true);
		nc.setContentTitle("Chat Text");
		nc.setContentText(lines[0]);
		nc.setNumber(7);
	  
		for (int i = 0; i < lines.length; i++) {  
	         inboxStyle.addLine(lines[i]);  
	    }  
	    inboxStyle.setBigContentTitle("New Chat Title");
		inboxStyle.setSummaryText("7 messages from 2 conversations.");
		nc.setStyle(inboxStyle);
		
		nm.notify(NOTIFICATION_ID_CHAT, nc.build());
	}
	
	public static void actionButtonNotification(Context context) {
		NotificationCompat.Builder nc = new NotificationCompat.Builder(context);
		NotificationCompat.BigTextStyle bigTextNotification = new NotificationCompat.BigTextStyle();
		NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		nc.setSmallIcon(R.drawable.ic_action_end_call);
		nc.setAutoCancel(true);
		nc.setContentTitle("Big Text Style Button");
		nc.setContentText("(900)022-3365");
		nc.addAction(R.drawable.ic_action_call, "Call back", null);
		nc.addAction(R.drawable.ic_action_chat, "Message", null);
		
		bigTextNotification.setBigContentTitle("New Big Text Title");
		bigTextNotification.bigText("Missed call from (900)022-3365");
		nc.setStyle(bigTextNotification);
		
		nm.notify(NOTIFICATION_ID_ACTION_BUTTON, nc.build());
	}

	public static void customSimpleNotification(Context context) {
		RemoteViews simpleView = new RemoteViews(context.getPackageName(), R.layout.custom_notification);
		 
		Notification notification = new NotificationCompat.Builder(context)
		        .setSmallIcon(R.drawable.ic_launcher)
		        .setContentTitle("Custom Big View").build();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.contentView = simpleView;
		notification.contentView.setTextViewText(R.id.textSongName, songName);
		notification.contentView.setTextViewText(R.id.textAlbumName, albumName);
		
		setListeners(simpleView, context);
				
		NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		nm.notify(NOTIFICATION_ID_CUSTOM_SIMPLE, notification);
	}

	@SuppressLint("NewApi")
	public static void customBigNotification(Context context) {
		RemoteViews expandedView = new RemoteViews(context.getPackageName(), R.layout.big_notification);
		 
		Notification notification = new NotificationCompat.Builder(context)
		        .setSmallIcon(R.drawable.ic_launcher)
		        .setContentTitle("Custom Big View").build();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.bigContentView = expandedView;
		notification.bigContentView.setTextViewText(R.id.textSongName, songName);
		notification.bigContentView.setTextViewText(R.id.textAlbumName, albumName);
		
		setListeners(expandedView, context);
		
		NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		nm.notify(NOTIFICATION_ID_CUSTOM_BIG, notification);
	}
	
	private static void setListeners(RemoteViews view, Context context) {
		Intent previous = new Intent(NOTIFY_PREVIOUS);
		Intent delete = new Intent(NOTIFY_DELETE);
		Intent pause = new Intent(NOTIFY_PAUSE);
		Intent next = new Intent(NOTIFY_NEXT);
		Intent play = new Intent(NOTIFY_PLAY);
	
		PendingIntent pPrevious = PendingIntent.getBroadcast(context, 0, previous, PendingIntent.FLAG_UPDATE_CURRENT);
		view.setOnClickPendingIntent(R.id.btnPrevious, pPrevious);
	
		PendingIntent pDelete = PendingIntent.getBroadcast(context, 0, delete, PendingIntent.FLAG_UPDATE_CURRENT);
		view.setOnClickPendingIntent(R.id.btnDelete, pDelete);
		
		PendingIntent pPause = PendingIntent.getBroadcast(context, 0, pause, PendingIntent.FLAG_UPDATE_CURRENT);
		view.setOnClickPendingIntent(R.id.btnPause, pPause);
		
		PendingIntent pNext = PendingIntent.getBroadcast(context, 0, next, PendingIntent.FLAG_UPDATE_CURRENT);
		view.setOnClickPendingIntent(R.id.btnNext, pNext);
		
		PendingIntent pPlay = PendingIntent.getBroadcast(context, 0, play, PendingIntent.FLAG_UPDATE_CURRENT);
		view.setOnClickPendingIntent(R.id.btnPlay, pPlay);
	}
}
