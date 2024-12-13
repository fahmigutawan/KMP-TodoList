package com.example.todolist.presentation.components.todo_item

data class TodoItemProps(
    val title:String,
    val descriptionSnapshot:String,
    val expand:Boolean,
    val onExpandChange:(Boolean) -> Unit,
    val isDone:Boolean,
    val onIsDoneChange:(Boolean) -> Unit,
    val onGotoDetail:() -> Unit,
    val createdAt:String,
    val updatedAt:String
)
