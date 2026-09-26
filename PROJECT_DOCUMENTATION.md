# Resume Analyzer & Job Recommendation System

## Detailed Project Documentation

---

## 1. Project Overview

The Resume Analyzer & Job Recommendation System is a web-based application developed using Java and Spring Boot.

The application allows users to upload their resume in PDF format and analyze it against a selected target job role.

The system extracts text from the uploaded resume, detects technical skills, calculates an ATS compatibility score, checks the match between resume skills and the selected job role, identifies missing skills, recommends suitable job roles, and provides resume strengths and improvement suggestions.

The application also stores resume analysis results in a MySQL database and provides a Resume History section where users can view and delete previous analyses.

The current system uses rule-based analysis and predefined skill requirements. It does not currently use Artificial Intelligence or Machine Learning models.

---

## 2. Project Objectives

The main objectives of this project are:

* To develop a web-based resume analysis system.
* To allow users to upload resumes in PDF format.
* To extract text from PDF resumes.
* To calculate an ATS compatibility score.
* To identify technical skills from resume content.
* To compare resume skills with selected job-role requirements.
* To calculate a job match percentage.
* To identify missing job-specific skills.
* To recommend suitable job roles based on detected skills.
* To provide resume strengths and improvement suggestions.
* To store analysis results in a MySQL database.
* To maintain a history of previously analyzed resumes.
* To provide View and Delete functionality for stored analyses.
* To understand Java, Spring Boot, REST APIs, database integration, PDF processing, and frontend-backend integration.

---

## 3. Technologies Used

### 3.1 Backend

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate

### 3.2 Frontend

* HTML5
* CSS3
* JavaScript
* Thymeleaf

### 3.3 Database

* MySQL

### 3.4 Libraries and Tools

* Apache PDFBox
* Maven
* IntelliJ IDEA
* Git
* GitHub

### 3.5 Development Environment

* Operating System: Windows
* Java Version: JDK 25
* Spring Boot Version: 4.1.1
* MySQL Version: 8.0.45
* Apache PDFBox Version: 3.0.5

---

## 4. Application Architecture

The application follows a layered Spring Boot architecture in which the frontend communicates with backend controllers, services handle the main business logic, and repositories communicate with the MySQL database.

### 4.1 High-Level Architecture

```text
                    User
                      |
                      v
        +---------------------------+
        |       Frontend            |
        | HTML + CSS + JavaScript   |
        |       Thymeleaf           |
        +-------------+-------------+
                      |
                      v
        +---------------------------+
        |   Spring Boot Controllers |
        +-------------+-------------+
                      |
                      v
        +---------------------------+
        |      Service Layer        |
        |---------------------------|
        | JobMatchService           |
        | JobRecommendationService  |
        | JobRoleService            |
        | ResumeQualityService      |
        | ResumeScoreService        |
        | ResumeTextExtractor       |
        +-------------+-------------+
                      |
                      v
        +---------------------------+
        |      Repository Layer     |
        |    ResumeRepository       |
        +-------------+-------------+
                      |
                      v
        +---------------------------+
        |       MySQL Database      |
        |      resume_analyzer      |
        |          resumes          |
        +---------------------------+
```

### 4.2 Main Layers

#### Frontend Layer

The frontend provides the user interface for:

* Selecting a target job role.
* Selecting and uploading a PDF resume.
* Starting the resume analysis.
* Displaying the ATS score.
* Displaying the job match percentage.
* Showing detected skills.
* Showing missing skills.
* Showing recommended jobs.
* Showing strengths and suggestions.
* Viewing resume history.
* Viewing analysis details.
* Deleting previous resume analyses.

The main frontend file is:

```text
src/main/resources/templates/index.html
```

### 4.3 Application Flow

A typical resume analysis follows this flow:

```text
1. User selects a target job role
                ↓
2. User uploads a PDF resume
                ↓
3. Frontend sends the resume to Spring Boot
                ↓
4. Resume text is extracted from the PDF
                ↓
5. Resume content is analyzed
                ↓
6. Technical skills are detected
                ↓
7. ATS score is calculated
                ↓
8. Selected job role is compared with resume skills
                ↓
9. Job match percentage is calculated
                ↓
10. Missing skills are identified
                ↓
11. Suitable job roles are recommended
                ↓
12. Strengths and suggestions are generated
                ↓
13. Analysis result is stored in MySQL
                ↓
14. Result is displayed on the frontend
                ↓
15. Analysis becomes available in Resume History
```

### 4.4 Data Flow

The main data flow of the application can be summarized as:

```text
PDF Resume
    ↓
ResumeTextExtractor
    ↓
Extracted Resume Text
    ↓
Resume Analysis
    ├── Technical Skills
    ├── ATS Score
    ├── Resume Quality
    ├── Job Match
    ├── Missing Skills
    ├── Job Recommendations
    ├── Strengths
    └── Suggestions
    ↓
Resume Entity
    ↓
ResumeRepository
    ↓
MySQL
    ↓
Resume History / View Details
```

---

## 5. Project Structure

The main project structure is:

