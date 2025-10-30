# MinaMarket Android App

A modern Android WebView application for MinaMarket (https://minamarket.online) built with **Jetpack Compose** and following 2025 Android development best practices.

## ✨ Features

### 🎯 **Modern Architecture**
- **Jetpack Compose UI**: Built with the latest Android UI toolkit (2025)
- **AndroidView Integration**: Seamless WebView integration within Compose
- **ComponentActivity**: Modern activity lifecycle management
- **Clean Code**: Simple, maintainable Compose-based implementation

### 🚀 **Core Functionality**
- **WebView Integration**: Loads MinaMarket website in a native Android WebView
- **Smart Navigation**: Compose BackHandler for web history navigation
- **External Links**: Opens external links in the default browser
- **JavaScript Support**: Full JavaScript support for interactive features

### 🔒 **Security & Performance**
- **Network Security**: Configured for HTTPS-only connections
- **Modern WebView**: Uses AndroidX WebKit library for latest features
- **Hardware Acceleration**: Optimized for smooth performance
- **Material Design 3**: Modern Android theming

### 📱 **User Experience**
- **Android 15+ Compatible**: Proper edge-to-edge handling with `systemBarsPadding()`
- **Custom Status Bar**: Branded blue status bar with proper icon colors
- **Automatic Inset Management**: Uses Compose's built-in inset handling
- **Responsive Design**: Adapts to different screen sizes and orientations
- **Native Feel**: Integrated with Android system behaviors
- **No Status Bar Issues**: Content properly positioned on all Android versions (13, 14, 15+)

## 📱 Screenshots

The app includes:
- Splash screen with MinaMarket branding
- Main WebView with progress indicator
- Error screen with retry functionality
- Pull-to-refresh animation

## 🛠️ Technical Details

### Modern Architecture (2025)
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Activity**: ComponentActivity (modern lifecycle)
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 35 (Android 15)
- **Build System**: Gradle with Kotlin DSL

### Dependencies
- **Jetpack Compose BOM**: Latest stable version
- **Material Design 3**: Modern theming
- **AndroidX Core KTX**: Core Android extensions
- **AndroidX WebKit (1.8.0)**: Modern WebView features
- **Activity Compose**: Compose integration

### Key Components
- `MainActivity`: ComponentActivity with Compose setContent
- `WebViewScreen`: Composable function with AndroidView
- `AndroidView`: Compose integration for WebView
- `BackHandler`: Compose-based navigation handling
- Network Security Config: Ensures secure HTTPS connections

### Modern Compose Features
- **AndroidView Integration**: WebView within Compose UI
- **systemBarsPadding()**: Proper Android 15+ edge-to-edge inset handling
- **WindowCompat.enableEdgeToEdge()**: Ensures compatibility across all Android versions
- **Custom Status Bar Styling**: Branded colors with proper icon appearance
- **Layered Background**: Colored background extends behind status bar
- **State Management**: Compose remember and state APIs
- **Lifecycle Awareness**: Proper Compose lifecycle integration

## 🔧 Setup & Installation

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 24+
- Java 11 or later

### Building the App
1. Clone the repository
2. Open in Android Studio
3. Sync project with Gradle files
4. Build and run

### Command Line Build
```bash
# Clean and build
./gradlew clean build

# Build debug APK
./gradlew assembleDebug

# Run tests
./gradlew test

# Install on connected device
./gradlew installDebug
```

### Quick Test
Run the included test script:
```bash
./test_app.sh
```

## 📋 Configuration

### Website URL
The app loads `https://minamarket.online` by default. To change the URL, modify the `websiteUrl` constant in `MainActivity.kt`:

```kotlin
private val websiteUrl = "https://your-website.com"
```

### Splash Screen Duration
Adjust the splash screen duration in `MainActivity.kt`:

```kotlin
private val splashDuration = 2000L // 2 seconds
```

### Network Security
The app uses a network security configuration that:
- Enforces HTTPS connections
- Trusts system certificate authorities
- Blocks cleartext traffic

## 🧪 Testing

### Unit Tests
- URL validation tests
- Error message validation
- Configuration validation

### Instrumented Tests
- UI component visibility tests
- WebView functionality tests
- User interaction tests

Run tests with:
```bash
./gradlew test           # Unit tests
./gradlew connectedAndroidTest  # Instrumented tests
```

## 🔒 Security Features

- **HTTPS Only**: Enforced HTTPS connections
- **Safe Browsing**: WebView safe browsing enabled
- **File Access**: Restricted file access for security
- **Mixed Content**: Blocked mixed content loading
- **Custom User Agent**: Identifies the app for analytics

## 📱 Edge-to-Edge Display Support

The app fully supports Android 15's edge-to-edge display enforcement:

### ✅ **What's Implemented:**
- **WindowCompat.enableEdgeToEdge()**: Enables edge-to-edge display for all Android versions
- **Window Insets Handling**: Proper handling of system bar insets to prevent content overlap
- **Status Bar Adaptation**: Progress bar positioned correctly below status bar
- **Navigation Bar Adaptation**: Content properly padded above navigation bar
- **Dynamic Insets**: Automatically adapts to different device configurations

### 🎯 **Benefits:**
- **No Content Hidden**: Website content is never obscured by system bars
- **Modern Design**: Follows latest Android design guidelines
- **Immersive Experience**: Content extends behind transparent system bars
- **Universal Compatibility**: Works on all Android versions and device types

### 🔧 **Technical Details:**
- Uses `WindowInsetsCompat.Type.systemBars()` for proper inset detection
- Applies padding dynamically based on device-specific inset values
- Maintains compatibility with gesture navigation and button navigation
- Handles orientation changes and display cutouts automatically

## 📦 Build Variants

### Debug
- Includes debugging information
- Allows HTTP connections for testing
- Detailed logging enabled

### Release
- Optimized and minified
- HTTPS-only enforcement
- Production-ready configuration

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🆘 Support

For issues and questions:
1. Check the GitHub Issues page
2. Review the troubleshooting section
3. Contact the development team

## 🔄 Updates

The app automatically loads the latest version of the MinaMarket website. No app updates are required for website changes.

---

**Built with ❤️ for MinaMarket**
# mina-market
