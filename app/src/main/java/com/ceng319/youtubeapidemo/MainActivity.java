package com.ceng319.youtubeapidemo;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

        import com.google.android.youtube.player.YouTubeBaseActivity;
        import com.google.android.youtube.player.YouTubeInitializationResult;
        import com.google.android.youtube.player.YouTubePlayer;
        import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity
{
    //These buttons are used for demonstration purposes.
    Button   mplayBtn;
    Button   mprevBtn;
    Button   mnextBtn;

    int count = 0;

    private YouTubePlayerView myouTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    /*
    * 1. Using a google account, create a new project in the developers website
    * 2. Once a project is created, Enable the Youtube Data API v3 under Library
    * 3. Under Credentials, create a new Credential.
    * 4. Follow the instructions provided to add your package name and SHA-1 signing certificate fingerprint
    * 5. Copy the API KEY and store it in an uneditable string.
     */
    private final String API_KEY = "AIzaSyDWObG77-bL8NAYEhiRz3VEeikwGJ9axxc";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //These buttons were created to demo .play(),.next() and .previous() functions

        mplayBtn = (Button) findViewById(R.id.playBtn);
        mprevBtn = (Button) findViewById(R.id.playPrev);
        mnextBtn = (Button) findViewById(R.id.playNext);


        //The player view is an essential part to display the Youtube Player
        myouTubePlayerView = (YouTubePlayerView) findViewById(R.id.playerView);


        /*
        *This api revolves around this OnInitializedListener
        * to determine if the Youtube Player is operational or not
        **/
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            /*The youTubePlayer that is passed through the following player allows
            * developers to decide what videos/playlist should be cued or automatically played.*/
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {

                //cueVideo() can also be used if there is no playlist
                //load() can also be used but will automatically play when initialized

                youTubePlayer.cuePlaylist("PL1XQUjpB5LD4SYJgTZWFjiNv4JU2IRTMJ");
                Log.d("Init","Success");

                mprevBtn.setEnabled(false);

                mplayBtn.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view){
                        youTubePlayer.play();
                    }

                });

                //Set the states of the button depending on the playlist
                mnextBtn.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view){
                        if(youTubePlayer.hasNext()){
                            youTubePlayer.next();
                            btnState(youTubePlayer);
                            mprevBtn.setEnabled(true);
                        }
                        else
                            btnState(youTubePlayer);
                    }


                });

                //Set the states of the button depending on the playlist
                mprevBtn.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view){
                        if(youTubePlayer.hasPrevious()){
                            youTubePlayer.previous();
                            btnState(youTubePlayer);
                        }
                        else
                            btnState(youTubePlayer);


                    }

                });
            }


            /*
            *Any Issues with the youtube player should be reported here.
            *
             */
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        /*
        * Initialize the youtube player with the api key and with the listener
         */
        myouTubePlayerView.initialize(API_KEY,onInitializedListener);
    }

    /*
    * This function determines whether the prev. or next buttons should be enabled depending on the
    *playlist.
    */
    public void btnState(YouTubePlayer ytp){
        if (ytp.hasNext())
            mnextBtn.setEnabled(true);
        else
            mnextBtn.setEnabled(false);

        if(ytp.hasPrevious())
            mprevBtn.setEnabled(true);
        else
            mprevBtn.setEnabled(false);
    }

}
