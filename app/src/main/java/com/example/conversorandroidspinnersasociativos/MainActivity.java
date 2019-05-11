package com.example.conversorandroidspinnersasociativos;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    DecimalFormat f = new DecimalFormat("0.00");
    EditText txtGrados1, txtGrados2;
    Spinner spnTemperatura1, spnTemperatura2;
    double temp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtGrados1 = findViewById(R.id.txtGrados1);
        txtGrados2 = findViewById(R.id.txtGrados2);

        spnTemperatura1 = findViewById(R.id.spnTemperatura1);
        spnTemperatura2 = findViewById(R.id.spnTemperatura2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temperatura1, android.R.layout.simple_spinner_item);
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item);

        spnTemperatura1.setAdapter(adapter);
        spnTemperatura1.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.temperatura2, android.R.layout.simple_spinner_item);

        spnTemperatura2.setAdapter(adapter2);
        spnTemperatura2.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast t = Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG);
        t.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
        t.show();

        //String dato = txtGrados1.getText().toString().trim();

        //temp = Double.parseDouble(dato);

        temp = Double.parseDouble(txtGrados1.getText().toString());

        int temp1 = spnTemperatura1.getSelectedItemPosition();
        int temp2 = spnTemperatura2.getSelectedItemPosition();

        if(txtGrados1.getText() != null){
            if ((temp1 == 0) && (temp2 == 0)){
                txtGrados1.setText("0.0");
                txtGrados2.setText("");
            }
            else if((temp1 == 1) && (temp2 == 1)){
                txtGrados2.setText(temp+"");

            }else if((temp1 == 1) && (temp2 == 2)){
                txtGrados2.setText(f.format(cfahrenheit(temp)));

            }else if((temp1 == 1) && (temp2 == 3)){
                txtGrados2.setText(f.format(ckelvin(temp)));

            }else if ((temp1 == 1) && (temp2 == 4)){
                txtGrados2.setText(f.format(crankine(temp)));

            }else if ((temp1 == 1) && (temp2 == 5)){
                txtGrados2.setText(f.format(creaumur(temp)));
            }

            else if((temp1 == 2) && (temp2 == 1)){
                txtGrados2.setText(f.format(fcelsius(temp)));

            }else if((temp1 == 2) && (temp1 == 2)){
                txtGrados2.setText(temp+"");

            }else if((temp1 == 2) && (temp2 == 3)){
                txtGrados2.setText(f.format(fkelvin(temp)));

            }else if ((temp1 == 2) && (temp2 == 4)){
                txtGrados2.setText(f.format(frankine(temp)));

            }else if ((temp1 == 2) && (temp2 == 5)){
                txtGrados2.setText(f.format(freamur(temp)));
            }

            else if ((temp1 == 3) && (temp2 == 1)){
                txtGrados2.setText(f.format(kcelsius(temp)));

            }else if((temp1 == 3) && (temp2 == 2)){
                txtGrados2.setText(f.format(kfahrenheit(temp)));

            }else if ((temp1 == 3) && (temp2 == 3)){
                txtGrados2.setText(temp+"");

            }else if ((temp1 == 3) && (temp2 == 4)){
                txtGrados2.setText(f.format(krankine(temp)));

            }else if ((temp1 == 3) && (temp2 == 5)){
                txtGrados2.setText(f.format(kreaumur(temp)));
            }

            else if ((temp1 == 4) && (temp2 == 1)){
                txtGrados2.setText(f.format(racelsius(temp)));

            }else if ((temp1 == 4) && (temp2 == 2)){
                txtGrados2.setText(f.format(rafahrenheit(temp)));

            }else if ((temp1 == 4) && (temp2 == 3)){
                txtGrados2.setText(f.format(rakelvin(temp)));

            }else if ((temp1 == 4) && (temp2 == 4)){
                txtGrados2.setText(temp+"");

            }else if ((temp1 == 4) && (temp2 == 5)){
                txtGrados2.setText(f.format(rareaumur(temp)));
            }

            else if ((temp1 == 5) && (temp2 == 1)){
                txtGrados2.setText(f.format(recelsius(temp)));

            }else if ((temp1 == 5) && (temp2 == 2)){
                txtGrados2.setText(f.format(refahrenheit(temp)));

            }else if ((temp1 == 5) && (temp2 == 3)){
                txtGrados2.setText(f.format(rekelvin(temp)));

            }else if ((temp1 == 5) && (temp2 == 4)){
                txtGrados2.setText(f.format(rerankine(temp)));

            }else if ((temp1 == 5) && (temp2 == 5)){
                txtGrados2.setText(temp+"");
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //------------------------------------------------- METODOS DE CONVERSIONES ---------------------------------------------
    //----- CELSIUS -----
    public double cfahrenheit(double c) {
        double f = (1.8 * c) + 32;
        return f;
    }
    public double ckelvin(double c) {
        double f = cfahrenheit(c);
        double k = (f + 459.67) / 1.8;
        return k;
    }
    public double crankine(double c) {
        double f = cfahrenheit(c);
        double ra = f + 459.67;
        return ra;
    }
    public double creaumur(double c) {
        double f = cfahrenheit(c);
        double re = (f - 32) / 2.25;
        return re;
    }
    //----- FIN CELSIUS -----

    //----- FAHRENHEIT -----
    public double fcelsius(double f) {
        double c = (f - 32) / 1.8;
        return c;
    }
    public double fkelvin(double f) {
        double k = (f + 459.67) / 1.8;
        return k;
    }
    public double frankine(double f) {
        double ra = f + 459.67;
        return ra;
    }
    public double freamur(double f) {
        double re = (f - 32) / 2.25;
        return re;
    }
    //----- FIN FAHRENHEIT -----

    //----- KELVIN -----
    public double kcelsius(double k) {
        double f = kfahrenheit(k);
        double c = (f - 32) / 1.8;
        return c;
    }
    public double kfahrenheit(double k) {
        double f = ((9 / 5) * k) - 459.67;
        return f;
    }
    public double krankine(double k) {
        double f = ((9 / 5) * k) - 459.67;
        double ra = f + 459.67;
        return ra;
    }
    public double kreaumur(double k) {
        double f = ((9 / 5) * k) - 459.67;
        double re = (f - 32) / 2.25;
        return re;
    }
    //----- FIN KELVIN -----

    //----- RANKINE -----
    public double racelsius(double ra) {
        double f = rafahrenheit(ra);
        double c = (f - 32) / 1.8;
        return c;
    }
    public double rafahrenheit(double ra) {
        double f = ra - 459.67;
        return f;
    }
    public double rakelvin(double ra) {
        double f = ra - 459.67;
        double k = (f + 459.67) / 1.8;
        return k;
    }
    public double rareaumur(double ra) {
        double f = ra - 459.67;
        double re = (f - 32) / 2.25;
        return re;
    }
    //----- FIN RANKINE -----

    //----- RÉAUMUR -----
    public double recelsius(double re) {
        double f = refahrenheit(re);
        double c = (f - 32) / 1.8;
        return c;
    }
    public double refahrenheit(double re) {
        double f = (2.25 * re) + 32;
        return f;
    }
    public double rekelvin(double re) {
        double f = refahrenheit(re);
        double k = fkelvin(f);
        return k;
    }
    public double rerankine(double re) {
        double f = refahrenheit(re);
        double ra = f + 459.67;
        return ra;
    }
    //----- FIN RÉAMUR -----
}
