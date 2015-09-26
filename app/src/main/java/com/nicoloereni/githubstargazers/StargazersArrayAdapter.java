package com.nicoloereni.githubstargazers;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;


public class StargazersArrayAdapter extends ArrayAdapter<StargazerModel> {
    private int listViewItemLayout;
    private final List<StargazerModel> stargazerModels;

    public StargazersArrayAdapter(Activity acivity, int listViewItemLayout, List<StargazerModel> stargazerModels) {
        super(acivity,listViewItemLayout,stargazerModels);
        this.listViewItemLayout = listViewItemLayout;
        this.stargazerModels = stargazerModels;

        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(acivity));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(getContext()).inflate(listViewItemLayout, null);
        getListItemNameTextView(view).setText(stargazerModels.get(position).name);
        ImageLoader.getInstance().displayImage(stargazerModels.get(position).avatarUrl, getListItemImageView(view));

        return view;
    }

    private ImageView getListItemImageView(View view) {
        return (ImageView)view.findViewById(R.id.stargazer_avatar_imageView);
    }

    private TextView getListItemNameTextView(View view) {
        return (TextView)view.findViewById(R.id.stargazer_name_textView);
    }
}
