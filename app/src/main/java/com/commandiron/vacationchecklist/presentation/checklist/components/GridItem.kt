package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.commandiron.handy_compose.core.HandyCard
import com.commandiron.handy_compose.core.HandyColumnCard
import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.presentation.components.ImportanceLevelDot
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun GridItem(
    checklistItem: ChecklistItem,
    isChecked: Boolean,
    onClick:() -> Unit
) {
    val spacing = LocalSpacing.current

    HandyColumnCard(
        modifier = Modifier
            .aspectRatio(1f)
            .clickable { onClick() }
            .padding(spacing.spaceExtraSmall),
        shadowElevation = 4.dp,
        color = if(isChecked) {
            MaterialTheme.colorScheme.tertiaryContainer
        } else MaterialTheme.colorScheme.secondaryContainer,
        paddingFraction = 0.1f,
        topContentWeight = 2f,
        topContent = {
            HandyCard(
                modifier = Modifier.fillMaxSize(),
                shapeSizeFraction = 0f,
                paddingFraction = 0.1f,
                color = LocalContentColor.current.copy(0f)
            ) {
                Icon(
                    painter = painterResource(checklistItem.iconDrawable),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        },
        bottomContentWeight = 1f,
        bottomContent = {
            Text(
                text = checklistItem.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall,
                overflow = TextOverflow.Ellipsis
            )
        },
        topStartContent = {
            if(!isChecked){
                ImportanceLevelDot(
                    modifier = Modifier.size(spacing.spaceExtraSmall),
                    importanceLevel = checklistItem.importanceLevel
                )
            }
        }
    )
}