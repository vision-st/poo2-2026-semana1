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

## Presentación de la clase

El deck completo está en [`docs/index.html`](docs/index.html) (se puede abrir en el navegador y exportar a PDF con el botón superior). A continuación, el contenido de cada pantalla.

### 1 / 15 — Semana 1: Polimorfismo sin humo

Desarrollo Orientado a Objetos II. Cómo pasar de "esto funciona con if/else" a "esto tiene una estructura decente".

Temas: polimorfismo, sobrescritura, sobrecarga.

**Idea central:** un mismo mensaje puede producir comportamientos distintos según el objeto que lo reciba. Mismo método, distintas respuestas.

Clase sugerida: 2 horas.

### 2 / 15 — ¿Qué deberían llevarse hoy?

- **Comprender:** qué problema resuelve el polimorfismo en diseño orientado a objetos.
- **Distinguir:** la diferencia entre sobrescritura y sobrecarga.
- **Aplicar:** leer y modificar un ejemplo simple en Java usando una jerarquía de clases.
- **Relacionar:** entender por qué esto ayuda a evitar código rígido, repetitivo y frágil.

### 3 / 15 — La versión fea pero tristemente común

Supongamos que debemos validar pasajes para distintos tipos de usuario:

```java
public void validarPasaje(String tipoUsuario) {
    if (tipoUsuario.equals("estudiante")) {
        System.out.println("Tarifa estudiante aplicada.");
    } else if (tipoUsuario.equals("adulto")) {
        System.out.println("Tarifa adulto aplicada.");
    } else if (tipoUsuario.equals("terceraEdad")) {
        System.out.println("Tarifa tercera edad aplicada.");
    } else {
        System.out.println("Tipo desconocido.");
    }
}
```

- **¿Funciona?** Sí. Compila, corre y probablemente alguien diría "listo, siguiente".
- **¿Qué huele mal?** Cada nuevo tipo obliga a tocar la misma lógica. Eso escala pésimo y rompe fácil.

### 4 / 15 — ¿Qué es el polimorfismo?

- **Definición aterrizada:** es la capacidad de tratar distintos objetos bajo un mismo tipo general y permitir que respondan de manera distinta al mismo mensaje.
- **En simple:** tenemos una referencia común, pero el comportamiento real depende del objeto concreto.

**Ejemplo mental:** si varios objetos entienden `validarPasaje()`, no necesito preguntarle a cada uno qué es. Solo le digo "haz tu trabajo". Cada uno responde como corresponde.

### 5 / 15 — Sobrescritura vs sobrecarga

| Concepto | Dónde ocurre | Qué cambia | Cuándo se resuelve |
| --- | --- | --- | --- |
| **Sobrescritura** | Entre clase base y subclases | La implementación | En tiempo de ejecución |
| **Sobrecarga** | En la misma clase | La lista de parámetros | En compilación |

- **Sobrescritura:** herencia obligatoria.
- **Sobrecarga:** mismo nombre, distintas firmas.
- **Error clásico:** creer que ambas son lo mismo.

### 6 / 15 — Modelo simple del ejemplo

```text
Usuario
├── Estudiante
├── Adulto
└── TerceraEdad
```

- **Clase base:** `Usuario` declara un comportamiento general, `validarPasaje()`.
- **Subclases:** cada una redefine el método para aplicar su propia lógica de validación.

### 7 / 15 — Clase base y sobrescritura

```java
public class Usuario {
    public void validarPasaje() {
        System.out.println("Validación general de pasaje.");
    }
}

public class Estudiante extends Usuario {
    @Override
    public void validarPasaje() {
        System.out.println("Tarifa estudiante aplicada.");
    }
}
```

**`@Override` importa.** No es decoración. Le dice al compilador: "estoy sobrescribiendo un método heredado". Si te equivocas en la firma, te avisa.

### 8 / 15 — Polimorfismo en ejecución

```java
Usuario[] usuarios = {
    new Estudiante(),
    new Adulto(),
    new TerceraEdad()
};

for (Usuario u : usuarios) {
    u.validarPasaje();
}
```

