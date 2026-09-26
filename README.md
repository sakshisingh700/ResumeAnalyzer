# Resume Analyzer & Job Recommendation System

A web-based Resume Analyzer that evaluates resumes, calculates an ATS compatibility score, identifies technical skills, recommends suitable job roles, and provides improvement suggestions based on the selected target role.

## 📌 Project Overview

The Resume Analyzer & Job Recommendation System is a Spring Boot-based web application designed to help students and job seekers understand how well their resume matches a selected job role.

The system accepts a resume in PDF format, extracts its text, analyzes the resume content, calculates an ATS score, detects technical skills, checks job-role-specific skills, recommends suitable job roles, and provides suggestions for improving the resume.

## ✨ Features

* 📄 PDF resume upload
* 📊 ATS compatibility score
* 🎯 Target job role selection
* 💼 Job match percentage
* 🛠 Technical skill detection
* 📚 Missing skill identification
* 💡 Resume improvement suggestions
* 💪 Resume strengths analysis
* 💼 Job recommendations
* 📋 Resume analysis history
* 👁 View previous analysis
* 🗑 Delete resume history
* 🔐 Database password managed using an environment variable

## 🎯 Supported Job Roles

The application currently supports the following target roles:

* Java Developer
* Frontend Developer
* Software Developer
* Full Stack Developer
* Data Analyst

## 🛠 Technologies Used

### Backend

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate

### Frontend

* HTML5
* CSS3
* JavaScript
* Thymeleaf

### Database

* MySQL

### Other Tools & Libraries

* Apache PDFBox
* Maven
* IntelliJ IDEA
* Git & GitHub

## ⚙️ How It Works

1. The user selects a target job role.
2. The user uploads a resume in PDF format.
3. The application extracts text from the PDF using Apache PDFBox.
4. The extracted resume content is analyzed.
5. Technical skills are detected from the resume.
6. An ATS score is calculated.
7. The selected job role is compared with the detected skills.
8. A job match percentage is calculated.
9. Missing job-specific skills are displayed.
10. Suitable job roles are recommended.
11. Resume strengths and improvement suggestions are generated.
12. The analysis is stored in MySQL and displayed in Resume History.

## 📊 ATS Score

The ATS score is calculated using multiple resume components:

| Component           | Maximum Score |
| ------------------- | ------------- |
| Technical Skills    | 40            |
| Resume Sections     | 20            |
| Projects            | 15            |
| Education           | 10            |
| Contact Information | 5             |
| Achievements        | 10            |
| **Total**           | **100**       |

## 🎯 Job Match Analysis

The Job Match Score compares the technical skills detected in the resume with the skills required for the selected target role.

For example, the system checks different skill requirements for roles such as:

* Java Developer
* Frontend Developer
* Software Developer
* Full Stack Developer
* Data Analyst

The percentage is calculated based on the number of required skills matched by the resume.

## 💼 Job Recommendations

The system recommends suitable job roles based on the technical skills detected in the uploaded resume.

Examples include:

* Java Developer
* JavaScript Developer
* Frontend Developer
* Web Developer
* SQL Developer
* Software Developer
* React Developer

## 📁 Project Structure

```text
ResumeAnalyzer
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.resumeanalyzer.resumeanalyzer
│   │   │       ├── controller
│   │   │       └── repository
│   │   │           └── entity
│   │   │
│   │   └── resources
│   │       ├── static
│   │       ├── templates
│   │       └── application.properties
│   │
│   └── test
│
├── uploads
├── .gitignore
├── .gitattributes
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## 🗄️ Database

The application uses MySQL with the database:

```text
resume_analyzer
```

The main `resumes` table stores information such as:

* Resume ID
* File name
* ATS score
* Detected skills
* Recommended jobs
* Missing skills
* Strengths
* Suggestions
* Selected job role
* Job match score

## 🔐 Database Configuration

For security, the MySQL password is not stored directly in the project.

The application uses an environment variable:

```properties
spring.datasource.password=${DB_PASSWORD}
```

Before running the application, configure the `DB_PASSWORD` environment variable with your local MySQL password.

## ▶️ How to Run the Project

### 1. Clone the Repository

```bash
git clone <your-github-repository-url>
```

### 2. Open the Project

Open the project in IntelliJ IDEA.

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE resume_analyzer;
```

### 4. Configure the Database Password

Set the environment variable:

```text
DB_PASSWORD
```

with your local MySQL password.

### 5. Run the Application

Using Maven Wrapper on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Or run the main Spring Boot application class directly from IntelliJ IDEA.

### 6. Open the Application

```text
http://localhost:8080
```

## 🔗 Main Application API

The primary resume upload endpoint is:

```text
POST /api/resume/upload
```

Additional endpoints and their exact behavior will be documented after final API testing.

## 🧪 Testing

The final version of the project will be tested for:

* Application startup
* MySQL database connection
* Resume PDF upload
* PDF text extraction
* ATS score calculation
* Technical skill detection
* Job recommendations
* Job match calculation
* Missing skill detection
* Resume history
* View details
* Delete functionality

Final test results will be added after the complete testing phase.

## 📸 Screenshots

Screenshots of the final working application will be added here after final UI testing.

Planned screenshots include:

* Home page
* Resume upload and target role selection
* ATS score
* Job Match Analysis
* Skills and missing skills
* Suggestions and strengths
* Resume History
* View analysis details

## ⚠️ Current Limitations

* Resume analysis is currently rule-based.
* Skill detection is based on predefined technical skills.
* Job-role requirements are predefined.
* The current system does not use a machine-learning model.
* Resume analysis is mainly focused on text-based PDF resumes.

## 🚀 Future Enhancements

Possible future improvements include:

* AI/ML-based resume analysis
* Natural Language Processing
* More job roles and skill sets
* Improved skill extraction
* Resume keyword optimization
* Job description matching
* Personalized job recommendations
* Resume section quality analysis
* Authentication and user accounts
* Cloud deployment
* More advanced ATS analysis

## 🎓 Project Purpose

This project was developed as an academic and practical software development project to understand:

* Java and Spring Boot
* REST APIs
* Database integration
* PDF processing
* Frontend-backend integration
* Resume analysis logic
* Job matching
* Git and GitHub project management

## 👩‍💻 Author

**Sakshi Singh**

MCA Student | Software Developer
