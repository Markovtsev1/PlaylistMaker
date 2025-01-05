package com.example.playlistmaker.domain.api.favorites

import com.example.playlistmaker.domain.model.track.Track
import kotlinx.coroutines.flow.Flow

interface FavoriteTrackInteractor {

    fun getFavoritesTracks(): Flow<List<Track>>

    suspend fun deleteTrackFromFavorites(track: Track)

    suspend fun addTrackToFavorites(track: Track)

    suspend fun isTrackInFavorites(trackId: Long): Boolean
}