
# Proyecto Docker Compose: Angular + WebSocket (Node.js)

Este proyecto contiene una aplicación distribuida con dos contenedores: un servidor WebSocket en Node.js que envía mensajes automáticamente cada 3 segundos, y una aplicación Angular servida mediante Apache que se conecta al WebSocket y muestra los mensajes en tiempo real. Para ejecutarlo correctamente, debes contar con Node.js, Angular CLI, Docker y Docker Compose. La estructura del proyecto es la siguiente: una carpeta `angular-app/` con el código fuente de Angular, una carpeta `websocket/` con el servidor WebSocket en Node.js, un archivo `docker-compose.yml` en la raíz para orquestar los contenedores, y dos Dockerfiles personalizados para construir las imágenes de Angular y WebSocket.

Para preparar el entorno localmente, primero clona el repositorio con `git clone https://github.com/pablomar23/angular-websocket-proyecto.git` y entra a la carpeta del proyecto con `cd angular-websocket-proyecto`. Luego entra a la carpeta `angular-app` y ejecuta `npm install` para instalar las dependencias de Angular. Después compila la aplicación con `ng build --configuration production`, lo que generará los archivos en `dist/angular-app/browser`. Vuelve a la raíz con `cd ..` y ejecuta `docker-compose up --build` para construir y levantar los contenedores. Una vez iniciado, abre el navegador en `http://localhost:8080` para ver un mensaje de bienvenida y la lista de mensajes en tiempo real provenientes del WebSocket. El servidor WebSocket corre en el puerto `8765` y Angular se conecta mediante `ws://localhost:8765`. Si la conexión se pierde, se reconecta automáticamente.

Para detener la ejecución, presiona `Ctrl + C` en la terminal y luego ejecuta `docker-compose down` para eliminar los contenedores. Si deseas publicar las imágenes en Docker Hub, primero etiqueta tus imágenes con `docker tag examen_inter-angular pablomar23/angular-app:1.0` y `docker tag examen_inter-websocket pablomar23/websocket-service:1.0`. Luego inicia sesión con `docker login` y súbelas con `docker push pablomar23/angular-app:1.0` y `docker push pablomar23/websocket-service:1.0`.

### Cómo usar las imágenes publicadas sin compilar

Si no quieres construir nada y solo quieres ejecutar directamente las imágenes desde Docker Hub, en otra máquina o entorno limpio, simplemente asegúrate de tener Docker y Docker Compose, y luego:

1. Descarga las imágenes con:

```bash
docker pull pablomar23/angular-app:1.0
docker pull pablomar23/websocket-service:1.0
````

2. Crea un archivo `docker-compose.yml` con el siguiente contenido:

```yaml
services:
  websocket:
    image: pablomar23/websocket-service:1.0
    ports:
      - "8765:8765"
  angular:
    image: pablomar23/angular-app:1.0
    ports:
      - "8080:80"
```

3. Ejecuta:

```bash
docker-compose up
```

4. Abre tu navegador en `http://localhost:8080` y ya tendrás todo el sistema funcionando sin necesidad de clonar, instalar o compilar nada.

Este README contiene todo lo necesario para preparar, ejecutar, publicar, desplegar y reutilizar el sistema desde cero o usando imágenes ya listas en Docker Hub.

