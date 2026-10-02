package org.example;

public class Flamenco implements ElementoAndaluz{
    @Override
    public String describir(String mensaje) {
        return "*" + mensaje;
    }
}
