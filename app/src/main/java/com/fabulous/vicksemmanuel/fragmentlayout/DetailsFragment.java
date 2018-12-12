package com.fabulous.vicksemmanuel.fragmentlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by vicksemmanuel on 1/12/2018.
 */

public class DetailsFragment extends Fragment {
    public static DetailsFragment newInstance(int index){
        DetailsFragment details=new DetailsFragment();
        Bundle args=new Bundle();
        args.putInt("index",index);
        details.setArguments(args);
        return details;
    }
    public int getShownIndex(){
        return getArguments().getInt("index",0);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ScrollView scrollView=new ScrollView(getActivity());
        TextView textView=new TextView(getActivity());
        int padding=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,4,getActivity().getResources().getDisplayMetrics());
        textView.setPadding(padding,padding,padding,padding);
        scrollView.addView(textView);
        textView.setText(SuperHeros.HISTORY[getShownIndex()]);
        return scrollView;
    }
}
