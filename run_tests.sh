#!/bin/bash

APK_PATH="/Users/kkrasotina/IdeaProjects/n26/n26-mobile-app-tests/src/test/resources/com.monefy.app.lite.apk"

echo "Run Appium server"
npx appium &

echo "Waiting for Appium server to start"
sleep 5

echo "Run tests with Gradle"
./gradlew clean build

GRADLE_EXIT_STATUS=$?

if [ $GRADLE_EXIT_STATUS -ne 0 ]; then
  echo "Tests failed. Check the Appium server logs"
  cat appium-server.log
  exit $GRADLE_EXIT_STATUS
fi

echo "Tests completed successfully!"

echo "Stopping Appium server"
kill %1

exit 0
