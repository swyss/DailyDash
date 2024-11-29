from fastapi import APIRouter, Depends
from sqlalchemy.orm import Session
from app.models import ToDoItem
from app.config import SessionLocal
from app.dependencies import get_redis_client
from typing import List

router = APIRouter()

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

@router.get("/todos", tags=["ToDos"])
async def get_todos(redis_client = Depends(get_redis_client)):
    todos = redis_client.lrange("todos", 0, -1)  # Retrieves all todos
    return {"todos": todos}

@router.post("/todos", tags=["ToDos"])
async def add_todo(todo: str, redis_client = Depends(get_redis_client)):
    redis_client.rpush("todos", todo)  # Adds todo to the list
    return {"message": "ToDo added"}

@router.delete("/todos", tags=["ToDos"])
async def delete_todo(index: int, redis_client = Depends(get_redis_client)):
    redis_client.lset("todos", index, "__deleted__")
    redis_client.lrem("todos", 1, "__deleted__")
    return {"message": "ToDo deleted"}