```text
ResumeAnalyzer
│
├── .mvn/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── resumeanalyzer/
│   │   │           └── resumeanalyzer/
│   │   │               │
│   │   │               ├── ResumeAnalyzerApplication.java
│   │   │               ├── ResumeAnalyzer.java
│   │   │               ├── JobMatchService.java
│   │   │               ├── JobRecommendationService.java
│   │   │               ├── JobRoleService.java
│   │   │               ├── ResumeQualityService.java
│   │   │               ├── ResumeScoreService.java
│   │   │               ├── ResumeTextExtractor.java
│   │   │               │
│   │   │               ├── controller/
│   │   │               │   ├── HomeController.java
│   │   │               │   ├── JobMatchController.java
│   │   │               │   ├── JobRoleController.java
│   │   │               │   └── ResumeController.java
│   │   │               │
│   │   │               └── repository/
│   │   │                   ├── ResumeRepository.java
│   │   │                   └── entity/
│   │   │                       └── Resume.java
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       │   └── index.html
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── resumeanalyzer/
│                   └── resumeanalyzer/
│                       └── ResumeAnalyzerApplicationTests.java
│
├── .gitattributes
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

### 5.1 Important Files and Their Purpose

| File / Folder                    | Purpose                                                              |
| -------------------------------- | -------------------------------------------------------------------- |
| `ResumeAnalyzerApplication.java` | Main Spring Boot application entry point                             |
| `ResumeAnalyzer.java`            | Resume analysis related application logic                            |
| `JobMatchService.java`           | Calculates job-role matching based on required skills                |
| `JobRecommendationService.java`  | Generates recommended job roles                                      |
| `JobRoleService.java`            | Handles supported job roles and their required skills                |
| `ResumeQualityService.java`      | Handles resume quality related analysis                              |
| `ResumeScoreService.java`        | Calculates the ATS/resume score                                      |
| `ResumeTextExtractor.java`       | Extracts text from uploaded PDF resumes                              |
| `HomeController.java`            | Handles the application's home page                                  |
| `ResumeController.java`          | Handles resume upload and resume-related operations                  |
| `JobMatchController.java`        | Handles job-match related requests                                   |
| `JobRoleController.java`         | Handles job-role related requests                                    |
| `ResumeRepository.java`          | Communicates with the `resumes` database table                       |
| `Resume.java`                    | Entity representing a stored resume analysis                         |
| `index.html`                     | Main frontend interface                                              |
| `application.properties`         | Database and application configuration                               |
| `pom.xml`                        | Maven dependencies and project configuration                         |
| `.gitignore`                     | Specifies files and folders that should not be committed to Git      |
| `README.md`                      | Main GitHub project documentation                                    |
| `PROJECT_DOCUMENTATION.md`       | Detailed documentation explaining project implementation and working |

---

## 6. Database Design and Configuration

The application uses **MySQL** to store resume analysis results and maintain resume history.

### 6.1 Database

The database used by the application is:

```text
resume_analyzer
```

### 6.2 Database Configuration

The application uses the following database configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/resume_analyzer
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 6.3 Main Database Table

The main database table used by the application is:

```text
resumes
```

### 6.4 Resume Table Fields

The `Resume` entity represents the `resumes` database table.

The main fields used to store resume analysis results are:

| Field             | Purpose                                    |
| ----------------- | ------------------------------------------ |
| `id`              | Unique ID of the resume analysis record    |
| `fileName`        | Name of the uploaded resume file           |
| `atsScore`        | Overall ATS/resume compatibility score     |
| `skills`          | Technical skills detected from the resume  |
| `missingSkills`   | Skills missing from the resume             |
| `recommendedJobs` | Job roles recommended based on the resume  |
| `strengths`       | Strengths identified from the resume       |
| `suggestions`     | Suggestions for improving the resume       |
| `selectedJobRole` | Job role selected by the user              |
| `jobMatchScore`   | Match percentage for the selected job role |

The entity class containing these fields is:

```text
src/main/java/com/resumeanalyzer/resumeanalyzer/repository/entity/Resume.java
```

### 6.5 Entity and Repository

The application uses a JPA entity and repository to communicate with the MySQL database.

#### Resume Entity

The entity class is:

```text
src/main/java/com/resumeanalyzer/resumeanalyzer/repository/entity/Resume.java
```

The repository class is:

```text
src/main/java/com/resumeanalyzer/resumeanalyzer/repository/ResumeRepository.java
```

### 6.6 Database Flow

The database-related flow of the application is:

```text
User Uploads Resume
        ↓
Resume Analysis
        ↓
Analysis Result Generated
        ↓
Resume Entity
        ↓
ResumeRepository
        ↓
MySQL
        ↓
resumes Table
        ↓
Resume History
        ↓
