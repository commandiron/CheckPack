package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.R
import com.commandiron.vacationchecklist.ui.theme.companyColor
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun FromCompanyComponent(
    modifier: Modifier = Modifier,
    companyName: String = stringResource(R.string.company_name),
    fromText: String = stringResource(R.string.from),
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