- **Lo importante:** la variable es de tipo `Usuario`, pero el método ejecutado depende del objeto real.
- **Resultado:** el mismo mensaje produce respuestas distintas. Ahí está el polimorfismo en tiempo de ejecución.

### 9 / 15 — Sobrecarga de métodos

```java
public class Validador {
    public void validarPasaje() { ... }

    public void validarPasaje(String tipoUsuario) { ... }

    public void validarPasaje(String tipoUsuario, int edad) { ... }
}
```

- **Mismo nombre:** todos se llaman igual.
- **Firmas distintas:** cambian los parámetros.
- **Compilación:** el compilador decide qué versión usar.

### 10 / 15 — ¿Cuándo usar cada cosa?

**Usa sobrescritura cuando...**
- tienes herencia,
- quieres especializar comportamiento,
- cada subclase debe responder distinto.

**Usa sobrecarga cuando...**
- la acción es conceptualmente la misma,
- necesitas distintas entradas,
- quieres flexibilidad sin cambiar intención.

**Ojo:** sobrecargar por sobrecargar es mala idea. Si las firmas son demasiado parecidas, confundes al compilador y al ser humano.

### 11 / 15 — Lo que sí y lo que no

**Sí**
- Usar `@Override`.
- Elegir nombres claros.
- Diseñar clases con responsabilidad concreta.

**Cuidado**
- Meter lógica gigante en una clase base.
- Abusar de sobrecargas confusas.
- Forzar herencia cuando no aporta.

**No gracias**
- Jerarquías absurdas.
- Condicionales eternos donde debería haber objetos.
- Código que "funciona" pero nadie quiere mantener.

### 12 / 15 — Preguntas para mover el curso

1. Si agregamos `UsuarioVIP`, ¿qué parte del diseño resiste mejor el cambio?
2. ¿Qué se ejecuta aquí: `Usuario u = new Adulto(); u.validarPasaje();`?
3. Si agrego `validarPasaje(boolean convenio)`, ¿es sobrecarga o sobrescritura?
4. ¿Qué diseño prefieren para crecer: muchos `if/else` o una jerarquía con comportamiento distribuido?

**Meta de esta parte:** que expliquen con palabras lo que el código está haciendo.

### 13 / 15 — Antes y después

- **Antes:** un método central lleno de condicionales según tipo de usuario. Más acoplamiento, menos extensibilidad, más dolor futuro.
- **Después:** una clase base + subclases + comportamiento polimórfico. Más orden, mejor separación de responsabilidades, cambios más seguros.

> La idea no es usar polimorfismo porque suena bonito. La idea es usarlo cuando evita rigidez.

### 14 / 15 — Qué deben recordar sí o sí

- **Polimorfismo:** un mismo mensaje, distintas respuestas.
- **Sobrescritura:** redefine comportamiento heredado.
- **Sobrecarga:** reutiliza un nombre con distintas firmas.
- Estos conceptos permiten construir código más flexible y mantenible.

**Pregunta final:** si mañana agrego un nuevo tipo de usuario, ¿mi diseño me obliga a reescribir lógica central o solo a crear una nueva clase?

### 15 / 15 — Materiales de apoyo para esta clase

- **Proyecto Java:** incluye jerarquía de usuarios, polimorfismo en ejecución, sobrecarga y una versión tradicional para refactorizar.
- **Guion docente:** orden de la clase, tiempos sugeridos, preguntas detonantes y puntos donde conviene correr código.
- **PDF imprimible:** este mismo material se puede guardar como PDF usando el botón superior del deck.
- **Enfoque:** presentación breve, clara y orientada a comprender el problema, la estructura y la aplicación práctica del concepto.

## Uso didáctico sugerido

1. Mostrar primero `ValidadorTradicional.java`.
2. Preguntar por qué esa solución se vuelve rígida al crecer.
3. Mostrar luego `Usuario` y sus subclases.
4. Ejecutar `Main` y observar el comportamiento polimórfico.
5. Cerrar con `Validador.java` para introducir sobrecarga.
