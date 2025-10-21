package com.ucc.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ucc.Connection.DatabaseConnection;
import com.ucc.Model.Actor;

public class ActorRepository implements IRepository{

    private Connection getConnection() throws SQLException{
        return DatabaseConnection.getInstanceConnection();
    }

    @Override
    public List<Actor> findAll() {

        List<Actor> Actors = new ArrayList<>();

        try (Statement myStat = getConnection().createStatement();
            ResultSet myRes= myStat.executeQuery("Select * from sakila.actor");
        ) {
                 while (myRes.next()) {
                Actor newActor = new Actor();
                newActor.setFirst_name(myRes.getString("first_name"));
                newActor.setLast_name(myRes.getString("last_name"));
                Actors.add(newActor); 
        }} catch (Exception e) {
             System.out.println("Conexion Fail");
        }
        return Actors;
    }

    @Override
    public Actor save(Actor actor) {
        return null;
    }
    
}
