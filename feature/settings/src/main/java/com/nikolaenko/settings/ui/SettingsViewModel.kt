package com.nikolaenko.settings.ui

import com.nikolaenko.core.viewmodel.BaseViewModel
import javax.inject.Inject

abstract class SettingsViewModel: BaseViewModel() {
}

class SettingsViewModelImpl @Inject constructor(): SettingsViewModel() {

    init {

    }
}