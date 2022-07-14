package com.nikolaenko.profile.ui

import com.nikolaenko.core.viewmodel.BaseViewModel
import javax.inject.Inject

abstract class ProfileViewModel: BaseViewModel() {
}

class ProfileViewModelImpl @Inject constructor(): ProfileViewModel() {

    init {

    }
}