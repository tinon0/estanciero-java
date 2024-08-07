# Estanciero esquema
***
## tablero
- - Celdas[] grilla; 
- - String[] nombreCasilleros; 
- - int dificultad;
- + construirTablero()

> esto manda un mensaje a la fabrica de celdas que construye todas las celdas y luego las agrega a grilla

- + void moverJugador() 

> mueve al jugador a la celda indicada por el numero que tira dados y activa el metodo entroJugador() de la celda

- + void empezar()

> inicializa todos los componentes necesarios para empezar el juego

- + guardar() 

> guarda la condición actual del juego

- + cargar() 

> carga la condición de un juego anterior


**responsabilidad**: mover los jugadores a la siguiente celda correspondiente, indicar la posición de cada jugador. inicializar el juego creando todas las Casillas
## celda - Clase abstracta
- - string nombre;
- - string tipo;
- - int numero;
- +entroJugador() 

> este método sera sobrescrito por las clases hijas para producir el efecto deseado, y implica la accion que hace cada celda al caer un jugador en ella

**responsabilidad**: una clase padre que permita la herencia de sus atributos y métodos
### propiedad Hereda de: celda
- - int chacras ;
- - int estancia ;
- - int valor;
- - int ValorHipotecario;
- - string provincia;
- - string jugadorDueño;
- - bool estaOcupada;
- + cuantoVale() 

> este metodo calcula el valor de la propiedad, si tiene mejoras, y es usado en pagas()

- + pagas()

> resta el dinero del jugador o bot acorde, y depende si la provicia tiene dueño o no

**Responsabilidad**: controlar la cantidad de chacras y estancias, ver quien la compro, y entregarle dinero cuando alguien que no sea el dueño caiga ahi, calcular la renta
#### ferrocarril Hereda de: Celda
- - int valor;
- - string jugadorDueño;

**Responsabilidad**: las mismas que la propiedad pero sin mejoras
#### compania Hereda de: Celda
- - string jugadorDueño;
- - int valor
**Responsabilidad**: las mismas que la propiedad pero sin mejoras
#### celdaEspecial Hereda de: Celda
- +entroJugador()

> este metodo tiene que ser sobreescribido porque hay diferentes respuestas dependiendo del numero de la celda

- + pagar()

> retira dinero del jugador que cae aqui

- + premio()

> el dinero del jugador que cae es incrementado

- + descanso?()

> pregunta al jugador si quiere descansar y por cuanto tiempo

- + vayaPreso()

> manda al jugador a la comisaria

**Responsabilidad**: manejar todos los otros efectos de las celdas que no pertenecen a las otras categorias
#### celdaSuerte Hereda de: Celda
- + void entroJugador()

> llama al metodo de baraja para sacar la siguente carta y efectuar el efecto espesificado

**Responsabilidad**: aplicar el efecto de la carta sacada al jugador y mostrar el mensaje
#### celdaDestino Hereda de: Celda
- + void entroJugador()

> llama al metodo de baraja para sacar la siguiente tarjeta y efectuar el efecto espesificado

**Responsabilidad**: aplicar el efecto de la carta sacada al jugador y mostrar el mensaje
## dados
- - int resultado1
- - int resultado2
- + int random()

> el metodo coloca 1d6 en cada resultado y los suma para enviar al turnero, emplea los metodos esDoble y esTriple para controlar si requiere un extra turno o enviarlo a la carcel

- + bool esDouble()

> revisa si los resultados son iguales y manda un mensaje al turnero para asignar un turno extra 

- + bool esTriple()

> revisa si los resultados son iguales una tercera ves y envia un mensaje al tablero para mover al jugador a la comisaria

**Responsabilidad**: genera los números random para pasarle al tablero un numero del 2-12. y indicar si es doble y si es triple, y aplicar efectos acordes
## Jugador - Clase abstracta
- - string nombre
- - string tipo
- - int dinero
- - propiedades[] propiedadesAdquiridas
- - int numeroFerrocarriles
- - int numeroCompanias
- - int posición
- - boolean salvarDeCarcel; `si el jugador tiene la carta sali de la carcel true, else false`
- + mover()

