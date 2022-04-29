# Questions

1. ¿Qué diferencia hay entre agregar al path del systema y al path del usuario?

Principlamente es para no afectar a los otros usuarios del sistema operativo.


2. ¿Las secuencia de Kotlin, no se ejecutan hasta que uno le diga que se ejecute? Es decir, es como una especie de: guardar para después.

3. En el códiggo de ejmplo, no me queda claro que hace el _it_ solo al final. 

```kotlin
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        // executes some code here
        it   // <--- Este, tiene un return implicito?
    }
```
