package com.iesam.digitallibrary.feature.user.domain;

public class User {
    public final String userCode;
    public final String dni;
    public final String name;
    public final String lastName;
    public final String phoneNumber;
    public final String address;

    public User(String userCode, String dni, String name, String lastName, String phoneNumber, String address) {
        this.userCode = userCode;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User {" +
                "Codigo de usuario: " + userCode +
                "\nDni: " + dni +
                "\nNombre: " + name +
                "\nApellidos: " + lastName +
                "\nNumero de telefono: " + phoneNumber +
                "\nDirección: " + address + " }";
    }
}
