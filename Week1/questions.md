# Programación Funcional

1. Se quiere resolver el problema de cuántos número mayor que 10 hay en el areglo. Una solución es utilizar ciclos y condicionales para hacerlo. Esto no es progrmación funcional.

```java
//Declarativo.
List<Integer> numeros = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);

int contador = 0;
for(int numero : numeros) {
    if(numero > 10) {
        contador ++;
    }
}
System.out.println(contador);
```

Pero si yo declaro una función que tenga el loop internamente y luego la llamo en el código principal ¿Entonces ahí si estaría programando funcionalmente? 

```java
public static long countGreaterThanTen(int [] Array) {
      int contador = 0;
      for (int numero : Array){
           if (numero > 10){
               contador++:
          }
     }
     return contador;
}

int result = countGreaterThanTen(numeros);
```


# Ejercicio de programación orientada a objetos

Haga el cálculo de una factura que permite en ciertos momentos aplicar un descuento

## Carácterísticas principales de la Programación Funcional

### Funciones puras: 
- No tiene efectos secundarios
- Solo depende de las entradas $f(x)$.
- No existe el concepto de variable global

### Aplicación parcial:
- Es posible invocar una función sin todos sur agumentos.

### Orden superior:
- Es posible pasarle una función a otra función $f(g(x))$

```kotlin
fun doble(x) {
    return x + x
}

fun triple(x){
    return x + x + x
}

fun main(){
    var result = triple(doble(2))
    // 12
}
```

### Recursividad:

- Se evitan los bucles y usa la recursividad

### Inferencia de tipos:
- Los típitos no son necesariamente estrictos.

### Pereza:
- Una expresión solo se evalúa sólo si es estrictamente necesario. Es decir, si una función siempre devuelve el mismo valor, no se ejecutan los argumentos.

```kotlin
fun doble(x) {
    return x + x
}

fun constantFun(x){
    // do something with x ...
    return 32
}

fun main(){
    var result = constantFun(doble(2))
    // reult: 32
}
```

En este caso, la función que se pasó como argumento a _constFun()_  no se ejecuta.



# Programación Orientada a objetos:

Conceptos y principios

## Clases

Es la abstracción de un objeto, contiene la informacion de sus atributos y métodos

Un ejemplo en la vida real puede ser la clase persona, tiene características y también comportamientos que son comunes a todas las personas.

## Objeto

Es una instancia de una clase. Es la clase materializada.



## Principios de POO:

### SOLID

- Single Responsability Principle: Una clase debería cumplir un único propósito.

- Open Closed Principle: Una clase puede extenderse sin modificarla.

- Liskov Substitution Principle: 

### DRY: Don't Repeat Yourself


