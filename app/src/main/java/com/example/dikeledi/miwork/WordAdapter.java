package com.example.dikeledi.miwork;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by codetribe on 7/3/2017.
 */



public class WordAdapter extends ArrayAdapter<Word>  {

    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> numbers, int colorResourceId){

        super(context, 0, numbers);

        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        Word currentWord = getItem(position);

        TextView miWorkWord = (TextView) listItemView.findViewById(R.id.miWork_translation);
        miWorkWord.setText(currentWord.getMiWorkTranslation());

        TextView defaultWord = (TextView) listItemView.findViewById(R.id.default_translation);
        defaultWord.setText(currentWord.getDefaultTranslation());

        ImageView iconImage = (ImageView) listItemView.findViewById(R.id.icon);
        if (currentWord.hasImage()) {
            iconImage.setImageResource(currentWord.getAppImage());
        }
        else {
            iconImage.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int colorSet = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(colorSet);

        return listItemView;
    }
}
