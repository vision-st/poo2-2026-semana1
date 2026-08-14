package cl.validacionpasajes;

public class Validador {
    public void validarPasaje() {
        System.out.println("Validación estándar sin datos.");
    }

    public void validarPasaje(String tipoUsuario) {
        System.out.println("Validación para tipo: " + tipoUsuario);
    }

    public void validarPasaje(String tipoUsuario, int edad) {
        if ("Tercera Edad".equalsIgnoreCase(tipoUsuario) && edad >= 60) {
            System.out.println("Descuento aplicado por edad avanzada.");
        } else {
            System.out.println("Validación para " + tipoUsuario + ", edad: " + edad);
        }
    }
}
