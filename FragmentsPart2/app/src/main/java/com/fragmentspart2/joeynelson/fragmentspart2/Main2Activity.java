package com.fragmentspart2.joeynelson.fragmentspart2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.fragmentspart2.joeynelson.fragmentspart2.Titles2Fragment.ListSelection2Listener;

public class Main2Activity extends AppCompatActivity implements
        ListSelection2Listener {

    public static String[] mTitle2Array;
    public static String[] mRestaurantsArray;
    private RestaurantsFragment mDetailsFragment = new RestaurantsFragment();
    private FragmentManager mFragmentManager;
    private FrameLayout mTitleFrameLayout, mRestaurantsFrameLayout;
    private static final String TAG = "RestaurantViewerActivity";
    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;

    @Override
    public void onListSelection(int index) {

        if (!mDetailsFragment.isAdded()) {

            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.detail2_fragment_container, mDetailsFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            mFragmentManager.executePendingTransactions();
        }

        if (mDetailsFragment.getShownIndex() != index) {

            mDetailsFragment.showRestaurantAtIndex(index);
        }
    }

    // Create Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    // Process clicks on Options Menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.attractions_menu:
                Intent aIntent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(aIntent);
                return true;
            case R.id.restaurants_menu:
                // do nothing since in restaurants
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the string arrays with the titles and Restaurants
        mTitle2Array = getResources().getStringArray(R.array.RestaurantsTitles);
        mRestaurantsArray = getResources().getStringArray(R.array.RestaurantsUrls);

        setContentView(R.layout.activity2_main);
        Toolbar myToolbar = findViewById(R.id.toolbar_2);
        setSupportActionBar(myToolbar);

        mTitleFrameLayout = (FrameLayout) findViewById(R.id.title2_fragment_container);
        mRestaurantsFrameLayout = (FrameLayout) findViewById(R.id.detail2_fragment_container);
        mFragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.title2_fragment_container, new Titles2Fragment());
        fragmentTransaction.commit();

        // Add a OnBackStackChangedListener to reset the layout when the back stack changes
        mFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            public void onBackStackChanged() {
                setLayout();
            }
        });
    }

    private void setLayout() {

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

            // Make the Title2Layout take 1/3 of the layout's width
            mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT, 1f));

            // Make the RestaurantsLayout take 2/3's of the layout's width
            mRestaurantsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT, 2f));
        }

        else{

            // Determine whether the RestaurantFragment has been added
            if (!mDetailsFragment.isAdded()) {

                // Make the Title2Fragment occupy the entire layout
                mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));
                mRestaurantsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
            } else {

                mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
                mRestaurantsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));
            }
        }
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onRestart()");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
        super.onStop();
    }
}
