package ru.bogdan.testtaskvodovoz.presenter


import ru.bogdan.testtaskvodovoz.domain.Goods

data class MainUIState(
    val fakeData: String = FAKE_DATA,
    val goods: List<Goods> = listOf(),
    val isSuccess: Boolean = false,
    val message: String = ""
) {
    companion object {
        const val FAKE_DATA = "FAKE DATA"
    }
}
