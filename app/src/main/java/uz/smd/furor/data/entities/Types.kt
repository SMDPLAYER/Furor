package uz.smd.furor.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Types(
  @PrimaryKey
  var id: Int = 2,
  var name_ru: String = "Исправление",
  var name_uk: String = "Тузатиш",
  var name_uz: String = "Tuzatish",
  var name: String = "Исправление",
  var description: String?,
  var css_icon: String = "mdi-bug",
  var color: String = "red",
  var ordering: Int = 3
)