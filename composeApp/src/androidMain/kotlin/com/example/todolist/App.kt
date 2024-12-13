package com.example.todolist

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolist.components.TodoItem
import com.example.todolist.presentation.components.todo_item.TodoItemProps
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import todolist.composeapp.generated.resources.Res
import todolist.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        Scaffold {
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(it),
                contentAlignment = Alignment.Center
            ) {
                val expand = remember {
                    mutableStateOf(false)
                }
                TodoItem(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    props = TodoItemProps(
                        title = "Learn Jetpack Compose",
                        descriptionSnapshot = "Explore how to create UI using Jetpack Compose",
                        expand = expand.value,
                        onExpandChange = { isExpanded ->
                            expand.value = isExpanded
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
        }
    }
}