📚 Biblioteca de Juegos – Proyecto de Desarrollo de Software


En esta versión encontrará la implementación de las funcionalidades completas del proyecto "Juegos" (incluye front end):

📌 Descripción del proyecto

Este proyecto implementa una aplicación completa para la gestión de una Biblioteca de Juegos, permitiendo que los usuarios registren, editen, consulten y eliminen juegos de su colección.
Incluye:

🌐 Backend REST en Spring Boot

🎨 Frontend moderno en React + Vite

• Búsqueda por título o plataforma.

• Ranking de Juegos más guardados.

• Gráficos de plataformas más frecuentes en la

biblioteca.

🔐 Login básico con usuarios demo

🧱 Tecnologías utilizadas
🔹 Backend

Java 17

Spring Boot 3

Spring Web

&nbsp;	•Tener instalado node v24.

 	•Descargar el contenido presente en el repositorio de GitHub.

H2 / MySQL

🔹 Frontend

React 18

 	•Usar la URL http://localhost:8080/api/juegos (URL principal) en caso de usar postman.

 	•Para acceder al front end se deberá acceder a la consola de comandos y ejecutar 'npm start' en la carpeta front end

TailwindCSS

Shadcn/UI

Lucide Icons

📦 Cómo clonar y ejecutar el proyecto
git clone https://github.com/tu-usuario/biblioteca-juegos.git
cd biblioteca-juegos

🖥️ MANUAL DE USUARIO – FRONTEND (React + Vite)
🔧 Instalación
1️⃣ Entrar a la carpeta del frontend
cd frontend

2️⃣ Instalar dependencias
npm install

3️⃣ Ejecutar la aplicación
npm run dev

4️⃣ Abrir en navegador

Normalmente Vite levanta en:

http://localhost:5173

🔐 Inicio de sesión (modo demo)
Usuario	Contraseña
demo@biblioteca.com
	demo123
admin@biblioteca.com
	demo123
gamer@biblioteca.com
	demo123
🧭 Funcionalidades principales del frontend
✔ Biblioteca de juegos

Listar juegos



Todas las solicitudes están implementadas en la interfaz gráfica, donde entre otros, podrá:

agregar juegos a biblioteca, crear nuevos juegos en catálogo y acceder a visualización de datos globales.





Restricción de valores:

Filtrar por estado

Paginación

Ver autor, género, plataforma y estado

✔ Gestión de juegos

Agregar juego (POST al backend)

Editar juego (PUT al backend)

Eliminar juego (DELETE al backend)

✔ Estadísticas

Gráficos por estado

Gráficos por género

📡 Conexión con el backend

Toda la comunicación se realiza desde:

src/api/juegos.ts


Este archivo define:

fetchGames()

createGame()

updateGame()

deleteGame()

Se comunican con la API:

http://localhost:8080/api/juegos

🖥️ MANUAL DE USUARIO – BACKEND (Spring Boot)
🔧 Requisitos

Java 17+

Maven 3.8+

MySQL (opcional)

Puerto por defecto: 8080

🚀 Cómo ejecutar el backend
1️⃣ Entrar a la carpeta del backend
cd backend

2️⃣ Ejecutar con Maven
mvn spring-boot:run

3️⃣ Probar en navegador
http://localhost:8080/api/juegos

📚 Endpoints disponibles
🔹 Obtener todos los juegos
GET /api/juegos

🔹 Obtener juego por ID
GET /api/juegos/{id}

🔹 Crear juego
POST /api/juegos


Body JSON:

{
  "titulo": "Hades",
  "plataforma": "PC",
  "genero": "Roguelike",
  "estado": "RESCATADO"
}

🔹 Actualizar juego
PUT /api/juegos/{id}

🔹 Eliminar juego
DELETE /api/juegos/{id}

🔹 Filtrar por estado
GET /api/juegos/filtrarEstado/RESCATADO

🔹 Buscar por título
GET /api/juegos/buscarTitulo/Hades

🔹 Filtrar por plataforma
GET /api/juegos/filtrarPlataforma/PC

🔐 CORS (para permitir conexión con React)

En JuegoController incluir:

@CrossOrigin(origins = "http://localhost:5173")

🗂️ Estructura del proyecto
Backend
backend/
 ├── src/main/java/com/proyecto/entrega2
 │    ├── controller/JuegoController.java
 │    ├── service/JuegoService.java
 │    ├── entity/Juego.java
 │    ├── entity/estadoJuego.java
 │    └── repository/JuegoRepository.java
 ├── resources/application.properties
 └── pom.xml

Frontend
frontend/
 ├── src/
 │    ├── api/juegos.ts
 │    ├── components/
 │    │      ├── GameLibrary.tsx
 │    │      ├── GameForm.tsx
 │    │      ├── Statistics.tsx
 │    │      └── LoginForm.tsx
 │    ├── App.tsx
 │    └── main.tsx
 └── package.json

📸 Capturas de pantalla (recomendadas)

Agrega imágenes a la carpeta assets/ y referencia así:

![Login](./assets/login.png)
![Biblioteca](./assets/library.png)
![Agregar Juego](./assets/add-game.png)
![Estadísticas](./assets/stats.png)

 	XBOX SERIES X

 	XBOX SERIES S

 	ANDROID

 	IOS

 	TABLET

 	MAC

 	LINUX

 	STEAM DECK

 	OCULUS QUEST

 	META QUEST

 	PLAYSTATION VR

 	HTC VIVE

 	PICO

 	NINTENDO DS

 	GAME BOY

 	GAME BOY ADVANCE

 	PSP

 	PS VITA

 	ARCADE

 	SMART TV

 	WEB

 	CLOUD GAMING

 	AMAZON LUNA

 	NVIDIA GEFORCE NOW

 	GOOGLE STADIA

estado:

 	RESCATADO

 	JUGANDO

 	PENDIENTE





Recuerde que deberá registrarse e iniciar sesión para usar la aplicación, ¡no olvide su contraseña!



Además encontrará un modulo de datos que le mostrara estadísticas globales relevantes.





¡No creo que haya más actualizaciones:( !

✔ Backend funcional
✔ Frontend completamente integrado
✔ CRUD operativo
✔ Filtros, búsqueda y paginación
✔ Estadísticas
✔ Usuarios demo
