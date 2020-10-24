package uz.smd.furor.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Statuses(
  @PrimaryKey
  var id: Int = 3,
  var name_ru: String = "Принят исполнителем",
  var name_uk: String = "Ижрочи кабул килди",
  var name_uz: String = "Ijrochi qabul qildi",
  var name: String = "Принят исполнителем",
  var description: String?,
  var css_icon: String = "mdi-account-check",
  var color: String = "warning"

)