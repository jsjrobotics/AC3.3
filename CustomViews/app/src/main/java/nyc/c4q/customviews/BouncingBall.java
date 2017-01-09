package nyc.c4q.customviews;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class BouncingBall extends View {
    private static final int DEFAULT_RADIUS_DP = 10;
    private static final int DEFAULT_X_SPEED_DP = 5;
    private static final int DEFAULT_Y_SPEED_DP = 0;
    private static final int INVALID = -1;
    private static final int DEFAULT_COLOR = 0xFFF11223;
    private Point mPreviousPosition;
    private Point mNextPostion;

    private int mHorizontalSpeed = INVALID;
    private int mVeriticalSpeed = INVALID;
    private int mBallRadius = INVALID;
    private int mBallColor = INVALID;

    private boolean mIncrementingX;
    private boolean mIncrementingY;
    private int mMaxCenterX;
    private int mMaxCenterY;
    private int mMinCenterX;
    private int mMinCenterY;
    private Paint mPaint;

    public BouncingBall(Context context) {
        super(context);
    }

    public BouncingBall(Context context, AttributeSet attrs) {
        super(context, attrs);
        extractXmlAttributes(attrs);
    }

    public BouncingBall(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        extractXmlAttributes(attrs);
    }

    private void extractXmlAttributes(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.BouncingBall,
                0, 0);
        mBallRadius = typedArray.getDimensionPixelSize(R.styleable.BouncingBall_radius, INVALID);
        mHorizontalSpeed = typedArray.getDimensionPixelSize(R.styleable.BouncingBall_xSpeed, INVALID);
        mVeriticalSpeed = typedArray.getDimensionPixelSize(R.styleable.BouncingBall_ySpeed, INVALID);
        mBallColor = typedArray.getColor(R.styleable.BouncingBall_color, INVALID);
        typedArray.recycle();
    }
    @Override
    public void onSizeChanged(int width, int height, int oldWidth, int oldHeight){
        init();

        mIncrementingX = true;
        mIncrementingY = true;
        mMaxCenterX = width - mBallRadius;
        mMaxCenterY = height - mBallRadius;
        mMinCenterX = mBallRadius;
        mMinCenterY = mBallRadius;
        mPreviousPosition = new Point(mMinCenterX, mMinCenterY);
        mNextPostion = new Point(mMinCenterX, mMinCenterY);

    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(mNextPostion.x - mBallRadius,
                        mNextPostion.y - mBallRadius,
                        mNextPostion.x + mBallRadius,
                        mNextPostion.y + mBallRadius,
                        mPaint);

    }

    private void init(){
        Context context = getContext();
        if (mBallRadius == INVALID) {
            mBallRadius = (int) dpToPx(context, DEFAULT_RADIUS_DP);
        }
        if (mHorizontalSpeed == INVALID) {
            mHorizontalSpeed = (int) dpToPx(getContext(), DEFAULT_X_SPEED_DP);
        }
        if (mVeriticalSpeed == INVALID) {
            mVeriticalSpeed = (int) dpToPx(getContext(), DEFAULT_Y_SPEED_DP);
        }
        mPaint = new Paint();
        if (mBallColor != INVALID){
            mPaint.setColor(mBallColor);
        } else {
            mPaint.setColor(DEFAULT_COLOR);
        }
    }

    private Point calculateNextPostion() {
        if (mPreviousPosition != null){
            int potentialNextX = mIncrementingX ? mPreviousPosition.x + mHorizontalSpeed : mPreviousPosition.x - mHorizontalSpeed;
            if (potentialNextX > mMaxCenterX || potentialNextX < mMinCenterX) {
                mIncrementingX = !mIncrementingX;
                potentialNextX = mPreviousPosition.x;
            }

            int potentialNextY = mIncrementingY ? mPreviousPosition.y + mVeriticalSpeed : mPreviousPosition.y - mVeriticalSpeed;
            if (potentialNextY > mMaxCenterY || potentialNextY < mMinCenterY) {
                mIncrementingY = !mIncrementingY;
                potentialNextY = mPreviousPosition.y;
            }
            return new Point(potentialNextX, potentialNextY );
        }
        return new Point(getWidth()/2, getHeight()/2);
    }

    public static float dpToPx(Context context, float dp){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public void update() {
        mPreviousPosition = mNextPostion;
        mNextPostion = calculateNextPostion();
        invalidate();
    }
}
