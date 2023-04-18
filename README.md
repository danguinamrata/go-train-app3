# GoTrainScheduleApp
This is a simple RestAPI to query the GO train schedule data.

### Tech Stack
Data storage for this application is in in-memory db (H2) which is loaded only once during Application startup.
For this project we use the openJdk 17, maven 3.9.1 setup, springboot 3.0.5, MapStruct and many others.



### Start Application
At the application directory level , you can run a clean install to build the application JAR
```
mvn clean install
```
This will create a JAR file of the application which can be executed as a normal JAR file.

Once the jar is built, execute “GoTrainApp3Application” class which should start the application at port=8080.

Alternatively, you could also build and start the app using below command (using maven wrapper), (this could be useful when we host this app in a container and can be used as an entry point script)
```
./mvnw spring-boot:run
```

## API calls and features

### \[GET\] /schedule

      This API returns the entire timetable as a JSON array.
      The output is displayed in a JSON format.

### \[GET\] /schedule/{line}
      Returns all schedules for a particular line.
      The output is displayed in a JSON format.


###  \[GET\] /schedule/{line}?departure={time}

      Returns the result by line and departure.   



## PostMan Collection
Simply import following file [go-train-schedule-app-postman.postman_collection.json](https://github.com/danguinamrata/go-train-app3/blob/main/src/test/resources/go-train-schedule-app-postman.postman_collection.json) into your postman app to trigger various testcases once the APP is started as described above.


### Future Application Enhancements
 * Application could be easily containerized as it is built in the microservice format.
 * Store abstraction will help to easily configure storage possibilities (db/file based and so on).
 * Code is written in such a way that it could be easily unit tested.
 


        
 
    
      
      
