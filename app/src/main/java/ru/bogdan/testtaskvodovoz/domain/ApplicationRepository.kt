package ru.bogdan.testtaskvodovoz.domain

import kotlinx.coroutines.flow.Flow

interface ApplicationRepository {
    fun getVodovozResponse(): Flow<VodovozResponse>
    
    fun updateData()
}