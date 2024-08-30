package ru.bogdan.testtaskvodovoz.domain

class GetVodovozResponseUseCase(private val repository: ApplicationRepository) {
    operator fun invoke() = repository.getVodovozResponse()
}