package com.ucc.Model;

public class Actor {
    private int actor_id;
    private String first_name;
    private String last_name;

    public Actor(int actor_id, String first_name, String last_name) {
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Actor() {
        //TODO Auto-generated constructor stub
    }

    public int getActor_id() {
        return actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "actor_id "+ actor_id +" first_name=" + first_name + " last_name=" + last_name + "]";
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }
    
    

}
