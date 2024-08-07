# Interfaces
***
## Celda
### Método:
- entroJugador()
> Este método permite generar un evento en el juego que, dependiendo de la celda que sea (propiedad, suerte, destino, etc.), genera el efecto adecuado (sacar carta, menú de comprar propiedades, etc.). Este método será disparado por el tablero cuando un jugador se mueva.
### Abstracción:
La celda representa cada casilla en el tablero, con cada característica que tiene. Todas, excepto una, tienen un comportamiento cuando el jugador cae en esa posición del tablero. Esta interfaz hace esencial que ese comportamiento esté definido en todas las celdas.
***
## Jugador
### Métodos:
- mover()
> El evento que utiliza los objetos Dados para mover al usuario en el tablero.
- comprar()
> Si el usuario cae en una celda propiedad que puede ser comprada, usando este método se realiza la transacción.
- hipotecar()
> Este método aumenta el atributo de dinero cuando se hipoteca algo al banco.
- venderPropiedades()
> Permite aumentar el atributo de dinero cuando se vende una propiedad al banco o al bot en caso del usuario.
- mejorar()
> Este método permite mejorar la propiedad con la compra de chacras o estancias.
### Abstracción:
Hay diferentes tipos de jugadores, player bots (y dentro de estos están los tres tipos de bot), pero todos ellos usan unos métodos básicos para jugar el juego en sus turnos.
***
## Bot
### Métodos:
- comportamiento()
> Cada bot, dependiendo de su tipo, tiene diferentes hábitos de juego, y será definido en la clase que implemente esta interfaz. Contiene todos los otros métodos dentro de este para evitar sobrecargar este método.
- esPreferida()
> Devuelve un booleano que determina si la casilla actual es una de las provincias preferidas del bot y si está para comprar.
- puedoMejorar()
> Devuelve un booleano que determina si las condiciones se cumplen para mejorar sus propiedades en este turno.
- mejorarPropiedad()
> Ayuda a determinar cuál propiedad de las que posee mejorar y ejecuta mejorar, mientras puede mejorar() devuelva true.
- comprarIgual()
> Define y ejecuta comprar usando el númeroChance de atributos de los bot para determinar con un método Math.random() si compra igual a pesar de no ser una provincia preferida.
### Abstracción:
Hay distintos tipos de bots (agresivos, conservadores y equilibrados) y cada uno de ellos emplea una estrategia diferente, pero todos en sí, son bots y esas estrategias tienen pasos en común. Esta interfaz remarca estos comportamientos.
***
## Tarjeta
### Métodos:
- efecto()
> Dependiendo del tipo de tarjeta sacada, ejecuta distintos eventos: dar dinero, sacar dinero, moverse, ir a la cárcel y salir de la cárcel.
### Abstracción:
La entidad tarjeta es similar sin importar si es destino o suerte. Pero todas ellas tienen un efecto que puede ser dar dinero, sacar dinero, moverse, ir a la cárcel y salir de la cárcel.
