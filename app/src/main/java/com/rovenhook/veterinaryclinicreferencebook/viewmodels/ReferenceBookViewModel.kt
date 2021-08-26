package com.rovenhook.veterinaryclinicreferencebook.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.rovenhook.veterinaryclinicreferencebook.data.Animal
import com.rovenhook.veterinaryclinicreferencebook.data.Cat
import com.rovenhook.veterinaryclinicreferencebook.data.Dog
import com.rovenhook.veterinaryclinicreferencebook.data.Repository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class ReferenceBookViewModel : ViewModel() {
    val repository: Repository = Repository()
    var AllAnimalsList: MutableList<Animal> = repository.getAnilamList()

    fun getData() {
        AllAnimalsList = repository.getAnilamList()
    }

    fun getCatsList(): Single<List<String>> {
        if (AllAnimalsList.isEmpty()) {
            getData()
        }
        val catList: MutableList<String> = mutableListOf()

        for (animal in AllAnimalsList) {
            if (animal is Cat) {
                catList.add(animal.toString())
            }
        }
        return Single.just(catList)
    }

    fun getDogsList(): Single<List<String>> {
        if (AllAnimalsList.isEmpty()) {
            getData()
        }
        val dogList: MutableList<String> = mutableListOf()

        for (animal in AllAnimalsList) {
            if (animal is Dog) {
                dogList.add(animal.toString())
            }
        }
        return Single.just(dogList)
    }

    fun getAnimalsList(): Single<List<String>> {
        val AllList: MutableList<String> = mutableListOf()

        for (animal in AllAnimalsList) {
            val type: String
            type = when (animal.javaClass) {
                Cat::class.java -> "кошка"
                else -> "собака"
            }
            AllList.add("${animal.name} $type")
        }
        return Single.just(AllList)
    }
}