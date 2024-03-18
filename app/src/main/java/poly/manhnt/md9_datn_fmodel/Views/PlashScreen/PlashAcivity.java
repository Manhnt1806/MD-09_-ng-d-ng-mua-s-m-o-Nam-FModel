package poly.manhnt.md9_datn_fmodel.Views.PlashScreen;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import poly.manhnt.md9_datn_fmodel.R;
import poly.manhnt.md9_datn_fmodel.Views.HomeScreen.HomeActivity;
import poly.manhnt.md9_datn_fmodel.Views.LoginScreen.LoginActivity;
import poly.manhnt.md9_datn_fmodel.Views.RegisterScreen.RegisterActivity;

public class PlashAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plash);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (Exception e){

                }finally {
                    Intent intent = new Intent(PlashAcivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        thread.start();
    }
}