package edu.alefuentes.examplesgof;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//class User {
//    private final int id;
//    private final String name;
//
//    public User(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//}


record User(int id, String name){}

class UserManager {

    //private List<User> userDB;

    private static class instanceHolder {
        public static UserManager instance = new UserManager();
    }

    private UserManager() {
        super();
        //userDB = new ArrayList<>();
    }

    public static UserManager getInstance() {
        return instanceHolder.instance;
    }

    //public void addUser(String name){
    public void addUser(String name, List<User> userDB){
        int userId = userDB.size() + 1;
        User user = new User(userId, name);
        userDB.add(user);
    }

    //public void listUsers(){
    public void listUsers(List<User> userDB){
        System.out.println("size -> " + userDB.size());
        for(User user : userDB){
            //System.out.println(String.format("%d - %s", user.getId(), user.getName()));
            System.out.println(String.format("%d - %s", user.id(), user.name()));
        }
    }

}

public class UserAdministratorWithSingleton {

    private static final List<User> users = new ArrayList<>();
    // TODO: Implementar o padrão Singleton para garantir que haja apenas uma instância do gerenciador de usuários
    private UserManager userMg = UserManager.getInstance();

    public void addUser(String name) {
        // TODO: "Implementar a lógica de adicionar um novo usuário na lista mutável $users."
        userMg.addUser(name, users);

    }

    public void listUsers() {
        //TODO: "Implementar a impressão dos $users, seguindo o padrão definido no enunciado."
        userMg.listUsers(users);
    }

    public static void main(String[] args) {

        UserAdministratorWithSingleton userAdmin = new UserAdministratorWithSingleton();
        Scanner scanner = new Scanner(System.in);

        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após a leitura do número

        for (int i = 1; i <= quantity; i++) {
            String name = scanner.nextLine();
            userAdmin.addUser(name);
        }

        userAdmin.listUsers();
    }
}
