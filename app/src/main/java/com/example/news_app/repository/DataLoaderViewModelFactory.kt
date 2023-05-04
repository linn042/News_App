import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news_app.repository.NewsRepo
import com.example.news_app.repository.DataLoaderViewModel

class DataLoaderViewModelFactory(private val newsRepo: NewsRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DataLoaderViewModel::class.java)) {
            return DataLoaderViewModel(newsRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
