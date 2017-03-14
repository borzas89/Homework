package hu.zsoltborza.superchargehomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ChessRecyclerAdapter mAdapter;
    List<String> mQueensList = new ArrayList<>();

    int boardSize = 8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.chess_recycler_view);
        GridLayout mGridChess = (GridLayout) findViewById(R.id.gridlayut_chess);

        int columnCount = mGridChess.getColumnCount() ;
        int rowCount = mGridChess.getRowCount();

        setupRecyclerView();

        // attaching to gridview - drawing a chessboard
        int c;
        for (int r = 0; r < rowCount; r++) {

            for ( c = 0; c < columnCount; c++) {

                if((r+c)%2==0){
                    ChessView blackSquares = new ChessView(this, r, c,R.drawable.black);
                    blackSquares.setId(View.generateViewId());
                    mGridChess.addView(blackSquares);
                }else{
                    ChessView whiteSquares = new ChessView(this, r, c,R.drawable.white);
                    whiteSquares.setId(View.generateViewId());
                    mGridChess.addView(whiteSquares);
                }

            }

       }

    }





    public void setupRecyclerView(){

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(MainActivity.this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mQueensList = Queens.getQueensList(boardSize);

        mAdapter = new ChessRecyclerAdapter(MainActivity.this,mQueensList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        



    }
}
