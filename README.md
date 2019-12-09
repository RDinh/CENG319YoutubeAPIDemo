##YouTube Android Player API

Download the API here https://developers.google.com/youtube/android/player/downloads

##Intro
The YouTube Player API,developed by Google, allows users to utilize the functionality of the popular video-sharing platform, mainly to view videos for education and daily entertainment. With its many features, developers can choose to display videos in their apps for tutorials for playing games, guides, or even display a playlist to provide informational videos. There are many ways to implement the API and these were just a few.

##History
Developer in December 12, 2012, this API was released as an experimental feature in API 17-18.  The YouTube API itself had overtime deprecated the support for JavaScript and Flash players and now have moved on to support HTML5 based video playback in the current YouTube Data API v3 utilized with the YouTube Android Player API.
Google had to decide to move on from Flash mainly because Adobe was slowly releasing updates for the Flash player which led to the increasing amount of discovered vulnerabilities. Also Flash also utilized a lot of processing power, and now with it gone the API can run much fluidly.

##The major methods and Attributes
Before utilizing the API, an API key has to be retrieved using a Google Account. The developers website helps configure the credential using your package name and HA-1 signing certificate fingerprint.
When creating the app, the class initializing the YoutubePlayerView must extend the YouTubeBaseActivity class and to ensure the accessibility to the internet a uses-permission tag must be entered.
Within the onCreate method, an instance of OnInitializedListener is created. This helps determine if the YouTube player is operational or not. 
Within the listener, there are 2 methods that are required.
When successful, the onInitializationSuccess method can be used to cue or load a video/playlist with the YouTubePlayer instance that is passed through as a parameter. The YouTubePlayer class has many functions that helps manipulate video playback and determines what is displayed. The functions that load a video/list only take the ending portion of the youtube url ,after the equals sign. For example, here is a link to a player list, https://www.youtube.com/playlist?list=PL1XQUjpB5LD4SYJgTZWFjiNv4JU2IRTMJ. The functions will take in “ PL1XQUjpB5LD4SYJgTZWFjiNv4JU2IRTMJ” as a parameter for cuePlaylist(). Similar functions include: cuePlaylist,cueVideo,cueVideos ( taking a List of ending portions of the urls), loadPlaylist, loadVideo,loadVideos( taking a List of ending portions of the urls)
When the initialization has failed,the onInitializationFailure method is triggered and Toast messages/ logs should be indicated.
Outside of the listener, the YouTubePlayerView is then initialized with the API key and the instance of the OnInitializedListener.
This is just a simple implementation of the Youtube Player and there are other ways to implement the other interfaces and do much more.

##References
Youtube Tutorial: https://www.youtube.com/watch?v=W4hTJybfU7s

Download the API here https://developers.google.com/youtube/android/player/downloads
https://www.educba.com/html5-vs-flash/


