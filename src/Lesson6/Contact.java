package Lesson6;

import java.util.Objects;

public class Contact {
    private String type;
    private int number;

    public Contact(String type, int number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return number == contact.number &&
                Objects.equals(type, contact.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, number);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "type='" + type + '\'' +
                ", number=" + number +
                '}';
    }
}
