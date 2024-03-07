# GitHub repo viewer

## **Description**

Technical task is to develop a GitHub Repo Viewer app that allows users to view repositories from GitHub. 

## Installation

you should to add 

```kotlin
RELEASE_URL=https://api.github.com/
DEBUG_URL=https://api.github.com/
```

in [local.properties](http://local.properties) file 

and sync then build and run

## App Features

- MVVM Structure
- Retrofit Network Third Party
- Room Database for Cashing
- Pagination with Pager3
- Searching
- Night Mode and Dark Mode
- Material3 with system design

## GIF

<hr>
<img src="https://github.com/m07med176/GithubRepoViewer/blob/master/screenshots/video.gif" alt="GIF">
<hr>

## Screenshots

<table>
  <tr>
    <td align="center"><img src="https://github.com/m07med176/GithubRepoViewer/blob/master/screenshots/1.png" alt="Image 1"></td>
    <td align="center"><img src="https://github.com/m07med176/GithubRepoViewer/blob/master/screenshots/2.png" alt="Image 2"></td>
    <td align="center"><img src="https://github.com/m07med176/GithubRepoViewer/blob/master/screenshots/3.png" alt="Image 3"></td>
    <td align="center"><img src="https://github.com/m07med176/GithubRepoViewer/blob/master/screenshots/4.png" alt="Image 4"></td>
  </tr>
  <tr>
    <td align="center"><img src="https://github.com/m07med176/GithubRepoViewer/blob/master/screenshots/5.png" alt="Image 5"></td>
    <td align="center"><img src="https://github.com/m07med176/GithubRepoViewer/blob/master/screenshots/6.png" alt="Image 6"></td>
    <td align="center"><img src="https://github.com/m07med176/GithubRepoViewer/blob/master/screenshots/7.png" alt="Image 7"></td>
    <td align="center"><img src="https://github.com/m07med176/GithubRepoViewer/blob/master/screenshots/8.png" alt="Image 8"></td>
  </tr>
</table>

## App Design

I have designed this project in MVVM architecture with layered clean architecture 

into 3 layers:

Domain Layer

Data Layer 

Presentation Layer

### Domain Layer:

i have added in this package 

- all use cases that end user need it from Data layer
- all repository interfaces
- all  Core Entity bussines model

**NOTE: i have put interface of mapper that used to map DTO to Domain model**

### Data Layer:

**For network call:**

- i have add BASE URL in [local.properties](http://local.properties)  for more Security Propose
- i have Endpoints in separated object
- in retrofit configuration i have added **Logging Interceptor**, **Header Data, Network Timeout and custom NetworkResponseAdapterFactory** to handle response of Response and add Bad response
- i have added network detector

**For room cashing database :**

- i have added converter that convert nested object of Entity Model to string  with using Gson for parsing ,i preferer this way than relation tables and impeded object because this way easy to implement and effective
- i have added Worker to delete all database i exceed in limit of cashing day
- i have add Paging 3 with room

### Presentation Layer:

- i have added three features of All repositories of 3 screen:
    
    retrieve Repositories
    
    Repository Details 
    
    Repository Issues
    
- i have add dark mode and light mode and save it in Datastore
