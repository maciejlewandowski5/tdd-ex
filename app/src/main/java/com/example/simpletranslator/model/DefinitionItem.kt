package com.example.simpletranslator.model

data class DefinitionItem(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val word: String
)

data class Meaning(
    val definitions: List<DefinitionX>,
    val partOfSpeech: String
)

data class Phonetic(
    val audio: String,
    val text: String
)

data class DefinitionX(
    val antonyms: List<Any>,
    val definition: String,
    val example: String,
    val synonyms: List<Any>
)
