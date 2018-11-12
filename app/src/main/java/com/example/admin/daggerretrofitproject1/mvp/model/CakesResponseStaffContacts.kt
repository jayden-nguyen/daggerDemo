package com.example.admin.daggerretrofitproject1.mvp.model

data class CakesResponseStaffContacts(val role: String,
                                      val name: String,
                                      val phones: CakesResponseStaffContactsPhones,
                                      val dateOfBirth: String,
                                      val id: Int,
                                      val email: Array<String>)