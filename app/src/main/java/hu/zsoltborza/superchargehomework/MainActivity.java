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

public class MainActivity extends AppCompatActivity implements ChessRecyclerAdapter.RecyclerViewClickListener {

    GridLayout mGridChess;
    RecyclerView recyclerView;
    ChessRecyclerAdapter mAdapter;
    List<String> mQueensList = new ArrayList<>();

    int columnCount;
    int rowCount;

    int numberOfElements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.chess_recycler_view);
        mGridChess = (GridLayout) findViewById(R.id.gridlayut_chess);

        columnCount = mGridChess.getColumnCount();
        rowCount = mGridChess.getRowCount();

        numberOfElements = columnCount * rowCount;

        ChessView[] chessViews = new ChessView[numberOfElements];

        drawChessBoard();

        setupRecyclerView();


    }


    public void drawChessBoard() {

        // attaching to gridview - drawing a chessboard

        int c;
        int r;
        for (r = 0; r < rowCount; r++) {

            for (c = 0; c < columnCount; c++) {

                if ((r + c) % 2 == 0) {
                    ChessView blackSquares = new ChessView(this, r, c, R.drawable.black);
                    blackSquares.setId(View.generateViewId());
                    mGridChess.addView(blackSquares);


                } else {
                    ChessView whiteSquares = new ChessView(this, r, c, R.drawable.white);
                    whiteSquares.setId(View.generateViewId());
                    mGridChess.addView(whiteSquares);
                }

            }

        }

    }

    public List<Position> positionsCounter(String item) {



        List<Position> positionList = new ArrayList<>();

        char[] alphabet = "ABCDEFGH".toCharArray();

        for (int i = 0; i < item.length(); i++) {

            if (i % 3 == 0) {

                for (int j = 0; j < alphabet.length; j++) {
                    if (item.charAt(i) == alphabet[j]) {

                        int col = ++j;
                        int row = Integer.parseInt(String.valueOf(item.charAt(i + 1)));
                        System.out.print("column is: " + ++j);
                        // numbers - column count
                        System.out.print(" row is: " + row);

                        System.out.println();
                        Position position = new Position(col,row);

                        System.out.println("POS" + position.getColumn() + "kk"+ position.getRow());
                        positionList.add(position);


                    }
                }
            }

        }

        return positionList;
    }


    public void setupRecyclerView() {

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(MainActivity.this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mQueensList = Queens.getQueensList();

        mAdapter = new ChessRecyclerAdapter(MainActivity.this, this, mQueensList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();


    }

    @Override
    public void recyclerViewListClicked(View view, int position) {


        // to clear chessboard
        drawChessBoard();


        Position pos = positionsCounter(mQueensList.get(position)).get(0);

        ChessView blackSquares = new ChessView(this, pos.getRow(), pos.getColumn(), R.mipmap.ic_launcher);
        mGridChess.addView(blackSquares);


    }


}



