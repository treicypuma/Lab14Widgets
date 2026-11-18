package com.example.lab14widgets

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import androidx.glance.color.ColorProvider
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
                .cornerRadius(24.dp)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            Text(
                text = "🛡️ Alerta Vecinal",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = GlanceTheme.colors.onSurface
                )
            )

            // Estado de la zona
            Row(
                modifier = GlanceModifier.padding(top = 4.dp, bottom = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "●",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = ColorProvider(
                            day = Color(0xFF2E7D32),
                            night = Color(0xFF81C784)
                        )
                    )
                )
                Spacer(modifier = GlanceModifier.width(6.dp))
                Text(
                    text = "Sin alertas en tu zona",
                    style = TextStyle(
                        fontSize = 13.sp,
                        color = GlanceTheme.colors.onSurfaceVariant
                    )
                )
            }

            // Botón principal: Auxilio
            Button(
                text = "🆘  AUXILIO",
                modifier = GlanceModifier.fillMaxWidth().height(52.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = GlanceTheme.colors.error,
                    contentColor = GlanceTheme.colors.onError
                ),
                onClick = actionStartActivity<SecondActivity>()
            )

            Spacer(modifier = GlanceModifier.height(8.dp))

            // Botones secundarios
            Row(modifier = GlanceModifier.fillMaxWidth()) {
                Button(
                    text = "💬 Chat",
                    modifier = GlanceModifier.defaultWeight().height(44.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = GlanceTheme.colors.secondaryContainer,
                        contentColor = GlanceTheme.colors.onSecondaryContainer
                    ),
                    onClick = actionStartActivity<MainActivity>()
                )
                Spacer(modifier = GlanceModifier.width(8.dp))
                Button(
                    text = "📞 Llamar",
                    modifier = GlanceModifier.defaultWeight().height(44.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = GlanceTheme.colors.secondaryContainer,
                        contentColor = GlanceTheme.colors.onSecondaryContainer
                    ),
                    onClick = actionStartActivity(
                        Intent(Intent.ACTION_DIAL, Uri.parse("tel:115"))
                    )
                )
            }
        }
    }
}