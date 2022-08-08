package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.presentation.components.CustomCircularIcon
import com.commandiron.vacationchecklist.presentation.components.ImportanceLevelDot
import com.commandiron.vacationchecklist.ui.theme.checkedGreen
import com.commandiron.vacationchecklist.util.LocalSpacing

@OptIn(ExperimentalMaterial3Api::class)
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
                checkedGreen
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
                        iconDrawable = checklistItem.iconDrawable
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
                            1 -> MaterialTheme.typography.labelLarge
                            2 -> MaterialTheme.typography.bodySmall
                            3 -> MaterialTheme.typography.titleSmall
                            else -> MaterialTheme.typography.bodySmall
                        },
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Clip
                    )
                }
            }
        }
    }
}