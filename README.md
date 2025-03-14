# Coles Android Mobile Coding Challenge

This is my submission for the Coles Android Mobile Coding Challenge.
Thanks very much for looking.

## Features and inclusions

1. Kotlin as the primary language
2. Modern architectural practices
3. Jetpack Compose UI framework
4. Compose / Material Theming
   - With added dark mode support
5. Coroutines
6. Error handling
    - Messages, logs and an error screen if there is a critical failure loading the data
7. Orientation changes support
    - Two columns when landscape VS one column when portrait
8. Hilt/Dagger2 dependency injection
9. Navigation Component library
    - Compose Navigation used
10. Unit and Android Instrumented Testing
11. Accessibility features
    - Via colour theming, thumbnail alternative / descriptive text, semantics with grouping descendants and content descriptions
12. Android Architecture Libraries
    - ViewModels used to maintain state and data across recompositions and navigation
    - Repository to abstract data sourcing and collection

## Unit Tests

I have implemented unit testing and instrumented testing in this application.
Unit tests cover the two ViewModels, while instrumented tests cover the Repository and JsonFileReader object.