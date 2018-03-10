package com.example.jean.prj_cursobasico_6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
