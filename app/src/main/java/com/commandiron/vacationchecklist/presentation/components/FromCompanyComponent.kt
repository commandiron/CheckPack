package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.R
import com.commandiron.vacationchecklist.ui.theme.companyColor
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.Strings.COMPANY_NAME
import com.commandiron.vacationchecklist.util.Strings.English.FROM

@Composable
fun FromCompanyComponent(
    modifier: Modifier = Modifier,
    companyName: String = COMPANY_NAME,
    fromText: String = FROM
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = fromText,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium
            ),
            color = LocalContentColor.current.copy(
                alpha = 0.5f
            )
        )
        Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.height(20.dp),
                painter = painterResource(id = R.drawable.ci_tech_logo),
                contentDescription = companyName,
                tint = companyColor
            )
            Spacer(modifier = Modifier.width(spacing.spaceSmall))
            Text(
                text = companyName,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = companyColor
            )
        }
    }
}