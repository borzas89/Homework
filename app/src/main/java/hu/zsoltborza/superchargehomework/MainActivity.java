package hu.zsoltborza.superchargehomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ChessRecyclerAdapter mAdapter;
    List<String> mQueensList = new ArrayList<>();

    int boardSize = 8;

    int columnCount = 8 ;
    int rowCount = 8;

    boolean empty = false;
    boolean queen = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.chess_recycler_view);

        setupRecyclerView();


    }



    public void setupRecyclerView(){

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(MainActivity.this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        Queens.enumerate(8);
        mQueensList = Queens.placedQueens;


        mAdapter = new ChessRecyclerAdapter(MainActivity.this,mQueensList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();





    }
}
