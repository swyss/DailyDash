from fastapi import FastAPI
from app.routers import health, todos

app = FastAPI()

# Include routes
app.include_router(health.router)
app.include_router(todos.router)
