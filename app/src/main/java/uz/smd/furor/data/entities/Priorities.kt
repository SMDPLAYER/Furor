package uz.smd.furor.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Priorities(
  @PrimaryKey
  var id: Int = 2,
  var name_ru: String = "Низкий",
  var name_uk: String = "Паст",
  var name_uz: String = "Past",
  var name: String = "Низкий",
  var description: String?,
  var css_icon: String = "mdi-beach",
  var color: String = "green",
  var ordering: Int = 1
)