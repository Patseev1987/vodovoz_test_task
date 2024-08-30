package ru.bogdan.testtaskvodovoz.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ru.bogdan.testtaskvodovoz.data.ApplicationRepositoryImpl
import ru.bogdan.testtaskvodovoz.data.web.ApiFactory
import ru.bogdan.testtaskvodovoz.data.web.ApiHelperImpl
import ru.bogdan.testtaskvodovoz.domain.GetVodovozResponseUseCase
import ru.bogdan.testtaskvodovoz.domain.VodovozResponse
import ru.bogdan.testtaskvodovoz.util.SingleSharedFlow

class MainViewModel(
   // private val getVodovozResponseUseCase: GetVodovozResponseUseCase
): ViewModel() {
    private val _uiAction = SingleSharedFlow<MainUIAction>()
    val uiAction = _uiAction.asSharedFlow()
    val apiHelperImpl = ApiHelperImpl(ApiFactory.apiService)
    val applicationRep = ApplicationRepositoryImpl(apiHelperImpl)
     val state = applicationRep.getVodovozResponse()
        .map{
            MainUIState(
                goods = it.goods,
                isSuccess = VodovozResponse.SUCCESS == it.status,
                message = it.message
            )
        }
        .stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        MainUIState()
    )

    fun intentHandler(intent: MainIntent){
        when (intent) {
            is MainIntent.ProductClicked -> {
                _uiAction.tryEmit(MainUIAction.RedirectToProduct(intent.product))
            }
        }
    }


}