# Projekt LAT

## Mitglieder
- Tristan Jung
- Lara Schenk
- Antonio Keßler

## How to Run

To get started with the project, follow these steps:

1. **Repository clonen**
1. **docker compose up --build**
1. **Tests können nur ohne Docker gestartet werden (Empfählung All in directory storage und api)**

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
