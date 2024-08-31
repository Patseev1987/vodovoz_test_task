package ru.bogdan.testtaskvodovoz.presenter.mainFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.bogdan.testtaskvodovoz.domain.GetVodovozResponseUseCase
import ru.bogdan.testtaskvodovoz.domain.UpdateDataUseCase
import ru.bogdan.testtaskvodovoz.domain.VodovozResponse
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getVodovozResponseUseCase: GetVodovozResponseUseCase,
    private val updateDataUseCase: UpdateDataUseCase
) : ViewModel() {
    
    private val sharedFlow = MutableSharedFlow<MainUIState>()
    
    val state = getVodovozResponseUseCase()
        .map {
            MainUIState(
                goods = it.goods,
                isSuccess = VodovozResponse.SUCCESS == it.status,
                message = it.message
            )
        }
        .catch { MainUIState(isSuccess = false) }
        .mergeWith(sharedFlow)
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            MainUIState()
        )
    
    fun updateData() {
        updateDataUseCase.update()
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