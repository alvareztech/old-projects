package com.ketanolab.pizza;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class Puntos extends ItemizedOverlay {
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	private Context contexto;
	private String[] items = { "2111361", "2111222", "2110311" };
	int c = 0;

	public Puntos(Drawable defaultMarker) {
		super(defaultMarker);
		// TODO Auto-generated constructor stub
	}

	public Puntos(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		contexto = context;
	}

	public void addOverlay(OverlayItem overlay) {
		mOverlays.add(overlay);

		if (size() > 4) {
			mOverlays.remove(3);
		}
		populate();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mOverlays.size();
	}

	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return mOverlays.get(i);
	}

	@Override
	protected boolean onTap(final int index) {
		OverlayItem item = mOverlays.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(contexto);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());

		dialog.setPositiveButton("Llamar",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						String telefono = "";
						switch (index) {
						case 0:
							telefono = contexto.getString(R.string.telefono1);
							break;
						case 1:
							telefono = contexto.getString(R.string.telefono2);
							break;
						case 2:
							telefono = contexto.getString(R.string.telefono3);
							break;
						}
						Intent callIntent = new Intent(Intent.ACTION_CALL);
						// callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						callIntent.setData(Uri.parse("tel:" + telefono));
						contexto.startActivity(callIntent);
					}
				});
		dialog.setNegativeButton("Cancelar",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});

		dialog.show();
		return true;
	}

}
