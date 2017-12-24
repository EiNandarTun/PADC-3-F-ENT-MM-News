package xyz.einandartun.news.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.einandartun.news.R;
import xyz.einandartun.news.viewitems.ImageInNewsDetailsViewItem;

/**
 * Created by einandartun on 12/10/17.
 */

public class ImagesInNewsDetailsAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
//        if (object instanceof View)
//            return true;
//        else
//            return false;

//        return (object instanceof View);
        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //return super.instantiateItem(container, position);
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //View view = layoutInflater.inflate(R.layout.item_news_details_images, container, false);
        ImageInNewsDetailsViewItem view = (ImageInNewsDetailsViewItem) layoutInflater.inflate(R.layout.item_news_details_images, container, false);
        container.addView(view); //add inflate object to parameter object
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object); //remove item from container
        super.destroyItem(container, position, object);
    }
}
