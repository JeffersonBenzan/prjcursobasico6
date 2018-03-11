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
            double masa = Double.parseDouble(mEditTextPeso.getText().toString());
            double estatura = Double.parseDouble(mEditTextEstatura.getText().toString());
            ImcCalculator.PesoUnit pesoUnit = ImcCalculator.PesoUnit.valueOf(mSpinnerPeso.getSelectedItem().toString());
            ImcCalculator.EstaturaUnit estaturaUnit = ImcCalculator.EstaturaUnit.valueOf(mSpinnerEstatura.getSelectedItem().toString());

            double ImcCalculado = ImcCalculator.calcularImc(masa,estatura,estaturaUnit,pesoUnit);

            String mensaje = "Tu Indice de Masa Corporal es: "
                    + Double.toString(utilities.redondear(ImcCalculado))
                    + System.getProperty("line.separator")
                    + "Estas en " + ImcCalculator.indicarImc(ImcCalculado).toLowerCase();

            alertDialogCustom("Estos son tus resultados:", mensaje);
        }
        catch (Exception ex){
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
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/JeanCCV/prjcursobasico6"));
                startActivity(browserIntent);
                break;
            case R.id.item_close:
                finishAffinity();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void fillSpinners(){
        ArrayAdapter<ImcCalculator.EstaturaUnit> adapterEstatura
                = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, ImcCalculator.EstaturaUnit.values());

        ArrayAdapter<ImcCalculator.PesoUnit> adapterPeso
                = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, ImcCalculator.PesoUnit.values());

        adapterEstatura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterPeso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        mSpinnerPeso.setAdapter(adapterPeso);
        mSpinnerEstatura.setAdapter(adapterEstatura);
    }

    private void alertDialogCustom(String tittle,String message){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle(tittle)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }
}
