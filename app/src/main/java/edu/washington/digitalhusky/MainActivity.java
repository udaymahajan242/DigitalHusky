package edu.washington.digitalhusky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.graphics.Color;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        toolbar.setTitle("Digital Husky.");



        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        // Create items
        AHBottomNavigationItem home = new AHBottomNavigationItem(R.string.text_home, R.drawable.ic_home_white, R.color.purple);
        AHBottomNavigationItem favorites = new AHBottomNavigationItem(R.string.text_favorites, R.drawable.ic_favorite, R.color.purple);
        AHBottomNavigationItem accounts = new AHBottomNavigationItem(R.string.text_accounts, R.drawable.ic_account_balance, R.color.purple);
        AHBottomNavigationItem scan = new AHBottomNavigationItem(R.string.text_scan, R.drawable.ic_scan, R.color.purple);

        bottomNavigation.addItem(home);
        bottomNavigation.addItem(favorites);
        bottomNavigation.addItem(accounts);
        bottomNavigation.addItem(scan);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        // Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);



        // Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        // Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.setForceTint(true);


     // Display color under navigation bar (API 21+)
    // Don't forget these lines in your style-v21
    // <item name="android:windowTranslucentNavigation">true</item>
    // <item name="android:fitsSystemWindows">true</item>
        bottomNavigation.setTranslucentNavigationEnabled(true);

        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        // Use colored navigation with circle reveal effect
        bottomNavigation.setColored(true);

// Set current item programmatically
        bottomNavigation.setCurrentItem(0);

        // Set listeners
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // Do something cool here...
                return true;
            }
        });

        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Dubs").withEmail("dubs@uw.edu").withIcon(getResources().getDrawable(R.drawable.profile))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();


        //if you want to update the items at a later time it is recommended to keep it in a variable

        PrimaryDrawerItem id  = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.ic_home_black);
        PrimaryDrawerItem dining = new PrimaryDrawerItem().withIdentifier(2).withName(" Dining Locations").withIcon(R.drawable.ic_dining_black);
        PrimaryDrawerItem feedback  = new PrimaryDrawerItem().withIdentifier(3).withName("Feedback").withIcon(R.drawable.ic_feedback_black);
        PrimaryDrawerItem logout  = new PrimaryDrawerItem().withIdentifier(4).withName("Logout").withIcon(R.drawable.ic_cancel_black);
        PrimaryDrawerItem settings = new PrimaryDrawerItem().withIdentifier(5).withName("Settings").withIcon(R.drawable.ic_settings_black);

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        id, dining, feedback, settings,logout
                        ).withSelectedItem(1)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        switch(position){

                            case 1: break;
                            case 2: {Intent dining = new Intent(MainActivity.this, Locations.class);
                                MainActivity.this.startActivity(dining);}
                            case 3: break;
                            case 4: break;
                            case 5: break;

                        }
                        return true;
                    }
                })
                .build();

    }
}
