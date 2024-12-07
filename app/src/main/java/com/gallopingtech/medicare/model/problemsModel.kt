package com.gallopingtech.medicare.model

import kotlinx.serialization.Serializable

@Serializable
data class ProblemsResponse(
    val problems: List<Problem>
)

@Serializable
data class Problem(
    val Diabetes: List<Condition> = emptyList(),
    val Asthma: List<Condition> = emptyList()
)

@Serializable
data class Condition(
    val medications: List<Medication> = emptyList(),
    val labs: List<Lab> = emptyList()
)

@Serializable
data class Medication(
    val medicationsClasses: List<MedicationClass> = emptyList()
)

@Serializable
data class MedicationClass(
    val className: List<DrugClass> = emptyList(),
    val className2: List<DrugClass> = emptyList()
)

@Serializable
data class DrugClass(
    val associatedDrug: List<Drug> = emptyList(),
    val associatedDrug2: List<Drug> = emptyList()
)

@Serializable
data class Drug(
    val name: String,
    val dose: String,
    val strength: String
)

@Serializable
data class Lab(
    val missing_field: String
)
@Serializable
class Asthma(

)
