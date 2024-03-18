package poly.manhnt.md9_datn_fmodel.Views.HomeScreen;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import poly.manhnt.md9_datn_fmodel.Adapters.NoiBatAdapter;
import poly.manhnt.md9_datn_fmodel.Adapters.ViewPagerAdapter;
import poly.manhnt.md9_datn_fmodel.R;


public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    private int currentPosition = 0;
    ViewPagerAdapter viewPagerAdapter;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NestedScrollView scrollView;
    RecyclerView recyclerView;
    NoiBatAdapter noiBatAdapter;
    private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        drawerLayout = findViewById(R.id.drawerLayout);
        scrollView = findViewById(R.id.nestedScrollHome);
        recyclerView = findViewById(R.id.recyclerNoiBat);

        List<String> list = new ArrayList<>();
        for(int i=0; i<20; i++){
            String ten = "Phụ kiện [Ghế xoay văn phòng] (kiểm tra mẫu trước khi đặt hàng với shop)"+ i;
            list.add(ten);
        };
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        noiBatAdapter = new NoiBatAdapter(this, list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(noiBatAdapter);
        noiBatAdapter.notifyDataSetChanged();

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        startAutoScroll();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        int scrollLimit = 256;
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                float alpha = Math.min(1, (float) scrollY / scrollLimit);
                int alphaInt = (int) (alpha * 255);
                if (scrollY > oldScrollY) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(Color.argb(alphaInt, 0, 169, 255));
                    }
                    toolbar.setBackgroundColor(Color.argb(alphaInt, 0, 169, 255));
                    drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
                } else if(scrollY == 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(Color.TRANSPARENT);
                    }
                    toolbar.setBackgroundColor(Color.TRANSPARENT);
                    drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.blue1));
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.homemenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return true ;
    }
    private void startAutoScroll() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                currentPosition++;
                if (currentPosition >= viewPagerAdapter.getCount()) {
                    currentPosition = 0;
                }
                viewPager.setCurrentItem(currentPosition);
                startAutoScroll();
            }
        }, 3000);

    }
}