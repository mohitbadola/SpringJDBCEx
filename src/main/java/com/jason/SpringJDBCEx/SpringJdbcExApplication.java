package com.jason.SpringJDBCEx;

import com.jason.SpringJDBCEx.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);
		 Student st = context.getBean(Student.class);
		 st.setName("Mohit");
		 st.setMarks(50);
		 st.setRollNo(1);
		 System.out.println(st.toString());
	}

}
