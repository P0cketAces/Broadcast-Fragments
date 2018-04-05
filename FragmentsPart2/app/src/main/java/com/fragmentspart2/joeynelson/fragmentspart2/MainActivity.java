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

import com.fragmentspart2.joeynelson.fragmentspart2.TitlesFragment.ListSelectionListener;

public class MainActivity extends AppCompatActivity implements
        ListSelectionListener{

    public static String[] mTitleArray;
    public static String[] mAttractionsArray;
    private AttractionsFragment mDetailsFragment = new AttractionsFragment();
    private FragmentManager mFragmentManager;
    private FrameLayout mTitleFrameLayout, mAttractionsFrameLayout;
    private static final String TAG = "AttractionViewerActivity";
    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;

    @Override
    public void onListSelection(int index) {

        if (!mDetailsFragment.isAdded()) {

            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.detail_fragment_container, mDetailsFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            mFragmentManager.executePendingTransactions();
        }

        if (mDetailsFragment.getShownIndex() != index) {

            mDetailsFragment.showAttractionAtIndex(index);
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
                //do nothing since in attractions
                return true;
            case R.id.restaurants_menu:
                Intent rIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(rIntent);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the string arrays with the titles and attractions
        mTitleArray = getResources().getStringArray(R.array.AttractionsTitles);
        mAttractionsArray = getResources().getStringArray(R.array.AttractionsUrls);

        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.toolbar_1);
        setSupportActionBar(myToolbar);

        mTitleFrameLayout = findViewById(R.id.title_fragment_container);
        mAttractionsFrameLayout = findViewById(R.id.detail_fragment_container);
        mFragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.title_fragment_container, new TitlesFragment());
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

            // Make the TitleLayout take 1/3 of the layout's width
            mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT, 1f));

            // Make the AttractionsLayout take 2/3's of the layout's width
            mAttractionsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT, 2f));
        }

        else{

            // Determine whether the AttractionFragment has been added
            if (!mDetailsFragment.isAdded()) {

                // Make the TitleFragment occupy the entire layout
                mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));
                mAttractionsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
            } else {

                mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
                mAttractionsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
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
