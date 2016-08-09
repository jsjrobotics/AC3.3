First Android Program
- Build a button
- Build a click listener
- Modify visuals on click
- Handle orientation changes
----------------------
It should start an activity, with a square button centered in the screen on a
blue background. When you press the button, the background should turn to red.
When you press the button again, the background should turn to blue.

After you have the blue and red alternating in portrait mode, I want to be able
to do the same thing in landscape mode. However in landscape, I want the first
color to be green, and the second color to be orange. At any time, I should be
able to rotate the device and see the appropriate first color, with a working
toggle button.

The app should work in a single activity, not spawn new ones.
Button should be in the center of the screen
There should be 2 colors used when the device is portrait, and two different
colors when in landscape

Second Android Program
- Build a button
- Build a click listener
- Modify visuals on click
- Disable buttons
- Reusing layouts
- Handle orientation changes
- Save state on orientation change
----------------------
It should start an activity, with four square button, one in each corner of the
screen. Each button will have a different color name for its text. When you
press a button, the background should turn to the color as described by the
button text.

After you have the four buttons working in portrait mode, I want to be able
to do the same thing in landscape mode. However in landscape, I want the first
color to be the same color as was selected last selected in portrait mode. If
I rotate from landscape to portrait mode, I expect the first color displayed
to be the last color selected in landscape mode.

At the start of the program, if no color is selected, the background should
stay white until a selection is made.

When a buttons color is displayed in the background, that button should be
disabled.

The app should work in a single activity, not spawn new ones.
Button should be aligned to the edges of the screen.
There should be only one layout file.


Third Android Program
- Download Image from internet
- Build and display image in Imageview
- Change image downloaded based on selection
- Caching
- Helpful links
https://developer.android.com/training/basics/network-ops/managing.html
https://developer.android.com/training/displaying-bitmaps/index.html
---------------------
It should start an activity, with four square button, one in each corner of the
screen. Each button will have a different name that corresponds to the image it
downloads.

- Faceless man - http://www.gravatar.com/avatar/be3aebd4ab2d50888d1e26b307144012?d=mm&s=230
- Flaming horse - http://www.gravatar.com/avatar/1c1ee0903c314d243796b0526c2bebe0?d=mm&s=230
- OpenGL Code -
http://www.familypicturewill.com/user_profile_uploads/1470345663111.jpg


When you press a button, the background should change to display the image.

-- Part 2 --
After each background changes according to the button click, we need to think
about network usage. Network usage is slow, and consumes a lot of battery. Hence
we download the stuff we need once and cache these values for later use.

At the start of the activity, download each of the image data, and save it
somehow. Android provides a LRU cache object, but you could also just save
bitmaps to a file. Saving them in memory by assigning them to an array or map
is always more difficult, but is more rewarding as you can implement your own
caching logic. If you chose to build your own cache, you will have to take into
account the limited memory of an android device and the high byte count of
images.

By using the cache, at the start of your activity, we should see network usage
spike, and the no matter how many buttons clicked, the network is not used
again.
https://developer.android.com/studio/profile/am-network.html

No third party libraries can be used.
