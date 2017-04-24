package main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import main.model.ConnectionPool;
import main.model.pojo.Group;

/**
 *
 */
@SuppressWarnings("Duplicates")
public class GroupDAOImpl implements GroupDAO {

    private static final String SELECT_ALL = "SELECT id , name FROM groups";
    private static final String INSERT_INTO = "INSERT INTO groups (name) VALUES (?)";
    private static final String UPDATE_WHERE = "UPDATE groups SET name = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM groups WHERE id=?";

    @Override
    public Collection<Group> getAll() {
        Set<Group> groups = new HashSet<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                groups.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return groups;
    }

    @Override
    public Group getById(Integer id) {
        Group group = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(SELECT_ALL + " WHERE id = ?")) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                group = createEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return group;
    }

    @Override
    public Integer insert(Group entity) {
        Integer result = -1;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO,
                     Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, entity.getName());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(Group entity) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(UPDATE_WHERE)) {

            statement.setString(1, entity.getName());
            statement.setLong(2, entity.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Group entity) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(DELETE_BY_ID)) {

            statement.setLong(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Group createEntity(ResultSet resultSet) throws SQLException {
        Group group = new Group();

        group.setId(resultSet.getLong("id"));
        group.setName(resultSet.getString("name"));

        return group;
    }
}
