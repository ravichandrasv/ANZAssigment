ANZ Assignment – Android App

📌 Project Overview



This is a small Android app built with Jetpack Compose, Kotlin, Coroutines, Hilt, and Retrofit/Gson.



It demonstrates:



Displaying a list of users from a public API.



Navigating to a user detail screen using Compose Navigation.



Handling loading and error states.



MVVM architecture with Repository + ViewModel + Composable UI.



Unit testing for ViewModels and Repository.



⚠️ Note: This is a minimal project for assignment purposes and is not production-ready.



🛠 Technologies Used

Layer / Feature	Technology / Library

Language	Kotlin

UI	Jetpack Compose

Navigation	Compose Navigation + NavGraph

Dependency Injection	Hilt

Networking	Retrofit + Gson

Coroutines	Kotlin Coroutines

Theme	Material3 (Color.kt, Type.kt, Theme.kt)

Testing	JUnit, Mockito, Coroutines Test

🗂 Project Structure

com.example.anzassigment

├─ MainApplication.kt                   # Hilt Application class

├─ MainActivity.kt                      # Entry point activity

├─ data

│  ├─ User.kt

│  ├─ UserRepositoryImpl.kt

│  └─ remote/UserApi.kt

├─ domain

│  └─ UserRepository.kt

├─ di

│  └─ NetorkModule.kt                      # Hilt modules

├─ ui

│  ├─ dummy

│  │  └─ (placeholder/experimental UI files)

│  ├─ navigation

│  │  └─ NavGraph.kt                    # Compose navigation graph

│  ├─ theme

│  │  ├─ Color.kt

│  │  ├─ Theme.kt

│  │  └─ Type.kt

│  └─ users

│     ├─ viewmodel

│     │  ├─ UsersViewModel.kt

│     │  └─ UserDetailViewModel.kt

│     ├─ UsersScreen.kt

│     └─ UserDetailScreen.kt



📱 Features



User List Screen



Fetches users from API and displays them in a scrollable list.



Shows loading indicator while fetching.



Handles network errors gracefully.



User Detail Screen



Displays user details including name, email, phone, company, and profile photo.



Handles user not found and network exceptions.



Navigation



Uses NavGraph.kt for navigation.



Route example: user/{userId} passes userId as argument to detail screen.



Themes



Color.kt → color palette



Type.kt → typography styles



Theme.kt → app-wide Material3 theme



Dependency Injection



Hilt provides repository and API instances.



⚙️ Assumptions



API endpoint: https://fake-json-api.mock.beeceptor.com/users



All fields in User are Strings for simplicity.



No offline caching (Room/Datastore not implemented).



Minimal error handling for null users or network failures.



💡 Possible Improvements



Add pull-to-refresh for list screen.



Implement offline caching with Room or DataStore.



Pagination for large datasets.



Improve UI/UX with animations or Material3 components.







🎥 Demo Video



Quick Demo Video -included

