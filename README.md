1)Завантажуємо Eclipse, останюю версію

2)Завантажуємо SQL Workbench(версія 8.0.27 підійде). після установки імпортуємо базу: Server ==> Data Import, вибираємо файл schoolmgtsp в папці DB

3)Завантажуємо JDK-18

4)Імпортуєм проект: File ==> Import ==> Existing Maven Project, обираємо директорію з проектом

5)Додаємо до проекту Lombok:
		В eclipse натискаєм на Help -> Install new software
		Додаємо ссиль на Lombok  https://projectlombok.org/p2 в поле work with
		Тиснем enter, чекаємо, тиснем галочку на Lombok, внизу прожимаємо Next, далі Finish, Select All, коли просить рестарт - рестартуєм
  
6)Конфігуруємо базу в файлі application.properties

7)Під Java Resources => src/main/java =? com.schoolmgt знаходимо файл SchoolMgtApplication, через правий клік робимо Run as Java Application

8)При успішній компіляції, проект буде доступний за урлом, що був вказаний в application.properties під час налаштувань. Наразі це - http://localhost:8080/SchoolMgt/

Troubleshooting:У випадку помилок виконуємо Right-click на проекті ==> Maven ==> Update Project ==> Force update of Snapshots/Releases(Check this) 
При необхідності  Right-click на проекті ==> properties ==> Project Facets - підняти java до версії 1.8
