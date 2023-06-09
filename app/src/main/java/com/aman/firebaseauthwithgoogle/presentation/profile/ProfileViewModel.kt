package com.aman.firebaseauthwithgoogle.presentation.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.aman.firebaseauthwithgoogle.domain.model.Response.Loading
import com.aman.firebaseauthwithgoogle.domain.model.Response.Success
import com.aman.firebaseauthwithgoogle.domain.repository.ProfileRepository
import com.aman.firebaseauthwithgoogle.domain.repository.RevokeAccessResponse
import com.aman.firebaseauthwithgoogle.domain.repository.SignOutResponse
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repo: ProfileRepository
): ViewModel() {
    val displayName get() = repo.displayName
    val photoUrl get() = repo.photoUrl

    var signOutResponse by mutableStateOf<SignOutResponse>(Success(false))
        private set
    var revokeAccessResponse by mutableStateOf<RevokeAccessResponse>(Success(false))
        private set

    fun signOut() = viewModelScope.launch {
        signOutResponse = Loading
        signOutResponse = repo.signOut()
    }

    fun revokeAccess() = viewModelScope.launch {
        revokeAccessResponse = Loading
        revokeAccessResponse = repo.revokeAccess()
    }
}