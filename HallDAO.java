package com.hallbooking.dao;

import com.hallbooking.model.Hall;
import com.hallbooking.util.DBConnection;
import java.sql.*;
import java.util.*;

public class HallDAO {
    public List<Hall> findAll() throws SQLException {
        List<Hall> halls = new ArrayList<>();
        String sql="SELECT * FROM halls WHERE status='AVAILABLE'";
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()) {
            while(rs.next()) {
                halls.add(new Hall(rs.getInt("id"),rs.getString("hall_name"),
                    rs.getString("location"),rs.getInt("capacity"),
                    rs.getDouble("price"),rs.getString("status")));
            }
        }
        return halls;
    }
}
