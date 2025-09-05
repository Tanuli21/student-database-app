package com.studentapp;

public class Student {
	
		private int id;
		private String name;
		private String email;
		private int age;
		private String subject;
		
		public Student() {}
		
		public Student(String name,String email, int age, String subject) {
			this.name = name;
			this.email = email;
			this.age = age;
			this.subject = subject;
		}
		
		public int getId() {return id;}
		public void setId(int id) {this.id=id;}
		
		public String getName() {return name;}
		public void setName(String name) {this.name=name;}
		
		public String getEmail() {return email;}
		public void setEmail(String email) {this.email=email;}
		
		public int getAge() {return age;}
		public void setAge(int age) {this.age=age;}
		
		public String getSubject() {return subject;}
		public void setSubject(String subject) {this.subject=subject;}
		
		public String toString() {
			return "ID: " + id + ", Name: " + name + ", Email: " + email + ", Age: " + age + ", Subject: " + subject;
		}
		
		

	}

