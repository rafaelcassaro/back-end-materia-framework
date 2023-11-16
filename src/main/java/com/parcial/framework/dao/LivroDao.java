package com.parcial.framework.dao;


import com.parcial.framework.bridgeImpl.ImpostoICMS;
import com.parcial.framework.entities.Livro;
import com.parcial.framework.entities.SpICMS;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class LivroDao extends Daos<Livro> {

    public LivroDao(){
        super();
    }

    @Override
    String sqlCommandFindAll() {
        return "SELECT * FROM livro";
    }

    @Override
    String sqlCommandFindByID() {
        return "select * from livro where id= ?";
    }

    @Override
    String sqlCommandDeleteByID() {
        return "delete from livro where id =?";
    }

    @Override
    String sqlCommandAdd() {
        return "insert into livro(nome, genero, preco ,imposto,total) VALUES (?,?,?,?,?)";
    }

    @Override
    String sqlCommandUpdate() {
        return "update livro set nome=?, preco= ?, genero= ?, imposto=?, total=? where id = ?";
    }

    @Override
    void ProcessingResultFindAll() {
        try {
            ls.clear();
            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setId(resultSet.getInt("id"));
                livro.setNome(resultSet.getString("nome"));
                livro.setPreco(resultSet.getDouble("preco"));
                livro.setGenero(resultSet.getString("genero"));
                livro.setImposto(resultSet.getDouble("imposto"));
                livro.setTotal(resultSet.getDouble("total"));
                ls.add(livro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    void ProcessingResultFindByID() {
        try {

            object = new Livro();

            while (resultSet.next()) {
                object.setId(resultSet.getInt("id"));
                object.setNome(resultSet.getString("nome"));
                object.setPreco(resultSet.getDouble("preco"));
                object.setGenero(resultSet.getString("genero"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    void ProcessingResultAdd(Livro obj) {
        try {
            object = obj;

            preparedStatement.setString(1, object.getNome());
            preparedStatement.setString(2, object.getGenero());
            preparedStatement.setDouble(3, object.getPreco());
            preparedStatement.setDouble(4, object.getImposto());
            preparedStatement.setDouble(5, object.getTotal());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    void ProcessingResultUpdate(Livro obj) {
        try {
            object = obj;
            preparedStatement.setString(1, object.getNome());
            preparedStatement.setDouble(2, object.getPreco());
            preparedStatement.setString(3, object.getGenero());
            preparedStatement.setDouble(4, object.getImposto());
            preparedStatement.setDouble(5, object.getTotal());
            preparedStatement.setInt(6, object.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
