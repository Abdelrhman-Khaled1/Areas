package com.example.areas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getBaseContext(),"Hello ",Toast.LENGTH_LONG).show();

        Spinner sp_shapes = findViewById(R.id.areas_sp_shapes);
        EditText et_rectangle_width = findViewById(R.id.areas_et_rectangle_width);
        EditText et_rectangle_height = findViewById(R.id.areas_et_rectangle_Height);
        EditText et_circle_radius = findViewById(R.id.areas_et_circle_radius);
        EditText et_triangle_base = findViewById(R.id.areas_et_triangle_Base);
        EditText et_triangle_height = findViewById(R.id.areas_et_triangle_Height);
         tv_result = findViewById(R.id.area_tv_result);
        Button btn_calculate = findViewById(R.id.areas_btn_calculate);

        sp_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        //rectangle
                        et_rectangle_width.setVisibility(view.VISIBLE);
                        et_rectangle_height.setVisibility(view.VISIBLE);
                        et_circle_radius.setVisibility(view.GONE);
                        et_triangle_base.setVisibility(view.GONE);
                        et_triangle_height.setVisibility(view.GONE);
                        break;
                    case 1:
                        //circle
                        et_rectangle_width.setVisibility(view.GONE);
                        et_rectangle_height.setVisibility(view.GONE);
                        et_circle_radius.setVisibility(view.VISIBLE);
                        et_triangle_base.setVisibility(view.GONE);
                        et_triangle_height.setVisibility(view.GONE);
                        break;
                    case 2:
                        //triangle
                        et_rectangle_width.setVisibility(view.GONE);
                        et_rectangle_height.setVisibility(view.GONE);
                        et_circle_radius.setVisibility(view.GONE);
                        et_triangle_base.setVisibility(view.VISIBLE);
                        et_triangle_height.setVisibility(view.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = sp_shapes.getSelectedItemPosition();
                double area =0;
                switch (index){
                    case 0:
                        //rectangle
                        double rect_width = Double.parseDouble(et_rectangle_width.getText().toString());
                        double rect_height = Double.parseDouble(et_rectangle_height.getText().toString());
                        area = rect_width * rect_height ;
                        break;
                    case 1:
                        //circle
                        double cir_red = Double.parseDouble(et_circle_radius.getText().toString());
                        area = Math.PI * Math.pow(cir_red,2);
                        break;
                    case 2:
                        //triangle
                        double triangle_Base = Double.parseDouble(et_triangle_base.getText().toString());
                        double triangle_height = Double.parseDouble(et_triangle_height.getText().toString());
                        area = 0.5 * triangle_Base * triangle_height ;
                        break;
                }
                tv_result.setText(area+"");
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getBaseContext(),"Lets contain",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getBaseContext(),"We are waiting you ",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("result",tv_result.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv_result.setText(savedInstanceState.getString("result"));
    }
}