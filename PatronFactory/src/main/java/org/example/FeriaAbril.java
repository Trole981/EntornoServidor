package org.example;

public class FeriaAbril implements ElementoAndaluz{
    @Override
    public String describir(String mensaje) {
        return "|" + mensaje;
    }
}
