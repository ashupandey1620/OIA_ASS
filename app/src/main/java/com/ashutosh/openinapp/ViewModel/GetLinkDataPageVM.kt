package com.ashutosh.openinapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashutosh.openinapp.Model.ResponseData
import com.ashutosh.openinapp.Repository.OIARepository
import com.ashutosh.openinapp.Token.TokenStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetLinkDataPageVM  @Inject constructor(private val repository: OIARepository ,
                                             private val tokenStore: TokenStore
): ViewModel(){


    private val _getData = MutableLiveData<ResponseData?>()
    val getData : LiveData<ResponseData?> = _getData

    fun getLinkData() {
        viewModelScope.launch {
            val result = repository.getLinkData(tokenStore.accessTokenFlow.toString())
            _getData.postValue(result)
        }
    }


}