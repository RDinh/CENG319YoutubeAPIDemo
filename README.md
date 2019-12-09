# YouTube Android Player API

Download the API here: https://developers.google.com/youtube/android/player/downloads

# Table of Contents
  * [Intro](#intro)
  * [History](#history)
  * [The Major mMthods and Attributes](#the-major-methods-and-attributes)
  * [References](#references)


## Intro
The YouTube Player API,developed by Google, allows users to utilize the functionality of the popular video-sharing platform, mainly to view videos for education and daily entertainment. With its many features, developers can choose to display videos in their apps show tutorials for playing games, guides, or even display a playlist to provide informational videos. There are many ways to implement the API and these were just a few.

## History
Developed in December 12, 2012, this API was released as an experimental feature in API 17-18.  The YouTube API itself had overtime deprecated the support for JavaScript and Flash players and now have moved on to support HTML5 video based playback in the current YouTube Data API v3 utilized with the YouTube Android Player API.

Google had to decide to move on from Flash mainly because Adobe was slowly releasing updates for the Flash player. This led to the increasing amount of discovered vulnerabilities that Adobe did not want to fix and later decided to discontinue support for Flash Player as it was not worth fixing. Also the Flash Player also utilized a lot of processing power, and now with it gone the YouTube Plyer API can run more fluidly with fewer security risks.

## The Major Methods and Attributes
Before utilizing the API, an API key has to be retrieved using a Google Account. The Google developers website helps configure the credential using your package name and SHA-1 signing certificate fingerprint. This key is very important because it grants access to the API and also helps Google identify the application to ensure nothing malicious is being doing with their code/API.

When creating the app, ensure the accessibility to the internet with an android device, a uses-permission tag must be entered in the manifest.

The MainActivity or the class that is initializing the YoutubePlayerView must extend the YouTubeBaseActivity class.

Within the onCreate method, an instance of OnInitializedListener is created. This helps determine if the YouTube player is operational or not. Within the listener, there are 2 methods that are required: *onInitializationSuccess* and *onInitializationFailure* .
When successful, the onInitializationSuccess method can be used to cue or load a video/playlist with the YouTubePlayer instance that is passed through as a parameter. The YouTubePlayer class has many functions that helps manipulate video playback and determines what is displayed. The functions that load a video/list only take the ending portion of the youtube url ,after the equals sign.
For example, here is a link to a player list, https://www.youtube.com/playlist?list=PL1XQUjpB5LD4SYJgTZWFjiNv4JU2IRTMJ. The functions will take in “ PL1XQUjpB5LD4SYJgTZWFjiNv4JU2IRTMJ” as an argument for cuePlaylist(). 

Similar functions include: cuePlaylist,cueVideo,cueVideos ( taking a List of ending portions of the urls), loadPlaylist, loadVideo,loadVideos( taking a List of ending portions of the urls).

Other video general playback functions include: next, play, pause, previous and stop. 

The remaining functions in the YouTube player have to deal with the player itself, checking to see its current state or even determining if there is another video to play next.

When the initialization has failed,the onInitializationFailure method is triggered and Toast messages/ logs should be indicated.

Outside of the listener, the YouTubePlayerView is initialized with the API key and the instance of the OnInitializedListener.

This is just a simple implementation of the Youtube Player and there are other ways to implement the other interfaces and do much more.

## References
Youtube Tutorial: 
https://www.youtube.com/watch?v=W4hTJybfU7s

Android Youtube Player APi Package Summary: https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/package-summary 

Revision Hisotry: 
https://developers.google.com/youtube/android/player/revision_history

Article on Flash Player: 
https://lifehacker.com/you-really-shouldnt-be-running-adobe-flash-player-anymo-1829721122




