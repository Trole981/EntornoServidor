package org.example;

public class Gazpacho implements ElementoAndaluz{
    @Override
    public String describir(String mensaje) {
        return "#" + mensaje;
    }
}
