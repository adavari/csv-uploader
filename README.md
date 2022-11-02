## API
| Name            | Path        | Method | Body                     | Description                 | Response                                   |
|-----------------|-------------|--------|--------------------------|-----------------------------|--------------------------------------------|
| upload          | /api/v1/csv | POST   | file multipart form data | upload csv file             | { 	"error": false, 	"message": "csv file uploaded successfully" } |
| get all csvs    | /api/v1/csv | GET    | -                        | get all csv files           |           |
| get csv by code | /api/v1/csv/{code} | GET    | -                        | get csv by code             |           |
| delete all data | /api/v1/csv | DELETE | -                        | delete all data in database |           |