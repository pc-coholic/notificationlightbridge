package de.pccoholic.pretix.notificationlightbridge

import android.app.NotificationManager
import android.content.IntentFilter
import android.service.notification.StatusBarNotification


class NotificationListenerService: android.service.notification.NotificationListenerService() {

    private var notificationManager: NotificationManager? = null
    private val setColorReceiver = SetColorReceiver()
    private val pretixReceiver = PretixReceiver()
    private val led = LED()

    override fun onListenerConnected() {
        super.onListenerConnected()
        notificationManager = application.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val setColorReceiverIntent = IntentFilter()
        SetColorReceiver.intent_actions.map {
            setColorReceiverIntent.addAction(it)
        }
        registerReceiver(setColorReceiver, setColorReceiverIntent)

        val pretixReceiverIntent = IntentFilter()
        PretixReceiver.intent_actions.map {
            pretixReceiverIntent.addAction(it)
        }
        registerReceiver(pretixReceiver, pretixReceiverIntent)
    }

    override fun onListenerDisconnected() {
        super.onListenerDisconnected()
        unregisterReceiver(setColorReceiver)
        unregisterReceiver(pretixReceiver)
    }

    override fun onNotificationPosted(sbn: StatusBarNotification, rankingMap: RankingMap) {
        return onNotificationPosted(sbn)
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
            led.send(LED.TURN_ON)
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification, rankingMap: RankingMap) {
        return onNotificationRemoved(sbn)
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
    }
}
