# CheckPack <img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" width="80" height="20"> <img src="https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white" width="80" height="20">

CheckPack is a native android checklist app for those going on vacation, written in Kotlin using Jetpack Compose.

* Screenshots 🖼️

<img src="https://user-images.githubusercontent.com/50905347/177814247-03837c5f-60bd-4d1e-acac-622356a7ad82.png" width="125" height="265">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/177772775-bc3fbbe7-5aac-411f-a791-26288fda540f.png" width="125" height="265">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/177772776-b0c9cdc0-a706-4a1a-8d20-e9e5b9c87128.png" width="125" height="265">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/177772779-be6434de-01c2-42fe-81d9-b4c2c43cbdf1.png" width="125" height="265">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/177773247-16fbdb60-29c9-44cc-9376-7165e35cc391.png" width="125" height="265">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/177773255-3ff0d8e9-627f-4d01-934b-a8b33201dfd6.png" width="125" height="265">

<img src="https://user-images.githubusercontent.com/50905347/177774059-627892f7-8ffe-4b8a-abfe-89912b519628.png" width="265" height="125"><img src="https://user-images.githubusercontent.com/50905347/177774062-917a9f5d-f04a-4085-b22f-8832a494fdd1.png" width="265" height="125"><img src="https://user-images.githubusercontent.com/50905347/177774067-7e0550b0-0a4c-44c1-a824-92d0a7be1f6f.png" width="265" height="125">

* Screenshots 🖼️ - Dark mode

<img src="https://user-images.githubusercontent.com/50905347/177814980-2b651351-ec48-49ee-bee8-119a611ec6e6.png" width="125" height="265">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/177817354-bf73b0d8-9b29-4d2f-bdbe-a2aac603244e.png" width="125" height="265">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/177817357-dd898358-37cd-40ab-a6c1-359e16b55a34.png" width="125" height="265">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/177814995-767bd799-7136-4e94-9776-b1e9572f23a6.png" width="125" height="265">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/177817366-6eeafebc-5e19-4f07-be80-5ed5d91bc539.png" width="125" height="265">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/177817372-576fdfad-d1bc-4d7d-9f96-3dddcfbf21f9.png" width="125" height="265">

* Ux 🧪

<img src="https://user-images.githubusercontent.com/50905347/178328848-39908123-1128-479c-8f5a-56f5643050da.gif" width="250" height="530">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/178371493-7131f78a-24ab-49e9-a427-a90b483a11a0.gif" width="250" height="530">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/178331289-0203a902-06bc-4cfc-b62b-d1e7ab4394b4.gif" width="250" height="530">

<img src="https://user-images.githubusercontent.com/50905347/178331301-7561bb26-2b40-415a-81e4-f34bb0c176c9.gif" width="250" height="530">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/178331311-11dee195-d792-4dc3-9b12-d2131473fc81.gif" width="250" height="530">&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/50905347/178331328-a6115f08-b479-4f7a-b5b2-5fce3c551867.gif" width="250" height="530">

* Structure - Modularization 🌲

<img src="https://user-images.githubusercontent.com/50905347/177567168-84dd5aa8-efaf-45d3-a2bb-7520135bb38b.png" width="540" height="540">

* Application - Features ☕
   * One time splash screen
   * Geolocation - permissions
   * Various calculation tools
   * Web scrapping
   * Database operations - CRUD
   * Various animations
   * Unit tests
   * Language - Turkish
* Tech-stack ⚛️
    * [Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operation
    * [Jetpack](https://developer.android.com/jetpack)
        * [Compose](https://developer.android.com/jetpack/compose) - toolkit for building native UI
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - deal with whole in-app navigation      
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
    * [Room](https://developer.android.com/jetpack/androidx/releases/room) - database object mapping
    * [Retrofit](https://square.github.io/retrofit/) - HTTP client
    * [Accompanist](https://github.com/google/accompanist)
        * systemUi
        * pager
        * permissions
        * navigation
    * [Coil](https://coil-kt.github.io/coil/) - image loading library 
    * [Hilt](https://dagger.dev/hilt/) - DI
    * [Google Play Services](https://developers.google.com/android)
        * location
    * [Google Firebase](https://firebase.google.com)
        * crashlytics
    * [Material 3](https://m3.material.io) - design
    * [Jsoup](https://jsoup.org) - perform web scraping
    * [Junit 4](https://junit.org/junit4/) - perform unit tests
* Architecture 🏗️
    * Model-View-Intent
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation))
 
 * Todo ✔️
   * Tests ❌ - working on
   * Dark Theme ✔️
