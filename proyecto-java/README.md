# SistemaValidacionPasajes

Proyecto Java pequeño para apoyar la clase de la semana 1 de POO2.

## Qué enseña

- polimorfismo
- sobrescritura de métodos
- sobrecarga de métodos
- diferencia entre una solución tradicional con `if/else` y una solución orientada a objetos

## Estructura

```text
src/cl/validacionpasajes/
├── Main.java
├── Usuario.java
├── Estudiante.java
├── Adulto.java
├── TerceraEdad.java
├── Validador.java
└── ValidadorTradicional.java
```

## Cómo ejecutar

### Opción 1: IntelliJ IDEA
1. Abrir la carpeta `proyecto-java`.
2. Marcar `src` como carpeta de código fuente si fuese necesario.
3. Ejecutar `Main.java`.

### Opción 2: Terminal
Desde la carpeta `proyecto-java`:

```bash
mkdir -p out
javac -d out src/cl/validacionpasajes/*.java
java -cp out cl.validacionpasajes.Main
```

## Uso didáctico sugerido

1. Mostrar primero `ValidadorTradicional.java`.
2. Preguntar por qué esa solución se vuelve rígida al crecer.
3. Mostrar luego `Usuario` y sus subclases.
4. Ejecutar `Main` y observar el comportamiento polimórfico.
5. Cerrar con `Validador.java` para introducir sobrecarga.
