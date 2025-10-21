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

public class ActorRepository implements IRepository {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstanceConnection();
    }

    @Override
    public List<Actor> findAll() {

        List<Actor> Actors = new ArrayList<>();

        try (Statement myStat = getConnection().createStatement();
                ResultSet myRes = myStat.executeQuery("Select * from sakila.actor");) {
            while (myRes.next()) {
                Actor newActor = new Actor();
                newActor.setActor_id(myRes.getInt("actor_id"));
                newActor.setFirst_name(myRes.getString("first_name"));
                newActor.setLast_name(myRes.getString("last_name"));
                Actors.add(newActor);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Actors;
    }

    ///// meter el update junto con el save

    @Override
    public Actor saveAndUpdateActor(Actor actor) {

        try (Connection myConn = getConnection()) {

            if (actor.getActor_id() != 0) {
                String updateSql = "UPDATE sakila.actor SET first_name = ?, last_name = ? WHERE actor_id = ?";
                try (PreparedStatement myPrepare = myConn.prepareStatement(updateSql)) {
                    myPrepare.setString(1, actor.getFirst_name());
                    myPrepare.setString(2, actor.getLast_name());
                    myPrepare.setInt(3, actor.getActor_id());
                    myPrepare.executeUpdate();
                }

            } else {
                String sql = "INSERT INTO sakila.actor(first_name, last_name) VALUES (?,?)";
                try (PreparedStatement myPrepare = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

                    myPrepare.setString(1, actor.getFirst_name());
                    myPrepare.setString(2, actor.getLast_name());
                    myPrepare.executeUpdate();

                    try (ResultSet rs = myPrepare.getGeneratedKeys()) {
                        if (rs.next()) {
                            actor.setActor_id(rs.getInt(1   ));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar o actualizar actor: " + e.getMessage());
        }
        return actor;
    }
}
