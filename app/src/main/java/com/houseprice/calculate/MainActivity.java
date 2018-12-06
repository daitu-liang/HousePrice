package com.houseprice.calculate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    TextView btn;
    @BindView(R.id.btn1)
    TextView btn1;
    @BindView(R.id.view_stub)
    ViewStub viewStub;
    private ViewStub viewStub1;
    public View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(viewStub1==null){
                    viewStub1 = (ViewStub) findViewById(R.id.view_stub);
                }
                view = viewStub1.inflate();
//                viewStub1.setVisibility(View.VISIBLE);
                if(view==null){
                    view = viewStub1.inflate();
                    TextView tv = (TextView) view.findViewById(R.id.tip);
                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this,"hahhahah",Toast.LENGTH_LONG).show();
                        }
                    });
                }else {
                    view.setVisibility(View.VISIBLE);
                }

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ViewStub viewStub2 = (ViewStub) findViewById(R.id.view_stub);
//                viewStub.setVisibility(View.VISIBLE);
                viewStub1.setVisibility(View.GONE);
//                viewStub.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
