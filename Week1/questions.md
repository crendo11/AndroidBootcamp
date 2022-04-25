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
