package com.jason.SpringJDBCEx.repo;

import com.jason.SpringJDBCEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student st) {
        String sql="insert into student(rollno,name,marks) values(?,?,?)";

        int rows=jdbc.update(sql,st.getRollNo(),st.getName(),st.getMarks());
        System.out.println(rows +" affected");
    }

    public List<Student> findAll() {
        String sql = "select * from student";
        
        RowMapper<Student> mapper = (rs, rowNum) -> {       //lambda expression
                Student st = new Student();
                st.setRollNo(rs.getInt("rollno"));
                st.setName(rs.getString("name"));
                st.setMarks(rs.getInt("marks"));

                return st;
        };

        return jdbc.query(sql, mapper);
    }
}
