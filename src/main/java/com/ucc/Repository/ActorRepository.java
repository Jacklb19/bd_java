package com.ucc.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                newActor.setActor_id(myRes.getInt("actor_id"));
                newActor.setFirst_name(myRes.getString("first_name"));
                newActor.setLast_name(myRes.getString("last_name"));
                Actors.add(newActor); 
        }} catch (Exception e) {
             System.out.println("Conexion Fail");
        }
        return Actors;
    }

    ///// meter el update junto con el save 
    
    @Override
    public Actor save(Actor actor) {
        String sql = "INSERT INTO sakila.actor(actor_id,first_name, last_name) VALUES (?,?,?)";
        try (PreparedStatement myPrepare = getConnection().prepareStatement(sql);) {

            myPrepare.setInt(1, actor.getActor_id());
            myPrepare.setString(2, actor.getFirst_name());
            myPrepare.setString(3, actor.getLast_name());
            
            myPrepare.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Conexion Fail");
        }
        return actor;
    }
    
}
