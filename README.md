# simpleSchedule
**A full stack web application for use as a front-desk medical service scheduler, intended to access a local database.**

Created for TEKGlobal Java Developer course

version 1.1 released April 11, 2021

[GitHub](https://github.com/danielmckinnonanderson/simpleSchedule)

------------------------------------------------------------------

**First-time Setup**

Navigate to the folder 'database', and run the SQL file 'initialize_simpleScheduleDB' to create the tables and initial data

-------------------------------------------------------------------


**Overview**

This application was designed with a focus on ease-of-use, thus the name.
The goal was to make an application that people would not need to be trained on how to use--Options are spelled out clearly, the UI is easy to read and unobtrusive, and performing the most common tasks is easy and intuitive.

With this goal in mind, I designed the application with user experience at the forefront:

**User Stories**
- As a scheduler, I want to access the things I do the most in no more than 3 pages from the homescreen.
- As a doctor, I want to see what appointments I have scheduled for any given date or time clearly and concisely.
- As a patient, I don't want to have to wait around for the person at the front desk to navigate a complicated application, I just want to get scheduled and be finished.
- As a scheduler, I don't want to have to spend most of my day looking at an eyesore.
- As a scheduler, I want to be able to find patients by as many or as few details as I have.
- As a patient, I want to provide necessary information quickly and without redundancy.
- As a patient, I want to be able to update my personal information as it changes.
- As a scheduler, I want to be able to easily alter data and correct mistakes that may come up.
- As a biller, I want to access patient's insurance information without having to jump through hoops in the computer system.
- As a patient, I want to have the option to have all my personal information completely removed from the system.
- As a scheduler, I want to have the system confirm that I meant to do something which could be destructive.


--------------------------------------------------------------------


**Technical Blog**

Early on, I encountered an issue that I wanted to fix as a helpful feature: Rather than requiring search forms to be completely filled out and then returning a single value, I wanted users to have the ability to fill out as much or as little of a form as they'd like and have the database query only what was provided. I set up the spring forms to databind to its respective object (either a patient or an appointment), and then parsed the fields to construct this object. If the user did not input values into some of the form fields, the databound object would construct with those values being set to `null`. Then, on my service layer, I utilized a series of chained private methods to parse the objects attributes and only send queries based on the attributes which were not `null`. If a patient has an extremely unique last name or is born on a leap day, I didn't want the user to have to continue to input fields when just having one filled out would likely be enough to display the intended result.

One of the more difficult issues I dealt with was the referencing of ID values from lists of objects. The application uses many lists for its core functions, and they needed to be able to reference each other smoothly. My initial solution was to use hidden fields that contained an object's ID in form submission, however retrieval was still cumbersome. While it did require some work to change things over, I determined that the best course of action would be to utilize Maps rather than Lists for many of these iterables. The Map interface allowed me to set a key value equal to an object's ID, and use that key value to retrieve the object itself. This made referencing the specific objects in lists significantly easier, and it allowed me to make lists more dynamic and future-proof since they relied on ID values instead of index values which are subject to change.

A user story that I felt was very important to implement was that of a user wanting to be prompted to confirm a potentially destructive choice. When buttons on a page look somewhat similar (and even when they don't) it's very easy to click something you didn't mean to. In this case, clicking delete on accident might completely remove a patient and all of their details and appointments from the system! To solve this, I made any destructive action redirect to a page displaying exactly what will be deleted and prompting the user to either go back to the page they were viewing previously if they made a mistake, or proceed with the deletion by clicking continue. Accidents happen, and a good application should protect users from their potentially dangerous mistakes.

While the functionality was largely working well, I wanted to improve the visuals to really make things clean and easy to read. This resulted in some other changes on the jsp files in order to accomodate the new CSS. Despite all the database connectivity, Java-based controllers, and complicated service-layer logic, this CSS was the most frustrating task to tackle. The method to the madness prevented a full-on spiral into dismay: Only change one thing at a time until it works. It was really important to me to have the front-end looking really crisp, and as a result it can be easy to get too overzealous with wide-ranging changes only to find that your page is no longer readable and you don't know what sent things astray. While it ended up being rather time-consuming, it's probably safe to assume that going crazy on the stylesheet before checking out the changes would've resulted in many more hours of scanning line-by-line.


------------------------------------------------------------------------

**Version History**

*v1.1 (released 4/11/2021)*:
- Visual overhaul to make things prettier


*v1.0.1*:
- Bugfixes: Appointment Search is no longer broken, Appointment Search now displays patient's name instead of ID, deleting a patient now also deletes all their appointments


*v1.0 (released 4/9/21)*:
- Basic workflow of application, CRUD function for Patient and Appointment model objects
- Simplistic but visually pleasing stylesheet 
- JPA functionality with local database called 'simpleSchedule'
