package Lesson6;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        boolean isEnd = false;
        int numbMenu;
        String answer;

        TreeMap<Users, HashSet<Contact>> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        while (!isEnd) {
            boolean moreAction = true;
            numbMenu = menu.showMainMenu();
            switch (numbMenu) {
                case 1:
                    while (moreAction) {
                        map = menu.registMenu(map);
                        System.out.println("<One more (y/n)?> ");
                        answer = scanner.nextLine();
                        if (answer.equals("n")) {
                            moreAction = false;
                        }
                    }
                    break;
                case 2:
                    menu.showUsers(map);
                    break;
                case 3:
                    try {
                        map = menu.removeUser(map);
                    }catch (NoSuchElementException e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    map = menu.addNewContact(map);
                    break;
                case 5:
                    map = menu.changeContact(map);
                    break;
                case 6:
                    menu.showAllTelBook(map);
                    break;
                case 0:
                    isEnd = true;
                    System.out.println("<-----Good BYE!!!----->");
                    break;
                default:
                    System.out.println("<Wrong input, please rapeat!>");
            }
        }

//        map.put(new Users("Bo", "Bon"), new HashSet<>());
//        map.put(new Users("Rob", "Ron"), new HashSet<>());
//        map.put(new Users("Rab", "Ran"), new HashSet<>());
//        Set<Map.Entry<Users, HashSet<Contact>>> entries = map.entrySet();
//        Iterator<Map.Entry<Users, HashSet<Contact>>> iterator = entries.iterator();
//
//        for (Map.Entry<Users, HashSet<Contact>> entry : entries) {
//            if (iterator.next().getKey().getName().equals("Rab")) {
//                entry.getValue().add(new Contact("Mob", 85666));
//            }
//        }

//        map = addNewUser(map,"Bob", "Bon", "Home", 256555);
//        map = addNewUser(map,"Ronnny", "Bor", "Mob", 242555);
//        map = addNewUser(map,"Any", "Brg", "Mob", 45555);
        System.out.println(map);

    }
}
