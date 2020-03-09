package com.zomwi.ejemplotouch;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public class MainActivity extends Activity implements OnGestureListener,
		OnDoubleTapListener {

	private String DEBUG_TAG = "ejemplo";

	private GestureDetectorCompat mDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDetector = new GestureDetectorCompat(this, this);
		mDetector.setOnDoubleTapListener(this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		mDetector.onTouchEvent(event);
		return super.onTouchEvent(event);

	}

	@Override
	public boolean onDoubleTap(MotionEvent event) {
		Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
		return true;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent event) {
		Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
		return true;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent event) {
		Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
		return true;
	}

	@Override
	public boolean onDown(MotionEvent event) {
		Log.d(DEBUG_TAG, "onDown: " + event.toString());
		return true;
	}

	@Override
	public boolean onFling(MotionEvent event1, MotionEvent event2, float arg2,
			float arg3) {
		Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
		return true;
	}

	@Override
	public void onLongPress(MotionEvent event) {
		Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float arg2,
			float arg3) {
		Log.d(DEBUG_TAG, "onScroll: " + e1.toString() + e2.toString());
		return true;
	}

	@Override
	public void onShowPress(MotionEvent event) {
		Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
	}

	@Override
	public boolean onSingleTapUp(MotionEvent event) {
		Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
		return true;
	}

}
