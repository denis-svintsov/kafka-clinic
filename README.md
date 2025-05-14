# Система записи в клинику

### 1. Клонирование

git clone https://github.com/denis-svintsov/kafka-clinic
cd kafka-clinic

### 2. Запуск

Соберите и запустите:

docker-compose up --build

### 3. Запросы к API

#### Создать пациента

curl -X POST http://localhost:8080/api/client/add -H "Content-Type: application/json" -d '{
"phone": "+7-900-123-4567",
"surname": "Иванов",
"name": "Иван",
"patronymic": "Иванович",
"age": 30,
"address": "г. Москва, ул. Пушкина, д. 10",
"email": "ivan.ivanov@example.com"
}'

- Ожидаемый ответ:
"Сообщение отправлено в топик."

#### Создать запись

curl -X POST http://localhost:8080/api/appointment/add -H "Content-Type: application/json" -d '{
  "appointmentDate": "2025-05-14T14:30:00",
  "doctor": "Петров Петр Петрович",
  "notes": "Головные боли",
  "services": "Консультация, МРТ головного мозга",
  "complaints": "Головная боль",
  "visited": false,
  "amount": 3499,
  "clientPhone": "+7-900-123-4567"
}'

- Ожидаемый ответ:
"Сообщение отправлено в топик."

#### Отметить запись, как посещенную

curl http://localhost:8080/api/appointment/isVisited?id=1

- Ожидаемый ответ:
"Сообщение отправлено в топик."


#### Поиск клиентов с записями

curl http://localhost:8080/api/report/getRecordsForClient?phone=+7-900-123-4567


- Ожидаемый ответ:
{
    "phone": "+7-900-123-4567",
    "surname": "Иванов",
    "name": "Иван",
    "patronymic": "Иванович",
    "age": 30,
    "address": "г. Москва, ул. Пушкина, д. 10",
    "email": "ivan.ivanov@example.com",
    "appointments": [
        {
            "id": 7,
            "appointmentDate": "2025-05-14T14:30:00",
            "doctor": "Петров Петр Петрович",
            "notes": "Головные боли",
            "services": "Консультация, МРТ головного мозга",
            "complaints": "Головная боль",
            "visited": false,
            "amount": 3499.0,
            "clientPhone": "+7-900-123-4567"
        }
    ]
}


#### Отчет: Все запланированные записи

curl http://localhost:8080/api/report/getCountPlannedRecords


- Ожидаемый ответ:
"1"


#### Отчет: Сумма потраченная клиентами за предыдущий месяц


curl http://localhost:8080/api/report/getAmountByMonth


- Ожидаемый ответ:
"0"


#### Отчет: Сумма потраченная клиентом за все время

curl http://localhost:8080/api/report/getAmountByClient?phone=+7-900-123-4567

- Ожидаемый ответ:
"3499.0"


### 4. Остановка

docker-compose down
