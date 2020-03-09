package com.androfony.replyfony;

import java.io.File;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CheckInExtrasActivity extends Activity {

	private TextView textoTitulo;
	private EditText cajaDescripcion;

	private ImageButton botonImagen;

	private double latitud;
	private double longitud;

	SharedPreferences configuraciones;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkinextras);

		textoTitulo = (TextView) findViewById(R.id.textoTitulo);
		botonImagen = (ImageButton) findViewById(R.id.botonImagen);
		cajaDescripcion = (EditText) findViewById(R.id.cajaDescripcion);

		String tipo = getIntent().getStringExtra("tipo");
		textoTitulo.setText(tipo);

		latitud = getIntent().getDoubleExtra("latitud", 0);
		longitud = getIntent().getDoubleExtra("longitud", 0);

		configuraciones = getSharedPreferences("mis_preferencias", Context.MODE_PRIVATE);
//		inicializar();
	}

	public void aceptar(View view) {

		String tipo = textoTitulo.getText().toString();
		String descripcion = cajaDescripcion.getText().toString();

		HttpClient cliente = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://192.168.43.105/replyfony/web/app.php/api/check-in");
		post.setHeader("content-type", "application/json");
		try {
			JSONObject object = new JSONObject();

			object.put("latitud", latitud);
			object.put("longitud", longitud);
			object.put("tipo", tipo);
			object.put("descripcion", descripcion);
			object.put("hecho", tipo);
			object.put("email", "a3dany@gmail.com");

			StringEntity entity = new StringEntity(object.toString());
			post.setEntity(entity);
			HttpResponse respuesta = cliente.execute(post);
			String res = EntityUtils.toString(respuesta.getEntity());
			if (res.equals("true")) {
				Toast.makeText(this, "Se envió correctamente.", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "Error de envió.", Toast.LENGTH_SHORT).show();
			}
		} catch (Exception ex) {
		}
	}

	public void cancelar(View view) {
		finish();
	}

	public void abrirCamara(View view) {
		Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(i, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_CANCELED) {
			Toast.makeText(this, "Se cancelo la captura por cámara.", Toast.LENGTH_SHORT).show();
		} else if (resultCode == Activity.RESULT_OK) {
			Bitmap bitmapCamera = (Bitmap) data.getExtras().get("data");
			if (bitmapCamera != null) {
				try {
					guardarImagen(bitmapCamera);
				} catch (Exception e) {
				}
			}
		}
	}

	private Bitmap crearBitmapEscaladoManteniendoAspecto(Bitmap bitmap, int maxLado) {
		// Tamaño original
		int anchoOriginal = bitmap.getWidth();
		int alturaOriginal = bitmap.getHeight();
		// Tamaño escalado
		int anchoEscalado = (anchoOriginal >= alturaOriginal) ? maxLado
				: (int) ((float) maxLado * ((float) anchoOriginal / (float) alturaOriginal));
		int altoEscalado = (alturaOriginal >= anchoOriginal) ? maxLado
				: (int) ((float) maxLado * ((float) alturaOriginal / (float) anchoOriginal));
		// Crear un Bitmap escalado
		Bitmap bitmapEscalado = Bitmap.createScaledBitmap(bitmap, anchoEscalado, altoEscalado, true);
		return bitmapEscalado;
	}

	private void guardarImagen(Bitmap imagen) {
		String nombreArchivo = "mi_imagen.jpg";
		try {
			imagen.compress(CompressFormat.JPEG, 100, openFileOutput(nombreArchivo, MODE_PRIVATE));
		} catch (Exception e) {
		}
		Uri imageUriToSaveCameraImageTo = Uri.fromFile(new File(this.getFilesDir(), nombreArchivo));
		// Guardamos preferencias
		Editor editor = configuraciones.edit();
		editor.putString("mis_preferencias", imageUriToSaveCameraImageTo.getPath());
		editor.commit();
		// Actualizar el ImageButton
		ImageButton botonAvatar = (ImageButton) findViewById(R.id.botonImagen);
		String strAvatarUri = configuraciones.getString("mis_preferencias",
				"android.resource://bo.umsa.pgi.camaraygaleria/drawable/mi_imagen");
		Uri imageUri = Uri.parse(strAvatarUri);
		botonAvatar.setImageURI(null);
		botonAvatar.setImageURI(imageUri);
	}

	private void inicializar() {
		ImageButton botonAvatar = (ImageButton) findViewById(R.id.botonImagen);
		if (configuraciones.contains("mis_preferencias")) {
			String strAvatarUri = configuraciones.getString("mis_preferencias",
					"android.resource://bo.umsa.pgi.camaraygaleria/drawable/mi_imagen");
			Uri imageUri = Uri.parse(strAvatarUri);
			botonAvatar.setImageURI(imageUri);
		} else {
			botonAvatar.setImageResource(R.drawable.ic_launcher);
		}
	}

}
