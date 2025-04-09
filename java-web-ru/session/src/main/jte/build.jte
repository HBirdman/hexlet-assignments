@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
    content = @`
        @if(!page.getError().isEmpty())
            <div>
                <h1>${page.getError()}</h1>
            </div>
        @endif
        <div>
            <form action="${NamedRoutes.loginPath()}" method="post">
                <input type="text" placeholder="Name" name="name" />
                <input type="password" placeholder="Password" name="password" />
                <input type="submit" />
            </form>
        </div>
`
)