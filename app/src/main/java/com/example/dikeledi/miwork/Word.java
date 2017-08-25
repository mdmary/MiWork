package com.example.dikeledi.miwork;

/**
 * Created by codetribe on 7/3/2017.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiWorkTranslation;
    private int mImage = NO_IMAGE_PROVIDED;
    private int mMediaPlayer;
    private static final int NO_IMAGE_PROVIDED = -1;


    public Word(String DefaultTranslation, String miWorkTranslation,int mediaAudio){

        mDefaultTranslation = DefaultTranslation;
        mMiWorkTranslation = miWorkTranslation;
        mMediaPlayer = mediaAudio;
    }


    public Word(String DefaultTranslation, String miWorkTranslation, int imageTranslation, int mediaAudio){

        mDefaultTranslation = DefaultTranslation;
        mMiWorkTranslation = miWorkTranslation;
        mImage = imageTranslation;
        mMediaPlayer = mediaAudio;
    }



    public String getDefaultTranslation(){

        return mDefaultTranslation;
    }

    public String getMiWorkTranslation(){

        return mMiWorkTranslation;
    }

    public int getAppImage(){

        return mImage;
    }

    public boolean hasImage(){

        return mImage != NO_IMAGE_PROVIDED;
    }

    public  int getMediaPlayer()
    {
        return mMediaPlayer;
    }
}
