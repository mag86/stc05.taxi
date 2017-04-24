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
import main.model.pojo.Journal;
import main.model.pojo.Lesson;
import main.model.pojo.Cars;

/**
 *
 */
@SuppressWarnings("Duplicates")
public class JournalDAOImpl implements JournalDAO {

    private static final String SELECT_ALL = "SELECT id, lesson_id, student_id FROM journal";
    private static final String INSERT_INTO = "INSERT INTO journal (lesson_id, student_id) VALUES (?, ?)";
    private static final String UPDATE_WHERE = "UPDATE journal SET lesson_id = ?, student_id = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM journal WHERE id=?";

    @Override
    public Collection<Journal> getAll() {
        Set<Journal> lessons = new HashSet<>();

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
    public Journal getById(Long id) {
        Journal journal = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(SELECT_ALL + " WHERE id = ?")) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                journal = createEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return journal;
    }

    @Override
    public Long insert(Journal entity) {
        long result = -1;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO,
                     Statement.RETURN_GENERATED_KEYS)) {

            statement.setLong(1, entity.getLessonId());
            statement.setLong(2, entity.getStudentId());
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
    public void update(Journal entity) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(UPDATE_WHERE)) {

            statement.setLong(1, entity.getLessonId());
            statement.setLong(2, entity.getStudentId());
            statement.setLong(3, entity.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Journal entity) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(DELETE_BY_ID)) {

            statement.setLong(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Journal createEntity(ResultSet resultSet) throws SQLException {
        Journal journal = new Journal();
        journal.setId(resultSet.getLong("id"));
        journal.setLessonId(resultSet.getLong("lesson_id"));
        journal.setStudentId(resultSet.getLong("student_id"));

        Cars student = new CarsDAOImpl().getById(journal.getStudentId());
        journal.setStudent(student);

        Lesson lesson = new LessonDAOImpl().getById(journal.getLessonId());
        journal.setLesson(lesson);

        return journal;
    }
}
