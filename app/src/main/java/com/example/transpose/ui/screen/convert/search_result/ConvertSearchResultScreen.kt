package com.example.transpose.ui.screen.convert.search_result

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.transpose.MainViewModel
import com.example.transpose.MediaViewModel
import com.example.transpose.data.model.newpipe.NewPipeContentListData
import com.example.transpose.data.model.newpipe.NewPipeVideoData
import com.example.transpose.ui.common.UiState
import com.example.transpose.ui.components.items.CommonVideoItem
import com.example.transpose.ui.components.items.LoadingIndicator
import com.example.transpose.ui.components.scrollbar.EndlessLazyColumn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConvertSearchResultScreen(
    convertSearchResultViewModel: ConvertSearchResultViewModel,
    mainViewModel: MainViewModel,
    mediaViewModel: MediaViewModel,
    query: String?

){
    val bottomSheetState by mainViewModel.bottomSheetState.collectAsState()
    val searchResults by convertSearchResultViewModel.searchResults.collectAsState()
    val uiState by convertSearchResultViewModel.searchUiState.collectAsState()
    val isMoreItemsLoading by convertSearchResultViewModel.isMoreItemsLoading.collectAsState()
    val hasMoreItems by convertSearchResultViewModel.hasMoreSearchItems.collectAsState()


    BackHandler(
        enabled = bottomSheetState == SheetValue.Expanded
    ) {
        mainViewModel.partialExpandBottomSheet()
    }

    LaunchedEffect(key1 = true) {
        query?.let {
            convertSearchResultViewModel.initializeSearchPager(it)
        }

    }


    when (uiState) {
        is UiState.Initial -> {
            // 초기 상태 UI (예: 검색 안내 메시지)
        }

        is UiState.Loading -> {
            LoadingIndicator()
        }

        is UiState.Success -> {
            EndlessLazyColumn(
                modifier = Modifier.fillMaxSize(),
                items = searchResults,
                headerData = null,
                itemKey = { item: NewPipeContentListData -> item.id },
                itemContent = { item: NewPipeContentListData ->
                    CommonVideoItem(
                        item = item,
                        onClick = { mediaViewModel.updateCurrentVideoItem(item as NewPipeVideoData)
                            mainViewModel.expandBottomSheet()
                        })
                },

                loading = isMoreItemsLoading,
                loadMore = { convertSearchResultViewModel.loadMoreSearchResults() },
                hasMoreItems = hasMoreItems
            )
        }

        is UiState.Error -> {
            ErrorMessage(message = (uiState as UiState.Error).message)
        }
    }
}

@Composable
fun ErrorMessage(message: String) {
    // 에러 메시지 표시 구현
}