View Details / Delete
```

---

## 7. Resume Upload and PDF Processing

The application allows users to upload their resume in PDF format for analysis.

### 7.1 Resume Upload

The user selects a PDF resume from the frontend and starts the analysis.

The main frontend file is:

```text
src/main/resources/templates/index.html
```

### 7.2 PDF Text Extraction

After the PDF resume is uploaded, the application extracts readable text from the document.

The text extraction functionality is handled by:

```text
ResumeTextExtractor.java
```

### 7.3 Extracted Resume Content

The text extracted from the uploaded PDF is used for further resume analysis.

The application processes the extracted content to identify information such as:

* Technical skills
* Programming languages
* Tools and technologies
* Resume sections
* Project-related information
* Education-related information
* Contact information
* Other relevant resume content

The extracted content is passed to the appropriate analysis services, which use it to generate the ATS score, job match score, missing skills, job recommendations, strengths, and improvement suggestions.

### 7.4 PDF Processing Limitation

The current implementation is designed to process text-based PDF resumes.

If a PDF mainly contains scanned images instead of selectable text, the application may not be able to extract all resume information correctly.

This is because the current project does not include OCR (Optical Character Recognition).

For best results, users should upload a PDF containing selectable text rather than a scanned image-only document.

OCR-based processing can be considered as a future enhancement.

---

## 8. ATS Score Calculation

The application calculates an ATS-style resume score based on different sections and characteristics of the uploaded resume.

### 8.1 ATS Score Service

The ATS score calculation is handled by:

```text
ResumeScoreService.java
```

### 8.2 ATS Score Breakdown

The application calculates the ATS score out of 100 using the following categories:

| Category            | Maximum Score |
| ------------------- | ------------: |
| Technical Skills    |            40 |
| Resume Sections     |            20 |
| Projects            |            15 |
| Education           |            10 |
| Contact Information |             5 |
| Achievements        |            10 |
| **Total**           |       **100** |

Each category contributes to the overall ATS score.

The scores from all categories are added together to generate the final ATS score displayed on the frontend.

### 8.3 Technical Skills

The application checks the extracted resume text for recognized technical skills.

Examples of technical skills that can be detected include:

* Java
* JavaScript
* Python
* HTML
* CSS
* SQL
* Git
* GitHub
* React
* Spring Boot

The detected technical skills contribute to the **Technical Skills** portion of the ATS score.

The application also uses the detected skills for other analysis features such as job matching, missing skill identification, and job recommendations.

### 8.4 Resume Sections

The application checks the resume content for important sections that are commonly included in a professional resume.

Examples of sections considered include:

* Summary / Objective
* Skills
* Education
* Projects
* Experience
* Certifications
* Achievements

The presence of relevant resume sections contributes to the **Resume Sections** portion of the ATS score.

This helps evaluate whether the resume contains the important structural sections expected in a standard professional resume.

### 8.5 Other ATS Factors

In addition to technical skills and resume sections, the application considers other important resume components while calculating the ATS score.

These components include:

* Projects
* Education
* Contact Information
* Achievements

Each component contributes to the overall ATS score according to the configured scoring structure.

The combined score from all categories produces the final ATS score out of 100.

### 8.6 Example

For example, an analyzed resume may receive the following score:

```text
Technical Skills      → 32/40
Resume Sections       → 20/20
Projects              → 15/15
Education             → 10/10
Contact Information   → 5/5
Achievements          → 10/10
--------------------------------
Total                 → 92/100
```

---

## 9. Job Match Analysis

The application compares the skills detected in the resume with the skills required for the job role selected by the user.

The job matching functionality is handled by:

```text
JobMatchService.java
```

### 9.1 Job Role Selection

Before analyzing a resume, the user selects a target job role from the available options.

The currently supported job roles are:

* Java Developer
* Frontend Developer
* Software Developer
* Full Stack Developer
* Data Analyst

The selected role is used by the application to determine the required skills and calculate the job match score.

The selected job role is also stored with the resume analysis record in the database.

### 9.2 Required Skills

Each supported job role has a predefined set of required technical skills.

The application uses these required skills to compare the selected job role with the skills detected from the uploaded resume.

For example, the required skills for the **Software Developer** role include:

```text
Java
JavaScript
SQL
Git
GitHub
React
Spring Boot
```

### 9.3 Match Score Calculation

The job match score is calculated by comparing the required skills of the selected job role with the skills detected in the uploaded resume.

The basic calculation is:

```text
Job Match Score =
Matched Required Skills / Total Required Skills × 100
```

### 9.4 Missing Skills

The application identifies the required skills that are not detected in the uploaded resume for the selected job role.

For example:

```text
Required Skills:
Java
JavaScript
SQL
Git
GitHub
React
Spring Boot

Detected Skills:
Java
JavaScript
SQL
Git
GitHub

Missing Skills:
React
Spring Boot
```

### 9.5 Job Match Result

After comparing the resume skills with the required skills of the selected job role, the application generates a job match result.

The result includes:

* Selected job role
* Job match percentage
* Matched skills
* Missing skills

The selected job role and calculated job match score are also stored in the database as part of the resume analysis record.

The result is displayed on the frontend in the **Job Match Analysis** section.

### 9.6 Example

For example, suppose the user selects the **Software Developer** role.

The required skills are:

```text
Java
JavaScript
SQL
Git
GitHub
React
Spring Boot
```

---

## 10. Job Recommendations

The application provides job role recommendations based on the technical skills detected in the uploaded resume.

The recommendation functionality is handled by:

```text
JobRecommendationService.java
```

### 10.1 Recommendation Process

After the resume text is extracted, the application identifies the technical skills present in the resume.

These detected skills are compared with the skill requirements associated with different job roles.

The recommendation process follows this flow:

```text
Uploaded Resume
       ↓
Resume Text Extraction
       ↓
Skill Detection
       ↓
Detected Skills
       ↓
Comparison with Job Role Requirements
       ↓
Recommended Job Roles
```

### 10.2 Example

For example, if the uploaded resume contains the following skills:

```text
Java
JavaScript
SQL
HTML
CSS
Git
GitHub
```

### 10.3 Recommendation Result

The recommended job roles are displayed on the resume analysis result page after the resume has been processed.

The recommendation result is based on the technical skills detected in the uploaded resume.

The result is stored in the `recommendedJobs` field of the `Resume` entity.

The stored recommendations can be retrieved along with the other resume analysis details through the **Resume History** section.

The recommendation system is currently rule-based and does not use AI or machine learning.

---

## 11. Strengths and Improvement Suggestions

The application identifies strengths in the resume and provides suggestions for improvement based on the analyzed resume content.

### 11.1 Strengths

The application identifies positive aspects of the resume, such as:

* Knowledge of programming languages
* Database and SQL knowledge
* Version control knowledge
* Relevant technical skills
* Project experience
* Relevant educational background

The identified strengths are stored in the `strengths` field of the `Resume` entity.

### 11.2 Improvement Suggestions

The application also generates suggestions to help improve the resume.

Examples include:

* Learning relevant technologies for the selected job role
* Adding measurable achievements to projects
* Keeping project descriptions clear and concise
* Improving missing technical skills
* Adding relevant skills that are not currently detected

The suggestions are stored in the `suggestions` field of the `Resume` entity.

### 11.3 Result Display

The strengths and suggestions are displayed on the frontend after the resume analysis is completed.

They are also stored in the database so that they remain available in the **Resume History** and **View Details** sections.

The current implementation generates these results using rule-based logic rather than an AI or machine learning model.

---

## 12. Resume History and Record Management

The application maintains a history of previously analyzed resumes.

This feature allows users to view and manage their previous resume analysis records.

### 12.1 Resume History

After a resume is successfully analyzed, the analysis result is saved in the MySQL database.

The saved records are displayed in the **Resume History** section of the frontend.

The history contains information such as:

* Record ID
* Resume file name
* ATS score
* Selected job role
* Job match score
* Available actions

### 12.2 View Details

The **View Details** option allows the user to open the complete analysis of a previously analyzed resume.

The details can include:

* Resume file name
* ATS score
* Selected job role
* Job match score
* Detected skills
* Recommended jobs
* Missing skills
* Strengths
* Suggestions

The details are retrieved from the database and displayed in a modal on the frontend.

### 12.3 Delete Record

The **Delete** option allows the user to remove a previous resume analysis record from the history.

When a record is deleted, the corresponding database record is removed and it no longer appears in the Resume History section.

### 12.4 Data Persistence

Resume analysis records are stored in MySQL.

Therefore, the history remains available after refreshing the application, as long as the records have not been deleted.

The history functionality demonstrates the complete flow of:

```text
Resume Analysis
       ↓
