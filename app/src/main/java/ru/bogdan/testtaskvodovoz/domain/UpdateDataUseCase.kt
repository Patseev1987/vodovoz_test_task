package ru.bogdan.testtaskvodovoz.domain

import javax.inject.Inject

class UpdateDataUseCase @Inject constructor(private val applicationRepository: ApplicationRepository) {
     fun update() {
        applicationRepository.updateData()
    }
}