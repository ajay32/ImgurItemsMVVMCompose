# Imgur Gallery Search Application

This application allows users to search and view the top images of the week from the Imgur gallery, providing a dynamic and interactive user experience. Below are the key features and functionalities implemented in the app:

## Features

### Search Functionality
- **Dynamic Search**: Users can input text as part of the search query to dynamically display relevant results from the Imgur gallery.

### Gallery Display
- **List and Grid Toggle**: The app includes a toggle feature allowing users to switch between two display modes:
  - **List View**: Displays search results in a list, containing full-screen width horizontal cells. Each cell neatly arranges all relevant information alongside a small thumbnail of the image.
  - **Grid View**: Shows search results in a grid layout, featuring larger thumbnails. This view also displays other relevant information alongside each thumbnail, providing an elegant design.

### Result Cell Details
Each search result cell displays the following information:
- **Title**: The title of the post.
- **Date**: The date of the post, formatted in local time (DD/MM/YY hh:mm am/pm).
- **Number of Additional Images**: Indicates the number of additional images in the post if there are multiple. This helps users understand the content breadth without needing to navigate away.
- **Image Display**: The app displays the first image from the list if a search result contains multiple images, ensuring users see the most relevant content at a glance.

## Implementation Notes

The application leverages modern Android development tools and practices, including Jetpack Compose for the UI, to create a seamless and responsive user experience. It also utilizes the Imgur API to fetch real-time data based on user queries.

## Screenshots
### Main Screen
 ![imgurApp](https://github.com/ajay32/ImgurItemsMVVMCompose/assets/8002767/88ba2673-4864-43b5-879b-bce28aa280ad)
---

For developers looking to extend or customize the application, please refer to the source code and the Imgur API documentation for detailed information on the available endpoints and response formats.