package com.korai.servletstudy2.repository;

import com.korai.servletstudy2.database.DatabaseProvider;
import com.korai.servletstudy2.entity.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository implements Repository<Menu> {
    private static MenuRepository instance;

    private DatabaseProvider databaseProvider;

    private MenuRepository() {
        this.databaseProvider = DatabaseProvider.getInstance();
    }

    public static MenuRepository getInstance() {
        if (instance == null) instance = new MenuRepository();
        return instance;
    }

    @Override
    public List<Menu> findAll() {
        List<Menu> menus = new ArrayList<>();

        String sql = """
                select
                    *
                from
                    menus""";

        try {
            ResultSet rs = select(databaseProvider.getConnection(), sql);
            while (rs.next()) {
                menus.add(new Menu(
                        rs.getInt("menu_id"),
                        rs.getInt("restaurant_id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getBoolean("is_signature"),
                        rs.getBoolean("is_sold_out")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menus;
    }

    @Override
    public Menu findById(int id) {
        return null;
    }
}
