# Git Setup Guide for Spring Boot Projects

This guide documents the complete process of setting up a Spring Boot project with Git and pushing it to GitHub.

## Prerequisites

- Git installed on your system
- GitHub account
- Spring Boot project ready to commit

## Step-by-Step Process

### 1. Initialize Git Repository

```bash
# Navigate to your project directory
cd /path/to/your/project

# Initialize git repository
git init
```

**Expected Output:**
```
Initialized empty Git repository in /path/to/your/project/.git/
```

### 2. Create .gitignore File

Create a comprehensive `.gitignore` file for Spring Boot projects:

```bash
# Create .gitignore file
touch .gitignore
```

**Content for .gitignore:**
```gitignore
# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# virtual machine crash logs
hs_err_pid*
replay_pid*

# Maven
target/
pom.xml.tag
pom.xml.releaseBackup
pom.xml.versionsBackup
pom.xml.next
release.properties
dependency-reduced-pom.xml
buildNumber.properties
.mvn/timing.properties
.mvn/wrapper/maven-wrapper.jar

# Gradle
.gradle
build/
!gradle/wrapper/gradle-wrapper.jar
!**/src/main/**/build/
!**/src/test/**/build/

# IntelliJ IDEA
.idea/
*.iws
*.iml
*.ipr
out/
!**/src/main/**/out/
!**/src/test/**/out/

# Eclipse
.apt_generated
.classpath
.factorypath
.project
.settings
.springBeans
.sts4-cache
bin/
!**/src/main/**/bin/
!**/src/test/**/bin/

# NetBeans
/nbproject/private/
/nbbuild/
/dist/
/nbdist/
/.nb-gradle/

# VS Code
.vscode/

# Mac
.DS_Store

# Windows
Thumbs.db
ehthumbs.db
Desktop.ini

# Application specific
application-local.properties
application-dev.properties
application-prod.properties
*.env

# Temporary files
*.tmp
*.temp
```

### 3. Configure Git (if not already done)

```bash
# Set your username and email
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

# Verify configuration
git config --global user.name
git config --global user.email
```

### 4. Add Files to Git

```bash
# Add all files to staging area
git add .

# Check status
git status
```

### 5. Make Initial Commit

```bash
# Commit with descriptive message
git commit -m "Initial commit: Spring Boot API with Swagger/OpenAPI integration"
```

### 6. Rename Branch to Main (Modern Standard)

```bash
# Rename master branch to main
git branch -M main
```

### 7. Create GitHub Repository

**Option A: Via GitHub CLI (if installed)**
```bash
# Install GitHub CLI first if needed
# macOS: brew install gh
# Windows: winget install GitHub.cli

# Create repository
gh repo create SampleAPI --public --description "Spring Boot API with Swagger/OpenAPI integration"
```

**Option B: Manual Creation**
1. Go to https://github.com/new
2. Repository name: `SampleAPI`
3. Description: `Spring Boot API with Swagger/OpenAPI integration`
4. Choose Public or Private
5. **DO NOT** check "Add a README file"
6. **DO NOT** check "Add .gitignore"
7. **DO NOT** check "Choose a license"
8. Click "Create repository"

### 8. Add Remote Repository

```bash
# Add GitHub as remote origin
git remote add origin https://github.com/YourUsername/SampleAPI.git

# Verify remote
git remote -v
```

### 9. Push to GitHub

```bash
# Push and set upstream
git push -u origin main
```

## Troubleshooting Common Issues

### Issue 1: Push Rejected - Remote Contains Work

**Error:**
```
! [rejected]        main -> main (fetch first)
error: failed to push some refs to 'https://github.com/YourUsername/SampleAPI.git'
```

**Solution:**
```bash
# Configure git to use merge strategy
git config pull.rebase false

# Pull remote changes
git pull origin main --allow-unrelated-histories

# Commit the merge
git commit -m "Merge remote repository with local project"

# Push again
git push -u origin main
```

### Issue 2: Merge Conflict During Pull

**Error:**
```
hint: You have divergent branches and need to specify how to reconcile them.
fatal: Need to specify how to reconcile divergent branches.
```

**Solution:**
```bash
# Set merge strategy
git config pull.rebase false

# Pull with allow-unrelated-histories
git pull origin main --allow-unrelated-histories

# If editor opens, save and exit
# Then commit the merge
git commit -m "Merge remote repository with local project"
```

### Issue 3: Authentication Issues

**Error:**
```
remote: Support for password authentication was removed on August 13, 2021.
```

**Solution:**
1. Use Personal Access Token (PAT)
2. Or set up SSH keys
3. Or use GitHub CLI authentication

```bash
# Using GitHub CLI
gh auth login

# Or configure credential helper
git config --global credential.helper store
```

## Best Practices

### 1. Commit Messages
- Use descriptive commit messages
- Start with a verb (Add, Fix, Update, etc.)
- Keep under 50 characters for the first line

**Good Examples:**
```bash
git commit -m "Add Car API endpoints with Swagger documentation"
git commit -m "Fix port configuration in application.properties"
git commit -m "Update OpenAPI configuration for better documentation"
```

### 2. Branch Naming
- Use `main` instead of `master` (modern standard)
- Use descriptive branch names for features

```bash
# Create feature branch
git checkout -b feature/add-motorcycle-api

# Create bugfix branch
git checkout -b bugfix/fix-port-configuration
```

### 3. Regular Commits
- Commit frequently with small, logical changes
- Don't commit broken code
- Test before committing

### 4. .gitignore Maintenance
- Keep .gitignore updated as project grows
- Add new file types as needed
- Remove entries that are no longer needed

## Useful Git Commands

```bash
# Check status
git status

# View commit history
git log --oneline

# View remote repositories
git remote -v

# View branches
git branch -a

# Switch branches
git checkout branch-name

# Create and switch to new branch
git checkout -b new-branch-name

# Merge branch into main
git checkout main
git merge feature-branch-name

# Delete branch
git branch -d branch-name

# View file changes
git diff

# View staged changes
git diff --cached
```

## Next Steps After Repository Setup

1. **Add README.md** - Document your project
2. **Set up GitHub Actions** - CI/CD pipeline
3. **Add Issues template** - For bug reports and feature requests
4. **Set up branch protection** - Require reviews for main branch
5. **Add contributing guidelines** - If open source

## Example README.md Template

```markdown
# SampleAPI

Spring Boot API with Swagger/OpenAPI integration

## Features

- RESTful API endpoints for Cars and Motorcycles
- Swagger/OpenAPI documentation
- Spring Boot 3.2.6
- Maven build system

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Installation

1. Clone the repository
```bash
git clone https://github.com/YourUsername/SampleAPI.git
cd SampleAPI
```

2. Run the application
```bash
./mvnw spring-boot:run
```

3. Access the API
- API Base URL: http://localhost:8081
- Swagger UI: http://localhost:8081/swagger-ui.html

## API Endpoints

- `GET /api/cars` - Get all cars
- `GET /api/motorcycles` - Get all motorcycles

## Technologies Used

- Spring Boot 3.2.6
- SpringDoc OpenAPI 2.3.0
- Maven
- Java 17

## License

This project is licensed under the MIT License.
```

## Summary

This guide covers the complete process from initializing a git repository to successfully pushing your Spring Boot project to GitHub. The key steps are:

1. Initialize git repository
2. Create proper .gitignore
3. Configure git user
4. Add and commit files
5. Create GitHub repository
6. Add remote and push
7. Handle any merge conflicts

Remember to commit frequently, use descriptive messages, and keep your .gitignore updated as your project grows. 