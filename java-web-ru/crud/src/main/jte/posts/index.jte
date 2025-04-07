@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Список постов</h1>
            @if(page.getPosts().isEmpty())
                <p>Пока постов нет</p>
            @else
                <table class="table table-striped">
                @for(var post : page.getPosts())
                    <h1 href="${NamedRoutes.showPath(String.valueOf(post.getId()))}">${post.getName()}</h1>
                    <a>${post.getBody()}</a>
                @endfor
            </table>
            @endif
            <div>
                <h1>Текущая страница</h1>
                <h1>${page.getPageNumber()}</h1>
            </div>
            @if(page.getPageNumber() > 1)
                <div>
                    <h1 href="${NamedRoutes.postsPath()}?page=${page.getPageNumber() - 1}">Предыдущая страница</h1>
                    <h1>${page.getPageNumber() - 1}</h1>
                </div>
            @endif
            <div>
                <h2 href="${NamedRoutes.postsPath()}?page=${page.getPageNumber() + 1}">Следующая страница</h2>
                <h2>${page.getPageNumber() + 1}</h2>
            </div>
        </main>
    </div>
`
)
