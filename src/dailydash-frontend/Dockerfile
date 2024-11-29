# Use Node.js base image for Angular
FROM node:20

# Set working directory
WORKDIR /app

# Copy package.json and install dependencies
COPY package.json package-lock.json ./
RUN npm install

# Copy Angular project files
COPY . .

# Build Angular project
RUN npm run build --prod

# Serve with a lightweight server
RUN npm install -g http-server
CMD ["http-server", "dist/dailydash-frontend", "-p", "4200"]
