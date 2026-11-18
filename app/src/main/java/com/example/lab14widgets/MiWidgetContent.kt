package com.example.lab14widgets

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.ButtonDefaults
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.actionStartActivity
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle

class MiWidgetContent : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                Contenido()
            }
        }
    }

    @Composable
    private fun Contenido() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.surface)
                .cornerRadius(16.dp)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Alerta Vecinal",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = GlanceTheme.colors.onSurface
                )
            )
            Text(
                text = "Estado de la zona: sin alertas",
                style = TextStyle(color = GlanceTheme.colors.onSurface),
                modifier = GlanceModifier.padding(top = 4.dp, bottom = 12.dp)
            )
            Row(modifier = GlanceModifier.fillMaxWidth()) {
                Button(
                    text = "Auxilio",
                    modifier = GlanceModifier.defaultWeight(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = GlanceTheme.colors.error,
                        contentColor = GlanceTheme.colors.onError
                    ),
                    onClick = actionStartActivity<SecondActivity>()
                )
                Spacer(modifier = GlanceModifier.width(8.dp))
                Button(
                    text = "Chat de zona",
                    modifier = GlanceModifier.defaultWeight(),
                    onClick = actionStartActivity<MainActivity>()
                )
            }
            Spacer(modifier = GlanceModifier.height(8.dp))
            Button(
                text = "Llamar emergencia",
                modifier = GlanceModifier.fillMaxWidth(),
                onClick = actionStartActivity(
                    Intent(Intent.ACTION_DIAL, Uri.parse("tel:115"))
                )
            )
        }
    }
}