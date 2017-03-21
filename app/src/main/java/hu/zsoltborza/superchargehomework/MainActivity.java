package hu.zsoltborza.superchargehomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ChessRecyclerAdapter.RecyclerViewClickListener {

    GridLayout mGridChess;
    RecyclerView recyclerView;
    ChessRecyclerAdapter mAdapter;
    List<String> mQueensList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.chess_recycler_view);
        mGridChess = (GridLayout) findViewById(R.id.gridlayut_chess);

        drawChessBoard();

        setupRecyclerView();


    }

    public void drawChessBoard() {
        // attaching to gridview - drawing a chessboard

        int columnCount = mGridChess.getColumnCount();
        int rowCount = mGridChess.getRowCount();

        int c;
        int r;
        for (r = 0; r < rowCount; r++) {

            for (c = 0; c < columnCount; c++) {

                if ((r + c) % 2 == 0) {
                    ChessView blackSquares = new ChessView(this, r, c, R.drawable.black);
                    mGridChess.addView(blackSquares);
                } else {
                    ChessView whiteSquares = new ChessView(this, r, c, R.drawable.white);
                    mGridChess.addView(whiteSquares);
                }

            }

        }

    }

    public void setupRecyclerView() {

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(MainActivity.this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mQueensList = EightQueen.getQueensStringList();
        mAdapter = new ChessRecyclerAdapter(MainActivity.this, this, mQueensList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();


    }

    @Override
    public void recyclerViewListClicked(View view, int position) {

        // to clear chessboard
        drawChessBoard();

        List<Position> eightList = EightQueen.getQueensPositionList();

        Position pos;

        // full list is contains 736 position so we need to multiple the position by 8
        int startPosition = position * 8;
        int endPosition = startPosition + 8;

        for (int i = startPosition; i < endPosition; ++i) {
            pos = eightList.get(i);

            // black board, white figures....
            if ((pos.getRow() + pos.getColumn()) % 2 == 0) {
                ChessView queenSquares = new ChessView(this, pos.getRow(), pos.getColumn(), R.drawable.queen_white);
                mGridChess.addView(queenSquares);
            } else {
                // white board black figures...
                ChessView queenSquares = new ChessView(this, pos.getRow(), pos.getColumn(), R.drawable.queen_black);
                mGridChess.addView(queenSquares);
            }

        }


    }


}



