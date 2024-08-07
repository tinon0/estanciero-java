---
tags:
---
# User-Experience
---
## Menu de navegación
***
### Antes del Juego
- menu de perfiles (nuevo nombre o perfiles usados)
- menu de cargar partidas
- nueva partida, menu de configuración (elige dificultad, elige ficha, condición de victoria (cantidad de dinero para ganar))
### Durante el Juego
- menu de acciones en el juego (vender, comprar, compra chacras o estancias, tirar los dados, examinar lo que los bots compraron)
### Explicación
Los menus están orientados a darle interactividad al usuario, ya sea durante el juego o antes de jugar
## Acciones
***
### Antes del Juego
- guardar partida 
- cargar partida 
- crear partida 
- eliminar partida 
- salir sin guardar 
- crear perfil 
- eliminar perfil 
- seleccionar perfil 
### Durante el juego
- tirar los dados para mover
- comprar propiedad, ferrocarril, compañía 
- vender propiedad, ferrocarril, compañía (banco o bot)
- compra de chacras o estancias  
- si cae en casilla descanso puede esperar hasta 2 turnos 
- examinar las compras del los bots
### Explicación
Las acciones representan las decisiones del usuario adentro y afuera del juego. Dada las condiciones del turno actual cuando es durante el juego
## Eventos
***
- Sacar carta destino
- Sacar carta suerte
- Caer en una propiedad no comprada (para comprar o no)
- Caer en una propiedad de otro jugador y pagar alquiler
- Pasar por la casilla de salida y cobrar dinero
- Caer en una casilla de impuestos a la ganancia 
- Caer en casilla descanso
- Caer en casilla comisaria o marche preso
- sacar doble 3 veces
### Explicación
explica lo que sucede después de que el jugador tira los dados para continuar el turno y las consecuencias que recibe 
## Presentaciones
***
### Durante el Juego
- Representación visual del tablero en consola y las fichas de los jugadores
- estado de juego, muestra: dinero (jugador), propiedades (jugador), turnos actuales
- mensaje de propiedades compradas por los bots
- pregunta de cuantos turnos esperar en la casilla descansó (hasta 2)
- mensaje de te quedaste sin plata, para vender propiedades
### Fuera del juego
- mensaje de estadísticas del perfil (cuantas quedo en bancarrota y cuantas gano)
- mensaje de YOU WIN!!!
- mensaje de GAME OVER
### Explicación
son las mensajes que proveen información al usuario de lo que esta sucediendo en el juego y fuera de el.