package ru.bogdan.testtaskvodovoz.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.bogdan.testtaskvodovoz.data.ApplicationRepositoryImpl
import ru.bogdan.testtaskvodovoz.data.web.ApiFactory
import ru.bogdan.testtaskvodovoz.data.web.ApiHelperImpl
import ru.bogdan.testtaskvodovoz.domain.VodovozResponse

class MainViewModel(
    // private val getVodovozResponseUseCase: GetVodovozResponseUseCase
) : ViewModel() {
    
    val apiHelperImpl = ApiHelperImpl(ApiFactory.apiService)
    val applicationRep = ApplicationRepositoryImpl(apiHelperImpl)
    
    private val sharedFlow = MutableSharedFlow<MainUIState>()
    
    val state = applicationRep.getVodovozResponse()
        .map {
            MainUIState(
                goods = it.goods,
                isSuccess = VodovozResponse.SUCCESS == it.status,
                message = it.message
            )
        }
        .mergeWith(sharedFlow)
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            MainUIState()
        )
    
    fun updateData() {
        applicationRep.updateData()
    }
    
    fun makeError() {
        viewModelScope.launch {
            sharedFlow.emit(
                state.value.copy(isSuccess = false)
            )
        }
    }
    
    private fun <T> Flow<T>.mergeWith(anotherFlow: Flow<T>): Flow<T> {
        return merge(this, anotherFlow)
    }
    
}