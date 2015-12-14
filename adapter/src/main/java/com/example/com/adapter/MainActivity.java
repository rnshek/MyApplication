package com.example.com.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.myapplication.R;


public class MainActivity extends AppCompatActivity {

    Integer[] posterID = {
            R.drawable.title1, R.drawable.title2, R.drawable.title3, R.drawable.title4
    };
    String[] posterID2 = {
      "신세계","괴물","하울링","달처럼"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView gv = (GridView) findViewById(R.id.gridView);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter{
        Context context;
        public MyGridAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
         }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.adapter, null);
                convertView.setLayoutParams(new GridView.LayoutParams(400, 600));

                ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView2);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(5, 5, 5, 5);

                imageView.setImageResource(posterID[position]);

                TextView tv = (TextView) convertView.findViewById(R.id.textView);
                tv.setText("제목 : " + posterID2[position]);

                final int pos = position;
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                        ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.imageView);
                        ivPoster.setImageResource(posterID[pos]);
                        dlg.setTitle(posterID2[pos]);
                        dlg.setIcon(R.drawable.icon);
                        dlg.setView(dialogView);
                        dlg.setNegativeButton("닫기", null);
                        dlg.show();
                    }
                });
            }
            return convertView;
        }
    }
}
