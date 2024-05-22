package com.iesam.digitallibrary.feature.user.domain;

public class UserFactory {
    public User build(String userCode, String dni, String name, String lastName, String phoneNumber, String address) {
        return new User(userCode, dni, name, lastName, phoneNumber, address);
    }
}
