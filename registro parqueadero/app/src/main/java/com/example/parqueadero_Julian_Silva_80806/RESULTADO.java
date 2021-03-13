package com.example.parqueadero_Julian_Silva_80806;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RESULTADO extends AppCompatActivity {
    public static TextView Mpantalla;
    public static TextView valor_final;

    //precio por hora
    public int minutoCarro =70;
    public int minutoMoto =40;
    public int minutoBicicleta =20;

    public static Double resultado=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_person);
        main();
        Tejecu();
        String str="Nombre : " + MainActivity.string3+" \nVehiculo: "+ MainActivity.string +"\nPlaca:"+ MainActivity.string2 +
                "\nHora de entrada: "+MainActivity.horaE1 +"\nHora de Salida: "+MainActivity.horaE2 +"\nCosto Por hora: ";
        str+=cont();
        str+="\n\nTotal: "+resultado;
        Mpantalla.setText(str);
    }
    public void main(){
        Mpantalla = findViewById(R.id.Personita);
        valor_final = findViewById(R.id.costototal);
    }
    public String cont(){
        if (MainActivity.string.equals("Carro")) {
            return (minutoCarro +"\n");
        } else if (MainActivity.string.equals("Moto")) {
            return (minutoMoto +"\n");
        } else {
            return (minutoBicicleta +"\n");
        }
    }
    public void Tejecu(){
        try {
            String str="Total: ";
            if (MainActivity.string.equals("Carro")) {
                resultado = MainActivity.total * minutoCarro;
                str+=resultado.toString();
                valor_final.setText(str);
            } else if (MainActivity.string.equals("Moto")) {
                resultado = MainActivity.total * minutoMoto;
                str+=resultado.toString();
                valor_final.setText(str);
            } else {
                resultado = MainActivity.total * minutoBicicleta;
                str+=resultado.toString();
                valor_final.setText(str);
            }
        }catch (Exception e){
            Intent m = new Intent(RESULTADO.this, MainActivity.class);
            MainActivity.textView.setText("*Error* no se encuentran los campos intente mas tarde");
            startActivity(m);
        }
    }


}