Save to MySQL
       ↓
Resume History
       ↓
View Details / Delete
```

---

## 13. Frontend and User Interface

The application provides a web-based frontend through which users can upload resumes, select job roles, view analysis results, and manage resume history.

The main frontend file is:

```text
src/main/resources/templates/index.html
```

### 13.1 Frontend Technologies

The frontend of the application is developed using the following technologies:

* **HTML5** – Used to create the structure and content of the web page.
* **CSS3** – Used for styling, layout, responsive design, cards, buttons, tables, and other visual elements.
* **JavaScript** – Used to handle user interactions, resume analysis requests, displaying results, loading history, viewing details, and deleting records.
* **Thymeleaf** – Used as the Spring Boot template engine for serving the frontend page.

The main frontend file is:

```text
src/main/resources/templates/index.html
```

### 13.2 Main UI Sections

The application frontend is divided into different sections to make the resume analysis process easy to understand and use.

The main UI sections include:

* **Hero / Introduction Section** – Introduces the Resume Analyzer application.
* **Resume Upload Section** – Allows the user to select and upload a PDF resume.
* **Job Role Selection** – Allows the user to select the target job role.
* **Analyze Resume Button** – Starts the resume analysis process.
* **ATS Score Section** – Displays the overall ATS score and score breakdown.
* **Job Match Analysis** – Displays the selected job role, match percentage, and missing skills.
* **Skills Section** – Displays the technical skills detected from the resume.
* **Recommended Jobs Section** – Displays job roles recommended based on detected skills.
* **Strengths Section** – Displays strengths identified from the resume.
* **Suggestions Section** – Displays recommendations for improving the resume.
* **Resume History Section** – Displays previously analyzed resumes.
* **View Details Modal** – Displays complete details of a selected history record.

These sections are organized within the main `index.html` frontend page.

### 13.3 Resume Upload Interface

The Resume Upload section allows the user to provide a resume for analysis.

The user can:

1. Select a target job role.
2. Choose a PDF resume from the computer.
3. View the selected file name.
4. Click the **Analyze Resume** button to start the analysis.

The frontend uses a file input element that accepts PDF files:

```html
<input type="file" id="fileInput" accept=".pdf">
```

### 13.4 Analysis Result Interface

After the resume is successfully analyzed, the frontend displays the generated results in an organized format.

The analysis result includes:

* **ATS Score** – Displays the overall resume score out of 100.
* **ATS Score Breakdown** – Displays the score obtained in different categories.
* **Target Job Role** – Displays the job role selected by the user.
* **Job Match Score** – Displays the percentage match with the selected job role.
* **Detected Skills** – Displays the technical skills identified from the resume.
* **Missing Skills** – Displays skills that are not detected for the selected job role.
* **Recommended Jobs** – Displays job roles recommended based on the detected skills.
* **Strengths** – Displays positive aspects identified from the resume.
* **Suggestions** – Displays suggestions for improving the resume.

The result is displayed dynamically on the same frontend page after the backend successfully processes the uploaded resume.

The basic flow is:

```text
Resume Analysis Completed
          ↓
Backend Response
          ↓
JavaScript Processes Response
          ↓
Analysis Result Section Updated
          ↓
Results Displayed to User
```

### 13.5 Resume History Interface

The Resume History section displays previously analyzed resume records stored in the MySQL database.

Each history record displays information such as:

* Resume file name
* ATS score
* Selected job role
* Job match score
* Available actions

The user can perform the following actions:

* **View Details** – Opens a modal containing the complete analysis result.
* **Delete** – Removes the selected analysis record from the history.

The history data is loaded from the backend and displayed dynamically on the frontend.

The basic flow is:

```text
MySQL Database
       ↓
Resume History Request
       ↓
Spring Boot Backend
       ↓
Resume Records
       ↓
JavaScript
       ↓
History Table
```

### 13.6 Responsive Design

The frontend includes responsive CSS rules to make the application usable on different screen sizes.

The responsive design adjusts elements such as:

* Layout and spacing
* Cards and sections
* Buttons
* Tables
* Upload area
* Analysis result sections
* Resume History section

Media queries are used in the CSS to adjust the layout for smaller screen sizes.

The goal is to keep the application readable and easy to use on both desktop and smaller screens.

### 13.7 User Interaction

JavaScript is used to handle the main user interactions in the application.

The frontend JavaScript handles tasks such as:

* Selecting a resume file.
* Displaying the selected file name.
* Selecting a target job role.
* Starting the resume analysis.
* Sending the resume and selected role to the backend.
* Receiving and displaying the analysis result.
* Loading resume history.
* Opening the View Details modal.
* Deleting a history record.
* Updating the displayed analysis information.

The general interaction flow is:

```text
User Action
     ↓
