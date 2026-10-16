# Resume Analyzer & Job Recommendation System

## Project Overview

Resume Analyzer is a web-based application developed using Java and Spring Boot that helps users evaluate their resumes and identify suitable job opportunities based on their skills.

The system extracts text from uploaded PDF resumes, calculates an ATS-style compatibility score, identifies technical skills, matches resumes with selected job roles, and provides personalized improvement suggestions.

## Key Features

- **Resume Upload & PDF Processing:** Upload PDF resumes and extract their text for analysis.
- **ATS Score Analysis:** Calculate a resume compatibility score using predefined evaluation rules.
- **Skill Detection:** Identify technical skills mentioned in the resume.
- **Job Role Matching:** Compare detected skills with the requirements of the selected job role.
- **Missing Skills Analysis:** Highlight skills that may be needed for the target role.
- **Job Recommendations:** Suggest suitable job roles based on the detected skills.
- **Improvement Suggestions:** Help users identify areas where their resumes can be improved.
- **Analysis History:** Store and view previous resume analysis records using MySQL.

## Technology Stack

- **Backend:** Java, Spring Boot
- **Frontend:** HTML, CSS, Thymeleaf
- **Database:** MySQL
- **PDF Processing:** Apache PDFBox
- **Build Tool:** Maven
- **Version Control:** Git and GitHub

## How It Works

1. The user uploads a PDF resume and selects a target job role.
2. The application extracts text from the resume.
3. Predefined rules identify technical skills and evaluate resume content.
4. The system calculates the ATS-style score and job match score.
5. The results include detected skills, missing skills, recommended roles, and improvement suggestions.
6. Analysis records are stored in MySQL for history tracking.


## Project Documentation

For detailed information about the project architecture, implementation, features, workflow, and technical details, see [`PROJECT_DOCUMENTATION.md`](PROJECT_DOCUMENTATION.md).

## Author

**Sakshi Singh**

MCA Student | Aspiring Software Developer

