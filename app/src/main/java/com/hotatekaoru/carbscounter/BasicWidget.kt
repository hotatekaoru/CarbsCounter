package com.hotatekaoru.carbscounter

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class BasicWidget : AppWidgetProvider() {
    companion object {
        const val INTENT_ACTION_NAME = "TAP_WIDGET_BUTTON"
        const val PRESSED_BUTTON_TYPE = "PRESSED_BUTTON_TYPE"
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    private fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {

        val views = RemoteViews(context.packageName, R.layout.basic_widget)
        views.setOnClickPendingIntent(R.id.widget_rice_button, getPendingIntent(context, CarbType.RICE))

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }

    private fun getPendingIntent(context: Context, type: CarbType): PendingIntent {

        val resultIntent = Intent(context, MainActivity::class.java)
        resultIntent.action = INTENT_ACTION_NAME
        resultIntent.putExtra(PRESSED_BUTTON_TYPE, type.ordinal)
        return PendingIntent.getActivity(context, type.ordinal, resultIntent, Intent.FILL_IN_ACTION)
    }
}
