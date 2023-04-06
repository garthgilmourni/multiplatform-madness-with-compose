# Preparing for Compose Multiplatform Development
## Setting up a developer machine for Android and iOS

### Introduction

This document describes how to prepare a macOS machine for developing with Compose Multiplatform. It is assumed that no
development tools or software have already been installed, and that the deployment targets will include Android and iOS.

### Stages

#### Install prerequisites for Android

1. Install the Java Development Kit
2. Install the [JetBrains Toolbox](https://www.jetbrains.com/lp/toolbox/)
3. Within the Toobox run the installer for Android Studio

#### Install XCode

1. Install [XCode via the AppStore](https://apps.apple.com/us/app/xcode)
3. Launch Xcode. On startup it installs support for iOS and macOS
4. Create and run a Hello World iOS application via the standard Wizard

#### Install CocoaPod via RVM

1. Install Homebrew via. `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)”`
2. Install GnuPG via. `brew install gnupg`
3. Install GPG keys for RVM via.  `gpg2 --keyserver keyserver.ubuntu.com --recv-keys 409B6B1796C275462A1703113804BB82D39DC0E3 7D2BAF1CF37B13E2069D6956105BD0E739499BDB`
4. Install rvm with ruby via.  `\curl -sSL https://get.rvm.io | bash -s stable --ruby`
5. Run. `source /Users/YOUR_USER_ID/.rvm/scripts/rvm`
6. Check ruby is installed via `ruby -v`. You should have version 3
7. Install CocoaPods via. `sudo gem install -n /usr/local/bin cocoapods`

#### Add the Kotlin Multiplatform Mobile Plugin
1. Start Android Studio and finish the setup wizard. The default settings are fine
2. Open the plugins menu and install the Kotlin Multiplatform Mobile Plugin plugin
3. Restart the IDE

#### Update the Kotlin Plugin
1. In the plugins menu of Android Studio check if the Kotlin plugin needs updated
2. If you have a new installation of Android Studio it may already be up to date

#### Install KDoctor
1. Run `brew install kdoctor`

#### Use KDoctor to validate your setup
1. Run `kdoctor` 
2. You may see the following error. Apply the suggested fix and close the current terminal.
3. Additional errors will be listed if any of the steps above failed.

> CocoaPods requires your terminal to be using UTF-8 encoding.
> 
>  Consider adding the following to ~/.zprofile
> 
>  export LC_ALL=en_US.UTF-8


#### Clone and open the project template in Android Studio
1. Run `git clone https://github.com/JetBrains/compose-multiplatform-template.git`
2. Restart Android Studio and open the downloaded project

#### Confirm that the sample works for Android and iOS
1. Create a profile for an Android Device
2. Run the `androidApp` configuration and check that the sample app launches
3. Run the `iosApp` configuration and check that the sample app launches





