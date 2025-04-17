package com.rust.simulation;

import java.util.Scanner;

public class Menu implements Runnable {

    Thread menuThread;
    Simulation simulation;
    private String title =
            "**************\n" +
                    "* SIMULATION *\n" +
                    "**************\n" +
                    "Добро пожалоать в СИМУЛЯЦИЮ, для остановки нажмите любую клавишу и ENTER.\n" +
                    "Хотите начать симуляцию? Д/Н";
    private String errorMessage = "Ошибка ввода";

    public Menu(Simulation simulation) {
        menuThread = new Thread(this, "Menu");
        this.simulation = simulation;
    }

    public boolean starting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);

        while (true) {
            String input = scanner.nextLine();
            if (input.matches("[дД, lL]")) {
                menuThread.start();
                return true;
            } else if (input.matches("[нН, yY]")) {
                System.out.println("Приложение завершено!");
                return false;
            } else {
                System.out.println(errorMessage);
            }
        }
    }

    private synchronized void pause() {
        Scanner scanner = new Scanner(System.in).useDelimiter("");
        boolean status = true;

        while (true) {
            if (scanner.hasNext()) {
                if (status) {
                    simulation.pauseSimulation();
                    System.out.println("Для продолжения нажмите любую клавишу и ENTER.\n");
                    status = !status;
                    scanner.nextLine();
                } else {
                    simulation.resumeSimulation();
                    System.out.println("Запуск симуляции");
                    status = !status;
                    scanner.nextLine();
                }
            }
        }
    }

    public void run() {
        System.out.println("Steam is run");
        pause();
    }
}
