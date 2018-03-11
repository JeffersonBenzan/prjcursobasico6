package com.example.jean.prj_cursobasico_6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
        double masa = Double.parseDouble(mEditTextPeso.getText().toString());
        double estatura = Double.parseDouble(mEditTextEstatura.getText().toString());
        ImcCalculator.PesoUnit pesoUnit = ImcCalculator.PesoUnit.valueOf(mSpinnerPeso.getSelectedItem().toString());
        ImcCalculator.EstaturaUnit estaturaUnit = ImcCalculator.EstaturaUnit.valueOf(mSpinnerEstatura.getSelectedItem().toString());

        double ImcCalculado = ImcCalculator.calcularImc(masa,estatura,estaturaUnit,pesoUnit);

        String resultado = ImcCalculator.indicarImc(ImcCalculado);

        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
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
}
