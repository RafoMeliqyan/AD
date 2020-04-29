package model;

public class User {
    private String name;
    private String Surname;
    private String gender;
    private int age;
    private int phoneNumber;
    private String password;

    public User(String name, String surname, String gender, int age, int phoneNumber, String password) {
        this.name = name;
        Surname = surname;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (phoneNumber != user.phoneNumber) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (Surname != null ? !Surname.equals(user.Surname) : user.Surname != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (Surname != null ? Surname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + phoneNumber;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                '}';
    }
}
