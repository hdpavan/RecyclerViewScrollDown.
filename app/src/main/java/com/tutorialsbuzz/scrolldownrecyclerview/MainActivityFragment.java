package com.tutorialsbuzz.scrolldownrecyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class MainActivityFragment extends Fragment {

    private RecyclerView mRecyclerView = null;
    private FloatingActionButton fab = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.examplelist);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        setupRecylerView();

        return view;
    }


    private void setupRecylerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new RVAdapter(getActivity(), getData()));
    }


    @Override
    public void onResume() {
        super.onResume();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRecyclerView.smoothScrollToPosition(mRecyclerView.getAdapter().getItemCount());

            }
        });


        mRecyclerView.addOnScrollListener(new HideShowScrollListener() {
            @Override
            public void onHide() {
                fab.hide();
            }

            @Override
            public void onShow() {
                fab.show();
            }
        });


    }

    private List<String> getData() {

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stringList.add("Data " + i);
        }
        return stringList;
    }


}
