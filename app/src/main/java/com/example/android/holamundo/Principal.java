package com.example.android.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private EditText CajaNumeroUno;
    private EditText CajaNumeroDos;
    private TextView CajaResultado;
    private Spinner comboOpciones;
    private String[] opciones;
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        CajaNumeroUno = (EditText) findViewById(R.id.txtNumeroUno);
        CajaNumeroDos = (EditText) findViewById(R.id.txtNumeroDos);
        CajaResultado = (TextView) findViewById(R.id.txtResultado);
        comboOpciones = (Spinner) findViewById(R.id.cmbOperaciones);

        opciones =  this.getResources().getStringArray(R.array.opciones);
        adapter =   new ArrayAdapter(this,android.R.layout.simple_list_item_1,opciones);
        comboOpciones.setAdapter(adapter);
    }

    public void calcular(View v){
        int op;
        double n1,n2,res=0;
        if (validar()) {
            n1 = Double.parseDouble(CajaNumeroUno.getText().toString());
            n2 = Double.parseDouble(CajaNumeroDos.getText().toString());

            op = comboOpciones.getSelectedItemPosition();
            switch (op){
                case 0:
                    res = n1+n2;
                    break;
                case 1:
                    res = n1-n2;
                    break;
                case 2:
                    res = n1*n2;
                    break;
                case 3:
                    res = n1/n2;
                    break;

            }
            CajaResultado.setText("" + res);
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
        }if(comboOpciones.getSelectedItemPosition()==3 && Double.parseDouble(CajaNumeroDos.getText().toString())==0){
            CajaNumeroDos.requestFocus();
            CajaNumeroDos.setError(this.getResources().getString(R.string.error_numero_dos_cero));
            return false;
        }
        return true;
    }



}
