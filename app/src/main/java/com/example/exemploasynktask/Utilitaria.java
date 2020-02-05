package com.example.exemploasynktask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Utilitaria {

    public static Bitmap obterRecurso(String url) {
        URL endereco = null;
        InputStream is = null;
        Bitmap bm = null;

        try {
            endereco = new URL(url);
            is = endereco.openStream();
            bm = BitmapFactory.decodeStream(is);
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bm;
    }

}
