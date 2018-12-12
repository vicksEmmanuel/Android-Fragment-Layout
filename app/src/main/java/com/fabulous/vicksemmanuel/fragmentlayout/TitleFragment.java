package com.fabulous.vicksemmanuel.fragmentlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by vicksemmanuel on 1/12/2018.
 */

public class TitleFragment extends ListFragment {
    public static int currentIndex=0;
    public boolean ifHorizontal;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> supesList=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,SuperHeros.NAMES);
        setListAdapter(supesList);
        View details=getActivity().findViewById(R.id.details);
        ifHorizontal=details!=null && details.getVisibility()==View.VISIBLE;

        if(savedInstanceState!=null){
            currentIndex=savedInstanceState.getInt("index",0);
        }
        if(ifHorizontal){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(currentIndex);
        }

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        currentIndex=position;
        getListView().setItemChecked(currentIndex,true);
        showDetails(position);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index",currentIndex);
    }
    private void showDetails(int index){
        currentIndex=index;
        if(ifHorizontal){
            getListView().setItemChecked(index,true);
            DetailsFragment details=(DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
            if(details==null || details.getShownIndex()!=index){
                details=DetailsFragment.newInstance(currentIndex);
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                ft.replace(R.id.details,details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }else{
            Intent intent=new Intent(getActivity(),DetailsActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }
    }
}
