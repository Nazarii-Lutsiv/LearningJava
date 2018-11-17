package Lesson6;

import java.util.*;

public class Users implements Comparable<Users>{
    private String name;
    private String surname;

    public Users(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static TreeMap<Users, HashSet<Contact>> addNewUser(TreeMap<Users, HashSet<Contact>> newMap, String name, String surname, String typeN, int number){
        HashSet<Contact> cont = new HashSet<>();
        cont.add(new Contact(typeN, number));
        newMap.put(new Users(name, surname), cont);
        return newMap;
    }

    @Override
    public int compareTo(Users o) {
        return name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(name, users.name) &&
                Objects.equals(surname, users.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
