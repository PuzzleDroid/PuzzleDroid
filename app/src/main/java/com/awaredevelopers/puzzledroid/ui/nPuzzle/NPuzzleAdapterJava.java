package com.awaredevelopers.puzzledroid.ui.nPuzzle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.awaredevelopers.puzzledroid.R;

public class NPuzzleAdapterJava extends BaseAdapter {


    //TODO por eliminar...
    // Contexto de la aplicación
    private Context mContext;

    // Array de identificadores
    private Integer[] mThumbIds = {
//            R.drawable.e1, R.drawable.e2, R.drawable.e3,
//            R.drawable.e4,R.drawable.e5, R.drawable.e6,
//            R.drawable.e7,R.drawable.e8, R.drawable.e9,
//            R.drawable.e10,R.drawable.e11, R.drawable.e12,
//            R.drawable.e13,R.drawable.e14, R.drawable.e15,
//            R.drawable.e1,R.drawable.e2, R.drawable.e3,
//            R.drawable.e4,R.drawable.e5, R.drawable.e6,
//            R.drawable.e7,R.drawable.e8, R.drawable.e9
            R.drawable.common_google_signin_btn_icon_dark,
            R.drawable.common_google_signin_btn_icon_light,
            R.drawable.common_google_signin_btn_text_dark,
            R.drawable.common_google_signin_btn_icon_dark,
            R.drawable.common_google_signin_btn_icon_light,
            R.drawable.common_google_signin_btn_text_dark,
            R.drawable.common_google_signin_btn_icon_dark,
            R.drawable.common_google_signin_btn_icon_light,
            R.drawable.common_google_signin_btn_text_dark,
            R.drawable.common_google_signin_btn_icon_dark,
            R.drawable.common_google_signin_btn_icon_light,
            R.drawable.common_google_signin_btn_text_dark,
    };

    public NPuzzleAdapterJava(Context context) {
        mContext = context;
    }

    public int getCount() {
        //Number of elements to show
//        return mThumbIds.length;
        return 6;

    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public int getThumbId(int position){return mThumbIds[position];}

    public View getView(int position, View convertView, ViewGroup parent) {
        //ImageView a retornar
        ImageView imageView;

        if (convertView == null) {
            /*
            Crear un nuevo Image View de 90x90
            y con recorte alrededor del centro
             */
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200,200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        //Setear la imagen desde el recurso drawable
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

}
