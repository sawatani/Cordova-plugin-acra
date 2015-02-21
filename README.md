Cordova-plugin-acra
===================

Cordova Plugin for [ACRA](https://github.com/ACRA/acra)

# Usage

## install

`cordova plugin add https://github.com/sawatani/Cordova-plugin-acra.git --variable TOAST_TEXT='<Some text>' --variable URL="<URL to your server>" --variable USERNAME="<BasicAuth for URL>" --variable PASSWORD="<BasicAuth for URL>"`

## working with reporter

See [ACRA official document](https://github.com/ACRA/acra/wiki/AdvancedUsage#sending-reports-for-caught-exceptions-or-for-unexpected-application-state-without-any-exception)

* To send error silently
  `plugin.acra.handleSilentException(<error message>)`

* To send error with toast text
  `plugin.acra.handleException(<error message>)`
