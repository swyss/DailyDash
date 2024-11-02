# DailyDash Project

## Project Overview
**DailyDash** is a lightweight dashboard for managing tasks, weather information, and specific ToDos for plant care, accessible within a private network. Designed to support multiple devices, with a Linux-based web server running on mobile devices, Windows clients, and a Raspberry Pi touchscreen as the main display.

## Technology Stack

- **Frontend**: Angular, Syncfusion Angular UI, Angular Material
- **Backend**: FastAPI, Redis
- **Version Control**: GitHub for source code management and CI/CD

## Functional Requirements

### Main Display
   - **Contents**:
     - **Date and Time**: Continuously updated display of the current date and time.
     - **Weather**: Displays current weather conditions and temperature based on location information.
     - **Daily ToDos**: List of ToDos for the current day, including specific reminders for plant care (e.g., watering).
   - **Interaction and Widget Management**:
     - **Always Visible**: The main display remains visible at all times.
     - **User Interaction**: Additional widgets (calendar, task overview for upcoming days, plant care details) appear only upon user interaction.
     - **Return to Main Display**: After 30 seconds of inactivity or via a “Back” button, the view returns to the main display.

### Calendar and ToDo Management
   - **Calendar**: Monthly and weekly views for planning upcoming tasks and events.
   - **ToDo Lists**:
     - **Daily Tasks**: Listing of current day’s tasks and a preview for upcoming days.
     - **Plant Care**: Dedicated ToDo list for recurring plant care tasks.

## Non-functional Requirements
   - **Performance**: Low-latency data queries for near real-time display.
   - **Security**: Only devices within the private network have access; optional access restrictions.
   - **Portability**: Usable across mobile devices, Raspberry Pi, and Windows clients.

## Backend-specific Requirements
   - **API Documentation**: Automatically generated (Swagger-UI).
   - **ToDo API**: Management of ToDos with endpoints for creating, updating, deleting, and setting due dates and reminders.
   - **Plant Care API**: Management of recurring tasks, especially for plant care.
   - **Weather API**: Regular updates of weather information.

## Frontend-specific Requirements
   - **Widgets and Views**:
     - Calendar and ToDo widgets on the main page.
     - Dedicated widget for plant care accessible from the main display.

## Project Structure

   ```plaintext
   dailydash/
   ├── app/
   │   ├── main.py          # Main file with FastAPI initialization and endpoints
   │   ├── config.py        # Configuration (e.g., Redis connection settings)
   │   ├── routers/         # Directory for API routers
   │   │   └── dashboard.py # Endpoints for the dashboard
   │   └── dependencies.py  # Redis client and other dependencies
   ├── Dockerfile           # Docker setup for FastAPI
   ├── requirements.txt     # Python dependencies
   └── .github/workflows/   # CI/CD pipeline with GitHub Actions
   ```

## Installation

1. **Prerequisites**: Ensure Docker and Git are installed.
2. **Clone the repository**:
   ```bash
   git clone <repository-url>
   ```
3. **Start Docker container**:
   ```bash
   docker-compose up --build
   ```
4. **Access**: DailyDash is accessible at `http://localhost:8000` after startup.

## API Reference

The API documentation is available via Swagger-UI once the application is running: `http://localhost:8000/docs`.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/AmazingFeature`).
3. Commit changes to the branch (`git commit -m 'Add some AmazingFeature'`).
4. Push the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

## Additional Documentation

### CHANGELOG.md
Contains an overview of all version changes and updates.

### docs/ Directory
Additional documentation, including specific module descriptions, ToDo and Plant Care API, and setup guides.