> Usa el método random() de dados para calcular el siguiente movimiento.

- + comprar()

> Permite comprar la propiedad en la que se para si está disponible.

- + hipotecar()

> Da dinero a cambio de la hipotecación de una propiedad.

- + venderPropiedad()

> Permite entregar una propiedad e incrementar el dinero.

**Responsabilidad**: Controlar que todas las funcionalidades de un jugador sean aplicables en el juego.

### Usuario | Hereda de Jugador
- - Perfil perfil
**Responsabilidad**: Usar todos los métodos heredados de jugador para jugar el juego y mantener el registro del perfil del usuario.
### bot/ interface *
- + void comportamiento()

> todos los bots se comportaran acorde a lo definido aca, por lo que es vital que todos poseean este metodo

**Responsabilidad**: asegurar el polimorfismo de todos los tipos de bot
#### bot - equilibrado |Hereda de:Jugador|Implementa: bot
- - string perfil
- - array provinciasPreferidas
- - int pesoPreferencia
- + void comportamiento()
 
> este metodo sera compuesto por varios metodos pequeños para mantener simplicidad del codigo

**Responsabilidad**: simular, el comportamiento de un jugador equilibrado 
#### bot - agresivo |Hereda de:Jugador|Implementa: bot
- - int pesoPreferencia
- - array provinciasPreferidas
- - string perfil
- + void comportamiento()

> este metodo sera compuesto por varios metodos pequeños para mantener simplicidad del codigo

**Responsabilidad**: simular, el comportamiento de un jugador  agresivo
#### bot - conservador |Hereda de:Jugador|Implementa: bot
- - string perfil
- - array provinciasPreferidas
- - int pesoPreferencia
- + void comportamiento()

> este metodo sera compuesto por varios metodos pequeños para mantener simplicidad del codigo

**Responsabilidad**: simular, el comportamiento de un jugador  conservador
## banco
+ + void daPlata()

> entrega dinero a un jugador 

+ + void transaccionPropiedad()

> realiza la compra de la propiedad por parte de un jugador

**Responsabilidad**: proporcionar la entrega de propiedades y la entrega de dinero en ciertas celdas
## Mazo
- -Tarjetas[] 
- - string tipo
- - int siguenteTarjeta
- + mesclar()

> re acomoda el orden de las tarjetas en tarjetas[]

- + sacarTarjeta()

> elije la siguente targeta del array y  apunta a la siguente para sacar, una vez se llegue a la ultima vuelve a recorrer el array, tambien ejecuta su efecto

**Responsabilidad**: contener todas las cartas de acuerdo al tipo de baraja que es
## tarjetas /interface
- +efecto()

> metodo universal de las tarjetas

**Responsabilidad**: determinar
### tarjetaDestino | Implementa: tarjeta
- - string mensaje
- + efecto()

> envia el mensaje al jugador y activa el effecto de la carta

**Responsabilidad**:  mandar el efecto a la celda destino con el mensaje para el jugador
### tarjetaSuerte | Implementa: tarjeta
- -string mensaje
- +efecto()

> envia el mensaje al jugador y activa el effecto de la carta

**Responsabilidad**:  mandar el efecto a la celda suerte con el mensaje para el jugador
## turnero
- - int numero
- - string proximoJugador;
- - string jugadorActual
- + siguienteTurno()

> mueve al jugador en proximo jugador a jugador actual y efectual el control de dinero

- + controlarDinero()

> revisa el dinero de todos los jugadore para ver si alguno gano

**Responsabilidad**:  controlar el ritmo de la partida, y revisar quien gana
***
#### fabrica de celdas // patron de diseño que identificamos
#### fabrica de cartas // patron identificado

![DER](https://files.catbox.moe/beagu9.png)
[DER link to source](https://miro.com/app/board/uXjVKU1DnNg=/?share_link_id=945089769597)
