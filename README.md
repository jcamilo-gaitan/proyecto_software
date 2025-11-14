📚 Biblioteca de Juegos – Proyecto de Desarrollo de Software


(Puedes reemplazar esta imagen por una captura de tu app.)

📌 Descripción del proyecto

Este proyecto implementa una aplicación completa para la gestión de una Biblioteca de Juegos, permitiendo que los usuarios registren, editen, consulten y eliminen juegos de su colección.
Incluye:

🌐 Backend REST en Spring Boot

🎨 Frontend moderno en React + Vite

🗄️ Base de datos H2/MySQL

🔄 Comunicación a través de API REST

📊 Módulo de estadísticas

🔐 Login básico con usuarios demo

🧱 Tecnologías utilizadas
🔹 Backend

Java 17

Spring Boot 3

Spring Web

Spring Data JPA

H2 / MySQL

🔹 Frontend

React 18

Vite

TypeScript

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

Buscar por título o plataforma

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

🏁 Estado del proyecto

✔ Backend funcional
✔ Frontend completamente integrado
✔ CRUD operativo
✔ Filtros, búsqueda y paginación
✔ Estadísticas
✔ Usuarios demo
