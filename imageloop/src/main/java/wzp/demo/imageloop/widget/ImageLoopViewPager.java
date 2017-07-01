package wzp.demo.imageloop.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;

import wzp.demo.imageloop.R;

/**
 * Created by wzp on 2017/6/15.
 */

public class ImageLoopViewPager extends ViewPager {

    private boolean isHandMove = false;
    private long millis = 3000; // 图片轮播的间隔时间，默认为3s
    private static final int IMAGE_LOOP = 1;
    private int page = 0;

    private Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == IMAGE_LOOP) {
                int currentItem = getCurrentItem();
//                if (currentItem < getChildCount()) {
                if (currentItem < page) {
                    currentItem++;
                    setCurrentItem(currentItem);
                } else {
                    currentItem = 0;
                    setCurrentItem(currentItem, false); // 最后一张图返回至第一张图，不需要切换效果
                }

                delaySendMessage();
            }
        }
    };

    public ImageLoopViewPager(Context context) {
        super(context);
        init(null);
    }

    public ImageLoopViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet set) {
        if (set != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(set, R.styleable.ImageLoopViewPager);
            millis = typedArray.getInt(R.styleable.ImageLoopViewPager_intervalMillis, 3000);
        }

        addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING: //手指滑动状态
                        //记录滑动开始时的当前页面
                        isHandMove = true;

                        mHandle.removeCallbacksAndMessages(null);
                        Log.d("MainActivity", "SCROLL_STATE_DRAGGING=" + state + ";" + isHandMove);
                        break;

                    case ViewPager.SCROLL_STATE_IDLE: //停止状态
                        if(isHandMove){
                            isHandMove = false;
                            delaySendMessage();
                        }

                        Log.d("MainActivity", "SCROLL_STATE_IDLE=" + state);
                        break;

                    case ViewPager.SCROLL_STATE_SETTLING: //自动滑动状态

                        Log.d("MainActivity", "SCROLL_STATE_SETTLING=" + state);
                        break;

                    default:
                        break;
                }
            }
        });
    }

//    @Override
//    protected void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        stopHandler();
//    }
//
//    @Override
//    protected void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        delaySendMessage();
//    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == VISIBLE) {
//            if (getAdapter() != null && getAdapter().getCount() > 0) {
                delaySendMessage();
//            }
            Log.d("ImageLoopViewPager", getAdapter().getCount() + "");
        } else {
            stopHandler();
        }
    }

    public void setLoopIntervalTime(long millis) {
        this.millis = millis;
    }

    public void setPage(int page) {
        this.page = page - 1;
        if (this.page < 0) {
            this.page = 0;
        }
    }

    private void delaySendMessage() {
        Message message = Message.obtain();
        message.what = 1;
        mHandle.sendMessageDelayed(message, millis);
    }

    private void stopHandler() {
        mHandle.removeCallbacksAndMessages(null);
    }
}
