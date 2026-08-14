# Diagrama de clases - validacionpasajes

```mermaid
classDiagram
    class Usuario {
        +validarPasaje()
    }

    class Estudiante {
        +validarPasaje()
    }

    class Adulto {
        +validarPasaje()
    }

    class TerceraEdad {
        +validarPasaje()
    }

    class Validador {
        +validarPasaje()
        +validarPasaje(String tipoUsuario)
        +validarPasaje(String tipoUsuario, int edad)
    }

    class ValidadorTradicional {
        +validarSegunTipo(String tipoUsuario)
    }

    class Main {
        +main(String[] args)
    }

    Usuario <|-- Estudiante
    Usuario <|-- Adulto
    Usuario <|-- TerceraEdad

    Main ..> ValidadorTradicional
    Main ..> Validador
    Main ..> Usuario
```

## Descripción

- `Usuario` es la clase base.
- `Estudiante`, `Adulto` y `TerceraEdad` heredan de `Usuario` y sobrescriben `validarPasaje()`.
- `Validador` contiene sobrecarga de métodos para validar pasajes según distintos parámetros.
- `ValidadorTradicional` usa condicionales para decidir la tarifa según el tipo de usuario.
- `Main` prueba ambas estrategias: tradicional y con polimorfismo.
