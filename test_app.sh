#!/bin/bash

# MinaMarket WebView App Test Script
echo "🚀 Testing MinaMarket WebView App..."

# Check if Android SDK is available
if ! command -v adb &> /dev/null; then
    echo "❌ ADB not found. Please install Android SDK and add it to PATH."
    exit 1
fi

# Build the app
echo "📦 Building the app..."
./gradlew assembleDebug

if [ $? -ne 0 ]; then
    echo "❌ Build failed!"
    exit 1
fi

echo "✅ Build successful!"

# Check if device is connected
DEVICES=$(adb devices | grep -v "List of devices" | grep "device$" | wc -l)

if [ $DEVICES -eq 0 ]; then
    echo "⚠️  No Android device connected. Please connect a device or start an emulator."
    echo "📱 You can install the APK manually from: app/build/outputs/apk/debug/app-debug.apk"
else
    echo "📱 Installing app on connected device..."
    adb install -r app/build/outputs/apk/debug/app-debug.apk
    
    if [ $? -eq 0 ]; then
        echo "✅ App installed successfully!"
        echo "🌐 The app will load https://minamarket.online in a WebView"
        echo "🎯 Features included:"
        echo "   - Splash screen with smooth loading"
        echo "   - Pull-to-refresh functionality"
        echo "   - Error handling with retry button"
        echo "   - Back button navigation through web history"
        echo "   - Progress bar for loading indication"
        echo "   - Network security configuration for HTTPS"
        echo ""
        echo "🚀 You can now launch the app from your device!"
    else
        echo "❌ Installation failed!"
        exit 1
    fi
fi

echo "✅ Test completed successfully!"
