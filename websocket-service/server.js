const WebSocket = require('ws');

const wss = new WebSocket.Server({ port: 8765 });

console.log('Servidor WebSocket iniciado en puerto 8765');

wss.on('connection', function connection(ws) {
  console.log('Cliente conectado');

  const sendMessages = setInterval(() => {
    const msg = `Mensaje dinámico: ${new Date().toLocaleTimeString()} - Número: ${Math.floor(Math.random() * 100)}`;
    ws.send(msg);
  }, 3000);

  ws.on('close', () => {
    console.log('Cliente desconectado');
    clearInterval(sendMessages);
  });
});
