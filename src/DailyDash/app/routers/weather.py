from fastapi import APIRouter, HTTPException
import requests
import os

router = APIRouter()

@router.get("/weather", tags=["Weather"])
async def get_weather(city: str = "Zurich"):
    api_key = os.getenv("WEATHER_API_KEY")  # Set your OpenWeatherMap API key here
    url = f"http://api.openweathermap.org/data/2.5/weather?q={city}&appid={api_key}&units=metric"

    response = requests.get(url)
    if response.status_code != 200:
        raise HTTPException(status_code=500, detail="Failed to fetch weather data")
    return response.json()
