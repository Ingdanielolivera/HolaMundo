package com.example.android.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private EditText CajaNumeroUno;
    private EditText CajaNumeroDos;
    private TextView CajaResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        CajaNumeroUno = (EditText)findViewById(R.id.txtNumeroUno);
        CajaNumeroDos = (EditText)findViewById(R.id.txtNumeroDos);
        CajaResultado = (TextView)findViewById(R.id.txtResultado);

    }

    public void calcular(View v){

        double n1,n2,suma;
        if (validar()) {
             n1 = Double.parseDouble(CajaNumeroUno.getText().toString());
             n2 = Double.parseDouble(CajaNumeroDos.getText().toString());
             suma = n1 + n2;
             CajaResultado.setText("" + suma);
        }
    }

    public void limpiar(View v){
        CajaNumeroUno.setText("");
        CajaNumeroDos.setText("");
        CajaResultado.setText("");
        CajaNumeroUno.requestFocus();
    }

    public boolean validar(){
        if (CajaNumeroUno.getText().toString().isEmpty()){
            CajaNumeroUno.setError(this.getResources().getString(R.string.error_numero_uno));
            CajaNumeroUno.requestFocus();
            return false;
        } else if (CajaNumeroDos.getText().toString().isEmpty()){
            CajaNumeroDos.setError(this.getResources().getString(R.string.error_numero_dos));
            CajaNumeroDos.requestFocus();
            return false;
        }
        return true;
    }



}
