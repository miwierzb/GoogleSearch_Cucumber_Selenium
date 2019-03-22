package com.assignment.api;

public class Comments {
    int postId;
    int id;
    String name;
    String email;
    String body;

    public Comments() {
    }

    public Comments(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        return "\nComment data: \nid: " + this.id + ",\npostId: " + this.postId + ",\nname: " + this.name + ",\nemail" +
                ": " + this.email + ",\nbody: " + this.body + "\n";
    }

}
