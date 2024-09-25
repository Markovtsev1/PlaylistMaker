package com.example.playlistmaker.utils.creator

import android.content.SharedPreferences
import android.media.MediaPlayer
import com.example.playlistmaker.data.HistoryRepositoryImpl
import com.example.playlistmaker.data.MediaPlayerRepositoryImpl
import com.example.playlistmaker.data.SettingsRepositoryImpl
import com.example.playlistmaker.data.TrackRepositoryImpl
import com.example.playlistmaker.data.network.RetrofitNetworkClient
import com.example.playlistmaker.domain.impl.history.HistoryInteractorImpl
import com.example.playlistmaker.domain.impl.player.MediaPlayerInteractorImpl
import com.example.playlistmaker.domain.impl.settings.SettingsInteractorImpl
import com.example.playlistmaker.domain.impl.track.TrackInteractorImpl

object Creator {

    private fun getTrackRepository() = TrackRepositoryImpl(RetrofitNetworkClient())

    fun provideTrackInteractor() = TrackInteractorImpl(getTrackRepository())

    private fun getSettingsRepository(sharedPreferences: SharedPreferences) =
        SettingsRepositoryImpl(sharedPreferences)

    fun provideSettingsInteractor(sharedPreferences: SharedPreferences) =
        SettingsInteractorImpl(getSettingsRepository(sharedPreferences))

    private fun getHistoryRepository(sharedPreferences: SharedPreferences) =
        HistoryRepositoryImpl(sharedPreferences)

    fun provideHistoryInteractor(sharedPreferences: SharedPreferences) =
        HistoryInteractorImpl(getHistoryRepository(sharedPreferences))

    private fun getMediaPlayerRepository() =
        MediaPlayerRepositoryImpl(mediaPlayer = MediaPlayer())

    fun provideMediaPlayerInteractor() =
        MediaPlayerInteractorImpl(getMediaPlayerRepository())
}