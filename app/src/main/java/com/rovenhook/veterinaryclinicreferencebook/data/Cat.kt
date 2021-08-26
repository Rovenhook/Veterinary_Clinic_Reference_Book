package com.rovenhook.veterinaryclinicreferencebook.data

data class Cat(override val name: String, val color: String) : Animal(name) {
    override fun toString(): String {
        return "${this.name} ${this.color}"
    }
}