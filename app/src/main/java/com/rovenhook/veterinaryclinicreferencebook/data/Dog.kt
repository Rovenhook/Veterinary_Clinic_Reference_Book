package com.rovenhook.veterinaryclinicreferencebook.data

data class Dog(override val name: String, val age: Int) : Animal(name) {
    override fun toString(): String {
        return "${this.name} ${this.age}"
    }
}