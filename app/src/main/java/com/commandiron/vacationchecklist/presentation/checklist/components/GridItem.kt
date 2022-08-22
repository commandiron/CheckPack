package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.presentation.components.CustomCircularIcon
import com.commandiron.vacationchecklist.presentation.components.ImportanceLevelDot
import com.commandiron.vacationchecklist.ui.theme.checkedGreen
import com.commandiron.vacationchecklist.ui.theme.iconBackgroundColor
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun GridItem(
    checklistItem: ChecklistItem,
    isChecked: Boolean,
    listScale: Int,
    onClick:() -> Unit
) {
    val spacing = LocalSpacing.current
    Card(
        modifier = Modifier
            .padding(spacing.spaceExtraSmall)
            .aspectRatio(1f)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (isChecked) {
                MaterialTheme.colorScheme.tertiaryContainer
            }else MaterialTheme.colorScheme.secondaryContainer
        ),
        shape = RoundedCornerShape(
            when(listScale){
                1 -> spacing.spaceMedium
                2 -> spacing.spaceLarge
                3 -> spacing.spaceLarge
                else -> spacing.spaceLarge
            }
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            if(!isChecked){
                Box(
                    modifier = Modifier
                        .fillMaxSize(0.7f)
                ) {
                    ImportanceLevelDot(
                        modifier = Modifier
                            .size(spacing.spaceExtraSmall)
                            .align(Alignment.TopStart),
                        importanceLevel = checklistItem.importanceLevel
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.8f)
                    .fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .weight(6f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CustomCircularIcon(
                        surfaceShape = RoundedCornerShape(spacing.spaceSmall),
                        surfaceColor = iconBackgroundColor,
                        iconDrawable = checklistItem.iconDrawable,
                        iconPadding = when(listScale){
                            1 -> 0.dp
                            2 -> spacing.spaceExtraSmall
                            3 -> spacing.spaceExtraSmall
                            else -> spacing.spaceExtraSmall
                        }
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .weight(3f)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxHeight(),
                        text = checklistItem.name,
                        style = when(listScale){
                            1 -> MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium)
                            2 -> MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium)
                            3 -> MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Medium)
                            else -> MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium)
                        },
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Clip
                    )
                }
            }
        }
    }
}