## 'FEED' the Eyes

### Overview

The purpose of this application is to show Image Feed using the Imgur API

- I have used Android - Material Design with Java for making the Application
- Have used MVP pattern for structuring the Application
- Have used Retrofit for making API calls
- I have also included external dependencies and classes for extra features and re-usability

### Details

- The Application has a Splash Screen as the launcher Activity
- Splash screen will by default disappear in 5 seconds but you can touch the screen anywhere if you want to go the ImageFeedActivity before 5 seconds
- ImageFeedActivity has a RecyclerView consisting of Images and Captions coming from Imgur API
- Clicking on any image will first give that image the focus and clicking the image second time will take you to ImageFeedDetailsActivity
- ImageFeedDetails will have the CollapsingToolbarLayout with image and the description of that image which comes as part of the Imgur API
- I have created a sample album on imgur.com to get all images from that album
- I have used JUnit and Mockito for testing the Presenter
