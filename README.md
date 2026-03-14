# FinanceTracker

FinanceTracker is a modern Android application for managing personal finances.  
The app allows users to track income, record expenses, analyze spending patterns, and manage category based budgets.

## Features

- Add and manage income and expense transactions
- Category-based budget management
- Expense analytics with visual charts
- Currency switching (USD / EUR)
- Transaction search
- Modern dark UI built with Jetpack Compose

## Tech Stack

- Kotlin
- Jetpack Compose
- Room Database
- Hilt (Dependency Injection)
- MVVM Architecture
- Coroutines / Flow

## Architecture

The project follows Clean Architecture principles.

data
- datastore
- local
    - dao
    - database
    - entity
- repository

di
- DatabaseModule
- RepositoryModule

domain
- repository

presentation
- components
- navigation
- screens
- utils
- viewmodel
- theme

## Architecture Overview

The application follows the MVVM pattern.

1. UI (Compose Screens)  

2. ViewModel  

3. Repository  

4. Room Database (DAO)

## Screenshots

### Home
![Home](screenshots/1.Home.U_S_D.png)

### Currency Switch
![Currency Switch](screenshots/2.Home.Curerncy_Switch.E_U_R.png)

### Recent Transactions
![Recent Transactions](screenshots/6.Recent_Transactions.png)

### Analytics
![Analytics](screenshots/5.Analytics.png)

### Budgets
![Budgets](screenshots/3.Budgets.png)

### Add Transaction
![Add Transaction](screenshots/4.Add_Transactions.png)

## Installation

Download the project and open it in Android Studio.

1. Download the repository as a ZIP file
2. Extract the ZIP
3. Open the project folder in Android Studio
4. Let Gradle sync and run the app

## Developer

Younes Barka

GitHub  
https://github.com/YounesBarka00

LinkedIn  
https://www.linkedin.com/in/younes-barka-b5b45136a/