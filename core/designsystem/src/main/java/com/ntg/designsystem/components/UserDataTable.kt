package com.ntg.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ntg.designsystem.model.UserDataTableItem

@Composable
fun UserDataTable(
    modifier: Modifier = Modifier,
    items: List<UserDataTableItem>,
    onClick:(Int) -> Unit,
){
    
    Column(
        modifier = modifier.background(
            color = MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(16.dp)
        ).clip(RoundedCornerShape(16.dp))
    ) {
     
        repeat(items.size){
            Item(item = items[it], items.size-1 != it) {
                onClick.invoke(it)
            }
        }
        
    }
    
}

@Composable
private fun Item(item: UserDataTableItem,
                 setDivider: Boolean,
                 onClick:(Int) -> Unit){
    
  Column(
      modifier = Modifier
          .clickable {
              onClick.invoke(item.id)
          }
          .fillMaxWidth()

          .padding(horizontal = 16.dp)
  ) {
      Text(
          modifier = Modifier.padding(top = 16.dp),
          text = item.title,
          style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.outline)
      )

      Text(
          modifier = Modifier
              .padding(top = 8.dp, bottom = 16.dp),
          text = item.subTitle,
          style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onSurface)
      )

      if (setDivider){
          Divider(thickness = 1.dp)
      }
  }
    
}