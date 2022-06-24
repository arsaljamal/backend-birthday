Given a JSON file with a list of people and their dates of birth, write a program to print out the people whose birthday is today.

If a person was born on Feb 29th, then their birthday during a non-leap year should be considered to be Feb 28th.

Input sample file:

```
[
    ["Doe", "John", "1982/10/08"],
    ["Wayne", "Bruce", "1965/01/30"],
    ["Gaga", "Lady", "1986/03/28"],
    ["Curry", "Mark", "1988/02/29"]
]
```

You can use whichever programming language you like. The assignment should take 60 to 90 min. If it’s taking longer, consider whether you’re complicating things.

If you make any assumptions, trade-offs or de-prioritise features for timeliness, please document these decisions.

Your submission must have:

* Instructions to run the code

* Tests to check if your code is correct, robust and complete

* Edge cases handled and tested

* Iterative development, backed by commit history

* Modular, cohesive code with sensible separation of concerns

Bonus points for following Test-Driven Development.

Please do not overcomplicate the code. You don’t need a web framework, database or message queues for this submission. Keep it simple!

# Documentation

## Build and run using Docker

### Required Dependencies

* Docker ([macOS](https://docs.docker.com/desktop/mac/install/)/[Linux](https://docs.docker.com/engine/install/#server)))

### Getting Started

The quickest way to get up and running with the application is to run docker-compose from the root of the project directory:

```
cd backend-birthday-assignment-1-vyisoh
```
```
docker-compose build
```
```
docker-compose up
```
Expected output : 
```
Starting backend-birthday-service ... done
Attaching to backend-birthday-service
backend-birthday-service    | 2022-06-23 19:46:05 INFO People whose birthday is on 2022-06-23 : [People{firstName='John', lastName='Baker', birthday=1988-06-23}]
backend-birthday-service exited with code 0
```

* I have made some changes to the input file located inside folder : `/src/main/resources/input.json`

```
[
  {"firstName" : "Doe", "lastName" : "John", "birthday" : "1982/10/08"},
  {"firstName" : "Wayne", "lastName" : "Bruce", "birthday" : "1965/01/30"},
  {"firstName" : "Gaga", "lastName" : "Lady", "birthday" : "1986/03/28"},
  {"firstName" : "Curry", "lastName" : "Mark", "birthday" : "1988/02/29"},
  {"firstName" : "John", "lastName" : "Baker", "birthday" : "1988/06/23"}
]
```

Currently, the output may return an empty list. As I am calculating birthday's on the current date, so it would result in
no match being found. Hence, for this we can make updates to the input.json file accordingly and re-run the application by
following the build and run steps.

* Test cases are located inside folder : `/src/test/java` 