package wzp.demo.showimagebyturnsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import wzp.demo.imageloop.widget.ImageLoopViewPager;

public class MainActivity extends AppCompatActivity {

//    private ViewPager vpNews;
    private ImageLoopViewPager vpNews;
    private NewsAdapter adapter;
    private List<News> newsList = new ArrayList<>();

    private boolean isHandMove;


    private Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg != null) {
                int what = msg.what;
                if (what == 1) {
                    int currentItem = vpNews.getCurrentItem();
                    if (currentItem < 3) {
                        currentItem++;
                        vpNews.setCurrentItem(currentItem);
                    } else {
                        currentItem = 0;
                        vpNews.setCurrentItem(currentItem, false);
                    }

                    MainActivity.this.sendMessage();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpNews = (ImageLoopViewPager) findViewById(R.id.vp_news);

//        News news1 = new News("http://04.imgmini.eastday.com/mobile/20170606/20170606155445_7cab1b9a6b7d15e60e2c3bc5be7a3091_1.jpeg", "詹姆斯", "获得三次总冠军，三次FMVP");
//        News news2 = new News("http://upload.site.cnhubei.com/2016/0117/1453000952567.jpg", "韦德", "获得三次总冠军，三次FMVP");
//        News news3 = new News("http://www.cnr.cn/newscenter/tyxw/pictures/photos/20161107/W020161107329999024236.jpg", "詹姆斯", "获得三次总冠军，三次FMVP");
//        News news4 = new News("http://cimg2.163.com/sports/2007/10/27/20071027220155c01a0.jpg", "詹姆斯", "获得三次总冠军，三次FMVP");
        News news1 = new News("http://04.imgmini.eastday.com/mobile/20170606/20170606155445_7cab1b9a6b7d15e60e2c3bc5be7a3091_1.jpeg",
                "http://baike.baidu.com/link?url=IXoVQH7elWrifDpjHVnDm45Gmw1SIgazmSsMvELQuEon7bf23O0HBfaLDpsDfq1462SYsqnkwb_eUJoxC4oLGr5Ma2r8PYjHyD3TBwcWsvgU93AS8mVbs19BCl6VePf-bsL15hA-P1F1gPAGTSvCNgybM4zijMZbSAgRKksyZ2RdN-FA7s3QjmA7WxzhxEJbp2iZtcdsJtGpmUOGSLcp_ubN9pFoAX0ePwrXGHzUReq");
        News news2 = new News("http://upload.site.cnhubei.com/2016/0117/1453000952567.jpg",
                "http://baike.baidu.com/link?url=LHIKB-s1b8UrTfsCf_Ej_KFJm9mPcFjYQgdulsZzfHIczC8JB9x08K4lO3wO0ilejM1r4Cfi4Dslad_Kkrozs_NrVGuRUUNVF5pgEVv4Iln485w85-kFInzZeAx4K2OTk39tiNyCi2Y6lgxu-kBIVxbf-kZGyr41gTcKhHK20uk6oByYMsiLx698ulxp5CckEr_KnoqY7bUsZU3PzAJC5_");
        News news3 = new News("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497547847512&di=96fd3ea06992b3f6f7579f5bb2a24444&imgtype=0&src=http%3A%2F%2Fimg1.cache.netease.com%2Fcatchpic%2F7%2F74%2F7453F6B35EC32C35D66DC948CD4A38D8.jpg",
                "http://baike.baidu.com/link?url=Ud2E2QsBQQRt6els_cSP12r7hv184AfcsrKK6RIqhYtFtRbDyeaKPWVjEeRsyXiXALulY5_qbPXKypPfz2AUv-q-tCIS93UOgpEzDtPQDaXRyUkK7GSKDFNC3vw972XqIUvtF1yKCcWyZONKCZmI25KenXmKJG1RMwOGEgskGslI29VCy1tzd0RNVSwTKWnk-3BtCfejOgrffxHc3_S-aqZs01i8tYzyYtpJdIE0NQW");
        News news4 = new News("http://cimg2.163.com/sports/2007/10/27/20071027220155c01a0.jpg",
                "http://baike.baidu.com/link?url=pjRWtNFwKA8poW-muoR26OOg_ikdJtmeEFE1galqpnjDG2iGqe70UKA5_h9Yz_rngAk4yc2ur4Ta-vf-GUiKajTTIrujO4wbVGTjgX6hRCBey2X6DTV-r8-whftkOHRAelq9Yo9IkAXsmaP8eWSxFTrtVUlU3of_6JdyVKzLsGIqBbOnhaI_KxS40r3RRRdmCMlmlrCTktw9EanRiuQH7B13_R9zKDp0lt_G5xHymDi");
        News news5 = new News("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497547847512&di=96fd3ea06992b3f6f7579f5bb2a24444&imgtype=0&src=http%3A%2F%2Fimg1.cache.netease.com%2Fcatchpic%2F7%2F74%2F7453F6B35EC32C35D66DC948CD4A38D8.jpg",
                "http://baike.baidu.com/link?url=Ud2E2QsBQQRt6els_cSP12r7hv184AfcsrKK6RIqhYtFtRbDyeaKPWVjEeRsyXiXALulY5_qbPXKypPfz2AUv-q-tCIS93UOgpEzDtPQDaXRyUkK7GSKDFNC3vw972XqIUvtF1yKCcWyZONKCZmI25KenXmKJG1RMwOGEgskGslI29VCy1tzd0RNVSwTKWnk-3BtCfejOgrffxHc3_S-aqZs01i8tYzyYtpJdIE0NQW");
        News news6 = new News("http://cimg2.163.com/sports/2007/10/27/20071027220155c01a0.jpg",
                "http://baike.baidu.com/link?url=pjRWtNFwKA8poW-muoR26OOg_ikdJtmeEFE1galqpnjDG2iGqe70UKA5_h9Yz_rngAk4yc2ur4Ta-vf-GUiKajTTIrujO4wbVGTjgX6hRCBey2X6DTV-r8-whftkOHRAelq9Yo9IkAXsmaP8eWSxFTrtVUlU3of_6JdyVKzLsGIqBbOnhaI_KxS40r3RRRdmCMlmlrCTktw9EanRiuQH7B13_R9zKDp0lt_G5xHymDi");

        newsList.add(news1);
        newsList.add(news2);
        newsList.add(news3);
        newsList.add(news4);
        newsList.add(news5);
        newsList.add(news6);

        List<ImageView> ivList = new ArrayList<>();
        for (int i=0; i<newsList.size(); i++) {
            ImageView iv = new ImageView(this);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            final int j = i;
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("url", newsList.get(j).getContentUrl());
                    startActivity(intent);
                }
            });
            ivList.add(iv);
        }
        adapter = new NewsAdapter(this, ivList, newsList);

        vpNews.setAdapter(adapter);
        vpNews.setPage(newsList.size());

