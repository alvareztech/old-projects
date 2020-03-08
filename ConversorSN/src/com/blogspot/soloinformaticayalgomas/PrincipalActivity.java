package com.blogspot.soloinformaticayalgomas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * 1 2 3 4 5 6 7 8 9  A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V
 * 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32
 * @author Daniel Alvarez
 */

public class PrincipalActivity extends Activity implements OnClickListener, OnItemSelectedListener, OnKeyListener {
 
    private Button botonConvertir;
    private Spinner baseOrigenSpinner;
    private Spinner baseDestinoSpinner;
    private EditText numeroOrigenEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        numeroOrigenEditText = (EditText) findViewById(R.id.numero_origen_edittext);
        numeroOrigenEditText.setOnKeyListener(this);
        baseOrigenSpinner = (Spinner) findViewById(R.id.base_origen_spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.bases, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        baseOrigenSpinner.setAdapter(adapter);
        baseOrigenSpinner.setOnItemSelectedListener(this);
        baseDestinoSpinner = (Spinner) findViewById(R.id.base_destino_spinner);
        baseDestinoSpinner.setAdapter(adapter);
        botonConvertir = (Button) findViewById(R.id.convertir_button);
        botonConvertir.setOnClickListener(this);
    }

    public void onClick(View view) {


        String numeroOrigen = numeroOrigenEditText.getText().toString();
        int baseOrigen = baseOrigenSpinner.getSelectedItemPosition();
        int baseDestino = baseDestinoSpinner.getSelectedItemPosition();



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Créditos");
        builder.setMessage("Desarrollado el grupo Desarolladores Android");
        builder.setCancelable(false);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                PrincipalActivity.this.finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onItemSelected(AdapterView<?> av, View view, int i, long l) {
        ArrayAdapter A = (ArrayAdapter) baseDestinoSpinner.getAdapter();
        A.remove(5);
    }

    public void onNothingSelected(AdapterView<?> av) {
        
    }

    public boolean onKey(View view, int i, KeyEvent ke) {
        
        return false;
    }

}