JavaScript Event
     ↓
HTTP Request
     ↓
Spring Boot Backend
     ↓
Processing
     ↓
Backend Response
     ↓
JavaScript
     ↓
Updated UI
```

---

## 14. Backend API and Controllers

The backend of the Resume Analyzer is built using Spring Boot and follows a controller-based architecture.

Controllers receive requests from the frontend, call the appropriate application services, and return the required response.

The main controller classes are:

* `HomeController`
* `ResumeController`
* `JobMatchController`
* `JobRoleController`

These controllers handle different parts of the application's functionality such as loading the home page, uploading and analyzing resumes, job matching, and job-role related operations.

### 14.1 HomeController

The `HomeController` is responsible for handling the application's main page.

Its primary purpose is to map the root URL of the application to the `index.html` Thymeleaf template.

Main responsibility:

* Opens the Resume Analyzer home page.
* Maps the root application URL to the frontend page.
* Returns the `index` view.

The controller provides the entry point for users when they open the application in a browser.

The basic flow is:

```text
User opens application
        ↓
HomeController
        ↓
index.html
        ↓
Resume Analyzer UI
```

### 14.2 ResumeController

The `ResumeController` is the main controller responsible for handling resume upload and analysis requests.

It receives the upload request and calls the appropriate services for resume analysis, ATS scoring, job matching, recommendations, and suggestions.

Main responsibilities include:

* Receiving the uploaded PDF resume from the frontend.
* Accepting the selected target job role.
* Passing the resume for text extraction and analysis.
* Calling the ATS score calculation logic.
* Calling the job match analysis logic.
* Obtaining missing skills, strengths, suggestions, and job recommendations.
* Saving the analyzed resume information into the database.
* Returning the analysis result to the frontend.
* Supporting resume history-related operations such as retrieving and deleting saved records.

The general request flow is:

```text
User uploads Resume
        ↓
ResumeController
        ↓
Services
        ↓
PDF Text Extraction
        ↓
Resume Analysis
        ↓
ATS Score + Job Match
        ↓
Recommendations + Suggestions
        ↓
MySQL Database
        ↓
Response to Frontend
```

### 14.3 JobMatchController

The `JobMatchController` is responsible for handling job-match related requests.

It works with the job matching logic to compare the skills detected in a resume with the skills required for the selected job role.

Main responsibilities include:

* Receiving the selected job role.
* Processing job-match related requests.
* Comparing resume skills with required job skills.
* Calculating the job match percentage.
* Identifying missing skills for the selected role.
* Returning job-match information to the frontend.

The general flow is:

```text
Resume Skills
      ↓
Selected Job Role
      ↓
JobMatchController
      ↓
Required Job Skills
      ↓
Skill Comparison
      ↓
Match Percentage
      ↓
Missing Skills
      ↓
Frontend Result
```

### 14.4 JobRoleController

The `JobRoleController` handles job-role related requests in the application.

It works with the job-role functionality to provide information about the supported roles available in the Resume Analyzer.

Main responsibilities include:

* Handling job-role related requests.
* Working with the job-role service.
* Providing supported job roles to the application.
* Connecting job-role information with the frontend when required.

The application currently supports the following job roles:

* Java Developer
* Frontend Developer
* Software Developer
* Full Stack Developer
* Data Analyst

The general flow is:

```text
Frontend Request
      ↓
JobRoleController
      ↓
JobRoleService
      ↓
Supported Job Roles
      ↓
Response
      ↓
Frontend
```

### 14.5 Service Layer

The service layer contains the main business logic of the Resume Analyzer application.

It keeps the processing logic separate from the controllers and helps organize different operations into dedicated service classes.

The main service classes are:

* `JobMatchService`
* `JobRecommendationService`
* `JobRoleService`
* `ResumeQualityService`
* `ResumeScoreService`
* `ResumeTextExtractor`

Each service has a specific responsibility.

| Service Class              | Main Responsibility                                           |
| -------------------------- | ------------------------------------------------------------- |
| `JobMatchService`          | Calculates job match percentage and identifies missing skills |
| `JobRecommendationService` | Generates job recommendations based on detected skills        |
| `JobRoleService`           | Manages supported job roles and role-related information      |
| `ResumeQualityService`     | Handles resume quality-related analysis                       |
| `ResumeScoreService`       | Calculates the ATS/resume score and its breakdown             |
| `ResumeTextExtractor`      | Extracts text from uploaded PDF resumes                       |

The general architecture is:

```text
Controller
    ↓
Service Layer
    ↓
Business Logic
    ↓
Repository / Database
```

### 14.6 Repository Layer

The repository layer is responsible for communicating with the MySQL database.

The application uses Spring Data JPA to perform database operations without writing SQL queries for every basic operation.

The main repository class is:

* `ResumeRepository`

The `ResumeRepository` works with the `Resume` entity and provides database operations such as:

* Saving resume analysis records.
* Retrieving stored resume records.
* Finding resume history.
* Deleting resume records.
* Performing other required database operations through Spring Data JPA.

The general flow is:

```text
Service Layer
      ↓
ResumeRepository
      ↓
JPA / Hibernate
      ↓
MySQL Database
      ↓
resumes Table
```

### 14.7 Entity Layer

The entity layer represents the structure of data stored in the database.

The main entity class in the application is:

* `Resume`

The `Resume` entity is mapped to the `resumes` table in the MySQL database using JPA annotations.

It contains information related to an analyzed resume, including:

* Resume ID
* File name
* ATS score
* Detected skills
* Missing skills
* Recommended jobs
* Strengths
* Improvement suggestions
* Selected job role
* Job match score

The basic relationship is:

```text
Resume Entity
      ↓
