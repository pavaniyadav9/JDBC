package com.hallbooking.servlet;

import com.hallbooking.util.DBConnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/book")
public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        try {
            int userId=Integer.parseInt(req.getParameter("userId"));
            int hallId=Integer.parseInt(req.getParameter("hallId"));
            String date=req.getParameter("bookingDate");
            String sql="INSERT INTO bookings(user_id,hall_id,booking_date) VALUES(?,?,?)";
            try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(sql)) {
                ps.setInt(1,userId); ps.setInt(2,hallId); ps.setDate(3,Date.valueOf(date));
                ps.executeUpdate();
            }
            resp.getWriter().println("<h2>Booking successful!</h2><a href='halls'>Back to halls</a>");
        } catch(SQLException e) {
            resp.getWriter().println("<h2>Booking failed. The hall may already be booked for this date.</h2>");
            resp.getWriter().println("<a href='halls'>Back to halls</a>");
        } catch(Exception e) {
            resp.getWriter().println("<h2>Invalid booking details.</h2>");
        }
    }
}
