package online.minamarket.app

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import online.minamarket.app.ui.theme.MinaMarketTheme

class MainActivity : ComponentActivity() {
    
    private val websiteUrl = "https://minamarket.online"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge for Android 15+ compatibility
        WindowCompat.enableEdgeToEdge(window)

        // Customize status bar appearance
        setupStatusBar()

        setContent {
            MinaMarketTheme {
                // Create a colored background that extends behind the status bar
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF2196F3)) // Status bar color
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .systemBarsPadding(), // Content starts below status bar
                        color = MaterialTheme.colorScheme.background
                    ) {
                        WebViewScreen(url = websiteUrl)
                    }
                }
            }
        }
    }

    private fun setupStatusBar() {
        // Configure status bar appearance for modern Android
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)

        // Set status bar to use light content (white icons) on colored background
        windowInsetsController.isAppearanceLightStatusBars = false

        // Set navigation bar to use dark content (dark icons) on light background
        windowInsetsController.isAppearanceLightNavigationBars = true

        // For Android 15+, we'll use a colored status bar background
        // The color will be applied through the Compose UI
        window.statusBarColor = getColor(R.color.status_bar_color)
        window.navigationBarColor = getColor(R.color.navigation_bar_color)
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen(url: String) {
    val context = LocalContext.current
    val webView = remember { WebView(context) }
    
    // Handle back press
    BackHandler(enabled = webView.canGoBack()) {
        webView.goBack()
    }
    
    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = {
                webView.apply {
                    // Setup WebView settings
                    settings.apply {
                        javaScriptEnabled = true
                        domStorageEnabled = true
                        loadWithOverviewMode = true
                        useWideViewPort = true
                        builtInZoomControls = true
                        displayZoomControls = false
                        setSupportZoom(true)
                        userAgentString = userAgentString + " MinaMarketApp/1.0"
                    }

                    // Setup WebViewClient for external links
                    webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                            return if (url != null && !url.contains("minamarket.online")) {
                                try {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                    context.startActivity(intent)
                                    true
                                } catch (e: Exception) {
                                    false
                                }
                            } else {
                                false
                            }
                        }
                    }

                    // Load the URL
                    loadUrl(url)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}
