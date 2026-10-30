This is the er diagram

<img width="3296" height="4014" alt="mermaid-diagram" src="https://github.com/user-attachments/assets/f032b893-8859-4e5f-a750-ea4d443b341d" />

## Service module

The `com.learning.services` package provides create/read/update/delete operations for all
entities in the diagram. Services validate input and related entity IDs before storing
records in the in-memory repositories in `com.learning.repository`.

Create one `LearningPlatformServices` instance to share repositories across the services:

```java
LearningPlatformServices services = new LearningPlatformServices();
services.getUserService().save(new Instructor(1, "Alex", "alex@example.com", "password"));
services.getCourseService().save(
    new Course(1, 1, "Java Basics", "Programming", "Beginner", 25.0));
```

IDs are assigned by the caller and must be positive. The in-memory data is held only for
the lifetime of the `LearningPlatformServices` instance; it is not persisted to a database.

## Command-line interface

Each service has its own CLI class in `src/com/learning/CLI`:

- `UserCLI`, `CourseCLI`, `EnrollmentCLI`, `SectionCLI`, and `LessonCLI`
- `PaymentCLI`, `ReviewCLI`, `CertificateCLI`, and `InstructorEarningCLI`
- `LessonProgressCLI` and `QuizAttemptCLI`

Compile the Java sources and launch the menu from PowerShell at the repository root:

```powershell
$sourceFiles = Get-ChildItem -Path .\src -Recurse -Filter *.java |
    ForEach-Object { $_.FullName }
javac -d .\out $sourceFiles
java -cp .\out com.learning.CLI.Main
```

Each service CLI provides save (create or replace by ID), list, find, and delete actions and
uses the service-layer validation. Data is held in memory and is discarded when the process
exits.