JPA / Hibernate
      ↓
resumes Table
      ↓
MySQL Database
```

### 14.8 Service-to-Controller Flow

The application follows a structured flow in which controllers receive requests and services perform the required business logic.

The main flow can be represented as:

```text
Frontend
   ↓
Controller
   ↓
Service Layer
   ↓
Repository
   ↓
MySQL Database
```

---

## 15. Resume Analysis Complete Flow

The Resume Analyzer processes a resume through multiple steps, starting from PDF upload and ending with the display and storage of the analysis results.

The complete analysis flow is:

```text
1. User opens the application
          ↓
2. User selects a PDF resume
          ↓
3. User selects a target job role
          ↓
4. User clicks the Analyze Resume button
          ↓
5. Frontend sends the resume and selected role to the backend
          ↓
6. ResumeController receives the request
          ↓
7. PDFBox extracts text from the PDF
          ↓
8. Resume content is analyzed
          ↓
9. Resume skills are detected
          ↓
10. ATS score is calculated
          ↓
11. Selected job role is evaluated
          ↓
12. Job match percentage is calculated
          ↓
13. Missing skills are identified
          ↓
14. Job recommendations are generated
          ↓
15. Strengths and improvement suggestions are generated
          ↓
16. Analysis result is saved in MySQL
          ↓
17. Backend sends the result to the frontend
          ↓
18. Analysis result is displayed to the user
          ↓
19. Resume appears in Resume History
```

### 15.1 Step-by-Step Processing

The resume analysis process is completed through a series of backend and frontend operations.

**Step 1 — Resume Upload**

The user selects a PDF resume from the frontend and starts the analysis process.

**Step 2 — Target Role Selection**

The user selects a target job role from the available options.

**Step 3 — Request Submission**

The frontend sends the uploaded resume and selected job role to the backend.

**Step 4 — PDF Text Extraction**

The backend processes the uploaded PDF using Apache PDFBox and extracts the readable text from the resume.

**Step 5 — Resume Content Analysis**

The extracted resume text is analyzed to identify skills, resume sections, projects, education, contact information, and other relevant content.

**Step 6 — ATS Score Calculation**

The application calculates the ATS score based on the defined scoring criteria and generates the score breakdown.

**Step 7 — Job Match Analysis**

The detected resume skills are compared with the required skills for the selected job role.

**Step 8 — Missing Skills Identification**

The application identifies the required skills that were not detected in the resume.

**Step 9 — Job Recommendations**

Based on the detected skills, the application generates relevant job recommendations.

**Step 10 — Strengths and Suggestions**

The application identifies resume strengths and generates suggestions for improving the resume.

**Step 11 — Database Storage**

The complete analysis result is stored in the MySQL `resumes` table.

**Step 12 — Result Display**

The frontend displays the analysis results, including ATS score, job match score, skills, missing skills, recommendations, strengths, and suggestions.

**Step 13 — Resume History**

The saved analysis becomes available in the Resume History section, where the user can view its details or delete the record.

### 15.2 Example Analysis Flow

The following example shows how a resume is processed when a user selects the `Java Developer` role.

```text
Uploaded Resume
      ↓
Extracted Skills:
Java, JavaScript, Python, HTML, CSS, SQL, Git, GitHub
      ↓
Selected Role:
Java Developer
      ↓
ATS Score:
92 / 100
      ↓
Required Job Skills Compared
      ↓
Matched Skills:
Java, Git, GitHub, SQL
      ↓
Missing Job Skill:
Spring Boot
      ↓
Job Match:
80%
      ↓
Job Recommendations Generated
      ↓
Strengths and Suggestions Generated
      ↓
Result Saved in MySQL
      ↓
Result Displayed on Frontend
```

### 15.3 Analysis Result Storage Flow

After the resume analysis is completed, the generated results are stored in the MySQL database.

The application stores the analysis as a `Resume` entity, which is mapped to the `resumes` table.

The storage flow is:

```text
Resume Analysis Completed
          ↓
Resume Entity Created
          ↓
ResumeRepository
          ↓
JPA / Hibernate
          ↓
MySQL Database
          ↓
resumes Table
```

### 15.4 Result Display Flow

After the backend completes the resume analysis and saves the result in the database, the analysis response is sent back to the frontend.

The frontend processes the response and displays the information in different sections of the user interface.

The result display flow is:

```text
Backend Analysis Completed
          ↓
Analysis Response
          ↓
Frontend JavaScript
          ↓
ATS Score
          ↓
Job Match Analysis
          ↓
Detected Skills
          ↓
Missing Skills
          ↓
Job Recommendations
          ↓
Strengths
          ↓
Improvement Suggestions
```

### 15.5 Complete End-to-End Flow

The complete Resume Analyzer workflow connects the frontend, backend services, database, and result display into one continuous process.

```text
                         USER
                           ↓
                  Select PDF Resume
                           ↓
                  Select Target Role
                           ↓
                  Analyze Resume
                           ↓
                      FRONTEND
                           ↓
                  ResumeController
                           ↓
                PDF Text Extraction
                           ↓
                 Resume Analysis
                           ↓
              ┌────────────┴────────────┐
              ↓                         ↓
       ATS Score                  Job Match
              ↓                         ↓
       Resume Quality             Missing Skills
              ↓                         ↓
              └────────────┬────────────┘
                           ↓
                  Job Recommendations
                           ↓
                Strengths & Suggestions
                           ↓
                    Resume Entity
                           ↓
                  ResumeRepository
                           ↓
                  MySQL Database
                           ↓
                    Analysis Result
                           ↓
                      FRONTEND
                           ↓
                 Display Final Result
                           ↓
                  Resume History
