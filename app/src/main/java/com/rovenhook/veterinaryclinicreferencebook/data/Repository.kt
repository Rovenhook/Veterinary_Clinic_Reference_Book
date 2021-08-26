package com.rovenhook.veterinaryclinicreferencebook.data

class Repository {
    private val animalsList: MutableList<Animal> = mutableListOf()

    init {
        animalsList.add(Dog("Мухтар", 10))
        animalsList.add(Dog("Рекс", 3))
        animalsList.add(Dog("Жучка", 8))
        animalsList.add(Dog("Боня", 5))
        animalsList.add(Dog("Полкан", 13))
        animalsList.add(Dog("Клёпа", 2))

        animalsList.add(Cat("Маруся", "Рыжий"))
        animalsList.add(Cat("Мурка", "Черный"))
        animalsList.add(Cat("Барсик", "Серый"))
        animalsList.add(Cat("Мурзик", "Рыжий"))
        animalsList.add(Cat("Соня", "Сервый"))
        animalsList.add(Cat("Пушок", "Белый"))
    }

    fun getAnilamList() : MutableList<Animal> {
        return animalsList
    }


}