//        vpNews.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                switch (state) {
//                    case ViewPager.SCROLL_STATE_DRAGGING://手指滑动状态
//                        //记录滑动开始时的当前页面
//                        isHandMove = true;
//
//                        mHandle.removeCallbacksAndMessages(null);
//                        Log.d("MainActivity", "SCROLL_STATE_DRAGGING=" + state + ";" + isHandMove);
//                        break;
//                    case ViewPager.SCROLL_STATE_IDLE://停止状态
//                        //比较滑动结束后当前页面和开始滑动时的页面值
//                        if(isHandMove){
//                            isHandMove = false;
//                            Message message = Message.obtain();
//                            message.what = 1;
//                            mHandle.sendMessageDelayed(message, 3000);
//                        }
//
//                        Log.d("MainActivity", "SCROLL_STATE_IDLE=" + state);
//                        break;
//                    case ViewPager.SCROLL_STATE_SETTLING://自动滑动状态
//
//                        Log.d("MainActivity", "SCROLL_STATE_SETTLING=" + state);
//                        break;
//
//                    default:
//                        break;
//                }
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        sendMessage();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        stopHandler();
    }

    private void sendMessage() {
        Message message = Message.obtain();
        message.what = 1;
        mHandle.sendMessageDelayed(message, 3000);
    }

    private void stopHandler() {
        mHandle.removeCallbacksAndMessages(null);
    }

}
