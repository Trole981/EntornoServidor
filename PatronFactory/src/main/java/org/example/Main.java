package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        AndaluciaFactory Andalucia=new AndaluciaFactory();

        Gazpacho QueRico= (Gazpacho) Andalucia.createElementoAndaluz("#Gaz1");
        System.out.println(QueRico.describir("Que Rico Estoy"));

        Flamenco baile= (Flamenco) Andalucia.createElementoAndaluz("*Fla1");
        System.out.println(baile.describir("Ira que arte"));

        Flamenco baile2= (Flamenco) Andalucia.createElementoAndaluz("*Fla3");
        System.out.println(baile2.describir("No"));
    }
}
