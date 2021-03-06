package com.android.alejandra.ej1_saludo2activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btAceptar, btOcultar;
    private EditText etNombre;
    private TextView tvLabelNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }




    ///////////////////////////////////////////////////////////////////
    ///    MÉTODO PROPIOS ////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////

    /**
     * Método que limpia el formulario
     *
     * @param v vista pulsada
     */
    public void limpiar(View v) {
        etNombre.setText("");
    }


    /**
     * Método que responde pulsaciones de botones
     *
     * @param boton botón pulsado
     */
    @Override
    public void onClick(View boton) {
        if (boton.getId() == R.id.btOcultar) {
            botonOcultarPulsado();
        }
        if (boton.getId() == R.id.btAceptar){
            botonAceptarPulsado();
        }
    }


    /** Método que se ejecuta al pulsar el botón ocultar
     *
     */
    private void botonOcultarPulsado() {
        if (etNombre.getVisibility() == View.VISIBLE
                && tvLabelNombre.getVisibility() == View.VISIBLE) {
            etNombre.setVisibility(View.GONE);
            tvLabelNombre.setVisibility(View.GONE);
            btOcultar.setText(R.string.btMostrar);
        } else {
            etNombre.setVisibility(View.VISIBLE);
            tvLabelNombre.setVisibility(View.VISIBLE);
            btOcultar.setText(R.string.btOcultar);
        }
    }

    /** Método que se ejecuta al pulsar el botón Aceptar
     *
     */
    private void botonAceptarPulsado() {
        Intent i = new Intent(MainActivity.this, PantallaSaludo.class);
        i.putExtra("NOMBRE", etNombre.getText().toString());
        startActivity(i);
    }

    /**
     * Método que obtiene referencias e inicializa interfaz usuarios
     */
    private void init() {
        //obtengo referencias
        btAceptar = (Button) findViewById(R.id.btAceptar);
        btOcultar = (Button) findViewById(R.id.btOcultar);
        etNombre = (EditText) findViewById(R.id.etNombre);
        tvLabelNombre = (TextView) findViewById(R.id.tvLabelNombre);

        //pulsación botón
        btAceptar.setOnClickListener(this);
        btOcultar.setOnClickListener(this);
    }

}
