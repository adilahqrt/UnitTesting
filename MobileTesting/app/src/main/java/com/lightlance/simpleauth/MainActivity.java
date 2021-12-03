package com.lightlance.simpleauth;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.lightlance.simpleauth.api.ApiConfig;
import com.lightlance.simpleauth.api.ApiService;
import com.lightlance.simpleauth.api.model.LoginUser;
import com.lightlance.simpleauth.api.responses.LoginResponse;
import com.lightlance.simpleauth.utils.Validator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText edtEmail;
    private TextInputEditText edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            assert edtEmail.getText() != null && edtPassword.getText() != null;

            String email = edtEmail.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            if (validate(email, password)) {
                LoginUser loginUser = new LoginUser(email, password);

                ApiService service = ApiConfig.getApiService();
                service.login(loginUser).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Log.d("LOGIN_RESULT", "onResponse: ");
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.e("LOGIN_RESULT", "onFailure: ", t);
                    }
                });
            }
        }
    }

    private boolean validate(String email, String password) {
        if (email.isEmpty()) {
            edtEmail.setError("This field can't be empty!");
        } else if (!Validator.validateEmail(email)) {
            edtEmail.setError("Email is invalid!");
        }

        if (password.isEmpty()) {
            edtPassword.setError("This field can't be empty!");
        } else if (!Validator.validateCharLength(password, 6)) {
            edtPassword.setError("Password at least 6 character!");
        }

        return edtEmail.getError() == null && edtPassword.getError() == null;
    }
}