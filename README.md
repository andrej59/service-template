# Шаблон сервиса
        
## Описание
 
Шаблон сервиса
   
## Сборка  

```sh
mavenw clean package
```

## Конфигурация

Все настройки по умолчанию находятся в файлах:
- `src/main/resources/application.properties`  

Создайте файл конфигурации для локальной разработки `src/main/resources/application-local.properties`  
   (пример файла можно взять из `env/application-local-sample.properties`).
   
_Примечание_

* Файл `src/main/resources/application-local.properties` явно добавлен в файл `.gitignore`,
  его не нужно сохранять в репозитории разработки
* Список всех доступных параметров [common-application-properties](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#common-application-properties)

## Запуск профилей
 
### **local** - локальная разработка
 
IDEA:

1. В IDEA создать `Edit configuration -> Spring Boot`.
3. В поле **Main class:**  установить `ru.ajana.service.template.Application`.
4. В поле **VM Options** установить `-Dspring.profiles.active=local`, или в **Program arguments** установить `--spring.profiles.active=local`,     
   или **Enviroment variables** установить `SPRING_PROFILES_ACTIVE=local`.
5. В поле **Use classpath module** выбрать `service-template_main`.
6. В поле **Before launcher** выбрать  **Run Maven Goal**  и добавить команду - `spring-boot:build-info`. 
7. Запуск приложения через интерфейс IDEA.
     
Console:     

```
java -jar service-template.jar -Dspring.profiles.active=local  
```

_Примечание_

В файле `application-local.properties` можно переопределить любой параметр установленный в
`src/main/resources/application.properties`.
   
### **prod** - продуктив
 
1. Подготовьте файл конфигурации для службы `application-prod.properties` 
 
В файле `application-prod.properties` можно переопределить любой параметр установленный в
`src/main/resources/application.properties`.

2. Запуск

```sh
java -jar service-template.jar  --spring.config.location=classpath:/application.properties,file:$${APP_HOME}/config/application-prod.properties
```

[Детали параметра **--spring.config.location**](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config-application-property-files)
