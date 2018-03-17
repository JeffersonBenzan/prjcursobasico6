package com.example.jean.prj_cursobasico_6;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import ImcCalculator.ImcCalculator;
import Utilities.Utilities;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner mSpinnerPeso, mSpinnerEstatura;
    private EditText mEditTextPeso, mEditTextEstatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mEditTextEstatura = findViewById(R.id.editTextEstatura);
        mEditTextPeso = findViewById(R.id.editTextPeso);
        mSpinnerEstatura = findViewById(R.id.spinnerSelectUnitEstatura);
        mSpinnerPeso = findViewById(R.id.spinnerSelectUnitPeso);

        fillSpinners();

        findViewById(R.id.buttonSend).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        try {
            double Masa = Double.parseDouble(mEditTextPeso.getText().toString());
            String Estatura = mEditTextEstatura.getText().toString();
            ImcCalculator.PesoUnit PesoUnit = ImcCalculator.PesoUnit.valueOf(mSpinnerPeso.getSelectedItem().toString());
            ImcCalculator.EstaturaUnit EstaturaUnit = ImcCalculator.EstaturaUnit.valueOf(mSpinnerEstatura.getSelectedItem().toString());

            double ImcCalculado = ImcCalculator.CalcularImc(Masa,Estatura,EstaturaUnit,PesoUnit);
            String MensajeRecomendacion = ImcCalculator.CalcularRecomendacion(Masa,Estatura,EstaturaUnit,PesoUnit);

            String Mensaje = "Tu Indice de Masa Corporal es: "
                    + System.getProperty("line.separator")
                    + Double.toString(Utilities.Redondear(ImcCalculado))
                    + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "Estas en " + ImcCalculator.IndicarImc(ImcCalculado).toLowerCase()
                    + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + MensajeRecomendacion;

            alertDialogCustom("Estos son tus resultados:", Mensaje);
        }
        catch (Exception ex){
            //mEditTextEstatura.setError("Este campo es requerido");
            alertDialogCustom("Campos Vacios",
                    "Todos los campos necesitan estar llenos para poder calcular tu Indice de Masa Corporal");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_about:
                Intent BrowserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/JeanCCV/prjcursobasico6"));
                startActivity(BrowserIntent);
                break;
            case R.id.item_close:
                finishAffinity();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void fillSpinners(){
        ArrayAdapter<ImcCalculator.EstaturaUnit> AdapterEstatura
                = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, ImcCalculator.EstaturaUnit.values());

        ArrayAdapter<ImcCalculator.PesoUnit> AdapterPeso
                = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, ImcCalculator.PesoUnit.values());

        AdapterEstatura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AdapterPeso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        mSpinnerPeso.setAdapter(AdapterPeso);
        mSpinnerEstatura.setAdapter(AdapterEstatura);
    }

    private void alertDialogCustom(String Tittle,String Message){
        AlertDialog.Builder AlertBuilder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AlertBuilder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            AlertBuilder = new AlertDialog.Builder(this);
        }
        AlertBuilder.setTitle(Tittle)
                .setMessage(Message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }
}
