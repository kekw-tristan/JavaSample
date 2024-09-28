## How to Run

To get started with the project, follow these steps:

1. **clone repo**
1. **docker compose up --build**
1. **hint: tests don't run in docker container**

## Examples JSON POST

JSON examples für: 

http://localhost:8080/api/calendar: 

```
{
"studioId": 2,
"startDate": "2024-08-25",
"endDate": "2024-09-01",
"firstName": "John",
"lastName": "Doe",
"email": "john.doe@example.com"
}
```
http://localhost:8080/api/studio:

```
{
"prizePerDay": 150.0,
"addressId": 1
}
```

http://localhost:8080/api/address:

```
{
"prizePerDay": 150.0,
"addressId": 1
}
```
