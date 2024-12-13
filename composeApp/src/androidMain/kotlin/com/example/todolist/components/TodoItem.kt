package com.example.todolist.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.presentation.components.todo_item.TodoItemProps
import com.example.todolist.utils.DateUtils

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TodoItem(
    modifier: Modifier = Modifier,
    props: TodoItemProps
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color(0xFFDFF6DD),
        elevation = 4.dp,
        onClick = {
            props.onGotoDetail()
        }
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Created:  ${DateUtils.dateUtcToFormatted(props.createdAt)}",
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray,
                    fontSize = 11.sp
                )

                IconButton(
                    onClick = {
                        props.onExpandChange(!props.expand)
                    }
                ) {
                    Icon(
                        imageVector = if (props.expand)
                            Icons.Default.KeyboardArrowUp
                        else Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand Btn"
                    )
                }
            }

            Column(
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text(
                    text = "Task",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Black
                )
                Text(
                    text = props.title,
                    style = MaterialTheme.typography.h6,
                    color = Color.Black
                )
            }

            AnimatedVisibility(
                visible = props.expand
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 8.dp, end = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Black
                    )

                    Text(
                        modifier = Modifier.align(Alignment.End),
                        text = "Last Update:  ${DateUtils.dateUtcToFormatted(props.updatedAt) ?: "-"}",
                        style = MaterialTheme.typography.body2,
                        color = Color.Gray,
                        fontSize = 11.sp
                    )
                }
            }

            Spacer(Modifier.padding(bottom = 16.dp))
        }
    }
}

@Preview
@Composable
fun PrevTodoItem(modifier: Modifier = Modifier) {
    TodoItem(
        props = TodoItemProps(
            title = "Learn Jetpack Compose",
            descriptionSnapshot = "Explore how to create UI using Jetpack Compose",
            expand = true,
            onExpandChange = { isExpanded ->
                println("Item expanded state changed: $isExpanded")
            },
            isDone = false,
            onIsDoneChange = { isCompleted ->
                println("Item completion state changed: $isCompleted")
            },
            onGotoDetail = {
                println("Go to detail")
            },
            createdAt = "2024-12-01T10:00:00Z",
            updatedAt = "2024-12-12T18:30:00Z"
        )
    )

}