package ru.bogdan.testtaskvodovoz.data.web

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import ru.bogdan.testtaskvodovoz.data.web.model.ResponseVodovoz
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    private val sharedFlow = MutableSharedFlow<Unit>()
    override fun getResponseVodovoz(): Flow<ResponseVodovoz> {
        return flow {
            val response = apiService.gerResponseVodovoz()
            emit(response)
            sharedFlow.collect {
                emit(apiService.gerResponseVodovoz())
            }
        }
    }
    
    override fun updateData() {
        CoroutineScope(Dispatchers.IO).launch {
            sharedFlow.emit(Unit)
        }
    }
}