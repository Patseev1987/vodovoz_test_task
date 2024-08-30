package ru.bogdan.testtaskvodovoz.domain

import javax.inject.Inject

class GetVodovozResponseUseCase @Inject constructor(private val repository: ApplicationRepository) {
    operator fun invoke() = repository.getVodovozResponse()
}