```

---

## 16. Error Handling and Validation

The application includes basic validation and error handling to prevent invalid input and provide a better user experience.

Validation is mainly applied to the resume upload process and user selections.

The application handles important conditions such as:

* A resume file should be selected before analysis.
* The frontend accepts PDF files for resume analysis.
* The target job role should be selected.
* The uploaded file should be within the configured file-size limit.
* The backend should be able to process the uploaded PDF.
* Database operations should complete successfully.

When an invalid input or processing problem occurs, the application provides an appropriate message instead of continuing with invalid data.

The general validation flow is:

```text
User Input
    ↓
Frontend Validation
    ↓
Backend Validation / Processing
    ↓
Valid Input?
   ↙       ↘
 Yes       No
  ↓         ↓
Process    Error Message
Request
```

### 16.1 File Upload Validation

The frontend accepts PDF files for resume analysis, and the backend processes the uploaded PDF.

The upload process checks the following conditions:

* A file must be selected before analysis.
* The resume should be in PDF format.
* The uploaded file must comply with the configured file-size limit.
* The backend must be able to read and process the PDF.
* The application should not continue with an invalid or missing file.

The configured upload limits are:

```text
Maximum File Size: 10 MB
Maximum Request Size: 10 MB
```

### 16.2 Target Job Role Validation

The application allows the user to select a target job role before starting the resume analysis.

The selected role is used during job match analysis to compare the resume skills with the required skills for that role.

The currently supported roles are:

* Java Developer
* Frontend Developer
* Software Developer
* Full Stack Developer
* Data Analyst

The basic flow is:

```text
User Selects Job Role
        ↓
Selected Role Sent to Backend
        ↓
Job Role Processing
        ↓
Required Skills Identified
        ↓
Resume Skills Compared
        ↓
Job Match Result Generated
```

### 16.3 Backend Error Handling

The backend handles errors that may occur during resume processing and database operations.

Potential backend problems include:

* Invalid or missing uploaded file.
* PDF text extraction failure.
* Unsupported or unreadable PDF content.
* Invalid request data.
* Database connection or persistence problems.
* Unexpected errors during resume analysis.

The general backend flow is:

```text
Request Received
      ↓
Validate Request
      ↓
Process Resume
      ↓
Error Occurred?
   ↙          ↘
 No           Yes
 ↓             ↓
Continue     Handle Error
 ↓             ↓
Save Result  Return Error Response
 ↓
Return Result
```

### 16.4 Database Error Handling

The application uses MySQL with Spring Data JPA and Hibernate for database operations.

Database-related problems may occur during operations such as saving, retrieving, or deleting resume analysis records.

Possible database issues include:

* Database server not running.
* Incorrect database connection details.
* Authentication or database configuration problems.
* Failure while saving a resume analysis record.
* Failure while retrieving resume history.
* Failure while deleting a stored record.

The database operation flow is:

```text
Application Request
        ↓
Service Layer
        ↓
ResumeRepository
        ↓
JPA / Hibernate
        ↓
MySQL
        ↓
Database Operation
        ↓
Success / Error
```

### 16.5 User-Facing Error Messages

The application provides feedback to the user when an operation cannot be completed successfully.

User-facing messages help the user understand whether an operation was successful or requires correction.

Examples of situations that may require a message include:

* No resume file selected.
* Invalid file type.
* File upload or processing failure.
* Resume analysis failure.
* Unable to retrieve resume history.
* Unable to delete a history record.

The general flow is:

```text
User Performs Action
        ↓
Application Processes Request
        ↓
Success?
   ↙          ↘
 Yes          No
  ↓            ↓
Show Result   Show Error Message
```

### 16.6 Validation and Error Handling Summary

The application uses basic validation and error handling across the resume analysis workflow.

The main areas covered are:

* Resume file validation.
* Target job role selection.
* PDF processing.
* Backend request processing.
* Database operations.
* User-facing success and error messages.

The overall flow is:

```text
User Input
    ↓
Input Validation
    ↓
Backend Processing
    ↓
Database Operation
    ↓
Result / Error Response
    ↓
