package com.ucc.Repository;

import java.util.List;

import com.ucc.Model.Actor;

public interface IRepository {
    List<Actor> findAll(); 
    Actor saveAndUpdateActor(Actor actor);
    boolean deleteActor(int actor_id);
    //getById only one actor

}