NotificationLightBridge
=======================

This project adapts Notification Colors to the led light bar of a WA1053T Android Wall Mount Tablet.

Colors are usually defined [on a NotificationChannel](https://developer.android.com/reference/android/app/NotificationChannel#setLightColor(int)),
or, on api version < 26 on [the notifications ledARGB property](https://developer.android.com/reference/android/app/Notification#ledARGB).

Note: Flashing the LEDs is not supported.

Additionally, using the following generic Broadcast Intents are made available: 
- `de.pccoholic.pretix.notificationlightbridge.TURN_OFF`
- `de.pccoholic.pretix.notificationlightbridge.SET_COLOR` with an Integer-Extra of `color`
- `de.pccoholic.pretix.notificationlightbridge.SET_RAW` with an IntegerList-Extra of `cmd`

The available raw values can be found in the `LED()` companion object.

Installation/Setup
------------------

After compiling and installing the apk, navigate to
`Settings → Apps & notifications → Special app access → Notification access` and enable the
_NotificationLightBridge_ entry.

