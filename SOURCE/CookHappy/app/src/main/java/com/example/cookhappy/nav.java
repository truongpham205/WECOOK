package com.example.cookhappy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.cookhappy.activity.Home;
import com.example.cookhappy.activity.Login;
import com.example.cookhappy.activity.MapsActivity;
import com.example.cookhappy.activity.telephone;
import com.example.cookhappy.adapter.MonanDD;

public class nav extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    //Menu tìm kiếm: theo Bữa sáng, trức, tối.
    public void clickchebien(View view) {
        redirectActivity(this, Home.Lvplace.class);
    }

    public void clickdd(View view) {
        redirectActivity(this, MonanDD.class);
    }

    public void clicksearch(View view) {
        //Call to quanngon on internet.
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.foody.vn/"));
        startActivity(i);
    }

    //Menu left
    public void ClickMenu(View view) {
        //mở drawer
        openDrawer(drawerLayout);

    }

    private static void openDrawer(DrawerLayout drawerLayout) {
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view) {
        //đóng drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view) {
        //Recreate activity
        recreate();
    }

    public void ClickDashboard(View view) {
        //Redirect activity to dashboard
        redirectActivity(this, Home.Lvplace.class);

    }

    public void Clickggmap(View view) {
        //Redirect activity to dashboard
        redirectActivity(this, MapsActivity.class);

    }

    public void ClickEmail(View view) {
        redirectActivity(this);
    }

    public void Clickphone(View view) {
        redirectActivity(this, telephone.class);
    }


    private void redirectActivity(nav nav) {
        Intent si = new Intent(Intent.ACTION_SEND);
        si.setType("message/rfc822");
        si.putExtra(Intent.EXTRA_EMAIL, new String[]{"cookhappyvn@gmail.com"});
        si.putExtra(Intent.EXTRA_SUBJECT, "Chào mừng bạn tới với CookHappy");
        si.putExtra(Intent.EXTRA_TEXT, "Hi! Chào bạn \n Hãy cho tôi xin ý kiến để chúng tôi hoàn thiện hơn nhé! \n Chúc bạn và gia đình một ngày tốt lành <3");
        startActivity(Intent.createChooser(si, "Choose Mail App"));
    }


    public void ClickLogout(View view) {
        logout(this);
    }

    public static void logout(Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        //Positive yes button
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finish
                Intent intent = new Intent(activity,Login.class);
                activity.startActivity(intent);
                activity.finish();
            }
        });
        //Nagative
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Dissmiss dialog
                dialog.dismiss();
            }
        });
        builder.show();

    }

    public static void redirectActivity(Activity activity, Class aClass) {
        //Initialize intent
        Intent i = new Intent(activity, aClass);
        //set flag
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //start activity
        activity.startActivity(i);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close
        closeDrawer(drawerLayout);
    }
}