package cl.validacionpasajes;

public class ValidadorTradicional {
    public void validarSegunTipo(String tipoUsuario) {
        if ("estudiante".equalsIgnoreCase(tipoUsuario)) {
            System.out.println("Tarifa estudiante aplicada.");
        } else if ("adulto".equalsIgnoreCase(tipoUsuario)) {
            System.out.println("Tarifa adulto aplicada.");
        } else if ("terceraEdad".equalsIgnoreCase(tipoUsuario)) {
            System.out.println("Tarifa tercera edad aplicada.");
        } else {
            System.out.println("Tipo de usuario no reconocido.");
        }
    }
}
