package hu.zsoltborza.superchargehomework;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.GridLayout;

/**
 * Created by Borzas on 2017. 03. 13.
 * Custom view class for displaying Queens for GridLayout.
 */

public class ChessView extends View {

    protected int mRow;
    protected int mColumn;

    protected Drawable mTablePiece;
    protected Drawable mChessQueen;


    public ChessView(Context context, int row, int column, int queenImage) {
        super(context);

        mRow = row;
        mColumn = column;

        // under 21 level api use the next commented line....
        // mFront = AppCompatDrawableManager.get().getDrawable(context,frontImageId)
        mChessQueen = context.getDrawable(queenImage);

        setBackground(mChessQueen);

       // mTablePiece = context.getDrawable(R.drawable.question);
      //  setBackground(mTablePiece);

        GridLayout.LayoutParams tempParams = new GridLayout.LayoutParams(GridLayout.spec(row),GridLayout.spec(column));

        tempParams.width = (int) getResources().getDisplayMetrics().density*40;
        tempParams.height = (int) getResources().getDisplayMetrics().density*40;

        setLayoutParams(tempParams);
    }
}
