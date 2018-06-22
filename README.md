##fhj.swenga2018.project

#Calories Calculator(CC)

The CC is an application to help you reach a certain goal concerning the weight and health of your body and was developed during the study course Software Engineering Advanced at FH JOANNEUM (UAS) in the Bachelor's degree Informationsmanagement (IMA16). The project was supported by DI (FH) Johann Blauensteiner and DI (FH) Stefan Krausler-Baumann.

###Team Members:

    Stefan Krasser
    Miriam Grainer
    Christoph Mali
    Thomas Ortner

###Workload distribution:

    Stefan Krasser: Security, Login and Registration, User Settings, Admin Settings, Validate Items, Add 							Items,
    Miriam Grainer: Thymeleaf: Design of Web Application, Create Activities, Guestbook, Diary,
    Christoph Mali: Calculator Logic, StandardKalorienVerbrauch,
    Thomas Ortner: Relationships Art-Food-Drink-Sport-Items, FillDatabase,
    
        
###Setup Guide

    Download project source from here
    Create New dynamic Web project eclipse project, convert to maven project and import sources
    Setup db.properties in folder src (db-connection-information)
    Change jpa-properties in dispatcher-servlet.xml to required attributes (validate, update, or create-drop)
    Setup your eclipse project (Server, Runtime, ...)
    Publish project to Tomcat and start Tomcat (8.5)
    Open Web application.
    Press on Button "Fill Database" to fill the Database with required data
    Login credentials: admin/password, user/password, guest/password
    Fill in the personel Settings so you can use full range of possibilities in the web application
    Have a lot of fun and reach your goal with the Calories Calculator

