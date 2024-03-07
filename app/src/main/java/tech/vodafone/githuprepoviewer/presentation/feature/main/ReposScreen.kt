package tech.vodafone.githuprepoviewer.presentation.feature.main

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.domain.entities.ReposEntity
import tech.vodafone.githuprepoviewer.presentation.utils.NavigationController

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchField(modifier: Modifier = Modifier,onClickSearch:(String)->Unit) {
    var result by remember{ mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current


    TextField(
        modifier = modifier.border(width = 1.dp, color = Color(0xFF8D8D94), shape = RoundedCornerShape(size = 8.dp)),
        value = result,
        onValueChange = {
            result = it
        },
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                text = "Search",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color =Color.Gray,
                )
            )
        },

        trailingIcon = {
            if (result.isNotBlank()){
                Icon(imageVector = Icons.Default.Close, contentDescription = null, tint = Color.Black, modifier = Modifier.clickable {
                    result = ""
                })

            }else{
                Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color.Black)

            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
            onClickSearch(result)
        })

    )
}

@Composable
fun ReposScreen(
    navController: NavigationController,
    modifier: Modifier = Modifier,
    viewModel: ReposViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()

//    val searchState = viewModel.pagingData.collectAsLazyPagingItems()


//    LaunchedEffect(true){
//        viewModel.onEvent(ReposEvents.GetRepos)
//    }

    Column {

        Spacer(modifier = Modifier.height(32.dp))

        var querySearch by remember { mutableStateOf("") }

        SearchField(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)){
            querySearch = it
            coroutineScope.launch {
                viewModel.onEvent(ReposEvents.RequestSearch(querySearch))
            }
        }

        if (querySearch.isNotBlank()){
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Results for “${querySearch}”",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                ),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }


//        LazyColumn(modifier = modifier.fillMaxSize(),) {
////            uiState.repos?.let {
//                items(
//                    count = searchState.itemCount,
//                    key = searchState.itemKey{ item -> item.id},
//                    contentType = searchState.itemContentType { "Repos" }
//                ) { index ->
//                    val repo = searchState[index]
//                    repo?.let {
//                        val data = it.toUIModel()
//                        CategoryItem(data){
//                            navController.onEvent(
//                                NavigationEvent.GoToRepositoryDetailsScreen(
//                                    repo = data.name ?: "",
//                                    owner = data.owner ?: ""
//                                )
//                            )
//                        }
////                    }
//                }
//
//            }
//        }
//        screenState.AnimateScreenState(
//            onStable = {
//
//            },
//        )
    }


}




@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CategoryItemPreview() {
    val category = ReposEntity.ReposModel(
        name = "Reuters",
        owner = "Ahmed",
        description = "dsfdsfgsdgfdgfdg",
        starCount = null
    )
    CategoryItem(category){

    }
}


@Composable
fun CategoryItem(model: ReposEntity.ReposModel, onClick:()->Unit) {
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier
        .padding(top = 24.dp)
        .padding(horizontal = 20.dp).clickable { onClick() }
    ) {
        model.name?.let {
            Text(
                text = it,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(800),
                    color = Color(0xFF096FFA),
                    )
            )
        }


        Spacer(modifier = Modifier.height(8.dp))

        model.owner?.let {
            Text(
                text = it,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                softWrap = true,
                modifier = Modifier.fillMaxWidth(0.7f)
            )
        }
//        Row {
//            Spacer(modifier = Modifier.width(8.dp))
//            ImageLoader(modifier = Modifier.fillMaxWidth(), url = model.image){
//            }
//        }
        Spacer(modifier = Modifier.height(20.dp))

        model.description?.let {
            Text(
                text = it,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }



    }
}
