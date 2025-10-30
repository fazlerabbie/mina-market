#!/bin/bash

echo "🔧 Testing MinaMarket App - Modern Compose Implementation"
echo "========================================================"

# Check if multiple devices are connected
DEVICE_COUNT=$(adb devices | grep -c "device$")
if [ "$DEVICE_COUNT" -eq 0 ]; then
    echo "❌ No Android device connected"
    exit 1
elif [ "$DEVICE_COUNT" -gt 1 ]; then
    echo "📱 Multiple devices detected, using emulator-5554"
    DEVICE_FLAG="-s emulator-5554"
else
    echo "📱 Device connected"
    DEVICE_FLAG=""
fi

# Clear logs
adb $DEVICE_FLAG logcat -c

echo "🚀 Launching MinaMarket app..."
adb $DEVICE_FLAG shell am start -n online.minamarket.app/.MainActivity

echo "⏳ Waiting 10 seconds to check for crashes and edge-to-edge setup..."
sleep 10

# Check for crashes in the last 10 seconds
CRASHES=$(adb $DEVICE_FLAG logcat -d | grep -E "(FATAL|AndroidRuntime.*online.minamarket.app)" | wc -l)

if [ "$CRASHES" -gt 0 ]; then
    echo "❌ App crashed! Crash logs:"
    adb $DEVICE_FLAG logcat -d | grep -E "(FATAL|AndroidRuntime.*online.minamarket.app)" -A 10
    exit 1
else
    echo "✅ App is running without crashes!"

    # Check if WebView is loading
    WEBVIEW_LOGS=$(adb $DEVICE_FLAG logcat -d | grep -E "(MainActivity.*WebView|WebView.*setup)" | wc -l)

    if [ "$WEBVIEW_LOGS" -gt 0 ]; then
        echo "✅ WebView setup detected in logs"
        adb $DEVICE_FLAG logcat -d | grep -E "(MainActivity.*WebView|WebView.*setup)" | tail -3
    fi

    # Check for edge-to-edge insets
    INSETS_LOGS=$(adb $DEVICE_FLAG logcat -d | grep -E "(Applied window insets|edge.*edge)" | wc -l)

    if [ "$INSETS_LOGS" -gt 0 ]; then
        echo "✅ Edge-to-edge insets detected in logs"
        adb $DEVICE_FLAG logcat -d | grep -E "(Applied window insets|edge.*edge)" | tail -3
    fi

    echo ""
    echo "🎉 Test completed successfully!"
    echo "The app should now be running with proper edge-to-edge display."
    echo "Content should no longer be hidden behind the status bar or navigation bar."
fi
