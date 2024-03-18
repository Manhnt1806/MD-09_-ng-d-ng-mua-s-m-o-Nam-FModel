package poly.manhnt.md9_datn_fmodel.Views.LoginScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import poly.manhnt.md9_datn_fmodel.R;


public class LoginActivity extends AppCompatActivity  {
    Toolbar toolbar;
    Button btnLogin, btnLoginFb;
    EditText edtPass;
    EditText edtUsername;
    ImageView imgClearUser, imgclearPass, imgEye;
    boolean isPasswordVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = findViewById(R.id.toolbarLogin);
        btnLogin = findViewById(R.id.btnLogin);
        edtPass = findViewById(R.id.edtPassLogin);
        edtUsername = findViewById(R.id.edtUsernameLogin);
        imgEye = findViewById(R.id.imgEye);
        imgclearPass = findViewById(R.id.imgClearPassLogin);
        imgClearUser = findViewById(R.id.imgClearUserLogin);
        btnLoginFb = findViewById(R.id.btnLoginFacebook);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        imgclearPass.setVisibility(View.GONE);
        isPasswordVisible = false;
        imgEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPass(isPasswordVisible);
            }
        });
        edtPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0) {
                    imgclearPass.setVisibility(View.VISIBLE);
                } else {
                    imgclearPass.setVisibility(View.GONE);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        imgclearPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPass.setText("");
            }
        });
        edtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0) {
                    imgClearUser.setVisibility(View.VISIBLE);
                } else {
                    imgClearUser.setVisibility(View.GONE);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        imgClearUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtUsername.setText("");
            }
        });
        TextWatcher loginTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int usernameInput = edtUsername.getText().toString().trim().length();
                int passwordInput = edtPass.getText().toString().trim().length();
                if(usernameInput > 0 && passwordInput > 0) {
                    btnLogin.setBackgroundColor(getResources().getColor(R.color.blue1));
                } else {
                    btnLogin.setBackgroundColor(getResources().getColor(R.color.gray3));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        };
        edtUsername.addTextChangedListener(loginTextWatcher);
        edtPass.addTextChangedListener(loginTextWatcher);
    }
    public boolean showPass(boolean count){
        if (count) {
            edtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            imgEye.setImageResource(R.drawable.ic_eye_pass);
        } else {
            edtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            imgEye.setImageResource(R.drawable.ic_eye_hide);
        }
        count = !count;
        edtPass.setSelection(edtPass.getText().length());
        return count;
    }


}