package com.parcial.framework.dao;

import com.parcial.framework.entities.Celular;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class CelularDao extends Daos<Celular>{

    public CelularDao(){
        super();
    }

    @Override
    String sqlCommandFindAll() {
        return "SELECT * FROM celular";
    }

    @Override
    String sqlCommandFindByID() {
        return "select * from celular where id= ?";
    }

    @Override
    String sqlCommandDeleteByID() {
        return "delete from celular where id =?";
    }

    @Override
    String sqlCommandAdd() {
        return "insert into celular(nome, preco ,marca,imposto,total,categoria) VALUES (?,?,?,?,?,?)";
    }

    @Override
    String sqlCommandUpdate() {
        return "update celular set nome=?, preco= ?, marca= ?, imposto=?, total=?, categoria=? where id = ?";
    }

    @Override
    void ProcessingResultFindAll() {
        try {
            ls.clear();
            while (resultSet.next()) {
                Celular celular = new Celular();
                celular.setId(resultSet.getInt("id"));
                celular.setNome(resultSet.getString("nome"));
                celular.setPreco(resultSet.getDouble("preco"));
                celular.setMarca(resultSet.getString("marca"));
                celular.setImposto(resultSet.getDouble("imposto"));
                celular.setTotal(resultSet.getDouble("total"));
                celular.setCategoria(resultSet.getString("categoria"));
                ls.add(celular);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void ProcessingResultFindByID() {
        try {
            object = new Celular();

            while (resultSet.next()) {
                object.setId(resultSet.getInt("id"));
                object.setNome(resultSet.getString("nome"));
                object.setPreco(resultSet.getDouble("preco"));
                object.setMarca(resultSet.getString("marca"));
                object.setCategoria(resultSet.getString("categoria"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void ProcessingResultAdd(Celular obj) {
        try {
            object = obj;
            preparedStatement.setString(1, object.getNome());
            preparedStatement.setDouble(2, object.getPreco());
            preparedStatement.setString(3, object.getMarca());
            preparedStatement.setDouble(4, object.getImposto());
            preparedStatement.setDouble(5, object.getTotal());
            preparedStatement.setString(6, object.getCategoria());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void ProcessingResultUpdate(Celular obj) {
        try {
            object = obj;
            preparedStatement.setString(1, object.getNome());
            preparedStatement.setDouble(2, object.getPreco());
            preparedStatement.setString(3, object.getMarca());
            preparedStatement.setDouble(4, object.getImposto());
            preparedStatement.setDouble(5, object.getTotal());
            preparedStatement.setString(6, object.getCategoria());
            preparedStatement.setInt(7, object.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
