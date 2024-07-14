package com.ilpacolo.page3.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.ilpacolo.page3.presentation.model.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
fun RickListScreen(rickListViewModel: RickListViewModel = hiltViewModel()) {


    val characters = rickListViewModel.characters.collectAsLazyPagingItems()
    CharacterList(characters = characters)

}

@Composable
fun CharacterList(characters: LazyPagingItems<CharacterModel>) {

    LazyColumn {
        items(characters.itemCount) {
            characters[it]?.let {
                ItemList(it)
            }
        }
    }
}

@Composable
fun ItemList(it: CharacterModel) {
        Box(modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(24))
            .fillMaxWidth()
            .height(180.dp),
            contentAlignment = Alignment.Center) {
                //Text(text = it.name, color = Color.White)
                AsyncImage(model = it.image, contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
        }
}
