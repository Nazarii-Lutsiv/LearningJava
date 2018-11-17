package Lesson6;

import java.util.*;

public class Menu {
    private int typeMenu;

    public int showMainMenu() {
        typeMenu = 1;
        int unsNumb;
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "<===================>\n" +
                        "<1. Regist new User:\n" +
                        "<2. List Users:\n" +
                        "<3. Delete User:\n" +
                        "<4. Add Number:\n" +
                        "<5. Change Number:\n" +
                        "<6. Show all TelBook:\n" +
                        "<0. Exit:\n"
        );
        System.out.print("Put number> ");
        try {
            unsNumb = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("---Wrong input!---");
            unsNumb = 1;
        }
        sc.nextLine();
        System.out.println("<===================>");
        return unsNumb;
    }

    public TreeMap<Users, HashSet<Contact>> registMenu(TreeMap<Users, HashSet<Contact>> registMap) {
        String name;
        String surname;
        String typeN;
        int number;
        Scanner sc = new Scanner(System.in);
        typeMenu = 2;
        System.out.print(
                "<Regist>\n" +
                        "Name> "
        );
        name = sc.nextLine();
        System.out.print("Surmame> ");
        surname = sc.nextLine();
        System.out.print("Type of Number> ");
        typeN = sc.nextLine();
        System.out.print("Number> ");
        number = sc.nextInt();
        sc.nextLine();
        System.out.println("---New User add!---");
        System.out.println("<===================>");
        return Users.addNewUser(registMap, name, surname, typeN, number);
    }

    public void showUsers(TreeMap<Users, HashSet<Contact>> showUserMap) {
        Set<Map.Entry<Users, HashSet<Contact>>> entries = showUserMap.entrySet();
        Iterator<Map.Entry<Users, HashSet<Contact>>> iterator = entries.iterator();

        System.out.println("<List all Users>");
        while (iterator.hasNext()) {
            if (iterator.hasNext())
                System.out.println(iterator.next().getKey());
            else {
                System.out.println("---List is Emty---");
            }
        }
    }

    public TreeMap<Users, HashSet<Contact>> removeUser(TreeMap<Users, HashSet<Contact>> userMap) {
        String name;
        Set<Map.Entry<Users, HashSet<Contact>>> entries = userMap.entrySet();
        Iterator<Map.Entry<Users, HashSet<Contact>>> iterator = entries.iterator();
        Scanner sc = new Scanner(System.in);

        System.out.print(
                "<Remove User>\n" +
                        "Put name/surname of User for remove> "
        );
        name = sc.nextLine();
        do {
            if (iterator.next().getKey().getName().equals(name) || iterator.next().getKey().getSurname().equals(name)) {
                iterator.remove();
                System.out.println("---Remove complete!---");
                break;
            } else {
                System.out.println("---No that User!---");
            }
        }
        while (iterator.hasNext());
//        for (Map.Entry<Users, HashSet<Contact>> usersHashSetEntry : userMap.entrySet()) {
//        }
        return userMap;
    }

    public TreeMap<Users, HashSet<Contact>> addNewContact(TreeMap<Users, HashSet<Contact>> userMap) {
        String name;
        String type;
        int number;
        Set<Map.Entry<Users, HashSet<Contact>>> entries = userMap.entrySet();
        //Iterator<Map.Entry<Users, HashSet<Contact>>> iterator = entries.iterator();
        Scanner sc = new Scanner(System.in);

        System.out.print(
                "<Add Contact>\n" +
                        "Put name/surname to add Cont.> "
        );
        name = sc.nextLine();
        System.out.print("Put type of number> ");
        type = sc.nextLine();
        System.out.print("Put number> ");
        number = sc.nextInt();
        sc.nextLine();
        for (Map.Entry<Users, HashSet<Contact>> usersHashSetEntry : userMap.entrySet()) {
            if (usersHashSetEntry.getKey().getName().equals(name) || usersHashSetEntry.getKey().getSurname().equals(name)) {
                usersHashSetEntry.getValue().add(new Contact(type, number));
            }
        }
        System.out.println("---Add complete!---");
        return userMap;
    }

    public TreeMap<Users, HashSet<Contact>> changeContact(TreeMap<Users, HashSet<Contact>> userMap) {
        String name;
        String oldType;
        String newType;
        int newNumber;
        Set<Map.Entry<Users, HashSet<Contact>>> entries = userMap.entrySet();
        //Iterator<Map.Entry<Users, HashSet<Contact>>> iterator4 = entries.iterator();
        Scanner sc = new Scanner(System.in);

        System.out.print(
                "<Change Contact>\n" +
                        "Put name/surname to change Cont.> "
        );

        name = sc.nextLine();
        System.out.print("Put old Type of number> ");
        oldType = sc.nextLine();
        System.out.print("Put new Type of number> ");
        newType = sc.nextLine();
        System.out.print("Put new Number> ");
        newNumber = sc.nextInt();
        sc.nextLine();

        for (Map.Entry<Users, HashSet<Contact>> usersHashSetEntr : userMap.entrySet()) {
            if (usersHashSetEntr.getKey().getName().equals(name) || usersHashSetEntr.getKey().getSurname().equals(name)) {
                if (usersHashSetEntr.getValue().iterator().next().getType().equals(oldType)) {
                    usersHashSetEntr.getValue().iterator().next().setType(newType);
                    usersHashSetEntr.getValue().iterator().next().setNumber(newNumber);
                }
            } else {
                System.out.println("---No that User!---");
            }
        }

        System.out.println("---Change complete!---");
        return userMap;
    }

    public void showAllTelBook(TreeMap<Users, HashSet<Contact>> userMap) {
        Set<Map.Entry<Users, HashSet<Contact>>> entries = userMap.entrySet();
        Iterator<Map.Entry<Users, HashSet<Contact>>> iterator5 = entries.iterator();

        System.out.println("<List TellBook>");
        while (iterator5.hasNext()) {
            if (iterator5.hasNext()) {
                System.out.println(iterator5.next());
            } else {
                System.out.println("---List is Emty---");
            }
        }

    }
}
