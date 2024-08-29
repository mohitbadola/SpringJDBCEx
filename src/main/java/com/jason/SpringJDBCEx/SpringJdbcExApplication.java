package com.jason.SpringJDBCEx;

import com.jason.SpringJDBCEx.model.Student;
import com.jason.SpringJDBCEx.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);
		 Student st = context.getBean(Student.class);
		 st.setName("Kaukau");
		 st.setMarks(10);
		 st.setRollNo(4);

		StudentService service = context.getBean(StudentService.class);

		 service.addStudent(st);

		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
