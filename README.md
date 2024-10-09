# WatchEyeMonitor: Advanced ANR and Crash Management

WatchEyeMonitor is a powerful library designed to effectively manage ANRs (Application Not Responding) and crashes caused by third-party
integrations beyond your control. This library ensures that exceptions are handled efficiently, preventing them from being reported to the
Google Play Console. With minimal configuration required, WatchEyeMonitor offers robust monitoring and management of ANRs and crashes,
enhancing the resilience and stability of your applications.

# **Key Features:**

- **ANR Monitoring**: Detects when the main thread remains busy beyond a specified threshold, triggering an exception to alert you.

- **Crash Handling**: Captures unexpected crashes and presents a customizable crash dialog, improving the user experience.

- **Firebase Crashlytics** Integration: Seamlessly integrates with Firebase Crashlytics for enhanced crash reporting and analysis.

- **Default Configuration**: Requires minimal setup, allowing you to get started quickly with default settings.

- **Customization Options**: Provides flexibility to customize the ticker interval, ANR threshold, crash dialog title, message, and more to suit your specific needs.

# **Implementation**

### Add Dependencies:

Add the WatchEyeMonitor dependency to your root build.gradle file

	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	} 
	

Add the WatchEyeMonitor dependency to your build.gradle file

     implementation("com.github.hypersoftdev:WatchEye:Tag")

### Setup Tutorial

#### Minimum Setup

For the minimum setup, simply build and start the WatchEyeMonitor with the default configuration.

#### Initialize WatchEyeMonitor:

In your application class, initialize and start the WatchEyeMonitor.

```
import android.app.Application
import com.example.watcheye.monitor_watcher.WatchEyeMonitorBuilder

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize and start WatchEyeMonitorBuilder with default settings
        WatchEyeMonitorBuilder(this).build().start()
    }
}

```

This minimal setup is sufficient to start monitoring ANRs and crashes with the default settings.

### Full Setup with Custom Configuration

To utilize all the customizable options available in WatchEyeMonitor, follow the steps below.

```
import android.app.Application
import com.example.watcheye.monitor_watcher.WatchEyeMonitorBuilder
import com.google.firebase.crashlytics.FirebaseCrashlytics

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize and start Watch Eye Monitor Builder with custom settings
        //val firebaseCrashlytics = FirebaseCrashlytics.getInstance()
        
        WatchEyeMonitorBuilder(this).setTimeTicker(200L) // Set ticker interval (1-500ms)
            .setTimeThreshold(3000L) // Set ANR threshold (1000-4500ms)
            .setErrorTitle("Error Title") // Set custom crash dialog title
            .setErrorMessage("Error Message") // Set custom crash dialog message
             //.setFirebaseCrashLytics(firebaseCrashlytics) // Integrate with Firebase Crashlytics
            .build().start()
    }
}

```

# Acknowledgements

This work would not have been possible without the invaluable contributions of [Hamza Arshad](https://github.com/Hamza384). His expertise, dedication, and unwavering support have been instrumental in bringing this project to fruition.

![Profile](https://github.com/hypersoftdev/WatchEye/blob/master/screens/image.jpg?raw=true){: width="50" height="50"}

We are deeply grateful for [Hamza Arshad](https://github.com/Hamza384) involvement and his belief in the importance of this work. His contributions have made a significant impact, and we are honored to have had the opportunity to collaborate with him.

# LICENSE

Copyright 2023 Hypersoft Inc

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.








