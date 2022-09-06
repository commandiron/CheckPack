package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.domain.model.CheckItem
import com.commandiron.vacationchecklist.presentation.components.ImportanceLevelDot
import com.commandiron.vacationchecklist.ui.theme.importantBorderColor
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun GridItem(
    modifier: Modifier = Modifier,
    columnCount: Int,
    checkItem: CheckItem,
    onItemLongClick: (CheckItem) -> Unit,
    onItemClick: (CheckItem) -> Unit,
) {
    val spacing = LocalSpacing.current
    Card(
        modifier = modifier
            .clip(shape = RoundedCornerShape(12.dp))
            .combinedClickable(
                interactionSource = remember { MutableInteractionSource()},
                indication = if(!checkItem.isMarked) LocalIndication.current else null,
                onLongClick = { onItemLongClick(checkItem) },
                onClick = { onItemClick(checkItem) }
            )
            .border(
                width = 2.dp,
                color = if(checkItem.isMarked) importantBorderColor else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = getContainerColor(checkItem.isChecked, checkItem.isMarked),
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.padding(spacing.spaceSmall),
                        painter = painterResource(checkItem.iconDrawable),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = spacing.spaceExtraSmall,
                                end = spacing.spaceExtraSmall,
                                bottom = spacing.spaceExtraSmall
                            ),
                        text = checkItem.name,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        style = getTextStyle(columnCount)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing.spaceSmall),
                contentAlignment = Alignment.TopStart
            ) {
                if(!checkItem.isChecked){
                    ImportanceLevelDot(
                        modifier = Modifier.size(spacing.spaceExtraSmall),
                        importanceLevel = checkItem.importanceLevel
                    )
                }
            }
        }
    }
}

@Composable
private fun getContainerColor(isChecked: Boolean, isMarked: Boolean): Color{
    return if(isMarked){
        MaterialTheme.colorScheme.tertiaryContainer
    }else{
        if(isChecked){
            MaterialTheme.colorScheme.primaryContainer
        }else{
            MaterialTheme.colorScheme.secondaryContainer
        }
    }
}

@Composable
private fun getTextStyle(columnCount: Int): TextStyle {
    return when(columnCount){
        1 -> MaterialTheme.typography.headlineSmall
        2 -> MaterialTheme.typography.bodyMedium
        3 -> MaterialTheme.typography.bodySmall
        4 -> MaterialTheme.typography.labelLarge
        5 -> MaterialTheme.typography.labelLarge
        else -> MaterialTheme.typography.bodySmall
    }
}