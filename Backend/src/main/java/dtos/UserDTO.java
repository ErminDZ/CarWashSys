package dtos;

import entities.User;

public class UserDTO {

    private int id;
    private String name;

    public UserDTO(User u) {
        this.id = u.getId();
        this.name = u.getUserName();
    }

    public UserDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
