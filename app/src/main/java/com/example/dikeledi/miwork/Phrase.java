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

public class Phrase extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener(){

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
        final ArrayList<Word> phrasesWordAdapter = new ArrayList<Word>();

        phrasesWordAdapter.add(new Word("minto wuksus","Where are you going?",R.raw.phrase_where_are_you_going));
        phrasesWordAdapter.add(new Word("tinnÓ™ oyaase'nÓ™ ","What is your name?",R.raw.phrase_what_is_your_name));
        phrasesWordAdapter.add(new Word("oyaaset... ","My name is...",R.raw.phrase_my_name_is));
        phrasesWordAdapter.add(new Word("michÓ™ksÓ™s? ","How are you feeling?",R.raw.phrase_how_are_you_feeling));
        phrasesWordAdapter.add(new Word("kuchi achit ","Iâ€™m feeling good.",R.raw.phrase_im_feeling_good));
        phrasesWordAdapter.add(new Word("Ó™Ó™nÓ™s'aa? ","Are you coming?",R.raw.phrase_are_you_coming));
        phrasesWordAdapter.add(new Word("hÓ™Ó™â€™ Ó™Ó™nÓ™m ","Yes, Iâ€™m coming.",R.raw.phrase_yes_im_coming));
        phrasesWordAdapter.add(new Word("Ó™Ó™nÓ™m ","Iâ€™m coming.",R.raw.phrase_im_coming));
        phrasesWordAdapter.add(new Word("yoowutis ","Letâ€™s go.",R.raw.phrase_lets_go));
        phrasesWordAdapter.add(new Word("Ó™nni'nem ","Come here.",R.raw.phrase_come_here));


        WordAdapter numbersAdapter = new WordAdapter(this, phrasesWordAdapter, R.color.phraseColor);

        ListView numberList = (ListView)findViewById(R.id.numbers_listView);
        numberList.setAdapter(numbersAdapter);

        numberList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word audio = phrasesWordAdapter.get(position);
                mMediaPlayer = MediaPlayer.create(Phrase.this,audio.getMediaPlayer());

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
