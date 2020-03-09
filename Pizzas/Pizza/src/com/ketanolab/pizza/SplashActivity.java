package com.ketanolab.pizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity {

	private ImageView imagenSplash;
	private TextView textoSplash;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);

		imagenSplash = (ImageView) findViewById(R.id.imagen_splash);
		textoSplash = (TextView) findViewById(R.id.texto_splash);
		iniciarAnimacion();
	}

	private void iniciarAnimacion() {

		Animation animacion = AnimationUtils.loadAnimation(this,
				R.anim.anima_imagenes);
		textoSplash.startAnimation(animacion);

		animacion.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

			}

			public void onAnimationEnd(Animation animation) {
				startActivity(new Intent(SplashActivity.this,
						PromocionActivity.class));
				SplashActivity.this.finish();
			}
		});
	}
}
