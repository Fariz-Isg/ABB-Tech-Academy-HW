package HW10;

import java.io.Serializable;

class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String email;
    private int age;

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("User{username='%s', email='%s', age=%d}",
                username, email, age);
    }
}