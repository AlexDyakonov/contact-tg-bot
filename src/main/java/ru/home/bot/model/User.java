package ru.home.model;

import java.util.Set;

public class User {
    public static final int MIN_USER_NAME_LENGTH = 1;
    public static final int MAX_USER_NAME_LENGTH = 255;
    public static final int MIN_TELEPHONE_NUMBER_LENGTH = 1;
    public static final int MAX_TELEPHONE_NUMBER_LENGTH = 14;

    private final Long id;
    private final Set<String> userContactName;
    private final Set<Integer> userContactNumber;

    public User(Set<String> userContactName, Set<Integer> userContactNumber) {
        this(null, userContactName, userContactNumber);
    }

    public User(Long id, Set<String> userContactName, Set<Integer> userContactNumber) {
        this.id = id;
        this.userContactName = userContactName;
        this.userContactNumber = userContactNumber;
    }

    public Long getId() {
        return id;
    }

    public Set<String> getUserContactName() {
        return userContactName;
    }

    public Set<Integer> getUserContactNumber() {
        return userContactNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userContactName=" + userContactName +
                ", userContactNumber=" + userContactNumber +
                '}';
    }
}
