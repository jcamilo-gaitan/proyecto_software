\#proyecto\_software

Hola!

En esta versión encontrará la implementación de las funcionalidades completas del proyecto "Juegos" (incluye front end):



• Agregar, editar y eliminar juegos con información básica (título, plataforma, género).

• Filtrar juegos por estado (rescatado,jugando,pendiente).

• Búsqueda por título o plataforma.

• Ranking de Juegos más guardados.

• Gráficos de plataformas más frecuentes en la

biblioteca.



///MANUAL DE INSTALACION Y CONFIGURACIÓN.////////////////////////////////

Para poder usar el sistema se debe:

 	•Tener instalado Maven, MySql y un IDE para Java.

&nbsp;	•Tener instalado node v24.

 	•Descargar el contenido presente en el repositorio de GitHub.

 	•Abrir el proyecto en un IDE, con java 17 disponibles.

 	•Ejecutar la aplicación desde el IDE.

 	•Una vez la aplicación haya iniciado, se podrán ejecutar solicitudes POST, PUT, GET, DELETE desde Postman, para usar Postman se debe:

 	•Usar la URL http://localhost:8080/api/juegos (URL principal) en caso de usar postman.

 	•Para acceder al front end se deberá acceder a la consola de comandos y ejecutar 'npm start' en la carpeta front end





Respecto a la solicitud GET:

 

 	•Para poder filtrar por estado,se debe añadir a la URL principal “/filtrarEstado/{estado}”

 	•Para poder buscar por titulo, se debe añadir a la URL principal “/buscarTitulo/{titulo}”

 	•Para poder filtrar por plataforma, se debe añadir a la URL principal “/filtrarPlataforma/{plataforma}”

 	•Para poder buscar por id, se debe añadir a la URL principal  “/{id}”





Todas las solicitudes están implementadas en la interfaz gráfica, donde entre otros, podrá:

agregar juegos a biblioteca, crear nuevos juegos en catálogo y acceder a visualización de datos globales.





Restricción de valores:



Titulo: Hasta 336 caracteres.

Descripción: hasta 3000 caracteres

Género:

 	ACCION

 	AVENTURA

 	RPG

 	ESTRATEGIA

 	CARRERAS

 	SHOOTER

 	DEPORTES

 	LUCHA

 	ARCADE

 	PUZZLE

 	SIMULACION

 	VISUAL NOVEL

 	TERROR

 	MUNDO ABIERTO

 	SANDBOX

 	PARTY

 	REALIDAD VIRTUAL

 	METROIDVANIA



Plataforma:



 	PC

 	PLAYSTATION

 	XBOX

 	NINTENDO SWITCH

 	NINTENDO 3DS

 	WII

 	WII U

 	GAMECUBE

 	NINTENDO 64

 	SUPER NINTENDO

 	NES

 	SEGA GENESIS

 	SEGA SATURN

 	DREAMCAST

 	PLAYSTATION 2

 	PLAYSTATION 3

 	PLAYSTATION 4

 	PLAYSTATION 5

 	XBOX 360

 	XBOX ONE

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

