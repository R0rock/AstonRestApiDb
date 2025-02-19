package org.example.projects.methods;

import com.example.app.entity.Privilege;
import com.example.app.entity.Role;
import com.example.app.repository.RoleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleRepositoryImpl implements RoleRepository {
    private Connection connection;

    public RoleRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Role> findAll() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT r.id, r.role_name, p.privilege_id, p.privilege_name " +
                    "FROM roles r LEFT JOIN role_privileges rp ON r.id = rp.role_id " +
                    "LEFT JOIN privileges p ON rp.privilege_id = p.id");
            ResultSet resultSet = statement.executeQuery();
            List<Role> roles = new ArrayList<>();
            while (resultSet.next()) {
                long roleId = resultSet.getLong("id");
                String roleName = resultSet.getString("role_name");
                Role role = new Role(roleId, roleName, new HashSet<>());
                while (!resultSet.isAfterLast()) {
                    long privilegeId = resultSet.getLong("privilege_id");
                    String privilegeName = resultSet.getString("privilege_name");
                    if (privilegeId != 0 && privilegeName != null) {
                        role.getPrivileges().add(new Privilege(privilegeId, privilegeName));
                    }
                    resultSet.next();
                }
                roles.add(role);
            }
            return roles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Role findById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT r.id, r.role_name, p.privilege_id, p.privilege_name " +
                    "FROM roles r LEFT JOIN role_privileges rp ON r.id = rp.role_id " +
                    "LEFT JOIN privileges p ON rp.privilege_id = p.id " +
                    "WHERE r.id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long roleId = resultSet.getLong("id");
                String roleName = resultSet.getString("role_name");
                Role role = new Role(roleId, roleName, new HashSet<>());
                while (!resultSet.isAfterLast()) {
                    long privilegeId = resultSet.getLong("privilege_id");
                    String privilegeName = resultSet.getString("privilege_name");
                    if (privilegeId != 0 && privilegeName != null) {
                        role.getPrivileges().add(new Privilege(privilegeId, privilegeName));
                    }
                    resultSet.next();
                }
                return role;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Role role) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO roles (role_name) VALUES (?)");
            statement.setString(1, role.getRoleName());
            statement.executeUpdate();

            long roleId = getGeneratedKey(statement);
            for (Privilege privilege : role.getPrivileges()) {
                statement = connection.prepareStatement("INSERT INTO role_privileges (role_id, privilege_id) VALUES (?, ?)");
                statement.setLong(1, roleId);
                statement.setLong(2, privilege.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Role role) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE roles SET role_name = ? WHERE id = ?");
            statement.setString(1, role.getRoleName());
            statement.setLong(2, role.getId());
            statement.executeUpdate();

            statement = connection.prepareStatement("DELETE FROM role_privileges WHERE role_id = ?");
            statement.setLong(1, role.getId());
            statement.executeUpdate();

            for (Privilege privilege : role.getPrivileges()) {
                statement = connection.prepareStatement("INSERT INTO role_privileges (role_id, privilege_id) VALUES (?, ?)");
                statement.setLong(1, role.getId());
                statement.setLong(2, privilege.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM roles WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private long getGeneratedKey(PreparedStatement statement) throws SQLException {
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getLong(1);
        }
        throw new SQLException("Failed to retrieve generated key.");
    }
}