package com.example.dikeledi.miwork;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

import static com.example.dikeledi.miwork.R.layout.word_list;

/**
 * Created by dikeledi on 21/06/2017.
 */

public class Colors extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    int k = 5;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new  MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMedia();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(word_list);

        //array list
        final ArrayList<Word> colorsWordAdapter = new ArrayList<Word>();

        colorsWordAdapter.add(new Word("á¹­akaakki ","brown",R.drawable.color_brown,R.raw.color_brown));
        colorsWordAdapter.add(new Word("á¹­opiisÓ™ ","dusty_yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        colorsWordAdapter.add(new Word("á¹­opoppi ","gray",R.drawable.color_gray,R.raw.color_gray));
        colorsWordAdapter.add(new Word("chokokki","green",R.drawable.color_green,R.raw.color_green));
        colorsWordAdapter.add(new Word("weá¹­eá¹­á¹­i ","red",R.drawable.color_red,R.raw.color_red));
        colorsWordAdapter.add(new Word("kelelli ","white",R.drawable.color_white,R.raw.color_white));
        colorsWordAdapter.add(new Word("kululli","black",R.drawable.color_black,R.raw.color_black));
        colorsWordAdapter.add(new Word("chiwiiá¹­Ó™ ","mustard_yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        WordAdapter numbersAdapter = new WordAdapter(this, colorsWordAdapter,R.color.colorColor);

        ListView numberList = (ListView)findViewById(R.id.numbers_listView);
        numberList.setAdapter(numbersAdapter);

        numberList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word audio = colorsWordAdapter.get(position);
                mMediaPlayer = MediaPlayer.create(Colors.this,audio.getMediaPlayer());

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mOnCompletionListener);

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMedia();
    }

    public void releaseMedia(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
        }
        else{
            mMediaPlayer = null;
        }
    }
}
