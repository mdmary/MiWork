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
public class Numbers extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {

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
        final ArrayList<Word> numberWordAdapter = new ArrayList<Word>();

        numberWordAdapter.add(new Word("lutti","One",R.drawable.number_one,R.raw.number_one));
        numberWordAdapter.add(new Word("otiiko","Two",R.drawable.number_two,R.raw.number_two));
        numberWordAdapter.add(new Word("tolookosu","Three",R.drawable.number_three,R.raw.number_three));
        numberWordAdapter.add(new Word("oyyisa","Four",R.drawable.number_four,R.raw.number_four));
        numberWordAdapter.add(new Word("massokka","Five",R.drawable.number_five,R.raw.number_five));
        numberWordAdapter.add(new Word("temmokka ","Six",R.drawable.number_six,R.raw.number_six));
        numberWordAdapter.add(new Word("kenekaku ","Seven",R.drawable.number_six,R.raw.number_seven));
        numberWordAdapter.add(new Word("kawinta ","Eight",R.drawable.number_eight,R.raw.number_eight));
        numberWordAdapter.add(new Word("woâ€™e ","Nine",R.drawable.number_nine,R.raw.number_nine));
        numberWordAdapter.add(new Word("naâ€™aacha ","Ten",R.drawable.number_ten,R.raw.number_ten));


        WordAdapter numbersAdapter = new WordAdapter(this, numberWordAdapter,R.color.numbersColor);

        ListView listViewList = (ListView)findViewById(R.id.numbers_listView);
        listViewList.setAdapter(numbersAdapter);

        listViewList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word audio = numberWordAdapter.get(position);
                mMediaPlayer = MediaPlayer.create(Numbers.this, audio.getMediaPlayer());

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

    public void releaseMedia() {
        if (mMediaPlayer != null) {

            mMediaPlayer.release();
        } else {
            mMediaPlayer = null;
        }
    }
}
