# Hospital AccWe
Recientemente varios hospitales de la zona han recibido una serie de ataques informáticos y se ha propuesto renovar el sistema de control de citas en el hospital AccWe, ya que es lo que mas tiempo lleva sin actualizarse. Los desarrolladores han salvado parte del proyecto anterior y lo han limpiado para evitar posibles errores, actualizando sobretodo librerías. Tu tarea sera implementar, arreglar y desarrollar las diferentes necesidades del hospital en cuanto a la gestión de citas.


## Tecnologías

- Java: Programming language used for the development of the project.
- Maven: Build and dependency management tool used for project configuration and compilation.
- Spring Boot: Java framework used to simplify the development of Spring-based applications.
- JUnit: Java unit testing framework used for automated testing of the code.
- Docker: Containerization platform that facilitates packaging, distribution, and execution of applications in isolated environments.


## Class model

![Modelo de clases](https://i.postimg.cc/QNFfSP0b/Class-Diagram.png)


## Endpoints

### Appointments
 
| Endpoint         | Method | Description                                |
| ---------------- | ------ | ------------------------------------------ |
| `/api/appointments`     | GET    | Retrieves all appointments                        |
| `/api/appointments/:id` | GET    | Retrieves an appointment by ID                      |
| `/api/appointment`     | POST   | Creates a new appointment                          |
| `/api/appointments/:id` | DELETE    | Deletes an appointment by ID                  |
| `/api/appointments` | DELETE | Deletes all appointments                         |

### Doctors
| Endpoint         | Method | Description                                |
| ---------------- | ------ | ------------------------------------------ |
| `/api/doctors`     | GET    | Retrieves all doctors                        |
| `/api/doctors/:id` | GET    | Retrieves a doctor by ID                      |
| `/api/doctor`     | POST   | Creates a new doctor                          |
| `/api/doctors/:id` | DELETE    | Deletes a doctor by ID                  |
| `/api/doctors` | DELETE | Deletes all doctors       

### Patients
| Endpoint         | Method | Description                                |
| ---------------- | ------ | ------------------------------------------ |
| `/api/patients`     | GET    | Retrieves all patients                        |
| `/api/patients/:id` | GET    | Retrieves a patient by ID                      |
| `/api/patient`     | POST   | Creates a new patient                          |
| `/api/patients/:id` | DELETE    | Deletes a patient by ID                  |
| `/api/patients` | DELETE | Deletes all patients        

### Rooms
| Endpoint         | Method | Description                                |
| ---------------- | ------ | ------------------------------------------ |
| `/api/rooms`     | GET    | Retrieves all rooms                        |
| `/api/rooms/:roomName` | GET    | Retrieves a room by roomName                     |
| `/api/room`     | POST   | Creates a new room                          |
| `/api/rooms/:roomnName` | DELETE    | Deletes a room by roomName                  |
| `/api/rooms` | DELETE | Deletes all rooms    


## Personal Conclusions

I consider that the challenge is very good, especially to reinforce knowledges that are essential this days for the development of applications. Obviously because is a practice project there are things that did not enter as for example: security with Spring Security.
I hope you continue to bring out these challenges that are appreciated a lot!
Regards Raul Funes.