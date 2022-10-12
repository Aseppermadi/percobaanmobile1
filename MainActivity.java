package com.example.aseppermadi_f55121049;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtwidth, edtheight, edtlength;
    private Button btncalculate;
    private TextView tvresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtwidth = findViewById(R.id.edt_width);
        edtheight = findViewById(R.id.edt_height);
        edtlength = findViewById(R.id.edt_length);
        btncalculate = findViewById(R.id.btn_calculate);
        tvresult = findViewById(R.id.tv_result);

        btncalculate.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result =
                    savedInstanceState.getString(STATE_RESULT);
            tvresult.setText(result);
            }

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_calculate) {
            String inputlength =
                    edtlength.getText().toString().trim();
            String inputwidth =
                    edtwidth.getText().toString().trim();
            String inputheigth =
                    edtheight.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputlength)) {
                isEmptyFields = true;
                edtlength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputwidth)) {
                isEmptyFields = true;
                edtwidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputheigth)) {
                isEmptyFields = true;
                edtheight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                Double volume = Double.parseDouble(inputlength) *
                        Double.parseDouble(inputwidth) * Double.parseDouble(inputheigth);
                tvresult.setText(String.valueOf(volume));
            }
        }
    }

    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT,
                tvresult.getText().toString());
        }
}