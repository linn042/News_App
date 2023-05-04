package network

data class NewsResponse(
    var status: String,
    var totalResults: Int,
    var articles: List<ArticleResponse>
)

data class ArticleResponse(
    var source: SourceResponse,
    var author: String?,
    var title: String,
    var description: String?,
    var url: String,
    var urlToImage: String?,
    var publishedAt: String,
    var content: String?
)

data class SourceResponse(
    var id: String?,
    var name: String
)
