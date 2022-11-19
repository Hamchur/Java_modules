package edu.school21.chat.models;

import java.util.Objects;
import java.util.List;

public class User {
    private final long id;
    private final String login;
    private String password;
    private List<Chatroom> createRoom;
    private List<Chatroom> socializedRoom;

    public User(long id, String login, String password, List<Chatroom> createRoom, List<Chatroom> socializedRoom){
        this.id = id;
        this.login = login;
        this.password = password;
        this.createRoom = createRoom;
        this.socializedRoom = socializedRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(createRoom, user.createRoom) && Objects.equals(socializedRoom, user.socializedRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, createRoom, socializedRoom);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createRoom=" + createRoom +
                ", socializedRoom=" + socializedRoom +
                '}';
    }


    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Chatroom> getCreateRoom() {
        return createRoom;
    }

    public List<Chatroom> getSocializedRoom() {
        return socializedRoom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreateRoom(List<Chatroom> createRoom) {
        this.createRoom = createRoom;
    }

    public void setSocializedRoom(List<Chatroom> socializedRoom) {
        this.socializedRoom = socializedRoom;
    }
}
