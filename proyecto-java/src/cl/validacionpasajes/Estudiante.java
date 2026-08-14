package cl.validacionpasajes;

public class Estudiante extends Usuario {
    @Override
    public void validarPasaje() {
        System.out.println("Tarifa estudiante aplicada.");
    }
}
