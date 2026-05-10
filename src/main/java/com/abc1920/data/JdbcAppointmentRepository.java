package com.abc1920.data;

import com.abc1920.domain.Consts;
import com.abc1920.domain.model.event.Appointment;
import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.repository.AppointmentRepository;
import com.abc1920.dto.EventDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class JdbcAppointmentRepository implements AppointmentRepository {
    private static final String SELECT_ALL = "SELECT * FROM appointment";
    private static final String SELECT_ALL_BY_ID = "SELECT * FROM appointment WHERE id = ?";
    private static final String INSERT = "INSERT INTO appointment (name, date, description, is_repeatable) VALUES (?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM appointment WHERE id = ?";
    private static final String COUNT = "SELECT COUNT(*) FROM appointment WHERE id = ? AND name = ? AND description = ? AND date = ? AND is_repeatable = ?";
    private static final String UPDATE = "UPDATE appointment SET name = ?, description = ?, date = ?, is_repeatable = ? WHERE id = ?";

    private Appointment createAppointment(ResultSet rs) throws SQLException {
        return new Appointment(rs.getInt("id"), rs.getDate("date"),
                rs.getString("name"), rs.getString("description"),
                rs.getBoolean("is_repeatable"));
    }

    @Override
    public ArrayList<Appointment> getAll() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        String sql = SELECT_ALL;

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
        String sql = SELECT_ALL_BY_ID;

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
        String sql = INSERT;

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
        String sql = DELETE;

        try (Connection conn = Consts.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(EventDTO event) {
        String sql = UPDATE;

        try (Connection conn = Consts.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, event.getName());
            stmt.setString(2, event.getDescription());
            stmt.setDate(3, new java.sql.Date(event.getDate().getTime()));
            stmt.setBoolean(4, event.getIsRepeatable());
            stmt.setInt(5, event.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean exists(EventDTO event) {
        String sql = COUNT;

        try (Connection conn = Consts.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, event.getId());
            stmt.setString(2, event.getName());
            stmt.setString(3, event.getDescription());
            stmt.setDate(4, new java.sql.Date(event.getDate().getTime()));
            stmt.setBoolean(5, event.getIsRepeatable());

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
