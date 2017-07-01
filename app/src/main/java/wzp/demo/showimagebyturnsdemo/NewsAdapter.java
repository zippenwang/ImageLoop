package wzp.demo.showimagebyturnsdemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by wzp on 2017/6/14.
 */

public class NewsAdapter extends PagerAdapter {

    private Context context;
    private List<News> newsList;
    private List<ImageView> ivList;


    public NewsAdapter(Context context, List<ImageView> ivList, List<News> newsList) {
        this.context = context;
        this.ivList = ivList;
        this.newsList = newsList;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = ivList.get(position);
        container.addView(iv);

        String url = newsList.get(position).getImageUrl();
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv);

        return  iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(ivList.get(position));
    }

    @Override
    public int getCount() {
        return ivList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
