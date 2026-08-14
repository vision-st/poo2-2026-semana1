package cl.validacionpasajes;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. Versión tradicional con condicionales ===");
        ValidadorTradicional tradicional = new ValidadorTradicional();
        tradicional.validarSegunTipo("estudiante");
        tradicional.validarSegunTipo("adulto");
        tradicional.validarSegunTipo("terceraEdad");

        System.out.println("\n=== 2. Polimorfismo por sobrescritura ===");
        Usuario[] usuarios = {
            new Estudiante(),
            new Adulto(),
            new TerceraEdad()
        };

        for (Usuario usuario : usuarios) {
            usuario.validarPasaje();
        }

        System.out.println("\n=== 3. Sobrecarga de métodos ===");
        Validador validador = new Validador();
        validador.validarPasaje();
        validador.validarPasaje("Estudiante");
        validador.validarPasaje("Tercera Edad", 65);
        validador.validarPasaje("Adulto", 35);
    }
}
