# Theme Switching in Android (XML)

Theme Switching in Android (XML) is a demonstration Android application that showcases how to implement dynamic theme switching (including light and dark modes for different color schemes) and persist the user's preference.

## Features

*   **Dynamic Theme Switching**: Switch between multiple themes at runtime:
    *   Blue (Light)
    *   Blue Night (Dark)
    *   Green (Light)
    *   Green Night (Dark)
*   **Persistence**: Uses `SharedPreferences` to remember the user's theme selection across app restarts.
*   **Custom Attributes**: Demonstrates the use of custom theme attributes (e.g., `colorIcon`, `colorText`, `colorBackground`) to style UI elements dynamically.
*   **SVG Color Tinting**: Includes an example of how to programmatically tint SVG icons based on the current theme's attributes.
*   **Edge-to-Edge**: Implements modern Android edge-to-edge display using `WindowInsets`.
*   **View Binding**: Utilizes Android View Binding for safer and easier interaction with UI components.

## How it Works

1.  **Themes Definition**: Different themes are defined in `res/values/themes.xml`, each inheriting from a base theme and overriding specific color attributes.
2.  **Preference Storage**: `SharedPreferencesHelper` manages saving and retrieving the selected theme's ordinal value.
3.  **Applying Themes**: In `MainActivity.onCreate()`, the saved theme is retrieved and applied using `setTheme()` *before* calling `setContentView()`.
4.  **Runtime Change**: When the "Change Theme" button is clicked, the new theme is saved to preferences, and `recreate()` is called to restart the activity and apply the new style.

## Getting Started

### Prerequisites

*   Android Studio Ladybug or newer.
*   Android SDK 34+.

### Installation

1.  Clone the repository.
2.  Open the project in Android Studio.
3.  Sync Gradle and run the app on an emulator or physical device.

## Project Structure

*   `MainActivity.kt`: Contains the core logic for theme switching and UI setup.
*   `SharedPreferencesHelper.kt`: A utility class for handling data persistence.
*   `themes.xml`: Defines the styles and custom attributes used for branding.
*   `activity_main.xml`: The main layout file using data binding.

## License

This project is open-source and available under the [MIT License](LICENSE).
