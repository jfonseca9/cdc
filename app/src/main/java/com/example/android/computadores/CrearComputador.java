package com.example.android.computadores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Android on 28/05/2018.
 */


    public class CrearComputador extends AppCompatActivity {
        private EditText txtTipo;
        private EditText txtMarca;
        private EditText txtColor;
    private EditText txtSoperativo;
        private Spinner cmbRam;
        private ArrayAdapter<String> adapter;
        private String opc[];
        private ArrayList<Integer> fotos;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_crear_personas);

            txtTipo = findViewById(R.id.txtTipo);
            txtMarca = findViewById(R.id.txtMarca);
            txtColor = findViewById(R.id.txtColor);
            txtSoperativo = findViewById(R.id.txtSoperativo);
            cmbRam = findViewById(R.id.cmbRam);

            opc = this.getResources().getStringArray(R.array.sexo);
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
            cmbRam.setAdapter(adapter);

            fotos = new ArrayList<Integer>();
            fotos.add(R.drawable.images);
            fotos.add(R.drawable.images2);
            fotos.add(R.drawable.images3);

        }

        public void guardar(View v){
            String ced, nomb, apelli,id;
            int sexo, foto;
            foto = Datos.fotoAleatoria(fotos);
            ced = txtCedula.getText().toString();
            nomb  = txtNombre.getText().toString();
            apelli = txtApellido.getText().toString();
            sexo = cmbSexo.getSelectedItemPosition();
            id = Datos.getId();

            Persona p = new Persona(id,foto,ced,nomb,apelli,sexo);
            p.guardar();
            Snackbar.make(v, getResources().getString(R.string.mensaje_guardado_exitoso), Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
            limpiar();
        }

        public void limpiar(View v){
            limpiar();
        }

        public void limpiar(){
            txtCedula.setText("");
            txtNombre.setText("");
            txtApellido.setText("");
            cmbSexo.setSelection(0);
            txtCedula.requestFocus();
        }

        public void onBackPressed(){
            finish();
            Intent i = new Intent(CrearPersonas.
                    this,Principal.class);
            startActivity(i);
        }

    }
