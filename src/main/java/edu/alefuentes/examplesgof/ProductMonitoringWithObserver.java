package edu.alefuentes.examplesgof;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface Observer
interface Observer {
    void update(String productName);
}

// Classe concreta Observer
class UserMonitor implements Observer {
    private String name;

    public UserMonitor(String name) {
        this.name = name;
    }

    @Override
    public void update(String productName) {
        System.out.println("Notificacao recebida: Novo produto adicionado - " + productName);
    }
}

// Interface Observable
interface CatalogObservable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String productName);
}

// Classe concreta Observable
class Catalog implements CatalogObservable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }


    @Override
    public void notifyObservers(String productName) {
        // TODO: Implementar lógica para notificar apenas os usuários que desejam ser notificados
        for (Observer observer : observers){
            observer.update(productName);
        }
    }

    public void addProduct(String name, String description, double price) {
        notifyObservers(name);
    }
}

public class ProductMonitoringWithObserver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando catálogo e usuário
        Catalog catalog = new Catalog();
        UserMonitor UserMonitor = new UserMonitor("Usuário 1");

        // Inscricao do usuário no catálogo
        catalog.addObserver(UserMonitor);

        // Adicionando novo produto
        String name = scanner.nextLine();
        String description = scanner.nextLine();
        double price = scanner.nextDouble();

        scanner.nextLine(); // Consumir a quebra de linha após nextDouble
        String subscribeChoice = scanner.nextLine();

        // TODO: Verifique qual foi a escolha de notificação (S ou N) do usuário
        if(subscribeChoice.equalsIgnoreCase("N")){
            catalog.removeObserver(UserMonitor);
            System.out.println("Programa Encerrado.");
        }

        // Adicionando produto ao catálogo
        catalog.addProduct(name, description, price);
    }
}

