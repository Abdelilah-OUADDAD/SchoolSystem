

# 🎓 School Management System

A comprehensive web-based platform for managing educational institutions. Built with modern web technologies to streamline administrative tasks, student management, teacher coordination, and pedagogical content organization.


## ✨ Features

### 📊 Dashboard & Analytics
- **Real-time Statistics**: Overview of Users, Students, Teachers, and Pedagogies
- **Distribution Visualization**: Visual progress bars showing student/teacher/pedagogy ratios
- **Recent Activity Feed**: Track latest system updates and actions
- **Quick Actions**: Fast access to add Students, Teachers, or Pedagogical content

### 👥 User Management
- **Multi-role System**: Admin, Teacher, Student access levels
- **Secure Authentication**: Password protection with visibility toggle
- **User Profiles**: Complete user information management
- **Account Creation**: Easy onboarding with Nom, Prénom, Email, and User Type

### 🎓 Student Management
- **Student Registry**: Complete list with ID, Name, Department, Year, and Group
- **Department Organization**:
  - Réseau (Network)
  - Développement (Development)
  - Gestion (Management)
  - Marketing
  - Électricité (Electricity)
- **Year Levels**: 1ère Année, 2ème Année
- **Group Management**: Organized group assignments per year
- **CRUD Operations**: Create, Read, Update, Delete student records
- **Visual Indicators**: Color-coded badges for departments and years
- **Search & Filter**: Easy navigation through student list

### 👨‍🏫 Teacher Management
- **Teacher Profiles**: Professional information and assignments
- **Subject Assignment**: Link teachers to specific courses
- **Department Association**: Organize by academic departments

### 📚 Pedagogy Module
- **Course Management**: Complete pedagogical content organization
- **Detailed Records**:
  - **Title**: Course name (e.g., "Introduction Java", "Spring Boot API")
  - **Description**: Course overview and content summary
  - **Teacher Assignment**: Linked instructor
  - **Subject Category**: Informatique, Base de Données, Réseaux, Physique, Mathématiques, Anglais, Français
  - **Year Level**: Target academic year
  - **Learning Objectives**: Specific goals and outcomes
- **Search Functionality**: Quick search by course title
- **Action Buttons**: Edit, view details, and delete with intuitive icons

- ## 🛠️ Technology Stack

| Layer    | Technology                                        |
| -------- | ------------------------------------------------- |
| Backend  | Spring Boot 3.x, Spring Security, Spring Data JPA |
| Frontend | HTML5, CSS3, Bootstrap, JavaScript                |
| Database | MySQL / PostgreSQL / H2 (dev)                     |
| Build    | Maven                                             |
| Security | JWT + Session                                     |

✨ Features

| Module             | Description                                  |
| ------------------ | -------------------------------------------- |
| 📊 **Dashboard**   | Stats cards, activity feed, quick actions    |
| 👥 **Users**       | Multi-role (Admin/Teacher/Student), JWT auth |
| 🎓 **Students**    | CRUD, departments, years, groups             |
| 👨‍🏫 **Teachers** | Profile management, subject assignment       |
| 📚 **Pedagogies**  | Course content, objectives, search           |

🔗 API Endpoints
| Endpoint          | Method              | Description        |
| ----------------- | ------------------- | ------------------ |
| `/api/users`      | GET/POST            | User management    |
| `/api/students`   | GET/POST/PUT/DELETE | Student CRUD       |
| `/api/teachers`   | GET/POST            | Teacher management |
| `/api/pedagogies` | GET/POST/PUT/DELETE | Course content     |
| `/api/auth/login` | POST                | JWT authentication |


🔐 Security
- Spring Security with JWT
- Role-based access (ADMIN, TEACHER, STUDENT)
- Password encryption (BCrypt)
