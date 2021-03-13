package com.example.parqueadero_Julian_Silva_80806;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
    public static String Mesaje = "Seleccione los mismos campos";
    public static EditText editText;
    public static EditText editText1;
    public static TextView textView;
    public static EditText editText2;
    public static EditText editText3;
    public static Double horaE1;
    public static Double horaE2;
    public static Double total;
    public static String string;
    public static String string1;
    public static String string2;
    public static String string3;
    public static RadioButton radioButton;
    public static RadioGroup radioGroup;
    public static CheckBox checkmoto;
    public static CheckBox checkcarro;
    public static CheckBox checkcicla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void main() {
        editText = findViewById(R.id.nombreP);
        editText1 = findViewById(R.id.id_vehiculo);
        editText2 = findViewById(R.id.horaE1);
        editText3 = findViewById(R.id.horaS);
        horaE2 = Double.parseDouble(editText2.getText().toString());
        horaE1 = Double.parseDouble(editText3.getText().toString());
        textView = findViewById(R.id.valor_final);
        checkmoto = findViewById(R.id.checkmotito);
        checkcarro = findViewById(R.id.checkcarrito);
        checkcicla = findViewById(R.id.checkbicicletita);
        radioGroup = findViewById(R.id.radiogroup);
        string2 = editText1.getText().toString();
        string3 = editText.getText().toString();
        string1 = "";
    }

    public void seleccion() {
        //Mira si esta seleccionado alguno de los checks
        if (checkmoto.isChecked()) {
            string1 += (checkmoto.getText().toString());
        }
        if (checkcarro.isChecked()) {
            string1 += (checkcarro.getText().toString());
        }
        if (checkcicla.isChecked()) {
            string1 += (checkcicla.getText().toString());
        }
    }

    public void ejecutar(View mostrar) {
        //ejecutar al presionar el boton
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(checkedRadioButtonId);
        string = radioButton.getText().toString();
    }

    public void fin_proceso() {
        //reseteo de variables
        editText.setText("");
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
    }

    public void total(View V) {
        //llamado de todas las variables y funciones
        main();
        ejecutar(V);
        seleccion();
        if (string1.equals(string)) {
            total = Math.abs(horaE1 - horaE2);
            fin_proceso();
            Intent m = new Intent(MainActivity.this, RESULTADO.class);
            startActivity(m);
        } else {
            string1 = "";
            textView.setText(Mesaje);
        }

    }
}