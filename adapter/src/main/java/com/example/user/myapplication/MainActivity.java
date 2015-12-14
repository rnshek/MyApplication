package com.example.user.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

public class MainActivity extends Activity {
    String[] posterName = {
            "한반도", "노트북", "수상한그녀", "뱅크잡", "퍼블릭에너미",
            "수요일", "렛", "감기", "짐승", "스니치",   "한반도", "노트북", "수상한그녀", "뱅크잡", "퍼블릭에너미",
            "수요일", "렛", "감기", "짐승", "스니치",

    };
    Integer[] posterID = {
            R.drawable.mov1, R.drawable.mov2, R.drawable.mov3, R.drawable.mov4, R.drawable.mov5,
            R.drawable.mov6, R.drawable.mov7, R.drawable.mov8, R.drawable.mov9 ,R.drawable.mov10,
            R.drawable.mov1, R.drawable.mov2, R.drawable.mov3, R.drawable.mov4, R.drawable.mov5,
            R.drawable.mov6, R.drawable.mov7, R.drawable.mov8, R.drawable.mov9 ,R.drawable.mov10,


    };

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gridView.setAdapter(gAdapter);
    }

    class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context c) {
            this.context = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        class Holder {
            TextView tv;
            ImageView img;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            TextView t;
            if(convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.image, null);

                imageView = (ImageView) convertView.findViewById(R.id.image);
                //   imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(5, 5, 5, 5);
                t = (TextView) convertView.findViewById(R.id.text);
                t.setText(posterName[position]);
                final int pos = position;
                imageView.setImageResource(posterID[position]);








           imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterName[pos]);
                    dlg.setIcon(R.drawable.ic_lanucher);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();

                }
            });
            }
            return convertView;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }
    }
}