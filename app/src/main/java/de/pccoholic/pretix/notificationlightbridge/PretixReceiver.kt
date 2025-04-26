package de.pccoholic.pretix.notificationlightbridge

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class PretixReceiver : BroadcastReceiver() {
    companion object {
        const val INTENT_TURN_OFF = "eu.pretix.led.OFF"
        const val INTENT_SUCCESS = "eu.pretix.led.SUCCESS"
        const val INTENT_ERROR = "eu.pretix.led.ERROR"
        const val INTENT_ATTENTION = "eu.pretix.led.ATTENTION"
        val intent_actions = listOf(
            INTENT_TURN_OFF,
            INTENT_SUCCESS,
            INTENT_ERROR,
            INTENT_ATTENTION
        )
    }

    override fun onReceive(context: Context, intent: Intent) {
        val led = LED()
        when (intent.action) {
            INTENT_TURN_OFF -> {
                led.send(LED.COLOR_WHITE)
            }
            INTENT_SUCCESS -> {
                led.send(LED.COLOR_GREEN)
            }
            INTENT_ERROR -> {
                led.send(LED.COLOR_RED)
            }
            INTENT_ATTENTION -> {
                led.send(LED.COLOR_YELLOW)
            }
        }
    }
}
