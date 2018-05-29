package com.example.android.computadores;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



    public class DetalleComputador extends AppCompatActivity {
        private TextView txtTipoDetalle;
        private TextView txtMarcaDetalle;
        private TextView txtColorDetalle;
        private TextView txtSoperativoDetalle;
        private TextView txtRamDetalle;
        private String[] rama;

        private String[] ram;
        private ImageView fot;
        private String Tipo,Marca,Apellido, Color, Soperativo;
        private int foto,Ram;
        private Intent i;
        private Bundle bundle;

        public DetalleComputador() {
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detalle_persona);
            txtTipoDetalle = findViewById(R.id.txtTipoDetalle);
            txtMarcaDetalle = findViewById(R.id.txtMarcaDetalle);
            txtColorDetalle = findViewById(R.id.txtColorDetalle);
            txtSoperativoDetalle = findViewById(R.id.SoperativoDetalle);
            fot = findViewById(R.id.foto);
            ram = getResources().getStringArray(R.array.ram);

            i = getIntent();

            bundle = i.getBundleExtra("datos");
            Tipo = bundle.getString("tipo");
            Marca = bundle.getString("marca");
            Color = bundle.getString("color");
            Soperativo = bundle.getString("Soperativo");
            Ram = bundle.getInt("ram");
            foto = bundle.getInt("foto");


            txtTipoDetalle.setText(Tipo);
            txtMarcaDetalle.setText(Marca);
            txtColorDetalle.setText(Color);
            txtSoperativoDetalle.setText(Soperativo);
            txtRamDetalle.setText(ram[rama]);
            fot.setImageResource(foto);
        }

        public void eliminar(View v){
            String positivo, negativo;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.eliminar));
            builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
            positivo = getResources().getString(R.string.positivo);
            negativo = getResources().getString(R.string.negativo);

            builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Computador p = new Computador(id);
                    p.eliminar();
                    onBackPressed();
                }
            });

            builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        }


        public void onBackPressed() {
            finish();
            Intent i = new Intent(DetalleComputador.this,Principal.class);
            startActivity(i);
        }
}
