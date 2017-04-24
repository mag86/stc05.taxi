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
import main.model.pojo.Lesson;

/**
 *
 */
@SuppressWarnings("Duplicates")
public class LessonDAOImpl implements LessonDAO {

    private static final String SELECT_ALL = "SELECT id, study_group_id, lesson_date, room, description FROM lesson";

    private static final String INSERT_INTO = "INSERT INTO lesson (study_group_id, lesson_date, room, description) " +
            "VALUES (?, ?, ?, ?)";

    private static final String UPDATE_WHERE = "UPDATE lesson SET study_group_id=?, lesson_date=?, " +
            "room=?, description=? WHERE id = ?";

    private static final String DELETE_BY_ID = "DELETE FROM lesson WHERE id=?";

    @Override
    public Collection<Lesson> getAll() {
        Set<Lesson> lessons = new HashSet<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                lessons.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lessons;
    }

    @Override
    public Lesson getById(Long id) {
        Lesson lesson = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(SELECT_ALL + " WHERE lesson.id = ?")) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lesson = createEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lesson;
    }

    @Override
    public Long insert(Lesson entity) {
        long result = -1;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO,
                     Statement.RETURN_GENERATED_KEYS)) {

            statement.setLong(1, entity.getGroupId());
            statement.setTimestamp(2, entity.getDate());
            statement.setInt(3, entity.getRoom());
            statement.setString(4, entity.getDescription());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                result = resultSet.getLong(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(Lesson entity) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(UPDATE_WHERE)) {

            statement.setLong(1, entity.getGroupId());
            statement.setTimestamp(2, entity.getDate());
            statement.setInt(3, entity.getRoom());
            statement.setString(4, entity.getDescription());

            statement.setLong(2, entity.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Lesson entity) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(DELETE_BY_ID)) {

            statement.setLong(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Lesson createEntity(ResultSet resultSet) throws SQLException {
        Lesson lesson = new Lesson();

        lesson.setId(resultSet.getLong("id"));
        lesson.setGroupId(resultSet.getInt("study_group_id"));
        lesson.setDate(resultSet.getTimestamp("lesson_date"));
        lesson.setRoom(resultSet.getInt("room"));
        lesson.setDescription(resultSet.getString("description"));

        Group group = new GroupDAOImpl().getById(lesson.getGroupId());
        lesson.setGroup(group);

        return lesson;
    }
}
