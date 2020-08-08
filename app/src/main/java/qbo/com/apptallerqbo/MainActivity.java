package qbo.com.apptallerqbo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText ettalla, etpeso;
    private Button btncalcularimc;
    private TextView tvresultadoimc;
    private ListView lvimc;
    private List<String> listimc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etpeso = findViewById(R.id.etpeso);
        ettalla = findViewById(R.id.ettalla);
        btncalcularimc = findViewById(R.id.btncalcularimc);
        tvresultadoimc = findViewById(R.id.tvresultadoimc);
        lvimc = findViewById(R.id.lvimc);
        listimc = new ArrayList<>();

        btncalcularimc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etpeso.getText().toString().equals("")){
                    etpeso.setError("Ingrese su peso.");
                } else if(ettalla.getText().toString().equals("")){
                    ettalla.setError("Ingrese su talla.");
                }else{
                    Double peso, talla, tallam, imc;
                    String resultadoimc ="";
                    peso = Double.parseDouble(etpeso.getText().toString());
                    talla = Double.parseDouble(ettalla.getText().toString());
                    tallam = talla / 100;
                    imc = peso / (tallam * tallam);
                    if(imc <= 18.5){
                        resultadoimc = "Por debajo del peso";
                    }else if(imc <= 25){
                        resultadoimc = "Con peso normal";
                    }else if(imc <= 30){
                        resultadoimc = "Con sobrepeso";
                    }else if(imc <= 35){
                        resultadoimc = "Obesidad leve";
                    }else if(imc <= 39){
                        resultadoimc = "Obsidad media";
                    }else{
                        resultadoimc = "Obesidad mórbida";
                    }
                    DecimalFormat df = new DecimalFormat("##.00");

                    tvresultadoimc.setText("Su valor de imc es: "+ df.format(imc)
                            + " ud. se encuentra: "+resultadoimc);
                    listimc.add("Valor imc: "+ df.format(imc));
                    ArrayAdapter adapter = new ArrayAdapter(
                            MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            listimc
                    );
                    lvimc.setAdapter(adapter);
                    //Toast.makeText(getApplicationContext(), "Calcular IMC", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
