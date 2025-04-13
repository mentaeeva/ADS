# Data Structures Project

This project implements common data structures in Java, including `MyArrayList`, `MyLinkedList`, `MyStack`, `MyQueue`, and `MyMinHeap`. It allows users to interact with these structures through a simple console-based application.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Usage](#usage)
- [Classes and Methods Documentation](#classes-and-methods-documentation)


## Overview

This project is designed to showcase the implementation of basic data structures:
- **MyArrayList**: A custom implementation of an array list.
- **MyLinkedList**: A custom implementation of a doubly linked list.
- **MyStack**: A custom stack implementation using `MyArrayList` or `MyLinkedList`.
- **MyQueue**: A custom queue implementation using `MyArrayList` or `MyLinkedList`.
- **MyMinHeap**: A custom minimum heap implementation using `MyArrayList`.

The goal is to provide a clear and efficient implementation of these structures while allowing users to interact with them via a command-line interface.

## Features

- **MyArrayList**: Implements a dynamic array with basic list operations such as add, remove, and get by index.
- **MyLinkedList**: Implements a doubly linked list with basic operations, supporting efficient insertions and deletions.
- **MyStack**: Implements a stack using either `MyArrayList` or `MyLinkedList` as the underlying data structure. Operations include `push`, `pop`, and `peek`.
- **MyQueue**: Implements a queue using either `MyArrayList` or `MyLinkedList`. Operations include `enqueue`, `dequeue`, and `peek`.
- **MyMinHeap**: Implements a min-heap using a custom array list (`MyArrayList`). Supports operations such as `insert`, `extractMin`, and `getMin`.

## Setup and Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/repository.git
Open the project in your preferred IDE or text editor.

Compile and run the main program:



## Usage
Once the program is running, you will be prompted to choose a data structure to work with:

1 - MyArrayList

2 - MyLinkedList

3 - MyStack

4 - MyQueue

5 - MyMinHeap

Example:
If you select MyArrayList, you will have access to various list operations like adding, removing, and getting elements by index. Similarly, you can use the stack or queue options to interact with those structures.

Operations:
MyArrayList / MyLinkedList:

Add items to the list.

Remove items by index or remove the first/last element.

Retrieve items by index.

Sort the list.

Check the size of the list.

Clear the list.

MyStack:

Push items onto the stack.

Pop items from the stack.

Peek at the top item.

MyQueue:

Enqueue items into the queue.

Dequeue items from the queue.

Peek at the front item.

MyMinHeap:

Insert items into the heap.

Extract the minimum item from the heap.

Get the minimum item without removing it.

## Classes and Methods Documentation
- MyArrayList
This class is a custom implementation of an array-based list, providing methods such as:

add(T item): Adds an element to the list.

add(int index, T item): Adds an element at a specified index.

get(int index): Retrieves the element at the specified index.

remove(int index): Removes the element at the specified index.

size(): Returns the size of the list.

clear(): Clears the list.

- MyLinkedList
This class implements a doubly linked list with similar functionality to MyArrayList, including:

add(T item): Adds an element to the end of the list.

addFirst(T item): Adds an element to the front of the list.

addLast(T item): Adds an element to the end of the list.

removeFirst(): Removes the first element from the list.

removeLast(): Removes the last element from the list.

getFirst(): Retrieves the first element of the list.

getLast(): Retrieves the last element of the list.

- MyStack
This class implements a stack data structure. Methods include:

push(T item): Pushes an item onto the stack.

pop(): Pops the top item off the stack.

peek(): Returns the top item without removing it.

- MyQueue
This class implements a queue data structure. Methods include:

enqueue(T item): Adds an item to the queue.

dequeue(): Removes and returns the front item of the queue.

peek(): Returns the front item without removing it.

- MyMinHeap
This class implements a minimum heap. Methods include:

insert(T item): Inserts an item into the heap.

extractMin(): Removes and returns the minimum item from the heap.

getMin(): Returns the minimum item without removing it.
