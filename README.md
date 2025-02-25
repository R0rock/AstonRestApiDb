# AstonRestCrudSql
stage 2 homework 2

- Сделать REST сервис c основными CRUD операциями
- Использовать сервлеты
- Использовать JDBC
- Нельзя использовать Spring, Hibernate
- Сервлет должен возвращать DTO, не возвращаем Entity, принимать
также DTO
- Покрыть rest unit тестами (не менее 80 %, использовать Mock, Spy,
Parameterized Tests)
- Должны быть как минимум слои: service, repository, mapper, dto, entity,
controller или servlet
- Использовать Lombok, кроме случаев переопределения equals и
hashcode
- Должны быть реализованы связи One-to-Many и Many-to-Many
- Базы данных MySQL или PostgreSQL
- Должны соблюдаться принципы ООП, SOLID
- Для проверки REST API использовать Postman или Insomnia
При необходимости быть готовым продемонстрировать разработанный
функционал на занятии

   Дополнительное задание со * (за дополнительные баллы):

1. Установите линукс (можно на виртуальную машину)
2. Если это линукс с gui задание должно быть выполнено через командную
строку
3. Установите JAVA
4. Установите Tomcat
5. Создайте Юзера tomcat и разрешите его доступ к папке где лежит томкат
6. Установите ваше приложение из второго заданияя на порту 8085
7. Установите Jenkins (можно локально, можно на виртуалку) (+2 баллов,
если дженкинс лежит на отдельной виртуальной машине)
8. Создайте соединение между Jenkins и Гитом (ssh)
9. Пусть после каждого коммита в мастер ветку на Git хаб Jenkins инсталит
приложение на сервер (Tomcat)

    Структура проекта

src/main/java
├── com
│   └── example
│       ├── controller
│       │   └── UserServlet.java
│       ├── dto
│       │   ├── UserDTO.java
│       │   └── AddressDTO.java
│       ├── entity
│       │   ├── User.java
│       │   └── Address.java
│       ├── mapper
│       │   ├── UserMapper.java
│       │   └── AddressMapper.java
│       ├── repository
│       │   ├── UserRepository.java
│       │   ├── UserRepositoryImpl.java
│       │   ├── AddressRepository.java
│       │   └── AddressRepositoryImpl.java
│       ├── service
│       │   ├── UserService.java
│       │   ├── UserServiceImpl.java
│       │   ├── AddressService.java
│       │   └── AddressServiceImpl.java
│       └── util
│           └── DatabaseUtil.java
src/test/java
├── com
│   └── example
│       ├── controller
│       │   └── UserServletTest.java
│       ├── service
│       │   └── UserServiceTest.java
│       └── repository
│           └── UserRepositoryTest.java
