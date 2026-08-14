package cl.validacionpasajes;

public class Adulto extends Usuario {
    @Override
    public void validarPasaje() {
        System.out.println("Tarifa adulto aplicada.");
    }
}
