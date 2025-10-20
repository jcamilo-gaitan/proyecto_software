\#proyecto\_software

Hola!

En esta versión encontrará la implementación de las funcionalidades básicas del proyecto "Juegos":



• Agregar, editar y eliminar juegos con información básica (título, plataforma, género).

• Filtrar juegos por estado (rescatado,jugando,pendiente).



• Búsqueda por título o plataforma.



///MANUAL DE INSTALACION Y CONFIGURACIÓN.////////////////////////////////

Para poder usar el sistema se debe:

&nbsp;	•Tener instalado Maven, MySql y un IDE para Java. 

&nbsp;	•Descargar el contenido presente en el repositorio de GitHub.

&nbsp;	•Abrir el proyecto en un IDE, con java 17 disponibles.

&nbsp;	•Ejecutar la aplicación desde el IDE.

&nbsp;	•Una vez la aplicación haya iniciado, se podrán ejecutar solicitudes POST, PUT, GET, DELETE desde Postman, para usar Postman se debe:

&nbsp;	•Usar la URL http://localhost:8080/api/juegos (URL principal)

&nbsp;	•Seleccionar la solicitud deseada y modificar o no la URL según corresponda





Respecto a la solicitud GET:

&nbsp;	

&nbsp;	•Para poder filtrar por estado,se debe añadir a la URL principal “/filtrarEstado/{estado}”

&nbsp;	•Para poder buscar por titulo, se debe añadir a la URL principal “/buscarTitulo/{titulo}”

&nbsp;	•Para poder filtrar por plataforma, se debe añadir a la URL principal “/filtrarPlataforma/{plataforma}”

&nbsp;	•Para poder buscar por id, se debe añadir a la URL principal  “/{id}”



Restricción de valores:



Titulo: Hasta 336 caracteres.

Descripción: hasta 3000 caracteres

Género:

&nbsp;	ACCION

&nbsp;	AVENTURA

&nbsp;	RPG

&nbsp;	ESTRATEGIA

&nbsp;	CARRERAS

&nbsp;	SHOOTER

&nbsp;	DEPORTES

&nbsp;	LUCHA

&nbsp;	ARCADE

&nbsp;	PUZZLE

&nbsp;	SIMULACION

&nbsp;	VISUAL NOVEL

&nbsp;	TERROR

&nbsp;	MUNDO ABIERTO

&nbsp;	SANDBOX

&nbsp;	PARTY

&nbsp;	REALIDAD VIRTUAL

&nbsp;	METROIDVANIA



Plataforma:



&nbsp;	PC

&nbsp;	PLAYSTATION

&nbsp;	XBOX

&nbsp;	NINTENDO SWITCH

&nbsp;	NINTENDO 3DS

&nbsp;	WII

&nbsp;	WII U

&nbsp;	GAMECUBE

&nbsp;	NINTENDO 64

&nbsp;	SUPER NINTENDO

&nbsp;	NES

&nbsp;	SEGA GENESIS

&nbsp;	SEGA SATURN

&nbsp;	DREAMCAST

&nbsp;	PLAYSTATION 2

&nbsp;	PLAYSTATION 3

&nbsp;	PLAYSTATION 4

&nbsp;	PLAYSTATION 5

&nbsp;	XBOX 360

&nbsp;	XBOX ONE

&nbsp;	XBOX SERIES X

&nbsp;	XBOX SERIES S

&nbsp;	ANDROID

&nbsp;	IOS

&nbsp;	TABLET

&nbsp;	MAC

&nbsp;	LINUX

&nbsp;	STEAM DECK

&nbsp;	OCULUS QUEST

&nbsp;	META QUEST

&nbsp;	PLAYSTATION VR

&nbsp;	HTC VIVE

&nbsp;	PICO

&nbsp;	NINTENDO DS

&nbsp;	GAME BOY

&nbsp;	GAME BOY ADVANCE

&nbsp;	PSP

&nbsp;	PS VITA

&nbsp;	ARCADE

&nbsp;	SMART TV

&nbsp;	WEB

&nbsp;	CLOUD GAMING

&nbsp;	AMAZON LUNA

&nbsp;	NVIDIA GEFORCE NOW

&nbsp;	GOOGLE STADIA

estado:

&nbsp;	RESCATADO

&nbsp;	JUGANDO

&nbsp;	PENDIENTE







¡Después del 18 de octubre de 2025, vendrán más actualizaciones!

