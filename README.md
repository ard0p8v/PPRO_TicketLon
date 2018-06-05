# TicketLon
#### Školní projekt - FIM UHK
PPRO - Pokročilé programování

Webová aplikace bude sloužit jako rezervační systém pro malé a středně velké sportovní a kulturní události konané v okolí Hradce Králové. V modelu bude šest základních entit: uživatel, událost, typ události, místo konání události, rezervace a novinky. Do aplikace bude moci vstoupit pouze přihlášený uživatel. Pro všechny typy entit budou použity CRUD operace (vytvářet, aktualizovat, mazat). Pro entita uživatel, událost, typ události, místo konání událostí a novinky bude CRUD operace přístupná pouze pro administrátora. Uživatel bude moci tyto entity pouze prohlížet. Uživateli bude zpřístupněno rezervace určité události nebo odebrání rezervace.

<hr />

#### School project - FIM UHK
PPRO - Advanced programming

The web application will serve as a booking system for small and medium-sized sports and cultural events held around Hradec Kralove. There will be six basic entities in the model: user, event, event type, event venue, reservation, and news. Only the logged-in user will be able to access the application. For all types of entities, CRUD operations will be used (create, update, delete). For the user entity, event, event type, event location, and news item, the CRUD operation will only be accessible to the administrator. The user will only be able to view these entities. The user will be able to book a certain event or take a reservation.

![usecase](https://user-images.githubusercontent.com/25181243/32955155-71cd65e6-cbb5-11e7-8ba8-6d1fc7a69d22.png)

## Database
Two sql scripts are attached to the project:
* initDB.sql - base schema of database
* populateDB.sql - default data
<hr />

## Login
You can log in to the system using four user accounts:

| username  | password | role |
| --------- | --------- | --------- |
| test  | test  | user |
| userPepa  | userPepa  | user |
| managerFranta | managerFranta | manager |
| adminHonza | adminHonza | admin |



## Technologies
* Java
* Spring MVC
* Spring Security
* MySQL
* Hibernate
* Git
* Bootstrap
* AJAX
