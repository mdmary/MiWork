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

public class FamilyMembers extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
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
        final ArrayList<Word> familyWordAdapter = new ArrayList<Word>();

        familyWordAdapter.add(new Word("epa","father",R.drawable.family_daughter));
        familyWordAdapter.add(new Word("eta","mother",R.drawable.family_father));
        familyWordAdapter.add(new Word("angsi","son",R.drawable.family_grandfather));
        familyWordAdapter.add(new Word("tune","daughter",R.drawable.family_grandmother));
        familyWordAdapter.add(new Word("taachi","older brother",R.drawable.family_mother));
        familyWordAdapter.add(new Word("chalitti","young brother",R.drawable.family_older_brother));
        familyWordAdapter.add(new Word("tete","older sister",R.drawable.family_son));
        familyWordAdapter.add(new Word("kolliti","young singer",R.drawable.family_younger_brother));
        familyWordAdapter.add(new Word("ama","grandmother",R.drawable.family_younger_sister));
        familyWordAdapter.add(new Word("paapa","grandfather",R.drawable.family_younger_brother));

        WordAdapter numbersAdapter = new WordAdapter(this, familyWordAdapter, R.color.familyColor);

        ListView numberList = (ListView)findViewById(R.id.numbers_listView);
        numberList.setAdapter(numbersAdapter);

        numberList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word audio = familyWordAdapter.get(position);
                mMediaPlayer = MediaPlayer.create(FamilyMembers.this,audio.getMediaPlayer());

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
        if (mMediaPlayer != null)
        {
            mMediaPlayer.release();
        }
        else {
            mMediaPlayer = null;
        }
    }
}
