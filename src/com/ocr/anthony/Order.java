package com.ocr.anthony;

import java.util.Scanner;

public class Order {
    Scanner sc = new Scanner(System.in);
    /**
     * Display all available menus in the restaurant.
     */
    public void displayAvailableMenu() {
        System.out.println("Choix du menu :  ");
        System.out.println("1 => Poulet");
        System.out.println("2 => Boeuf");
        System.out.println("3 => Végétarien");
        System.out.println("Que souhaitez-vous comme menu ?");

    }
    /**
     * Display a selected menu.
     * @param nbMenu The selected menu.
     */
    public void displaySelectedMenu(int nbMenu) {

        if (nbMenu == 1) {
            System.out.println("Vous avez choisi comme menu : poulet");
        }

        else if (nbMenu == 2) {
            System.out.println("Vous avez choisi comme menu : boeuf");
        }

        else if (nbMenu == 3) {
            System.out.println("Vous avez choisi comme menu : végétarien");
        }

        else {
            System.out.println("Vous n'avez pas choisi de menu parmi les choix proposés");
        }

    }

    /**
     * Run asking process for a menu.
     */

    public void runMenu() {

        this.displayAvailableMenu();
        int nbMenu;

        do {
            nbMenu = sc.nextInt();
            this.displaySelectedMenu(nbMenu);

            switch (nbMenu) {

                case 1:
                    displayAvailableSide(true);
                    int nbSide;

                    do {
                        nbSide = sc.nextInt();
                        displaySelectedSide(nbSide, true);
                    } while (nbSide < 1 || nbSide > 3);

                    displayAvailableDrink();
                    int nbDrink;

                    do {
                        nbDrink = sc.nextInt();
                        displaySelectedDrink(nbDrink);
                    } while (nbDrink < 1 || nbDrink > 3);
                break;

                case 2:
                    displayAvailableSide(true);

                    do {
                        nbSide = sc.nextInt();
                        displaySelectedSide(nbSide, true);
                    } while (nbSide < 1 || nbSide > 3);
                break;

                case 3:
                    displayAvailableSide(false);

                    do {
                        nbSide = sc.nextInt();
                        displaySelectedSide(nbSide, false);
                    } while (nbSide < 1 || nbSide > 2);

                    displayAvailableDrink();

                    do {
                        nbDrink = sc.nextInt();
                        displaySelectedDrink(nbDrink);
                    } while (nbDrink < 1 || nbDrink > 3);
                break;
            }

        } while (nbMenu < 1 || nbMenu > 3);

    }

    /**

     * Display a selected side depending on all sides enable or not.

     * All sides = vegetables, frites and rice

     * No all sides = rice or not

     * @param nbSide The selected Side

     * @param allSidesEnable  enable display for all side or not

     */


    public void displaySelectedSide(int nbSide, boolean allSidesEnable) {
        if (allSidesEnable){
            switch (nbSide){

                case 1 :
                    System.out.println("Vous avez choisi comme accompagnement : légumes frais");
                break;

                case 2 :
                    System.out.println("Vous avez choisi comme accompagnement : frites");
                break;

                case 3 :
                    System.out.println("Vous avez choisi comme accompagnement : riz");
                break;

                default:
                    System.out.println("Vous n'avez pas choisi d'accompagnement parmi les choix proposés");
                break;
            }
        } else {
            switch (nbSide){
                case 1 :
                    System.out.println("Vous avez choisi comme accompagnement : riz");
                break;

                case 2 :
                    System.out.println("Vous avez choisi comme accompagnement : pas de riz");
                break;

                default:
                    System.out.println("Vous n'avez pas choisi d'accompagnement parmi les choix proposés");
                break;
            }
        }
    }

    /**
     *
     * @param nbSide
     */
    public void displaySelectedDrink(int nbSide) {
        switch (nbSide) {
            case 1 :
                System.out.println("Vous avez choisi comme boisson : eau plate");
            break;

            case 2 :
                System.out.println("Vous avez choisi comme boisson : eau gazeuse");
            break;

            case 3 :
                System.out.println("Vous avez choisi comme boisson : soda");
            break;

            default:
                System.out.println("Vous n'avez pas choisi de boisson parmi les choix proposés");
            break;
        }
    }

    /**
     * Display all available sides depending on all sides enable or not.
     * All sides = vegetables, frites and rice
     * No all sides = rice or not
     * @param allSideEnable enable display for all side or not
     */
    public void displayAvailableSide(boolean allSideEnable) {
        System.out.println("Choix accompagnement");

        if (allSideEnable) {
            System.out.println("1 - légumes frais");
            System.out.println("2 - frites");
            System.out.println("3 - riz");
        } else {
            System.out.println("1 - riz");
            System.out.println("2 - pas de riz");
        }
        System.out.println("Que souhaitez-vous comme accompagnement ?");
    }

    /**
     * Display all available drinks in the restaurant
     */
    public void displayAvailableDrink() {
        System.out.println("Choix boisson");
        System.out.println("1 - eau plate");
        System.out.println("2 - eau gazeuse");
        System.out.println("3 - soda");
        System.out.println("Que souhaitez-vous comme boisson ?");
    }

    /**
     * Run asking process for several menus.
     */
    public void runMenus() {
        System.out.println("Combien souhaitez vous commander de menu ?");
        int menuQuantity = sc.nextInt();
        int counter = 0;

        while (counter < menuQuantity) {
            runMenu();
            counter = counter + 1;
        }
    }

    public void askSomething(String category, String[] responses) {

        System.out.println("Choix " + category);
        for (int i = 1; i <= responses.length; i++)
            System.out.println(i + " - " + responses[i - 1]);
        System.out.println("Que souhaitez-vous comme " + category + "?");

        int nbResponse;
        boolean responseIsGood;

        do {
            nbResponse = sc.nextInt();
            responseIsGood = (nbResponse >= 1 && nbResponse <= responses.length);

            if (responseIsGood)
                System.out.println("Vous avez choisi comme " + category + " : " + responses[nbResponse - 1]);

            else {
                boolean isVowel = "aeiouy".contains(Character.toString(category.charAt(0)));

                if (isVowel)
                    System.out.println("Vous n'avez pas choisi d'" + category + " parmi les choix proposés");
                else
                    System.out.println("Vous n'avez pas choisi de " + category + " parmi les choix proposés");
            }
        } while (!responseIsGood);
    }


    public void askMenu() {

        String[] menus = {"poulet", "boeuf", "végétarien"};
        askSomething("menu", menus);
    }

    public void askSide(boolean allSidesEnable) {

        if (allSidesEnable) {
            String[] responsesAllSide = {"légumes frais", "frites", "riz"};
            askSomething("accompagnement", responsesAllSide);
        } else {
            String[] responsesOnlyRice = {"riz", "pas de riz"};
            askSomething("accompagnement", responsesOnlyRice);
        }
    }

    public void askDrink() {

        String[] responsesDrink = {"eau plate", "eau gazeuse", "soda"};
        askSomething("boisson", responsesDrink);

    }


}

