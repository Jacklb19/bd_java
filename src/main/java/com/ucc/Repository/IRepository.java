package com.ucc.Repository;

import java.util.List;

import com.ucc.Model.Actor;

public interface IRepository {
    List<Actor> findAll(); 
    Actor save(Actor actor);
}