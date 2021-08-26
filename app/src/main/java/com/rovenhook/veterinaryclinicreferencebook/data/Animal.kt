package com.rovenhook.veterinaryclinicreferencebook.data

abstract class Animal(open val name: String) {
    override fun toString(): String {
        val type: String = when(this.javaClass) {
            Cat::class.java -> "кошка"
            else -> "собака"
        }

        return "${this.name}  $type"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Animal) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

}