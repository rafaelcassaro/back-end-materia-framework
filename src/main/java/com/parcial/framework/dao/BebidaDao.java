package com.parcial.framework.dao;

import com.parcial.framework.entities.Bebida;
import com.parcial.framework.entities.Student;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class BebidaDao extends Daos<Bebida>{

    public BebidaDao(){
        super();
    }

    @Override
    String sqlCommandFindAll() {
        return "SELECT * FROM bebida";
    }

    @Override
    String sqlCommandFindByID() {
        return "select * from bebida where id= ?";
    }

    @Override
    String sqlCommandDeleteByID() {
        return "delete from bebida where id =?";
    }

    @Override
    String sqlCommandAdd() {
        return "insert into bebida(nome, preco ,validade) VALUES (?,?,?)";
    }

    @Override
    String sqlCommandUpdate() {
        return "update bebida set nome=?, preco= ?, validade= ? where id = ?";
    }

    @Override
    void ProcessingResultFindAll() {
        try {
            ls.clear();
            while (resultSet.next()) {
                Bebida bebida = new Bebida();
                bebida.setId(resultSet.getInt("id"));
                bebida.setNome(resultSet.getString("nome"));
                bebida.setPreco(resultSet.getDouble("preco"));
                bebida.setValidade(resultSet.getString("validade"));
                ls.add(bebida);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void ProcessingResultFindByID() {
        try {
            object = new Bebida();

            while (resultSet.next()) {
                object.setId(resultSet.getInt("id"));
                object.setNome(resultSet.getString("nome"));
                object.setPreco(resultSet.getDouble("preco"));
                object.setValidade(resultSet.getString("validade"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void ProcessingResultAdd(Bebida obj) {
        try {
            object = obj;
            preparedStatement.setString(1, object.getNome());
            preparedStatement.setDouble(2, object.pegarImpostoICMS().aplicarImposto(object.getPreco()));
            preparedStatement.setString(3, object.getValidade());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void ProcessingResultUpdate(Bebida obj) {
        try {
            object = obj;
            preparedStatement.setString(1, object.getNome());
            preparedStatement.setDouble(2, object.getPreco());
            preparedStatement.setString(3, object.getValidade());
            preparedStatement.setInt(4, object.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
