# Singleton

- **Dice**
> Los set de dados tiene que ser único, no se puede crear mas de un objeto dado por juego, porque el dado guarda los resultados en su objeto, mas de dos instancias de dados y los diferentes objetos que usan los dados no sabrán con que resultado quedarse. haciendo la clase un singleton, cada vez que se pidan los resultados de un rol, siempre podemos estar seguros que es el resultado correcto

***
# Template method

- **Bot (y todos sus descendientes)**
> los bots tienen muchos métodos similares (como isPreferred()), mas los heredados de la clase jugador, pero en particular los métodos de Bot, varios pueden ser definidos en una clase abstracta y luego las particularidades desarrollarlas en sus clases hijas. esto es para evitar la duplicación de código innecesaria

***
# Abstract Factory

- **Tarjetas**
> las tarjetas tiene diferentes efectos similares (como pagar, cobrar, moverse etc). para no tener que codear una por una el tipo de efecto, podemos usar una fabrica de tarjetas para pagar, para cobrar, etc. cosa que solo pasando los datos de la base de datos el Código automáticamente ve como construir todas esas cartas basadas en el tipo de efecto y el tipo de carta que es (suerte y destino)

***
# Iterator

- **Turnero**
> dado la necesidad e iterar infinitamente hasta que el juego termine, el turnero necesita un método para recorrer una lista indefinidamente, este método es el Iterator, que itera una lista de jugadores para que el juego siga en marcha

***
# Factory method
- **Celdas**
> igual que las tarjetas necesitamos una fabrica para crear todas las celdas que se necesitan para jugar, pasándole los datos de la base de datos. pero a diferencia de las tarjetas no hay necesidad de crear cada una por un tipo que haría que se comporten muy diferentes. por eso el uso del factory method es mas apropiado
