package com.fragmentspart2.joeynelson.fragmentspart2;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by Joey on 3/27/2018.
 */

public class AttractionsFragment extends Fragment {

    private WebView mAttractionsView;
    private int mCurrIdx = -1;
    private int mAttractionsArrayLen = 0;
    private static final String TAG = "AttractionsFragment";

    public int getShownIndex() {
        return mCurrIdx;
    }

    public void showAttractionAtIndex(int newIndex) {
        if (newIndex < 0 || newIndex >= mAttractionsArrayLen)
            return;
        mCurrIdx = newIndex;
        mAttractionsView.loadUrl(MainActivity.mAttractionsArray[mCurrIdx]);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":onCreate()");
        super.onCreate(savedInstanceState);

        // Retain this Fragment across Activity reconfigurations
        setRetainInstance(true);

    }

    // Called to create the content view for this Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":onCreateView()");

        View v = inflater.inflate(R.layout.attractions_fragment, container, false);
        mAttractionsView = (WebView) v.findViewById(R.id.attractionsView);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":onActivityCreated()");
        super.onActivityCreated(savedInstanceState);

        mAttractionsArrayLen = MainActivity.mAttractionsArray.length;
        showAttractionAtIndex(mCurrIdx);
    }

    @Override
    public void onAttach(Context activity) {
        Log.i(TAG, getClass().getSimpleName() + ":onAttach()");
        super.onAttach(activity);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i(TAG, getClass().getSimpleName() + ":onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, getClass().getSimpleName() + ":onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, getClass().getSimpleName() + ":onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, getClass().getSimpleName() + ":onDetach()");
        super.onDetach();
    }

    @Override
    public void onPause() {
        Log.i(TAG, getClass().getSimpleName() + ":onPause()");
        super.onPause();
    }

    @Override
    public void onResume() {
        Log.i(TAG, getClass().getSimpleName() + ":onResume()");
        super.onResume();
    }

    @Override
    public void onStart() {
        Log.i(TAG, getClass().getSimpleName() + ":onStart()");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.i(TAG, getClass().getSimpleName() + ":onStop()");
        super.onStop();
    }
}
