package com.rust.simulation;

import java.util.Scanner;

public class Menu {

    private String title =
                        "**************\n" +
                        "* SIMULATION *\n" +
                        "**************\n" +
                        "Если хотите начать симуляцию? Д/Н";
    private String errorMessage = "Ошибка ввода";

    public boolean start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);

        while (true) {
            String input = scanner.nextLine();
            if (input.matches("[дД]")) {
                return true;
            } else if (input.matches("[нН]")) {
                System.out.println("Приложение завершено!");
                return false;
            } else {
                System.out.println(errorMessage);
            }
        }
    }
}