Frontend Feedback
```

---

## 17. Testing and Verification

The Resume Analyzer was tested to verify that its major features work correctly from the user interface to the backend and database.

Testing focused on the application's core functionality, including:

* Application startup.
* Resume PDF upload.
* Resume text extraction.
* ATS score calculation.
* Target job role selection.
* Job match calculation.
* Missing skill identification.
* Job recommendations.
* Strengths and improvement suggestions.
* Saving analysis results in MySQL.
* Resume History retrieval.
* Viewing saved resume details.
* Deleting history records.
* Data persistence after page refresh.

The application was tested using actual PDF resume files and different target job roles.

The testing process helped verify that the major frontend, backend, and database components work together correctly.

### 17.1 Application Startup Test

The application was started successfully using IntelliJ IDEA.

The following components were verified:

* Spring Boot application started successfully.
* Java 25.0.2 was used.
* MySQL database connection was established.
* Application ran on port `8080`.
* The Resume Analyzer home page loaded successfully.

This confirmed that the basic application configuration and database connectivity were working correctly.

### 17.2 Resume Upload Test

The resume upload functionality was tested using PDF resume files.

The test verified that:

* A PDF resume could be selected successfully.
* The selected file was accepted by the application.
* The resume was uploaded successfully.
* The analysis process started after clicking the Analyze Resume button.

The upload functionality worked as expected during testing.

### 17.3 PDF Text Extraction Test

The PDF text extraction functionality was tested using a resume PDF containing readable text.

The test verified that:

* Text was extracted from the uploaded PDF.
* Resume skills were detected from the extracted content.
* Resume information was successfully passed to the analysis process.

Apache PDFBox was used for PDF text extraction.

The text extraction worked successfully for the tested text-based PDF resumes.

### 17.4 ATS Score Test

The ATS score calculation was tested using uploaded resume files.

The test verified that:

* An ATS score was generated successfully.
* The score was displayed out of 100.
* The ATS score breakdown was displayed correctly.
* The score included technical skills, resume sections, projects, education, contact information, and achievements.

Example tested result:

```text
ATS Score: 92 / 100
```

### 17.5 Job Match Test

The job match functionality was tested using different target job roles.

The test verified that:

* A target job role could be selected.
* Resume skills were compared with the required skills for that role.
* A job match percentage was generated.
* Missing job skills were identified.

Example tested result:

```text
Target Role: Java Developer
Job Match: 80%
Missing Job Skill: Spring Boot
```

### 17.6 Missing Skills and Recommendations Test

The missing skills and job recommendation features were tested using analyzed resumes.

The test verified that:

* Missing skills were identified based on the selected role.
* Job recommendations were generated from detected resume skills.
* Strengths were displayed.
* Improvement suggestions were generated.

The results were displayed correctly in the analysis section.

These features worked successfully during testing.

### 17.7 Database Storage Test

The database storage functionality was tested after completing resume analysis.

The test verified that:

* Analysis results were saved in MySQL.
* A unique record ID was generated.
* ATS score and job match score were stored.
* Selected job role and resume details were stored.
* Skills, missing skills, recommendations, strengths, and suggestions were saved.

The stored records were successfully retrieved from the Resume History section.

### 17.8 Resume History Test

The Resume History functionality was tested after saving multiple resume analysis records.

The test verified that:

* Saved resume records appeared in the History section.
* File name, ATS score, target role, and job match score were displayed.
* Previous analysis records remained available after refreshing the page.

The Resume History functionality worked successfully during testing.

### 17.9 View and Delete Test

The View and Delete functionality was tested using saved resume history records.

The test verified that:

* The View button opened the complete analysis details.
* Resume information and analysis results were displayed correctly.
* The Delete button removed the selected history record.
* The deleted record did not reappear after refreshing the page.

Both View and Delete operations worked successfully during testing.

### 17.10 Refresh and Data Persistence Test

The application was refreshed after completing resume analysis and saving records.

The test verified that:

* Saved history records remained available after refresh.
* Analysis data was retrieved correctly from MySQL.
* Deleted records remained deleted after refresh.

This confirmed that resume analysis data was being persisted correctly in the database.

### 17.11 Overall Testing Result

The major features of the Resume Analyzer were tested successfully.

The testing covered:

* Application startup
* Resume upload
* PDF text extraction
* ATS score calculation
* Job matching
* Missing skills and recommendations
* Database storage
* Resume History
* View and Delete operations
* Data persistence after refresh

The tested core functionality worked as expected during the verification process.

---

## 18. Project Limitations

The current version of the Resume Analyzer has some limitations:

* It currently uses rule-based analysis instead of AI or machine learning.
* PDF text extraction may not work properly for scanned image-only resumes because OCR is not implemented.
* Job matching depends on the predefined skills for each supported job role.
* The application currently supports a limited number of job roles.

These limitations can be addressed through future enhancements.

---

## 19. Future Enhancements

The project can be improved in the future by adding:

* AI/ML-based resume analysis.
* More job roles and skill sets.
* OCR support for scanned resumes.
* Job recommendations from real job portals.
* User login and profile management.
* Resume improvement suggestions using AI.
* More detailed reports and analytics.

These features can make the application more advanced and useful for real-world use.

---

## 20. Security and Configuration

The project follows basic security practices for its current development version.

* The database password is not hard-coded in the source code.
* The password is provided through the `DB_PASSWORD` environment variable.
* `.gitignore` prevents sensitive and unnecessary files from being committed.
* The `uploads/` folder is excluded from Git.
* IDE and build-generated files are also excluded from Git.

These practices help keep sensitive configuration and unnecessary files out of the GitHub repository.

---

## 21. How to Run the Project

Follow these steps to run the Resume Analyzer locally:

1. Open the project in IntelliJ IDEA.
2. Make sure MySQL is running.
3. Create the `resume_analyzer` database.
4. Set the `DB_PASSWORD` environment variable.
5. Run `ResumeAnalyzerApplication`.
6. Open the application in a browser using:

```text
http://localhost:8080
```

7. Upload a PDF resume and select a target job role.
8. Click **Analyze Resume** to view the results.

---

## 22. GitHub and Version Control

Git and GitHub were used to manage and store the project source code.

The project was initialized as a Git repository and pushed to GitHub.

Git was used for:

* Tracking project changes.
* Creating commits.
* Managing the project version history.
* Synchronizing local changes with GitHub.

The GitHub repository contains the source code and project documentation.

Repository:

`https://github.com/sakshisingh700/ResumeAnalyzer.git`

---

## 23. Learning Outcomes

By developing this project, the following concepts were practiced:

* Java and Spring Boot development.
* REST API and controller-based architecture.
* Spring Data JPA and Hibernate.
* MySQL database integration.
* PDF text extraction using Apache PDFBox.
* HTML, CSS, and JavaScript frontend development.
* Git and GitHub version control.
* Connecting frontend, backend, and database components.
* Testing and debugging a complete web application.

---

## 24. Project Summary

The Resume Analyzer is a Java and Spring Boot web application that analyzes PDF resumes and provides useful resume insights.

The application can:

* Calculate an ATS score.
* Detect resume skills.
* Match skills with a selected job role.
* Identify missing skills.
* Recommend suitable job roles.
* Provide strengths and improvement suggestions.
* Store and manage previous analysis results.

The project demonstrates the integration of frontend, backend, PDF processing, business logic, and MySQL database operations in a single web application.

The current version is rule-based and provides a foundation for adding AI-based features in the future.
