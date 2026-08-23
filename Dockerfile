FROM maven:3.9-eclipse-temurin-21

# Install Chrome and its dependencies
RUN apt-get update && apt-get install -y \
    wget gnupg unzip \
    && wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY . .

# Ensure the output directory exists before writing to it
RUN mkdir -p /app/output

# Run tests, output both to console and to a results file
CMD ["sh", "-c", "mvn test 2>&1 | tee /app/output/test-results.txt"]