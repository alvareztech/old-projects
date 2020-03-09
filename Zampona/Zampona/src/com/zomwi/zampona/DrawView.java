package com.zomwi.zampona;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawView extends View implements OnTouchListener {

	private Paint paint;
	private int positionX;
	private int positionY;
	private SoundPool soundPool;

	public DrawView(Context context) {
		super(context);
		paint = new Paint();
		positionX = 0;
		positionY = 0;
		setOnTouchListener(this);
	}

	public DrawView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.paint = new Paint();
		setOnTouchListener(this);

		soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

		int x = soundPool.load(getContext(), R.raw.sonido, 0);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		canvas.drawRect(positionX, positionY, positionX + 40, positionY + 60,
				paint);
		invalidate();

	}

	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_UP:
			soundPool.stop(1);
			break;
		case MotionEvent.ACTION_MOVE:
			positionX = (int) event.getX();
			positionY = (int) event.getY();
			break;
		case MotionEvent.ACTION_DOWN:
			soundPool.play(1, 1, 1, 1, 0, 1);
			break;
		}

		return false;
	}
}
