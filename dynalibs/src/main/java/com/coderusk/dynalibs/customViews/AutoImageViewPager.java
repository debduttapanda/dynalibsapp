package com.coderusk.dynalibs.customViews;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.coderusk.dynalibs.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class AutoImageViewPager extends ViewPager {
    int timeInMillisecond = 3000;
    ArrayList<String> urls = null;

    private OnPageChangeListener pageChangeListener = null;
    private Context context;
    int current = -1;
    int total = 0;
    Timer timer = null;
    private void commonConstructor(Context context)
    {
        this.context = context;
    }

    public void setup(ArrayList<String> urls, int ms)
    {
        timeInMillisecond = ms;
        if(timeInMillisecond<300)
        {
            timeInMillisecond = 3000;
        }
        this.urls = urls;
        if(urls==null)
        {
            return;
        }
        int sz = urls.size();
        if(sz<1)
        {
            return;
        }

        String first = urls.get(0);
        String last = urls.get(sz-1);

        this.urls.add(0,last);
        this.urls.add(first);
        total = this.urls.size();

        setAdapter(new AutoImagePagerAdapter(context));

        pageChangeListener = new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("auto_view",state+"");
                if(state==0)
                {
                    checkCircle();
                }
            }
        };

        addOnPageChangeListener(pageChangeListener);

        if(total>1)
        {
            final Handler handler = new Handler();
            if(timer!=null)
            {
                try {
                    timer.cancel();
                    timer = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            timer = new Timer(false);
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            current = (current+1)%total;
                            setCurrentItem(current);
                        }
                    });
                }
            };
            timer.schedule(timerTask, timeInMillisecond, timeInMillisecond); // 1000 = 1 second.
        }
    }

    private void checkCircle() {
        int last = total-1;
        int first = 0;
        if(current==last)
        {
            current = 1;
            setCurrentItem(current,false);
        }
        if(current==first)
        {
            current = total-2;
            setCurrentItem(current,false);
        }
    }

    public AutoImageViewPager(@NonNull Context context) {
        super(context);
        commonConstructor(context);
    }

    public AutoImageViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        commonConstructor(context);
    }


    ////////////////////////////////////////////////////

    class AutoImagePagerAdapter extends PagerAdapter {

        private Context mContext;

        public AutoImagePagerAdapter(Context context) {
            mContext = context;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.banner_item, collection, false);
            //////////////////////////////////////////////
            ImageView iv_banner = layout.findViewById(R.id.iv_banner);
            Glide
                    .with(context)
                    .load(urls.get(position))
                    .centerCrop()
                    .into(iv_banner);
            collection.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return urls.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "";
        }

    }

    public void terminate()
    {
        if(pageChangeListener!=null)
        {
            removeOnPageChangeListener(pageChangeListener);
        }
    }
}
