package com.example.transpose.ui.components.bottomsheet.item

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.transpose.MediaViewModel
import com.example.transpose.media.model.MediaItemType
import com.example.transpose.ui.common.PlayableItemUiState
import com.example.transpose.utils.constants.AppColors

@Composable
fun PlayerLoadingIndicator(
    mediaViewModel: MediaViewModel, modifier: Modifier = Modifier
) {
    val currentVideoState by mediaViewModel.currentVideoItemState.collectAsState()
    val isPlaying by mediaViewModel.isPlaying.collectAsState()

    when (val state = currentVideoState) {
        is PlayableItemUiState.BasicInfoLoaded -> {
            if (state.basicInfo.type == MediaItemType.YOUTUBE){
                CircularProgressIndicator(
                    modifier = modifier,
                    color = AppColors.BlueBackground
                )
            }
        }

        is PlayableItemUiState.Error -> {}
        is PlayableItemUiState.FullInfoLoaded -> {}
        PlayableItemUiState.Initial -> {

            CircularProgressIndicator(
                modifier = modifier,
                color = AppColors.BlueBackground

            )
        }
    }

}