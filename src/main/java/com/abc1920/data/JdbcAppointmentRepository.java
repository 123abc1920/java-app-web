package com.abc1920.data;

import com.abc1920.domain.Consts;
import com.abc1920.domain.model.event.Appointment;
import com.abc1920.domain.repository.AppointmentRepository;

import java.sql.*;
import java.util.ArrayList;

public class JdbcAppointmentRepository implements AppointmentRepository {

    private Appointment createAppointment(ResultSet rs) throws SQLException {
        return new Appointment(rs.getInt("id"), rs.getDate("date"), rs.getString("name"), rs.getString("description"), rs.getBoolean("is_repeatable"));
    }

    @Override
    public ArrayList<Appointment> getAll() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment";

        try (Connection conn = Consts.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                appointments.add(createAppointment(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public Appointment getById(int id) {
        String sql = "SELECT * FROM appointment WHERE id = ?";

        try (Connection conn = Consts.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return createAppointment(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Appointment item) {
        String sql = "INSERT INTO appointment (name, date, description, is_repeatable) VALUES (?, ?, ?, ?)";

        System.out.println("hhh");
        try (Connection conn = Consts.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            java.util.Date utilDate = item.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setString(1, item.getName());
            stmt.setDate(2, sqlDate);
            stmt.setString(3, item.getDescription());
            stmt.setBoolean(4, item.isRepeatable());

            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                item.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM appointment WHERE id = ?";

        try (Connection conn = Consts.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean exists(int id) {
        String sql = "SELECT COUNT(*) FROM appointment WHERE id = ?";

        try (Connection conn = Consts.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
