/*Fonte: https://www.devmedia.com.br/trabalhando-com-asynctask-no-android/33481*/
package com.example.exemploasynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private Button btn;
    private EditText et;
    private ProgressDialog tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.imgViewLogo);
        btn = findViewById(R.id.btnClicar);
        et = findViewById(R.id.etTextURL);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acionarTarefa(et.getText().toString());
            }
        });

    }//onCreate

    private void acionarTarefa(String url) {
        ExecutaDownload ed = new ExecutaDownload();
        ed.execute(url);

    }//acionarTarefa

    private class ExecutaDownload extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tela = ProgressDialog.show(MainActivity.this, "AGUARDE", "baixando recurso");
        }//method

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = null;
            bitmap = Utilitaria.obterRecurso(strings[0]);
            return bitmap;

        }//method

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            iv.setImageBitmap(bitmap);
            tela.dismiss();

        }//method

    }//private class

}//class
