# Future HTML → Android Suite

This is a clean rebuild foundation for two apps:

1. **HTML App Builder** — project editor/preview with a native Android shell and a GitHub Actions build pipeline.
2. **AI HTML Code Generator + APK Builder** — prompt-to-starter-code UI, preview, project save, and the same APK/AAB pipeline.

## Build online
Upload either folder as its own GitHub repository. Open **Actions → Build APK and AAB → Run workflow**. The workflow produces debug APK, release APK and AAB artifacts.

## Important architecture
The apps are not designed as a permanently closed HTML-to-WebView system. The Android layer is a native Kotlin shell with a JavaScript bridge, so native modules can be added later (files, camera, notifications, storage, sharing, etc.).

The AI app deliberately does not contain a hard-coded AI API key. A future backend/provider module can be connected securely.
