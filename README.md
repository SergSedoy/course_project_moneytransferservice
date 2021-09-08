## Курсовой проект "Сервис перевода денег"
Вашему вниманию представлен REST-сервис. Сервис реализовывает все методы перевода с одной банковской карты на другую
описанные в протоколе https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml.
Все переводы с одной банковской карты на другую записываются в файл логирования.



При реализации данного проекта пришлось столкнуться с несколькими темами, которые пришлось изучать "на ходу",
в том числе - *CORS policy (Cross-Origin Request Blocked)*. 

##### В проекте используются технологии:
- Фреймворк Spring Boot;
- Сборщик проектов "Gradle";
- Фреймворк "Log4j2";
- Фреймворки "Mockito" и JUnit;
- Docker, docker-compose;
- Интеграционные тесты с использованием @Testcontainers.

##### Интеграция с FRONT:
Демо веб-приложение (FRONT) подключаемое к разработанному REST-сервису
развернуто по адресу https://serp-ya.github.io/card-transfer/.

##### Команды запуска и порты:

'docker build -t transferservice .'             *// создаём Docker-образ*

'docker run -p 5500:5500 -d transferservice'    *// запускаем Docker-образ*

'docker stop $(docker ps -aq)'                  *// $(docker ps -aq) - этос список id контейнеров*

'docker rm $(docker ps -aq)'                    *// удалит все контейнеры*

'docker-compose up'                             *// запуск через docker-compose.yml*