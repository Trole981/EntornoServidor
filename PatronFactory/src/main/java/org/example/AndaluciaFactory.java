package org.example;

public class AndaluciaFactory extends ElementoAndaluzFactory {
    @Override
    public ElementoAndaluz createElementoAndaluz(String objeto) {
        if(objeto.startsWith("#")){
            return new Gazpacho();
        }
        if (objeto.startsWith("*")){
            return new Flamenco();
        }else{
            return new FeriaAbril();
        }
    }
}
