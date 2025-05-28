# Proyecto Docker Compose: Angular + WebSocket

## Descripción
Este proyecto implementa una aplicación distribuida con dos servicios contenedorizados:
- Frontend: Aplicación Angular servida por Apache en Debian, que muestra un mensaje de bienvenida y se conecta a un servidor WebSocket.
- Backend: Servidor WebSocket en Node.js que envía mensajes periódicos a los clientes conectados.
La solución permite comunicación en tiempo real y visualización dinámica desde el navegador

## Estructura del proyecto
EXAMEN/  
├── angular-app/  # Código fuente Angular  
├── apache/  
│   └── 000-default.conf  # Configuración Apache  
├── backend/  
│   ├── server.js  # Servidor WebSocket Node.js  
│   ├── package.json  # Dependencias backend  
│   └── Dockerfile  # Dockerfile backend  
├── Dockerfile  # Dockerfile frontend (Angular + Apache)  
├── docker-compose.yml  # Orquestación de servicios  
└── README.md  # Este archivo  

## Requisitos previos
- Docker Desktop instalado y corriendo.  
- Node.js y Angular CLI instalados localmente para compilar Angular.  
- Cuenta en Docker Hub para publicar imágenes.  

## Pasos para compilar y ejecutar

1. Compilar Angular  
Desde la carpeta angular-app/:  
```bash
npm install
ng build --configuration production

2. Luego para levantar el programa usamos 
docker-compose up --build

y el programa estaria listo 
