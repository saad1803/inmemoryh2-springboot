package com.inmemory.test.demo.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Student st = new Student();
	    st.setId(rs.getLong("id"));
	    st.setName(rs.getString("name"));
	    st.setAddress(rs.getString("address"));
	    st.setGender(rs.getString("gender"));
	    return st;
	}

    }

    public List<Student> findAll() {
	return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }

    public Student findById(Long id) {
	return jdbcTemplate.queryForObject("select * from student where id = ?", new Object[] { id },
		new BeanPropertyRowMapper<Student>(Student.class));
    }

    public int insert(Student student) {
	return jdbcTemplate.update("insert into student (id, name, address,gender) " + "values(?,  ?, ?,?)",
		new Object[] { student.getId(), student.getName(), student.getAddress(), student.getGender() });
    }

    public int update(Student student) {
	return jdbcTemplate.update("update student " + " set name = ?, address = ? " + " where id = ?",
		new Object[] { student.getName(), student.getAddress(), student.getId() });
    }
}
