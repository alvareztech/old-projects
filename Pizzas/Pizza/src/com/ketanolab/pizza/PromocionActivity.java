package com.ketanolab.pizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;

public class PromocionActivity extends Activity {

	private TextView textoPromocion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.promocion);

		textoPromocion = (TextView) findViewById(R.id.texto_promocion);
		iniciarAnimacion();
	}

	private void iniciarAnimacion() {
		Animation animacion = AnimationUtils.loadAnimation(this,
				R.anim.anima_imagenes);
		
		textoPromocion.startAnimation(animacion);

		animacion.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

			}

			public void onAnimationEnd(Animation animation) {
				startActivity(new Intent(PromocionActivity.this,
						DashboardActivity.class));
				PromocionActivity.this.finish();
			}
		});

	}

}
