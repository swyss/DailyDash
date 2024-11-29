import redis

def get_redis_client():
    # Connects to Redis running in Docker
    return redis.Redis(host="redis", port=6379, decode_responses=True)
